package com.sunshineroad.framework.codegenerate.util;

import java.util.ResourceBundle;

public class CodeResourceUtil {
	private static final ResourceBundle bundle = ResourceBundle
			.getBundle("resources//freemarker//sit_database");
	private static final ResourceBundle bundlePath = ResourceBundle
			.getBundle("resources//freemarker//freemarker_config");

	public static String DIVER_NAME = "com.mysql.jdbc.Driver";

	public static String URL = "jdbc:mysql://localhost:3306/jxcia?useUnicode=true&characterEncoding=UTF-8";

	public static String USERNAME = "root";

	public static String PASSWORD = "123";

	public static String DATABASE_NAME = "jxcia";
  
	public static String DATABASE_TYPE = "mysql";

	public static String SIT_UI_FIELD_REQUIRED_NUM = "4";

	public static String SIT_UI_FIELD_SEARCH_NUM = "3";

	public static String web_root_package = "WebRoot";

	public static String source_root_package = "src";

	public static String bussiPackage = "sun";

	public static String entity_package = "entity";
	public static String entityVo_package = "entityVo";

	public static String page_package = "page";

	public static boolean SIT_FILED_CONVERT = true;
	public static String ENTITY_URL;
	public static String ENTITYVO_URL;
	public static String PAGE_URL;
	public static String ENTITY_URL_INX;
	public static String PAGE_URL_INX;
	public static String TEMPLATEPATH;
	public static String CODEPATH;
	public static String JSPPATH;
	public static String LISTJSPATH;
	public static String WINDOWJSPATH;
	public static String FORMJSPATH;
	public static String MODELJSPATH;
	public static String STOREJSPATH;
	public static String SIT_GENERATE_TABLE_ID;
	public static String SIT_GENERATE_UI_FILTER_FIELDS;
	public static String SYSTEM_ENCODING;

	static {
		DIVER_NAME = getDIVER_NAME();
		URL = getURL();

		USERNAME = getUSERNAME();
		PASSWORD = getPASSWORD();
		DATABASE_NAME = getDATABASE_NAME();

		SIT_FILED_CONVERT = getSIT_FILED_CONVERT();

		SYSTEM_ENCODING = getSYSTEM_ENCODING();
		TEMPLATEPATH = getTEMPLATEPATH();
		source_root_package = getSourceRootPackage();
		web_root_package = getWebRootPackage();
		bussiPackage = getBussiPackage();

		SIT_GENERATE_TABLE_ID = getJeecg_generate_table_id();

		SIT_UI_FIELD_SEARCH_NUM = getJeecg_ui_search_filed_num();

		if ((URL.indexOf("mysql") >= 0) || (URL.indexOf("MYSQL") >= 0))
			DATABASE_TYPE = "mysql";
		else if ((URL.indexOf("oracle") >= 0) || (URL.indexOf("ORACLE") >= 0))
			DATABASE_TYPE = "oracle";
		else if ((URL.indexOf("postgresql") >= 0)
				|| (URL.indexOf("POSTGRESQL") >= 0)) {
			DATABASE_TYPE = "postgresql";
		}

		source_root_package = source_root_package.replace(".", "/");
		web_root_package = web_root_package.replace(".", "/");
		String bussiPackageUrl = bussiPackage.replace(".", "/");

		ENTITY_URL = source_root_package + "/" + bussiPackageUrl + "/"
				+ entity_package + "/";
		ENTITYVO_URL = source_root_package + "/" + bussiPackageUrl + "/"
				+ entity_package + "/";

		PAGE_URL = source_root_package + "/" + bussiPackageUrl + "/"
				+ page_package + "/";

		ENTITY_URL_INX = entity_package  + "." +  bussiPackage+ ".";
		System.out.println("ENTITY_URL_INX=" + ENTITY_URL_INX);

		PAGE_URL_INX = bussiPackage + "." + page_package + ".";

		CODEPATH = source_root_package + "/" + bussiPackageUrl + "/";
	 

		JSPPATH = web_root_package + "/" + "webpage" + "/" + bussiPackageUrl
				+ "/";
		MODELJSPATH = web_root_package + "/" + "module/model/";
		LISTJSPATH = web_root_package + "/" + "module/view" + "/";
		STOREJSPATH = web_root_package + "/" + "module/store" + "/";
		WINDOWJSPATH = web_root_package + "/" + "module/view" + "/";
		FORMJSPATH = web_root_package + "/" + "module/view" + "/";
		 
	}

	private void ResourceUtil() {
	}

	public static final String getDIVER_NAME() {
		
		System.out.println("diver_name----------------------------");
		return bundle.getString("diver_name");
	}

	public static final String getURL() {
		return bundle.getString("url");
	}

	public static final String getUSERNAME() {
		return bundle.getString("username");
	}

	public static final String getPASSWORD() {
		return bundle.getString("password");
	}

	public static final String getDATABASE_NAME() {
		return bundle.getString("database_name");
	}

	public static final boolean getSIT_FILED_CONVERT() {
		String s = bundlePath.getString("sit_filed_convert");

		return !s.toString().equals("false");
	}

	private static String getBussiPackage() {
		return bundlePath.getString("bussi_package");
	}

	public static final String getEntityPackage() {
		return bundlePath.getString("entity_package");
	}

	public static final String getPagePackage() {
		return bundlePath.getString("page_package");
	}

	public static final String getTEMPLATEPATH() {
		return bundlePath.getString("templatepath");
	}

	public static final String getSourceRootPackage() {
		return bundlePath.getString("source_root_package");
	}

	public static final String getWebRootPackage() {
		return bundlePath.getString("webroot_package");
	}

	public static final String getSYSTEM_ENCODING() {
		return bundlePath.getString("system_encoding");
	}

	public static final String getJeecg_generate_table_id() {
		return bundlePath.getString("sit_generate_table_id");
	}

	public static final String getJeecg_generate_ui_filter_fields() {
		return bundlePath.getString("sit_generate_ui_filter_fields");
	}

	public static final String getJeecg_ui_search_filed_num() {
		return bundlePath.getString("sit_ui_search_filed_num");
	}

	public static final String getJeecg_ui_field_required_num() {
		return bundlePath.getString("sit_ui_field_required_num");
	}
}
