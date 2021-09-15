package server;

import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Server extends HttpServer {

    private static final Logger logger = Logger.getLogger(Server.class.getCanonicalName());
    private static Server httpServerInstance;
    private Server(){}

    public static Server getHttpServerInstance() throws IOException{
        if(httpServerInstance == null){
            httpServerInstance = new Server() {
            };
            logger.info("one and only server created");
        }
        return httpServerInstance;
    }


    @Override
    public void bind(InetSocketAddress inetSocketAddress, int i) throws IOException {
        double x = Math.random();

        logger.log(Level.INFO, "binding");
        //todo figure out how to implement bind, поправить: при эксепшене здесь все равно запускается Бизнес логика и сообщение
        if(x > 0.9)
            throw new IOException();
    }

    @Override
    public void start() {
        try {
            httpServerInstance = Server.getHttpServerInstance();
            httpServerInstance.bind(new InetSocketAddress(8500), 0);
        } catch (IOException e) {
            logger.log(Level.WARNING, "BINDING WARNING: Binding failed");
            // todo server stop
        }
    }

    @Override
    public void setExecutor(Executor executor) {

    }

    @Override
    public Executor getExecutor() {
        return null;
    }

    @Override
    public void stop(int i) {

    }

    @Override
    public HttpContext createContext(String s, HttpHandler httpHandler) {
        return null;
    }

    @Override
    public HttpContext createContext(String s) {
        return null;
    }

    @Override
    public void removeContext(String s) throws IllegalArgumentException {

    }

    @Override
    public void removeContext(HttpContext httpContext) {

    }

    @Override
    public InetSocketAddress getAddress() {
        return null;
    }
}
