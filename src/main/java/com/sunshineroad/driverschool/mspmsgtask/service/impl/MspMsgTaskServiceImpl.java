package com.sunshineroad.driverschool.mspmsgtask.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import   com.sunshineroad.driverschool.mspmsgtask.service.MspMsgTaskService;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sunshineroad.driverschool.mspmsgtask.dao.MspMsgTaskDao;
import com.sunshineroad.driverschool.mspmsgtask.entity.MspMsgTask;
import com.sunshineroad.driverschool.mspmsgtask.entityvo.MspMsgTaskVo;
import com.sunshineroad.framework.support.matchrule.HQLParameter;

import com.sunshineroad.framework.support.service.impl.BaseServiceImpl;


import java.util.List;
import com.sunshineroad.framework.util.ListUtils;

@Service("mspMsgTaskService")
@Transactional
public class MspMsgTaskServiceImpl extends BaseServiceImpl<MspMsgTask, Integer>  implements MspMsgTaskService {
	@Autowired
	private MspMsgTaskDao  mspMsgTaskDao;

	public List<MspMsgTaskVo> list(MspMsgTask entity) {
		HQLParameter p = new HQLParameter(MspMsgTask.class);	   
		return ListUtils.transform(mspMsgTaskDao.findPageByHql(" from MspMsgTask "   ),
				MspMsgTaskVo.class);
	}
	
		@Override
	public void update(MspMsgTask model)  {
		this.mspMsgTaskDao.update(model);	
	}
	
	@Override
	public MspMsgTask save(MspMsgTask model)   {
		this.mspMsgTaskDao.save(model);	
		return model;
	}

	@Override
	public void delete(MspMsgTask model)  {
		this.mspMsgTaskDao.delete(model);	
	}
}


