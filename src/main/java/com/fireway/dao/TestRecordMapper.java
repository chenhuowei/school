package com.fireway.dao;

import com.fireway.entity.TestRecord;
import com.fireway.entity.TestRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TestRecordMapper {
    int countByExample(TestRecordExample example);

    int deleteByExample(TestRecordExample example);

    int deleteByPrimaryKey(String id);

    int insert(TestRecord record);

    int insertSelective(TestRecord record);

    List<TestRecord> selectByExample(TestRecordExample example);

    TestRecord selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TestRecord record, @Param("example") TestRecordExample example);

    int updateByExample(@Param("record") TestRecord record, @Param("example") TestRecordExample example);

    int updateByPrimaryKeySelective(TestRecord record);

    int updateByPrimaryKey(TestRecord record);
}