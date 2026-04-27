package edu.qs.model.entity;

public class Movie {
	
	private Integer id ;
	private String name;
	private Double rating;
	private String genre;
	
	public Movie() {
		// TODO Auto-generated constructor stub
	}

	public Movie(Integer id, String name, Double rating, String genre) {
		super();
		this.id = id;
		this.name = name;
		this.rating = rating;
		this.genre = genre;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", name=" + name + ", rating=" + rating + ", genre=" + genre + "]";
	}
	
	
	
	
	
	
	
	
}
