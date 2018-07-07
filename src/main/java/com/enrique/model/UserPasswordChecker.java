package com.enrique.model;

import com.enrique.entities.UserEntity;

public class UserPasswordChecker {

	private UserEntity user;
	private String confirmPassword;

	public UserPasswordChecker() {
	}

	public UserPasswordChecker(UserEntity user, String confirmPassword) {
		this.user = user;
		this.confirmPassword = confirmPassword;
	}

	public void validatePassword() {
		if (!user.getPassword().equals(confirmPassword)) {
			throw new UserManagementException("Las dos contraseñas no coinciden");
		}
	}

	public UserEntity getUserEntity() {
		return user;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setUserEntity(UserEntity userEntity) {
		this.user = userEntity;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	@Override
	public String toString() {
		return "UserPasswordChecker [userEntity=" + user + ", passwordMatch="
				+ confirmPassword.equals(user.getPassword()) + "]";
	}
}