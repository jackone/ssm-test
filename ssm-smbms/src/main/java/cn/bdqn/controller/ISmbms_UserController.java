package cn.bdqn.controller;

import cn.bdqn.bean.Smbms_User;
import cn.bdqn.service.ISmbms_UserService;
import cn.bdqn.until.PageUntil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
public class ISmbms_UserController {
    @Resource(name="ISmbms_UserService")
    private ISmbms_UserService iSmbms_userService;
    @RequestMapping("/login")
    public ModelAndView login(String userCode, String userPassword , HttpSession session){
        Smbms_User smbms_user = iSmbms_userService.selectLogin(userCode, userPassword);
        ModelAndView mv=new ModelAndView();
        if (smbms_user!=null){
            session.setAttribute("smbms_user",smbms_user);
            mv.setViewName("welcome");
            return mv;
        }else{
            mv.setViewName("login");
            return mv;
        }
    }

    /**
     *退出,同时session失效
     * @return
     */
    @RequestMapping("/tuchu")
        public String tuchu(HttpSession session){
                if(session!=null){
                    session.invalidate();
                }

                return "login";
            }

    @RequestMapping("/userList")
    public String UserList(){
        return "userList";
    }

    @RequestMapping("/userListByPage")
    @ResponseBody
    public Object selectUserList(@RequestParam(defaultValue = "1",value = "page") int pageIndex, @RequestParam(defaultValue = "2",value = "rows") int pageSize, Smbms_User user){
        Map<String,Object> map = new HashMap<String,Object>();
        PageUntil page=new PageUntil();
        page= iSmbms_userService.selectAllUser(user,pageIndex - 1,pageSize);
        Integer total = page.getTotalCount();
        map.put("total",total);
        map.put("rows",page.getList());
        return map;
    }

    @RequestMapping("/userListByPage1")
    @ResponseBody
    public Object selectUser(@RequestParam(defaultValue = "1") int pageIndex, @RequestParam(defaultValue = "2") int pageSize, Smbms_User user){

        PageUntil page=new PageUntil();
        page= iSmbms_userService.selectAllUser(user,pageIndex - 1,pageSize);


        return page;
    }
    //添加方法

    @ResponseBody
    @RequestMapping("/addUser")
    public  Object addUser(Smbms_User user,HttpSession session){

         Smbms_User user1=(Smbms_User) session.getAttribute("smbms_user");
         user.setCreatedBy(user1.getId());
         user.setCreationDate(new Date());
            boolean flag =iSmbms_userService.addUser(user);
            return  flag;
    }
    //修改方法
    @ResponseBody
    @RequestMapping("/updateUser")
    public  Object updateUser(Smbms_User user,HttpSession session,Integer id){
        Smbms_User user1=(Smbms_User) session.getAttribute("smbms_user");
        user.setModifyBy(user1.getId());
        user.setId(id);
        user.setModifyDate(new Date());
        System.out.println(user.toString());
        boolean flag =iSmbms_userService.updateUser(user);
        return  flag;
    }

    //删除方法
    @ResponseBody
    @RequestMapping("/delUser")
    public  Object delUser(Smbms_User user,String ids){
        String [] idstr = ids.split(",");
        boolean flag=false;
        for (String s : idstr) {
            System.out.println(s);
            user.setId(Integer.parseInt(s));
            System.out.println(user);
            flag=iSmbms_userService.delUser(user);
        }
        return  flag;
    }








}
