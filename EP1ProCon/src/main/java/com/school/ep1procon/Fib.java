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
public class Fib implements Runnable {

    BlockingQueue queue;
    BlockingQueue queue2;

   public Fib(BlockingQueue queue, BlockingQueue queue2){
       this.queue = queue;
       this.queue2 = queue2;
   }
    
    @Override
    public void run() {
        while(queue.size() > 0){
        queue2.add(fibb((int)queue.poll()));
        }
    }

    private long fibb(int n) {
        System.out.println(n);
        if ((n == 0) || (n == 1)) {
            return n;
        } else {
            return fibb(n - 1) + fibb(n - 2);
        }
    }
}
