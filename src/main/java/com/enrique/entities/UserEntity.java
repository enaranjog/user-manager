package com.enrique.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "u_user")
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String userName;
	private String email;
	private String password;

	protected UserEntity() {
	}

	public UserEntity(Long id, String userName, String email, String setting) {
		this.id = id;
		this.userName = userName;
		this.email = email;
		this.password = setting;
	}
	
	public Long getId() {
		return id;
	}

	public String getName() {
		return userName;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	@Override
	public String toString() {
		return String.format("User [name='%s', email='%s', id=%d]", userName, email, id);
	}
}