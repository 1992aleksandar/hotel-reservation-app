package com.hotelapp.swb;

import java.util.Scanner;

import com.hotelapp.swb.service.HotelService;

public class Main {

	public static void main(String args[]) throws InterruptedException {
		try (Scanner scanner = new Scanner(System.in)) {
			HotelService hotelService = new HotelService();			
			Integer roomNumber;

			do {
				System.out.println("Please enter number of rooms the hotel has. Maximum number of rooms is 1000.");
				roomNumber = scanner.nextInt();
			} while (roomNumber > 1000 || roomNumber < 1);

			hotelService.createHotel(roomNumber);
			String input;
			Integer startDay;
			Integer endDay;

			do {				
				System.out.println("Please enter the booking start day.");
				startDay = scanner.nextInt();
				System.out.println("Please enter the booking end day.");
				endDay = scanner.nextInt();

				if (hotelService.booking(startDay, endDay))
					System.out.println("Booking (" + startDay + ", " + endDay + ")" + " accepted");
				else
					System.out.println("Booking (" + startDay + ", " + endDay + ")" + " declined");

				System.out.println("Another booking? Press y for yes or any other key to exit the program.");
				input = scanner.next();

			} while (input.equals("y") || input.equals("Y"));		
		}
		
		System.out.println("Exiting the program.");
		Thread.sleep(2000);		
	}
}