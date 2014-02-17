package com.sunshineroad.framework.util;

import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import jxl.Workbook;
import jxl.write.DateFormat;
import jxl.write.DateTime;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

/**
 * 
 * omplatform
 * com.sunshineroad.framework.util
 * @{#} ExcelUtil.java Create on  2013-6-14 上午11:21:31
 * 
 * Copyright (c) 2013 by 阳光道路.
 * @author <a href="mailto:younglihl@163.com">李红雷</a>
 * @version 1.0
 * 功能说明：数据写入到Excel或从Excel读取数据
 *
 */

public class ExcelUtil {

	public static boolean DBToExcel(ResultSet rs,String fileName) {
		boolean flag = false;
		WritableWorkbook workbook = null;
		WritableSheet sheet = null;
		Label label = null;
		DateTime dateCell = null;

		// 创建Excel表
		try {
			workbook = Workbook.createWorkbook(new File(fileName));

			// 创建Excel表中的sheet
			sheet = workbook.createSheet("第一页", 0);

			// 向Excel中添加数据
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnCount = rsmd.getColumnCount();
			String colName = null;
			int row = 0;
			// 添加标题
			for (int i = 0; i < columnCount; i++) {
				colName = rsmd.getColumnName(i + 1);
				label = new Label(i, row, colName);
				sheet.addCell(label);
			}
			row++;
			System.out.println("写入标题成功");
			while (rs.next()) {
				SimpleDateFormat sdf = new SimpleDateFormat(
						"yyyy-MM-dd hh:mm:ss");
				DateFormat customDateFormat = new DateFormat(
						"yyyy-MM-dd hh:mm:ss");
				WritableCellFormat dateFormat = new WritableCellFormat(
						customDateFormat);
				for (int i = 0; i < columnCount; i++) {
					if ((rsmd.getColumnType(i + 1) == java.sql.Types.TIMESTAMP)
							&& rs.getString(i + 1) != null) {
						dateCell = new DateTime(i, row, sdf.parse(rs
								.getString(i + 1)), dateFormat);
						sheet.addCell(dateCell);

					} else {
						label = new Label(i, row, rs.getString(i + 1));
						sheet.addCell(label);
					}

				}
				row++;
			}
			System.out.println("写入内容成功");

			// 关闭文件
			workbook.write();
			workbook.close();
			System.out.println("数据成功写入Excel");
			flag = true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (RowsExceededException e) {
			System.out.println(e.getMessage());
		} catch (WriteException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				workbook.close();
				System.out.println("写入数据失败！");
			} catch (Exception e) {
			}
		}
		return flag;
	}
}
