package server;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import resources.DataBase;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.logging.Logger;


public class ServerHandler implements HttpHandler {

    // todo null pointer exception here

    // private Session serverSession; //если нужно будет фиксировать сессию для сервера
    private static final Logger logger = Logger.getLogger("ServerHandler");

    private static final String defaultPage = "/";
    private static final String instaAccountsPage = "/accounts";
    private static final String accountSearchPage = "/accounts/search?name=awesome_shoes";
    private static final String instaAccountToSearch = "awesome_shoes";

    public ServerHandler() {
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
            handleResponse(httpExchange, requestParamValue);
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
        String value = null;
        String request = httpExchange.getRequestURI().toString();
        if (request.equals(accountSearchPage)) {
            value = httpExchange.
                    getRequestURI()
                    .toString()
                    .split("\\?")[1]
                    .split("=")[1];

            logger.info(value);
        } else if (request.equals(instaAccountsPage)) //todo переделать, чтобы искал другие магазины
            value = "Requested Instagram Account not found. For now you can look for 'awesome_shoes'";
        else
            httpExchange.sendResponseHeaders(404, -1);
        return value;
    }

    private void handleResponse(HttpExchange httpExchange, String requestParamValue) throws IOException {
        String response = null;

        if (requestParamValue.equals(instaAccountToSearch))
            response = generateInstaAccountPage(instaAccountToSearch, httpExchange);


        OutputStream outputStream = httpExchange.getResponseBody();
        StringBuilder htmlBuilder = new StringBuilder();

        htmlBuilder
                .append("<h1>")
                .append("Your request : ").append(requestParamValue)
                .append(" | Response : ")
                .append(response)
                .append("</h1>");

        // encode HTML content
        // String htmlResponse = StringEscapeUtils.escapeHtml4(htmlBuilder.toString()); // не тянется либа, но можно скачать всю и положить в проект

        String htmlResponse = htmlBuilder.toString();

        httpExchange.sendResponseHeaders(200, htmlResponse.length());

        outputStream.write(htmlResponse.getBytes());
        outputStream.flush();
        outputStream.close();
    }

    private String generateInstaAccountPage(String accountSearchPage, HttpExchange httpExchange) {
        String instaAccountName = DataBase.getDataBaseInstance().searchByInstaAccountName(accountSearchPage);
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
