/*     */ package com.sunshineroad.framework.codegenerate.util;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.PrintStream;
/*     */ 
/*     */ public class JeecgCodeDeleteUtil
/*     */ {
/*   7 */   private static String buss_package = CodeResourceUtil.bussiPackage;
/*   8 */   private static final String src_url = "src/" + buss_package;
/*   9 */   private static final String web_url = "WebRoot/" + buss_package;
/*     */   private static final String action_inx = "action";
/*     */   private static final String entity_inx = "entity";
/*     */   private static final String page_inx = "page";
/*     */   private static final String service_inx = "service";
/*     */   private static final String impl_inx = "impl";
/*     */   private static String action_url;
/*     */   private static String entity_url;
/*     */   private static String page_url;
/*     */   private static String service_url;
/*     */   private static String service_impl_url;
/*     */   private static String jsp_url;
/*     */   private static String jsp_add_url;
/*     */   private static String jsp_edit_url;
/*     */ 
/*     */   public static void init(String gn_package, String name)
/*     */   {
/*  28 */     action_url = src_url + "/" + "action" + "/" + gn_package + "/" + name + "Action.java";
/*  29 */     entity_url = src_url + "/" + "entity" + "/" + gn_package + "/" + name + "Entity.java";
/*  30 */     page_url = src_url + "/" + "page" + "/" + gn_package + "/" + name + "Page.java";
/*  31 */     service_url = src_url + "/" + "service" + "/" + gn_package + "/" + name + "Service.java";
/*  32 */     service_impl_url = src_url + "/" + "service" + "/" + "impl" + "/" + gn_package + "/" + name + "ServiceImpl.java";
/*  33 */     jsp_url = web_url + "/" + gn_package + "/" + name + ".jsp";
/*  34 */     jsp_add_url = web_url + "/" + gn_package + "/" + name + "-main-add.jsp";
/*  35 */     jsp_edit_url = web_url + "/" + gn_package + "/" + name + "-main-edit.jsp";
/*     */ 
/*  39 */     String path = getProjectPath();
/*  40 */     action_url = path + "/" + action_url;
/*  41 */     entity_url = path + "/" + entity_url;
/*  42 */     page_url = path + "/" + page_url;
/*  43 */     service_url = path + "/" + service_url;
/*  44 */     service_impl_url = path + "/" + service_impl_url;
/*  45 */     jsp_url = path + "/" + jsp_url;
/*  46 */     jsp_add_url = path + "/" + jsp_add_url;
/*  47 */     jsp_edit_url = path + "/" + jsp_edit_url;
/*     */   }
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/*  53 */     String name = "Company";
/*  54 */     String subPackage = "test";
/*  55 */     delCode(subPackage, name);
/*     */   }
/*     */ 
/*     */   public static void delCode(String subPackage, String codeName)
/*     */   {
/*  62 */     init(subPackage, codeName);
/*     */ 
/*  65 */     delete(action_url);
/*  66 */     delete(entity_url);
/*  67 */     delete(page_url);
/*  68 */     delete(service_url);
/*  69 */     delete(service_impl_url);
/*  70 */     delete(jsp_edit_url);
/*  71 */     delete(jsp_url);
/*  72 */     delete(jsp_add_url);
/*     */ 
/*  74 */     System.out.println("--------------------删除动作结束-----------------------");
/*     */   }
/*     */ 
/*     */   public static String getProjectPath()
/*     */   {
/*  81 */     String path = System.getProperty("user.dir").replace("\\", "/") + "/";
/*  82 */     return path;
/*     */   }
/*     */ 
/*     */   public static boolean delete(String strFileName)
/*     */   {
/*  94 */     File fileDelete = new File(strFileName);
/*     */ 
/*  96 */     if ((!fileDelete.exists()) || (!fileDelete.isFile()))
/*     */     {
/*  98 */       return false;
/*     */     }
/*     */ 
/* 101 */     System.out.println("--------成功删除文件---------" + strFileName);
/* 102 */     return fileDelete.delete();
/*     */   }
/*     */ }

/* Location:           C:\Users\Administrator.WIN-ARR84UMMDSP\Desktop\org.jeecgframework.codegenerate.jar
 * Qualified Name:     org.jeecgframework.codegenerate.util.JeecgCodeDeleteUtil
 * JD-Core Version:    0.5.4
 */