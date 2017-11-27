import java.net.*;

import java.io.*;

import java.util.*;



class clien
{

	public static void main(String args[])
{

		try
{

			DatagramSocket skt = new DatagramSocket();
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		String str1,str2;
		
			byte[] buffer = new byte[100];

			InetAddress host = InetAddress.getByName("127.0.0.1");
		
			int port_no = 6792;
		
		
			do
{
	
			System.out.print("CLIENT :  ");
	
			str1 = br.readLine();
	
			byte[] b1 = str1.getBytes();
			
				DatagramPacket p1 = new DatagramPacket(b1,b1.length,host,port_no);
	
			skt.send(p1);
	
			if(!str1.equals("bye bye")){
					System.out.print("SERVER :  ");
					DatagramPacket p2 = new DatagramPacket(buffer,buffer.length);
	
				skt.receive(p2);
	
				str2 = "";

					str2 = new String(p2.getData());

					System.out.println(str2);

				}
		
			}while(!str1.equals("bye bye"));

	
		System.out.println("\n\nclosing the application....");

	
		skt.close();

		}
 catch(Exception e){
		
			System.out.println("error");
		
				    }
	
	}

}
			
