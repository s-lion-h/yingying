package com.dao.mapper;

import com.po.BdSentiment;
import com.po.StockComment;
import com.po.TcSentiment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/*
 * Create by s lion h on 2018/5/7
 */
public interface CommentMapper {
//    void insertComment(StockComment stockComment);
    void addStockComment(StockComment stockComment);
    List<String> listStockId();
    List<BdSentiment> listBdSentiment(@Param("stockId") String stockId);
    List<BdSentiment> listBdSentimentLimit(Integer stockId,Integer start,Integer limit);

    List<BdSentiment> listByDate(@Param("stockId") String stockId,@Param("date") String date);

}
