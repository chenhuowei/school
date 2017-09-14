package com.fireway.sys.service;

import java.util.List;

import com.fireway.base.BaseService;
import com.fireway.entity.SchoolMessage;
import com.fireway.entity.SchoolMessageExample;
import com.fireway.utils.PageBean;

public interface SchoolMessageService extends BaseService<SchoolMessage> {

	List<SchoolMessage> findByExample(SchoolMessageExample example);
	
	PageBean<SchoolMessage> findByPage(int page,int limit,SchoolMessageExample example);
}
