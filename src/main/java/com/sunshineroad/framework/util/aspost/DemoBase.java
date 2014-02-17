package com.sunshineroad.framework.util.aspost;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aspose.cells.Workbook;

/**
 * 自定义模板导出基类
 */
public abstract class DemoBase {

	protected abstract Workbook createReport(HttpServletRequest request) throws Exception;
	
	/**
	 * 设置HTTP响应头
	 * @param response 
	 * @param fileName
	 * @param formatSuffix
	 */
    protected void setResponseHeader(HttpServletResponse response, String fileName, String formatSuffix) {
        String contentType = "application/vnd.ms-excel";
        formatSuffix = formatSuffix.toLowerCase();
        if(formatSuffix.endsWith(".xlsx")
		        || formatSuffix.endsWith(".xlsb")
		        || formatSuffix.endsWith(".xlsm")
		        || formatSuffix.endsWith(".xltm")
		        || formatSuffix.endsWith(".xltx")) {
            contentType = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
        }
        response.setContentType(contentType);
        response.addHeader("content-disposition", "inline;filename=" + fileName);
    }
    
    /**
     * 向客户端返回excel
     * @param request
     * @param response
     * @param wb
     * @throws Exception
     */
    protected void sendReport(HttpServletRequest request,
			HttpServletResponse response, Workbook wb) throws Exception {
		wb.save(response.getOutputStream(), wb.getFileFormat());
	}
}
