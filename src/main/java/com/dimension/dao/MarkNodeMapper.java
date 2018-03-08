package com.dimension.dao;

import com.dimension.pojo.MarkNode;

public interface MarkNodeMapper {
    int deleteByPrimaryKey(Long markid);

    int insert(MarkNode record);

    int insertSelective(MarkNode record);

    MarkNode selectByPrimaryKey(Long markid);

    int updateByPrimaryKeySelective(MarkNode record);

    int updateByPrimaryKey(MarkNode record);
}