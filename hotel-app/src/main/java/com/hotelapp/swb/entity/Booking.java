package com.hotelapp.swb.entity;

public class Booking {

	private Integer start;
	private Integer end;

	public Booking() {
	}

	public Booking(Integer start, Integer end) {
		this.start = start;
		this.end = end;
	}

	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public Integer getEnd() {
		return end;
	}

	public void setEnd(Integer end) {
		this.end = end;
	}
}
