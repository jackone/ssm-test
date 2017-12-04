package cn.bdqn.dao;

import cn.bdqn.bean.News_Comment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface INews_CommentDao {
    List<News_Comment> selectById(@Param("id") int id );

    int addComment(News_Comment comment);

    int delCommentByNewsId(@Param("newsid")int newsid);
}
