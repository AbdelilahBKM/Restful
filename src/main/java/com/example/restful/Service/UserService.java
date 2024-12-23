package com.example.restful.Service;
import com.example.restful.Entity.User;
import com.example.restful.DAO.IUser;
import jakarta.inject.Inject;

import java.util.List;

public class UserService {
    @Inject
    private IUser userDAO;

    public void AddUser(User user){
         userDAO.addUser(user);
    }
    public List<User> getUsers(){
        return userDAO.getUsers();
    }
    public User getUser(long id){
        return userDAO.getUser(id);
    }
    public void updateUser(User user){
        userDAO.updateUser(user);
    }
    public void deleteUser(long id){
        userDAO.deleteUser(id);
    }
}
