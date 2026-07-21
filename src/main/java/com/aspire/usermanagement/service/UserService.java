package com.aspire.usermanagement.service;
import java.util.List;

import com.aspire.usermanagement.service.dto.UserRequestDTO;
import com.aspire.usermanagement.service.dto.UserResponseDTO;


public interface UserService {

	public Long insertUser(UserRequestDTO userRequestDTO);
	public UserResponseDTO getUser(Long userId);
	public List<UserResponseDTO> getUsers();
	public void updateUser(Long userId , UserRequestDTO userRequestDTO);
	public void deleteUser(Long userId);
}




