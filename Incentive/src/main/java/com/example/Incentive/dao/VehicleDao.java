package com.example.Incentive.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.example.Incentive.entities.Vehicle;

public interface VehicleDao extends JpaRepository<Vehicle, Long> {
         
	@Transactional
    @Query(value = "select vid from Vehicle V where V.Vname = ?1", nativeQuery = true)
    String getId(String VName);
	
}
