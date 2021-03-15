package server;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;


public class RestServer {
    public static void main(String[] args) throws Exception {

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");

        Server jettyServer = new Server(8080);
        jettyServer.setHandler(context);

        ServletHolder jerseysServlet = context.addServlet(
                org.glassfish.jersey.servlet.ServletContainer.class, "/*");
        jerseysServlet.setInitOrder(0);

        jerseysServlet.setInitParameter(
                "jersey.config.server.provider.classnames",
                Controls.class.getCanonicalName());

        ServletHolder holdHome = new ServletHolder("static-home", DefaultServlet.class);
        holdHome.setInitParameter("resourceBase", "src/main/resources/static");
        holdHome.setInitParameter("dirAllowed", "true");
        holdHome.setInitParameter("pathInfoOnly", "true");
        context.addServlet(holdHome, "/static/*");

        try {
            jettyServer.start();
            jettyServer.join();
        } finally {
            jettyServer.destroy();
        }

    }
}

//in Webbrowser: http://localhost:8080/controls/welcome