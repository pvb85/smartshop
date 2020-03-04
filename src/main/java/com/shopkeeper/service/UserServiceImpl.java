package com.shopkeeper.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopkeeper.dao.UserRepository;
import com.shopkeeper.exceptions.UserNotFoundException;
import com.shopkeeper.model.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	public User login(String userName, String password) {

		User user = userRepository.findByUserNameAndUserPasword(userName, password);

		return user;

	}

	public String registerUser(User user) {
		String result = null;
		String nameiffail = user.getUserName();
		try {
			System.out.println(user.getUserId());

			userRepository.save(user);

			String name = user.getUserName();
			result = "Hi " + name + "  you Successfully registed";
			return result;
		} catch (Exception e) {
			System.out.println(e);
			return "Hi " + nameiffail + "  your registration is failued ";
		}

	}

}
