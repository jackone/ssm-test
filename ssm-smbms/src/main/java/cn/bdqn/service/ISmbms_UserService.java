package cn.bdqn.service;

import cn.bdqn.bean.Smbms_User;
import cn.bdqn.until.PageUntil;




public interface ISmbms_UserService {
    //登录
    Smbms_User selectLogin(String userCode,String userPassword);
  //分页查询user集合保存在PageUntil内
    PageUntil selectAllUser(Smbms_User user,int pageIndex, int pageSize);
    /**
     * 增加方法
     */

    boolean addUser(Smbms_User user);

    /**
     * 修改
     * @param user
     * @return
     */
    boolean updateUser(Smbms_User user);

    boolean delUser(Smbms_User user);
}
