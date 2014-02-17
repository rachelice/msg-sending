package com.sunshineroad.system.dept.service.impl;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sunshineroad.framework.support.matchrule.HQLParameter;
import com.sunshineroad.framework.util.ListUtils;
import com.sunshineroad.system.dept.dao.DeptDao;
import com.sunshineroad.system.dept.entity.Dept;
import com.sunshineroad.system.dept.service.DeptService;
import com.sunshineroad.system.dept.vo.DeptVo;


@Service("deptServiceImpl")
public class DeptServiceImpl implements DeptService {

	@Autowired
	private DeptDao<Dept, Integer> deptDao;

	public List<DeptVo> list(Integer id) {
		HQLParameter p = new HQLParameter(Dept.class);
		System.out.println(p);
		return ListUtils.transform(deptDao.findPageByHql(" from Dept  WHERE  parentId=?",id),
				DeptVo.class);
	}

	@Override
	public void update(Dept dept) throws Exception {
		deptDao.update(dept);
	}

	@Override
	public Integer save(Dept dept) throws Exception {
		return deptDao.save(dept);
	}

	@Override
	public void delete(Dept dept) throws Exception {
		deptDao.delete(dept);
	}

	@Override
	public List<DeptVo> getRoot() {
		return	 ListUtils.transform(deptDao.findByHQL(" from Dept "),
					DeptVo.class);
	}

	@Override
	public Dept getDeptById(Integer id) throws Exception {
		List<Dept>list=deptDao.findByHQL(" from Dept  where id=?",id);
		if(null==list||list.size()==0){
			return null;
		}else{
			return list.get(0);					
		}
	}

	@Override
	public List<Dept> getDeptBypId(Integer pid) throws Exception {
		return deptDao.findByHQL(" from Dept  where parentId=?",pid);
	}

	@Override
	public List<Dept> listByIds(Integer[] ids) {
		if(ids==null||ids.length==0){
			return null; 
		}
		return 	deptDao.findByIdsForHql(" from Dept  where id in ?",ids);
				
		
	}
}
