package com.slavauz.jettyjerseysimple;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by slava on 25.08.16.
 */
public class Application {

    public static void main(String[] args) throws Exception {

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");

        Server server = new Server(8080);
        server.setHandler(context);

        context.addServlet(SimpleServlet.class, "/*");

        ServletHolder restServletHolder = context.addServlet(
                org.glassfish.jersey.servlet.ServletContainer.class, "/v1/*");

        restServletHolder.setInitOrder(0);
        restServletHolder.setInitParameter(
                "jersey.config.server.provider.classnames",
                TasksResource.class.getCanonicalName() + "," +
                        UsersResource.class.getCanonicalName());

        try {
            server.start();
            server.join();
        } finally {
            server.destroy();
        }
    }

    @SuppressWarnings("serial")
    public static class SimpleServlet extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest request,
                             HttpServletResponse response) throws ServletException, IOException {
            response.setContentType("text/html");
            response.setStatus(HttpServletResponse.SC_OK);
            response.getWriter().println("<h1>Hello world!!!</h1>");
        }
    }
}
