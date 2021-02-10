package com.omnirio.controller;

import com.omnirio.model.Account;
import com.omnirio.model.CustomResponse;
import com.omnirio.service.AccountsService;
import com.omnirio.util.LogUtil;
import com.omnirio.util.Utilities;
import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/omnirio")
public class AccountsController {

	private static Logger logger = LogUtil.getInstance();

	@Autowired
	private AccountsService mainService;

	@RequestMapping(value = "/account", method = RequestMethod.GET)
	public ResponseEntity<String> getAllAccounts() {

		CustomResponse customResponse = mainService.getAllAccounts();

		if (customResponse.getSuccess()) {
			return ResponseEntity.ok()
					.header("message", customResponse.getMessage())
					.body(customResponse.getInfoAsJson().toString());
		} else {
			return ResponseEntity.badRequest()
					.header("message", customResponse.getMessage())
					.body(customResponse.getMessage());
		}

	}

	@RequestMapping(value = "/account/{id}", method = RequestMethod.GET)
	public ResponseEntity<String> getAccount(@PathVariable("id") String id) {


		CustomResponse customResponse = mainService.getAccount(id);

		if (customResponse.getSuccess()) {
			return ResponseEntity.ok()
					.header("message", customResponse.getMessage())
					.body(customResponse.getInfoAsJson().toString());
		} else {
			return ResponseEntity.badRequest()
					.header("message", customResponse.getMessage())
					.body(customResponse.getMessage());
		}

	}

	@PostMapping("/account")
	@ResponseBody
	public ResponseEntity<String> createAccount(@RequestBody String body) throws Exception {

		JSONObject jsonObject = new JSONObject(body.trim());
		CustomResponse customResponse = mainService.createAccount(Utilities.jsonToAccount(jsonObject));
		if (customResponse.getSuccess()) {
			return ResponseEntity.ok()
					.header("message", customResponse.getMessage())
					.body(customResponse.getInfoAsJson().toString());
		} else {
			return ResponseEntity.badRequest()
					.header("message", customResponse.getMessage())
					.body(customResponse.getMessage());
		}
	}

	// below are going to be tokenized services, means they will not work without a valid token
	@PutMapping("/account")
	@ResponseBody
	public ResponseEntity<String> updateAccount(@RequestBody String body) throws Exception {

		JSONObject jsonObject = new JSONObject(body.trim());
		CustomResponse customResponse = mainService.updateAccount(Utilities.jsonToAccount(jsonObject));
		if (customResponse.getSuccess()) {
			return ResponseEntity.ok()
					.header("message", customResponse.getMessage())
					.body(customResponse.getInfoAsJson().toString());
		} else {
			return ResponseEntity.badRequest()
					.header("message", customResponse.getMessage())
					.body(customResponse.getMessage());
		}
	}

	// below are going to be tokenized services, means they will not work without a valid token
	@RequestMapping(value = "/account/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteAccount(@PathVariable("id") String id) {

		CustomResponse customResponse = mainService.deleteAccount(id);

		if (customResponse.getSuccess()) {
			return ResponseEntity.ok()
					.header("message", customResponse.getMessage())
					.body(customResponse.getInfoAsJson().toString());
		} else {
			return ResponseEntity.badRequest()
					.header("message", customResponse.getMessage())
					.body(customResponse.getMessage());
		}

	}
}
