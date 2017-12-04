package cn.bdqn.dao;

import cn.bdqn.bean.Role;

import java.util.List;
import java.util.Map;

public interface  IRoleDao {
    //查询记录数
    int selectCount(Role role);
    //查询全部的User分页
    List<Role> selectAllUserByPage(Map<String,Object> map);
}
