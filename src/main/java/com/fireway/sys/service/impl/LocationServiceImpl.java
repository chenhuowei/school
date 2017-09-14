package com.fireway.sys.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fireway.dao.LocationMapper;
import com.fireway.entity.Location;
import com.fireway.entity.LocationExample;
import com.fireway.sys.service.LocationService;
import com.fireway.utils.PageBean;
import com.github.pagehelper.PageHelper;

@Service("locationService")
public class LocationServiceImpl implements LocationService {

	@Resource
	private LocationMapper locationMapper;
	
	public void save(Location record) {
		locationMapper.insertSelective(record);
	}

	public void delete(String id) {
		locationMapper.deleteByPrimaryKey(id);
	}

	public void updateSelectById(Location record) {
		locationMapper.updateByPrimaryKeySelective(record);
	}

	public void updateById(Location record) {
		locationMapper.updateByPrimaryKey(record);
	}

	public Location findById(String id) {

		return locationMapper.selectByPrimaryKey(id);
	}

	public boolean isRepeat(String key) {

		return false;
	}

	public void deleteByExample(LocationExample example) {
	}

	public void updateSelectByExample(Location record, LocationExample example) {
		locationMapper.updateByExampleSelective(record, example);
	}

	public void updateExample(Location record, LocationExample example) {
	}

	public List<Location> findByExample(LocationExample example) {

		return locationMapper.selectByExample(example);
	}

	public PageBean<Location> findyPage(int page, int limit, LocationExample example) {

		PageHelper.startPage(page, limit);
		List<Location> list = findByExample(example);
		
		return new PageBean<Location>(list);
	}

}
