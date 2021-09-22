package server;

import com.ibm.jvm.dtfjview.Session;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;


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

    private Session serverSession; //если нужно будет фиксировать сессию для сервера
    private static final Logger logger = Logger.getLogger(ServerHandler.class.getCanonicalName());

    public ServerHandler(){}

    @Override
    public void handle(HttpExchange httpExchange) throws IOException {

        String requestParamValue = null;

        try {
            if ("GET".equals(httpExchange.getRequestMethod())) {
                requestParamValue = handleGetRequest(httpExchange);
                logger.log(Level.INFO, requestParamValue);
            } else if ("POST".equals(httpExchange)) {
                requestParamValue = handlePostRequest(httpExchange);
            } else
                httpExchange.sendResponseHeaders(405, -1);
            handleResponse(httpExchange, requestParamValue);
        } catch (IOException ex){
            throw new IOException();
        }
    }

    private String handlePostRequest(HttpExchange httpExchange) {
        String messageToPost = null;
        logger.log(Level.INFO, "method post");
        return messageToPost;
    }

    private String handleGetRequest(HttpExchange httpExchange) throws IOException {
        String value = null;
        String request = httpExchange.getRequestURI().toString();
        if(request.equals("/accounts/search?name=awesome_shoes")) {
            value = httpExchange.
                    getRequestURI()
                    .toString()
                    .split("\\?")[1]
                    .split("=")[1];

            logger.log(Level.INFO, value);
        }
        else if(request.equals("/accounts")) //todo переделать, чтобы искал другие магазины
            value = "Requested Instagram Account not found. For now you can look for 'awesome_shoes'";
        else
            httpExchange.sendResponseHeaders(404, -1);
        return value;
    }

    private void handleResponse(HttpExchange httpExchange, String requestParamValue)  throws  IOException {
        OutputStream outputStream = httpExchange.getResponseBody();
        StringBuilder htmlBuilder = new StringBuilder();

        htmlBuilder.
                append("<h1>").
                append("Your request : ")
                .append(requestParamValue)
                .append("</h1>");

        // encode HTML content
       // String htmlResponse = StringEscapeUtils.escapeHtml4(htmlBuilder.toString());

        String htmlResponse = htmlBuilder.toString();
        // this line is a must
        httpExchange.sendResponseHeaders(200, htmlResponse.length());

        outputStream.write(htmlResponse.getBytes());
        outputStream.flush();
        outputStream.close();
    }
}
