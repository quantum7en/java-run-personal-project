package src.server;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.logging.Logger;


public class Server {

    private static final Logger logger = Logger.getLogger(Server.class.getName());

    private Server() {
    }

    public static void start() throws IOException {
        HttpServer httpServerInstance = HttpServer.create(new InetSocketAddress(8080), 0); // 0 - для обратной регистрации, если 0 - не ставим в очередь никаких запросов
        ServerHandlerToSearch serverHandlerToSearch = new ServerHandlerToSearch();
        ServerHandlerToShowAccounts serverHandlerToShowAccounts = new ServerHandlerToShowAccounts();
        logger.info("ServerHandler created");

        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);
        httpServerInstance.setExecutor(threadPoolExecutor);
        logger.info("Executor created");

        httpServerInstance.createContext("/accounts", serverHandlerToShowAccounts);
        httpServerInstance.createContext("/accounts/search", serverHandlerToSearch);

        httpServerInstance.start();
        logger.info("Server started");
    }
}
