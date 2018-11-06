package javaLesson;

import java.net.InetAddress;

public class NetworkEx17_1 {

	public static void main(String[] args) {
		try {
			String name = "www.google.co.kr";
			InetAddress inetAddr = InetAddress.getByName(name);
			String hostName = inetAddr.getHostName();
			String hostAddress = inetAddr.getHostAddress();
			System.out.println(hostName + " : " + hostAddress);

			InetAddress localHost = InetAddress.getLocalHost();
			String localName = localHost.getHostName();
			String localAddress = localHost.getHostAddress();
			System.out.println(localName + " : " + localAddress);

			byte[] b = localHost.getAddress();
			for (int i = 0; i < b.length; i++) {
				String a = Integer.toString((b[i] < 0) ? (b[i] + 255) : b[i]);
				System.out.print(a + ".");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} // close try-catch

	} // close main

} // close class
