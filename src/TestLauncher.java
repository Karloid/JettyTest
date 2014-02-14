import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.AbstractHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * Created by 3 on 22.01.14.
 */
public class TestLauncher {
    public static void main(String[] args) throws Exception {
        Server server = new Server(80);
        server.setHandler(new HelloWorld());
        server.start();
        server.join();
    }

    private static class HelloWorld extends AbstractHandler {
        @Override
        public void handle(String s, Request request, HttpServletRequest httpServletRequest, 
                HttpServletResponse httpServletResponse) throws IOException, ServletException {
            httpServletResponse.setContentType("text/html:charset=urf-8");
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
            request.setHandled(true);
            httpServletResponse.getWriter().println("Hello World! " + new Date());
        }
    }
}
