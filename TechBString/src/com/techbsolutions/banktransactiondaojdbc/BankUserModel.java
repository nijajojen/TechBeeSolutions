package com.techbsolutions.banktransactiondaojdbc;

/**
 * For each database table, a model should be created and each field in this
 * model class should exactly match the fields in the database table. Inside the
 * class there will be private variables. And it have public getter setter
 * methods.
 */
public class BankUserModel {

	private int accountNum;
	private double balance;
	private String firstName;
	private String lastName;
	private String email;
	private long phoneNumber;

	public int getAccountNum() {
		return accountNum;
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

	public void setAccountNum(int accountNum) {
		this.accountNum = accountNum;
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
