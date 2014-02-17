package org.activiti.sit.service.oa.leave;

import java.util.Date;

import org.activiti.sit.dao.LeaveDao;
import org.activiti.sit.entity.oa.Leave;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * 请假实体管理
 *
 * @your name
 */
@Component
@Transactional(readOnly = true)
public class LeaveManager {

	private LeaveDao leaveDao;

	public Leave getLeave(Long id) {
		return leaveDao.findOne(id);
	}

	@Transactional(readOnly = false)
	public void saveLeave(Leave entity) {
		if (entity.getId() == null) {
			entity.setApplyTime(new Date());
		}
		leaveDao.save(entity);
	}

	@Autowired
	public void setLeaveDao(LeaveDao leaveDao) {
		this.leaveDao = leaveDao;
	}

}
