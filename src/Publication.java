public abstract class Publication {
    private final int id;
    private final int year;
    private final Author author;
    private String title;

    public Publication(int id, int year, Author author, String title) {
        this.id = id;
        this.year = year;
        this.author = author;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public int getYear() {
        return year;
    }

    public Author getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}