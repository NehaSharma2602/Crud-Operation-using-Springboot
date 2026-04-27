package edu.qs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import edu.qs.model.entity.Movie;
import edu.qs.model.repository.MovieRepository;

@Service // @Service will register the class as a java bean, we can also use @Component
@Primary
public class MovieServiceImpl implements MovieService{
	
	@Autowired
	MovieRepository movieRepo ; // DI 

	@Override
	public boolean addMovie(Movie movie) {
		return movieRepo.addMovie(movie);		
	}

	@Override
	public Movie findMovieById(int id) {
		
		return movieRepo.findMovieById(id);
	}
	
	@Override
	public Movie deleteMovieById(int id) {
		return movieRepo.deleteMovieById(id);
	}
	
	@Override
	public Movie MovieUpdate(Movie m) {
		return movieRepo.MovieUpdate(m);
	}
	
	
}
