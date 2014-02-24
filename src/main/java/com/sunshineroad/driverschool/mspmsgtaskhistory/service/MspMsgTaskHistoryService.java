package com.sunshineroad.driverschool.mspmsgtaskhistory.service;

import java.util.List;
 
import com.sunshineroad.driverschool.mspmsgtaskhistory.entity.MspMsgTaskHistory;
import com.sunshineroad.driverschool.mspmsgtaskhistory.entityvo.MspMsgTaskHistoryVo;
import com.sunshineroad.framework.support.service.IBaseService;

public interface MspMsgTaskHistoryService extends IBaseService<MspMsgTaskHistory, Integer>{
	public List<MspMsgTaskHistoryVo> list(MspMsgTaskHistory entity) ;
}
