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

@RestController
public class UserManagementController {

	private UserManager userManager;

	@Inject
	public UserManagementController(UserManager userManager) {
		this.userManager = userManager;
	}

	@PostMapping(value = "/register_user")
	@ResponseBody
	public void registerUser(@RequestBody UserEntity user) {
		System.out.println(user);
	}

	@GetMapping(value = "/retrieve_user")
	@ResponseBody
	public UserEntity retrieveUser(@RequestParam("user_email") String userEmail,
			@RequestParam("password") String password) {
		return userManager.getUserByEmail(userEmail, password);
	}
}
