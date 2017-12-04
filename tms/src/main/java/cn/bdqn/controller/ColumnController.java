package cn.bdqn.controller;

import cn.bdqn.bean.Column;
import cn.bdqn.bean.News;
import cn.bdqn.bean.Privilege;
import cn.bdqn.service.ColumnService;
import cn.bdqn.until.PageUntil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/column")
public class ColumnController {


    @Resource(name="columnService")
    private ColumnService columnService;

    @RequestMapping("/showColumnList")
    public Object showColumnList(){
        return "/page/column/columnList.jsp";
    }

    @ResponseBody
    @RequestMapping("/getAllMenusJson")
    public Object getAllMenusJson(HttpSession session){
        //新的容器 保存父子关系的权限
            List<Column> rootMenus=new ArrayList<Column>();
        List<Column> columnList=columnService.selectAllColumn();

        //工具：转成有父子关系的权限
        for (Column item:columnList){
            Column childMenu=item;
            String  pid = childMenu.getParentcode();
            if (pid.equals("0")){
                rootMenus.add(item);
            }else{
                for (Column innerMenu:columnList){
                    String  id = innerMenu.getSyscode();
                    if (id.equals(pid)){
                        Column parentMenu=innerMenu;
                        parentMenu.getChildren().add(childMenu);
                        break;
                    }
                }
            }
        }
        return rootMenus;

    }
    @ResponseBody
    @RequestMapping("/selectNews")
    public Object selectNews(@RequestParam(defaultValue = "1",value = "page") int pageIndex, @RequestParam(defaultValue = "2",value = "rows") int pageSize,News news){
        Map<String,Object> map = new HashMap<String,Object>();
        PageUntil page=new PageUntil();
        page= columnService.selectAllNews(news,pageIndex - 1,pageSize);
        Integer total = page.getTotalCount();
        map.put("total",total);
        map.put("rows",page.getListNews());
        System.out.println("News=="+map);
        return map;


    }




}
