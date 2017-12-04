package cn.bdqn.dao;

import cn.bdqn.bean.Privilege;

import java.util.List;
import java.util.Map;

public interface IPrivilegeDao {
    List<Privilege> getAllPrivileges();

    List<Privilege> getPrivilegesByRoleId(Integer rid);

    void addDataToRolePrivilege(Map<String, Object> map);
    void delDataToRolePrivilege(Integer roleId);

}
