package com.iuh.ktln.quysang.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.iuh.ktln.quysang.model.Phonics;
import com.iuh.ktln.quysang.model.Stories;

@Repository
public interface PhonicRepository extends JpaRepository<Phonics, Long> {
	@Query("SELECT p FROM Phonics p WHERE p.unitId = :unitId")
    List<Phonics> findPhonicsByUnitId(@Param("unitId") Long unitId);
}
