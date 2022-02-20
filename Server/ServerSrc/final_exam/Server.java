/*
 * EE422C Final Project submission by
 * Replace <...> with your actual data.
 * Sylvia Vu
 * sav987
 * 16330
 * Spring 2020
 */


package final_exam;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Observable;
import java.util.Scanner;




public class Server extends Observable{

    public static int port = 6969;

    public static void main(String[] args)  throws Exception{
        ReadFile.processFile();
    }

    private void runServer(){
        try{
            initServer();
        } catch(Exception e){
            e.printStackTrace();
            return;
        }
    }

    private void initServer() throws Exception{
        @SuppressWarnings("resource")
        ServerSocket serverSocket = new ServerSocket(port);

        while(true){
            Socket clientSocket = serverSocket.accept();
            System.out.println("Connecting to... " + clientSocket);



        }
    }






}
