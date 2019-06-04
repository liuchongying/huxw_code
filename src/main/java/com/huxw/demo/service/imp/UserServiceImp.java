package com.huxw.demo.service.imp;

import com.huxw.demo.dao.UserDao;
import com.huxw.demo.entity.User;
import com.huxw.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: huxw
 * @Date: 2019-4-20 8:07
 * @Version 1.0
 */
@Service
public class UserServiceImp implements IUserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User queryUserByName(String userName) throws Exception {
        User user = userDao.queryUserByName(userName);
        return user;
    }

    @Override
    public User queryUserByNamePassword(User user) throws Exception {
        return userDao.queryUserByNamePassword(user);
    }

    @Override
    public List<User> queryUser() throws Exception {
        return userDao.queryUser();
    }

    @Override
    @Transactional
    public void insertUser(User user) throws Exception {
        userDao.insertUser(user);
    }

    @Override
    @Transactional
    public int deleteUser(int id) throws Exception {
        return userDao.deleteUser(id);
    }
}
