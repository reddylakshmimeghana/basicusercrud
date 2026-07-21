package com.aspire.usermanagement.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aspire.usermanagement.service.UserService;
import com.aspire.usermanagement.service.dto.CommonResponseDTO;
import com.aspire.usermanagement.service.dto.UserResponseDTO;
import com.aspire.usermanagement.service.dto.UserRequestDTO;
@RestController
@RequestMapping("/api/user")
public class UserController {
	private final UserService userService;
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	@PostMapping("/insertuser")
	public ResponseEntity<CommonResponseDTO<Long>> insertUser(@RequestBody UserRequestDTO userRequestDto) {
		Long userId = userService.insertUser(userRequestDto);
		CommonResponseDTO<Long> commonResponseDTO = new CommonResponseDTO<>(); 
		commonResponseDTO.setData(userId);
		commonResponseDTO.setStatus(HttpStatus.CREATED.value());
		commonResponseDTO.setMessage("User details are sucessfully inserted");
		commonResponseDTO.setTimeStamp(LocalDateTime.now());
		
		return new ResponseEntity<>(commonResponseDTO, HttpStatus.CREATED);
		
	}
	
	@GetMapping("/users")
	public ResponseEntity<CommonResponseDTO<List<UserResponseDTO>>> getUsers() {
		
		List<UserResponseDTO> users = userService.getUsers();
		CommonResponseDTO<List<UserResponseDTO>> commonResponseDTO = new CommonResponseDTO<>();
		commonResponseDTO.setData(users);
		commonResponseDTO.setStatus(HttpStatus.OK.value());
		commonResponseDTO.setMessage("User details are sucessfully fetched");
		commonResponseDTO.setTimeStamp(LocalDateTime.now());
		return new ResponseEntity<> (commonResponseDTO, HttpStatus.OK);
	}
	@GetMapping("/{userId}")
	public ResponseEntity<CommonResponseDTO<UserResponseDTO>> getUser(@PathVariable("userId") Long userId) {
		UserResponseDTO userResponseDTO = userService.getUser(userId);
		CommonResponseDTO<UserResponseDTO> commonResponseDTO = new CommonResponseDTO<>();
		commonResponseDTO.setData(userResponseDTO);
		commonResponseDTO.setStatus(HttpStatus.OK.value());
		commonResponseDTO.setMessage("User details are sucessfully fetched based on userId");
		commonResponseDTO.setTimeStamp(LocalDateTime.now());
		return new ResponseEntity<>(commonResponseDTO, HttpStatus.OK);
		
		
	}
	@PutMapping("/updateuser/{userId}")
	public ResponseEntity<Void> updateUser(@PathVariable("userId") Long userId, @RequestBody UserRequestDTO userRequestDTO) {
		
		userService.updateUser(userId, userRequestDTO);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT );
		
	}
	
	@DeleteMapping("/deleteuser")
	public ResponseEntity<Void> deleteUser(@RequestParam("userId") Long userId){
		
		userService.deleteUser(userId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT );
	}

}
	
		
	
