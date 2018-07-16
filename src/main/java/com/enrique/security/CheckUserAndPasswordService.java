package com.enrique.security;

import org.springframework.stereotype.Service;

import com.enrique.entities.UserEntity;
import com.enrique.model.UserManagementException;
import com.enrique.repositories.UserRepository;

@Service
public class CheckUserAndPasswordService {

	private UserRepository userRepo;

	public CheckUserAndPasswordService(UserRepository userRepo) {
		this.userRepo = userRepo;
	}

	public void checkUserAndPassword(String email, String password) {
		if (!password.equals(
				userRepo.findByEmailIgnoreCase(email).orElse(new UserEntity(null, null, null, null)).getPassword())) {
			throw new UserManagementException(String.format("The password for user email %s is not correct.", email));
		}
	}
}
