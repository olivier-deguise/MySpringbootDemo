package com.example.demo.api.loginuser;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginUserService {

    @Autowired
    private LoginUserRepository loginUserRepository;


    public Iterable<LoginUser> getLoginUsers() {
        return loginUserRepository.findAll();
    }
    
    public LoginUser getLoginUserByUsername(String username) {
        return loginUserRepository.findByUserName(username);
    }
	
}
