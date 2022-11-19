package aggregator;

/*  Address which are network identifier,like IP address. */
import java.io.BufferedInputStream;
import java.io.File;

import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
/* The IOException occurs while reading a particular file or trying to access the file using the wrong path. */
import java.io.IOException;
import aggregator.library.Book;
import org.jetbrains.annotations.NotNull;
import org.jsoup.Connection;
import org.jsoup.Jsoup; //Contains the main Jsoup class, which provides convenient static access to the jsoup functionality.
import org.jsoup.helper.Validate; // https://jsoup.org/apidocs/org/jsoup/helper/Validate.html
import org.jsoup.nodes.Document;  //jsoup.org/apidocs/org/jsoup/nodes/Document.html
import org.jsoup.nodes.Element; //https://jsoup.org/apidocs/org/jsoup/nodes/Element.html
import org.jsoup.select.Elements; //https://jsoup.org/apidocs/org/jsoup/select/Elements.html

public class libgen {
    public static void main(String[] args) throws IOException {
        //String url = "https://libgen.li";
        //TODO: read about http GET request vs POST request
        //TODO: read about Jetbrains decompiler
        //TODO: find out how the Jsoup works (travel through return calls)
        String url = "https://libgen.rocks/ads.php?md5=8094d914791e8774c27f2815cb9fec4c";
        System.out.println("Fetching ..." + url);
        //data("req", "algebra").timeout(30000)
        Document doc = Jsoup.connect(url).get();


        Elements links = doc.getElementsByTag("a"); //The most important attribute of the <a> element is the href attribute, which indicates the link's destination.
        System.out.println("\nLinks: " + links.size());


        for (Element link : links) {
            if (link.text().equalsIgnoreCase("get")) {
                System.out.printf(" * a:%s (%s)\n " , link.attr("abs:href")  , link.text());
            }

         }








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