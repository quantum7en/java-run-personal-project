package server;

import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Server {

    private static final Logger logger = Logger.getLogger("Server");

    private static final String defaultPage = "/";
    private static final String instaAccountsPage = "/accounts";
    private static final String accountSearchPage = "/accounts/search?name=awesome_shoes";

    private Server() {
    }

    public static void start() throws IOException {

        try {
            HttpServer httpServerInstance = HttpServer.create(new InetSocketAddress(8080), 0); // 0 - для обратной регистрации, если 0 - не ставим в очередь никаких запросов
            ServerHandler serverHandler = new ServerHandler();
            logger.info("ServerHandler created");

            ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);
            httpServerInstance.setExecutor(threadPoolExecutor);
            logger.info("Executor created");

            HttpContext defaultContext = httpServerInstance.createContext(defaultPage, serverHandler);
            httpServerInstance.createContext(instaAccountsPage, serverHandler);
            httpServerInstance.createContext(accountSearchPage, serverHandler);

            httpServerInstance.start();
        } catch (IOException ex) {
            logger.log(Level.WARNING, "Server creation caught IOException");
            throw new IOException();
        }

        logger.info("Server started");

    }
}
