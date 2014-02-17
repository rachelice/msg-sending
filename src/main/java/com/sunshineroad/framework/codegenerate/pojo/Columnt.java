/*     */ package com.sunshineroad.framework.codegenerate.pojo;
/*     */ 
/*     */ public class Columnt
/*     */ {
/*     */   public static final String OPTION_REQUIRED = "required:true";
/*     */   public static final String OPTION_NUMBER_INSEX = "precision:2,groupSeparator:','";
/*     */   private String fieldDbName;
/*     */   private String fieldName;
/*  13 */   private String filedComment = "";
/*     */ 
/*  15 */   private String fieldType = "";
/*     */ 
/*  17 */   private String classType = "";
/*     */ 
/*  19 */   private String classType_row = "";
/*     */ 
/*  21 */   private String optionType = "";
/*     */ 
/*  23 */   private String charmaxLength = "";
/*     */   private String precision;
/*     */   private String scale;
/*     */   private String nullable;
/*     */ 
/*     */   public String getNullable()
/*     */   {
/*  32 */     return this.nullable;
/*     */   }
/*     */ 
/*     */   public void setNullable(String nullable) {
/*  36 */     this.nullable = nullable;
/*     */   }
/*     */ 
/*     */   public String getPrecision() {
/*  40 */     return this.precision;
/*     */   }
/*     */ 
/*     */   public String getScale() {
/*  44 */     return this.scale;
/*     */   }
/*     */ 
/*     */   public void setPrecision(String precision) {
/*  48 */     this.precision = precision;
/*     */   }
/*     */ 
/*     */   public void setScale(String scale) {
/*  52 */     this.scale = scale;
/*     */   }
/*     */ 
/*     */   public String getOptionType() {
/*  56 */     return this.optionType;
/*     */   }
/*     */ 
/*     */   public void setOptionType(String optionType) {
/*  60 */     this.optionType = optionType;
/*     */   }
/*     */ 
/*     */   public String getClassType() {
/*  64 */     return this.classType;
/*     */   }
/*     */ 
/*     */   public void setClassType(String classType) {
/*  68 */     this.classType = classType;
/*     */   }
/*     */ 
/*     */   public String getFieldType() {
/*  72 */     return this.fieldType;
/*     */   }
/*     */ 
/*     */   public void setFieldType(String fieldType) {
/*  76 */     this.fieldType = fieldType;
/*     */   }
/*     */ 
/*     */   public String getFieldName() {
/*  80 */     return this.fieldName;
/*     */   }
/*     */ 
/*     */   public void setFieldName(String fieldName) {
/*  84 */     this.fieldName = fieldName;
/*     */   }
/*     */ 
/*     */   public String getFiledComment()
/*     */   {
/*  94 */     return this.filedComment;
/*     */   }
/*     */ 
/*     */   public void setFiledComment(String filedComment) {
/*  98 */     this.filedComment = filedComment;
/*     */   }
/*     */ 
/*     */   public String getClassType_row() {
/* 102 */     if ((this.classType != null) && (this.classType.indexOf("easyui-") >= 0)) {
/* 103 */       return this.classType.replaceAll("easyui-", "");
/*     */     }
/* 105 */     return this.classType_row;
/*     */   }
/*     */ 
/*     */   public void setClassType_row(String classType_row) {
/* 109 */     this.classType_row = classType_row;
/*     */   }
/*     */ 
/*     */   public String getCharmaxLength() {
/* 113 */     if ((this.charmaxLength == null) || ("0".equals(this.charmaxLength))) {
/* 114 */       return "";
/*     */     }
/* 116 */     return this.charmaxLength;
/*     */   }
/*     */ 
/*     */   public void setCharmaxLength(String charmaxLength) {
/* 120 */     this.charmaxLength = charmaxLength;
/*     */   }
/*     */ 
/*     */   public String getFieldDbName() {
/* 124 */     return this.fieldDbName;
/*     */   }
/*     */ 
/*     */   public void setFieldDbName(String fieldDbName) {
/* 128 */     this.fieldDbName = fieldDbName;
/*     */   }
/*     */ }

/* Location:           C:\Users\Administrator.WIN-ARR84UMMDSP\Desktop\org.jeecgframework.codegenerate.jar
 * Qualified Name:     org.jeecgframework.codegenerate.pojo.Columnt
 * JD-Core Version:    0.5.4
 */