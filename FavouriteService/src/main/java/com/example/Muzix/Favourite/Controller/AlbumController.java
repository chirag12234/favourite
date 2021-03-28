package com.example.Muzix.Favourite.Controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.Muzix.Favourite.Model.Album;
import com.example.Muzix.Favourite.Model.AlbumUser;
import com.example.Muzix.Favourite.Service.AlbumService;
import java.util.List;
@RestController
@RequestMapping("api/v1/favourites")
@CrossOrigin(origins="http://localhost:4200")
public class AlbumController {
	@Autowired
	private AlbumService albumService;
	@GetMapping("/{id}")
	public ResponseEntity<?> getAllFavourites(@PathVariable() String id){
		List<Album> favourites = albumService.getAllAlbumsByUserId(id);
		if(favourites!=null)
			return new ResponseEntity<List<Album>>(favourites,HttpStatus.OK);
			else
				return new ResponseEntity<String>("No favourites found",HttpStatus.OK);
		
}// which one
	//post mapping one
	@PostMapping
	public ResponseEntity<?> addFavourite(@RequestBody Album album){
		boolean status = albumService.addFavourite(album);
		if(status)
			return new ResponseEntity<Album>(album,HttpStatus.CREATED);
		else
			return new ResponseEntity<String>("Album not added",HttpStatus.CONFLICT);

}
	@DeleteMapping("/{userId}/{albumid}")
	public ResponseEntity<?> deleteFavourite(@PathVariable() String userId,@PathVariable() String albumid) 
	{
		
			boolean status = albumService.deleteFavourite(userId, albumid);
			if(status)
		     return new ResponseEntity<String>("Favourite deleted",HttpStatus.OK);
			else
				return new ResponseEntity<String>("Favourite not present",HttpStatus.CONFLICT);
				
	
	}
}