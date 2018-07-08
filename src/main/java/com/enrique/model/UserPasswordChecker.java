package com.enrique.model;

import com.enrique.entities.UserEntity;

public class UserPasswordChecker {

	private UserEntity userEntity;
	private String confirmPassword;

	public UserPasswordChecker() {
	}

	public UserPasswordChecker(UserEntity userEntity, String confirmPassword) {
		this.userEntity = userEntity;
		this.confirmPassword = confirmPassword;
	}

	public void validatePassword() {
		if (!userEntity.getPassword().equals(confirmPassword)) {
			throw new UserManagementException("Las dos contraseñas no coinciden");
		}
	}

	public UserEntity getUserEntity() {
		return userEntity;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	@Override
	public String toString() {
		return "UserPasswordChecker [userEntity=" + userEntity + ", passwordMatch="
				+ confirmPassword.equals(userEntity.getPassword()) + "]";
	}
}