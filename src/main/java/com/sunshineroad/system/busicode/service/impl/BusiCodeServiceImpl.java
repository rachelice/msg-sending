package com.sunshineroad.system.busicode.service.impl;

import java.io.File;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sunshineroad.system.busicode.dao.BusiCodeDao;
import com.sunshineroad.system.busicode.service.BusiCodeService;
import com.sunshineroad.system.busicode.vo.BusiCodeVo;

@Service("busicodeService")
public class BusiCodeServiceImpl implements BusiCodeService {

	protected Log logger = LogFactory.getLog(this.getClass());
	
	@Autowired
	protected BusiCodeDao<BusiCodeVo, Integer> busicodeDao;

	@Override
	public List<BusiCodeVo> getList(BusiCodeVo busicodeVo) throws Exception
	{

		return null;
	}
	
	@Override
	public String checkFilePath(String scanPath) throws Exception{
		String path = this.getClass().getProtectionDomain()
				.getCodeSource().getLocation().getPath();

		String scanFolderPath;
		if (path.indexOf("WEB-INF") > 0)
		{
			scanFolderPath = path.substring(0, path.indexOf("WEB-INF"))
					+ scanPath;
		} else
		{
			throw new IllegalAccessException("路径获取错误");
		}
		
		File newFile = new File(scanFolderPath);
		if (!newFile.exists())
		{
			newFile.mkdirs();
		}
		
		return scanFolderPath;
		
	}

}
