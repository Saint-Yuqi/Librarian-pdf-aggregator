package aggregator.library;

import java.net.URI;

public class Article {
    private String year;
    private String publisher;
    private String subject;
    private String filed;
    private int size;
    private URI DOI;

    public String getYear() {
        return year;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setFiled() {
        this.filed = filed;
    }
    public int getSize() {
        return size;
    }




}
