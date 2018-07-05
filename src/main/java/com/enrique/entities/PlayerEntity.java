package com.enrique.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "m_clue_card")
public class PlayerEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;
	private String surname;
	
	@Column(name = "score_enrollments")
	private Integer scoreEnrollments;
	
	@Column(name = "score_credits")
	private String scoreCredits;
	private String game;
	private String user_email;

	protected PlayerEntity() {
	}


	@Override
	public String toString() {
		return "ClueCardEntity [id=" + id + ", city=" + city + ", name=" + name + ", value=" + value + ", setting="
				+ setting + "]";
	}


}