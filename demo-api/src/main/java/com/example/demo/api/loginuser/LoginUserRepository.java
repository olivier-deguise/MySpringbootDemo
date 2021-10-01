package com.example.demo.api.loginuser;


import org.springframework.data.repository.CrudRepository;

public interface LoginUserRepository extends CrudRepository<LoginUser, Long>{

		LoginUser findByUserName(String userName);
}
