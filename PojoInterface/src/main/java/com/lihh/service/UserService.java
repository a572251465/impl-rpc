package com.lihh.service;

import com.lihh.pojo.User;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface UserService extends Remote {
    List<User> getAllUser() throws RemoteException;
}
