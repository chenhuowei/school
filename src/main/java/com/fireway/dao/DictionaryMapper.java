package com.fireway.dao;

import com.fireway.entity.Dictionary;
import com.fireway.entity.DictionaryExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface DictionaryMapper {
    int countByExample(DictionaryExample example);

    int deleteByExample(DictionaryExample example);

    int deleteByPrimaryKey(String id);

    int insert(Dictionary record);

    int insertSelective(Dictionary record);

    List<Dictionary> selectByExample(DictionaryExample example);

    Dictionary selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Dictionary record, @Param("example") DictionaryExample example);

    int updateByExample(@Param("record") Dictionary record, @Param("example") DictionaryExample example);

    int updateByPrimaryKeySelective(Dictionary record);

    int updateByPrimaryKey(Dictionary record);
    
    List<Map<String, String>> selectByType(DictionaryExample example);
    
    List<Map<String, String>> findTreeList(DictionaryExample example);
    
}