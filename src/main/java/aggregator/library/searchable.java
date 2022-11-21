package aggregator.library;

import java.net.URI;

public interface searchable {

    String getBookName();

    String getAuthor();
    String getLanguage();
    URI getDownload();
    String getMD5();
    int getYear();

    int getSize();


}
