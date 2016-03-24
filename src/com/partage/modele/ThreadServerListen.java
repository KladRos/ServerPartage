/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.partage.modele;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user6
 */
public class ThreadServerListen extends Thread {
    Server ref;
    private int n=0;

	public ThreadServerListen(Server r)
        {
            ref = r;
        }

	public void run()
        {
            while(true)
            {
                try {
                    while(ref.getIn().available() == 0)
                    {
                        try
                        {
                            Thread.sleep(100);
                        }
                        catch(InterruptedException e)
                        {
                            System.out.println(e);
                        }
                        n++;
                    }
                } catch (IOException ex) {
                    Logger.getLogger(ThreadServerListen.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    ref.getFiles();
                } catch (IOException ex) {
                    Logger.getLogger(ThreadServerListen.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } 
}
