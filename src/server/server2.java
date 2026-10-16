package server;

import java.io.*;
import java.net.Socket;
import java.net.ServerSocket;

public class server2 {
    static void main(String[] args) throws IOException{
        ServerSocket socketServer = new ServerSocket(1234);
        Socket socket = socketServer.accept();
        System.out.println("un client est connecté");

        InputStream is = socket.getInputStream();
        DataInputStream dis = new DataInputStream(is);
        int nb = dis.readInt();
        System.out.println("le serveur a recu le nombre "+nb);

        int x = nb * 5;
        System.out.println("Calcul du serveur : "+nb+" * 5 = "+x);

        OutputStream os = socket.getOutputStream();
        DataOutputStream dos = new DataOutputStream(os);
        dos.writeInt(x);
        System.out.println("le résultat a été envoyé au client."+nb);

        dis.close();
        dos.close();
        socket.close();
        socketServer.close();
    }
}
