package edu.qs.controller;


import java.util.ListIterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.qs.model.entity.Movie;
import edu.qs.model.response_structure.ResponseStructure;
import edu.qs.service.MovieService;

@RestController
public class MovieController {
	
	@Autowired
	MovieService movieService;
	
	/*@PostMapping("/movie")
	public String addMovie(@RequestBody Movie movie) {
		
		boolean result = movieService.addMovie(movie);
		
		if(result) {
			return "movie added successfully";
		}
		return "falied to add movie";
		
		
	}*/
	
	@PostMapping("/movie")
	public ResponseEntity<ResponseStructure<Movie>> addMovie(@RequestBody Movie movie){
		ResponseStructure<Movie> rs = new ResponseStructure<Movie>();
		
		boolean result = movieService.addMovie(movie);
		
		if(result) {
			rs.setStatus(HttpStatus.OK.value());
			rs.setMessage("Movie added");
			rs.setData(movie);
			return new ResponseEntity<ResponseStructure<Movie>>(rs, HttpStatus.OK);
		}
		else {
			rs.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			rs.setMessage("failed to add movie");
			rs.setData(null);
			return new ResponseEntity<ResponseStructure<Movie>>(rs, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
	/*@GetMapping("/movie/{id}")
	public Movie findMovieById(@PathVariable int id ) {
		
		Movie movie = movieService.findMovieById(id);
		if(movie != null) {
			return movie;
			
		}
		return null;
	}*/
	
	// using just 'response structure' we can only control response body
	/*@GetMapping("/movie/{id}")
	public Movie findMovieById(@PathVariable int id ) {
		
		ResponseStructure<Movie> rs = new ResponseStructure<Movie>();
		Movie movie = movieService.findMovieById(id);
		if(movie != null) {
			rs.setStatus(HttpStatus.FOUND.value());
			rs.setMessage("Movie Found");
			rs.setData(movie);
			return rs;
			
		}
		else {
			rs.setStatus(HttpStatus.NOT_FOUND.value());
			rs.setMessage("Movie not Found");
			rs.setData(null);
			return rs;
		}
	}
	*/
	
	// ResponseEntity =>We can control full response (status, header, body)
	@GetMapping("/movie/{id}")
	public ResponseEntity<ResponseStructure<Movie>> findMovieById(@PathVariable int id){
		ResponseStructure<Movie> rs = new ResponseStructure<Movie>();
		
		Movie movie = movieService.findMovieById(id);
		
		if(movie != null) {
			rs.setStatus(HttpStatus.FOUND.value());
			rs.setMessage("Movie Found");
			rs.setData(movie);
			HttpHeaders hh = new HttpHeaders();
			hh.set("message", "Found");
			
			return new ResponseEntity<ResponseStructure<Movie>>(rs,hh,HttpStatus.FOUND);
			
		}
		else {
			rs.setStatus(HttpStatus.NOT_FOUND.value());
			rs.setMessage("Movie not Found");
			rs.setData(null);
			HttpHeaders hh = new HttpHeaders();
			hh.set("message", "Not Found");
			
			return new ResponseEntity<ResponseStructure<Movie>>(rs,hh,HttpStatus.NOT_FOUND);
		}
	}
	
	
	@DeleteMapping("/movie")
	public ResponseEntity<ResponseStructure<Movie>> deleteMovieById(@PathVariable int id){
		ResponseStructure<Movie> rs = new ResponseStructure<Movie>();
		
		Movie movie = movieService.deleteMovieById(id);
		
		if(movie != null) {
			rs.setStatus(HttpStatus.OK.value());
			rs.setMessage("Movie Deleted");
			rs.setData(movie);
			
			return new ResponseEntity<ResponseStructure<Movie>>(rs,HttpStatus.OK);
			
		}
		else {
			rs.setStatus(HttpStatus.NOT_FOUND.value());
			rs.setMessage("Movie not Found");
			rs.setData(null);
			
			return new ResponseEntity<ResponseStructure<Movie>>(rs,HttpStatus.NOT_FOUND);
		}
	}
	
	
	@PutMapping("/movie/{id}")
	public ResponseEntity<ResponseStructure<Movie>> UpdateMovie(@PathVariable Movie m){
		ResponseStructure<Movie> rs = new ResponseStructure<Movie>();
		
		Movie movie = movieService.MovieUpdate(m);
		
		if(movie != null) {
			rs.setStatus(HttpStatus.OK.value());
			rs.setMessage("Movie Updated");
			rs.setData(movie);
			
			return new ResponseEntity<ResponseStructure<Movie>>(rs,HttpStatus.OK);
			
		}
		else {
			rs.setStatus(HttpStatus.NOT_FOUND.value());
			rs.setMessage("Movie not Found");
			rs.setData(null);
			
			return new ResponseEntity<ResponseStructure<Movie>>(rs,HttpStatus.NOT_FOUND);
		}
	}
	
	
	
	
	
	
	
}
