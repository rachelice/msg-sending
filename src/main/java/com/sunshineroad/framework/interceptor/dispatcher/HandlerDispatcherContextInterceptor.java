package com.sunshineroad.framework.interceptor.dispatcher;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunshineroad.framework.context.spring.SpringDispatcherContextHolder;
import com.sunshineroad.framework.interceptor.AbstractHandlerPreparInterceptor;

public class HandlerDispatcherContextInterceptor extends
		AbstractHandlerPreparInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) {
		SpringDispatcherContextHolder.initDispatcherContext(response);
		return true;
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		SpringDispatcherContextHolder.resetDispatcherContext();
	}
}
