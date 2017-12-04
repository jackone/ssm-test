package cn.bdqn.service.impl;

import cn.bdqn.bean.News_Detail;
import cn.bdqn.dao.INews_DetailDao;
import cn.bdqn.service.News_DetailService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service("news_DetailService")
public class NewsDetailServiceImpl implements News_DetailService{
     @Resource(name="INews_DetailDao")
     private INews_DetailDao dao;

    public List<News_Detail> selectNews() {
        return dao.selectNews();
    }

    public List<News_Detail> selectNewsByTitle(String title) {
        return dao.selectNewsByTitle(title);
    }

    public int delNewsById(int newsid) {
        return dao.delNewsById(newsid);
    }
}
