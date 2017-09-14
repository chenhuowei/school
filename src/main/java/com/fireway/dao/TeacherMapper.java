package com.fireway.dao;

import com.fireway.entity.Teacher;
import com.fireway.entity.TeacherExample;
import com.fireway.request.dto.AutoLayoutParams;
import com.fireway.request.dto.SearchParam;
import com.sun.javafx.collections.MappingChange.Map;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TeacherMapper {
    int countByExample(TeacherExample example);

    int deleteByExample(TeacherExample example);

    int deleteByPrimaryKey(String id);

    int insert(Teacher record);

    int insertSelective(Teacher record);

    List<Teacher> selectByExample(TeacherExample example);

    Teacher selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Teacher record, @Param("example") TeacherExample example);

    int updateByExample(@Param("record") Teacher record, @Param("example") TeacherExample example);

    int updateByPrimaryKeySelective(Teacher record);

    int updateByPrimaryKey(Teacher record);
    List<Teacher> selectBySearchParam(SearchParam record);
    
    List<Map<String, String>> findIdAndNameByAcademy(@Param("academyId")String academyId);
    
    
   
    
}