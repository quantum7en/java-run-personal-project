package server;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Logger;

public abstract class ServerResponseHandler {
    private static final Logger logger = Logger.getLogger(HttpHandler.class.getName());

    protected void handleResponse(HttpExchange httpExchange, String requestParamValue, String response) throws IOException {

        OutputStream outputStream = httpExchange.getResponseBody();
        StringBuilder htmlBuilder = new StringBuilder();

        htmlBuilder
                .append("<h1>")
                .append("Your request : ").append(requestParamValue)
                .append(" | Response : ")
                .append(response)
                .append("</h1>");

        String htmlResponse = htmlBuilder.toString();

        httpExchange.sendResponseHeaders(200, htmlResponse.length());

        outputStream.write(htmlResponse.getBytes());
        outputStream.flush();
        outputStream.close();
    }

}