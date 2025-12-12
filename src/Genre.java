public enum Genre {
    FICTION("Художественная литература"),
    NON_FICTION("Научно-популярная"),
    SCIENCE("Наука"),
    FANTASY("Фэнтези"),
    BIOGRAPHY("Биография"),
    HISTORY("История"),
    ROMANCE("Роман");

    private final String description;

    Genre(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}