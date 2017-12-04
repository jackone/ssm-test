package cn.bdqn.service.impl;

import cn.bdqn.bean.Privilege;
import cn.bdqn.dao.IPrivilegeDao;
import cn.bdqn.service.PrivilegeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service("privilegeService")
public class PrivilegeServiceImpl implements PrivilegeService {
    @Resource(name="IPrivilegeDao")
    private IPrivilegeDao privilegeDao;


    public List<Privilege> getAllPrivileges() {
        return privilegeDao.getAllPrivileges();
    }

    public List<Privilege> getPrivilegesByRoleId(Integer rid) {
        return privilegeDao.getPrivilegesByRoleId(rid);
    }

    public void addDataToRolePrivilege(Map<String, Object> map) {
         privilegeDao.addDataToRolePrivilege( map);
    }

    public void delDataToRolePrivilege(Integer roleId) {
        privilegeDao.delDataToRolePrivilege(roleId);
    }
}
