/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.sockets;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author Orvur
 */
public class Server {

    private static boolean keepRunning = true;
    private static ServerSocket serverSocket;
    private String ip;
    private int port;
    static private int counte;
    static private ArrayList<Turnstile> turnstiles = new ArrayList<>();
    static private AtomicInteger counter = new AtomicInteger();
    static private ExecutorService threadpool = Executors.newFixedThreadPool(1000);
    

    public static void stopServer() {
        keepRunning = false;
    }

    public static void handleClient(Socket socket) throws IOException {
        Scanner input = new Scanner(socket.getInputStream());
        PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
        
        writer.println("You are connected to the Server.");

        String message = input.nextLine(); //IMPORTANT blocking call
        String[] messages = message.split(",");
        if(messages[0].equals("turnstile")){
            turnstiles.add(new Turnstile(Integer.parseInt(messages[1]), socket));
        }else if(messages[0].equals("monitor")){
            
        }else socket.close();
        while (keepRunning) {
            message = input.nextLine(); //IMPORTANT blocking call
            if(message.equals("number") && messages[0].equals("monitor")){
                writer.println("Hey Monitor. The number of spectators is:" + counter.get());
            }
            for (Turnstile stile : turnstiles) {
                if(stile.getId() == Integer.parseInt(messages[1])){
                    stile.setNumber(Integer.parseInt(message));
                }
            }
            counter.addAndGet(Integer.parseInt(message));
            for (Turnstile stile : turnstiles) {
                writer.println("Turnstile nr." + stile.getId() + "has counted: " + stile.getNumber() + " spectators.");
            }
            writer.println("Hey Turnstile" + messages[1] + "The number of spectators is:" + counter.get());
        }
        writer.println("hey");//Echo the stop message back to the client for a nice closedown
        socket.close();
        System.out.println("Closed a Connection");
    }

    private void runServer(String ip, int port) {
        this.port = port;
        this.ip = ip;

        //System.out.println("Server started. Listening on: " + port + ", bound to: " + ip);
        try {
            serverSocket = new ServerSocket();
            serverSocket.bind(new InetSocketAddress(ip, port));
            do {
                Socket socket = serverSocket.accept(); //Important Blocking call
                System.out.println("Connected to a client");
                threadpool.submit(new runner(socket));
            } while (keepRunning);
        } catch (IOException ex) {
        }
    }

    public static void main(String[] args) {

        try {
            new Server().runServer("localhost", 8080);
        } catch (Exception e) {

        }
    }
}
