package com.dxc.controller;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.dxc.exception.UserExistExcep;
import com.dxc.model.User;
import com.dxc.services.UserService;


@RestController
@RequestMapping("/user")
public class UserController {

	@GetMapping("/greet")
    public String welcome(){
        return "User Controller page is working";
    }
	
	@Autowired
	private UserService service;
	
	@PostMapping("/newuser")
	public User registerUser(@RequestBody User user) throws UserExistExcep {
		return this.service.newUser(user);
	}
	
	@PutMapping("/updateuser")
    public String updateuser(@RequestBody User user){
		service.updateUserById(user);
		return "user updated";
    }
	
	@DeleteMapping("/deleteuser/{userid}")
    public String deleteUser(@PathVariable String userid){
		service.deleteUserById(userid);
		return "user deleted";	
    }
	
	@GetMapping("/retriveuser/{userid}")
	 public Optional<User> getUserById(@PathVariable String userid){
		 return service.getUserById(userid);
	 }
}
