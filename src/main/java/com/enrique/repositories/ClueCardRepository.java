package com.enrique.repositories;

import org.springframework.data.repository.CrudRepository;

import com.enrique.entities.PlayerEntity;
public interface ClueCardRepository extends CrudRepository<PlayerEntity, Long> {
	PlayerEntity findByName(String name);
}
