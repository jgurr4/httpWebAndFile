import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpsServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

//Important explanation of com.sun.net, java.net, javax.servlet and

// Minimal classes required for http server and method requests:
//Java.net has HttpClient, HttpRequest and HttpURLConnection. These are used to create a client and make http requests
// to a web server using it's url("http://something.com") They are not used for making a server. see https://openjdk.java.net/groups/net/httpclient/intro.html
// ServerSocket class is able to create a simple server which can listen for connections and serve documents and respond
// to requests. see https://javarevisited.blogspot.com/2015/06/how-to-create-http-server-in-java-serversocket-example.html

//com.sun.net has http and https classes. These lets you create servers. They are based around ServerSocket, so they add
// more configuration options, but this means they are not as lightweight as java.net.ServerSocket.

//javax.servlet has many classes to do with java servlets for use with .jsp pages.
// This lets you create a server as well. Even though it's made for .jsp, you can actually use them for making
// servlet filters  which work on any technology not just .jsp.
// See http://tutorials.jenkov.com/java-servlets/servlet-filters.html

// You can manually implement Secure Socket Layer protection via HTTPS in any of these by following these steps:
// https://docs.oracle.com/javaee/5/tutorial/doc/bnbxw.html

// Creating a server in spring-boot or vert.x is going to use framework specific classes for this type of thing.

// This pages teaches how you can create a Secure Socket Layer using either ServerSocket or using HttpsServer classes.
public class HttpServer {

  private static final Logger LOGGER = LoggerFactory.getLogger(HttpServer.class);

  public void startServer() throws IOException {
    LOGGER.debug("made it to startServer");
    int port = 8080;
    final HttpsServer server = HttpsServer.create(new InetSocketAddress(port), 0);
    final HttpContext context = server.createContext("/");
    context.setHandler(HttpServer::handleRequest);
    final HttpContext getUser = server.createContext("/api/user");
    getUser.setHandler(HttpServer::getUser);
    LOGGER.debug("Listening on port:" + port);
    server.start();
  }

  private static void getUser(HttpExchange exchange) {
    final Headers headers = exchange.getResponseHeaders();
    headers.add("Content-Type", "text/html");

  }

  private static void handleRequest(HttpExchange exchange) throws IOException {
    LOGGER.debug("made it to handleRequest");
    String response = "Hi there!";
    exchange.sendResponseHeaders(200, response.getBytes().length); //response code and length
    OutputStream os = exchange.getResponseBody();
    os.write(response.getBytes());
    os.close();
  }

  public static void serveHtml() {

  }
}
