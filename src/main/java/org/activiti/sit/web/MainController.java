package org.activiti.sit.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 首页控制器
 *
 * @your name
 */
@Controller
@RequestMapping("/activiti/main")
public class MainController {

	@RequestMapping(value = "/index")
	public String index() {
		return "/activiti/main/index";
	}
	
	@RequestMapping(value = "/welcome")
	public String welcome() {
		return "/activiti/main/welcome";
	}
	
}
