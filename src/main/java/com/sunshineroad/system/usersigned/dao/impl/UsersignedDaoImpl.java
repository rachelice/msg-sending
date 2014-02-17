package com.sunshineroad.system.usersigned.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.sunshineroad.framework.support.dao.hibernate.impl.HibernateDaoSupport;
import com.sunshineroad.system.usersigned.dao.UsersignedDao;
import com.sunshineroad.system.usersigned.entity.Usersigned;

@Repository("usersignedDao")
public class UsersignedDaoImpl extends HibernateDaoSupport<Usersigned, Integer> implements UsersignedDao<Usersigned, Integer> {

    @Resource(name="sessionFactory_system")
    public void setSessionFactory(SessionFactory sessionFactory){
    	super.sessionFactory = sessionFactory;
    }
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Usersigned> findAll() {
		// TODO Auto-generated method stub
		Criteria cri = this.getSession().createCriteria(Usersigned.class);

		List<Usersigned> list =  cri.list();
		if(list!=null&&list.size()>0){
			return list;
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Usersigned findSigned(String loginName,String occurday,String flag) {
		Criteria cri = this.getSession().createCriteria(Usersigned.class);

		Criterion cron_userid = Restrictions.eq("user_id",loginName);
		cri.add(cron_userid);
		Criterion cron_date = Restrictions.eq("occurday",occurday);
		cri.add(cron_date);
		Criterion cron_flag = Restrictions.eq("flag",flag);
		cri.add(cron_flag);		

		 
		List<Usersigned> list =  cri.list();
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}
}
