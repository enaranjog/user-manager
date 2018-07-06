package com.enrique.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.enrique.entities.PlayerEntity;

public interface PlayerScoreRepository extends CrudRepository<PlayerEntity, Long> {
	Optional<PlayerEntity> findByNameIgnoreCase(String name);
}
