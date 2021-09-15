package program;

import logic.BusinessLogic;
import server.Server;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Program {

    private static final Logger logger = Logger.getLogger(Program.class.getCanonicalName());

    public static void main(String[] args) {

        try {
            Server.getHttpServerInstance().start();
            BusinessLogic.getBusinessLogicInstance().startBusinessLogic();

        } catch (IOException ioE) { //todo remove, to change completely
            logger.log(Level.WARNING, "BINDING WARNING: Binding failed");
            // todo server stop
        } catch (Exception ignored) {
            logger.log(Level.WARNING, "BUSINESS LOGIC WARNING");
        }
        logger.log(Level.INFO, "Server started succesfully!!! <3 ");
    }
}
