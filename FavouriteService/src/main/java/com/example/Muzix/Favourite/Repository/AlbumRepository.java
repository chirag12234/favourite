package com.example.Muzix.Favourite.Repository;



import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.Muzix.Favourite.Model.AlbumUser;

/*
* This class is implementing the MongoRepository interface for Note.
* Annotate this class with @Repository annotation
* */

@Repository
public interface AlbumRepository extends MongoRepository<AlbumUser, String> {

}
