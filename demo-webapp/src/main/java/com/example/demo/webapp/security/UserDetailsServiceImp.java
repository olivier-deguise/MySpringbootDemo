package com.example.demo.webapp.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.webapp.configuration.CustomProperties;
import com.example.demo.webapp.loginuser.LoginUser;

@Service
public class UserDetailsServiceImp implements UserDetailsService {
	
    @Autowired
    private CustomProperties props;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		LoginUser user = findUserbyUsername(username);

	    UserBuilder builder = null;
	    if (user != null) {
	      builder = org.springframework.security.core.userdetails.User.withUsername(username);
	      builder.password(user.getPassword());
	      builder.roles(user.getRolesToStringArray());
	    } else {
	      throw new UsernameNotFoundException("User not found.");
	    }

	    return builder.build();
	}

	  private LoginUser findUserbyUsername(String username) {
		  String baseApiUrl = props.getApiUrl();
		  String getLoginUserUrl = baseApiUrl + "/loginUser/" + username;
		    
		  RestTemplate restTemplate = new RestTemplate();
		  LoginUser loginUser = restTemplate.getForObject(getLoginUserUrl, LoginUser.class);
		  
		  return loginUser;
	}
	  
}
