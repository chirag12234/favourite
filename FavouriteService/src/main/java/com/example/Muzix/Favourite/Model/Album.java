package com.example.Muzix.Favourite.Model;


public class Album {


	private String userId;
	private String name;
	private String artistName;
	private String albumName;
	private String albumId;
	
	public Album() {
		
	}
	
	public Album(String userId, String name, String artistName, String albumName, String albumId) {
		super();
		this.userId = userId;
		this.name = name;
		this.artistName = artistName;
		this.albumName = albumName;
		this.albumId = albumId;
	}
	public String getuserId() {
		return userId;
	}
	public void setuserId(String id) {
		this.userId = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getArtistName() {
		return artistName;
	}
	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}
	public String getAlbumName() {
		return albumName;
	}
	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}
	public String getAlbumId() {
		return albumId;
	}
	public void setAlbumId(String albumId) {
		this.albumId = albumId;
	}
	@Override
	public String toString() {
		return "Track [id=" + userId + ", name=" + name + ", artistName=" + artistName + ", albumName=" + albumName
				+ ", albumId=" + albumId + "]";
	}
	
}
