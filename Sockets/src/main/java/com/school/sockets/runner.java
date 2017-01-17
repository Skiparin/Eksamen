/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.sockets;

import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Orvur
 */
public class runner implements Runnable {
    
    Socket socket;
    
    public runner(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            Server.handleClient(socket);
        } catch (IOException ex) {
            Logger.getLogger(runner.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
