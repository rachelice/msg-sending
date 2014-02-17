/*    */ package com.sunshineroad.framework.codegenerate.util;
/*    */ 
/*    */ import org.apache.commons.lang.StringUtils;
/*    */ 
/*    */ public class CodeStringUtils
/*    */ {
/*    */   public static String getStringSplit(String[] val)
/*    */   {
/* 13 */     StringBuffer sqlStr = new StringBuffer();
/* 14 */     for (String s : val) {
/* 15 */       if (StringUtils.isNotBlank(s)) {
/* 16 */         sqlStr.append(",");
/* 17 */         sqlStr.append("'");
/* 18 */         sqlStr.append(s.trim());
/* 19 */         sqlStr.append("'");
/*    */       }
/*    */     }
/* 22 */     return sqlStr.toString().substring(1);
/*    */   }
/*    */ 
/*    */   public static String getInitialSmall(String str)
/*    */   {
/* 28 */     if (StringUtils.isNotBlank(str)) {
/* 29 */       str = str.substring(0, 1).toLowerCase() + str.substring(1);
/*    */     }
/* 31 */     return str;
/*    */   }
/*    */ 
/*    */   public static Integer getIntegerNotNull(Integer t)
/*    */   {
/* 38 */     if (t == null) {
/* 39 */       return Integer.valueOf(0);
/*    */     }
/* 41 */     return t;
/*    */   }
/*    */ }

 