package findingemailchallenge;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;



public class FindingEmailChallenge {


    public static void main(String[] args) {
        try {
            //
            Document doc = Jsoup.connect("http://web.mit.edu/").get();
            
            Pattern emailForm = Pattern.compile("[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+");
            Matcher matcher = emailForm.matcher(doc.text());
            Set<String> links = new HashSet<String>();
            Set<String> emails = new HashSet<String>();
            while (matcher.find()) {
                emails.add(matcher.group());
            }
            
            
            
            Elements elements = doc.select("a");
            for (Element e : elements) {
                links.add(e.attr("href"));
            }
            
            System.out.println(emails);
            System.out.println(links);
        } catch (IOException ex) {
            Logger.getLogger(FindingEmailChallenge.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


}
