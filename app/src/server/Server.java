package server;

import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Server extends HttpServer {

    private static final Logger logger = Logger.getLogger(Server.class.getCanonicalName());
    private static Server httpServerInstance;
    private Server(){}

    public static Server getHttpServerInstance() {
        if(httpServerInstance == null){
            httpServerInstance = new Server() {
            };
            logger.info("One and only server created.");
        }
        return httpServerInstance;
    }


    @Override
    public void bind(InetSocketAddress inetSocketAddress, int i) throws IOException {
        double x = Math.random(); //for debug

        logger.log(Level.INFO, "binding");
        //todo figure out how to implement bind, поправить: при эксепшене здесь, все равно запускается Бизнес логика и сообщение
        if(x > 0.9) //for debug
            throw new IOException();
    }

    @Override
    public void start() {
        try {
            httpServerInstance = Server.getHttpServerInstance();
            httpServerInstance.bind(new InetSocketAddress(8080), 0); //todo remove this

            try (ServerSocket serverSocket = new ServerSocket(8080)) {
                logger.log(Level.INFO, "Server started!");

                while (true) {
                    Socket socket = serverSocket.accept();
                    logger.log(Level.INFO, "Client connected!");

                    // для подключившегося клиента открываем потоки
                    // чтения и записи
                    try (BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
                         PrintWriter output = new PrintWriter(socket.getOutputStream())) {

                        // ждем первой строки запроса
                        while (!input.ready()) ;

                        // считываем и печатаем все что было отправлено клиентом
                        logger.log(Level.INFO, "\n");
                        while (input.ready()) {
                            logger.log(Level.INFO, input.readLine());
                        }

                        // отправляем ответ
                        output.println("HTTP/1.1 200 OK");
                        output.println("Content-Type: text/html; charset=utf-8");
                        output.println();
                        output.println("<p>Masya!</p>");
                        output.flush();

                        // по окончанию выполнения блока try-with-resources потоки,
                        // а вместе с ними и соединение будут закрыты
                        logger.log(Level.INFO,"Client disconnected!");
                    }
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }

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
