package cn.bdqn.controller;

import cn.bdqn.bean.Privilege;
import cn.bdqn.bean.Role;
import cn.bdqn.bean.User;
import cn.bdqn.service.PrivilegeService;
import cn.bdqn.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    @Resource(name="userService")
    private UserService userService;
    @Resource(name="privilegeService")
    private PrivilegeService privilegeService;

    
    //d登录方法
    @ResponseBody
    @RequestMapping("/isLogin")
    public Object isLogin(User user, HttpSession session){
        User loginUser = userService.isLogin(user);
        if(loginUser!=null&&user.getUserName()!=null){
            session.setAttribute("user",loginUser);
            return "yes";
        }else {
            return "no";

        }
    }


    @RequestMapping("/doMain")
    public Object doMain(Model model, HttpSession session){
        User user= (User) session.getAttribute("user");
        //平级的权限
        List<Privilege> privilegeList = userService.findAllPrivilegesByUserId(user.getUserId());
        //新的容器 保存有父子关系的权限
        List<Privilege> rootMenus=new ArrayList<Privilege>();
        //工具：转成有父子关系的权限
        for (Privilege item:privilegeList){
            Privilege childMenu=item;
            int pid = childMenu.getParent();
            if (pid==0){
                rootMenus.add(item);
            }else{
                for (Privilege innerMenu:privilegeList){
                    Integer id = innerMenu.getId();
                    if (id==pid){
                        Privilege parentMenu=innerMenu;
                        parentMenu.getChildren().add(childMenu);
                        break;
                    }
                }
            }
        }
        //2.放入Model
        //request.setAttribute()
        model.addAttribute("list",rootMenus);
        //3.给出渲染数据的视图名称  main.jsp
        return "/main.jsp";
    }

    @ResponseBody
    @RequestMapping("/getAllMenusJson")
    public Object getAllMenusJson(HttpSession session){
        //新的容器 保存父子关系的权限
        List<Privilege> rootMenus=new ArrayList<Privilege>();
        List<Privilege> privilegeList=privilegeService.getAllPrivileges();

        //工具：转成有父子关系的权限
        for (Privilege item:privilegeList){
            Privilege childMenu=item;
            int pid = childMenu.getParent();
            if (pid==0){
                rootMenus.add(item);
            }else{
                for (Privilege innerMenu:privilegeList){
                    Integer id = innerMenu.getId();
                    if (id==pid){
                        Privilege parentMenu=innerMenu;
                        parentMenu.getChildren().add(childMenu);
                        break;
                    }
                }
            }
        }
        return rootMenus;
    }

    @ResponseBody
    @RequestMapping("/getPrivilegeJson")
    public Object getPrivilegeJson(Role role){
        List<Privilege> privilegeList=privilegeService.getPrivilegesByRoleId(role.getRid());
        return privilegeList;
    }
    @ResponseBody
    @RequestMapping("/savePrivilege")
    public void savePrivilege(Role role,String s){
        privilegeService.delDataToRolePrivilege(role.getRid());
        String[] str=s.split(",");
       for(String item:str){
           int pid=Integer.parseInt(item);
           Map<String,Object> map=new HashMap<String,Object>();
           map.put("rid",role.getRid());
           map.put("pid",pid);
           privilegeService.addDataToRolePrivilege(map);
       }
    }



}
