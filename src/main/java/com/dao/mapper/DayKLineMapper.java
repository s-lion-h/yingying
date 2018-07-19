package com.dao.mapper;

import com.stock.dayprice.DataPo;

import java.util.List;

/*
 * Create by s lion h on 2018/7/19
 */
public interface DayKLineMapper {
    void insertDayKLine(DataPo dataPo);
    List<String> getTradeDay();
}
