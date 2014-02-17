/*     */ package com.sunshineroad.framework.codegenerate.util;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.PrintStream;
/*     */ import java.security.SecureRandom;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Date;
/*     */ import java.util.UUID;
/*     */ import org.apache.commons.lang.RandomStringUtils;
/*     */ 
/*     */ public class NonceUtils
/*     */ {
/*  19 */   private static final SimpleDateFormat INTERNATE_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
/*     */ 
/*  22 */   private static final String[] SPACES = { "0", "00", "0000", "00000000" };
/*     */   private static Date lastTime;
/*  26 */   private static int counter = 0;
/*     */ 
/*     */   public static String randomString(int length)
/*     */   {
/*  35 */     return RandomStringUtils.randomAlphanumeric(length);
/*     */   }
/*     */ 
/*     */   public static int randomInt()
/*     */   {
/*  42 */     return new SecureRandom().nextInt();
/*     */   }
/*     */ 
/*     */   public static String randomHexInt()
/*     */   {
/*  49 */     return Integer.toHexString(randomInt());
/*     */   }
/*     */ 
/*     */   public static long randomLong()
/*     */   {
/*  56 */     return new SecureRandom().nextLong();
/*     */   }
/*     */ 
/*     */   public static String randomHexLong()
/*     */   {
/*  63 */     return Long.toHexString(randomLong());
/*     */   }
/*     */ 
/*     */   public static String randomUUID()
/*     */   {
/*  70 */     return UUID.randomUUID().toString();
/*     */   }
/*     */ 
/*     */   public static String currentTimestamp()
/*     */   {
/*  80 */     Date now = new Date();
/*  81 */     return INTERNATE_DATE_FORMAT.format(now);
/*     */   }
/*     */ 
/*     */   public static long currentMills()
/*     */   {
/*  88 */     return System.currentTimeMillis();
/*     */   }
/*     */ 
/*     */   public static String currentHexMills()
/*     */   {
/*  95 */     return Long.toHexString(currentMills());
/*     */   }
/*     */ 
/*     */   public static synchronized String getCounter()
/*     */   {
/* 103 */     Date currentTime = new Date();
/*     */ 
/* 105 */     if (currentTime.equals(lastTime)) {
/* 106 */       counter += 1;
/*     */     } else {
/* 108 */       lastTime = currentTime;
/* 109 */       counter = 0;
/*     */     }
/* 111 */     return Integer.toHexString(counter);
/*     */   }
/*     */ 
/*     */   public static String format(String source, int length)
/*     */   {
/* 119 */     int spaceLength = length - source.length();
/* 120 */     StringBuilder buf = new StringBuilder();
/*     */ 
/* 122 */     while (spaceLength >= 8) {
/* 123 */       buf.append(SPACES[3]);
/* 124 */       spaceLength -= 8;
/*     */     }
/*     */ 
/* 127 */     for (int i = 2; i >= 0; --i) {
/* 128 */       if ((spaceLength & 1 << i) != 0) {
/* 129 */         buf.append(SPACES[i]);
/*     */       }
/*     */     }
/*     */ 
/* 133 */     buf.append(source);
/* 134 */     return buf.toString();
/*     */   }
/*     */   public static void main(String[] args) throws IOException {
/* 137 */     System.out.println(randomLong() + currentMills());
/*     */   }
/*     */ }

/* Location:           C:\Users\Administrator.WIN-ARR84UMMDSP\Desktop\org.jeecgframework.codegenerate.jar
 * Qualified Name:     org.jeecgframework.codegenerate.util.NonceUtils
 * JD-Core Version:    0.5.4
 */