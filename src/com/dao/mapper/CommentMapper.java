package com.dao.mapper;

import com.po.StockComment;

/*
 * Create by s lion h on 2018/5/7
 */
public interface CommentMapper {
    void insertComment(StockComment stockComment);
    void addStockComment(StockComment stockComment);
}
