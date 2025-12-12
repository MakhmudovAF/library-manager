public class Magazine extends Publication {
    private String publisher;
    private int issueNumber;

    public Magazine(String title, String publisher, int publicationYear, int issueNumber) {
        super(title, publicationYear);
        this.publisher = publisher;
        this.issueNumber = issueNumber;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getIssueNumber() {
        return issueNumber;
    }

    public void setIssueNumber(int issueNumber) {
        this.issueNumber = issueNumber;
    }

    @Override
    public String toString() {
        return "Magazine{" +
                "publisher='" + publisher + '\'' +
                ", issueNumber=" + issueNumber +
                ", title='" + title + '\'' +
                ", publicationYear=" + publicationYear +
                '}';
    }
}