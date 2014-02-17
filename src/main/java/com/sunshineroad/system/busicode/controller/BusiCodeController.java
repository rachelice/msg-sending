package com.sunshineroad.system.busicode.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.sunshineroad.framework.util.WebUtils;
import com.sunshineroad.system.actionlog.service.ActionlogService;
import com.sunshineroad.system.updatelog.service.UpdatelogService;
import com.sunshineroad.system.busicode.service.BusiCodeService;
import com.sunshineroad.system.busicode.usercase.BusiCodeUC;
import com.sunshineroad.system.busicode.vo.BusiCodeVo;
import com.sunshineroad.system.connaddress.service.ConnaddressService;

@Controller
@RequestMapping(value = "busicodes")
public class BusiCodeController {

	@Autowired
	private BusiCodeService busicodeService;

	@Autowired
	private ActionlogService actionlogService;

	@Autowired
	private ConnaddressService connService;

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody
	Object select() throws Exception {
		HttpServletRequest request = WebUtils.getRequestByContext();
		BusiCodeUC busicodeUC = new BusiCodeUC();
		BusiCodeVo busicodeVo = new BusiCodeVo();
		String businessname=request.getParameter("businame");
		String businesstype=request.getParameter("busitype");
		
		busicodeVo.setBusinessname(businessname);
		busicodeVo.setBusinesstype(businesstype);
		
		return busicodeUC.genBusiCode(busicodeService,actionlogService, busicodeVo);
		
	}

	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public @ResponseBody
	Object update(@RequestBody BusiCodeVo busicodeVo) throws Exception {
		BusiCodeUC busicodeUC = new BusiCodeUC();

		return null;
	}

	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody
	Object insert(@RequestBody BusiCodeVo busicodeVo) throws Exception {
		BusiCodeUC busicodeUC = new BusiCodeUC();

		return null;
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public @ResponseBody
	Object delete(@RequestBody BusiCodeVo busicodeVo) throws Exception {
		BusiCodeUC busicodeUC = new BusiCodeUC();

		return null;
	}
}
