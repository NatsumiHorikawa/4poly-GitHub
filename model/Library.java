package model;

public class Library {

    private String isbn;
    private String title;
    private String author;
    private String publisher;
    private String overview;

    public Library () {}

    public Library(String isbn, String title, String author, String publisher, String overview) {
        super();
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.overview = overview;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getOverview() {
        return overview;
    }


}