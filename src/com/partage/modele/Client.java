package com.partage.modele;


import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
    //send
    private InputStream in;// = new FileInputStream(file);
    private OutputStream out;
    private Socket socket= null ;
    private String host = "127.0.0.1";
    
    //download
    private int bytesRead;
    private int current = 0;
    private FileOutputStream fos = null;
    private BufferedOutputStream bos = null;
    
    public Client() throws IOException{
        socket = new Socket(host, 4444);
        //File file = new File("C:\\Users\\user6\\Desktop\\ra.jpg");
        //File file = new File("C:\\Users\\user6\\Desktop\\tpex1.txt");

    //        in = new FileInputStream(file);
    //        out = socket.getOutputStream();
            //sendFile(file);
            //out.close();
            //in.close();

        //getFiles();
        

        //socket.shutdownOutput();//.shutdow
        //socket.close();
        
        
        }
        public void sendFile(File f) throws IOException{
            in = new FileInputStream(f);
            out = socket.getOutputStream();
            
            //File file = new File("C:\\Users\\user6\\Desktop\\tr.png");
            //File file = new File("M:\\test.xml");
            // Get the size of the file
            long length = f.length();
            byte[] bytes = new byte[16 * 1024];
            in = new FileInputStream(f);
            out = socket.getOutputStream();

            int count;
            while ((count = in.read(bytes)) > 0) {
                out.write(bytes, 0, count);
            }
//            out.close();
//            in.close();
        }    
        public void getFiles() throws IOException{
        
        //getFiles();
        byte [] mybytearray  = new byte [6022386];
        InputStream is = socket.getInputStream();
        
        //fos = new FileOutputStream("C:\\Users\\user6\\Desktop\\mago.png");
        fos = new FileOutputStream("C:\\Users\\user6\\Desktop\\SHITBAYWORK.txt");
        bos = new BufferedOutputStream(fos);
        bytesRead = is.read(mybytearray,0,mybytearray.length);
        current = bytesRead;

        do {
           bytesRead =
              is.read(mybytearray, current, (mybytearray.length-current));
           if(bytesRead >= 0) current += bytesRead;
        } while(bytesRead > -1);

        bos.write(mybytearray, 0 , current);
        bos.flush();
        System.out.println("File " + "mago"
            + " downloaded (" + current + " bytes read)");

        if (fos != null) fos.close();
        if (bos != null) bos.close();

    }
        public static void main(String[] args) throws IOException{
            Client s = new Client();
        }
    }