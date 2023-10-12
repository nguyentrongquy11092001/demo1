package com.iuh.ktln.quysang.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "stories")
public class Stories {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	private Long unitId;
	private String storyName;
	private String videoUrl;
    private String imageUrl; // URL on Cloudinary
	public Stories() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Stories(Long id, Long unitId, String storyName, String videoUrl, String imageUrl) {
		super();
		this.id = id;
		this.unitId = unitId;
		this.storyName = storyName;
		this.videoUrl = videoUrl;
		this.imageUrl = imageUrl;
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
	public String getStoryName() {
		return storyName;
	}
	public void setStoryName(String storyName) {
		this.storyName = storyName;
	}
	public String getVideoUrl() {
		return videoUrl;
	}
	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	
}
