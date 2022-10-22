package com.lihh;

import com.lihh.service.PojoProviderService;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import static org.apache.zookeeper.CreateMode.*;
import static org.apache.zookeeper.ZooDefs.*;

public class PojoProvider {
    public static void main(String[] args) throws IOException, AlreadyBoundException, InterruptedException, KeeperException {
        PojoProviderService pojoProviderService = new PojoProviderService();

        LocateRegistry.createRegistry(8888);
        String url = "rmi://localhost:8888/getAllUser";
        Naming.bind(url, pojoProviderService);

        ZooKeeper zooKeeper = new ZooKeeper("43.140.193.197:2181", 100000, (watchedEvent) -> {
            System.out.println("zookeeper 启动成功");
        });

        zooKeeper.create("/user/url", url.getBytes(), Ids.OPEN_ACL_UNSAFE, PERSISTENT);
    }
}
