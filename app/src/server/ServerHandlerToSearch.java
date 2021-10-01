package server;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import resources.DataBase;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.logging.Logger;


public class ServerHandlerToSearch extends ServerResponseHandler implements HttpHandler {

    private static final Logger logger = Logger.getLogger(HttpHandler.class.getName());
    private static final String instaAccountToSearch = "awesome_shoes";

    public ServerHandlerToSearch() {
    }

    @Override
    public void handle(HttpExchange httpExchange) throws IOException {

        String requestParamValue = null;

        try {
            if ("GET".equals(httpExchange.getRequestMethod())) {
                requestParamValue = handleGetRequest(httpExchange);
                logger.info(requestParamValue);
            } else if ("POST".equals(httpExchange)) {
                requestParamValue = handlePostRequest(httpExchange);
            } else
                httpExchange.sendResponseHeaders(405, -1);
            String response = generateInstaAccountPage(httpExchange);
            handleResponse(httpExchange, requestParamValue, response);
        } catch (IOException ex) {
            throw new IOException();
        }
    }

    private String handlePostRequest(HttpExchange httpExchange) {
        String messageToPost = null;
        logger.info("method post");
        return messageToPost;
    }

    private String handleGetRequest(HttpExchange httpExchange) throws IOException {
        String value = httpExchange.
                getRequestURI().getQuery()
                .split("=")[1];

        logger.info(value);
        return value;
    }

    private String generateInstaAccountPage(HttpExchange httpExchange) {
        String instaAccountName = DataBase.getDataBaseInstance().searchByInstaAccountName(instaAccountToSearch);
        logger.info("Account name to search : " + instaAccountName);

        if (instaAccountName != null) {
            final Headers headers = httpExchange.getResponseHeaders();
            headers.set("Content-Type", String.format("application/json,; charset=%s", StandardCharsets.UTF_8));
            final StringBuilder responseBody = new StringBuilder();
            responseBody.append("{");
            responseBody.append(String.format("{\"name\":\"%s\"}", instaAccountName));
            responseBody.append("}");
            return responseBody.toString();
        }
        return null;
    }

}
