package com.example.demo.service;

import com.example.demo.entity.User;

import java.util.List;

public interface UserService {

    List<User> getAllUser();

    List<User> select(User user);

    boolean insert(User user);

    boolean update(User user);

    boolean delete(User user);
}
