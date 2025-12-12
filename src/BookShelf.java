import java.util.Arrays;

public class BookShelf {
    private final Book[] books;
    private int bookCount;
    private final String location;

    public static final int DEFAULT_SHELF_CAPACITY = 20;

    public BookShelf(String location) {
        this(location, DEFAULT_SHELF_CAPACITY);
    }

    public BookShelf(String location, int capacity) {
        this.books = new Book[capacity];
        this.bookCount = 0;
        this.location = location;
    }

    public boolean addBook(Book book) {
        if (book != null && bookCount < books.length) {
            books[bookCount++] = book;
            return true;
        }
        return false;
    }

    public boolean removeBook(Book book) {
        for (int i = 0; i < bookCount; i++) {
            if (books[i].equals(book)) {
                for (int j = i; j < bookCount - 1; j++) {
                    books[j] = books[j + 1];
                }
                books[--bookCount] = null;
                return true;
            }
        }
        return false;
    }

    public Book findBookByTitle(String title) {
        for (int i = 0; i < bookCount; i++) {
            if (books[i].getTitle().equalsIgnoreCase(title)) {
                return books[i];
            }
        }
        return null;
    }

    public Book[] getBooks() {
        Book[] copy = new Book[bookCount];
        System.arraycopy(books, 0, copy, 0, bookCount);
        return copy;
    }

    public int getBookCount() {
        return bookCount;
    }

    public String getLocation() {
        return location;
    }

    public boolean isFull() {
        return bookCount >= books.length;
    }

    public boolean isEmpty() {
        return bookCount == 0;
    }

    @Override
    public String toString() {
        return "BookShelf{" +
                "books=" + Arrays.toString(books) +
                ", bookCount=" + bookCount +
                ", location='" + location + '\'' +
                '}';
    }
}