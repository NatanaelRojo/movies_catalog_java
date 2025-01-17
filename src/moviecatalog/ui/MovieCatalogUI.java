package moviecatalog.ui;

import javax.swing.JOptionPane;

import moviecatalog.models.Movie;
import moviecatalog.models.MovieCatalog;

public class MovieCatalogUI {

    private MovieCatalog catalog;
    private String title;

    public MovieCatalogUI() {
        this.catalog = new MovieCatalog();
    }

    public void showGeneral() {
        outer: while (true) {
            String option = JOptionPane.showInputDialog(
                    null,
                    "1. Add a movie\n2. Delete a movie\n3. Get a movie\n4. Update a movie\n5. List all movies\n6. Exit",
                    "Movies Catalog",
                    JOptionPane.INFORMATION_MESSAGE);

            switch (option) {
                case "1":
                    this.addMovie();
                    break;
                case "2":
                    this.deleteMovie();
                    break;
                case "3":
                    this.getMovie();
                    break;
                case "4":
                    this.updateMovie();
                    break;
                case "5":
                    this.listAllMovies();
                    break;
                case "6":
                    break outer;
                default:
                    JOptionPane.showMessageDialog(null,
                            "Invalid option", "Error",
                            JOptionPane.ERROR_MESSAGE);
                    break;
            }
        }
    }

    private void addMovie() {
        this.title = JOptionPane.showInputDialog("Title: ");
        String description = JOptionPane.showInputDialog("Description: ");
        int rating = Integer.parseInt(JOptionPane.showInputDialog("Rating: "));
        catalog.addMovie(new Movie(title, description, rating));
    }

    private void deleteMovie() {
        this.title = JOptionPane.showInputDialog("Title: ");
        Movie foundMovie = catalog.getMovie(title);

        if (!foundMovie.isEmpty()) {
            catalog.deleteMovie(this.title);
            JOptionPane.showMessageDialog(null,
                    "Movie deleted", "Success",
                    JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        JOptionPane.showMessageDialog(null,
                "Movie not found", "Error",
                JOptionPane.ERROR_MESSAGE);
    }

    private void getMovie() {
        this.title = JOptionPane.showInputDialog("Title: ");
        Movie foundMovie = catalog.getMovie(title);

        if (foundMovie.isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "Movie not found", "Error",
                    JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(
                    null,
                    foundMovie.toString(),
                    "Movie",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void updateMovie() {
        this.title = JOptionPane.showInputDialog("Enter the title of the movie you want to update: ");
        Movie foundMovie = catalog.getMovie(title);
        if (!foundMovie.isEmpty()) {
            String newTitle = JOptionPane.showInputDialog("Title: ");
            String newDescription = JOptionPane.showInputDialog("Description: ");
            int newRating = Integer.parseInt(JOptionPane.showInputDialog("Rating: "));
            catalog.updateMovie(new Movie(newTitle, newDescription, newRating));
            JOptionPane.showMessageDialog(null,
                    "Movie updated", "Success",
                    JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        JOptionPane.showMessageDialog(null,
                "Movie not found", "Error",
                JOptionPane.ERROR_MESSAGE);
    }

    private void listAllMovies() {
        if (!catalog.getMovies().isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    catalog.getMovies(),
                    "Movies Catalog",
                    JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        JOptionPane.showMessageDialog(null,
                "No movies found", "Error",
                JOptionPane.ERROR_MESSAGE);
    }
}
