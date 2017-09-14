package com.fireway.dao;

import com.fireway.entity.StudentTest;
import com.fireway.entity.StudentTestExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StudentTestMapper {
    int countByExample(StudentTestExample example);

    int deleteByExample(StudentTestExample example);

    int deleteByPrimaryKey(String id);

    int insert(StudentTest record);

    int insertSelective(StudentTest record);

    List<StudentTest> selectByExample(StudentTestExample example);

    StudentTest selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") StudentTest record, @Param("example") StudentTestExample example);

    int updateByExample(@Param("record") StudentTest record, @Param("example") StudentTestExample example);

    int updateByPrimaryKeySelective(StudentTest record);

    int updateByPrimaryKey(StudentTest record);
}