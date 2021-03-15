package server;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.nio.charset.StandardCharsets;


@Path("controls")

public class Controls {

    @GET
    @Path("welcome")
    public Response welcomeMenu() throws IOException {
        String pageTemplatePath = "/pageTemplatePath.html";
        String page = new String(this.getClass().getResourceAsStream(pageTemplatePath).readAllBytes());
        page = page.replace("${title}", "Welcome Page");
        Document doc = Jsoup.parse(page);
        String menuTemplatePath = "/menu_template.html";
        String menu = new String(this.getClass().getResourceAsStream(menuTemplatePath).readAllBytes());
        menu.replace("${menuTitle}", "Welcome Page");
        doc.appendChild(Jsoup.parse(menu).body());
        return Response
                .ok(doc.html(), MediaType.TEXT_HTML)
                .encoding(StandardCharsets.UTF_8.name())
                .build();
    }
}
