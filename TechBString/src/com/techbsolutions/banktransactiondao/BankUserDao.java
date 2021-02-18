package com.techbsolutions.banktransactiondao;

import java.util.ArrayList;

/**
 * For each database table, we have to create a Dao class. This class contains
 * jdbc to connect to the database and to do CRUD operations and this will be
 * done through the pojo or model class.So model/pojo class will stand between
 * Dao and database.
 */
public class BankUserDao {

	ArrayList<BankUserModel> users = new ArrayList<BankUserModel>();

	/**
	 * Add a new User
	 * 
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param phoneNumber
	 */
	public void addUser(String firstName, String lastName, String email, long phoneNumber) {
		BankUserModel userModel = new BankUserModel();
		userModel.setFirstName(firstName);
		userModel.setLastName(lastName);
		userModel.setEmail(email);
		userModel.setPhoneNumber(phoneNumber);
		users.add(userModel);
	}

	/**
	 * Show User Details for a given email
	 * 
	 * @param email
	 */
	public void showUserDetails(String email) {
		BankUserModel user = findUser(email);
		if (user == null) {
			System.out.println("No User Found");
		}

		System.out.println(user);
	}

	/**
	 * Deposits Amount to given email
	 * 
	 * @param email
	 * @param amount
	 * @return
	 */
	public boolean depositFund(String email, double amount) {
		BankUserModel user = findUser(email);
		if (user == null) {
			return false;
		}

		Double balance = user.getBalance();
		balance = balance + amount;
		user.setBalance(balance);
		return true;
	}

	/**
	 * Withdraw amount from an account with given email
	 * 
	 * @param email
	 * @param fund
	 * @return
	 */
	public double withdrawAmount(String email, double fund) {
		BankUserModel user = findUser(email);
		if (user == null) {
			return -1;
		}
		Double balance = user.getBalance();
		Double tempBalance = balance;
		if (balance <= 0)
			return -1;
		else {
			tempBalance -= fund;
			if (tempBalance < 0)
				return -1;
			else
				user.setBalance(tempBalance);
		}
		return tempBalance;

	}

	/**
	 * Show Account Balance
	 * 
	 * @param email
	 */
	public void showBalance(String email) {
		BankUserModel user = findUser(email);
		if (user != null) {
			System.out.println(user.getBalance());
		} else {
			System.out.println("No User Found");
		}
	}

	/**
	 * Return an account with given email
	 * 
	 * @param email
	 * @return
	 */
	private BankUserModel findUser(String email) {
		for (BankUserModel user : users) {
			if (user.getEmail().equalsIgnoreCase(email)) {
				return user;
			}
		}
		return null;
	}

}
