package com.sunshineroad.driverschool.mspmsglist.service;

import java.util.List;
 
import com.sunshineroad.driverschool.mspmsglist.entity.MspMsgList;
import com.sunshineroad.driverschool.mspmsglist.entityvo.MspMsgListVo;
import com.sunshineroad.framework.support.service.IBaseService;

public interface MspMsgListService extends IBaseService<MspMsgList, Integer>{
	public List<MspMsgListVo> list(MspMsgList entity) ;
}
