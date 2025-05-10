package com.utk.thread.multi.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server {

    private static final Logger LOGGER = Logger.getLogger(Server.class.getName());

    private Consumer<Socket> getConsumer() {
        return (clientSocket) -> {
            try {
                PrintWriter toClient = new PrintWriter(clientSocket.getOutputStream());
                toClient.println("Hello from the server");
                toClient.close();
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        };
    }

    public static void main(String[] args) {
        Server server = new Server();
        int port = 8010;
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            serverSocket.setSoTimeout(10000);
            LOGGER.info("Server started on port " + port);
            while(true){
                Socket clientSocket = serverSocket.accept();
                LOGGER.info("Client connected: " + clientSocket.getInetAddress());
                Thread thread = new Thread(()->server.getConsumer().accept(clientSocket));
                thread.start();
            }
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Error starting server", e);
        }
    }
}
