package program;

import com.sun.net.httpserver.HttpServer;
import server.Server;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Program {
    static HttpServer appServer; //TODO remove
    static Level level;

    public static final Logger logger = Logger.getLogger("appLogger");

    public static void main(String[] args) {

        //TODO create package & class business logic
        level = Level.INFO;

        try {
            appServer = Server.getHttpServerInstance();
            appServer.start();
        }
        catch (IOException E){
            logger.log(level, "Binding failed");
        }

        level = Level.INFO;
        logger.log(level, "Server started succesfully");
    }
}
