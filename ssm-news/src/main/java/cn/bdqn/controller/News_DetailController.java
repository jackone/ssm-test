package cn.bdqn.controller;

import cn.bdqn.service.News_CommentService;
import cn.bdqn.service.News_DetailService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@Controller
@RequestMapping("/new")
public class News_DetailController {
    @Resource(name="news_CommentService")
    private News_CommentService commentService;

    @Resource(name="news_DetailService")
    private News_DetailService service;

        @RequestMapping("/all")
        public ModelAndView main(){
            ModelAndView mv=new ModelAndView();
            mv.addObject("details",service.selectNews());
            mv.setViewName("/main.jsp");
            return mv;
        }
    @RequestMapping("/mohu")
    public ModelAndView main(String title){
        ModelAndView mv=new ModelAndView();
            if ("".equals(title)||null==title){
                mv.addObject("details",service.selectNews());
            }else {
                mv.addObject("details",service.selectNewsByTitle(title));
            }

        mv.setViewName("/main.jsp");
        return mv;
    }


     public ModelAndView delNewsById(@PathVariable int newsid){
        ModelAndView mv=null;
        if ( commentService.selectById(newsid).size()>0){
           if (commentService.delCommentByNewsId(newsid)>0){
               if(service.delNewsById(newsid)>0){
                   mv=new ModelAndView("redirect:/new/all");
                   mv.addObject("msg","删除成功！");
               }
           }
        }else{
            if(service.delNewsById(newsid)>0){
                mv=new ModelAndView("redirect:/new/all");
                mv.addObject("msg","删除成功！");
            }
        }
        return mv;

    }

}
