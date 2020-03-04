package com.shopkeeper.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.shopkeeper.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

	public User findByUserNameAndUserPasword(String userName, String password);

	public User findByUserName(String userName);

}
