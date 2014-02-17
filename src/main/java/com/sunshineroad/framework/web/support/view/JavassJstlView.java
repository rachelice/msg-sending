package com.sunshineroad.framework.web.support.view;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.view.JstlView;

/**
 * omplatformNew
 * com.sunshineroad.framework.web.support.view
 * @{#} JavassJstlView.java Create on  2013-6-13 上午9:21:09
 * 
 * Copyright (c) 2013 by 阳光道路.
 * @author <a href="mailto:xxxxxx">xxxxxx</a>
 * @version 1.0
 * 功能说明：添加对于JavassContentNegotiatingViewResolver.java 的content-type支持
 *
 */

public class JavassJstlView extends JstlView {
    
    @Override
    protected void exposeHelpers(HttpServletRequest request) throws Exception {
        super.exposeHelpers(request);
    }
    
}
