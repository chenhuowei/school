package com.fireway.dao;

import com.fireway.entity.SubjectArrangement;
import com.fireway.entity.SubjectArrangementExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface SubjectArrangementMapper {
    int countByExample(SubjectArrangementExample example);

    int deleteByExample(SubjectArrangementExample example);

    int deleteByPrimaryKey(String id);

    int insert(SubjectArrangement record);

    int insertSelective(SubjectArrangement record);

    List<SubjectArrangement> selectByExample(SubjectArrangementExample example);

    SubjectArrangement selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SubjectArrangement record, @Param("example") SubjectArrangementExample example);

    int updateByExample(@Param("record") SubjectArrangement record, @Param("example") SubjectArrangementExample example);

    int updateByPrimaryKeySelective(SubjectArrangement record);

    int updateByPrimaryKey(SubjectArrangement record);
    
    List<SubjectArrangement> selectByPage();
    
    List<Map<String, String>> selectByClassId(@Param("classId")String classId,@Param("schoolYear")String schoolYear,
    		@Param("term")String term,@Param("teacherId")String teacherId);
    
}