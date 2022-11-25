package aggregator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

public class Main {
    public static void main(String[] args) throws IOException {
        String url = "https://libgen.li";
        System.out.println("Fetching ..." + url);

        Document doc = (Document) Jsoup.connect(url)
                .data("req","Linear Algebra and its Applications")
                .data("req","Biswa Nath Datta")
                .get();

        //System.out.println(doc.body());

        Elements links = doc.getElementsByTag("a"); //The most important attribute of the <a> element is the href attribute, which indicates the link's destination.
        System.out.println("\nLinks: " + links.size());


        for (Element link : links) {

            if (link.text().equalsIgnoreCase("Linear Algebra and its Applications"))
            {
                System.out.printf(" * a:%s (%s)\n " , link.attr("abs:href")  , link.text());
            }

        }

    }
}