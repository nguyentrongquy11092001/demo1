package com.iuh.ktln.quysang.service;

import java.util.List;

import com.iuh.ktln.quysang.model.Levels;

public interface LevelService {
	
	//Thêm Level
    Levels createLevel(Levels level);
    
	//Hiển thị tất cả Level
    List<Levels> getAllLevels();
    
    //Lấy Level theo id
    Levels getLevelById(Long levelId);
    
    //Chỉnh sửa Level theo id
    Levels updateLevel(Levels updatedLevel, Long levelId);
    
    //Xóa Level theo id
    String deleteLevel(Long levelId);
}
