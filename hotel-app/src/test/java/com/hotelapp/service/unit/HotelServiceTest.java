package com.hotelapp.service.unit;

import static org.junit.Assert.*;



import org.junit.Test;

import com.hotelapp.swb.service.HotelService;

public class HotelServiceTest { 
	
	@Test
	public void testBooking1() {
		HotelService hotelService=new HotelService();
		hotelService.createHotel(1);

		Boolean booking1 = hotelService.booking(-4, 2);
		Boolean booking2 = hotelService.booking(200, 400);
		assertEquals(false, booking1);
		assertEquals(false, booking2);
	}

	@Test	
	public void testBooking2() {
		HotelService hotelService=new HotelService();
		hotelService.createHotel(3);
		
		Boolean booking1 = hotelService.booking(0, 5);
		Boolean booking2 = hotelService.booking(7, 13);
		Boolean booking3 = hotelService.booking(3, 9);
		Boolean booking4 = hotelService.booking(5, 7);
		Boolean booking5 = hotelService.booking(6, 6);
		Boolean booking6 = hotelService.booking(0, 4);

		assertEquals(true, booking1);
		assertEquals(true, booking2);
		assertEquals(true, booking3);
		assertEquals(true, booking4);
		assertEquals(true, booking5);
		assertEquals(true, booking6);
	}
	
	@Test
	public void testBooking3() {
		HotelService hotelService=new HotelService();
		hotelService.createHotel(3);

		Boolean booking1 = hotelService.booking(1, 3);
		Boolean booking2 = hotelService.booking(2, 5);
		Boolean booking3 = hotelService.booking(1, 9);
		Boolean booking4 = hotelService.booking(0, 15);

		assertEquals(true, booking1);
		assertEquals(true, booking2);
		assertEquals(true, booking3);
		assertEquals(false, booking4);
	}

	@Test	
	public void testBooking4() {
		HotelService hotelService=new HotelService();
		hotelService.createHotel(3);

		Boolean booking1 = hotelService.booking(1, 3);
		Boolean booking2 = hotelService.booking(0, 15);
		Boolean booking3 = hotelService.booking(1, 9);
		Boolean booking4 = hotelService.booking(2, 5);
		Boolean booking5 = hotelService.booking(4, 9);

		assertEquals(true, booking1);
		assertEquals(true, booking2);
		assertEquals(true, booking3);
		assertEquals(false, booking4);
		assertEquals(true, booking5);
	}

	@Test	
	public void testBooking5() {
		HotelService hotelService=new HotelService();
		hotelService.createHotel(2);

		Boolean booking1 = hotelService.booking(1, 3);
		Boolean booking2 = hotelService.booking(0, 4);
		Boolean booking3 = hotelService.booking(2, 3);
		Boolean booking4 = hotelService.booking(5, 5);
		Boolean booking5 = hotelService.booking(4, 10);
		Boolean booking6 = hotelService.booking(10, 10);
		Boolean booking7 = hotelService.booking(6, 7);
		Boolean booking8 = hotelService.booking(8, 10);
		Boolean booking9 = hotelService.booking(8, 9);

		assertEquals(true, booking1);
		assertEquals(true, booking2);
		assertEquals(false, booking3);
		assertEquals(true, booking4);
		assertEquals(true, booking5);
		assertEquals(true, booking6);
		assertEquals(true, booking7);
		assertEquals(false, booking8);
		assertEquals(true, booking9);
	}
}
