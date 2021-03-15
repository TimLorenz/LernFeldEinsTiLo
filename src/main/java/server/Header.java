package server;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class Header {
    private Header() {
    }

    public static void appendHead(Document doc, String title) {

        Element head = doc.appendElement("head");
        head.appendChild(new Element("html").attr("lang", "de"));
        head.appendChild(new Element("meta").attr("charset", "UTF-8")); //String der aus JSOUP kommt wird in bits umgewandelt, hat mit jaxRS schnittstelle zu tun
        head.appendChild(new Element("title").text(title));
    }
}
