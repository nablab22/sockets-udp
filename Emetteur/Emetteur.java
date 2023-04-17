package Emetteur;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Emetteur {//Client

	public static void main(String[] args) {
		//int port = 2024;
		String host="localhost";
	    Scanner sc = new Scanner(System.in);

		try {
		    DatagramSocket Soc = new DatagramSocket();
		    System.out.println("Port local Client:" +Soc.getLocalPort());
		    
		    InetAddress adIP=InetAddress.getByName(host);
		    
		    byte[] tampon=new byte[2024];

		    int l=tampon.length;
		    
            FileInputStream f=new FileInputStream("C:\\Users\\lenovo\\eclipse-workspace\\RSR\\src\\Emetteur\\f1.txt");

            /*int i=0;
            while(f.available()!=0)
            {
            	tampon[i]=(byte)f.read();
            	i++;
            }                     
            f.close();
		    DatagramPacket packet=new DatagramPacket(tampon, l,adIP,1224);
		    Soc.send(packet);*/
		    int i=0;
            while((i=f.read(tampon))!=-1)
            {
            	DatagramPacket packet=new DatagramPacket(tampon,i,adIP,1224);
            	Soc.send(packet);
            }                     
            f.close();

	    
	
	   }
	    catch (Exception exc) {System.out.println(exc);}

	}

}