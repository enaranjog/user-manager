package com.enrique.managers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.enrique.entities.GameEntity;
import com.enrique.model.UserManagementException;
import com.enrique.repositories.GameRepository;

@Service
public class GameManager {

	private GameRepository gameRepo;

	@Inject
	public GameManager(GameRepository gameRepo) {
		this.gameRepo = gameRepo;
	}

	public GameEntity getGameByName(String name) {
		return gameRepo.findByNameIgnoreCase(name).orElse(new GameEntity(null, null, null));
		//TODO check if we should throw an exception here
	}
	
	public void addNewGame(GameEntity gameEntity) {
		gameRepo.save(gameEntity);
	}

}
