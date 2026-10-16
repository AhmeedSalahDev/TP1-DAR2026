package server;

import java.io.*;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class server3 {
    public static void main(String[] args) throws IOException {

        // Adresse IP réelle de la machine serveur (à vérifier avec "ipconfig" sous Windows)
        InetAddress adresseIP = InetAddress.getByName("192.168.1.15");
        int port = 1234;
        InetSocketAddress adresseServeur = new InetSocketAddress(adresseIP, port);

        ServerSocket socketServer = new ServerSocket();
        socketServer.bind(adresseServeur);
        System.out.println("Serveur en écoute sur " + adresseIP.getHostAddress() + ":" + port);

        Socket socket = socketServer.accept();
        System.out.println("Un client est connecté depuis : " + socket.getInetAddress().getHostAddress());

        DataInputStream dis = new DataInputStream(socket.getInputStream());
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

        while (true) {
            int choix = dis.readInt();
            if (choix == 0) {
                System.out.println("Le client a demandé la fin de la communication.");
                break;
            }

            int x = dis.readInt();
            int y = dis.readInt();
            String reponse;

            switch (choix) {
                case 1:
                    reponse = x + " + " + y + " = " + (x + y);
                    break;
                case 2:
                    reponse = x + " - " + y + " = " + (x - y);
                    break;
                case 3:
                    reponse = x + " * " + y + " = " + (x * y);
                    break;
                case 4:
                    if (y == 0) {
                        reponse = "Erreur : division par zéro impossible";
                    } else {
                        reponse = x + " / " + y + " = " + ((double) x / y);
                    }
                    break;
                default:
                    reponse = "Erreur : opération inconnue";
            }

            System.out.println("Calcul du serveur : " + reponse);
            dos.writeUTF(reponse);
        }

        dis.close();
        dos.close();
        socket.close();
        socketServer.close();
        System.out.println("Serveur arrêté.");
    }
}