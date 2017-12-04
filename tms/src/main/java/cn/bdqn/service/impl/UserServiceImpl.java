package cn.bdqn.service.impl;

import cn.bdqn.bean.Privilege;
import cn.bdqn.bean.User;
import cn.bdqn.dao.IUserDao;
import cn.bdqn.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource(name="IUserDao")
    private IUserDao userDao;
    public User isLogin(User user) {
        return userDao.isLogin(user);
    }
    public List<Privilege> findAllPrivilegesByUserId(int userid) {
        return userDao.findAllPrivilegesByUserId(userid);
    }


}
