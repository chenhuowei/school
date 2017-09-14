package com.fireway.dao;

import com.fireway.entity.ClassSubject;
import com.fireway.entity.ClassSubjectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ClassSubjectMapper {
    int countByExample(ClassSubjectExample example);

    int deleteByExample(ClassSubjectExample example);

    int deleteByPrimaryKey(String id);

    int insert(ClassSubject record);

    int insertSelective(ClassSubject record);

    List<ClassSubject> selectByExample(ClassSubjectExample example);

    ClassSubject selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ClassSubject record, @Param("example") ClassSubjectExample example);

    int updateByExample(@Param("record") ClassSubject record, @Param("example") ClassSubjectExample example);

    int updateByPrimaryKeySelective(ClassSubject record);

    int updateByPrimaryKey(ClassSubject record);
}