package com.fireway.dao;

import com.fireway.entity.Opinion;
import com.fireway.entity.OpinionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OpinionMapper {
    int countByExample(OpinionExample example);

    int deleteByExample(OpinionExample example);

    int deleteByPrimaryKey(String id);

    int insert(Opinion record);

    int insertSelective(Opinion record);

    List<Opinion> selectByExample(OpinionExample example);

    Opinion selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Opinion record, @Param("example") OpinionExample example);

    int updateByExample(@Param("record") Opinion record, @Param("example") OpinionExample example);

    int updateByPrimaryKeySelective(Opinion record);

    int updateByPrimaryKey(Opinion record);
}