package cn.bdqn.controller;

import cn.bdqn.bean.News_Comment;
import cn.bdqn.service.News_CommentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.Date;

@Controller
@RequestMapping("/comment")
public class News_CommentController {
    @Resource(name="news_CommentService")
    private News_CommentService commentService;

    @RequestMapping("/{newsid}/select")
    public ModelAndView selectById(@PathVariable int newsid){
        ModelAndView mv=new ModelAndView("/comment.jsp");
        mv.addObject("commentList",commentService.selectById(newsid));
        return mv;
    }
    @RequestMapping("/{newsid}/add")
    public ModelAndView addComment(@PathVariable int newsid, News_Comment comment){
        comment.setCreateDate(new Date());
        comment.setNewsid(newsid);
        int num=commentService.addComment(comment);
        if (num>0){
            ModelAndView mv=new ModelAndView("select");
            return mv;
        }
         return null;
    }



}
