package com.enrique.managers;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.enrique.entities.UserEntity;
import com.enrique.model.UserManagementException;
import com.enrique.model.UserPasswordChecker;
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
		return userRepo.findByEmailIgnoreCase(email)
				.orElseThrow(() -> new UserManagementException("There is no user with email " + email));
	}

	public boolean registerUser(UserPasswordChecker userPasswordChecker) {
		userPasswordChecker.validatePassword();
		UserEntity userEntity = userPasswordChecker.getUserEntity();
		userRepo.save(userEntity);
		return true;
	}
}
