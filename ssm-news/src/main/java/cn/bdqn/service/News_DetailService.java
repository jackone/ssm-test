package cn.bdqn.service;

import cn.bdqn.bean.News_Detail;

import java.util.List;

public interface News_DetailService {
    List<News_Detail> selectNews();

    List<News_Detail> selectNewsByTitle(String title);

    int delNewsById(int newsid);
}
