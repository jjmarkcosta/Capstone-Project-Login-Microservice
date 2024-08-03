package com.nmscinema.Capstone_Project_Login_Microservice.repository;

import org.springframework.data.repository.CrudRepository;

import com.nmscinema.Capstone_Project_Login_Microservice.model.User;

public interface UserRepository extends CrudRepository<User, Integer>{

}
