package cn.bdqn.dao;

import cn.bdqn.bean.News_Detail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface INews_DetailDao {
    List<News_Detail> selectNews();

    List<News_Detail> selectNewsByTitle(@Param("title") String title);

    int delNewsById(@Param("newsid") int newsid);
}
