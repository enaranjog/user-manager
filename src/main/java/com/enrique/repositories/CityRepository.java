package com.enrique.repositories;

import org.springframework.data.repository.CrudRepository;

import com.enrique.entities.UserEntity;

public interface CityRepository extends CrudRepository<UserEntity, Long> {
	UserEntity findByName(String name);
}
