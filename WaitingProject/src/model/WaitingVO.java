package model;

import java.sql.Timestamp;
import java.util.Date;

public class WaitingVO {
	private int no;
	private String phone;
	private int  people;
	private Timestamp receTime;
	
	
	public WaitingVO(int no, String phone, int people, Timestamp receTime) {
		super();
		this.no = no;
		this.phone = phone;
		this.people = people;
		this.receTime = receTime;
	}
	public WaitingVO(String phone, int people) {
		this.phone = phone;
		this.people = people;
	}


	public int getNo() {
		return no;
	}


	public void setNo(int no) {
		this.no = no;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public int getPeople() {
		return people;
	}


	public void setPeople(int people) {
		this.people = people;
	}


	public Timestamp getReceTime() {
		return receTime;
	}


	public void setReceTime(Timestamp receTime) {
		this.receTime = receTime;
	}
	
	
	
}
