public abstract class Publication {
    protected final String id;
    protected final int year;
    protected final String title;

    public Publication(String id, int year, String title) {
        this.id = id;
        this.year = year;
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public int getYear() {
        return year;
    }

    public String getTitle() {
        return title;
    }
}