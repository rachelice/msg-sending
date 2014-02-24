package com.sunshineroad.driverschool.mspmsgtaskhistory.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import   com.sunshineroad.driverschool.mspmsgtaskhistory.service.MspMsgTaskHistoryService;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sunshineroad.driverschool.mspmsgtaskhistory.dao.MspMsgTaskHistoryDao;
import com.sunshineroad.driverschool.mspmsgtaskhistory.entity.MspMsgTaskHistory;
import com.sunshineroad.driverschool.mspmsgtaskhistory.entityvo.MspMsgTaskHistoryVo;
import com.sunshineroad.framework.support.matchrule.HQLParameter;

import com.sunshineroad.framework.support.service.impl.BaseServiceImpl;


import java.util.List;
import com.sunshineroad.framework.util.ListUtils;

@Service("mspMsgTaskHistoryService")
@Transactional
public class MspMsgTaskHistoryServiceImpl extends BaseServiceImpl<MspMsgTaskHistory, Integer>  implements MspMsgTaskHistoryService {
	@Autowired
	private MspMsgTaskHistoryDao  mspMsgTaskHistoryDao;

	public List<MspMsgTaskHistoryVo> list(MspMsgTaskHistory entity) {
		HQLParameter p = new HQLParameter(MspMsgTaskHistory.class);	   
		return ListUtils.transform(mspMsgTaskHistoryDao.findPageByHql(" from MspMsgTaskHistory "   ),
				MspMsgTaskHistoryVo.class);
	}
	
		@Override
	public void update(MspMsgTaskHistory model)  {
		this.mspMsgTaskHistoryDao.update(model);	
	}
	
	@Override
	public MspMsgTaskHistory save(MspMsgTaskHistory model)   {
		this.mspMsgTaskHistoryDao.save(model);	
		return model;
	}

	@Override
	public void delete(MspMsgTaskHistory model)  {
		this.mspMsgTaskHistoryDao.delete(model);	
	}
}


