package com.sunshineroad.framework.util;

/**
 * omplatform
 * test
 * @{#} exceltest.java Create on  2013-6-18 上午9:10:04
 * 
 * Copyright (c) 2013 by 阳光道路.
 * @author <a href="mailto:371917461@qq.com">张光明</a>
 * @version 1.0
 * 功能说明：读取Excel
 *
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelSheetParser
{
	// log4j
	private Logger logger = Logger.getLogger(ExcelSheetParser.class);

//	XSSFWorkbook 只支持2007，HSSFWorkbook只支持2003
	private XSSFWorkbook workbook2007;// 工作簿
	
	private HSSFWorkbook workbook2003;

	public ExcelSheetParser(String fileName)
	{
		try
		{
			File file = new File(fileName);
			FileInputStream fis = new FileInputStream(file);
			boolean isExcel2003 = true;
	        /** 对文件的合法性进行验证 */
	        if (fileName.matches("^.+\\.(?i)(xlsx)$"))
	        {
	            isExcel2003 = false;
	        }
			// 获取工作薄workbook
			if (!isExcel2003)
			{
				workbook2007 = new XSSFWorkbook(fis);
			} else
			{
				workbook2003 = new HSSFWorkbook(fis);
			}
			fis.close();
		}
		catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@SuppressWarnings({ "rawtypes" })
	public List getDatasInSheetX(int sheetNumber)
	{
		List<List> result = new ArrayList<List>();

		// 获得指定的sheet
		XSSFSheet sheet = workbook2007.getSheetAt(sheetNumber);
		// 获得sheet总行数
		int rowCount = sheet.getLastRowNum();
		logger.info("found excel rows count:" + rowCount);
		if (rowCount < 1)
		{
			return result;
		}

		// 遍历行row
		for (int rowIndex = 0; rowIndex <= rowCount; rowIndex++)
		{
			// 获得行对象
			XSSFRow row = sheet.getRow(rowIndex);
			if (null != row)
			{
				List<Object> rowData = new ArrayList<Object>();
				// 获得本行中单元格的个数
				int cellCount = row.getLastCellNum();
				// 遍历列cell
				for (short cellIndex = 0; cellIndex < cellCount; cellIndex++)
				{
					XSSFCell cell = row.getCell(cellIndex);
					// 获得指定单元格中的数据
					Object cellStr = this.getCellStringX(cell);

					rowData.add(cellStr);
				}
				result.add(rowData);
			}
		}
		return result;
	}

	private Object getCellStringX(XSSFCell cell)
	{
		// TODO Auto-generated method stub
		Object result = null;
		if (cell != null)
		{
			// 单元格类型：Numeric:0,String:1,Formula:2,Blank:3,Boolean:4,Error:5
			int cellType = cell.getCellType();
			switch (cellType)
			{
			case XSSFCell.CELL_TYPE_STRING:
				result = cell.getRichStringCellValue().getString();
				break;
			case XSSFCell.CELL_TYPE_NUMERIC:
				result = cell.getNumericCellValue();
				break;
			case XSSFCell.CELL_TYPE_FORMULA:
				result = cell.getNumericCellValue();
				break;
			case XSSFCell.CELL_TYPE_BOOLEAN:
				result = cell.getBooleanCellValue();
				break;
			case XSSFCell.CELL_TYPE_BLANK:
				result = null;
				break;
			case XSSFCell.CELL_TYPE_ERROR:
				result = null;
				break;
			default:
				System.out.println("枚举了所有类型");
				break;
			}
		}
		return result;
	}
	
	@SuppressWarnings({ "deprecation", "rawtypes" })
	public List getDatasInSheet(int sheetNumber)
	{
		List<List> result = new ArrayList<List>();

		// 获得指定的sheet
		HSSFSheet sheet = workbook2003.getSheetAt(sheetNumber);
		// 获得sheet总行数
		int rowCount = sheet.getLastRowNum();
		logger.info("found excel rows count:" + rowCount);
		if (rowCount < 1)
		{
			return result;
		}

		// 遍历行row
		for (int rowIndex = 0; rowIndex <= rowCount; rowIndex++)
		{
			// 获得行对象
			HSSFRow row = sheet.getRow(rowIndex);
			if (null != row)
			{
				List<Object> rowData = new ArrayList<Object>();
				// 获得本行中单元格的个数
				int cellCount = row.getLastCellNum();
				// 遍历列cell
				for (short cellIndex = 0; cellIndex < cellCount; cellIndex++)
				{
					HSSFCell cell = row.getCell(cellIndex);
					// 获得指定单元格中的数据
					Object cellStr = this.getCellString(cell);

					rowData.add(cellStr);
				}
				result.add(rowData);
			}
		}

		return result;
	}

	private Object getCellString(HSSFCell cell)
	{
		// TODO Auto-generated method stub
		Object result = null;
		if (cell != null)
		{
			// 单元格类型：Numeric:0,String:1,Formula:2,Blank:3,Boolean:4,Error:5
			int cellType = cell.getCellType();
			switch (cellType)
			{
			case HSSFCell.CELL_TYPE_STRING:
				result = cell.getRichStringCellValue().getString();
				break;
			case HSSFCell.CELL_TYPE_NUMERIC:
				result = cell.getNumericCellValue();
				break;
			case HSSFCell.CELL_TYPE_FORMULA:
				result = cell.getNumericCellValue();
				break;
			case HSSFCell.CELL_TYPE_BOOLEAN:
				result = cell.getBooleanCellValue();
				break;
			case HSSFCell.CELL_TYPE_BLANK:
				result = null;
				break;
			case HSSFCell.CELL_TYPE_ERROR:
				result = null;
				break;
			default:
				System.out.println("枚举了所有类型");
				break;
			}
		}
		return result;
	}
}
