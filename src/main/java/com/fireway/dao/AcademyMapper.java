package com.fireway.dao;

import com.fireway.entity.Academy;
import com.fireway.entity.AcademyExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface AcademyMapper {
    int countByExample(AcademyExample example);

    int deleteByExample(AcademyExample example);

    int deleteByPrimaryKey(String id);

    int insert(Academy record);

    int insertSelective(Academy record);

    List<Academy> selectByExample(AcademyExample example);

    Academy selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Academy record, @Param("example") AcademyExample example);

    int updateByExample(@Param("record") Academy record, @Param("example") AcademyExample example);

    int updateByPrimaryKeySelective(Academy record);

    int updateByPrimaryKey(Academy record);
    
    List<Map<String, String>> findIdnName(AcademyExample example);
   
    List<Map<String, String>> findTreeList(AcademyExample example);
}