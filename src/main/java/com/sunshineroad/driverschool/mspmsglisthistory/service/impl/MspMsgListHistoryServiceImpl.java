package com.sunshineroad.driverschool.mspmsglisthistory.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import   com.sunshineroad.driverschool.mspmsglisthistory.service.MspMsgListHistoryService;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sunshineroad.driverschool.mspmsglisthistory.dao.MspMsgListHistoryDao;
import com.sunshineroad.driverschool.mspmsglisthistory.entity.MspMsgListHistory;
import com.sunshineroad.driverschool.mspmsglisthistory.entityvo.MspMsgListHistoryVo;
import com.sunshineroad.framework.support.matchrule.HQLParameter;

import com.sunshineroad.framework.support.service.impl.BaseServiceImpl;


import java.util.List;
import com.sunshineroad.framework.util.ListUtils;

@Service("mspMsgListHistoryService")
@Transactional
public class MspMsgListHistoryServiceImpl extends BaseServiceImpl<MspMsgListHistory, Integer>  implements MspMsgListHistoryService {
	@Autowired
	private MspMsgListHistoryDao  mspMsgListHistoryDao;

	public List<MspMsgListHistoryVo> list(MspMsgListHistory entity) {
		HQLParameter p = new HQLParameter(MspMsgListHistory.class);	   
		return ListUtils.transform(mspMsgListHistoryDao.findPageByHql(" from MspMsgListHistory "   ),
				MspMsgListHistoryVo.class);
	}
	
		@Override
	public void update(MspMsgListHistory model)  {
		this.mspMsgListHistoryDao.update(model);	
	}
	
	@Override
	public MspMsgListHistory save(MspMsgListHistory model)   {
		this.mspMsgListHistoryDao.save(model);	
		return model;
	}

	@Override
	public void delete(MspMsgListHistory model)  {
		this.mspMsgListHistoryDao.delete(model);	
	}
}


