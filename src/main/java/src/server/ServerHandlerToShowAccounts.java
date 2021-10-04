package src.server;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.util.logging.Logger;


public class ServerHandlerToShowAccounts extends ServerHandler implements HttpHandler {

    private static final Logger logger = Logger.getLogger(HttpHandler.class.getName());

    public ServerHandlerToShowAccounts() {
    }

    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        String requestParamValue = null;

        try {
            if ("GET".equals(httpExchange.getRequestMethod())) {
                requestParamValue = handleGetRequest();
                logger.info(requestParamValue);
            } else if ("POST".equals(httpExchange)) {
                requestParamValue = handlePostRequest(httpExchange);
            } else
                httpExchange.sendResponseHeaders(405, -1);
            handleResponse(httpExchange, requestParamValue, null);
        } catch (IOException ex) {
            throw new IOException();
        }
    }

    private String handleGetRequest() throws IOException {
        return "Requested Instagram Accounts not found. For now you can look for 'awesome_shoes'";
    }
}
