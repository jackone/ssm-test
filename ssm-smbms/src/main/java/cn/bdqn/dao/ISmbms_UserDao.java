package cn.bdqn.dao;

import cn.bdqn.bean.Smbms_User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ISmbms_UserDao {
    /**
     * 登录
     * @param userCode
     * @param userPassword
     * @return
     */
    Smbms_User selectLogin(@Param("userCode") String userCode,@Param("userPassword")String userPassword);
//查询记录数
    int selectCount(Smbms_User user);
    //查询全部的User分页
    List<Smbms_User> selectAllUserByPage(Map<String,Object> map);

    //增加方法
    int addUser(Smbms_User user);

    int updateUser(Smbms_User user);

    int delUser(Smbms_User user);
}
