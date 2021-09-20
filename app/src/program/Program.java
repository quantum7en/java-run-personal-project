package program;

import logic.BusinessLogic;
import server.Server;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Program {

    private static final Logger logger = Logger.getLogger(Program.class.getCanonicalName());

    public static void main(String[] args) {

        try {
            Server.start();
            logger.log(Level.INFO, "after server started");
            BusinessLogic.getBusinessLogicInstance().startBusinessLogic();
        } catch (Exception ignored) {
            logger.log(Level.WARNING, "WARNING");
        }
        logger.log(Level.INFO, "Server started succesfully!!! <3 ");
    }
}
