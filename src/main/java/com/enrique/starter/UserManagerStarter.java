package com.enrique.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.enrique.controller.UserManagementController;
import com.enrique.managers.GameManager;
import com.enrique.managers.PlayerManager;
import com.enrique.managers.UserManager;
import com.enrique.repositories.GameRepository;
import com.enrique.repositories.PlayerRepository;
import com.enrique.repositories.UserRepository;
import com.enrique.security.CheckUserAndPasswordService;

@EnableJpaRepositories(basePackages = { "com.enrique.repositories" })
@SpringBootApplication(scanBasePackages={"com.enrique.security", "com.enrique.managers", "com.enrique.controller"})
@EntityScan(basePackages = { "com.enrique.entities" })
public class UserManagerStarter {

	public static void main(String[] args) {
		SpringApplication.run(UserManagerStarter.class, args);
	}
}
