package com.bway.springproject.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Gallery {
	@Id
	@GeneratedValue
	private int id;
	private String img_name;
	private long img_size;

	
}
