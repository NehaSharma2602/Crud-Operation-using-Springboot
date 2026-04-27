package edu.qs.service;

import edu.qs.model.entity.Movie;

public interface MovieService {
	public boolean addMovie(Movie movie);
	
	public Movie findMovieById(int id );
	
	public Movie deleteMovieById(int id);
	
	public Movie MovieUpdate(Movie m);

	
}
