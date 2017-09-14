package com.fireway.dao;

import com.fireway.entity.SelectSubject;
import com.fireway.entity.SelectSubjectExample;
import com.fireway.request.dto.AutoLayoutParams;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface SelectSubjectMapper {
    int countByExample(SelectSubjectExample example);

    int deleteByExample(SelectSubjectExample example);

    int deleteByPrimaryKey(String id);

    int insert(SelectSubject record);

    int insertSelective(SelectSubject record);

    List<SelectSubject> selectByExample(SelectSubjectExample example);

    SelectSubject selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SelectSubject record, @Param("example") SelectSubjectExample example);

    int updateByExample(@Param("record") SelectSubject record, @Param("example") SelectSubjectExample example);

    int updateByPrimaryKeySelective(SelectSubject record);

    int updateByPrimaryKey(SelectSubject record);
    
    int countByLayoutParams(AutoLayoutParams autoLayoutParams);
    List<SelectSubject> selectByStudentId(@Param("studentId")String studentId,@Param("schoolYear")String schoolYear,@Param("term")String term);
    List<SelectSubject> selectByTeacherId(@Param("teacherId")String teacherId,@Param("schoolYear")String schoolYear,@Param("term")String term);
    List<SelectSubject> selectByStudentIdAndPage(@Param("studentId")String studentId,@Param("schoolYear")String schoolYear,@Param("term")String term);
    List<Map<String , String>> selectByIdAndName(@Param("teacherId")String teacherId,@Param("schoolYear")String schoolYear,@Param("term")String term);
    
}