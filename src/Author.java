import java.util.List;
import java.util.ArrayList;

public class Author {
    private final int id;
    private final List<Book> booksWritten;
    private final String name;

    public Author(int id, String name) {
        this.id = id;
        this.booksWritten = new ArrayList<>();
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public List<Book> getBooksWritten() {
        return booksWritten;
    }

    public String getName() {
        return name;
    }
}