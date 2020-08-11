package com.samuelvaldes.lookify.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.samuelvaldes.lookify.models.Song;

@Repository
public interface SongRepository extends CrudRepository<Song, Long>{
	
	 // this method retrieves all the songs from the database
    List<Song> findAll();
    // this method find a song by the name of the artist
    List<Song> findByArtistContaining(String search);
    // this method retrieves the top 5 songs in descendant order
    List<Song> findTop5ByOrderByRatingDesc();
	
    
}
