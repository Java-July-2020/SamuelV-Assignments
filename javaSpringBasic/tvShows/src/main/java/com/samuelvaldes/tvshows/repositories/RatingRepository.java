package com.samuelvaldes.tvshows.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.samuelvaldes.tvshows.models.Rating;
import com.samuelvaldes.tvshows.models.Show;

@Repository
public interface RatingRepository extends CrudRepository<Rating, Long>{

	// retrieves all ratings from database
	List<Rating> findAll();
	// retrieves all ratings from a Show in descending order
	List<Rating> findByShowRatedOrderByScoreAsc(Show show);
	}
