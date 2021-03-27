package com.example.Muzix.Favourite.Model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class AlbumUser {
	
	@Id
	private String userId;
	private List<Album> album;
	
	public AlbumUser()
	{
		
	}
	
	public AlbumUser(String userId,List<Album> album) {
		super();
		this.album = album;
		this.userId = userId;
	}
	public List<Album> getAlbums() {
		return album;
	}
	public void setAlbums(List<Album> album) {
		this.album = album;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

}
