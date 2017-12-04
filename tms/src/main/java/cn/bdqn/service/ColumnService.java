package cn.bdqn.service;

import cn.bdqn.bean.Column;
import cn.bdqn.bean.News;
import cn.bdqn.until.PageUntil;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ColumnService {
    List<Column> selectAllColumn();

    PageUntil selectAllNews(News news, int pageIndex, int pageSize);
}
