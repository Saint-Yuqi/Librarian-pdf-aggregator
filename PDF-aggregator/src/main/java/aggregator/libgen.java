package aggregator;

/*  Address which are network identifier,like IP address. */
import java.io.BufferedInputStream;

import java.io.FileOutputStream;
import java.net.URL;
/* The IOException occurs while reading a particular file or trying to access the file using the wrong path. */
import java.io.IOException;
import aggregator.library.Book;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.jsoup.Jsoup; //Contains the main Jsoup class, which provides convenient static access to the jsoup functionality.
import org.jsoup.nodes.Document;  //jsoup.org/apidocs/org/jsoup/nodes/Document.html
import org.jsoup.nodes.Element; //https://jsoup.org/apidocs/org/jsoup/nodes/Element.html
import org.jsoup.select.Elements; //https://jsoup.org/apidocs/org/jsoup/select/Elements.html

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import com.google.gson.JsonParser;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;
public class libgen {

    public ArrayList<String> getDownlodlink(Book book) throws IOException {
        String url = "https://libgen.li";
        ArrayList<String> link1 = new ArrayList<String>();
        Document doc = Jsoup.connect(url)
                .data("req", book.getBookName())
                .get();
        Elements links = doc.getElementsByTag("a");
        for (Element link : links) {
                if (link.attr("abs:href").contains("md5") && link.text().equalsIgnoreCase("libgen")) {
                    link1.add(link.attr("abs:href"));
                }
        }
        return link1;
    }
    public void getDownload(Book book) throws IOException {
        getDownlodlink(book);
        System.out.println("The number of books we could get: " + getDownlodlink(book).size());
        for (int i = 0; i < 2; i++) {
            String url = getDownlodlink(book).get(i);
            System.out.println("Fetching ..." + url);
            Document doc = Jsoup.connect(url).get();

            Elements links = doc.getElementsByTag("a"); //The most important attribute of the <a> element is the href attribute, which indicates the link's destination.
            //System.out.println("\nLinks: " + links.size());
            for (Element link : links) {
                //System.out.printf(" * a:%s (%s)\n ", link.attr("abs:href"), link.text());
                if (link.text().equalsIgnoreCase("get")) {
                    //System.out.printf(" * a:%s (%s)\n ", link.attr("abs:href"), link.text());
                    String path = link.attr("abs:href");
                    try (BufferedInputStream in = new BufferedInputStream(new URL(path).openStream());
                         FileOutputStream fileOutputStream = new FileOutputStream(book.getBookName()+ i + ".pdf")) {
                        byte[] dataBuffer = new byte[1024];
                        int bytesRead;
                        while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
                            fileOutputStream.write(dataBuffer, 0, bytesRead);
                        }
                    } catch (IOException e) {
                        //catch exception
                    }
                }
            }
        }
    }
     public Book parseBook(Gson bookObject) throws IOException {

         Book book = new Book();
         String url = "https://libgen.li";
         ArrayList<String> link1 = new ArrayList<String>();
         Document doc = Jsoup.connect(url)
                 .data("req", book.getBookName())
                 .get();
         Elements links = doc.getElementsByTag("a");
         return book;
     }
    /*
    <tr><td><textarea rows='9' name='bibtext' id='bibtext' readonly cols='60'>@book{book:{93338971},
       title =     {Systems of Equations Substitution Simultaneous Cramer s Rule Algebra Practice Workbook with Answers Improve Your Math Fluency Series 20 Chris McMullen},
       author =    {Chris McMullen},
       publisher = {Algebra Chris McMullen},
       year =      {2019},
       series =    {Algebra Practice Workbook with Answers Improve Your Math Fluency Series},
       url =       {libgen.li/file.php?md5=8094d914791e8774c27f2815cb9fec4c}}</textarea></td></tr>
     */
     //I hope get the json object.
    private static String getJson(String body){
        String start="{";
        String end="}";
        int s=body.indexOf(start);
        int e=body.indexOf(end)+1;
        return body.substring(s,e);
    }


    public static void main(String[] args) throws IOException {
        //String url = "https://libgen.li";

        Book book = new Book();
        book.setBookName("algebra");
        libgen lib = new libgen();
        lib.getDownload(book);

    }
}

        /*
        Elements media = doc.select("[src]");//The required src attribute specifies the path (URL) to the image.
        Elements imports = doc.select("link[href]");//defines a hyperlink. It has the following syntax:

        print("\nMedia: (%d)", media.size());
        for (Element src : media) {
            if (src.normalName().equals("img"))
                print(" * %s: <%s> %sx%s (%s)",
                        src.tagName(), src.attr("abs:src"), src.attr("width"), src.attr("height"),
                        trim(src.attr("alt"), 20));
            else
                print(" * %s: <%s>", src.tagName(), src.attr("abs:src"));
        }
        print("\nImports: (%d)", imports.size());
        for (Element link : imports) {
            print(" * %s <%s> (%s)", link.tagName(),link.attr("abs:href"), link.attr("rel"));
        }

         */
