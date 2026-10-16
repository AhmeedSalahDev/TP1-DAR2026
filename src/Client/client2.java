package Client;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class client2 {
    static void main(String[] args) throws IOException {
        System.out.println("je suis un client pas encore connecté...");

        Socket socket = new Socket("localhost",1234);
        System.out.println("je suis un client connecté");

        Scanner scanner = new Scanner(System.in);
        System.out.println("ecrire un entier x : ");
        int x = scanner.nextInt();

        OutputStream os = socket.getOutputStream();
        DataOutputStream dos = new DataOutputStream(os);
        dos.writeInt(x);
        System.out.println("Nombre envoyé au serveur : "+x);

        InputStream is = socket.getInputStream();
        DataInputStream dis = new DataInputStream(is);
        int xx = dis.readInt();
        System.out.println("Resultat réçu du server : "+xx);

        dis.close();
        dos.close();
        socket.close();
        scanner.close();
    }
}
