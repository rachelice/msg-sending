package com.sunshineroad.driverschool.mspmsgtask.service;

import java.util.List;
 
import com.sunshineroad.driverschool.mspmsgtask.entity.MspMsgTask;
import com.sunshineroad.driverschool.mspmsgtask.entityvo.MspMsgTaskVo;
import com.sunshineroad.framework.support.service.IBaseService;

public interface MspMsgTaskService extends IBaseService<MspMsgTask, Integer>{
	public List<MspMsgTaskVo> list(MspMsgTask entity) ;
}
