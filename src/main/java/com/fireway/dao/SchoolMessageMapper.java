package com.fireway.dao;

import com.fireway.entity.SchoolMessage;
import com.fireway.entity.SchoolMessageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SchoolMessageMapper {
    int countByExample(SchoolMessageExample example);

    int deleteByExample(SchoolMessageExample example);

    int deleteByPrimaryKey(String id);

    int insert(SchoolMessage record);

    int insertSelective(SchoolMessage record);

    List<SchoolMessage> selectByExample(SchoolMessageExample example);

    SchoolMessage selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SchoolMessage record, @Param("example") SchoolMessageExample example);

    int updateByExample(@Param("record") SchoolMessage record, @Param("example") SchoolMessageExample example);

    int updateByPrimaryKeySelective(SchoolMessage record);

    int updateByPrimaryKey(SchoolMessage record);
}