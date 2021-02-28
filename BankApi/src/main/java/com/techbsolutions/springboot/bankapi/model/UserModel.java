package com.techbsolutions.springboot.bankapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="user")
public class UserModel {
	
	private String firstName;
	private String lastName;
	@Id
	private String email;
	private long phoneNumber;
	private double balance;

	
	private Long accountId;
	

	

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public double getBalance() {
		return balance;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String toString() {
		return "Firstname: " + firstName + " lastname: " + lastName + " email: " + email + " phonenumber: "
				+ phoneNumber;
	}

}
