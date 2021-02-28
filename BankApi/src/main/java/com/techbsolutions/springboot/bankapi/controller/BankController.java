package com.techbsolutions.springboot.bankapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.techbsolutions.springboot.bankapi.dao.BankTransactionDao;
import com.techbsolutions.springboot.bankapi.model.UserModel;

@RestController
@RequestMapping("/bankapi/user")
public class BankController {

	@Autowired
	BankTransactionDao transactionDao;

	@RequestMapping(path = "/{email}", method = RequestMethod.GET)
	public ResponseEntity<UserModel> getDetails(@PathVariable("email") String email) throws Exception {
		UserModel user = transactionDao.displayUserDetails(email);

		if (user == null) {
			return new ResponseEntity<UserModel>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<UserModel>(user, HttpStatus.OK);
		}
	}

	@RequestMapping(path = "/createaccount", method = RequestMethod.POST)

	public ResponseEntity<UserModel> createAccount(@RequestBody UserModel user) throws Exception {

		if (user == null) {
			return new ResponseEntity<UserModel>(HttpStatus.BAD_REQUEST);
		}
		UserModel saveduser = transactionDao.createAccount(user);
		return new ResponseEntity<UserModel>(saveduser, HttpStatus.CREATED);

	}

	@RequestMapping(path = "/{emailid}/deposit/{balance}", method = RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<UserModel> depositFund(@PathVariable("emailid") String id,
			@PathVariable("balance") Double balance) {
		Double amount = transactionDao.depositFund(id, balance);
		if (amount == -1) {
			return new ResponseEntity<UserModel>(HttpStatus.NOT_MODIFIED);
		} else {
			return new ResponseEntity<UserModel>(HttpStatus.NO_CONTENT);
		}
	}

	@RequestMapping(path = "/{emailid}/withdraw/{balance}", method = RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<UserModel> withdrawFund(@PathVariable("emailid") String id,
			@PathVariable("balance") Double balance) {
		Double amount = transactionDao.withdrawAmount(id, balance);
		if (amount == -1) {
			return new ResponseEntity<UserModel>(HttpStatus.NOT_MODIFIED);
		} else {
			return new ResponseEntity<UserModel>(HttpStatus.NO_CONTENT);
		}

	}

}
