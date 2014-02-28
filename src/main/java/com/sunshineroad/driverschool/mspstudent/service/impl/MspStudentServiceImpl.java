package com.sunshineroad.driverschool.mspstudent.service.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import   com.sunshineroad.driverschool.mspstudent.service.MspStudentService;
 





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunshineroad.driverschool.mspstudent.dao.MspStudentDao;
import com.sunshineroad.driverschool.mspstudent.entity.MspStudent;
import com.sunshineroad.driverschool.mspstudent.entityvo.MspStudentVo;
import com.sunshineroad.framework.support.matchrule.HQLParameter;
import com.sunshineroad.framework.support.service.impl.BaseServiceImpl;







import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sunshineroad.framework.util.ListUtils;

@Service("mspStudentService")
@Transactional
public class MspStudentServiceImpl extends BaseServiceImpl<MspStudent, Integer>  implements MspStudentService {
	@Autowired
	private MspStudentDao  mspStudentDao;
	protected SessionFactory sessionFactory;

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public List<MspStudentVo> list(MspStudent entity) {
		HQLParameter p = new HQLParameter(MspStudent.class);	   
		return ListUtils.transform(mspStudentDao.findPageByHql(" from MspStudent "   ),
				MspStudentVo.class);
	}
	
		@Override
	public void update(MspStudent model)  {
		this.mspStudentDao.update(model);	
	}
	
	@Override
	public MspStudent save(MspStudent model)   {
		this.mspStudentDao.save(model);	
		return model;
	}

	@Override
	public void delete(MspStudent model)  {
		this.mspStudentDao.delete(model);	
	}
	
	@Override
	public List<MspStudentVo>  queryStudentByMap(Map filter) {
		String licenseCode="";
		String learnerName="";
		String mobileNum="";
		if( filter.get("licenseCode") != null && !"".equals( filter.get( "licenseCode" ))){
			licenseCode = filter.get("licenseCode").toString();
			licenseCode = "and t.licenseCode like :licenseCode ";
		}
		if( filter.get("learnerName") != null && !"".equals( filter.get( "learnerName" ))){
			learnerName = filter.get("learnerName").toString();
			learnerName = "and t.learnerName like :learnerName ";
		}
		if( filter.get("mobileNum") != null && !"".equals( filter.get( "mobileNum" ))){
			mobileNum = filter.get("mobileNum").toString();
			mobileNum = "and t.mobileNum like :mobileNum ";
		}
		Query query = getSession().createQuery( "select t.id, t.learnerName, t.mobileNum from MspStudent where 1=1 " + licenseCode + learnerName + mobileNum
                ).setCacheable( false );
		if( filter.get( "licenseCode" )!= null && !"".equals( filter.get( "licenseCode" ) ) ){
            query.setParameter( "licenseCode", "%" + filter.get( "licenseCode" ).toString() + "%");
        }
		if( filter.get( "learnerName" )!= null && !"".equals( filter.get( "learnerName" ) ) ){
            query.setParameter( "learnerName", "%" + filter.get( "learnerName" ).toString() + "%");
        }
		if( filter.get( "mobileNum" )!= null && !"".equals( filter.get( "mobileNum" ) ) ){
            query.setParameter( "mobileNum", "%" + filter.get( "mobileNum" ).toString() + "%");
        }
		return query.list();
	}
	
	@Override
	public List<MspStudentVo> showStudent() {
		StringBuffer hql= new StringBuffer(" FROM MspStudent  WHERE 1=1");
		return ListUtils.transform(mspStudentDao.findPageByHql(" from MspStudent where learnerName like '%晓%' " ),
				MspStudentVo.class);
	}
}


