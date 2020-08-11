package com.samuelvaldes.lookify.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.samuelvaldes.lookify.models.Song;
import com.samuelvaldes.lookify.repositories.SongRepository;


@Service
public class SongService {

	// adding the song repository as a dependency
	private final SongRepository songRepository;
	
	public SongService(SongRepository songRepository) {
		this.songRepository = songRepository;
	}
	
	// return all the songs
	public List<Song> allSongs(){
		return this.songRepository.findAll();
	}
	
	// creates a song
	public Song createSong(Song song) {
		return this.songRepository.save(song);
	}
	
	// retrieves a song by id
	public Song findSongById(Long id) {
		return this.songRepository.findById(id).orElse(null);
	}
	
	// retrieves a songs by Artist
	public List<Song> findSongByArtist(String artist) {
		return this.songRepository.findByArtistContaining(artist);	
	}
	
	// retrieves top five songs
	public List<Song> topSongs() {
		return this.songRepository.findTop5ByOrderByRatingDesc();
	}
	
	// update Book
	public Song updateSong(Song updatedSong) {
		return this.songRepository.save(updatedSong);
    }
	
	// delete book
	public void deleteSong(Long id) {
		this.songRepository.deleteById(id);
	}
}
