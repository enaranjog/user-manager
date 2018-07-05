package com.enrique.services;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.validation.constraints.NotNull;

import com.enrique.entities.UserEntity;
import com.enrique.entities.PlayerEntity;
import com.enrique.managers.CityManager;
import com.enrique.managers.ClueCardManager;
import com.enrique.model.Counter;

public class CounterService {

	private ClueCardManager clueCardManager;
	private CityManager cityManager;

	@Inject
	public CounterService(ClueCardManager clueCardManager, CityManager cityManager) {
		this.clueCardManager = clueCardManager;
		this.cityManager = cityManager;
	}

	/*
	 * This method created dynamically the counters needed and stores in each of
	 * them the sum of all the clue cards
	 */
	public List<Counter> counterWithCityValues(@NotNull List<PlayerEntity> clueCards) {
		List<Counter> listOfCounters = new ArrayList<>();

		clueCards.stream().forEach(card -> {
			UserEntity city = cityManager.getCityByName(card.getCity());

			if (listOfCounters.stream().noneMatch(counter -> city.getName() == counter.getCity().getName())) {
				Counter counter = new Counter(city, clueCardManager);
				counter.addCard(card);
				listOfCounters.add(counter);
			} else {
				listOfCounters.stream().filter(counter -> counter.getCity() == city)
						.forEach(counter -> counter.addCard(card));
				// for (Counter counter : listOfCounters) {
				// if (counter.getCity() == city) {
				// counter.addCard(card);
				// }
				// }
			}
		});

		return listOfCounters;
	}
}