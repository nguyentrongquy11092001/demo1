package com.iuh.ktln.quysang.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iuh.ktln.quysang.model.Levels;

@Repository
public interface LevelRepository extends JpaRepository<Levels, Long>{
	List<Levels> findAllByOrderByLevelNameAsc();
	
}
