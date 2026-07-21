package com.aspire.usermanagement.service.mapper;

import org.springframework.stereotype.Component;

import com.aspire.usermanagement.exception.BadRequestException;
import com.aspire.usermanagement.exception.CustomApplicationException;
import com.aspire.usermanagement.repostiory.entity.UserEntity;
import com.aspire.usermanagement.service.dto.UserRequestDTO;
import com.aspire.usermanagement.service.dto.UserResponseDTO;
import com.aspire.usermanagement.service.util.DateUtil;

@Component
public class UserMapper {
	public UserEntity toEntity(UserRequestDTO userRequestDTO) {
		
		if(userRequestDTO == null ) {
			throw new BadRequestException("userRequestdto must be required");
		}
		
		UserEntity userEntity = new UserEntity();
		userEntity.setFirstName(userRequestDTO.getFirstName());
		userEntity.setLastName(userRequestDTO.getLastName());
		userEntity.setEmailId(userRequestDTO.getEmailId());
		userEntity.setPassWord(userRequestDTO.getPassword());
		userEntity.setMobileNumber(userRequestDTO.getMobileNumber());
		userEntity.setDataofBirth(DateUtil.toLocalDate(userRequestDTO.getDateOfBirth()));
		
		return userEntity;
	}
	
	public UserResponseDTO toDTO(UserEntity userEntity) {
		
		if(userEntity == null) {
			throw new CustomApplicationException("user entity must be required");
		}
		
		UserResponseDTO userResponseDTO = new UserResponseDTO();
		userResponseDTO.setFirstName(userEntity.getFirstName());
		userResponseDTO.setLastName(userEntity.getLastName());
		userResponseDTO.setEmailId(userEntity.getEmailId());
		userResponseDTO.setPassword(userEntity.getPassWord());
		userResponseDTO.setMobileNumber(userEntity.getMobileNumber());
		userResponseDTO.setDateOfBirth(DateUtil.toString(userEntity.getDataofBirth()));
		
		return userResponseDTO; 
	}


}
