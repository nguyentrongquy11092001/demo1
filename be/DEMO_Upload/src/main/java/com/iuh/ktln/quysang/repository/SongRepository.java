package com.iuh.ktln.quysang.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.iuh.ktln.quysang.model.Songs;
import com.iuh.ktln.quysang.model.Stories;

@Repository
public interface SongRepository extends JpaRepository<Songs, Long> {
	@Query("SELECT s FROM Songs s WHERE s.unitId = :unitId")
    List<Songs> findSongsByUnitId(@Param("unitId") Long unitId);
}
