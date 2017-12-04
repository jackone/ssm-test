package cn.bdqn.service.impl;

import cn.bdqn.bean.Smbms_User;
import cn.bdqn.dao.ISmbms_UserDao;
import cn.bdqn.service.ISmbms_UserService;
import cn.bdqn.until.PageUntil;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("ISmbms_UserService")
public class ISmbms_UserServiceImpl implements ISmbms_UserService{


    @Resource(name="ISmbms_UserDao")
        private ISmbms_UserDao iSmbms_userDao;

    public Smbms_User selectLogin(String userCode, String userPassword) {
        return iSmbms_userDao.selectLogin(userCode,userPassword);
    }

    /**
     *
     * @param user  根据条件查询，封装成一个user对象
     * @param pageIndex 当前也下表
     * @param pageSize 页大小
     * @return  PageUntil 这个里面有查询的所有值
     */
    public PageUntil selectAllUser(Smbms_User user, int pageIndex, int pageSize) {
        Map<String,Object> map = new HashMap<String, Object>();
        //把pageIndex、pageSize，userName 放在map集合里面
        map.put("pageIndex",pageIndex*pageSize);
        map.put("pageSize",pageSize);
      /* if (user!=null){
           map.put("userName",user.getUserName());
       }*/

        if(user!=null){
            map.put("user",user);
        }
        //给page属性复制
        PageUntil page=new PageUntil();
        page.setPageIndex(pageIndex);
        page.setPageSize(pageSize);
        //给查出来的总记录数复制，
        page.setTotalCount(iSmbms_userDao.selectCount(user));
        int totalPage = page.getTotalCount()%page.getPageSize()==0?
                page.getTotalCount()/page.getPageSize():page.getTotalCount()/page.getPageSize()+1;
        page.setTotalPage(totalPage);
        //
       page.setList(iSmbms_userDao.selectAllUserByPage(map));
        return page;
    }

    /**
     * 增加方法
     *
     * @param user
     */
    public boolean addUser(Smbms_User user) {
        boolean flag=false;
        if (iSmbms_userDao.addUser(user)>0){
            flag=true;
        }
        return flag;
    }

    /**
     * 修改
     *
     * @param user
     * @return
     */
    public boolean updateUser(Smbms_User user) {
        boolean flag=false;
        if (iSmbms_userDao.updateUser(user)>0){
            flag=true;
        }
        return flag;
    }

    /**
     * 删除方法
     * @param user
     * @return
     */
    public boolean delUser(Smbms_User user) {
        boolean flag=false;
        if (iSmbms_userDao.delUser(user)>0){
            flag=true;
        }
        return flag;
    }

}
