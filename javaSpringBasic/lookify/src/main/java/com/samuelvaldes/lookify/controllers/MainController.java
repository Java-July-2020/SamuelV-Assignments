package com.samuelvaldes.lookify.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.samuelvaldes.lookify.models.Song;
import com.samuelvaldes.lookify.services.SongService;

@Controller
public class MainController {

	
	// I) Attributes and Constructor for Controller
	
	private final SongService songService;
	
	public MainController (SongService songService) {
		this.songService = songService;
	}
	
	
	// I) Show index
	
	@RequestMapping("/")
	public String showIndex() {	
		return "index.jsp";
	}
	
	// II) Show dashboard with all songs
	
	@RequestMapping("/dashboard")
	public String showAllSongs(Model model) {
		List<Song> songs = songService.allSongs();
		model.addAttribute("songs", songs);
		return "songDashboard.jsp";
	}
	
	// III) Search top five songs
	
	@RequestMapping("/search/topSongs")
	public String searchTopSongs(Model model) {
		List<Song> topSongs = songService.topSongs();
		model.addAttribute("topSongs", topSongs);
		return "searchTopSongs.jsp";
	}
	
	// IV) Search songs by Artist
	
	@RequestMapping("/songs/search")
	public String findSongByArtist(Model model,@RequestParam(value="artist", required=false) String artist) {
		System.out.println("Heyyy");
		List<Song> songsByArtist = songService.findSongByArtist(artist);
		model.addAttribute("artist", artist);
		model.addAttribute("songsByArtist", songsByArtist);
		return "searchByArtist.jsp";
	}
	
	// V) Search songs by Id
	
	@RequestMapping("/songs/{index}")
	public String findSong(Model model, @PathVariable("index") Long id) {
		Song song = songService.findSongById(id);
		model.addAttribute("song", song);
		return "showSong.jsp";
	}
	
	// VI) Create new song (two methods, one with a GET and other with POST request)
	
	// GET Request
	@RequestMapping("/songs/new")
	public String newSong(@ModelAttribute("song") Song song) {
		return "newSong.jsp";
	}
	
	// POST Request
	@RequestMapping(value="/songs/new", method=RequestMethod.POST)
	public String createSong(@Valid @ModelAttribute("song") Song song, BindingResult result) {
		if(result.hasErrors()) {
			return "newSong.jsp";
		}
		else {
			songService.createSong(song);
			return "redirect:/dashboard";
		}
	}
	
	// VII) Update a song (two methods, one with a GET and other with POST request)
	
	// GET Request
	@RequestMapping("/songs/edit/{id}")
	public String editSong(@PathVariable("id") Long id, Model model ) {
		Song song = songService.findSongById(id);
		if (song != null) {
			model.addAttribute("song",song);
			return "editSong.jsp";
		}
		else {
			return "redirect:/songs";
		}
	}
	
	// POST Request
	@RequestMapping(value="/songs/edit/{id}", method=RequestMethod.POST)
	public String updateSong(@PathVariable("id") Long id, @Valid @ModelAttribute("song") Song song, BindingResult result) {
		
		if (result.hasErrors()) {
			return "editSong.jsp";
		}
		else {
			songService.updateSong(song);
			return "redirect:/dashboard";
		}
		
	}
	
	// VIII) Delete a song 
	
	// GET Request
	@RequestMapping("/songs/delete/{id}")
    public String deleteSong(@PathVariable("id") Long id) {
        songService.deleteSong(id);
        return "redirect:/dashboard";
    }
	
	
}
