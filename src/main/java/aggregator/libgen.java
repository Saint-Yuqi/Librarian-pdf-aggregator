package aggregator;

/*  Address which are network identifier,like IP address. */
import java.io.IOException;
/* The IOException occurs while reading a particular file or trying to access the file using the wrong path. */

import org.jetbrains.annotations.NotNull;
import org.jsoup.Jsoup; //Contains the main Jsoup class, which provides convenient static access to the jsoup functionality.
import org.jsoup.helper.Validate; // https://jsoup.org/apidocs/org/jsoup/helper/Validate.html
import org.jsoup.nodes.Document;  //jsoup.org/apidocs/org/jsoup/nodes/Document.html
import org.jsoup.nodes.Element; //https://jsoup.org/apidocs/org/jsoup/nodes/Element.html
import org.jsoup.select.Elements; //https://jsoup.org/apidocs/org/jsoup/select/Elements.html

public class libgen {
    public static void main(String [] args) throws IOException {
        String url = "https://libgen.li";
        print("Fetching %s...",url);

        Document doc = Jsoup.connect(url).get();
        Elements links = doc.select("a"); //The most important attribute of the <a> element is the href attribute, which indicates the link's destination.
        Elements media = doc.select("[src]");//The required src attribute specifies the path (URL) to the image.
        Elements imports = doc.select("link[href]");//defines a hyperlink. It has the following syntax:
        /*
        Element image = document.select("img").first();
        String url = image.absUrl("src");
        url = http://www.example.com/images/chicken.jpg
        equivalently
        String url = image.attr("abs:src");
        */
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

        print("\nLinks: (%d)", links.size());
        for (Element link : links) {
            print(" * a: <%s>  (%s)", link.attr("abs:href"), trim(link.text(), 35));
        }

    }

    private static void print(String msg, Object... args) {
        System.out.println(String.format(msg, args));
    }

    private static Object trim(String s, int width) {
        if (s.length() > width) {
            return s.substring(0, width - 1) + ".";
        }
        else {
            return s;
        }
    }

}
