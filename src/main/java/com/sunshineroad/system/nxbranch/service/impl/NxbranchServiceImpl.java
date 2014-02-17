package com.sunshineroad.system.nxbranch.service.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunshineroad.framework.support.matchrule.HQLParameter;
import com.sunshineroad.framework.util.ListUtils;
import com.sunshineroad.system.nxbranch.dao.NxbranchDao;
import com.sunshineroad.system.nxbranch.entity.Nxbranch;
import com.sunshineroad.system.nxbranch.service.NxbranchService;
import com.sunshineroad.system.nxbranch.vo.NxbranchVo;

/**
 * omplatform
 * com.sunshineroad.system.nxbranch.service.impl
 * @{#} NxbranchServiceImpl.java Create on  2013-6-13 上午9:38:46
 * 
 * Copyright (c) 2013 by 阳光道路.
 * @author <a href="mailto:xxxxxx">xxxxxx</a>
 * @version 1.0
 * 功能说明：农信机构列表
 *
 */

@Service("NxbranchService")
public class NxbranchServiceImpl implements NxbranchService {

	protected Log logger = LogFactory.getLog(this.getClass());
	
	@Autowired
	protected NxbranchDao<Nxbranch, Integer> nxBranchDao;
	
	public NxbranchDao<Nxbranch, Integer> getNxbranchDao(){
		return this.nxBranchDao;
	}

	public List<NxbranchVo> list() {
		HQLParameter p = new HQLParameter(Nxbranch.class);
		System.out.println(p);
		return ListUtils.transform(nxBranchDao.findPageByHql(" from Nxbranch "),
				NxbranchVo.class);
	}
	
	@Override
	public List<NxbranchVo> getRoot(String query) {
		System.out.println(query);
		if(StringUtils.isNotBlank(query)){
			query="%"+query+"%";
			System.out.println(query);
			return ListUtils.transform(nxBranchDao.findPageByHql(" from Nxbranch where brcname like ?",query),
					NxbranchVo.class);
		}

		return ListUtils.transform(nxBranchDao.findPageByHql(" from Nxbranch "),
				NxbranchVo.class);
	}
	
	@Override
	public void update(Nxbranch nxBranch) throws Exception {
		nxBranchDao.update(nxBranch);
	}

	@Override
	public Integer save(Nxbranch nxBranch) throws Exception {
		return nxBranchDao.save(nxBranch);
	}

	@Override
	public void delete(Nxbranch nxBranch) throws Exception {
		nxBranchDao.delete(nxBranch);
	}

}
