///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.partage.modele;
//
//import java.io.IOException;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//
///**
// *
// * @author Marie
// */
//public class ThreadServer extends Thread{
//    ServerPartage sp;
//
//    public ThreadServer(ServerPartage sp) {
//        this.sp = sp;
//    }
//    public void run(){
//        while (true){
//            try {
//                while(sp.getIs().available() == 0){
//                    Thread.sleep(100);
//                    sp.readMessage();
//                }
//            } catch (IOException ex) {
//                Logger.getLogger(ThreadServer.class.getName()).log(Level.SEVERE, null, ex);
//            } catch (InterruptedException ex) {
//                Logger.getLogger(ThreadServer.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//    }
//    
//    
//}
