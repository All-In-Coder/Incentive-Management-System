package com.example.Incentive.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.example.Incentive.entities.Sold_Vehicle;

public interface Vehicle_Sold_DAO extends JpaRepository<Sold_Vehicle,Long>{
	
	@Transactional
    @Query(value = "select * from Sold_Vehicle V where V.sid = ?1", nativeQuery = true)
    List<Sold_Vehicle> getId(long sid);
	
}
