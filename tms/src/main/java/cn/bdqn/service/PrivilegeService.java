package cn.bdqn.service;

import cn.bdqn.bean.Privilege;


import java.util.List;
import java.util.Map;

public interface PrivilegeService {
    List<Privilege> getAllPrivileges();

    List<Privilege> getPrivilegesByRoleId(Integer rid);

    void addDataToRolePrivilege(Map<String, Object> map);
    void delDataToRolePrivilege(Integer roleId);
}
