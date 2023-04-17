package Recepteur;

import java.io.*;
import java.net.*;

public class Recepteur_img { //Serveur

	public static void main(String[] args) {
		int port = 1224;
 
        try {
            System.out.println("En attente de reception de fichiers");

			    DatagramSocket socket = new DatagramSocket(port);
			    

			    File imagefile = new File("C:\\Users\\lenovo\\eclipse-workspace\\RSR\\src\\Recepteur\\image_recu.jpeg");

                FileOutputStream f=new FileOutputStream(imagefile);
                byte[] buffer = new byte[65507];
	            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

                while (true) {
                    socket.receive(packet);
                    int l = packet.getLength();
                    f.write(buffer, 0, l);
                    System.out.println("Fichier reçu de l'adresse : " + packet.getAddress() + ", port : " + packet.getPort());
                    socket.close();
               }
	    	}

	    catch (Exception exc) {System.out.println("Erreur"+exc);}
	    }
	

}