package moviecatalog.interfaces;

import java.util.ArrayList;
import java.util.List;

import moviecatalog.models.Movie;

public interface IMovieCatalog {

    public void addMovie(Movie movie);

    public boolean deleteMovie(String title);

    public Movie getMovie(String title);

    public boolean updateMovie(Movie newMovie);

    public List<Movie> getMovies();
}
