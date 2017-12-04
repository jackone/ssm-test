package cn.bdqn.service;

import cn.bdqn.bean.Role;
import cn.bdqn.until.PageUntil;

public interface RoleService {

    PageUntil selectAllUser(Role role, int i, int pageSize);
}
