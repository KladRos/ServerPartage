/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.partage.modele;

import java.io.BufferedInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.File;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marie
 */
public class ServerPartage {
    //FICHIER
    private    Socket socket = null;
    private    InputStream in = null;
    private    OutputStream out = null;
    private File direct;
    
    private     PrintWriter os;
    private     BufferedInputStream is;
    
    public ServerPartage() throws IOException{
        //ClassLoader loader = ServerPartage.class.getClassLoader();
        //System.out.println(loader.getResource("com.partage.modele\\ServerPartage.class"));
        
        URL location = getClass().getProtectionDomain().getCodeSource().getLocation();
        direct = new File(location.getPath());
        direct = direct.getParentFile();
        //System.out.println("yoo "+temp.getParent()+"\\files\\");
        direct = new File(direct.getParent()+"\\files\\\\");
        System.out.println(direct.getAbsoluteFile());
        
        
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(4444);
        } catch (IOException ex) {
            Logger.getLogger(ServerPartage.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            socket = serverSocket.accept();
        } catch (IOException ex) {
            Logger.getLogger(ServerPartage.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        is = new BufferedInputStream(socket.getInputStream());
        os = new PrintWriter(socket.getOutputStream());
        //(new ThreadServer(this)).start();
        this.sendMessage("Connexion");
        
//        String cd
//        if(readMessage().equals("connecté"))
//            System.out.println("GOOOD");  
        
        try {
            in = socket.getInputStream();
        } catch (IOException ex) {
            System.out.println("Can't get socket input stream. ");
        }
        
        
        try {
            out = new FileOutputStream("C:\\Users\\user6\\Desktop\\tp\\partageServer-master\\files\\RFt1258.png");
            //out = new FileOutputStream("M:\\test2.xml");
        } catch (FileNotFoundException ex) {
            System.out.println("File not found. ");
        }

        byte[] bytes = new byte[16*1024];

        int count;
        while ((count = in.read(bytes)) > 0) {
            out.write(bytes, 0, count);
        }

        

        out.close();
        in.close();
        socket.close();
        serverSocket.close();
    }
    
    public void sendMessage(String code){
        os.print(code);
        os.flush();
    }
//    public void readMessage()
//    {
//        byte []buf = new byte[200];
//        String message="";
//
//        try
//        {
//            is.read(buf);
//            message = (new String(buf)).trim();
//            if (message.equals("tele"))
//                getFiles();
//            if(message.equals("connecté"))
//                System.out.println("GOOOD");  
//        }
//        catch(IOException e)
//         {
//                System.out.println(e);
//         }
//    }
//    public void getFiles(){
//        System.out.println("obtention fichier");
//        try {
//            //out = new FileOutputStream("C:\\Users\\Marie\\Desktop\\partageServer-master\\files\\test.txt");
//            out = new FileOutputStream(""+direct+"\\"+"testDAMN.txt");
//        } catch (FileNotFoundException ex) {
//            System.out.println("File not found. ");
//        }
//        byte[] bytes = new byte[16*1024];
//        
//        int count;
//        try {
//            while ((count = in.read(bytes)) > 0) {
//                out.write(bytes, 0, count);
//            }
//        } catch (IOException ex) {
//            Logger.getLogger(ServerPartage.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//
//    public Socket getSocket() {
//        return socket;
//    }
//
//    public void setSocket(Socket socket) {
//        this.socket = socket;
//    }
//
//    public InputStream getIn() {
//        return in;
//    }
//
//    public void setIn(InputStream in) {
//        this.in = in;
//    }
//
//    public OutputStream getOut() {
//        return out;
//    }
//
//    public void setOut(OutputStream out) {
//        this.out = out;
//    }
//
//    public File getDirect() {
//        return direct;
//    }
//
//    public void setDirect(File direct) {
//        this.direct = direct;
//    }
//
//    public PrintWriter getOs() {
//        return os;
//    }
//
//    public void setOs(PrintWriter os) {
//        this.os = os;
//    }
//
//    public BufferedInputStream getIs() {
//        return is;
//    }
//
//    public void setIs(BufferedInputStream is) {
//        this.is = is;
//    }
    public static void main(String[] args) throws IOException {
        ServerPartage s = new ServerPartage();
    }
}
