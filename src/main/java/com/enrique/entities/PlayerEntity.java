package com.enrique.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "u_players")
public class PlayerEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;
	private String game;
	private String userEmail;

	protected PlayerEntity() {
	}

	public PlayerEntity(Long id, String name, String game, String userEmail) {
		this.id = id;
		this.name = name;
		this.game = game;
		this.userEmail = userEmail;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getGame() {
		return game;
	}

	public String getUserEmail() {
		return userEmail;
	}

	@Override
	public String toString() {
		return String.format("Player [name='%s', game='%s', userEmail='%s', id=%d]", name, game, userEmail, id);
	}

}