package com.hotelapp.swb.entity;

import java.util.ArrayList;

public class Hotel {

	private Integer hotelSize;
	private ArrayList<Room> hotelRooms = new ArrayList<>();

	public Hotel(Integer hotelSize) {
		this.hotelSize = hotelSize;
	}

	public Integer getHotelSize() {
		return hotelSize;
	}

	public void setHotelSize(Integer hotelSize) {
		this.hotelSize = hotelSize;
	}

	public ArrayList<Room> getHotelRooms() {
		return hotelRooms;
	}

	public void setHotelRooms(ArrayList<Room> hotelRooms) {
		this.hotelRooms = hotelRooms;
	}

	public Room getRoomById(Integer id) {
     if ((id<=0) || (id>(hotelSize)))
    	 throw new RuntimeException("No room with such id");
		
		return hotelRooms.get(id-1);	
	}
}
