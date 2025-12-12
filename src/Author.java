import java.util.List;
import java.util.ArrayList;

public class Author {
    private static int authorCounter = 1;

    private final int authorId;
    private String name;

    private List<Book> booksWritten;

    public Author(String name) {
        this.authorId = authorCounter++; // Использование статического счетчика
        this.name = name;
        this.booksWritten = new ArrayList<>();
    }

    public static int getTotalAuthors() {
        return authorCounter;
    }

    public void addBook(Book book) {
        if (book != null && !booksWritten.contains(book)) {
            booksWritten.add(book);
        }
    }

    public void removeBook(Book book) {
        booksWritten.remove(book);
    }

    public static int getAuthorCounter() {
        return authorCounter;
    }

    public static void setAuthorCounter(int authorCounter) {
        Author.authorCounter = authorCounter;
    }

    public int getAuthorId() {
        return authorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBooksWritten() {
        return new ArrayList<>(booksWritten);
    }

    public void setBooksWritten(List<Book> booksWritten) {
        this.booksWritten = booksWritten;
    }

    @Override
    public String toString() {
        return "Author{" +
                "authorId=" + authorId +
                ", name='" + name + '\'' +
                ", booksWritten=" + booksWritten +
                '}';
    }
}