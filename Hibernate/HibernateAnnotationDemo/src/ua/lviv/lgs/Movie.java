package ua.lviv.lgs;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.CascadeType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "movie")
public class Movie implements java.io.Serializable {
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "MOVIE_ID", unique = true, nullable = false)
	private Integer movieId;
	@Column(name = "MOVIE_NAME", unique = true, nullable = false, length = 20)
	private String movieName;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "movie_category", joinColumns = { @JoinColumn(name = "MOVIE_ID", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "CATEGORY_ID", nullable = false, updatable = false) })
	private Set<Category> categories = new HashSet<Category>(0);

	public Movie() {
	}

	public Movie(String movieName) {
		this.movieName = movieName;
	}

	public Movie(String movieName, Set<Category> categories) {
		this.movieName = movieName;
		this.categories = categories;
	}

	public Integer getStockId() {
		return this.movieId;
	}

	public void setStockId(Integer stockId) {
		this.movieId = stockId;
	}

	public String getMovieName() {
		return this.movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public Set<Category> getCategories() {
		return this.categories;
	}

	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}

}
