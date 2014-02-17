package org.activiti.sit.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 登录页面
 * 
 * @your name
 */
@Controller
public class LoginController {

	@RequestMapping(value = "/activiti/login")
	public String login() {
		return "/activiti/login";
	}
	
}
