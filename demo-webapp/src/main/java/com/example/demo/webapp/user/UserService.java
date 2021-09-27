package com.example.demo.webapp.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Data;

@Data
@Service
public class UserService {

    @Autowired
    private UserRepository userProxy;
    
    public User getUser(final int id) {
        return userProxy.getUser(id);
    }

    public Iterable<User> getUsers() {
        return userProxy.getUsers();
    }

    public void deleteUser(final int id) {
    	userProxy.deleteUser(id);
    }

     public User saveUser(User user) {
        User savedUser;

        // Règle de gestion : Le nom de famille doit être mis en majuscule.
        user.setName(user.getName().toUpperCase());

        if(user.getId() == null) {
            // Si l'id est null, alors c'est un nouvel employé.
        	savedUser = userProxy.createUser(user);
        } else {
        	savedUser = userProxy.updateUser(user);
        }
    
        return savedUser;
    }    
    
}
