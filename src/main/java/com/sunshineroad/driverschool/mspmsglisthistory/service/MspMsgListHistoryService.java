package com.sunshineroad.driverschool.mspmsglisthistory.service;

import java.util.List;
 
import com.sunshineroad.driverschool.mspmsglisthistory.entity.MspMsgListHistory;
import com.sunshineroad.driverschool.mspmsglisthistory.entityvo.MspMsgListHistoryVo;
import com.sunshineroad.framework.support.service.IBaseService;

public interface MspMsgListHistoryService extends IBaseService<MspMsgListHistory, Integer>{
	public List<MspMsgListHistoryVo> list(MspMsgListHistory entity) ;
}
