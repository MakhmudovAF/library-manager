public interface Borrowable {
    boolean borrow(String readerId);
    boolean returnItem();
    boolean isAvailable();
}