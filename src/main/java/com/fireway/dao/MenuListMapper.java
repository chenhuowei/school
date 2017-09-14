package com.fireway.dao;

import com.fireway.entity.MenuList;
import com.fireway.entity.MenuListExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MenuListMapper {
    int countByExample(MenuListExample example);

    int deleteByExample(MenuListExample example);

    int deleteByPrimaryKey(String id);

    int insert(MenuList record);

    int insertSelective(MenuList record);

    List<MenuList> selectByExample(MenuListExample example);

    MenuList selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") MenuList record, @Param("example") MenuListExample example);

    int updateByExample(@Param("record") MenuList record, @Param("example") MenuListExample example);

    int updateByPrimaryKeySelective(MenuList record);

    int updateByPrimaryKey(MenuList record);
}