package com.enrique.repositories;

import org.springframework.data.repository.CrudRepository;

import com.enrique.entities.GameEntity;

public interface SettingRepository extends CrudRepository<GameEntity, Long> {
	GameEntity findByName(String name);
}
