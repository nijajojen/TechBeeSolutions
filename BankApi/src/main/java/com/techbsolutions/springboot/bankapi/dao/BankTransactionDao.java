package com.techbsolutions.springboot.bankapi.dao;

import java.util.Optional;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.techbsolutions.springboot.bankapi.model.UserModel;
import com.techbsolutions.springboot.bankapi.repository.UserRepository;

@Component
public class BankTransactionDao {

	@Inject
	UserRepository userRepo;

	/**
	 * Add a new User
	 * 
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param phoneNumber
	 */

	public UserModel createAccount(UserModel user) {

		return userRepo.save(user);
	}

	/**
	 * Show User Details for a given email
	 * 
	 * @param email
	 * @return
	 */

	public UserModel displayUserDetails(String email) {
		UserModel user = findUser(email);
		return user;
	}

	/**
	 * Deposits Amount to given email
	 * 
	 * @param email
	 * @param amount
	 * @return
	 */
	public double depositFund(String email, double amount) {

		UserModel user = findUser(email);

		if (user == null) {
			return 0;
		}

		double newFund = user.getBalance() + amount;

		user.setBalance(newFund);
		userRepo.save(user);

		return newFund;

	}

	/**
	 * Withdraw amount from an account with given email
	 * 
	 * @param email
	 * @param fund
	 * @return
	 */

	public double withdrawAmount(String email, double fund) {
		UserModel user = findUser(email);
		if (user == null) {
			return -1;
		}
		Double balance = user.getBalance();
		Double newBalance = balance - fund;
		if (newBalance < 0)
			return -1;

		user.setBalance(newBalance);
		userRepo.save(user);
		return newBalance;

	}

	/**
	 * Show Account Balance
	 * 
	 * @param email
	 */

	public void showBalance(String email) {
		UserModel user = findUser(email);
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

	private UserModel findUser(String email) {
		Optional<UserModel> userOptional = userRepo.findById(email);
		if (userOptional.isPresent()) {
			return userOptional.get();
		}

		return null;
	}

}
