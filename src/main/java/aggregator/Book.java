package aggregator;

import java.net.URI;

public class Book {
    private String author;
    private String bookName;
    private URI download;

    public Book() {
    }


    public String getAuthor() {
        return author;
    }

    public String getBookName() {
        return bookName;
    }

    public URI getDownload() {
        return download;
    }

}
