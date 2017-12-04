package cn.bdqn.controller;

import cn.bdqn.bean.Role;
import cn.bdqn.service.RoleService;
import cn.bdqn.until.PageUntil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/role")
public class RoleController {
    @Resource(name="roleService")
   private RoleService roleService;



    @RequestMapping("/showRoleList")
    public  Object showRoleList(){
        return "/page/user/roleList.jsp";
    }


    @ResponseBody
     @RequestMapping("/selectRole")
    public Object selectRole(@RequestParam(defaultValue = "1",value = "page") int pageIndex, @RequestParam(defaultValue = "2",value = "rows") int pageSize, Role role){

        Map<String,Object> map = new HashMap<String,Object>();
        PageUntil page=new PageUntil();
        page= roleService.selectAllUser(role,pageIndex - 1,pageSize);
        Integer total = page.getTotalCount();
        map.put("total",total);
        map.put("rows",page.getList());
        return map;

      }



}
