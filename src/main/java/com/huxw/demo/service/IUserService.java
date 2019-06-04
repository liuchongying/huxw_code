package com.huxw.demo.service;

import com.huxw.demo.entity.User;

import java.util.List;

/**
 * @Author: huxw
 * @Date: 2019-4-20 8:02
 * @Version 1.0
 */
public interface IUserService {
    /**
     * @Author huxw
     * @Description 根据用户名查询用户
     * @Date 2019-4-20 8:06
     * @Param
     * @return
     **/
    User queryUserByName(String userName) throws Exception;

    /**
     * @Author huxw
     * @Description 根据用户名、密码查询用户
     * @Date 2019-4-20 11:01
     * @Param
     * @return
     **/
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
