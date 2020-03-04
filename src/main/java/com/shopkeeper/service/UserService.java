package com.shopkeeper.service;

import com.shopkeeper.model.User;

public interface UserService {

	public User login(String userName, String password);

	public String registerUser(User user);

}
