package com.issimo.web.dao;

import com.issimo.web.bean.ShowForgoods;
import com.issimo.web.bean.ShowForgoodsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ShowForgoodsMapper {
    long countByExample(ShowForgoodsExample example);

    int deleteByExample(ShowForgoodsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ShowForgoods record);

    int insertSelective(ShowForgoods record);

    List<ShowForgoods> selectByExample(ShowForgoodsExample example);

    ShowForgoods selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ShowForgoods record, @Param("example") ShowForgoodsExample example);

    int updateByExample(@Param("record") ShowForgoods record, @Param("example") ShowForgoodsExample example);

    int updateByPrimaryKeySelective(ShowForgoods record);

    int updateByPrimaryKey(ShowForgoods record);
}