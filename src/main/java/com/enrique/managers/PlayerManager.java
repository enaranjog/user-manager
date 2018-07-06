package com.enrique.managers;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.enrique.entities.PlayerEntity;
import com.enrique.repositories.PlayerRepository;

@Service
public class PlayerManager {

	private PlayerRepository playerRepo;

	@Inject
	public PlayerManager(PlayerRepository playerRepo) {
		this.playerRepo = playerRepo;
	}
	
	public PlayerEntity getPlayerByName(String name) {
		return playerRepo.findByNameIgnoreCase(name).orElse(new PlayerEntity(null, null, null, null));
		//TODO check if we should throw an exception here
	}
}