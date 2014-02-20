package com.sunshineroad.driverschool.mspstudent.service;

import java.util.List;
 
import com.sunshineroad.driverschool.mspstudent.entity.MspStudent;
import com.sunshineroad.driverschool.mspstudent.entityvo.MspStudentVo;
import com.sunshineroad.framework.support.service.IBaseService;

public interface MspStudentService extends IBaseService<MspStudent, Integer>{
	public List<MspStudentVo> list(MspStudent entity) ;
}
