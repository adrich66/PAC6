package com.example.PAC6;


public class Dob {
	private int day;
	private int month;
	private int year;
	
	public Dob() {
		super();
	}
	
	public Dob(int day, int month, int year) {
		super();
		this.day = day;
		this.month = month;
		this.year = year;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "Dob [day=" + day + ", month=" + month + ", year=" + year + "]";
	}
}
