package com.utk.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server {

    private static final Logger LOGGER = Logger.getLogger(Server.class.getName());

    public void run() throws IOException {
        while (true) {
            try {
                int port = 8010;
                ServerSocket serverSocket = new ServerSocket(port);
                serverSocket.setSoTimeout(10000);
                LOGGER.log(Level.INFO, () -> "Server is waiting for a connection on port " + port);
                Socket acceptedConnection = serverSocket.accept();
                LOGGER.log(Level.INFO, () -> "Connection accepted from " + acceptedConnection.getRemoteSocketAddress());
                PrintWriter toClient = new PrintWriter(acceptedConnection.getOutputStream());
                BufferedReader fromClient = new BufferedReader(new InputStreamReader(acceptedConnection.getInputStream()));
                toClient.println("Hello from the server");
                toClient.close();
                fromClient.close();
                acceptedConnection.close();
            } catch (IOException e) {
                e.printStackTrace();
                LOGGER.log(Level.SEVERE, "Error accepting connection", e);
            }
        }
    }

    public static void main(String[] args) {
        Server server = new Server();
        try {
            server.run();
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Error starting server", e);
        }
    }
}
