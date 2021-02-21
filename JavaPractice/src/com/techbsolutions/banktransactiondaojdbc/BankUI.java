package com.techbsolutions.banktransactiondaojdbc;

import java.util.Scanner;

import com.techbsolutions.banktransactiondao.BankUserModel;

public class BankUI {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int val = 0;
		BankUserDao userDao = new BankUserDao();

		do {

			System.out.println("Select from the following options.");
			System.out.println("1.Are you a new Customer? To create new Account,Enter 1");// done
			System.out.println("2.To Deposit money,Enter 2.");// done
			System.out.println("3.To Withdraw Money,Enter 3");// done
			System.out.println("4.Show account details,Enter 4");// done
			System.out.println("5.To Show Account Balance,Enter 5.");// done
			System.out.println("6.To Exit,Enter,0");
			System.out.println("Enter the options:");

			int option = sc.nextInt();

			switch (option) {

			case 1:
				System.out.println("Enter the name: ");
				String firstName = sc.next();
				System.out.println("Enter the lastname: ");
				String lastName = sc.next();
				System.out.println("Enter the email: ");
				String email = sc.next();
				System.out.println("Enter the phoneNumber: ");
				long phoneNumber = sc.nextLong();
				BankUserModel userModel = new BankUserModel();
				userModel.setFirstName(firstName);
				userModel.setLastName(lastName);
				userModel.setEmail(email);
				userModel.setPhoneNumber(phoneNumber);
				userModel.setBalance(0);
				userDao.createUser(userModel);
				System.out.println("Account created");
				break;

			case 2:
				System.out.println("Enter the email: ");
				email = sc.next();
				System.out.println("Enter the amount to deposit: ");
				double amount = sc.nextDouble();
				boolean status = userDao.depositFund(email, amount);
				if (status == true)
					System.out.println("deposited suceessfully");
				else
					System.out.println("User not found/Transaction failed!");
				break;

			case 3:

				System.out.println("Enter the email: ");
				email = sc.next();
				System.out.println("Enter the fund to withdraw");
				double withdraw = sc.nextInt();
				double amt = userDao.withdrawAmount(email, withdraw);
				if (amt == -1)
					System.out.println("No sufficient balance");
				else
					System.out.println("balance amount: " + amt);

				break;

			case 4:
				System.out.println("Enter the email: ");
				email = sc.next();
				userDao.displayUserDetails(email);
				break;
			case 5:
				System.out.println("Enter the email: ");
				email = sc.next();
				userDao.showBalance(email);
				break;


			}
			System.out.println("Do you want to continue?Enter any number to continue.Enter 0 to exit");
			val = sc.nextInt();

		} while (val != 0);
		sc.close();
		return;

	}

}
