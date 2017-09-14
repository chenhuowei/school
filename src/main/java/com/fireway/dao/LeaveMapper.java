package com.fireway.dao;

import com.fireway.entity.Leave;
import com.fireway.entity.LeaveExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LeaveMapper {
    int countByExample(LeaveExample example);

    int deleteByExample(LeaveExample example);

    int deleteByPrimaryKey(String id);

    int insert(Leave record);

    int insertSelective(Leave record);

    List<Leave> selectByExample(LeaveExample example);

    Leave selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Leave record, @Param("example") LeaveExample example);

    int updateByExample(@Param("record") Leave record, @Param("example") LeaveExample example);

    int updateByPrimaryKeySelective(Leave record);

    int updateByPrimaryKey(Leave record);
}