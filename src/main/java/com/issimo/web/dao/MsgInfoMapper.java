package com.issimo.web.dao;

import com.issimo.web.bean.MsgInfo;
import com.issimo.web.bean.MsgInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MsgInfoMapper {
    long countByExample(MsgInfoExample example);

    int deleteByExample(MsgInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MsgInfo record);

    int insertSelective(MsgInfo record);

    List<MsgInfo> selectByExample(MsgInfoExample example);

    MsgInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MsgInfo record, @Param("example") MsgInfoExample example);

    int updateByExample(@Param("record") MsgInfo record, @Param("example") MsgInfoExample example);

    int updateByPrimaryKeySelective(MsgInfo record);

    int updateByPrimaryKey(MsgInfo record);
}