package com.java.test;

import java.sql.Timestamp;

public class TimeStampTest {

	public static void main(String[] args) {
		
		String str = "1480431827965";
		long number = Long.parseLong(str);
		Timestamp time = new Timestamp(number);
		System.out.println(str);
		System.out.println(number);
		System.out.println(time);
		// Server : A message received from session_id [ 2 ]
		// Server : Message Type [ send ]
		// Server : sender_id [ asdf ]
		// Server : receiver_id [ 123 ]
		// Server : sending time [ 2016-11-30 00:03:47.965 ]
		// Server : message [ test ]
		// Server : is_read [ 0 ]
		//
		// Sending a message from the sender_id ( asdf ) to the receiver_id ( 123 )
		//
		// Server : A message received from session_id [ 3 ]
		// Server : Message Type [ echo ]
		// Server : sender_id [ 123 ]
		// Server : receiver_id [ asdf ]
		// Server : sending time [ 2016-11-30 00:04:37.475 ]
		// Server : message [ 1480431827965 ]
		// Server : is_read [ 0 ]

	}

}
