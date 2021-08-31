package com.atguigu.dao.impl;

import com.atguigu.dao.UserDao;
import com.atguigu.pojo.User;

import java.util.List;

public class UserDaoImpl extends BaseDao implements UserDao {

    @Override
    public int saveUser(User user) {

        String sql = "insert into t_user(`username`,`password`,`email`) values(?,?,?)";

        return update(sql, user.getUsername(), user.getPassword(), user.getEmail());

    }

    @Override
    public User queryUserByUsernameAndPassword(String username, String password) {

        String sql = "select `username`,`password`,`email`,`id` from t_user where username = ? and password = ?";

        return queryForOne(User.class, sql, username, password);

    }

    @Override
    public User queryUserByUsername(String username) {

        String sql = "select `username`,`password`,`email`,`id` from t_user where username = ?";

        return queryForOne(User.class, sql, username);

    }


    @Override
    public List<User> queryUsers() {
        return queryForList(User.class, "select `username`,`password`,`email`,`id` from t_user");
    }
}
