package server;

import javax.xml.ws.spi.http.HttpExchange;

public class Request {
    private String instaAccountName;

    private Request(String query) {
        this.instaAccountName = query;
    }

    public Request getRequest(HttpExchange exchange) {
        String query = exchange.getRequestURI();

        return new Request(query);
    }

    @Override
    public String toString() {
        return "Request{" +
                "instaAccountName='" + instaAccountName + '\'' +
                '}';
    }
}
