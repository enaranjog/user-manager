package com.enrique.services;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.inject.Inject;

import com.enrique.entities.PlayerEntity;
import com.enrique.managers.ClueCardManager;
import com.enrique.managers.SettingManager;
import com.enrique.model.Counter;

public class ValuesCalculatorService {

	private CounterService counterService;
	private ClueCardManager clueCardManager;
	private SettingManager settingManager;

	@Inject
	public ValuesCalculatorService(CounterService counterService, ClueCardManager clueCardManager,
			SettingManager settingManager) {
		this.counterService = counterService;
		this.clueCardManager = clueCardManager;
		this.settingManager = settingManager;
	}

	public List<Counter> countAllCardsValuesForASetting(String setting) {
		return calculateFinalArea(clueCardManager.getAllClueCardsBySetting(settingManager.getSettingByName(setting)));
	}

	public List<Counter> calculateFinalArea(List<PlayerEntity> clueCards) {
		return counterService.counterWithCityValues(clueCards).stream().filter(Objects::nonNull)
				.collect(Collectors.toList());
	}
}
