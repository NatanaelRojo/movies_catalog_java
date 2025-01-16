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
    public boolean deleteMovie(Movie movie) {
        return this.movies.remove(movie);
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
    public boolean updateMovie(String title, Movie newMovie) {
        for (Movie movie : this.movies) {
            if (title.equals(movie.getTitle())) {
                movie.setTitle(newMovie.getTitle());
                movie.setDescription(newMovie.getDescription());
                movie.setRating(newMovie.getRating());
                return true;
            }
        }

        return false;
    }

}
