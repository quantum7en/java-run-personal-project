package server;

import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import program.Program;

import java.io.IOException;
import java.net.BindException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executor;

//    private static Server httpServerInstance;
//    private Server(){}
//
//    public static Server getHttpServerInstance() throws IOException{
//        if(httpServerInstance == null){
//            httpServerInstance = new Server() {
//            };
//        }
//        return httpServerInstance;
//    }



public class Server extends HttpServer {

    private static Server httpServerInstance;
    private Server(){}

    public static Server getHttpServerInstance() throws IOException{
        if(httpServerInstance == null){
            httpServerInstance = new Server() {
            };
        }
        return httpServerInstance;
    }


    @Override
    public void bind(InetSocketAddress inetSocketAddress, int i) throws IOException {

    }

    @Override
    public void start() {

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
