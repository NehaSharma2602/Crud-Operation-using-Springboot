package edu.qs.model.repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.springframework.stereotype.Repository;

import edu.qs.model.entity.Movie;

@Repository // @Repository will also register the class as java bean. WE can also use @Component also
public class MovieRepository {
	
	private List<Movie> movies;
	
	public MovieRepository() {
		movies = new ArrayList<Movie>();
	}
	
	
	public boolean addMovie(Movie movie) {
		
		movies.add(movie);
		return true;
	}
	
	
	public Movie findMovieById(int id ) {
		
		for(Movie m : movies) {
			if(m.getId() == id) {
				return m;
			}
		}
		
		return null;
		
	}
		
	public Movie deleteMovieById(int id) {
		Iterator<Movie> itr = movies.iterator();
		
		while(itr.hasNext()) {
			Movie temp = itr.next();
			if(temp.getId() == id){
				itr.remove();
				return temp;
			}
		}
		return null;
	}
	
	
	public Movie MovieUpdate(Movie movie) {
		ListIterator<Movie> itr = movies.listIterator();
		
		while(itr.hasNext()) {
			Movie temp = itr.next();
			if(temp.getId() == movie.getId()) {
			itr.set(movie);
			return movie;
			}
		}
		return null;
	}
	
	
	
	
	
}
