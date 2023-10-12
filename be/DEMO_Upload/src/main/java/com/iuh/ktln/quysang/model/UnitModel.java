package com.iuh.ktln.quysang.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UnitModel {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long unitId;

    private String unitName;
    private String status;
    private Long levelId;
	public UnitModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public UnitModel(Long unitId, String unitName, String status, Long levelId) {
		super();
		this.unitId = unitId;
		this.unitName = unitName;
		this.status = status;
		this.levelId = levelId;
	}

	public Long getUnitId() {
		return unitId;
	}
	public void setUnitId(Long unitId) {
		this.unitId = unitId;
	}
	public String getUnitName() {
		return unitName;
	}
	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Long getLevelId() {
		return levelId;
	}
	public void setLevelId(Long levelId) {
		this.levelId = levelId;
	}
    
}
