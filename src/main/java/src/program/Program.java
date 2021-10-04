package src.program;

import src.resources.DataBase;
import src.server.Server;

import java.io.IOException;
import java.util.logging.Logger;

public class Program {

    private static final Logger logger = Logger.getLogger(Program.class.getName());

    public static void main(String[] args) throws IOException {
        DataBase.start();
        Server.start();
        logger.info("Server, DB & logic started successfully!!! <3 ");
    }
}
