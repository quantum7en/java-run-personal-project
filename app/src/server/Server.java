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


public class Server {

    private static final Logger logger = Logger.getLogger(Server.class.getCanonicalName());
    private static HttpServer httpServerInstance;
    private Server(){}

    public static void start() {
        // httpServerInstance.bind(new InetSocketAddress(8080), 0); //todo remove this

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

    }
}
