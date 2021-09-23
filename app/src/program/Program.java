package program;

import logic.BusinessLogic;
import resources.DataBase;
import server.Server;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Program {

    private static final Logger logger = Logger.getLogger("Program");

    public static void main(String[] args) {

        try {
            DataBase.getDataBaseInstance();
            Server.start();
            BusinessLogic.getBusinessLogicInstance().startBusinessLogic();
        } catch (IOException ioException) {
            logger.warning("WARNING: ioException in Server");
        }
        logger.log(Level.INFO, "Server, DB & logic started succesfully!!! <3 ");
    }
}
