package com.fireway.dao;

import com.fireway.entity.Classes;
import com.fireway.entity.ClassesExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface ClassesMapper {
    int countByExample(ClassesExample example);

    int deleteByExample(ClassesExample example);

    int deleteByPrimaryKey(String id);

    int insert(Classes record);

    int insertSelective(Classes record);

    List<Classes> selectByExample(ClassesExample example);

    Classes selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Classes record, @Param("example") ClassesExample example);

    int updateByExample(@Param("record") Classes record, @Param("example") ClassesExample example);

    int updateByPrimaryKeySelective(Classes record);

    int updateByPrimaryKey(Classes record);
    
    List<Map<String, String>> selectIdAndName(ClassesExample example);
    List<Classes> findByTeacher(String teacherNum);
}