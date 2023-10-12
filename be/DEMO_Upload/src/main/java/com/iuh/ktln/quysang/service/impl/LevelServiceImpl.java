package com.iuh.ktln.quysang.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iuh.ktln.quysang.model.Levels;
import com.iuh.ktln.quysang.repository.LevelRepository;
import com.iuh.ktln.quysang.service.LevelService;

@Service
public class LevelServiceImpl implements LevelService {
	@Autowired
	private LevelRepository levelRepository;

	@Override
	public Levels createLevel(Levels level) {
		// TODO Auto-generated method stub
		return levelRepository.save(level);
	}

	@Override
	public List<Levels> getAllLevels() {
		// TODO Auto-generated method stub
		return levelRepository.findAllByOrderByLevelNameAsc();
	}

	@Override
	public Levels getLevelById(Long levelId) {
		// TODO Auto-generated method stub
		return levelRepository.findById(levelId).get();
	}

	@Override
	public Levels updateLevel(Levels updatedLevel, Long levelId) {
		// TODO Auto-generated method stub
		Levels oldLevels = levelRepository.findById(levelId).get();
		
		oldLevels.setLevelName(updatedLevel.getLevelName());
		return null;
	}

	@Override
	public String deleteLevel(Long levelId) {
		// TODO Auto-generated method stub
		Levels levels = levelRepository.findById(levelId).get();
		if(levels != null) {
			levelRepository.delete(levels);
			return "Delete Successfully";
		}
		return "Error on Server";
	}
}
