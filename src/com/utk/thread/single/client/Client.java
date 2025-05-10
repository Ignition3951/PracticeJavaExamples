package com.utk.thread.single.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Client {

    private static final Logger LOGGER = Logger.getLogger(Client.class.getName());
    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 8010;

    public void run() throws IOException {
        InetAddress inetAddress = InetAddress.getByName(SERVER_ADDRESS);
        Socket socket = new Socket(inetAddress, SERVER_PORT);
        PrintWriter toSocket = new PrintWriter(socket.getOutputStream());
        BufferedReader fromSocket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        toSocket.println("Hello from the client");
        String line = fromSocket.readLine();
        LOGGER.log(Level.INFO,()->"Response from server is : " + line);
        toSocket.close();
        fromSocket.close();
        socket.close();
    }

    public static void main(String[] args) {
        Client client = new Client();
        try {
            client.run();
        } catch (IOException e) {
            LOGGER.severe("Error connecting to server: " + e.getMessage());
        }
    }
}
