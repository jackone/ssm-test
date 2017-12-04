package cn.bdqn.service.impl;

import cn.bdqn.bean.Role;
import cn.bdqn.dao.IRoleDao;
import cn.bdqn.service.RoleService;
import cn.bdqn.until.PageUntil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Service("roleService")
public class RoleServiceImpl implements RoleService {
    @Resource(name="IRoleDao")
    private IRoleDao roleDao;


    public PageUntil selectAllUser(Role role, int pageIndex, int pageSize) {
        Map<String,Object> map = new HashMap<String, Object>();
        //把pageIndex、pageSize，userName 放在map集合里面
        map.put("pageIndex",pageIndex*pageSize);
        map.put("pageSize",pageSize);
      /* if (user!=null){
           map.put("userName",user.getUserName());
       }*/

        if(role!=null){
            map.put("role",role);
        }
        //给page属性复制
        PageUntil page=new PageUntil();
        page.setPageIndex(pageIndex);
        page.setPageSize(pageSize);
        //给查出来的总记录数复制，
        page.setTotalCount(roleDao.selectCount(role));
        System.out.println("记录书"+roleDao.selectCount(role));
        int totalPage = page.getTotalCount()%page.getPageSize()==0?
                page.getTotalCount()/page.getPageSize():page.getTotalCount()/page.getPageSize()+1;
        page.setTotalPage(totalPage);
        //
        page.setList(roleDao.selectAllUserByPage(map));
        return page;
    }
}
