/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.sockets;

import java.net.Socket;

/**
 *
 * @author Orvur
 */
public class Turnstile {
    private int id;
    private Socket socket;
    private int number = 0;

    public Turnstile(int id, Socket socket) {
        this.id = id;
        this.socket = socket;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }
    
    
    
}
