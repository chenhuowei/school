package com.fireway.dao;

import com.fireway.entity.EmploymentRate;
import com.fireway.entity.EmploymentRateExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface EmploymentRateMapper {
    int countByExample(EmploymentRateExample example);

    int deleteByExample(EmploymentRateExample example);

    int deleteByPrimaryKey(String id);

    int insert(EmploymentRate record);

    int insertSelective(EmploymentRate record);

    List<EmploymentRate> selectByExample(EmploymentRateExample example);

    EmploymentRate selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") EmploymentRate record, @Param("example") EmploymentRateExample example);

    int updateByExample(@Param("record") EmploymentRate record, @Param("example") EmploymentRateExample example);

    int updateByPrimaryKeySelective(EmploymentRate record);

    int updateByPrimaryKey(EmploymentRate record);
    
    List<Map<String, Object>> statistics(@Param("graduationYear")String graduationYear);
    List<Map<String, Object>> selectGraduationYear();
    List<Map<String, Object>> selectRateByAcademy(@Param("academy")String academy);
    
    
    
    
    
    
    
    
    
}