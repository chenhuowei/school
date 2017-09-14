package com.fireway.dao;

import com.fireway.entity.ResultsStatistical;
import com.fireway.entity.ResultsStatisticalExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ResultsStatisticalMapper {
    int countByExample(ResultsStatisticalExample example);

    int deleteByExample(ResultsStatisticalExample example);

    int deleteByPrimaryKey(String id);

    int insert(ResultsStatistical record);

    int insertSelective(ResultsStatistical record);

    List<ResultsStatistical> selectByExample(ResultsStatisticalExample example);

    ResultsStatistical selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ResultsStatistical record, @Param("example") ResultsStatisticalExample example);

    int updateByExample(@Param("record") ResultsStatistical record, @Param("example") ResultsStatisticalExample example);

    int updateByPrimaryKeySelective(ResultsStatistical record);

    int updateByPrimaryKey(ResultsStatistical record);
}