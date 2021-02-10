package com.omnirio.controller;

import com.omnirio.model.CustomResponse;
import com.omnirio.service.UserService;
import com.omnirio.util.LogUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/omnirio")
public class UserController {

	private static Logger logger = LogUtil.getInstance();

	@Autowired
	private UserService mainService;

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public ResponseEntity<String> getAllUsers() {

		CustomResponse customResponse = mainService.getAllUsers();

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

	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	public ResponseEntity<String> testJson(@PathVariable("id") String id) {


		CustomResponse customResponse = mainService.getAllUsers();

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
