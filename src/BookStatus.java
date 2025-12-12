public enum BookStatus {
    AVAILABLE("Доступна"),
    BORROWED("Выдана"),
    RESERVED("Зарезервирована"),
    LOST("Утеряна");

    private final String description;

    BookStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}