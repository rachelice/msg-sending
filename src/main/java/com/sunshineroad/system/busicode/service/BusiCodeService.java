package com.sunshineroad.system.busicode.service;

import java.util.List;

import com.sunshineroad.system.busicode.vo.BusiCodeVo;

public interface BusiCodeService {

	public List<BusiCodeVo> getList(BusiCodeVo busicodeVo) throws Exception;

	public String checkFilePath(String scanPath) throws Exception;


}
