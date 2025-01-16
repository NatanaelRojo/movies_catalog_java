package moviecatalog.interfaces;

import moviecatalog.models.Movie;

public interface IMovieCatalog {

    public void addMovie(Movie movie);

    public boolean deleteMovie(Movie movie);

    public Movie getMovie(String title);

    public boolean updateMovie(Movie movie);
}
