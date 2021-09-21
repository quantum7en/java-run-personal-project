package server;

import com.ibm.jvm.dtfjview.Session;
import com.ibm.jvm.dtfjview.SessionProperties;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;

public class ServerHandler implements HttpHandler {
    /**
     * Handle the given request and generate an appropriate response.
     * See {@link HttpExchange} for a description of the steps
     * involved in handling an exchange.
     *
     * @param exchange the exchange containing the request from the
     *                 client and used to send the response
     * @throws NullPointerException if exchange is <code>null</code>
     */

    private Session serverSession;

    public ServerHandler(){}


    @Override
    public void handle(HttpExchange exchange) throws IOException {

        throw new IOException();
    }
}
