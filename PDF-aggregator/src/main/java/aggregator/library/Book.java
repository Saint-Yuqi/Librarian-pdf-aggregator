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

    public void setAuthor(String author) {
        this.author = author;
    }
    public void setMD5(String MD5) {
        this.MD5 = MD5;
    }

   public void setBookName(String bookName) {
        this.bookName = bookName;
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

    @Override
    public int getYear() {
        return 0;
    }


    public int getSize() {
        return size;
    }

}
