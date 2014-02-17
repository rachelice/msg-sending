package org.activiti.sit.dao;

import org.activiti.sit.entity.oa.Leave;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

/**
 * 请假实体管理接口
 *
 * @your name
 */
@Component
public interface LeaveDao extends CrudRepository<Leave, Long> {
}
