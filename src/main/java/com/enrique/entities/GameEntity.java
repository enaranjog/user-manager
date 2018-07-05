package com.enrique.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "u_game")
public class GameEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;
	private String setting;

	protected GameEntity() {
	}

	public GameEntity(String name, String setting) {
		super();
		this.name = name;
		this.setting = setting;
	}

	public String getName() {
		return name;
	}

	public String getSetting() {
		return setting;
	}

	@Override
	public String toString() {
		return String.format("Game [name='%s', setting='%s', id=%d]", name, setting, id);
	}
}
