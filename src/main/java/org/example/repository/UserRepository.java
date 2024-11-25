package org.example.repository;

import org.example.models.User;

import java.util.HashMap;
import java.util.Map;

public class UserRepository {
    Map<Integer,User> userStores;

    public UserRepository() {
        this.userStores = new HashMap<>();
    }

    public void addUser(User user) {
        userStores.put(user.getId(),user);
    }
    public User getUser(int id){
        return userStores.get(id);
    }
}
