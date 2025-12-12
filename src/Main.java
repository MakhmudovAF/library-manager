import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== ДЕМОНСТРАЦИЯ СИСТЕМЫ БИБЛИОТЕКИ ===\n");

        System.out.println("1. Создание массива книг:");
        Book[] booksArray = new Book[5];
        booksArray[0] = new Book("Война и мир", "Лев Толстой", 1869, Genre.FICTION);
        booksArray[1] = new Book("Преступление и наказание", "Федор Достоевский", 1866, Genre.FICTION);
        booksArray[2] = new Book("Краткая история времени", "Стивен Хокинг", 1988, Genre.SCIENCE);
        booksArray[3] = new Book("Автобиография", "Нельсон Мандела", 1994, Genre.BIOGRAPHY);
        booksArray[4] = new Book("Властелин колец", "Дж. Р. Р. Толкин", 1954, Genre.FANTASY);

        for (Book book : booksArray) {
            System.out.println("  " + book);
        }

        System.out.println("\n2. Создание и инициализация библиотеки:");
        Library library = new Library();

        for (Book book : booksArray) {
            library.addBook(book);
        }

        library.addBook(new Book("1984", "Джордж Оруэлл", 1949, Genre.FICTION));
        library.addBook(new Book("Мастер и Маргарита", "Михаил Булгаков", 1967, Genre.FICTION));

        System.out.println("\n3. Демонстрация полиморфизма:");
        Publication[] publications = new Publication[3];
        publications[0] = new Book("Анна Каренина", "Лев Толстой", 1877, Genre.FICTION);
        publications[1] = new Magazine("National Geographic", "National Geographic Society", 2023, 5);
        publications[2] = new Book("Гарри Поттер", "Джоан Роулинг", 1997, Genre.FANTASY);

        for (Publication pub : publications) {
            library.addPublication(pub);
            System.out.println("  Добавлена публикация: " + pub);
        }

        System.out.println("\n4. Поиск книги по ID (HashMap):");
        Book foundBook = library.findBookById("PUB1000");
        if (foundBook != null) {
            System.out.println("  Найдена книга: " + foundBook);
        }

        System.out.println("\n5. Все публикации в библиотеке (ArrayList):");
        List<Publication> allPubs = library.getAllPublications();
        for (Publication pub : allPubs) {
            System.out.println("  - " + pub);
        }

        System.out.println("\n6. Демонстрация выдачи и возврата книг:");
        String readerId = "READER001";
        boolean borrowed = library.borrowBook("PUB1000", readerId);
        System.out.println("  Книга выдана: " + borrowed);

        List<Book> readerBooks = library.getBorrowedBooksByReader(readerId);
        System.out.println("  Читатель " + readerId + " имеет книг: " + readerBooks.size());

        boolean returned = library.returnBook("PUB1000");
        System.out.println("  Книга возвращена: " + returned);

        System.out.println("\n8. Демонстрация работы с перечислениями:");
        System.out.println("  Доступные жанры:");
        for (Genre genre : Genre.values()) {
            int count = library.countBooksByGenre(genre);
            System.out.printf("    %s: %d книг\n", genre.getDescription(), count);
        }

        System.out.println("\n9. Состояние книжных полок (массивы):");
        BookShelf[] shelves = library.getShelves();
        for (BookShelf shelf : shelves) {
            if (!shelf.isEmpty()) {
                System.out.println("  " + shelf);
            }
        }

        System.out.println("\n10. Статистика библиотеки:");
        Library.printLibraryInfo(library);

        System.out.println("\n11. Демонстрация инкапсуляции:");
        Book testBook = new Book("Тест", "Автор", 2020, Genre.SCIENCE);
        
        System.out.println("  ID книги: " + testBook.getId());
        System.out.println("  Автор книги: " + testBook.getAuthor());

        System.out.println("\n=== ДЕМОНСТРАЦИЯ ЗАВЕРШЕНА ===");
    }
}