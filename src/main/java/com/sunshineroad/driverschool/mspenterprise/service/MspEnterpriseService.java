package com.sunshineroad.driverschool.mspenterprise.service;

import java.util.List;
 
import com.sunshineroad.driverschool.mspenterprise.entity.MspEnterprise;
import com.sunshineroad.driverschool.mspenterprise.entityvo.MspEnterpriseVo;
import com.sunshineroad.framework.support.service.IBaseService;

public interface MspEnterpriseService extends IBaseService<MspEnterprise, Integer>{
	public List<MspEnterpriseVo> list(MspEnterprise entity) ;
}
