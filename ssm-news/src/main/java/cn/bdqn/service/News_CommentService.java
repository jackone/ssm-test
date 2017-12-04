package cn.bdqn.service;

import cn.bdqn.bean.News_Comment;

import java.util.List;

public interface News_CommentService {
    List<News_Comment> selectById( int id );

    int addComment(News_Comment comment);

    int  delCommentByNewsId(int newsid);
}
