package com.iuh.ktln.quysang.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "phonics")

public class Phonics {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	private Long unitId;
    private String name;
    private String imageUrl; // URL on Cloudinary
    private String audioUrl;
    private String mean;
    
    
	public Phonics() {
		super();
	}


	public Phonics(Long id, Long unitId, String name, String imageUrl, String audioUrl, String mean) {
		super();
		this.id = id;
		this.unitId = unitId;
		this.name = name;
		this.imageUrl = imageUrl;
		this.audioUrl = audioUrl;
		this.mean = mean;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Long getUnitId() {
		return unitId;
	}


	public void setUnitId(Long unitId) {
		this.unitId = unitId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getImageUrl() {
		return imageUrl;
	}


	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}


	public String getAudioUrl() {
		return audioUrl;
	}


	public void setAudioUrl(String audioUrl) {
		this.audioUrl = audioUrl;
	}


	public String getMean() {
		return mean;
	}


	public void setMean(String mean) {
		this.mean = mean;
	}
    
}
