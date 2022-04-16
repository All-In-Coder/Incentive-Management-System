package com.example.Incentive.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.example.Incentive.entities.SalesPerson;



public interface SalesPersonDoa extends JpaRepository<SalesPerson, Long>{
	@Transactional
    @Query(value = "select count(*) from Sales_Person SP where SP.SPhone = ?1", nativeQuery = true)
    int getUserPresentOrNot(String SPhone);
	
	@Transactional
    @Query(value = "select sid from Sales_Person SP where SP.SPhone = ?1", nativeQuery = true)
    String getId(String SPhone);


}
