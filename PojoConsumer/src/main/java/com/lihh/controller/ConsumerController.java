package com.lihh.controller;

import com.lihh.pojo.User;
import com.lihh.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ConsumerController {

    @Autowired
    private ConsumerService consumerService;

    @GetMapping(value = "/show")
    public List<User> getInfo() throws Exception {
        return consumerService.allUser();
    }
}
