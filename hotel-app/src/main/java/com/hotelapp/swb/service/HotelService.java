package com.hotelapp.swb.service;

import java.util.ArrayList;
import java.util.List;

import com.hotelapp.swb.entity.Booking;
import com.hotelapp.swb.entity.Hotel;
import com.hotelapp.swb.entity.Room;

public class HotelService {

	private Hotel hotel;

	public HotelService() {
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public void createHotel(Integer size) {
		if ((size < 1) || (size > 1000))
			throw new RuntimeException("Invalid room number");

		hotel = new Hotel(size);

		for (int i = 1; i <= size; i++)
			hotel.getHotelRooms().add(new Room(i));
	}

	public Boolean booking(int start, int end) {
		Integer size = hotel.getHotelSize();
		Room room = null;
		ArrayList<Room> availableRooms = new ArrayList<>();

		if ((start < 0) || (end >= 365))
			return false;

		if (start > end)
			return false;

		for (int i = 1; i <= size; i++) {
			room = hotel.getRoomById(i);

			if (roomIsAvailable(room, start, end)) {
				availableRooms.add(room);
			}
		}

		if (!availableRooms.isEmpty()) {
			Room selectedRoom = roomSelection(availableRooms, start, end);
			Booking newBooking = new Booking(start, end);
			selectedRoom.getBookings().add(newBooking);
			return true;
		}
		
		return false;
	}

	public Room roomSelection(List<Room> availableRooms, Integer start, Integer end) {
		Room selectedRoom = availableRooms.get(0);
		Integer minDistance = selectedRoom.distanceFromOtherBookings(start, end);

		if (availableRooms.size() > 1)
			for (int i = 1; i < availableRooms.size(); i++) {
				Room room = availableRooms.get(i);
				Integer distance = room.distanceFromOtherBookings(start, end);

				if (distance < minDistance) {
					minDistance = distance;
					selectedRoom = room;
				}
			}

		return selectedRoom;
	}

	public Boolean roomIsAvailable(Room room, Integer start, Integer end) {
		List<Booking> bookings = room.getBookings();
		Boolean available = true;

		for (Booking booking : bookings) {
			for (int j = start; j <= end; j++) {
				if (j >= booking.getStart() && j <= booking.getEnd()) {
					available = false;
					break;
				}
			}
		}
		
		return available;
	}	
}