/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.partage.modele;

import com.partagefichiers.vue.MainFrame;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marie
 */
public class ClientPartage {
    Socket socket = null;
    String host = "127.0.0.1";
    private     PrintWriter os;
    private     BufferedInputStream is;
    private MainFrame f;
    
    
    private InputStream in;
    private OutputStream out;
    
    
    public ClientPartage() throws IOException{
        try {
            socket = new Socket(host, 4444);
        } catch (IOException ex) {
            Logger.getLogger(ClientPartage.class.getName()).log(Level.SEVERE, null, ex);
        }
        //POUR ENVOYER DES CODES STRINGS
        is = new BufferedInputStream(socket.getInputStream());
        os = new PrintWriter(socket.getOutputStream());
        
        os.print("connecté");
        os.flush();
        
        //f = new MainFrame(socket,in,out,os);
        File file = new File("C:\\Users\\user6\\Desktop\\tr.png");
        
        long length = file.length();
        byte[] bytes = new byte[16 * 1024];
        InputStream in = new FileInputStream(file);
        OutputStream out = socket.getOutputStream();

        int count;
        while ((count = in.read(bytes)) > 0) {
            out.write(bytes, 0, count);
        }

            //this.sendFile();
        
//        File file = new File("M:\\test.xml");
//        // Get the size of the file
//        long length = file.length();
//        byte[] bytes = new byte[16 * 1024];
//        InputStream in = new FileInputStream(file);
//        OutputStream out = socket.getOutputStream();
//
//        int count;
//        while ((count = in.read(bytes)) > 0) {
//            out.write(bytes, 0, count);
//        }
//
        out.close();
        in.close();
        socket.close();
    }
    public void sendFile() throws FileNotFoundException, IOException{
        //File file = new File("C:\\Users\\user6\\Desktop\\tpex1.txt");
        File file = new File("C:\\Users\\user6\\Desktop\\tr.png");
        
        long length = file.length();
        byte[] bytes = new byte[16 * 1024];
        InputStream in = new FileInputStream(file);
        OutputStream out = socket.getOutputStream();

        int count;
        while ((count = in.read(bytes)) > 0) {
            out.write(bytes, 0, count);
        }

    }
    
    public static void main(String[] args) throws IOException {
      ClientPartage c = new ClientPartage();

    }
}
