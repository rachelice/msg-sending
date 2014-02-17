package com.sunshineroad.framework.util.aspost;


import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aspose.cells.Workbook;
import com.aspose.cells.WorkbookDesigner;

/**
 * 根据自定义的Excel模板进行导出 
 */
@Controller
@RequestMapping(value="toExcel")
public class SmartMarkerController extends DemoBase {
	
	//存放Excel模板的位置
	public  String TEMPLATE_FILE_PATH_PART = "/WEB-INF/classes/resources/xlsTemplate/SmartMarkerDesigner1.xls";
    
	/**  
	 * 对客户端开发的方法
	 */

	 @RequestMapping(value="getReport",method=RequestMethod.GET)
	public Object getReport(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			//创建工作薄
			Workbook wb = createReport(request);
			//设置输出响应头
            setResponseHeader(response, "SmartMarker.xls", ".xlsx");
            //向客户端输出
            sendReport(request, response, wb);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 向自定义模板中填充数据
	 */
	protected Workbook createReport(HttpServletRequest request) throws Exception {
		
		ServletContext sc = request.getSession().getServletContext();
        String template_file_path = sc.getRealPath(TEMPLATE_FILE_PATH_PART);
        System.out.println(template_file_path);
        //创建工作薄加载模板(SmartMarkerDesigner.xls)
		Workbook wb = new Workbook(template_file_path);
		createSmart(wb);
		
		return wb;
	}
	
	private static void createSmart(Workbook wb) throws Exception {
		WorkbookDesigner designer = new WorkbookDesigner();
		designer.setWorkbook(wb);
		designer.setDataSource("Person", InitData.getPersons());
		//这个框架默认不支持HashMap(查了好多资料都没找到直接支持的方法)
		//所以我实现了ICellsDataTable接口 使其可以支持HashMap
		designer.setDataSource("Map", new HashMapDataTable(InitData.getHashMap()));
		designer.process(true);
	}
	
}
