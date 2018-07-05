package com.enrique.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.enrique.controller.CardValueCalculatorController;
import com.enrique.managers.CityManager;
import com.enrique.managers.ClueCardManager;
import com.enrique.managers.SettingManager;
import com.enrique.repositories.CityRepository;
import com.enrique.repositories.ClueCardRepository;
import com.enrique.repositories.SettingRepository;
import com.enrique.services.BrokenCheckerService;
import com.enrique.services.CounterComparator;
import com.enrique.services.CounterService;
import com.enrique.services.ValuesCalculatorService;

@EnableJpaRepositories(basePackages = { "com.enrique.repositories" })
@SpringBootApplication()
@EntityScan(basePackages = { "com.enrique.entities" })
public class CardCalculatorStarter {

	public static void main(String[] args) {
		SpringApplication.run(CardCalculatorStarter.class, args);
	}

	@Bean
	public CounterService counterService(ClueCardManager clueCardManager, CityManager cityManager) {
		return new CounterService(clueCardManager, cityManager);
	}

	@Bean
	public ValuesCalculatorService valuesCalculatorService(CounterService counterService,
			ClueCardManager clueCardManager, SettingManager settingManager) {
		return new ValuesCalculatorService(counterService, clueCardManager, settingManager);
	}

	@Bean
	public BrokenCheckerService brokenCheckerService(ClueCardManager clueCardManager) {
		return new BrokenCheckerService(clueCardManager);
	}

	@Bean
	public CounterComparator counterComparator() {
		return new CounterComparator();
	}

	@Bean
	public CityManager cityManager(CityRepository repo) {
		return new CityManager(repo);
	}

	@Bean
	public SettingManager settingManager(SettingRepository repo) {
		return new SettingManager(repo);
	}

	@Bean
	public ClueCardManager clueCardManager(ClueCardRepository repo) {
		return new ClueCardManager(repo);
	}

	@Bean
	public CardValueCalculatorController cardValueCalculatorController(BrokenCheckerService brokenCheckerService,
			ValuesCalculatorService valuesCalculatorService, CounterComparator counterComparator,
			ClueCardManager clueCardManager, SettingManager settingManager) {
		return new CardValueCalculatorController(brokenCheckerService, valuesCalculatorService, counterComparator,
				clueCardManager, settingManager);
	}
}
