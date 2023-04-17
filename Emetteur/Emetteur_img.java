package Emetteur;

import java.io.*;
import java.net.*;

public class Emetteur_img {//Client

	public static void main(String[] args) {

		String host="localhost";
	    File imagefile = new File("C:\\Users\\lenovo\\eclipse-workspace\\RSR\\src\\Emetteur\\image.jpeg");
		try {
		    DatagramSocket Soc = new DatagramSocket();
		    System.out.println("Port local Client:" +Soc.getLocalPort());
		    
		    InetAddress adIP=InetAddress.getByName(host);
	    
            FileInputStream f=new FileInputStream(imagefile);

            byte[] buffer = new byte[65507];//Max Supporté 2^16
            int i;
            while ((i = f.read(buffer)) != -1) {
            	DatagramPacket packet = new DatagramPacket(buffer, i, adIP, 1224);
            	Soc.send(packet);
            	}
            f.close();
            Soc.close();
	   }
	    catch (Exception exc) {System.out.println(exc);}

	}

}