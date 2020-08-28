package com.samuelvaldes.tvshows.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.samuelvaldes.tvshows.models.Show;

@Repository
public interface ShowRepository extends CrudRepository<Show, Long>{

	// retrieves all shows from database
	List<Show> findAll();
	

}
