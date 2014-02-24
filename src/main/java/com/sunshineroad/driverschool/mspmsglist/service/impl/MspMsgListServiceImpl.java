package com.sunshineroad.driverschool.mspmsglist.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import   com.sunshineroad.driverschool.mspmsglist.service.MspMsgListService;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sunshineroad.driverschool.mspmsglist.dao.MspMsgListDao;
import com.sunshineroad.driverschool.mspmsglist.entity.MspMsgList;
import com.sunshineroad.driverschool.mspmsglist.entityvo.MspMsgListVo;
import com.sunshineroad.framework.support.matchrule.HQLParameter;

import com.sunshineroad.framework.support.service.impl.BaseServiceImpl;


import java.util.List;
import com.sunshineroad.framework.util.ListUtils;

@Service("mspMsgListService")
@Transactional
public class MspMsgListServiceImpl extends BaseServiceImpl<MspMsgList, Integer>  implements MspMsgListService {
	@Autowired
	private MspMsgListDao  mspMsgListDao;

	public List<MspMsgListVo> list(MspMsgList entity) {
		HQLParameter p = new HQLParameter(MspMsgList.class);	   
		return ListUtils.transform(mspMsgListDao.findPageByHql(" from MspMsgList "   ),
				MspMsgListVo.class);
	}
	
		@Override
	public void update(MspMsgList model)  {
		this.mspMsgListDao.update(model);	
	}
	
	@Override
	public MspMsgList save(MspMsgList model)   {
		this.mspMsgListDao.save(model);	
		return model;
	}

	@Override
	public void delete(MspMsgList model)  {
		this.mspMsgListDao.delete(model);	
	}
}


