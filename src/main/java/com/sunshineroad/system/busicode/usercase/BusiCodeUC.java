package com.sunshineroad.system.busicode.usercase;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import org.apache.log4j.Logger;
import com.sunshineroad.framework.util.ResponseUtils;
import com.sunshineroad.system.actionlog.service.ActionlogService;
import com.sunshineroad.system.busicode.service.BusiCodeService;
import com.sunshineroad.system.busicode.vo.BusiCodeVo;

public class BusiCodeUC
{
	private static final Logger logger = Logger.getLogger(BusiCodeUC.class);

	public Object genBusiCode(BusiCodeService busicodeService , 
			ActionlogService actionlogService, BusiCodeVo busicodeVo) throws Exception
	{
		String path = "/app/weblogic/wars/src/";
		String dirname = busicodeVo.getBusinessname().toLowerCase();
		String filenamezip = dirname + ".zip";
		boolean success = false;

		try
		{
			Process process = Runtime.getRuntime().exec ("sh "+path+"busicode.sh "+ 
								busicodeVo.getBusinessname()+" "+busicodeVo.getBusinesstype());
			InputStreamReader ir=new InputStreamReader(process.getInputStream());
			LineNumberReader input = new LineNumberReader (ir);
			String line=null;
			
			while ((line = input.readLine ()) != null){
				if(line.equalsIgnoreCase("ok")){
					success = true;
					break;
				}
			}
		}
		catch (IOException e){
			System.err.println ("IOException " + e.getMessage());
		}

		if(success){
			String scanPath = "download/BusiCode/";
			String scanFolderPath = busicodeService.checkFilePath(scanPath);

			Runtime.getRuntime().exec ("mv "+path+filenamezip +" "+scanFolderPath);
			return ResponseUtils.sendSuccess(scanPath + filenamezip);
		}else{
			return ResponseUtils.sendFailure("代码生成失败！");
		}

	}
}
