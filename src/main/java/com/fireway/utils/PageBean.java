/**
 * Project Name:letJoyFun
 * File Name:PageBean.java
 * Package Name:com.fireway.util
 * Date:2016年5月23日下午3:13:35
 * Copyright (c) 2016, chenzhou1025@126.com All Rights Reserved.
 *
*/

package com.fireway.utils;

import java.io.Serializable;
import java.util.List;

import com.github.pagehelper.Page;

/**
 * ClassName:PageBean <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2016年5月23日 下午3:13:35 <br/>
 * @author   chenhuowei
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
public class PageBean<T> implements Serializable {
    private static final long serialVersionUID = 8656597559014685635L;
    private long total;        //总记录数
    private List<T> rows;    //结果集
    private int pageNum;    // 第几页
    private int pageSize;    // 每页记录数
    private int pages;        // 总页数
    private int size;        // 当前页的数量 <= pageSize，该属性来自ArrayList的size属性
    
    /**
     * 包装Page对象，因为直接返回Page对象，在JSON处理以及其他情况下会被当成List来处理，
     * 而出现一些问题。
     * @param list          page结果
     * @param navigatePages 页码数量
     */
    public PageBean(List<T> list) {
        if (list instanceof Page) {
           Page<T> page = (Page<T>) list;
            this.pageNum = page.getPageNum();
            this.pageSize = page.getPageSize();
            this.total = page.getTotal();
            this.pages = page.getPages();
            this.rows = page;
            this.size = page.size();
        }
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    
    
	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
    
    
    
}
