package com.octest.dao;

import java.util.List;

import com.octest.beans.User;

public interface IUserDao {
    void add(User user) throws DaoException;
    List<User> list() throws DaoException;
}