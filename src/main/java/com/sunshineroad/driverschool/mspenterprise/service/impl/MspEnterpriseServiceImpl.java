package com.sunshineroad.driverschool.mspenterprise.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import   com.sunshineroad.driverschool.mspenterprise.service.MspEnterpriseService;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sunshineroad.driverschool.mspenterprise.dao.MspEnterpriseDao;
import com.sunshineroad.driverschool.mspenterprise.entity.MspEnterprise;
import com.sunshineroad.driverschool.mspenterprise.entityvo.MspEnterpriseVo;
import com.sunshineroad.framework.support.matchrule.HQLParameter;

import com.sunshineroad.framework.support.service.impl.BaseServiceImpl;


import java.util.List;
import com.sunshineroad.framework.util.ListUtils;

@Service("mspEnterpriseService")
@Transactional
public class MspEnterpriseServiceImpl extends BaseServiceImpl<MspEnterprise, Integer>  implements MspEnterpriseService {
	@Autowired
	private MspEnterpriseDao  mspEnterpriseDao;

	public List<MspEnterpriseVo> list(MspEnterprise entity) {
		HQLParameter p = new HQLParameter(MspEnterprise.class);	   
		return ListUtils.transform(mspEnterpriseDao.findPageByHql(" from MspEnterprise "   ),
				MspEnterpriseVo.class);
	}
	
		@Override
	public void update(MspEnterprise model)  {
		this.mspEnterpriseDao.update(model);	
	}
	
	@Override
	public MspEnterprise save(MspEnterprise model)   {
		this.mspEnterpriseDao.save(model);	
		return model;
	}

	@Override
	public void delete(MspEnterprise model)  {
		this.mspEnterpriseDao.delete(model);	
	}
}


