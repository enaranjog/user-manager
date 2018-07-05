package com.enrique.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

import com.enrique.entities.PlayerEntity;
import com.enrique.managers.ClueCardManager;
import com.enrique.model.CardCalculatorException;

public class BrokenCheckerService {

	private ClueCardManager clueCardManager;

	@Inject
	public BrokenCheckerService(ClueCardManager clueCardManager) {
		this.clueCardManager = clueCardManager;
	}

	public void cardsBelongToCorrectSetting(List<String> clueCards, String setting) {
		List<PlayerEntity> filteredList = clueCards.stream().map(clueCardManager::getCardByNameAmongAllCards)
				.filter(cc -> !cc.getSetting().equalsIgnoreCase(setting)).collect(Collectors.toList());
		if (!filteredList.isEmpty()) {
			throw new CardCalculatorException("The setting " + setting + " does not contain the following cards: "
					+ filteredList.stream().map(PlayerEntity::getName).collect(Collectors.toList()));
		}
	}

	public void areDuplicates() {
		// Set<ClueCardEnum> cards = new HashSet<>();
		// for(ClueCardEnum card : ClueCardEnum.values()){
		// if(cards.contains(card)){
		// throw new CardCalculatorException("Hay cartas duplicadas");
		// }
		// cards.add(card);
		// }
	}

	public void checkDuplicatedValues() {
		// Set<Integer> cards = new HashSet<>();
		// for(ClueCardEnum card : ClueCardEnum.values()){
		// if(cards.contains(card.getValue())){
		// throw new CardCalculatorException("Hay valores repetidos");
		// }
		// cards.add(card.getValue());
		// }
	}
}
