package com.enrique.managers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

import com.enrique.entities.GameEntity;
import com.enrique.model.CardCalculatorException;
import com.enrique.repositories.SettingRepository;

public class SettingManager {

	private List<GameEntity> listOfSettings = new ArrayList<>();
	private List<GameEntity> allSettings = new ArrayList<>();

	@Inject
	public SettingManager(SettingRepository repo) {
		repo.findAll().forEach(allSettings::add);
	}

	public void addSetting(GameEntity setting) {
		listOfSettings.add(setting);
	}

	public List<GameEntity> getAllSettings() {
		return allSettings;
	}

	public GameEntity getSettingByName(String name) {
		List<GameEntity> filteredList = allSettings.stream().filter(e -> e.getName().equalsIgnoreCase(name)).collect(Collectors.toList());
		if(filteredList == null || filteredList.isEmpty()) {
			throw new CardCalculatorException("There is no setting with name " + name + " among settings " + allSettings);
		}
		return filteredList.get(0);
	}

}
