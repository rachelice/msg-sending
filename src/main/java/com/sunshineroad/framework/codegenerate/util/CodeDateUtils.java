/*     */ package com.sunshineroad.framework.codegenerate.util;
/*     */ 
/*     */ import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CodeDateUtils
/*     */ {
/*     */   public static final String DATESTYLE = "yyyyMMddHHmmss";
/*     */   public static final String DATESTYLE_EX = "yyyy-MM-dd_HH-mm-ss";
/*     */   public static final String DATESTYLE_ = "yyyy-MM-dd";
/*     */   public static final String DATESTYLE_YEAR_MONTH = "yyyyMM";
/*     */   public static final String DATESTYLE_SHORT = "yyyyMMdd";
/*     */   public static final String DATESTYLE_SHORT_EX = "yyyy/MM/dd";
/*     */   public static final String DATESTYLE_YEAR_MONTH_EX = "yyyy/MM";
/*     */   public static final String DATESTYLE_DETAIL = "yyyyMMddHHmmssSSS";
/*     */ 
/*     */   public static String dateToString(Date date)
/*     */   {
/*  73 */     if (date == null) return "";
/*  74 */     return FormatDate(date, "yyyy-MM-dd HH:mm:ss");
/*     */   }
/*     */ 
/*     */   public static String dateToStringShort(Date date)
/*     */   {
/*  82 */     if (date == null) return "";
/*  83 */     return FormatDate(date, "yyyy-MM-dd");
/*     */   }
/*     */ 
/*     */   public static long diffTwoDate(Date date1, Date date2)
/*     */   {
/*  93 */     long l1 = date1.getTime();
/*  94 */     long l2 = date2.getTime();
/*  95 */     return l1 - l2;
/*     */   }
/*     */ 
/*     */   public static int diffTwoDateDay(Date date1, Date date2)
/*     */   {
/* 107 */     long l1 = date1.getTime();
/* 108 */     long l2 = date2.getTime();
 
/* 109 */     int diff = Integer.parseInt(String.valueOf((l1 - l2) / 3600L / 24L / 1000L));
/* 110 */     return diff;
/*     */   }
/*     */ 
/*     */   public static String FormatDate(Date date, String sf)
/*     */   {
/* 120 */     if (date == null) return "";
/* 121 */     SimpleDateFormat dateformat = new SimpleDateFormat(sf);
/* 122 */     return dateformat.format(date);
/*     */   }
/*     */ 
/*     */   public static String getCurrDate()
/*     */   {
/* 130 */     Date date_time = new Date();
/* 131 */     return FormatDate(date_time, "yyyy-MM-dd");
/*     */   }
/*     */ 
/*     */   public static Date getCurrDateTime()
/*     */   {
/* 136 */     return new Date(System.currentTimeMillis());
/*     */   }
/*     */ 
/*     */   public static String getCurrTime()
/*     */   {
/* 144 */     Date date_time = new Date();
/* 145 */     return FormatDate(date_time, "yyyy-MM-dd HH:mm:ss");
/*     */   }
/*     */ 
/*     */   public static String getDate10to8(String str)
/*     */   {
/* 154 */     String y = str.substring(0, 4);
/* 155 */     String m = str.substring(5, 7);
/* 156 */     String d = str.substring(8, 10);
/* 157 */     return y + m + d;
/*     */   }
/*     */ 
/*     */   public static String getDate8to10(String str)
/*     */   {
/* 166 */     String y = str.substring(0, 4);
/* 167 */     String m = str.substring(4, 6);
/* 168 */     String d = str.substring(6, 8);
/* 169 */     return y + "-" + m + "-" + d;
/*     */   }
/*     */ 
/*     */   public static String getDay(Date date)
/*     */   {
/* 178 */     return FormatDate(date, "dd");
/*     */   }
/*     */ 
/*     */   public static String getHour(Date date)
/*     */   {
/* 188 */     return FormatDate(date, "HH");
/*     */   }
/*     */ 
/*     */   public static String getMinute(Date date)
/*     */   {
/* 197 */     return FormatDate(date, "mm");
/*     */   }
/*     */ 
/*     */   public static String getMonth(Date date)
/*     */   {
/* 208 */     return FormatDate(date, "MM");
/*     */   }
/*     */ 
/*     */   public static int getMonth(Date start, Date end) {
/* 212 */     if (start.after(end)) {
/* 213 */       Date t = start;
/* 214 */       start = end;
/* 215 */       end = t;
/*     */     }
/* 217 */     Calendar startCalendar = Calendar.getInstance();
/* 218 */     startCalendar.setTime(start);
/* 219 */     Calendar endCalendar = Calendar.getInstance();
/* 220 */     endCalendar.setTime(end);
/* 221 */     Calendar temp = Calendar.getInstance();
/* 222 */     temp.setTime(end);
/* 223 */     temp.add(5, 1);
/*     */ 
/* 225 */     int year = endCalendar.get(1) - 
/* 226 */       startCalendar.get(1);
/* 227 */     int month = endCalendar.get(2) - 
/* 228 */       startCalendar.get(2);
/*     */ 
/* 230 */     if ((startCalendar.get(5) == 1) && 
/* 231 */       (temp.get(5) == 1))
/* 232 */       return year * 12 + month + 1;
/* 233 */     if ((startCalendar.get(5) != 1) && 
/* 234 */       (temp.get(5) == 1))
/* 235 */       return year * 12 + month;
/* 236 */     if ((startCalendar.get(5) == 1) && 
/* 237 */       (temp.get(5) != 1)) {
/* 238 */       return year * 12 + month;
/*     */     }
/* 240 */     return (year * 12 + month - 1 < 0) ? 0 : year * 12 + month;
/*     */   }
/*     */ 
/*     */   public static String getSecond(Date date)
/*     */   {
/* 250 */     return FormatDate(date, "ss");
/*     */   }
/*     */ 
/*     */   public static String getTime(String year, String month)
/*     */   {
/* 260 */     String time = "";
/* 261 */     int len = 31;
/* 262 */     int iYear = Integer.parseInt(year);
/* 263 */     int iMonth = Integer.parseInt(month);
/* 264 */     if ((iMonth == 4) || (iMonth == 6) || (iMonth == 9) || (iMonth == 11))
/* 265 */       len = 30;
/* 266 */     if (iMonth == 2) {
/* 267 */       len = 28;
/* 268 */       if (((iYear % 4 == 0) && (iYear % 100 == 0) && (iYear % 400 == 0)) || ((iYear % 4 == 0) && (iYear % 100 != 0))) {
/* 269 */         len = 29;
/*     */       }
/*     */     }
/* 272 */     time = year + "-" + month + "-" + String.valueOf(len);
/* 273 */     return time;
/*     */   }
/*     */ 
/*     */   public static String getYear(Date date)
/*     */   {
/* 282 */     return FormatDate(date, "yyyy");
/*     */   }
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/* 290 */     CodeDateUtils d = new CodeDateUtils();
/* 291 */     String strDate = "2007-02-11";
/* 292 */     Date aa = stringToDateShort(strDate);
/*     */ 
/* 294 */     CodeDateUtils ddd = new CodeDateUtils();
/*     */   }
/*     */ 
/*     */   public static Date stringToDate(String dateString)
/*     */   {
/* 303 */     if ((dateString == null) || (dateString.trim().length() == 0)) return null;
/* 304 */     String datestr = dateString.trim();
/*     */ 
/* 306 */     String sf = "yyyy-MM-dd HH:mm:ss";
/* 307 */     Date dt = stringToDate(datestr, sf);
/* 308 */     if (dt == null) dt = stringToDate(datestr, "yyyy-MM-dd");
/* 309 */     if (dt == null) dt = stringToDate(datestr, "yyyyMMdd");
/* 310 */     return dt;
/*     */   }
/*     */ 
/*     */   public static Date stringToDate(String dateString, String sf)
/*     */   {
/* 318 */     ParsePosition pos = new ParsePosition(0);
/* 319 */     SimpleDateFormat sdf = new SimpleDateFormat(sf);
/* 320 */     Date dt = sdf.parse(dateString, pos);
/* 321 */     return dt;
/*     */   }
/*     */ 
/*     */   public static Date stringToDateShort(String dateString)
/*     */   {
/* 329 */     String sf = "yyyy-MM-dd";
/* 330 */     Date dt = stringToDate(dateString, sf);
/* 331 */     return dt;
/*     */   }
/*     */ 
/*     */   public String getBeginDate(String granularity, String statisticDate)
/*     */   {
/* 342 */     String beginDate = "";
/* 343 */     Date date = stringToDateShort(statisticDate);
/* 344 */     Date beginDateTemp = null;
/* 345 */     if (granularity.equals("1")) {
/* 346 */       beginDateTemp = date;
/*     */     }
/* 348 */     if (granularity.equals("2")) {
/* 349 */       beginDateTemp = getWeekBegin(date);
/*     */     }
/* 351 */     if (granularity.equals("3")) {
/* 352 */       beginDateTemp = getPeriodBegin(date);
/*     */     }
/* 354 */     else if (granularity.equals("4")) {
/* 355 */       beginDateTemp = getMonthBegin(date);
/*     */     }
/* 357 */     else if (granularity.equals("5")) {
/* 358 */       beginDateTemp = getSeasonBegin(date);
/*     */     }
/* 360 */     else if (granularity.equals("6")) {
/* 361 */       beginDateTemp = getHalfYearBegin(date);
/*     */     }
/* 363 */     else if (granularity.equals("7")) {
/* 364 */       beginDateTemp = getYearBegin(date);
/*     */     }
/* 366 */     beginDate = dateToStringShort(beginDateTemp);
/* 367 */     return beginDate;
/*     */   }
/*     */ 
/*     */   public String getDateChangeALL(String currentTime, String type, int iQuantity)
/*     */   {
/* 379 */     Date curr = null;
/* 380 */     String newtype = "";
/* 381 */     if (currentTime.length() == 10) {
/* 382 */       curr = stringToDateShort(currentTime);
/*     */     }
/* 384 */     if (currentTime.length() > 10) {
/* 385 */       curr = stringToDate(currentTime);
/*     */     }
/*     */ 
/* 389 */     if (type.equals("1")) {
/* 390 */       
/* 391 */       newtype = "d";
/*     */     }
/* 394 */     else if (type.equals("2")) {
/* 395 */       iQuantity *= 7;
/* 396 */       newtype = "d";
/*     */     }
/* 399 */     else if (type.equals("3")) {
/* 400 */       iQuantity *= 10;
/* 401 */       newtype = "d";
/*     */     }
/* 404 */     else if (type.equals("4")) {
/* 405 */        ;
/* 406 */       newtype = "m";
/*     */     }
/* 409 */     else if (type.equals("5")) {
/* 410 */       iQuantity *= 3;
/* 411 */       newtype = "m";
/*     */     }
/* 414 */     else if (type.equals("6")) {
/* 415 */       iQuantity *= 6;
/* 416 */       newtype = "m";
/*     */     }
/* 419 */     else if (type.equals("7")) {
/* 420 */       newtype = "y";
/*     */     }
/*     */     else {
/* 423 */        ;
/* 424 */       newtype = "d";
/*     */     }
/*     */ 
/* 427 */     Date change = getDateChangeTime(curr, newtype, iQuantity);
/*     */ 
/* 433 */     return dateToStringShort(change);
/*     */   }
/*     */ 
/*     */   public Date getDateChangeTime(Date currentTime, String type, int iQuantity)
/*     */   {
/* 445 */     int year = Integer.parseInt(FormatDate(currentTime, "yyyy"));
/* 446 */     int month = Integer.parseInt(FormatDate(currentTime, "MM"));
/*     */ 
/* 448 */     --month;
/* 449 */     int day = Integer.parseInt(FormatDate(currentTime, "dd"));
/* 450 */     int hour = Integer.parseInt(FormatDate(currentTime, "HH"));
/* 451 */     int mi = Integer.parseInt(FormatDate(currentTime, "mm"));
/* 452 */     int ss = Integer.parseInt(FormatDate(currentTime, "ss"));
/* 453 */     GregorianCalendar gc = new GregorianCalendar(year, month, day, 
/* 454 */       hour, mi, ss);
/*     */ 
/* 457 */     if (type.equalsIgnoreCase("y")) {
/* 458 */       gc.add(1, iQuantity);
/*     */     }
/* 460 */     else if (type.equalsIgnoreCase("m")) {
/* 461 */       gc.add(2, iQuantity);
/*     */     }
/* 463 */     else if (type.equalsIgnoreCase("d")) {
/* 464 */       gc.add(5, iQuantity);
/*     */     }
/* 466 */     else if (type.equalsIgnoreCase("h")) {
/* 467 */       gc.add(10, iQuantity);
/*     */     }
/* 469 */     else if (type.equalsIgnoreCase("mi")) {
/* 470 */       gc.add(12, iQuantity);
/*     */     }
/* 472 */     else if (type.equalsIgnoreCase("s")) {
/* 473 */       gc.add(13, iQuantity);
/*     */     }
/* 475 */     return gc.getTime();
/*     */   }
/*     */ 
/*     */   public String getDateChangeTime(String currentTime, String type, int iQuantity)
/*     */   {
/* 488 */     Date curr = stringToDate(currentTime);
/* 489 */     curr = getDateChangeTime(curr, type, iQuantity);
/* 490 */     return dateToString(curr);
/*     */   }
/*     */ 
/*     */   public String getEndDate(String granularity, String statisticDate)
/*     */   {
/* 499 */     String beginDate = "";
/* 500 */     Date date = stringToDateShort(statisticDate);
/* 501 */     Date beginDateTemp = null;
/*     */ 
/* 504 */     if (granularity.equals("1")) {
/* 505 */       beginDateTemp = date;
/*     */     }
/* 507 */     if (granularity.equals("2")) {
/* 508 */       beginDateTemp = getWeekEnd(date);
/*     */     }
/* 510 */     if (granularity.equals("3")) {
/* 511 */       beginDateTemp = getPeriodEnd(date);
/*     */     }
/* 513 */     else if (granularity.equals("4")) {
/* 514 */       beginDateTemp = getMonthEnd(date);
/*     */     }
/* 516 */     else if (granularity.equals("5")) {
/* 517 */       beginDateTemp = getSeasonEnd(date);
/*     */     }
/* 519 */     else if (granularity.equals("6")) {
/* 520 */       beginDateTemp = getHalfYearEnd(date);
/*     */     }
/* 522 */     else if (granularity.equals("7")) {
/* 523 */       beginDateTemp = getYearEnd(date);
/*     */     }
/*     */ 
/* 526 */     beginDate = dateToStringShort(beginDateTemp);
/* 527 */     return beginDate;
/*     */   }
/*     */ 
/*     */   public Date getHalfYearBegin(Date date)
/*     */   {
/* 536 */     int year = Integer.parseInt(FormatDate(date, "yyyy"));
/* 537 */     int month = Integer.parseInt(FormatDate(date, "MM"));
/* 538 */     String newDateStr = FormatDate(date, "yyyy") + "-";
/* 539 */     if (month <= 6) {
/* 540 */       newDateStr = newDateStr + "01-01";
/*     */     }
/*     */     else {
/* 543 */       newDateStr = newDateStr + "07-01";
/*     */     }
/* 545 */     return stringToDateShort(newDateStr);
/*     */   }
/*     */ 
/*     */   public Date getHalfYearEnd(Date date)
/*     */   {
/* 554 */     int year = Integer.parseInt(FormatDate(date, "yyyy"));
/* 555 */     int month = Integer.parseInt(FormatDate(date, "MM"));
/* 556 */     String newDateStr = FormatDate(date, "yyyy") + "-";
/* 557 */     if (month <= 6) {
/* 558 */       newDateStr = newDateStr + "06-30";
/*     */     }
/*     */     else {
/* 561 */       newDateStr = newDateStr + "12-31";
/*     */     }
/* 563 */     return stringToDateShort(newDateStr);
/*     */   }
/*     */ 
/*     */   public Date getMonthBegin(Date date)
/*     */   {
/* 572 */     String newDateStr = FormatDate(date, "yyyy-MM") + "-01";
/*     */ 
/* 574 */     return stringToDateShort(newDateStr);
/*     */   }
/*     */ 
/*     */   public Date getMonthEnd(Date date)
/*     */   {
/* 584 */     int year = Integer.parseInt(FormatDate(date, "yyyy"));
/* 585 */     int month = Integer.parseInt(FormatDate(date, "MM"));
/* 586 */     int day = Integer.parseInt(FormatDate(date, "dd"));
/*     */ 
/* 588 */     GregorianCalendar calendar = new GregorianCalendar(year, month - 1, day, 0, 0, 0);
/* 589 */     int monthLength = calendar.getActualMaximum(5);
/* 590 */     String newDateStr = FormatDate(date, "yyyy") + "-" + FormatDate(date, "MM") + "-";
/* 591 */     if (monthLength < 10)
/* 592 */       newDateStr = newDateStr + "0" + monthLength;
/*     */     else
/* 594 */       newDateStr = newDateStr + monthLength;
/* 595 */     return stringToDateShort(newDateStr);
/*     */   }
/*     */ 
/*     */   public Date getPeriodBegin(Date date)
/*     */   {
/* 604 */     int days = Integer.parseInt(FormatDate(date, "dd"));
/* 605 */     String newDateStr = FormatDate(date, "yyyy-MM") + "-";
/* 606 */     if (days <= 10) {
/* 607 */       newDateStr = newDateStr + "01";
/*     */     }
/* 609 */     else if (days <= 20)
/* 610 */       newDateStr = newDateStr + "11";
/*     */     else {
/* 612 */       newDateStr = newDateStr + "21";
/*     */     }
/* 614 */     return stringToDateShort(newDateStr);
/*     */   }
/*     */ 
/*     */   public Date getPeriodEnd(Date date)
/*     */   {
/* 624 */     int days = Integer.parseInt(FormatDate(date, "dd"));
/* 625 */     String newDateStr = FormatDate(date, "yyyy-MM") + "-";
/* 626 */     if (days <= 10) {
/* 627 */       newDateStr = newDateStr + "10";
/*     */     }
/* 629 */     else if (days <= 20)
/* 630 */       newDateStr = newDateStr + "20";
/*     */     else {
/* 632 */       newDateStr = FormatDate(getMonthEnd(date), "yyyy-MM-dd");
/*     */     }
/* 634 */     return stringToDateShort(newDateStr);
/*     */   }
/*     */ 
/*     */   public Date getSeasonBegin(Date date)
/*     */   {
/* 644 */     int year = Integer.parseInt(FormatDate(date, "yyyy"));
/* 645 */     int month = Integer.parseInt(FormatDate(date, "MM"));
/* 646 */     String newDateStr = FormatDate(date, "yyyy") + "-";
/* 647 */     if ((month >= 1) && (month <= 3)) {
/* 648 */       newDateStr = newDateStr + "01-01";
/*     */     }
/* 650 */     else if ((month >= 4) && (month <= 6)) {
/* 651 */       newDateStr = newDateStr + "04-01";
/*     */     }
/* 653 */     else if ((month >= 7) && (month <= 9)) {
/* 654 */       newDateStr = newDateStr + "07-01";
/*     */     }
/* 656 */     else if ((month >= 10) && (month <= 12)) {
/* 657 */       newDateStr = newDateStr + "10-01";
/*     */     }
/* 659 */     return stringToDateShort(newDateStr);
/*     */   }
/*     */ 
/*     */   public Date getSeasonEnd(Date date)
/*     */   {
/* 668 */     int year = Integer.parseInt(FormatDate(date, "yyyy"));
/* 669 */     int month = Integer.parseInt(FormatDate(date, "MM"));
/* 670 */     String newDateStr = FormatDate(date, "yyyy") + "-";
/* 671 */     if ((month >= 1) && (month <= 3)) {
/* 672 */       newDateStr = newDateStr + "03-31";
/*     */     }
/* 674 */     else if ((month >= 4) && (month <= 6)) {
/* 675 */       newDateStr = newDateStr + "06-30";
/*     */     }
/* 677 */     else if ((month >= 7) && (month <= 9)) {
/* 678 */       newDateStr = newDateStr + "09-30";
/*     */     }
/* 680 */     else if ((month >= 10) && (month <= 12)) {
/* 681 */       newDateStr = newDateStr + "12-31";
/*     */     }
/* 683 */     return stringToDateShort(newDateStr);
/*     */   }
/*     */ 
/*     */   public String getTimedes(String granularity, String statisticDate)
/*     */   {
/* 698 */     String timedes = "";
/* 699 */     Date date = stringToDateShort(statisticDate);
/* 700 */     String year = ""; String month = "01"; String day = "01";
/* 701 */     year = getYear(date);
/* 702 */     month = getMonth(date);
/* 703 */     day = getDay(date);
/* 704 */     if (granularity.equals("1")) {
/* 705 */       timedes = statisticDate;
/* 706 */     } else if (granularity.equals("4")) {
/* 707 */       timedes = year + "年" + month + "月";
/*     */     }
/* 709 */     else if (granularity.equals("8")) {
/* 710 */       String quarter = month + "-" + day;
/* 711 */       if (quarter.equals("03-31"))
/* 712 */         timedes = year + "年 第1季度";
/* 713 */       else if (quarter.equals("06-30"))
/* 714 */         timedes = year + "年 第2季度";
/* 715 */       else if (quarter.equals("09-30"))
/* 716 */         timedes = year + "年 第3季度";
/* 717 */       else if (quarter.equals("12-31"))
/* 718 */         timedes = year + "年 第4季度";
/*     */     }
/* 720 */     else if (granularity.equals("32")) {
/* 721 */       timedes = year + "年";
/*     */     }
/* 723 */     return timedes;
/*     */   }
/*     */ 
/*     */   public Date getWeekBegin(Date date)
/*     */   {
/* 733 */     int year = Integer.parseInt(FormatDate(date, "yyyy"));
/* 734 */     int month = Integer.parseInt(FormatDate(date, "MM"));
/*     */ 
/* 736 */     --month;
/* 737 */     int day = Integer.parseInt(FormatDate(date, "dd"));
/*     */ 
/* 739 */     GregorianCalendar gc = new GregorianCalendar(year, month, day);
/*     */ 
/* 742 */     int week = 6;
/*     */ 
/* 744 */     if (week == 0) {
/* 745 */       week = 7;
/*     */     }
/*     */ 
/* 748 */     gc.add(5, 0 - week + 1);
/*     */ 
/* 750 */     return gc.getTime();
/*     */   }
/*     */ 
/*     */   public Date getWeekEnd(Date date)
/*     */   {
/* 760 */     int year = Integer.parseInt(FormatDate(date, "yyyy"));
/* 761 */     int month = Integer.parseInt(FormatDate(date, "MM"));
/*     */ 
/* 763 */     --month;
/* 764 */     int day = Integer.parseInt(FormatDate(date, "dd"));
/*     */ 
/* 766 */     GregorianCalendar gc = new GregorianCalendar(year, month, day);
/*     */ 
/* 769 */     int week = 6;
/*     */ 
/* 771 */     if (week == 0) {
/* 772 */       week = 7;
/*     */     }
/* 774 */     gc.add(5, 7 - week);
/*     */ 
/* 776 */     return gc.getTime();
/*     */   }
/*     */ 
/*     */   public Date getYearBegin(Date date)
/*     */   {
/* 785 */     String newDateStr = FormatDate(date, "yyyy") + "-01-01";
/* 786 */     return stringToDateShort(newDateStr);
/*     */   }
/*     */ 
/*     */   public Date getYearEnd(Date date)
/*     */   {
/* 795 */     String newDateStr = FormatDate(date, "yyyy") + "-12-31";
/* 796 */     return stringToDateShort(newDateStr);
/*     */   }
/*     */ 
/*     */   public boolean IsXperiodEnd(Date date)
/*     */   {
/* 806 */     boolean flag = false;
/*     */ 
/* 808 */     String day = getDay(date);
/* 809 */     String month = getMonth(date);
/*     */ 
/* 811 */     if (day.equalsIgnoreCase("10")) {
/* 812 */       flag = true;
/*     */     }
/* 814 */     else if (day.equalsIgnoreCase("20")) {
/* 815 */       flag = true;
/*     */     }
/*     */ 
/* 822 */     return flag;
/*     */   }
/*     */ 
/*     */   public static String addDay(String s, int n)
/*     */   {
/*     */     try
/*     */     {
/* 832 */       SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
/*     */ 
/* 834 */       Calendar cd = Calendar.getInstance();
/* 835 */       cd.setTime(sdf.parse(s));
/* 836 */       cd.add(5, n);
/*     */ 
/* 839 */       return sdf.format(cd.getTime());
/*     */     } catch (Exception e) {
/*     */     }
/* 842 */     return null;
/*     */   }
/*     */ 
/*     */   public static String delDay(String s, int n)
/*     */   {
/*     */     try
/*     */     {
/* 853 */       SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
/*     */ 
/* 855 */       Calendar cd = Calendar.getInstance();
/* 856 */       cd.setTime(sdf.parse(s));
/* 857 */       cd.add(5, -n);
/*     */ 
/* 860 */       return sdf.format(cd.getTime());
/*     */     } catch (Exception e) {
/*     */     }
/* 863 */     return null;
/*     */   }
/*     */ }

/* Location:           C:\Users\Administrator.WIN-ARR84UMMDSP\Desktop\org.jeecgframework.codegenerate.jar
 * Qualified Name:     org.jeecgframework.codegenerate.util.CodeDateUtils
 * JD-Core Version:    0.5.4
 */