package Recepteur;

import java.io.*;
import java.net.*;

public class Recepteur_multicast { //Serveur

	public static void main(String[] args) {
		int port = 1224;
 
        try {
			    DatagramSocket socket = new DatagramSocket(port);
		        MulticastSocket serverSocket = new MulticastSocket(port);
		        InetAddress group = InetAddress.getByName("230.0.0.5");
	            System.out.println("En attente de reception de fichiers");

	            NetworkInterface networkInterface = NetworkInterface.getByInetAddress(group);
	            serverSocket.joinGroup(new InetSocketAddress(group, port), networkInterface);
	           // serverSocket.joinGroup(group);

	            byte[] tampon=new byte[2024];
	    	    
                FileOutputStream f=new FileOutputStream("C:\\Users\\lenovo\\eclipse-workspace\\RSR\\src\\Recepteur\\f1_recu.txt");

	            while(true)
                {
                            DatagramPacket dp=new DatagramPacket(tampon,tampon.length);
                            serverSocket.receive(dp);
                            f.write(tampon);
                            System.out.println("Fichier reçu");                             


                }
	            

	    	}
	    
	    catch (Exception exc) {System.out.println("problème de réception");}
	    }
	

}