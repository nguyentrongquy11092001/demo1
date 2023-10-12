package com.iuh.ktln.quysang.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.iuh.ktln.quysang.model.UnitModel;

@Repository
public interface UnitRepository extends JpaRepository<UnitModel, Long> {
    // Các phương thức tùy chỉnh nếu cần
	@Query("SELECT u FROM UnitModel u WHERE u.levelId = :levelId")
    List<UnitModel> findUnitsByLevelId(@Param("levelId") Long levelId);
	
	@Query("SELECT u.unitId FROM UnitModel u WHERE u.unitName = :unitName")
    Long findUnitIdByUnitName(@Param("unitName") String unitName);
}
