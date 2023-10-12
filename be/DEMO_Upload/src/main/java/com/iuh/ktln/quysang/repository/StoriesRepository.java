package com.iuh.ktln.quysang.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.iuh.ktln.quysang.model.Stories;
import com.iuh.ktln.quysang.model.UnitModel;
@Repository
public interface StoriesRepository  extends JpaRepository<Stories, Long>{
	@Query("SELECT st FROM Stories st WHERE st.unitId = :unitId")
    List<Stories> findStoriesByUnitId(@Param("unitId") Long unitId);
}
