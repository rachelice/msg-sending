/*    */ package com.sunshineroad.framework.codegenerate.pojo;
/*    */ 
/*    */ import org.apache.commons.lang.StringUtils;
/*    */ 
/*    */ public class TableConvert
/*    */ {
/*    */   public static String getNullAble(String nullable)
/*    */   {
/* 15 */     if (("YES".equals(nullable)) || ("yes".equals(nullable)) || ("y".equals(nullable)) || ("Y".equals(nullable)) || ("f".equals(nullable))) {
/* 16 */       return "Y";
/*    */     }
/* 18 */     if (("NO".equals(nullable)) || ("N".equals(nullable)) || ("no".equals(nullable)) || ("n".equals(nullable)) || ("t".equals(nullable))) {
/* 19 */       return "N";
/*    */     }
/* 21 */     return null;
/*    */   }
/*    */ 
/*    */   public static String getNullString(String nullable)
/*    */   {
/* 30 */     if (StringUtils.isBlank(nullable)) {
/* 31 */       return "";
/*    */     }
/* 33 */     return nullable;
/*    */   }
/*    */ 
/*    */   public static String getV(String s)
/*    */   {
/* 41 */     return "'" + s + "'";
/*    */   }
/*    */ }

/* Location:           C:\Users\Administrator.WIN-ARR84UMMDSP\Desktop\org.jeecgframework.codegenerate.jar
 * Qualified Name:     org.jeecgframework.codegenerate.pojo.TableConvert
 * JD-Core Version:    0.5.4
 */