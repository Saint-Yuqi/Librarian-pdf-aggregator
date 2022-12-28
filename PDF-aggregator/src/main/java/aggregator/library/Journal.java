package aggregator.library;

import java.net.URI;

public class Journal {
    private String authors;
    private String journalTitle;
    private  String language;
    private URI download;
    private URI doi;
    private int year;
    private int size;

    public Journal(String authors, String bookName, String language) {
        this.authors = authors;
        this.journalTitle = bookName;
        this.language = language;
    }


    public String getAuthor() {
        return authors;
    }


    public String getJournalTitle() {
        return journalTitle;
    }

    public String getLanguage() {
        return language;
    }


    public URI getDownload() {
        return download;
    }

    public int getYear() {
        return year;
    }

    public int getSize() {
        return size;
    }
}
