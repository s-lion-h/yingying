package com.analysis.date;

import com.dao.mapper.CommentMapper;
import com.dao.util.DBTools;
import com.po.BdSentiment;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/*
 * Create by s lion h on 2018/6/25
 */
public class DateService {
    private static SqlSession session=DBTools.getSession();
    private static CommentMapper commentMapper=session.getMapper(CommentMapper.class);

    /*
     * @Param(String stockId,String date)
     * date:2018-06-12
     * @Result(List<BdSentiment>)
     * list某id某day
     */
    public static List<BdSentiment> listByDate(String stockId, String date){
        return commentMapper.listByDate(stockId,date);
    }
}
