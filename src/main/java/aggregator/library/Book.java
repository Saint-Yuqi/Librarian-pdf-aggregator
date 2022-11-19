package aggregator.library;

import java.net.URI;

public class Book implements searchable{
    private String author;
    private String MD5;
    private String bookName;
    private String language;
    private URI download;
    private URI doi;
    private int year;
    private int size;

    public Book(String author, String bookName, String language, URI download, URI doi, int year,int size) {
        this.author = author;
        this.bookName = bookName;
        this.language = language;
        this.download = download;
        this.doi = doi;
        this.year = year;
        this.size = size;
    }


    public String getAuthor() {
        return author;
    }

    public String getBookName() {
        return bookName;
    }

    public String getLanguage() {
        return language;
    }


    public URI getDownload() {
        return download;
    }

    public String getMD5() {
        return MD5;
    }
    public int getYear() {
        return year;
    }

    public int getSize() {
        return size;
    }

}