import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class StartApp {

  private static final Logger LOGGER = LoggerFactory.getLogger(StartApp.class);

  public static void main(String[] args) throws IOException {
    //Uncomment for an explanation of Bitwise operators.
    //new BitwiseOperators().explanation();
    LOGGER.debug("made it to main");
    new HttpServer().startServer();
  }
}
