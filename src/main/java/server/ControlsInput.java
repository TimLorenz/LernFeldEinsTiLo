package server;


import org.jsoup.nodes.Document;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.nio.charset.StandardCharsets;

@Path("controlsInput")
public class ControlsInput {

    @GET
    @Path("welcome")
    public Response welcomeMenu() {
        Document doc = new Document("scoopSoftware.com");
        Header.appendHead(doc, "LernFeldEinsTiLo/welcome");
        System.out.println(doc.html());
        return Response
                .ok(doc.html(), MediaType.TEXT_HTML)
                .encoding(StandardCharsets.UTF_8.name())
                .build();
    }
}
