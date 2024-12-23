package com.example.restful.DAO;
import com.example.restful.Entity.User;

import java.util.List;

public interface IUser {
    void addUser(User user);
    List<User> getUsers();
    User getUser(Long id);
    void updateUser(User user);
    void deleteUser(Long id);
}
