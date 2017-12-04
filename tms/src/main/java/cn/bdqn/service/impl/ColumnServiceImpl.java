package cn.bdqn.service.impl;

import cn.bdqn.bean.Column;
import cn.bdqn.bean.News;
import cn.bdqn.dao.IColumnDao;
import cn.bdqn.dao.INewsDao;
import cn.bdqn.service.ColumnService;
import cn.bdqn.until.PageUntil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("columnService")
public class ColumnServiceImpl implements ColumnService{
    @Resource(name="IColumnDao")
    private IColumnDao columnDao;
    @Resource(name="INewsDao")
    private INewsDao iNewsDao;
    public List<Column> selectAllColumn() {
        return columnDao.selectAllColumn();
    }

    public PageUntil selectAllNews(News news, int pageIndex, int pageSize) {
        System.out.println(news.getColumntype());
        Map<String,Object> map = new HashMap<String, Object>();
        //把pageIndex、pageSize，userName 放在map集合里面
        map.put("pageIndex",pageIndex*pageSize);
        map.put("pageSize",pageSize);
      /* if (user!=null){
           map.put("userName",user.getUserName());
       }*/

        if(news!=null){
            map.put("news",news);
        }
        System.out.println("news"+news);
        //给page属性复制
        PageUntil page=new PageUntil();
        page.setPageIndex(pageIndex);
        page.setPageSize(pageSize);
        //给查出来的总记录数复制，
        page.setTotalCount(iNewsDao.selectCount(news));
        int totalPage = page.getTotalCount()%page.getPageSize()==0?
                page.getTotalCount()/page.getPageSize():page.getTotalCount()/page.getPageSize()+1;
        page.setTotalPage(totalPage);
        //
        page.setListNews(iNewsDao.selectAllNewsByPage(map));
        return page;
    }
}
