package com.utk.thread.multi.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server {

    private static final Logger LOGGER = Logger.getLogger(Server.class.getName());

    private final ExecutorService executorService;

    public Server(int poolSize) {
        this.executorService = java.util.concurrent.Executors.newFixedThreadPool(poolSize);
    }

    public void handleClient(Socket clientSocket) {
        try (PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {
            out.println("Hello from server!");
            clientSocket.close();
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Error handling client", e);
        }
    }


    public static void main(String[] args) {
        int port = 8010;
        int poolsize = 10;
        Server server = new Server(poolsize);
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            serverSocket.setSoTimeout(10000);
            LOGGER.info("Server started on port " + port);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                server.executorService.execute(() -> server.handleClient(clientSocket));
            }
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Error starting server", e);
        }
    }
}


