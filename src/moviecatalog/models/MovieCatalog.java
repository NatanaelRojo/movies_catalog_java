package moviecatalog.models;

import java.util.ArrayList;

import moviecatalog.interfaces.IMovieCatalog;

public class MovieCatalog implements IMovieCatalog {

    private final ArrayList<Movie> movies;

    public MovieCatalog() {
        this.movies = new ArrayList<>();
    }

    @Override
    public void addMovie(Movie movie) {
        this.movies.add(movie);
    }

    @Override
    public boolean deleteMovie(String title) {
        Movie foundMovie = this.getMovie(title);

        if (!foundMovie.isEmpty()) {
            return this.movies.remove(foundMovie);
        }

        return false;
    }

    @Override
    public Movie getMovie(String title) {
        Movie movieFounded = new Movie();

        for (Movie movie : this.movies) {
            if (movie.getTitle().equals(title)) {
                movieFounded = movie;
            }
        }

        return movieFounded;
    }

    @Override
    public boolean updateMovie(Movie newMovie) {
        for (Movie movie : this.movies) {
            if (movie.getTitle().equals(newMovie.getTitle())) {
                movie.setTitle(newMovie.getTitle());
                movie.setDescription(newMovie.getDescription());
                movie.setRating(newMovie.getRating());
                return true;
            }
        }

        return false;
    }

    public ArrayList<Movie> getMovies() {
        return this.movies;
    }
}
