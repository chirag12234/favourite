package com.example.Muzix.Favourite.Exception;



public class AlbumAlreadyExistsException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public AlbumAlreadyExistsException(String message)
	{
		super(message);
	}
}
