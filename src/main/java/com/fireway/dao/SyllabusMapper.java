package com.fireway.dao;

import com.fireway.entity.Syllabus;
import com.fireway.entity.SyllabusExample;
import com.fireway.request.dto.AutoLayoutParams;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SyllabusMapper {
    int countByExample(SyllabusExample example);

    int deleteByExample(SyllabusExample example);

    int deleteByPrimaryKey(String id);

    int insert(Syllabus record);

    int insertSelective(Syllabus record);

    List<Syllabus> selectByExample(SyllabusExample example);

    Syllabus selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Syllabus record, @Param("example") SyllabusExample example);

    int updateByExample(@Param("record") Syllabus record, @Param("example") SyllabusExample example);

    int updateByPrimaryKeySelective(Syllabus record);

    int updateByPrimaryKey(Syllabus record);
    
    
    
    int countByLayoutParams(AutoLayoutParams autoLayoutParams);
    int countTeacherLessionOfWeek(AutoLayoutParams autoLayoutParams);
    int countTeacherLessionOfDay(AutoLayoutParams autoLayoutParams);
    int countClassLessionOfWeek(AutoLayoutParams autoLayoutParams);
    int countClassLessionOfDay(AutoLayoutParams autoLayoutParams);
    int countSubjectOfWeek(AutoLayoutParams autoLayoutParams);
    int countClassSubjectOfDay(AutoLayoutParams autoLayoutParams);
    int countTeacherWeekTimeHasLession(AutoLayoutParams autoLayoutParams);
    
}