package cn.bdqn.dao;

import cn.bdqn.bean.News;

import java.util.List;
import java.util.Map;

public interface INewsDao {
    Integer selectCount(News news);

    List<News> selectAllNewsByPage(Map<String, Object> map);
}
