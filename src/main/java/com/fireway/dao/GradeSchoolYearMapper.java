package com.fireway.dao;

import com.fireway.entity.GradeSchoolYear;
import com.fireway.entity.GradeSchoolYearExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface GradeSchoolYearMapper {
    int countByExample(GradeSchoolYearExample example);

    int deleteByExample(GradeSchoolYearExample example);

    int deleteByPrimaryKey(String id);

    int insert(GradeSchoolYear record);

    int insertSelective(GradeSchoolYear record);

    List<GradeSchoolYear> selectByExample(GradeSchoolYearExample example);
    
    List<Map<String, String>> selectByGrade(String grade);

    GradeSchoolYear selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") GradeSchoolYear record, @Param("example") GradeSchoolYearExample example);

    int updateByExample(@Param("record") GradeSchoolYear record, @Param("example") GradeSchoolYearExample example);

    int updateByPrimaryKeySelective(GradeSchoolYear record);

    int updateByPrimaryKey(GradeSchoolYear record);
}