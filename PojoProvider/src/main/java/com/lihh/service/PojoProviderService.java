package com.lihh.service;

import com.lihh.pojo.User;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class PojoProviderService extends UnicastRemoteObject implements UserService {


    public PojoProviderService() throws RemoteException {
    }

    @Override
    public List<User> getAllUser() throws RemoteException {
        List<User> list = new ArrayList<>();
        list.add(new User("lxx", 22));
        list.add(new User("cdd", 21));

        return list;
    }
}
