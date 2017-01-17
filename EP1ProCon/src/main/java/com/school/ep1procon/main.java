/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.ep1procon;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 *
 * @author Orvur
 */
public class main {

    static int[] S1 = {4,5,8,12,21,22,34,35};
    static ArrayBlockingQueue queue = new ArrayBlockingQueue(8);
    static BlockingQueue queue2 = new ArrayBlockingQueue(1024);
    public static void main(String[] args) {
        queue.add(4);
        queue.add(5);
        queue.add(8);
        queue.add(12);
        //queue.add(21);
        //queue.add(22);
        //queue.add(34);
        //queue.add(35);
        
        Thread one = new Thread(new Fib(queue, queue2));
        Thread two = new Thread(new Fib(queue, queue2));
        //Thread three = new Thread(new Fib(queue, queue2));
        //Thread four = new Thread(new Fib(queue, queue2));
        
        
        one.run();
        two.run();
        //three.run();
        //four.run();
        
        System.out.println(queue2.toString());
        System.out.println(queue.peek());
    }

    private long fib(long n) {
        if ((n == 0) || (n == 1)) {
            return n;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }
    
    
}
