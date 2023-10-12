package com.iuh.ktln.quysang.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iuh.ktln.quysang.model.UnitModel;
import com.iuh.ktln.quysang.repository.UnitRepository;
import com.iuh.ktln.quysang.service.UnitService;

@Service
public class UnitServiceImpl implements UnitService{
	@Autowired
	private UnitRepository unitRepository;

	@Override
	public UnitModel createUnit(UnitModel unit) {
		// TODO Auto-generated method stub
		return unitRepository.save(unit);
	}
}
