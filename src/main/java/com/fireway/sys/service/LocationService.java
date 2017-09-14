package com.fireway.sys.service;

import java.util.List;

import com.fireway.base.BaseService;
import com.fireway.entity.Location;
import com.fireway.entity.LocationExample;
import com.fireway.utils.PageBean;

public interface LocationService extends BaseService<Location> {
	
	void deleteByExample(LocationExample example);
	void updateSelectByExample(Location record,LocationExample example);
	void updateExample(Location record,LocationExample example);
	
	List<Location> findByExample(LocationExample example);
	
	PageBean<Location> findyPage(int page , int limit, LocationExample example);
	
	

}
