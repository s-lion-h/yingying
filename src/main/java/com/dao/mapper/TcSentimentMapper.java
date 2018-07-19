package com.dao.mapper;

import com.po.BdSentiment;
import com.po.TcSentiment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/*
 * Create by s lion h on 2018/6/19
 */
public interface TcSentimentMapper {
    List<TcSentiment> listAllSentimentById(String stockId);
    List<TcSentiment> listSentimentByIdNum(Integer stockId,Integer start,Integer limit);
    void updateSentiment(TcSentiment tcSentiment);
    void updateBdSentiment(BdSentiment bdSentiment);

}
