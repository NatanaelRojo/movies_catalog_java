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
                    "1. Add a movie\n2. Delete a movie\n3. Get a movie\n4. Update a movie\n5. Exit",
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
        catalog.deleteMovie(new Movie(title, "", 0));
    }

    private void getMovie() {
        this.title = JOptionPane.showInputDialog("Title: ");
        Movie foundMovie = catalog.getMovie(title);
        JOptionPane.showMessageDialog(
                null,
                foundMovie.toString(),
                "Movie",
                JOptionPane.INFORMATION_MESSAGE);
    }

    private void updateMovie() {
        this.title = JOptionPane.showInputDialog("Title: ");
        String description = JOptionPane.showInputDialog("Description: ");
        int rating = Integer.parseInt(JOptionPane.showInputDialog("Rating: "));
        catalog.updateMovie(title, new Movie(title, description, rating));
    }
}
