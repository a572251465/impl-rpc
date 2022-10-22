package com.lihh.service;

import com.lihh.pojo.User;

import java.util.List;

public interface ConsumerService {
    List<User> allUser() throws Exception;
}
