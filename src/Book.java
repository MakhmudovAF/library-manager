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
            this.currentReaderId = null;
            return true;
        }
        return false;
    }

    @Override
    public boolean isAvailable() {
        return status == BookStatus.AVAILABLE;
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