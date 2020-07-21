package com.hotelapp.swb.entity;

import java.util.ArrayList;

public class Room {

	private final int roomId;
	private ArrayList<Booking> bookings;

	public Room(int roomId) {
		this.roomId = roomId;
		bookings = new ArrayList<>();
	}

	public int getRoomId() {
		return roomId;
	}

	public ArrayList<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(ArrayList<Booking> bookings) {
		this.bookings = bookings;
	}

	public Integer distanceFromOtherBookings(Integer start, Integer end) {
		Integer closestLeft = 0;
		Integer closestRight = 0;

		for (Booking booking : bookings) {
			if (booking.getEnd() < start && booking.getEnd() > closestLeft)
				closestLeft = booking.getEnd();

			if (booking.getStart() > end && booking.getStart() < closestRight)
				closestRight = booking.getStart();
		}

		Integer distance = (start - closestLeft) + (closestRight - end);

		return distance;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + roomId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Room other = (Room) obj;
		if (roomId != other.roomId)
			return false;
		return true;
	}
}
