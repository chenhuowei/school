package com.fireway.dao;

import com.fireway.entity.StudentSelectSubject;
import com.fireway.entity.StudentSelectSubjectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StudentSelectSubjectMapper {
    int countByExample(StudentSelectSubjectExample example);

    int deleteByExample(StudentSelectSubjectExample example);

    int deleteByPrimaryKey(String id);

    int insert(StudentSelectSubject record);

    int insertSelective(StudentSelectSubject record);

    List<StudentSelectSubject> selectByExample(StudentSelectSubjectExample example);

    StudentSelectSubject selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") StudentSelectSubject record, @Param("example") StudentSelectSubjectExample example);

    int updateByExample(@Param("record") StudentSelectSubject record, @Param("example") StudentSelectSubjectExample example);

    int updateByPrimaryKeySelective(StudentSelectSubject record);

    int updateByPrimaryKey(StudentSelectSubject record);
}