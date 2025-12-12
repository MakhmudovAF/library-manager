import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Library {
    private final Map<String, Book> booksById;
    private final List<Publication> allPublications;
    private final Map<Genre, Integer> genreStatistics;
    private final Map<String, List<Book>> borrowedBooks;
    private final BookShelf[] shelves;

    public static final int MAX_SHELVES = 10;

    public Library() {
        this.booksById = new HashMap<>();
        this.allPublications = new ArrayList<>();
        this.genreStatistics = new HashMap<>();
        this.borrowedBooks = new HashMap<>();
        this.shelves = new BookShelf[MAX_SHELVES];

        for (int i = 0; i < MAX_SHELVES; i++) {
            shelves[i] = new BookShelf("Полка " + (i + 1));
        }

        for (Genre genre : Genre.values()) {
            genreStatistics.put(genre, 0);
        }
    }

    public boolean addBook(Book book) {
        if (book == null || booksById.containsKey(book.getId())) {
            return false;
        }

        booksById.put(book.getId(), book);

        if (!allPublications.contains(book)) allPublications.add(book);

        Genre genre = book.getGenre();
        genreStatistics.put(genre, genreStatistics.get(genre) + 1);

        for (BookShelf shelf : shelves) {
            if (!shelf.isFull()) {
                shelf.addBook(book);
                break;
            }
        }

        return true;
    }

    public void addPublication(Publication publication) {
        allPublications.add(publication);

        if (publication instanceof Book) {
            addBook((Book) publication);
        }
    }

    public Book findBookById(String id) {
        return booksById.get(id);
    }

    public List<Book> findBooksByAuthor(String author) {
        List<Book> result = new ArrayList<>();
        for (Book book : booksById.values()) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                result.add(book);
            }
        }
        return result;
    }

    public boolean borrowBook(String bookId, String readerId) {
        Book book = findBookById(bookId);
        if (book != null && book.borrow(readerId)) {
            borrowedBooks.computeIfAbsent(readerId, k -> new ArrayList<>())
                    .add(book);
            return true;
        }
        return false;
    }

    public boolean returnBook(String bookId) {
        Book book = findBookById(bookId);
        if (book != null && book.returnItem()) {
            String readerId = book.getCurrentReaderId();
            book.setCurrentReaderId(null);
            if (readerId != null && borrowedBooks.containsKey(readerId)) {
                borrowedBooks.get(readerId).remove(book);
            }
            return true;
        }
        return false;
    }

    public Map<Genre, Integer> getGenreStatistics() {
        return new HashMap<>(genreStatistics);
    }

    public int countBooksByGenre(Genre genre) {
        return genreStatistics.getOrDefault(genre, 0);
    }

    public List<Book> getBorrowedBooksByReader(String readerId) {
        List<Book> books = borrowedBooks.get(readerId);
        return books != null ? new ArrayList<>(books) : new ArrayList<>();
    }

    public List<Publication> getAllPublications() {
        return new ArrayList<>(allPublications);
    }

    public List<Book> getAllBooks() {
        return new ArrayList<>(booksById.values());
    }

    public BookShelf[] getShelves() {
        BookShelf[] copy = new BookShelf[shelves.length];
        System.arraycopy(shelves, 0, copy, 0, shelves.length);
        return copy;
    }

    public static void printLibraryInfo(Library library) {
        System.out.println("=== ИНФОРМАЦИЯ О БИБЛИОТЕКЕ ===");
        System.out.println("Всего публикаций: " + library.allPublications.size());
        System.out.println("Всего книг: " + library.booksById.size());

        System.out.println("\nСтатистика по жанрам:");
        for (Map.Entry<Genre, Integer> entry : library.genreStatistics.entrySet()) {
            System.out.printf("  %s: %d книг\n", entry.getKey().getDescription(), entry.getValue());
        }

        System.out.println("\nСостояние полок:");
        for (BookShelf shelf : library.shelves) {
            System.out.println("  " + shelf);
        }
    }
}