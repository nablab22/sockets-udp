package Recepteur;

import java.io.*;
import java.net.*;

public class Recepteur { //Serveur

	public static void main(String[] args) {
		int port = 1224;
 
        try {
            System.out.println("En attente de reception de fichiers");

			    DatagramSocket socket = new DatagramSocket(port);
			    byte[] tampon=new byte[2024];
	    	    
                FileOutputStream f=new FileOutputStream("C:\\Users\\lenovo\\eclipse-workspace\\RSR\\src\\Recepteur\\f1_recu.txt");

	            while(true)
                {
                            DatagramPacket dp=new DatagramPacket(tampon,tampon.length);
                            socket.receive(dp);
                            f.write(tampon);
                            System.out.println("Fichier recu");                             
                }
	    	}
	    
	    catch (Exception exc) {System.out.println("problème de réception");}
	    }
	

}