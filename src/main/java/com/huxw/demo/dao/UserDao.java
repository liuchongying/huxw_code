package com.huxw.demo.dao;

import com.huxw.demo.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: huxw
 * @Date: 2019-4-20 7:46
 * @Version 1.0
 */
@Repository
public interface UserDao {
    /**
     * 根据用户名查询用户
     * @param userName
     * @return
     * @throws Exception
     */
    User queryUserByName(String userName) throws Exception;

    /**
     * 根据用户名、密码查询用户
     * @param user
     * @return
     * @throws Exception
     */
    User queryUserByNamePassword(User user) throws Exception;

    /**
     * 查询所有用户
     * @return
     * @throws Exception
     */
    List<User> queryUser() throws Exception;

    /**
     * 插入用户
     * @param user
     * @throws Exception
     */
    void insertUser(User user) throws Exception;

    /**
     * 删除用户
     * @param id
     * @return
     * @throws Exception
     */
    int deleteUser(int id) throws Exception;
}
