package com.saurabh.finance.controller;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saurabh.finance.dtos.UserDTO;
import com.saurabh.finance.service.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("api/v1/user")
@RequiredArgsConstructor
public class UserController {
	
	private final UserService service;
	
	@GetMapping(value = "/{identification}")
	public ResponseEntity<UserDTO> readUser(@PathVariable("identification") String identification) {
		return ResponseEntity.ok(service.readUser(identification));
	}
	
	@GetMapping
	public ResponseEntity<List<UserDTO>> readUser(Pageable pageable) {
		return ResponseEntity.ok(service.readUsers(pageable));
	}
	

}
