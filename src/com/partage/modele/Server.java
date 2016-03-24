package com.partage.modele;


import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;

public class Server {
    private ServerSocket serverSocket = null;
    private Socket socket = null;
    
    
    //RECEVOIR
    private InputStream in = null;
    private OutputStream out = null;
    
    private URL location = getClass().getProtectionDomain().getCodeSource().getLocation();
    private File direct = new File(location.getPath());
    
    //Envoyer
    private FileInputStream fis = null;
    private BufferedInputStream bis = null;
    private OutputStream os = null;
    private ServerSocket servsock = null;
    //private Socket sock = null;
    
    
    
    
    
    public Server() throws IOException{
        try {
            serverSocket = new ServerSocket(4444);
        } catch (IOException ex) {
            System.out.println("Can't setup server on this port number. ");
        }

         socket = null;
         in = null;
         out = null;
         
        direct = new File(direct.getParent());
        direct = new File(direct.getParent());
        direct = new File(direct+"\\files\\");
        System.out.println("yoooo "+direct);


        try {
            socket = serverSocket.accept();
            System.out.println("k");
            
            
        } catch (IOException ex) {
            System.out.println("Can't accept client connection. ");
        }

        try {
            in = socket.getInputStream();
        } catch (IOException ex) {
            System.out.println("Can't get socket input stream. ");
        }
        
        (new ThreadServerListen(this)).start();
        //getFiles();
//        out.close();
        //File tf = new File(direct+"\\testTXT.txt");
        //sendFiles(tf);


        


        
        
//        out.close();
        //in.close();
//        socket.close();
//        serverSocket.close();
    }
    public void getFiles() throws IOException{
        try {
//            URL location = getClass().getProtectionDomain().getCodeSource().getLocation();
//            File direct = new File(location.getPath());
//                direct = direct.getParentFile();
                
        //System.out.println("yoo "+temp.getParent()+"\\files\\");

            //out = new FileOutputStream("C:\\Users\\user6\\Desktop\\tp\\partageServer-master\\files\\testTXT.txt");
            //out = new FileOutputStream(direct+"\\testTXT.txt");
            out = new FileOutputStream(direct+"\\mage.png");
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        }

        byte[] bytes = new byte[16*1024];

        int count;
        if (in.available() > 0){
            while ((count = in.read(bytes)) > 0) {
                out.write(bytes, 0, count);
            }
            out.close();
        }
        
    }
    public void sendFiles(File f) throws FileNotFoundException, IOException{
        //File tf = new File(direct+"\\mage.png");

        //sendFiles(tf);
        byte [] mybytearray  = new byte [(int)f.length()];
        fis = new FileInputStream(f);
        bis = new BufferedInputStream(fis);
        bis.read(mybytearray,0,mybytearray.length);
        os = socket.getOutputStream();
        System.out.println("Sending " + f + "(" + mybytearray.length + " bytes)");
        os.write(mybytearray,0,mybytearray.length);
        os.flush();
        System.out.println("Done.");

          if (bis != null) bis.close();
          if (os != null) os.close();
    }
    public void sendFile(File f) throws IOException{
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
        }

    public ServerSocket getServerSocket() {
        return serverSocket;
    }

    public void setServerSocket(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public InputStream getIn() {
        return in;
    }

    public void setIn(InputStream in) {
        this.in = in;
    }

    public OutputStream getOut() {
        return out;
    }

    public void setOut(OutputStream out) {
        this.out = out;
    }

    public URL getLocation() {
        return location;
    }

    public void setLocation(URL location) {
        this.location = location;
    }

    public File getDirect() {
        return direct;
    }

    public void setDirect(File direct) {
        this.direct = direct;
    }

    public FileInputStream getFis() {
        return fis;
    }

    public void setFis(FileInputStream fis) {
        this.fis = fis;
    }

    public BufferedInputStream getBis() {
        return bis;
    }

    public void setBis(BufferedInputStream bis) {
        this.bis = bis;
    }

    public OutputStream getOs() {
        return os;
    }

    public void setOs(OutputStream os) {
        this.os = os;
    }

    public ServerSocket getServsock() {
        return servsock;
    }

    public void setServsock(ServerSocket servsock) {
        this.servsock = servsock;
    }
    
    
    
    
    public static void main(String[] args) throws IOException {
        Server s = new Server();
    }
}