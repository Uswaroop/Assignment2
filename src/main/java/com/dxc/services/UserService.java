package com.dxc.services;

import java.util.List;
import java.util.Optional;

import com.dxc.exception.IncorrectPassExcep;
import com.dxc.exception.UserExistExcep;
import com.dxc.exception.UserNotFoundException;
import com.dxc.model.User;

public interface UserService {
	User newUser(User user) throws UserExistExcep;

	void updateUserById(User user);

	void deleteUserById(String userid);

	Optional<User> getUserById(String userid);

	String authenticateUser(String userId, String userPassword) throws UserNotFoundException, IncorrectPassExcep;

	String authenticateUserlogout(String userId, String userPassword) throws UserNotFoundException, IncorrectPassExcep;

	
}
