package com.enrique.entities;

import javax.persistence.Column;
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

	private Integer position;
	private String game;
	private String userEmail;
	
	
	`id` INT NOT NULL AUTO_INCREMENT,
	  `name` VARCHAR(200) NOT NULL,
	  `game` VARCHAR(200) NOT NULL,
	  `user_email` VARCHAR(200) NOT NULL,
	  `created` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
	  `modified`

	protected PlayerEntity() {
	}

	public PlayerEntity(String name, Integer scoreEnrollments, Integer scoreCredits, Integer position,
			String game, String userEmail) {
		super();
		this.name = name;
		this.scoreEnrollments = scoreEnrollments;
		this.scoreCredits = scoreCredits;
		this.position = position;
		this.game = game;
		this.userEmail = userEmail;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Integer getScoreEnrollments() {
		return scoreEnrollments;
	}

	public Integer getScoreCredits() {
		return scoreCredits;
	}

	public Integer getPosition() {
		return position;
	}

	public String getGame() {
		return game;
	}

	public String getUserEmail() {
		return userEmail;
	}

	@Override
	public String toString() {
		return String.format(
				"Player [name='%s', scoreEnrollments='%s', scoreCredits='%s', "
						+ "position='%s', game='%s', userEmail='%s', id=%d]",
				name, scoreEnrollments, scoreCredits, position, game, userEmail, id);
	}

}