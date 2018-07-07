package com.enrique.controller;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.enrique.entities.UserEntity;
import com.enrique.managers.UserManager;
import com.enrique.model.UserPasswordChecker;

@RestController
public class UserManagementController {

	private UserManager userManager;

	@Inject
	public UserManagementController(UserManager userManager) {
		this.userManager = userManager;
	}

	@PostMapping(value = "/register_user")
//	@ResponseBody
	public String registerUser(@RequestBody UserPasswordChecker userPasswordChecker) {
		System.out.println(userPasswordChecker);
		userManager.registerUser(userPasswordChecker);
		return "User successfully registered: " + userPasswordChecker.getUserEntity().getEmail();
	}

	@GetMapping(value = "/retrieve_user")
	@ResponseBody
	public UserEntity retrieveUser(@RequestParam("user_email") String userEmail,
			@RequestParam("password") String password) {
		return userManager.getUserByEmail(userEmail, password);
	}
}
