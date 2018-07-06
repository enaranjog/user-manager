package com.enrique.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "u_player_score")
public class PlayerScoreEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "player_name")
	private String playerName;
	private String game;
	@Column(name = "score_enrollments")
	private Integer scoreEnrollments;

	@Column(name = "score_credits")
	private Integer scoreCredits;

	private Integer position;

	protected PlayerScoreEntity() {
	}

	public PlayerScoreEntity(Long id, String playerName, String game, Integer scoreEnrollments, Integer scoreCredits,
			Integer position) {
		this.id = id;
		this.playerName = playerName;
		this.game = game;
		this.scoreEnrollments = scoreEnrollments;
		this.scoreCredits = scoreCredits;
		this.position = position;
	}

	public Long getId() {
		return id;
	}

	public String getPlayerName() {
		return playerName;
	}

	public String getGame() {
		return game;
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

	@Override
	public String toString() {
		return String.format(
				"User [playerName='%s', game='%s', scoreEnrollments='%s', scoreCredits='%s', position='%s', id=%d]",
				playerName, game, scoreEnrollments, scoreCredits, position, id);
	}
}
