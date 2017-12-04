package cn.bdqn.service.impl;

import cn.bdqn.bean.News_Comment;
import cn.bdqn.dao.INews_CommentDao;
import cn.bdqn.service.News_CommentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service("news_CommentService")
public class News_CommentServiceImpl implements News_CommentService{
    @Resource(name="INews_CommentDao")
    private INews_CommentDao commentDao;


    public List<News_Comment> selectById(int id) {
        return commentDao.selectById(id);
    }

    public int addComment(News_Comment comment) {
        return commentDao.addComment(comment);
    }

    public int delCommentByNewsId(int newsid) {
        return commentDao.delCommentByNewsId(newsid);
    }
}
