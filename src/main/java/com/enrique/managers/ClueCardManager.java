package com.enrique.managers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

import com.enrique.entities.PlayerEntity;
import com.enrique.entities.GameEntity;
import com.enrique.model.CardCalculatorException;
import com.enrique.repositories.ClueCardRepository;

public class ClueCardManager {

	private List<PlayerEntity> listOfClueCards = new ArrayList<>();
	private List<PlayerEntity> allClueCards = new ArrayList<>();
	private String setting;

	private static final String COULD_NOT_FIND_CARD = "Could not find a card with value: %s in setting %s";

	@Inject
	public ClueCardManager(ClueCardRepository repo) {
		repo.findAll().forEach(allClueCards::add);
	}

	public void reset() {
		listOfClueCards.clear();
	}

	public void addClueCardsBySetting(String setting) {
		reset();
		this.setting = setting;
		listOfClueCards = allClueCards.stream()
				.filter(clueCardEntity -> clueCardEntity.getSetting().equalsIgnoreCase(setting))
				.collect(Collectors.toList());
	}

	public List<String> getImageUrlsBySetting(String setting) {
		addClueCardsBySetting(setting);
		return listOfClueCards.stream().map(PlayerEntity::getUrl).collect(Collectors.toList());
	}

	public List<PlayerEntity> getAllClueCards() {
		return allClueCards;
	}

	public List<PlayerEntity> getAllClueCardsBySetting(GameEntity setting) {
		this.setting = setting.getName();
		return allClueCards.stream().filter(cc -> cc.getSetting().equalsIgnoreCase(setting.getName()))
				.collect(Collectors.toList());
	}

	public PlayerEntity getCardByValue(Integer value) {
		List<PlayerEntity> clueCardGet = listOfClueCards.stream()
				.filter(clueCardEntity -> clueCardEntity.getValue() == value).collect(Collectors.toList());
		if (clueCardGet == null || clueCardGet.isEmpty()) {
			throw new CardCalculatorException(String.format(COULD_NOT_FIND_CARD, value, this.setting));
		} else {
			return clueCardGet.get(0);
		}
	}

	public PlayerEntity getCardByName(String name) {
		List<PlayerEntity> clueCardGet = listOfClueCards.stream().filter(cc -> cc.getName().equalsIgnoreCase(name))
				.collect(Collectors.toList());
		if (clueCardGet == null || clueCardGet.isEmpty()) {
			throw new CardCalculatorException(String.format(COULD_NOT_FIND_CARD, name, this.setting));
		} else {
			return clueCardGet.get(0);
		}
	}

	public PlayerEntity getCardByNameAmongAllCards(String name) {
		List<PlayerEntity> clueCardGet = allClueCards.stream().filter(cc -> cc.getName().equalsIgnoreCase(name))
				.collect(Collectors.toList());
		if (clueCardGet == null || clueCardGet.isEmpty()) {
			throw new CardCalculatorException(String.format(COULD_NOT_FIND_CARD, name, this.setting));
		} else {
			return clueCardGet.get(0);
		}
	}
}
