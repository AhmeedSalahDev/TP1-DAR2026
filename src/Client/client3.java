package Client;

import java.io.*;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class client3 {
    public static void main(String[] args) throws IOException {

        // Adresse IP de la machine serveur (remplace "localhost")
        InetAddress adresseServeur = InetAddress.getByName("192.168.1.15");
        int port = 1234;

        System.out.println("Je suis un client pas encore connecté...");
        Socket socket = new Socket();
        socket.connect(new InetSocketAddress(adresseServeur, port));
        System.out.println("Je suis un client connecté au serveur " + adresseServeur.getHostAddress() + ":" + port);

        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        DataInputStream dis = new DataInputStream(socket.getInputStream());
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== MENU CALCULATRICE =====");
            System.out.println("1. Addition");
            System.out.println("2. Soustraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.println("0. Quitter");
            System.out.print("Votre choix : ");
            int choix = scanner.nextInt();

            if (choix == 0) {
                dos.writeInt(0);
                System.out.println("Fin de la communication.");
                break;
            }
            if (choix < 1 || choix > 4) {
                System.out.println("Choix invalide, réessayez.");
                continue;
            }

            System.out.print("Entrez x : ");
            int x = scanner.nextInt();
            System.out.print("Entrez y : ");
            int y = scanner.nextInt();

            dos.writeInt(choix);
            dos.writeInt(x);
            dos.writeInt(y);

            String resultat = dis.readUTF();
            System.out.println("Résultat reçu du serveur : " + resultat);
        }

        dis.close();
        dos.close();
        socket.close();
        scanner.close();
    }
}