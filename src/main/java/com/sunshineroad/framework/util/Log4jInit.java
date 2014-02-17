package com.sunshineroad.framework.util;

import java.io.IOException;
import java.util.Properties;

import javax.servlet.http.HttpServlet;

import org.apache.log4j.PropertyConfigurator;

/**
 * omplatform
 * com.sunshineroad.framework.util
 * @{#} Log4jInit.java Create on  2013-6-13 上午8:59:51
 * 
 * Copyright (c) 2013 by 阳光道路.
 * @author <a href="mailto:371917461@qq.com">张光明</a>
 * @version 1.0
 * 功能说明：Log4j初始化
 *
 */

@SuppressWarnings("serial")
public class Log4jInit extends HttpServlet {
    public void init() {
        /**
         * apache中的调用方法
         * String prefix =getServletContext().getRealPath("/");
         * 
         * String file = getInitParameter("log4j");
         *  // if the log4j-init-file is not set, then no point in trying
         * 
         * System.out.println("................log4j start");
         * 
         * if(file != null) {
         * 
         * PropertyConfigurator.configure(prefix+file);
         *  }
         * 
         */
        String file = getInitParameter("log4j");        
        System.out.println("................log4j start");
        if (file != null) {
            Properties ps=new Properties();
            try {
                ps.load(getServletContext().getResourceAsStream(file));
            } catch (IOException e) {
                e.printStackTrace();
            }
            PropertyConfigurator.configure(ps);
        }
    }
}
