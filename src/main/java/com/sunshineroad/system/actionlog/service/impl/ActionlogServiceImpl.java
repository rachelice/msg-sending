package com.sunshineroad.system.actionlog.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.sunshineroad.framework.util.DateUtils;
import com.sunshineroad.system.actionlog.dao.ActionlogDao;
import com.sunshineroad.system.actionlog.entity.Actionlog;
import com.sunshineroad.system.actionlog.service.ActionlogService;
import com.sunshineroad.system.actionlog.vo.ActionlogVo;

/**
 * omplatform com.sunshineroad.system.actionlog.service.impl
 * 
 * @{# ActionlogServiceImpl.java Create on 2013-6-13 上午4:36:05
 * 
 *     Copyright (c) 2013 by 阳光道路.
 * @author <a href="mailto:371917461@qq.com">张光明</a>
 * @version 1.0 功能说明：用户操作历史记录处理
 * 
 */
@Service("actionlogService")
public class ActionlogServiceImpl implements ActionlogService
{

	protected Log logger = LogFactory.getLog(this.getClass());

	@Autowired
	protected ActionlogDao<Actionlog, Integer> alogDao;

	public ActionlogDao<Actionlog, Integer> getActionlogDao()
	{
		return this.alogDao;
	}

	@Override
	public List<ActionlogVo> list(ActionlogVo actvo) throws Exception
	{
		List<Actionlog> modelList;
		String hql;
		hql = "from Actionlog where user_id like ? and " + "action like ? ";
		if (actvo.getUser_id() != null || actvo.getAction() != null
				|| actvo.getOccurdate() != null || actvo.getStatus() != null)
		{
			String user_id = actvo.getUser_id();
			if (user_id == null)
			{
				user_id = "%";
			}
			String action = actvo.getAction();
			if (action == null)
			{
				action = "%";
			}
			String result = actvo.getStatus();
			if (result != null)
			{
				hql += " and status = ? ";
			}
			if (actvo.getOccurdate() != null)
			{
				Date startdate = actvo.getOccurdate();
				Date enddate = DateUtils.addDayD(startdate, 1, "d");

				System.out.println("StartDate: " + startdate);
				System.out.println("EndDate: " + enddate);

				hql += " and occurdate >= ? and occurdate < ?";
				if (result != null)
				{
					modelList = alogDao.findPageByHql(hql, user_id, action,
							result, startdate, enddate);
				} else
				{
					modelList = alogDao.findPageByHql(hql, user_id, action,
							startdate, enddate);
				}
			} else
			{
				if (result != null)
				{
					modelList = alogDao.findPageByHql(hql, user_id, action,
							result);
				} else
				{
					modelList = alogDao.findPageByHql(hql, user_id, action);
				}
			}
		} else
		{
			modelList = alogDao.findPageByHql(" from Actionlog ");
		}
		List<ActionlogVo> nodeList = new ArrayList<ActionlogVo>();
		for (Actionlog model : modelList)
		{
			ActionlogVo node = new ActionlogVo();
			node.setId(model.getId());
			node.setAction(model.getAction());
			node.setOccurdate(model.getOccurdate());
			node.setStatus(model.getStatus());
			node.setComments(model.getComments());
			node.setUser_id(model.getUser_id());
			nodeList.add(node);
		}
		return nodeList;
	}

	@Override
	public void update(Actionlog alog) throws Exception
	{
		alogDao.update(alog);
	}

	@Override
	public Integer save(Actionlog alog) throws Exception
	{
		return alogDao.save(alog);
	}

	@Override
	public void delete(Actionlog alog) throws Exception
	{
		alogDao.delete(alog);
	}

	@Override
	public String getSelfLoginName()
	{
		UserDetails userDetails = (UserDetails) SecurityContextHolder
				.getContext().getAuthentication().getPrincipal();
		return userDetails.getUsername();
	}

	@Override
	public Integer saveAlog(String user, String actDesc, boolean status,
			String comments) throws Exception
	{
		Date occurdate = new Date();
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		Actionlog alog = new Actionlog();
		if (status)
		{
			alog.setStatus("S");
		} else
		{
			alog.setStatus("F");
		}
		if (user == null)
		{
			alog.setUser_id(this.getSelfLoginName());
		} else if (user.trim() == "")
		{
			alog.setUser_id(this.getSelfLoginName());
		} else
		{
			alog.setUser_id(user);
		}
		alog.setAction(actDesc);
		alog.setComments(comments);
		alog.setOccurdate(occurdate);
		alog.setTimestamp(timestamp);
		return alogDao.save(alog);

	}

}
