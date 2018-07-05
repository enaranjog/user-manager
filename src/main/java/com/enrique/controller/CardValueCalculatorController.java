package com.enrique.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.validation.constraints.NotNull;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.enrique.entities.PlayerEntity;
import com.enrique.managers.ClueCardManager;
import com.enrique.managers.SettingManager;
import com.enrique.model.CardCalculatorException;
import com.enrique.model.Counter;
import com.enrique.services.BrokenCheckerService;
import com.enrique.services.CounterComparator;
import com.enrique.services.ValuesCalculatorService;

@RestController
public class CardValueCalculatorController {

	private BrokenCheckerService brokenCheckerService;
	private ValuesCalculatorService valuesCalculatorService;
	private CounterComparator counterComparator;
	private ClueCardManager clueCardManager;
	private SettingManager settingManager;

	@Inject
	public CardValueCalculatorController(BrokenCheckerService brokenCheckerService,
			ValuesCalculatorService valuesCalculatorService, CounterComparator counterComparator,
			ClueCardManager clueCardManager, SettingManager settingManager) {
		this.brokenCheckerService = brokenCheckerService;
		this.valuesCalculatorService = valuesCalculatorService;
		this.counterComparator = counterComparator;
		this.clueCardManager = clueCardManager;
		this.settingManager = settingManager;
	}

	@GetMapping(value = "/duplicated_cards")
	public String areDuplicates() {
		brokenCheckerService.areDuplicates();
		return "Everything is fine";
	}

	@RequestMapping(value = "/get_images")
	public List<PlayerEntity> getImageUrls(@RequestParam("setting") String setting) {
		System.out.println(clueCardManager.getImageUrlsBySetting(setting));
		return clueCardManager.getAllClueCardsBySetting(settingManager.getSettingByName(setting));
	}

	@RequestMapping(value = "/calculate_final_area")
	@ResponseBody
	public List<Counter> calculateFinalArea(@RequestParam("cards-names") @NotNull String cardsNames,
			@RequestParam("setting") @NotNull String setting) {
		if(StringUtils.isEmpty(cardsNames)) {
			throw new CardCalculatorException("'cards-names' is not present.");
		}
		List<String> listOfCards = Arrays.asList(cardsNames.split("-"));
		clueCardManager.addClueCardsBySetting(setting);
		brokenCheckerService.cardsBelongToCorrectSetting(listOfCards, setting);
		return valuesCalculatorService
				.calculateFinalArea(
						listOfCards.stream().map(clueCardManager::getCardByName).collect(Collectors.toList()))
				.stream().sorted(counterComparator).collect(Collectors.toList());
	}

	@RequestMapping(value = "/count_all_cards")
	public List<String> countAllCardsValues(@RequestParam("setting") String setting) {
		return prepareToDisplay(valuesCalculatorService.countAllCardsValuesForASetting(setting));
	}

	private List<String> prepareToDisplay(List<Counter> listOfCounters) {
		return listOfCounters.stream().sorted(counterComparator).map(Counter::toString).collect(Collectors.toList());
	}
}
