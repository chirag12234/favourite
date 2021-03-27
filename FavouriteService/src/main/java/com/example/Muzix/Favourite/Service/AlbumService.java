package com.example.Muzix.Favourite.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Muzix.Favourite.Model.Album;
import com.example.Muzix.Favourite.Model.AlbumUser;
import com.example.Muzix.Favourite.Repository.AlbumRepository;

@Service
public class AlbumService {

	
	
	@Autowired
	private AlbumRepository albumrepo;
	 List<Album> albumlist = null;
	private AlbumUser albumUser;
	

public boolean addFavourite(Album album) {
		
		
		
		if(albumrepo.existsById(album.getuserId()))
		{
			albumUser = albumrepo.findById(album.getuserId()).get();
			
			albumUser.getAlbums().add(album);
			if(albumrepo.save(albumUser)!=null)
				return true;
			else
				return false;
		
			
		}
		else
		{
			albumUser = new AlbumUser();
			albumUser.setUserId(album.getuserId());
			 albumlist = new ArrayList<Album>();
			 albumlist .add(album);	
			albumUser.setAlbums(albumlist);
			if(albumrepo.insert(albumUser)!=null)
				return true;
			else
				return false;
		
			
			
		}
		
	}



	public List<Album> getAllAlbumsByUserId(String userId) {
		 
		albumlist = albumrepo.findById(userId).get().getAlbums();
		return albumlist;
	}
   public boolean deleteFavourite(String userId, String albumId) {
		
		AlbumUser albumuser = new AlbumUser();
		albumlist = albumrepo.findById(userId).get().getAlbums();
		if(!albumlist.isEmpty())
		{
			Iterator<Album> itr = albumlist.iterator();
			while(itr.hasNext())
			{
				Album album= (Album) itr.next();
				if((album.getAlbumId()).equals(albumId))
				{
					itr.remove();
				}
			}
			albumuser.setUserId(userId);
			albumuser.setAlbums(albumlist);
			albumrepo.save(albumuser);
			return true;
			
		}
		return false;
	}
}
