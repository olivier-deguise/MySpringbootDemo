package com.example.demo.webapp.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.example.demo.webapp.configuration.CustomProperties;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class UserRepository {
	
    @Autowired
    private CustomProperties props;

    public Iterable<User> getUsers() {
        String baseApiUrl = props.getApiUrl();
        String getUsersUrl = baseApiUrl + "/users";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Iterable<User>> response = restTemplate.exchange(
        		getUsersUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Iterable<User>>() {}
                );

        log.debug("Get Users call " + response.getStatusCode().toString());
        
        return response.getBody();
    }
    
	public User getUser(int id) {
		String baseApiUrl = props.getApiUrl();
		String getUsersUrl = baseApiUrl + "/user/" + id;

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<User> response = restTemplate.exchange(
				getUsersUrl, 
				HttpMethod.GET, 
				null,
				User.class
			);
		
		log.debug("Get User call " + response.getStatusCode().toString());
		
		return response.getBody();
	}    
    
    public User createUser(User u) {
        String baseApiUrl = props.getApiUrl();
        String createUserUrl = baseApiUrl + "/user";

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<User> request = new HttpEntity<User>(u);
        ResponseEntity<User> response = restTemplate.exchange(
        	createUserUrl,
            HttpMethod.POST,
            request,
            User.class);

        log.debug("Create User call " + response.getStatusCode().toString());

        return response.getBody();
    }
    
	public User updateUser(User u) {
		String baseApiUrl = props.getApiUrl();
		String updateUserUrl = baseApiUrl + "/user/" + u.getId();

		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<User> request = new HttpEntity<User>(u);
		ResponseEntity<User> response = restTemplate.exchange(
				updateUserUrl, 
				HttpMethod.PUT, 
				request, 
				User.class);
		
		log.debug("Update User call " + response.getStatusCode().toString());
		
		return response.getBody();
	}
	
	public void deleteUser(int id) {
		String baseApiUrl = props.getApiUrl();
		String deleteUserUrl = baseApiUrl + "/user/" + id;
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Void> response = restTemplate.exchange(
				deleteUserUrl, 
				HttpMethod.DELETE, 
				null, 
				Void.class);
		
		log.debug("Delete User call " + response.getStatusCode().toString());
	}	
}
