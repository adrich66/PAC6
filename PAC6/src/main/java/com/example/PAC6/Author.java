package com.example.PAC6;


public class Author {

	private static int id= 1;
	
	private String name;
	private String country;
	private Dob dob;
	private int qtyBooks;
	private boolean alive;
	private int authorID;
	
	public Author() {
		super();
	}

	public Author(String name, String country, Dob dob, int qtyBooks, boolean alive) {
		super();
		
		this.name = name;
		this.country = country;
		this.dob = dob;
		this.qtyBooks = qtyBooks;
		this.alive = alive;
		authorID = id;
		id++;
	}

	public int getAuthorID() {
		return authorID;
	}

	public void setAuthorID(int authorID) {
		this.authorID = authorID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Dob getDob() {
		return dob;
	}

	public void setDob(Dob dob) {
		this.dob = dob;
	}

	public int getQtyBooks() {
		return qtyBooks;
	}

	public void setQtyBooks(int qtyBooks) {
		this.qtyBooks = qtyBooks;
	}

	public boolean getAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	@Override
	public String toString() {
		return "Author [id=" + id + ", name=" + name + ", country=" + country + ", dob=" + dob + ", qtyBooks="
				+ qtyBooks + ", alive=" + alive + "]";
	}
}