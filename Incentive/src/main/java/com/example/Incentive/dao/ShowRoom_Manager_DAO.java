package com.example.Incentive.dao;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.example.Incentive.entities.ShowRoom_Manager;

public interface ShowRoom_Manager_DAO extends JpaRepository<ShowRoom_Manager,Long> {
	@Transactional
    @Query(value = "select sid from show_room_manager", nativeQuery = true)
    List<Long> getId();
}
