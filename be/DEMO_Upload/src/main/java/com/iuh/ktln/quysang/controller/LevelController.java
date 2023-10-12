package com.iuh.ktln.quysang.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iuh.ktln.quysang.model.Levels;
import com.iuh.ktln.quysang.service.LevelService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/levels")
public class LevelController {
	@Autowired
	private LevelService levelService;

	// Lưu Level
	@PostMapping("/saveLevel")
	public ResponseEntity<?> saveLevel(@RequestBody Levels levels) {
		return new ResponseEntity<>(levelService.createLevel(levels), HttpStatus.CREATED);
	}

	// Hiển thị tất cả Level
	@GetMapping("/getAllLevels")
	public ResponseEntity<?> getAllLevels() {
		return new ResponseEntity<>(levelService.getAllLevels(), HttpStatus.OK);
	}

	// Tìm Level theo id
	@GetMapping("/getLevelById/{levelId}")
	public ResponseEntity<?> getLevelById(@PathVariable Long levelId) {
		return new ResponseEntity<>(levelService.getLevelById(levelId), HttpStatus.OK);
	}

	// Xóa Level theo id
	@GetMapping("/deleteLevel/{levelId}")
	public ResponseEntity<?> deleteLevel(@PathVariable Long levelId) {
		return new ResponseEntity<>(levelService.deleteLevel(levelId), HttpStatus.OK);
	}

	// Cập nhật Level theo id
	@PostMapping("/editLevel/{levelId}")
	public ResponseEntity<?> editLevel(@RequestBody Levels levels, @PathVariable Long levelId) {
		return new ResponseEntity<>(levelService.updateLevel(levels, levelId), HttpStatus.CREATED);
	}
}

