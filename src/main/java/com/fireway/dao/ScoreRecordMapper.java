package com.fireway.dao;

import com.fireway.entity.ScoreRecord;
import com.fireway.entity.ScoreRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ScoreRecordMapper {
    int countByExample(ScoreRecordExample example);

    int deleteByExample(ScoreRecordExample example);

    int deleteByPrimaryKey(String id);

    int insert(ScoreRecord record);

    int insertSelective(ScoreRecord record);

    List<ScoreRecord> selectByExample(ScoreRecordExample example);

    ScoreRecord selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ScoreRecord record, @Param("example") ScoreRecordExample example);

    int updateByExample(@Param("record") ScoreRecord record, @Param("example") ScoreRecordExample example);

    int updateByPrimaryKeySelective(ScoreRecord record);

    int updateByPrimaryKey(ScoreRecord record);
}