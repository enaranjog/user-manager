package com.enrique.managers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

import com.enrique.entities.UserEntity;
import com.enrique.repositories.CityRepository;

public class CityManager {

	private List<UserEntity> listOfCities = new ArrayList<>();
	private List<UserEntity> allCities = new ArrayList<>();

	@Inject
	public CityManager(CityRepository repo) {
		repo.findAll().forEach(allCities::add);
	}

	public void addCity(UserEntity city) {
		listOfCities.add(city);
	}

	public List<UserEntity> getAllCities() {
		return allCities;
	}

	public UserEntity getCityByName(String name) {
		return allCities.stream().filter(c -> c.getName().equalsIgnoreCase(name)).collect(Collectors.toList()).get(0);
	}
}
