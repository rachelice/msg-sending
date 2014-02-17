/*     */ package com.sunshineroad.framework.codegenerate.database;
/*     */ 
/*     */ import java.io.PrintStream;
/*     */ import java.sql.Connection;
/*     */ import java.sql.DriverManager;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
/*     */ import java.sql.Statement;
/*     */ import java.text.MessageFormat;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.apache.commons.lang.StringUtils;
/*     */ import org.apache.commons.logging.Log;
/*     */ import org.apache.commons.logging.LogFactory;

import com.sunshineroad.framework.codegenerate.pojo.Columnt;
import com.sunshineroad.framework.codegenerate.pojo.TableConvert;
import com.sunshineroad.framework.codegenerate.util.CodeResourceUtil;
/*     */ 
/*     */ public class SitReadTable
/*     */ {
/*  26 */   private static final Log log = LogFactory.getLog(SitReadTable.class);
/*     */   private static final long serialVersionUID = -5324160085184088010L;
/*     */   private Connection conn;
/*     */   private Statement stmt;
/*     */   private String sql;
/*     */   private ResultSet rs;
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/*     */     try
/*     */     {
/*  38 */       List<Columnt> cls = new SitReadTable().readTableColumn("person");
/*  39 */       for (Columnt c : cls)
/*  40 */         System.out.println(c.getFieldName());
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  44 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   public List<Columnt> readTableColumn(String tableName)
/*     */     throws Exception
/*     */   {
/*  57 */     List<Columnt> columntList = new ArrayList<Columnt>();
/*     */     try {
/*  59 */       Class.forName(CodeResourceUtil.DIVER_NAME);
/*  60 */       this.conn = DriverManager.getConnection(CodeResourceUtil.URL, CodeResourceUtil.USERNAME, CodeResourceUtil.PASSWORD);
/*  61 */       this.stmt = this.conn
/*  62 */         .createStatement(1005, 
/*  62 */         1007);
/*     */ 
/*  66 */       if (CodeResourceUtil.DATABASE_TYPE.equals("mysql")) {
/*  67 */         this.sql = MessageFormat.format("select column_name,data_type,column_comment,numeric_precision,numeric_scale,character_maximum_length,is_nullable nullable from information_schema.columns where table_name = {0} and table_schema = {1}", new Object[] { TableConvert.getV(tableName.toUpperCase()), TableConvert.getV(CodeResourceUtil.DATABASE_NAME) });
/*     */       }
/*     */ 
/*  70 */       if (CodeResourceUtil.DATABASE_TYPE.equals("oracle")) {
/*  71 */         this.sql = MessageFormat.format(" select colstable.column_name column_name, colstable.data_type data_type, commentstable.comments column_comment, colstable.Data_Precision column_precision, colstable.Data_Scale column_scale,colstable.Char_Length,colstable.nullable from user_tab_cols colstable  inner join user_col_comments commentstable  on colstable.column_name = commentstable.column_name  where colstable.table_name = commentstable.table_name  and colstable.table_name = {0}", new Object[] { TableConvert.getV(tableName.toUpperCase()) });
/*     */       }
/*     */ 
/*  74 */       if (CodeResourceUtil.DATABASE_TYPE.equals("postgresql")) {
/*  75 */         this.sql = MessageFormat.format("SELECT a.attname AS  field,t.typname AS type,col_description(a.attrelid,a.attnum) as comment,null as column_precision,null as column_scale,null as Char_Length,a.attnotnull  FROM pg_class c,pg_attribute  a,pg_type t  WHERE c.relname = {0} and a.attnum > 0  and a.attrelid = c.oid and a.atttypid = t.oid  ORDER BY a.attnum ", new Object[] { TableConvert.getV(tableName.toLowerCase()) });
/*     */       }
/*     */ 
/*  79 */       this.rs = this.stmt.executeQuery(this.sql);
/*  80 */       this.rs.last();
/*  81 */       int fieldNum = this.rs.getRow();
/*  82 */       int n = fieldNum;
/*     */ 
/*  84 */       if (n > 0) {
/*  85 */         Columnt columnt = new Columnt();
/*     */ 
/*  87 */         if (CodeResourceUtil.SIT_FILED_CONVERT)
/*  88 */           columnt.setFieldName(formatField(this.rs.getString(1).toLowerCase()));
/*     */         else {
/*  90 */           columnt.setFieldName(this.rs.getString(1).toLowerCase());
/*     */         }
/*     */ 
/*  94 */         columnt.setFieldDbName(this.rs.getString(1).toUpperCase());
/*  95 */         columnt.setFieldType(formatField(this.rs.getString(2).toLowerCase()));
/*     */ 
/*  97 */         columnt.setPrecision(this.rs.getString(4));
/*  98 */         columnt.setScale(this.rs.getString(5));
/*  99 */         columnt.setCharmaxLength(this.rs.getString(6));
/* 100 */         columnt.setNullable(TableConvert.getNullAble(this.rs.getString(7)));
/*     */ 
/* 102 */         formatFieldClassType(columnt);
/* 103 */         columnt.setFiledComment((StringUtils.isBlank(this.rs.getString(3))) ? columnt.getFieldName() : this.rs.getString(3));
/*     */ 
/* 107 */         if ((!CodeResourceUtil.SIT_GENERATE_TABLE_ID.equals(columnt.getFieldName())) && 
/* 108 */           (!"createDt".equals(columnt.getFieldName())) && 
/* 109 */           (!"modifyDt".equals(columnt.getFieldName())) && 
/* 110 */           (!"delflag".equals(columnt.getFieldName())) && 
/* 111 */           (!"crtuser".equals(columnt.getFieldName())) && 
/* 112 */           (!"crtuserName".equals(columnt.getFieldName())) && 
/* 113 */           (!"modifierName".equals(columnt.getFieldName())) && 
/* 114 */           (!"optip".equals(columnt.getFieldName())) && 
/* 115 */           (!"modifier".equals(columnt.getFieldName())) && 
/* 116 */           (!"delDt".equals(columnt.getFieldName())) && 
/* 117 */           (!"modifyip".equals(columnt.getFieldName())))
/*     */         {
/* 120 */           columntList.add(columnt);
/*     */         }
/* 122 */         while (this.rs.previous()) {
/* 123 */           Columnt po = new Columnt();
/*     */ 
/* 125 */           if (CodeResourceUtil.SIT_FILED_CONVERT)
/* 126 */             po.setFieldName(formatField(this.rs.getString(1).toLowerCase()));
/*     */           else {
/* 128 */             po.setFieldName(this.rs.getString(1).toLowerCase());
/*     */           }
/*     */ 
/* 132 */           po.setFieldDbName(this.rs.getString(1).toUpperCase());
/*     */ 
/* 134 */           if ((CodeResourceUtil.SIT_GENERATE_TABLE_ID.equals(po.getFieldName())) || 
/* 135 */             ("createDt".equals(po.getFieldName())) || 
/* 136 */             ("modifyDt".equals(po.getFieldName())) || 
/* 137 */             ("delflag".equals(po.getFieldName())) || 
/* 138 */             ("crtuser".equals(po.getFieldName())) || 
/* 139 */             ("crtuserName".equals(po.getFieldName())) || 
/* 140 */             ("modifierName".equals(po.getFieldName())) || 
/* 141 */             ("optip".equals(po.getFieldName())) || 
/* 142 */             ("modifier".equals(po.getFieldName())) || 
/* 143 */             ("delDt".equals(po.getFieldName()))) continue;
/* 144 */           if ("modifyip".equals(po.getFieldName())) {
/*     */             continue;
/*     */           }
/* 147 */           po.setFieldType(formatField(this.rs.getString(2).toLowerCase()));
/*     */ 
/* 150 */           po.setPrecision(this.rs.getString(4));
/* 151 */           po.setScale(this.rs.getString(5));
/* 152 */           po.setCharmaxLength(this.rs.getString(6));
/* 153 */           po.setNullable(TableConvert.getNullAble(this.rs.getString(7)));
/*     */ 
/* 155 */           formatFieldClassType(po);
/* 156 */           po.setFiledComment((StringUtils.isBlank(this.rs.getString(3))) ? po.getFieldName() : this.rs.getString(3));
/* 157 */           columntList.add(po);
/*     */         }
/*     */       } else {
/* 160 */         throw new Exception("该表不存在或者表中没有字段");
/*     */       }
/*     */     }
/*     */     catch (ClassNotFoundException e)
/*     */     {
/* 165 */       throw e;
/*     */     } catch (SQLException e) {
/* 167 */       throw e;
/*     */     } finally {
/*     */       try {
/* 170 */         if (this.stmt != null) {
/* 171 */           this.stmt.close();
/* 172 */           this.stmt = null;
/* 173 */           System.gc();
/*     */         }
/* 175 */         if (this.conn != null) {
/* 176 */           this.conn.close();
/* 177 */           this.conn = null;
/* 178 */           System.gc();
/*     */         }
/*     */       } catch (SQLException e) {
/* 181 */         throw e;
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 187 */     List<Columnt> rsList = new ArrayList<Columnt>();
/* 188 */     for (int i = columntList.size() - 1; i >= 0; --i) {
/* 189 */       Columnt ch = (Columnt)columntList.get(i);
/* 190 */       rsList.add(ch);
/*     */     }
/* 192 */     return rsList;
/*     */   }
/*     */ 
/*     */   public List<Columnt> readOriginalTableColumn(String tableName)
/*     */     throws Exception
/*     */   {
/* 203 */     List<Columnt> columntList = new ArrayList<Columnt>();
/*     */     try {
/* 205 */       Class.forName(CodeResourceUtil.DIVER_NAME);
/* 206 */       this.conn = DriverManager.getConnection(CodeResourceUtil.URL, CodeResourceUtil.USERNAME, CodeResourceUtil.PASSWORD);
/* 207 */       this.stmt = this.conn
/* 208 */         .createStatement(1005, 
/* 208 */         1007);
/*     */ 
/* 212 */       if (CodeResourceUtil.DATABASE_TYPE.equals("mysql")) {
/* 213 */         this.sql = MessageFormat.format("select column_name,data_type,column_comment,numeric_precision,numeric_scale,character_maximum_length,is_nullable nullable from information_schema.columns where table_name = {0} and table_schema = {1}", new Object[] { TableConvert.getV(tableName.toUpperCase()), TableConvert.getV(CodeResourceUtil.DATABASE_NAME) });
/*     */       }
/*     */ 
/* 216 */       if (CodeResourceUtil.DATABASE_TYPE.equals("oracle")) {
/* 217 */         this.sql = MessageFormat.format(" select colstable.column_name column_name, colstable.data_type data_type, commentstable.comments column_comment, colstable.Data_Precision column_precision, colstable.Data_Scale column_scale,colstable.Char_Length,colstable.nullable from user_tab_cols colstable  inner join user_col_comments commentstable  on colstable.column_name = commentstable.column_name  where colstable.table_name = commentstable.table_name  and colstable.table_name = {0}", new Object[] { TableConvert.getV(tableName.toUpperCase()) });
/*     */       }
/*     */ 
/* 220 */       if (CodeResourceUtil.DATABASE_TYPE.equals("postgresql")) {
/* 221 */         this.sql = MessageFormat.format("SELECT a.attname AS  field,t.typname AS type,col_description(a.attrelid,a.attnum) as comment,null as column_precision,null as column_scale,null as Char_Length,a.attnotnull  FROM pg_class c,pg_attribute  a,pg_type t  WHERE c.relname = {0} and a.attnum > 0  and a.attrelid = c.oid and a.atttypid = t.oid  ORDER BY a.attnum ", new Object[] { TableConvert.getV(tableName.toLowerCase()) });
/*     */       }
/*     */ 
/* 224 */       this.rs = this.stmt.executeQuery(this.sql);
/* 225 */       this.rs.last();
/* 226 */       int fieldNum = this.rs.getRow();
/* 227 */       int n = fieldNum;
/*     */ 
/* 229 */       if (n > 0) {
/* 230 */         Columnt columnt = new Columnt();
/*     */ 
/* 232 */         if (CodeResourceUtil.SIT_FILED_CONVERT)
/* 233 */           columnt.setFieldName(formatField(this.rs.getString(1).toLowerCase()));
/*     */         else {
/* 235 */           columnt.setFieldName(this.rs.getString(1).toLowerCase());
/*     */         }
/*     */ 
/* 239 */         columnt.setFieldDbName(this.rs.getString(1).toUpperCase());
/*     */ 
/* 241 */         columnt.setPrecision(TableConvert.getNullString(this.rs.getString(4)));
/* 242 */         columnt.setScale(TableConvert.getNullString(this.rs.getString(5)));
/* 243 */         columnt.setCharmaxLength(TableConvert.getNullString(this.rs.getString(6)));
/* 244 */         columnt.setNullable(TableConvert.getNullAble(this.rs.getString(7)));
/*     */ 
/* 246 */         columnt.setFieldType(formatDataType(this.rs.getString(2).toLowerCase(), columnt.getPrecision(), columnt.getScale()));
/*     */ 
/* 248 */         formatFieldClassType(columnt);
/* 249 */         columnt.setFiledComment((StringUtils.isBlank(this.rs.getString(3))) ? columnt.getFieldName() : this.rs.getString(3));
/*     */ 
/* 253 */         columntList.add(columnt);
/* 254 */         while (this.rs.previous()) {
/* 255 */           Columnt po = new Columnt();
 
/* 257 */           if (CodeResourceUtil.SIT_FILED_CONVERT)
/* 258 */             po.setFieldName(formatField(this.rs.getString(1).toLowerCase()));
						else {
/* 260 */             po.setFieldName(this.rs.getString(1).toLowerCase());
/*     */           }
/*     */ 
/* 264 */           po.setFieldDbName(this.rs.getString(1).toUpperCase());
/*     */ 
/* 266 */           po.setPrecision(TableConvert.getNullString(this.rs.getString(4)));
/* 267 */           po.setScale(TableConvert.getNullString(this.rs.getString(5)));
/* 268 */           po.setCharmaxLength(TableConvert.getNullString(this.rs.getString(6)));
/* 269 */           po.setNullable(TableConvert.getNullAble(this.rs.getString(7)));
/*     */ 
/* 271 */           po.setFieldType(formatDataType(this.rs.getString(2).toLowerCase(), po.getPrecision(), po.getScale()));
/*     */ 
/* 273 */           formatFieldClassType(po);
/* 274 */           po.setFiledComment((StringUtils.isBlank(this.rs.getString(3))) ? po.getFieldName() : this.rs.getString(3));
/* 275 */           columntList.add(po);
/*     */         }
/*     */       } else {
/* 278 */         throw new Exception("该表不存在或者表中没有字段");
/*     */       }
/*     */     }
/*     */     catch (ClassNotFoundException e)
/*     */     {
/* 283 */       throw e;
/*     */     } catch (SQLException e) {
/* 285 */       throw e;
/*     */     } finally {
/*     */       try {
/* 288 */         if (this.stmt != null) {
/* 289 */           this.stmt.close();
/* 290 */           this.stmt = null;
/* 291 */           System.gc();
/*     */         }
/* 293 */         if (this.conn != null) {
/* 294 */           this.conn.close();
/* 295 */           this.conn = null;
/* 296 */           System.gc();
/*     */         }
/*     */       } catch (SQLException e) {
/* 299 */         throw e;
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/* 305 */     List<Columnt> rsList = new ArrayList<Columnt>();
/* 306 */     for (int i = columntList.size() - 1; i >= 0; --i) {
/* 307 */       Columnt ch = (Columnt)columntList.get(i);
/* 308 */       rsList.add(ch);
/*     */     }
/* 310 */     return rsList;
/*     */   }
/*     */ 
/*     */   public static String formatField(String field)
/*     */   {
/* 320 */     String[] strs = field.split("_");
/* 321 */     field = "";
/* 322 */     int m = 0; for (int length = strs.length; m < length; ++m) {
/* 323 */       if (m > 0) {
/* 324 */         String tempStr = strs[m].toLowerCase();
/* 325 */         tempStr = tempStr.substring(0, 1).toUpperCase() + 
/* 326 */           tempStr.substring(1, tempStr.length());
/* 327 */         field = field + tempStr;
/*     */       } else {
/* 329 */         field = field + strs[m].toLowerCase();
/*     */       }
/*     */     }
/* 332 */     return field;
/*     */   }
/*     */ 
/*     */   public static String formatFieldCapital(String field)
/*     */   {
/* 342 */     String[] strs = field.split("_");
/* 343 */     field = "";
/* 344 */     int m = 0; for (int length = strs.length; m < length; ++m) {
/* 345 */       if (m > 0) {
/* 346 */         String tempStr = strs[m].toLowerCase();
/* 347 */         tempStr = tempStr.substring(0, 1).toUpperCase() + 
/* 348 */           tempStr.substring(1, tempStr.length());
/* 349 */         field = field + tempStr;
/*     */       } else {
/* 351 */         field = field + strs[m].toLowerCase();
/*     */       }
/*     */     }
/* 354 */     field = field.substring(0, 1).toUpperCase() + field.substring(1);
/* 355 */     return field;
/*     */   }
/*     */ 
/*     */   public boolean checkTableExist(String tableName)
/*     */   {
/*     */     try
/*     */     {
/* 365 */       System.out.println("数据库驱动: " + CodeResourceUtil.DIVER_NAME);
/* 366 */       Class.forName(CodeResourceUtil.DIVER_NAME);
/* 367 */       this.conn = DriverManager.getConnection(CodeResourceUtil.URL, CodeResourceUtil.USERNAME, CodeResourceUtil.PASSWORD);
/* 368 */       this.stmt = this.conn
/* 369 */         .createStatement(1005, 
/* 369 */         1007);
/*     */ 
/* 373 */       if (CodeResourceUtil.DATABASE_TYPE.equals("mysql")) {
/* 374 */         this.sql = 
/* 376 */           ("select column_name,data_type,column_comment,0,0 from information_schema.columns where table_name = '" + 
/* 375 */           tableName.toUpperCase() + "'" + 
/* 376 */           " and table_schema = '" + CodeResourceUtil.DATABASE_NAME + "'");
/*     */       }
/*     */ 
/* 379 */       if (CodeResourceUtil.DATABASE_TYPE.equals("oracle")) {
/* 380 */         this.sql = 
/* 387 */           ("select colstable.column_name column_name, colstable.data_type data_type, commentstable.comments column_comment from user_tab_cols colstable   left join user_col_comments commentstable  on colstable.column_name = commentstable.column_name  where colstable.table_name = commentstable.table_name  and colstable.table_name = '" + 
/* 386 */           tableName.toUpperCase() + 
/* 387 */           "'");
/*     */       }  
/*     */ 
/* 390 */       if (CodeResourceUtil.DATABASE_TYPE.equals("postgresql")) {
/* 391 */         this.sql = MessageFormat.format("SELECT a.attname AS  field,t.typname AS type,col_description(a.attrelid,a.attnum) as comment,null as column_precision,null as column_scale,null as Char_Length,a.attnotnull  FROM pg_class c,pg_attribute  a,pg_type t  WHERE c.relname = {0} and a.attnum > 0  and a.attrelid = c.oid and a.atttypid = t.oid  ORDER BY a.attnum ", new Object[] { TableConvert.getV(tableName.toLowerCase()) });
/*     */       }
/*     */ 
/* 395 */       this.rs = this.stmt.executeQuery(this.sql);
/* 396 */       this.rs.last();
/* 397 */       int fieldNum = this.rs.getRow();
/* 398 */       if (fieldNum > 0)
/* 399 */         return true;
/*     */     }
/*     */     catch (Exception e) {
/* 402 */       e.printStackTrace();
/* 403 */       return false;
/*     */     }
/* 405 */     return false;
/*     */   }
/*     */ 
/*     */   private void formatFieldClassType(Columnt columnt)
/*     */   {
/* 413 */     String fieldType = columnt.getFieldType();
/* 414 */     String scale = columnt.getScale();
/*     */ 
/* 416 */     columnt.setClassType("inputxt");
/*     */ 
/* 418 */     if ("N".equals(columnt.getNullable())) {
/* 419 */       columnt.setOptionType("*");
/*     */     }
/* 421 */     if (("datetime".equals(fieldType)) || (fieldType.contains("time")))
/* 422 */       columnt.setClassType("easyui-datetimebox");
/* 423 */     else if ("date".equals(fieldType))
/* 424 */       columnt.setClassType("easyui-datebox");
/* 425 */     else if (fieldType.contains("int"))
/* 426 */       columnt.setOptionType("n");
/* 427 */     else if ("number".equals(fieldType)) {
/* 428 */       if ((StringUtils.isNotBlank(scale)) && (Integer.parseInt(scale) > 0))
/* 429 */         columnt.setOptionType("d");
/*     */     }
/* 431 */     else if (("float".equals(fieldType)) || ("double".equals(fieldType)) || ("decimal".equals(fieldType)))
/* 432 */       columnt.setOptionType("d");
/* 433 */     else if ("numeric".equals(fieldType))
/* 434 */       columnt.setOptionType("d");
/*     */   }
/*     */ 
/*     */   private String formatDataType(String dataType, String precision, String scale)
/*     */   {
/* 442 */     if (dataType.contains("char"))
/* 443 */       dataType = "java.lang.String";
/* 444 */     else if (dataType.contains("int"))
/* 445 */       dataType = "java.lang.Integer";
/* 446 */     else if (dataType.contains("float"))
/* 447 */       dataType = "java.lang.Float";
/* 448 */     else if (dataType.contains("double"))
/* 449 */       dataType = "java.lang.Double";
/* 450 */     else if (dataType.contains("number")) {
/* 451 */       if ((StringUtils.isNotBlank(scale)) && (Integer.parseInt(scale) > 0))
/* 452 */         dataType = "java.math.BigDecimal";
/* 453 */       else if ((StringUtils.isNotBlank(precision)) && (Integer.parseInt(precision) > 10))
/* 454 */         dataType = "java.lang.Long";
/*     */       else
/* 456 */         dataType = "java.lang.Integer";
/*     */     }
/* 458 */     else if (dataType.contains("decimal"))
/* 459 */       dataType = "BigDecimal";
/* 460 */     else if (dataType.contains("date"))
/* 461 */       dataType = "java.util.Date";
/* 462 */     else if (dataType.contains("time"))
/*     */     {
/* 464 */       dataType = "java.util.Date";
/* 465 */     } else if (dataType.contains("clob"))
/* 466 */       dataType = "java.sql.Clob";
/* 467 */     else if (dataType.contains("numeric"))
/* 468 */       dataType = "BigDecimal";
/*     */     else {
/* 470 */       dataType = "java.lang.Object";
/*     */     }
/* 472 */     return dataType;
/*     */   }
/*     */ }

 