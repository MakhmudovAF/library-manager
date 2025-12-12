public class Book extends Publication {
    private final Author author;
    private final Genre genre;
    private boolean isAvailable;

    public Book(String id, int year, Author author, String title, Genre genre) {
        super(id, year, title);
        this.author = author;
        this.genre = genre;
    }

    public Author getAuthor() {
        return author;
    }

    public Genre getGenre() {
        return genre;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}