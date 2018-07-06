package com.enrique.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.enrique.entities.GameEntity;

public interface GameRepository extends CrudRepository<GameEntity, Long> {
	Optional<GameEntity> findByNameIgnoreCase(String name);
}
