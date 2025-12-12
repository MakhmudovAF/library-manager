public abstract class Publication {
    protected final String id;
    protected final int publicationYear;
    protected final String title;

    private static int idCounter = 1000;

    public Publication(String title, int publicationYear) {
        this.id = "PUB" + (idCounter++);
        this.publicationYear = publicationYear;
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Publication{" +
                "id='" + id + '\'' +
                ", publicationYear=" + publicationYear +
                ", title='" + title + '\'' +
                '}';
    }
}