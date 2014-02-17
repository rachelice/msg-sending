package com.sunshineroad.framework.web.support.pagination;

import com.sunshineroad.framework.constants.Constants;

/**
 * omplatform
 * com.sunshineroad.framework.web.support.pagination
 * @{#} IPageContext.java Create on  2013-6-13 上午9:16:17
 * 
 * Copyright (c) 2013 by 阳光道路.
 * @author <a href="mailto:xxxxxx">xxxxxx</a>
 * @version 1.0
 * 功能说明：分页上下文环境。用于计算Page
 *
 */

public interface IPageContext<E> {
    
    /**
     * 默认设定每页显示记录数为10
     */
    public static final int DEFAULT_PAGE_SIZE = Constants.DEFAULT_PAGE_SIZE;
    
    /**
     * 计算总页数.
     * 
     * @return
     */
    public int getPageCount();
    

    /**
     * 返回 Page 对象.
     * 
     * @param index
     * @return
     */
    public Page<E> getPage(int index);
    
    /**
     * 每页显示的记录数量
     * 
     * @return
     */
    public int getPageSize();
    
    /**
     * 计算总记录数
     * 
     * @return
     */
    public int getTotal();
    
}
