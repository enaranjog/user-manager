package com.enrique.managers;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.enrique.entities.UserEntity;
import com.enrique.repositories.UserRepository;
import com.enrique.security.CheckUserAndPasswordService;

@Service
public class UserManager {

	private UserRepository userRepo;
	private CheckUserAndPasswordService userPasswordService;

	@Inject
	public UserManager(UserRepository userRepo, CheckUserAndPasswordService userPasswordService) {
		this.userRepo = userRepo;
		this.userPasswordService = userPasswordService;
	}

	public UserEntity getUserByEmail(String email, String password) {
		userPasswordService.checkUserAndPassword(email, password);
		return userRepo.findByEmailIgnoreCase(email).orElse(new UserEntity(null, null, null, null));
		//TODO check if we should throw an exception here
	}
	
	public void saveOrUpdateUser(UserEntity userEntity) {
		
	}
}
