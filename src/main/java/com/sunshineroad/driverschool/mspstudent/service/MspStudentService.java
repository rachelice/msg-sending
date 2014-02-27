package com.sunshineroad.driverschool.mspstudent.service;

import java.util.List;
 
import java.util.Map;

import com.sunshineroad.driverschool.mspstudent.entity.MspStudent;
import com.sunshineroad.driverschool.mspstudent.entityvo.MspStudentVo;
import com.sunshineroad.framework.support.service.IBaseService;

public interface MspStudentService extends IBaseService<MspStudent, Integer>{
	public List<MspStudentVo> list(MspStudent entity) ;
	public List<MspStudentVo>  queryStudentByMap(Map filter);
	public List<MspStudentVo> showStudent();
}
