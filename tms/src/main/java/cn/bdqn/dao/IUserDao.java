package cn.bdqn.dao;

import cn.bdqn.bean.Privilege;
import cn.bdqn.bean.User;

import java.util.List;

public interface IUserDao {
     User isLogin(User user);
     //2.写一个根据用户编号获取该用户拥有所有权限的方法
     public List<Privilege> findAllPrivilegesByUserId(int userId);


}
