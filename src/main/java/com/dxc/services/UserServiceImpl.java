package com.dxc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxc.exception.IncorrectPassExcep;
import com.dxc.exception.UserExistExcep;
import com.dxc.exception.UserNotFoundException;
import com.dxc.model.User;
import com.dxc.repository.UserRepository;
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User newUser(User user) throws UserExistExcep {
		final boolean existById = this.userRepository.existsById(user.getUserId());
		if(existById) {
			throw new UserExistExcep("User Already Exists");
		}
		return this.userRepository.save(user);
	}

	@Override
	public void updateUserById(User user) {
		userRepository.save(user);
	}
	
	@Override
	public void deleteUserById(String userid){
		Optional<User> user=userRepository.findById(userid);
		if(user.isPresent()) {
			userRepository.deleteById(userid);
		
			userRepository.deleteById(userid);
		}
	}

	@Override
	public Optional<User> getUserById(String userid) {
		return userRepository.findById(userid);
	}
	
	@Override
	public String authenticateUser(String userId, String userPassword)
			throws UserNotFoundException, IncorrectPassExcep {
		final Optional<User> optionalUser = this.userRepository.findByUserIdAndUserPassword(userId, userPassword);
		if(optionalUser.isEmpty()) {
			throw new UserNotFoundException("User Not Found");
		}
		return "Logged in";
	}

	@Override
	public String authenticateUserlogout(String userId, String userPassword) throws UserNotFoundException, IncorrectPassExcep{
		
		final Optional<User> optionalUser = this.userRepository.findByUserIdAndUserPassword(userId, userPassword);
		if(optionalUser.isEmpty()) {
			throw new UserNotFoundException("User Not Found");
		}
		return "Logged out";
	}
	
}
