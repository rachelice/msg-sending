package com.sunshineroad.framework.codegenerate.generate;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.Writer;
import java.net.URL;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;

import com.sunshineroad.framework.codegenerate.util.CodeResourceUtil;
import com.sunshineroad.framework.codegenerate.util.CodeStringUtils;

public class CodeFactory {
	private ICallBack callBack;

	public Configuration getConfiguration() throws IOException {
		Configuration cfg = new Configuration();
		String path = getTemplatePath();
		File templateDirFile = new File(path);
		cfg.setDirectoryForTemplateLoading(templateDirFile);
		cfg.setLocale(Locale.CHINA);
		cfg.setDefaultEncoding("UTF-8");
		return cfg;
	}

	public void generateFile(String templateFileName, String type, Map data) {
		try {
			String entityPackage = data.get("entityPackage").toString();
			String entityName = data.get("entityName").toString();
			String fileNamePath = getCodePath(type, entityPackage, entityName);
			System.out.println("fileNamePath="+fileNamePath);
			String fileDir = StringUtils.substringBeforeLast(fileNamePath, "/");
			System.out.println("fileDir="+fileDir);
			System.out.println("");
			Template template = getConfiguration()
					.getTemplate(templateFileName);
			FileUtils.forceMkdir(new File(fileDir + "/"));
			Writer out = new OutputStreamWriter(new FileOutputStream(
					fileNamePath), CodeResourceUtil.SYSTEM_ENCODING);
			template.process(data, out);
			out.close();
		} catch (TemplateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String getProjectPath() {
		String path = System.getProperty("user.dir").replace("\\", "/") + "/";
		return path;
	}

	public String getClassPath() {
		String path = Thread.currentThread().getContextClassLoader()
				.getResource("./").getPath();
		return path;
	}

	public static void main(String[] args) {
		System.out.println(getProjectPath());
	}

	public String getTemplatePath() {
		String path = getClassPath() + CodeResourceUtil.TEMPLATEPATH;
		return path;
	}

	public String getCodePath(String type, String entityPackage,
			String entityName) {
		String path = getProjectPath();
		StringBuilder str = new StringBuilder();
		if (StringUtils.isNotBlank(type)) {
			String codeType = ((CodeType) Enum.valueOf(CodeType.class, type))
					.getValue();
			str.append(path);
			if ("list".equalsIgnoreCase(type)) {
				str.append(CodeResourceUtil.LISTJSPATH);
				str.append(StringUtils.capitalize(entityName));
				str.append(StringUtils.capitalize(codeType));
				str.append(".js");
				
			}else 	if ("store".equalsIgnoreCase(type)) {
				
				str.append(CodeResourceUtil.STOREJSPATH);
				str.append(StringUtils.capitalize(entityName));
				str.append(StringUtils.capitalize(codeType));
				str.append(".js");
				
			}else	if ("window".equalsIgnoreCase(type)) {
				
				str.append(CodeResourceUtil.WINDOWJSPATH);
				str.append(StringUtils.capitalize(entityName));
				str.append(StringUtils.capitalize(codeType));
				str.append(".js");
				
			}else	if ("form".equalsIgnoreCase(type)) {
				
				str.append(CodeResourceUtil.FORMJSPATH);
				str.append(StringUtils.capitalize(entityName));
				str.append(StringUtils.capitalize(codeType));
				str.append(".js");
				
			}else			if ("model".equalsIgnoreCase(type)) {
				str.append(CodeResourceUtil.MODELJSPATH);
				str.append(StringUtils.capitalize(entityName));
				str.append(StringUtils.capitalize(type));
				str.append(".js");
			} else  //if (!("list".equals(type) || "model".equals(type) || "store".equals(type))) 
			{
				str.append(CodeResourceUtil.CODEPATH);
				 str.append("/");
				 str.append(StringUtils.lowerCase(entityPackage));
				 str.append("/");
			}
			if ("Action".equalsIgnoreCase(codeType))
				str.append(StringUtils.lowerCase("action"));
			else if ("ServiceImpl".equalsIgnoreCase(codeType))
				str.append(StringUtils.lowerCase("service/impl"));
			else if ("Service".equalsIgnoreCase(codeType))
				str.append(StringUtils.lowerCase("service"));

			else if ("DaoImpl".equalsIgnoreCase(codeType))
				str.append(StringUtils.lowerCase("dao/impl"));
			else if ("Dao".equalsIgnoreCase(codeType))
				str.append(StringUtils.lowerCase("dao"));
			
			else if (!("EntityH".equalsIgnoreCase(type)||
					"EntityM".equalsIgnoreCase(type)||"List".equalsIgnoreCase(codeType)||"window".equals(type)||"form".equals(type)||"store".equalsIgnoreCase(codeType)||"model".equalsIgnoreCase(codeType))) {
				str.append(StringUtils.lowerCase(codeType));
			}
			 if (!("EntityH".equalsIgnoreCase(type)||
						"EntityM".equalsIgnoreCase(type)||"list".equals(type) ||"window".equals(type)||"form".equals(type)|| "model".equals(type) || "store"
						.equals(type))) {
				
				 str.append("/");
				 
			 }

			if (("jsp".equals(type)) || ("jspList".equals(type))) {
				String jspName = StringUtils.capitalize(entityName);

				str.append(CodeStringUtils.getInitialSmall(jspName));
				str.append(codeType);
				str.append(".jsp");
			} else if (!("EntityH".equalsIgnoreCase(type)||
					"EntityM".equalsIgnoreCase(type)||"list".equals(type)||"window".equals(type)||"form".equals(type) || "model".equals(type) || "store".equals(type))) {
				
				 str.append("/");
				str.append(StringUtils.capitalize(entityName));
				if(!("Entity".equalsIgnoreCase(codeType)||"EntityVo".equalsIgnoreCase(codeType))){
					str.append(StringUtils.capitalize(codeType));
				}else if("EntityVo".equalsIgnoreCase(codeType)){
					str.append("Vo");
				}
				str.append(".java");
			}
			if("EntityH".equalsIgnoreCase(type)){
				str.append(StringUtils.lowerCase(entityName)+".h"); 

				//System.out.println(str+"========================");
				
			}
			if("EntityM".equalsIgnoreCase(type)){

				str.append(StringUtils.lowerCase(entityName)+".m"); 
				//System.out.println(str+"========================");
			}
			
		} else {
			throw new IllegalArgumentException("type is null");
		}
	
		return str.toString();
	}

	public void invoke(String templateFileName, String type) {
		Map data = new HashMap();
		data = this.callBack.execute();
		generateFile(templateFileName, type, data);
	}

	public ICallBack getCallBack() {
		return this.callBack;
	}

	public void setCallBack(ICallBack callBack) {
		this.callBack = callBack;
	}

	public static enum CodeType {
		serviceImpl("ServiceImpl"), 
		service("Service"), 
		daoImpl("DaoImpl"),
		dao("Dao"), 
		controller("Controller"),
		entity("Entity"), 
		entityVo("EntityVo"), 
		list("list"),
		store("store"), 
		window("window"),
		form("form"),
		model("model"),
		entityH("EntityH"),
		entityM("EntityM");
		private String type;

		private CodeType(String type) {
			this.type = type;
		}

		public String getValue() {
			return this.type;
		}
	}
}
