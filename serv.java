import java.net.*;

import java.util.*;

import java.io.*;



class serv
{

	public static void main (String args[])
	{

		try 
{

				DatagramSocket skt = new DatagramSocket(6792);
			
	byte[] buffer = new byte[100];
		
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str1;
		

		do
 {

					DatagramPacket p1 = new DatagramPacket(buffer,buffer.length);
		
			skt.receive(p1);
		
			String str2 = new String(p1.getData());

					System.out.println("CLIENT :  "+str2);
		
			System.out.print("SERVER :  ");
		
			str1 = br.readLine();
	
					byte[] b1 = str1.getBytes();
		
					DatagramPacket p2 = new DatagramPacket(b1,b1.length,p1.getAddress(),p1.getPort());
		
			skt.send(p2);
			
	}
		
		while(!str1.equals("bye bye"));
	
	
			System.out.println("\n\nclosing the chat application...");
	
				skt.close();

			}
catch(Exception e)
{

			System.out.println("Error");

		
	}
	}

}
		
