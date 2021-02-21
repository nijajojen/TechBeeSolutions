package com.techbsolutions.banktransactiondaojdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.techbsolutions.banktransactiondao.BankUserModel;

/**
 * For each database table, we have to create a Dao class. This class contains
 * jdbc to connect to the database and to do CRUD operations and this will be
 * done through the pojo or model class.So model/pojo class will stand between
 * Dao and database.
 */
public class BankUserDao {

	ArrayList<BankUserModel> users = new ArrayList<BankUserModel>();

	final String DB_URL = "jdbc:mysql://bankdb.cwoep3xkzjdd.us-west-1.rds.amazonaws.com:3306/bankdb";
	final String USER = "admin";
	final String PASS = "password-123";
	Connection conn = null;

	public BankUserDao() {
		createConnection();
	}

	private void createConnection() {
		try {
			// final String JDBC_DRIVER = "com.mysql.jdbc.Driver";

			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Connecting to database...");

			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// System.out.println("Creating table in given database...");

			/*
			 * String sql = "CREATE TABLE OurTable " + "(AccountId INTEGER not NULL, " +
			 * " firstName VARCHAR(255), " + " lastName VARCHAR(255), " +
			 * " age INTEGER(3));";
			 */

		} catch (SQLException | ClassNotFoundException e) {
			(e).printStackTrace();

		}

	}

	/**
	 * Add a new User
	 * 
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param phoneNumber
	 */

	public void createUser(BankUserModel userModel) {
		try {

			Statement stmt = conn.createStatement();
			String sql = "INSERT INTO `Transactions` (`FirstName`,`LastName`,`Email`,`PhoneNumber`,`Balance`) "
					+ "VALUES ( '" + userModel.getFirstName() + "','" + userModel.getLastName() + "','"
					+ userModel.getEmail() + "'," + userModel.getPhoneNumber() + "," + userModel.getBalance() + ");";

			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();

		}
	}

	/**
	 * Show User Details for a given email
	 * 
	 * @param email
	 */
	public void displayUserDetails(String email) {
		BankUserModel user = findUser(email);
		if (user == null) {
			System.out.println("resource not found");
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
		double newFund = user.getBalance() + amount;

		boolean isBalanceUpdateOp = updateBalance(email, newFund);
		return isBalanceUpdateOp;

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
		Double newBalance = balance - fund;
		if (newBalance < 0)
			return -1;
		boolean isBalanceUpdateOp = updateBalance(email, newBalance);
		if (!isBalanceUpdateOp) {
			System.out.println("Update Balance Failed");
			return -1;
		}
		return newBalance;

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
		try {
			String sql = "Select firstname,lastname,email,phonenumber,balance from `Transactions` where `Email` ='"
					+ email + "';";
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
				BankUserModel userModel = new BankUserModel();
				userModel.setFirstName(rs.getString("firstname"));
				userModel.setLastName(rs.getString("lastname"));
				userModel.setEmail(rs.getString("email"));
				userModel.setPhoneNumber(rs.getLong("phonenumber"));
				userModel.setBalance(rs.getDouble("balance"));
				return userModel;
			}

		} catch (SQLException e) {
			// Resource Not Found
			e.printStackTrace();
		}
		return null;

	}

	/**
	 * Return an account with given email
	 * 
	 * @param email
	 * @return
	 */

	private boolean updateBalance(String email, double balance) {
		try {
			String updateSql = "update `Transactions` set `balance`= ? where `email` = '" + email + "';";
			PreparedStatement prepstmt = conn.prepareStatement(updateSql);
			prepstmt.setDouble(1, balance);
			prepstmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			// Resource Not Found
			e.printStackTrace();
		}
		return false;

	}

}
