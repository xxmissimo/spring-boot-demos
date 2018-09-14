package com.issimo.web.dao;

import com.issimo.web.bean.QQspeed;
import com.issimo.web.bean.QQspeedExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface QQspeedMapper {
    long countByExample(QQspeedExample example);

    int deleteByExample(QQspeedExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(QQspeed record);

    int insertSelective(QQspeed record);

    List<QQspeed> selectByExample(QQspeedExample example);

    QQspeed selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") QQspeed record, @Param("example") QQspeedExample example);

    int updateByExample(@Param("record") QQspeed record, @Param("example") QQspeedExample example);

    int updateByPrimaryKeySelective(QQspeed record);

    int updateByPrimaryKey(QQspeed record);
}