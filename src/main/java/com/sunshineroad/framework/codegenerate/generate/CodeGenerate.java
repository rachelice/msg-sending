/*     */ package com.sunshineroad.framework.codegenerate.generate;
/*     */ 
/*     */ import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.sunshineroad.framework.codegenerate.database.SitReadTable;
import com.sunshineroad.framework.codegenerate.pojo.Columnt;
import com.sunshineroad.framework.codegenerate.pojo.CreateFileProperty;
import com.sunshineroad.framework.codegenerate.util.CodeDateUtils;
import com.sunshineroad.framework.codegenerate.util.CodeResourceUtil;
import com.sunshineroad.framework.codegenerate.util.NonceUtils;
import com.sunshineroad.framework.codegenerate.util.def.FtlDef;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CodeGenerate
/*     */   implements ICallBack
/*     */ {
/*  25 */   private static final Log log = LogFactory.getLog(CodeGenerate.class);
/*     */ 
/*  27 */   private static String entityPackage = "test";
/*  28 */   private static String entityName = "SitNote";
/*  29 */   private static String tableName = "jg_person";
/*  30 */   private static String ftlDescription = "gg";
/*  31 */   private static String primaryKeyPolicy = "identity";
/*  32 */   private static String sequenceCode = "";
/*     */ 
/*  39 */   private List<Columnt> originalColumns = new ArrayList();
/*  40 */   public static int FIELD_ROW_NUM = 1;
/*  41 */   private static CreateFileProperty createFileProperty = new CreateFileProperty();
/*     */ 
/*  82 */   private List<Columnt> columns = new ArrayList();
/*  83 */   private SitReadTable dbFiledUtil = new SitReadTable();
/*     */ 
/*     */   static
/*     */   {
/*  43 */     createFileProperty.setActionFlag(true);
/*  44 */     createFileProperty.setServiceFlag(true);
/*  45 */     createFileProperty.setJspFlag(true);
/*  46 */     createFileProperty.setServiceImplFlag(true);
/*  47 */     createFileProperty.setJspMode("01");
/*  48 */     createFileProperty.setPageFlag(true);
/*  49 */     createFileProperty.setEntityFlag(true);
/*     */   }
/*     */ 
/*     */   public CodeGenerate()
/*     */   {
/*     */   }
/*     */ 
/*     */   public CodeGenerate(String entityPackage, String entityName, String tableName, String ftlDescription, CreateFileProperty createFileProperty, int fieldRowNum, String primaryKeyPolicy, String sequenceCode)
/*     */   {
/*  59 */     CodeGenerate.entityName = entityName;
/*  60 */       CodeGenerate.entityPackage = entityPackage;
/*  61 */       CodeGenerate.tableName = tableName;
/*  62 */      CodeGenerate. ftlDescription = ftlDescription;
/*  63 */       CodeGenerate.createFileProperty = createFileProperty;
/*  64 */      CodeGenerate.FIELD_ROW_NUM = fieldRowNum;
/*  65 */       CodeGenerate.primaryKeyPolicy = primaryKeyPolicy;
/*  66 */       CodeGenerate.sequenceCode = sequenceCode;
/*     */   }
/*     */ 
/*     */   public CodeGenerate(String entityPackage, String entityName, String tableName, String ftlDescription, CreateFileProperty createFileProperty, String primaryKeyPolicy, String sequenceCode)
/*     */   {
/*  71 */       CodeGenerate.entityName = entityName;
/*  72 */       CodeGenerate.entityPackage = entityPackage;
/*  73 */       CodeGenerate.tableName = tableName;
/*  74 */       CodeGenerate.ftlDescription = ftlDescription;
/*  75 */      CodeGenerate.createFileProperty = createFileProperty;
/*  76 */      CodeGenerate. primaryKeyPolicy = primaryKeyPolicy;
/*  77 */       CodeGenerate.sequenceCode = sequenceCode;
/*     */   }
/*     */ 
/*     */   @Override
public Map<String, Object> execute()
/*     */   {
/*  89 */     Map data = new HashMap();
/*     */ 
/*  92 */     data.put("bussiPackage", CodeResourceUtil.bussiPackage);
/*     */ 
/*  94 */     data.put("entityPackage", entityPackage);
/*     */ 
/*  96 */     data.put("entityName", entityName);
/*     */ 
/*  98 */     data.put("tableName", tableName);
/*     */ 
/* 100 */     data.put("ftl_description", ftlDescription);
/*     */ 
/* 102 */     data.put(FtlDef.SIT_TABLE_ID, CodeResourceUtil.SIT_GENERATE_TABLE_ID);
/*     */ 
/* 104 */     data.put(FtlDef.SIT_PRIMARY_KEY_POLICY, primaryKeyPolicy);
/* 105 */     data.put(FtlDef.SIT_SEQUENCE_CODE, sequenceCode);
/*     */ 
/* 107 */     data.put("ftl_create_time", CodeDateUtils.dateToString(new Date()));
/*     */ 
/* 111 */     data.put(FtlDef.FIELD_REQUIRED_NAME, Integer.valueOf((StringUtils.isNotEmpty(CodeResourceUtil.SIT_UI_FIELD_REQUIRED_NUM)) ? Integer.parseInt(CodeResourceUtil.SIT_UI_FIELD_REQUIRED_NUM) : -1));
/*     */ 
/* 113 */     data.put(FtlDef.SEARCH_FIELD_NUM, Integer.valueOf((StringUtils.isNotEmpty(CodeResourceUtil.SIT_UI_FIELD_SEARCH_NUM)) ? Integer.parseInt(CodeResourceUtil.SIT_UI_FIELD_SEARCH_NUM) : -1));
/*     */ 
/* 115 */     data.put(FtlDef.FIELD_ROW_NAME, Integer.valueOf(FIELD_ROW_NUM));
/*     */     try
/*     */     {
/* 119 */       this.columns = this.dbFiledUtil.readTableColumn(tableName);
/* 120 */       data.put("columns", this.columns);
/*     */ 
/* 123 */       this.originalColumns = this.dbFiledUtil.readOriginalTableColumn(tableName);
/* 124 */       data.put("originalColumns", this.originalColumns);
/*     */ 
/* 127 */       for (Columnt c : this.originalColumns) {
/* 128 */         if (c.getFieldName().toLowerCase().equals(CodeResourceUtil.SIT_GENERATE_TABLE_ID.toLowerCase()))
/* 129 */           data.put("primary_key_type", c.getFieldType());
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 134 */       e.printStackTrace();
/* 135 */       System.exit(-1);
/*     */     }
/* 137 */     long serialVersionUID = NonceUtils.randomLong() + 
/* 138 */       NonceUtils.currentMills();
/* 139 */     data.put("serialVersionUID", String.valueOf(serialVersionUID));
/* 140 */     return data;
/*     */   }
/*     */ 
/*     */   public void generateToFile() throws SQLException {
/* 144 */     log.info("----jeecg---Code----Generation----[单表模型:" + tableName + "]------- 生成中。。。");
/*     */ 
/* 146 */     CodeFactory codeFactory = new CodeFactory();
/* 147 */     codeFactory.setCallBack(new CodeGenerate());
/*     */ 
 
/* 158 */     if (createFileProperty.isServiceImplFlag()) {
/* 159 */       codeFactory.invoke("serviceImpl.ftl", "serviceImpl");
/*     */     }
/* 161 */     if (createFileProperty.isServiceFlag()) {
/* 162 */       codeFactory.invoke("service.ftl", "service");
/*     */     }
/* 164 */     if (createFileProperty.isActionFlag()) {
/* 165 */       codeFactory.invoke("controller.ftl", "controller");
/*     */     }
/* 167 */     if (createFileProperty.isEntityFlag())
/*     */     {
/* 169 */       codeFactory.invoke("entity.ftl", "entity");
/* 169 */       codeFactory.invoke("entityH.ftl", "entityH");
/* 169 */       codeFactory.invoke("entityM.ftl", "entityM");
/* 169 */       codeFactory.invoke("entityVo.ftl", "entityVo");

				codeFactory.invoke("dao.ftl", "dao");
/* 159 */       codeFactory.invoke("daoImpl.ftl", "daoImpl");

/* 169 */       codeFactory.invoke("listJs.ftl", "list");
/* 169 */       codeFactory.invoke("modelJs.ftl", "model");
/* 169 */       codeFactory.invoke("store.ftl", "store");

/* 169 */       codeFactory.invoke("windowJs.ftl", "window");
/* 169 */       codeFactory.invoke("formJs.ftl", "form"); 

/*     */     }

ApplicationContext context = new ClassPathXmlApplicationContext("resources\\spring\\spring-dao1.xml");

DataSource ds =(DataSource) context.getBean("dataSource5");  
JdbcTemplate jdbcTemplate =(JdbcTemplate) context.getBean("jdbcTemplate1");
     
//jdbcTemplate.equals("delete sys_resource where component= Fes.view"+entityName+"List"); 
jdbcTemplate.equals("delete MSP_resource where url like '%"+entityName+"%'"); 

String upperEntityName = entityName.substring(0,1).toLowerCase()+entityName.substring(1); //实体名首字母小写

int fatherIDInt = jdbcTemplate.queryForInt("SELECT MSP_RESOURCE_SEQ.NEXTVAL FROM DUAL")+1; //通过序列确定父节点ID
String fatherID = String.valueOf(fatherIDInt);

jdbcTemplate.execute("INSERT INTO \"MSP\".\"MSP_RESOURCE\" (component,descripton,text,type,parent_id,URL) VALUES ( 'Fes.view."+entityName+"List','"+ftlDescription+"资源','"+ftlDescription+"资源','COMPONENT',"+2 + ",'" +upperEntityName+"s')");
jdbcTemplate.execute("INSERT INTO \"MSP\".\"MSP_RESOURCE\" (component,descripton,text,type,parent_id,URL) VALUES ( NULL, '"+ftlDescription+"列表','"+ftlDescription+"资源','COMPONENT',"+fatherID+",'"+upperEntityName+"/list')");
jdbcTemplate.execute("INSERT INTO \"MSP\".\"MSP_RESOURCE\" (component,descripton,text,type,parent_id,URL) VALUES ( NULL, '"+ftlDescription+"新增','"+ftlDescription+"新增','COMPONENT',"+fatherID+",'"+upperEntityName+"/create')");
jdbcTemplate.execute("INSERT INTO \"MSP\".\"MSP_RESOURCE\" (component,descripton,text,type,parent_id,URL) VALUES ( NULL, '"+ftlDescription+"修改','"+ftlDescription+"修改','COMPONENT',"+fatherID+",'"+upperEntityName+"/update')");
jdbcTemplate.execute("INSERT INTO \"MSP\".\"MSP_RESOURCE\" (component,descripton,text,type,parent_id,URL) VALUES ( NULL, '"+ftlDescription+"删除','"+ftlDescription+"删除','COMPONENT',"+fatherID+",'"+upperEntityName+"/delete')");
    

ds.getConnection().close();

/* 171 */     log.info("----jeecg----Code----Generation-----[单表模型：" + tableName + "]------ 生成完成。。。");
/*     */   }
/*     */ 
/*     */   public static void main(String[] args) throws SQLException
/*     */   {
/* 178 */     System.out.println("----jeecg--------- Code------------- Generation -----[单表模型]------- 生成中。。。");
/* 179 */     new CodeGenerate().generateToFile();
/* 180 */     System.out.println("----jeecg--------- Code------------- Generation -----[单表模型]------- 生成完成。。。");
/*     */   }
/*     */ }

 