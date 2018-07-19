package com.dao.mapper;

import com.po.BdSentiment;
import com.po.Stock;

import java.util.List;

/*
 * Create by s lion h on 2018/6/23
 */
public interface StockMapper {
    void addTable(String stockId);
    List<Stock> listExampleStock();
}
