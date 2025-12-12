import java.util.Objects;

public class Book extends Publication implements Borrowable {
    private final String author;
    private final Genre genre;
    private BookStatus status;
    private String currentReaderId;

    public Book(String title, String author, int publicationYear, Genre genre) {
        super(title, publicationYear); // Вызов конструктора родительского класса
        this.author = author;
        this.genre = genre;
        this.status = BookStatus.AVAILABLE;
        this.currentReaderId = null;
    }

    public String getAuthor() {
        return author;
    }

    public Genre getGenre() {
        return genre;
    }

    public BookStatus getStatus() {
        return status;
    }

    public void setStatus(BookStatus status) {
        this.status = status;
        if (status != BookStatus.BORROWED) {
            this.currentReaderId = null;
        }
    }

    public String getCurrentReaderId() {
        return currentReaderId;
    }

    public void setCurrentReaderId(String currentReaderId) {
        this.currentReaderId = currentReaderId;
    }

    @Override
    public boolean borrow(String readerId) {
        if (isAvailable()) {
            this.status = BookStatus.BORROWED;
            this.currentReaderId = readerId;
            return true;
        }
        return false;
    }

    @Override
    public boolean returnItem() {
        if (status == BookStatus.BORROWED) {
            this.status = BookStatus.AVAILABLE;
            return true;
        }
        return false;
    }

    @Override
    public boolean isAvailable() {
        return status == BookStatus.AVAILABLE;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(author, book.author) && genre == book.genre && status == book.status && Objects.equals(currentReaderId, book.currentReaderId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(author, genre, status, currentReaderId);
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", genre=" + genre +
                ", status=" + status +
                ", title='" + title + '\'' +
                ", currentReaderId='" + currentReaderId + '\'' +
                '}';
    }
}