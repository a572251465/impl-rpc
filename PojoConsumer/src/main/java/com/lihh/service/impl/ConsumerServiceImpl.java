package com.lihh.service.impl;

import com.lihh.pojo.User;
import com.lihh.service.ConsumerService;
import com.lihh.service.UserService;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.util.List;

@Service
public class ConsumerServiceImpl implements ConsumerService {
    @Override
    public List<User> allUser() throws IOException, InterruptedException, KeeperException, NotBoundException {
        ZooKeeper zooKeeper = new ZooKeeper("43.140.193.197:2181", 10000, (watchedEvent) -> {
            System.out.println("zookeeper 启动成功");
        });

        byte[] result = zooKeeper.getData("/user/url", false, null);
        String url = new String(result);

        UserService userService = (UserService) Naming.lookup(url);
        return userService.getAllUser();
    }
}
