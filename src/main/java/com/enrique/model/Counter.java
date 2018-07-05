package com.enrique.model;

import java.util.ArrayList;
import java.util.List;

import com.enrique.entities.UserEntity;
import com.enrique.entities.PlayerEntity;
import com.enrique.managers.ClueCardManager;

public class Counter {

	private UserEntity city;
	private List<PlayerEntity> allClueCards = new ArrayList<>();
	private ClueCardManager clueCardManager;

	public Counter(UserEntity city, ClueCardManager clueCardManager) {
		this.city = city;
		this.allClueCards = new ArrayList<>();
		this.clueCardManager = clueCardManager;
	}

	public UserEntity getCity() {
		return city;
	}

	public void setCity(UserEntity city) {
		this.city = city;
	}

	public List<PlayerEntity> getAllClueCards() {
		return allClueCards;
	}

	public void setListOfClueCards(List<PlayerEntity> listOfClueCards) {
		this.allClueCards = listOfClueCards;
	}

	public void addCard(PlayerEntity card) {
		this.allClueCards.add(card);
	}

	public Integer getAreaValue() {
		return this.allClueCards.stream().mapToInt(PlayerEntity::getValue).sum();
	}

	public PlayerEntity getCardWithMaxValue() {
		return clueCardManager
				.getCardByValue(this.getAllClueCards().stream().mapToInt(PlayerEntity::getValue).max().getAsInt());
	}

	@Override
	public String toString() {
		return "El valor de la zona de " + city.getName() + " es de " + getAreaValue();
	}

}
