package com.aspire.usermanagement.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.aspire.usermanagement.exception.UserNotFoundException;
import com.aspire.usermanagement.repository.UserEntityRepository;
import com.aspire.usermanagement.repostiory.entity.UserEntity;
import com.aspire.usermanagement.service.UserService;
import com.aspire.usermanagement.service.dto.UserRequestDTO;
import com.aspire.usermanagement.service.dto.UserResponseDTO;
import com.aspire.usermanagement.service.mapper.UserMapper;
@Service
public class UserServiceImpl implements UserService{
	private final UserMapper userMapper;
	private final UserEntityRepository userEntityRepository;

	public UserServiceImpl(UserMapper userMapper, UserEntityRepository userEntityRepository) {
		super();
		this.userMapper = userMapper;
		this.userEntityRepository = userEntityRepository;
	}

	@Override
	public Long insertUser(UserRequestDTO userRequestDTO) {
		UserEntity userEntity = userMapper.toEntity(userRequestDTO);
		if (userEntity != null) {
			UserEntity savedUserEntity = userEntityRepository.save(userEntity);
			return savedUserEntity.getUserId();
		}
		return null;
	}

	@Override
	public UserResponseDTO getUser(Long userId) {
		Optional<UserEntity> optionalUser = userEntityRepository.findById(userId);
		if (optionalUser.isEmpty()) {
			throw new UserNotFoundException("User details are not found for given userid" + userId);

		}

		return userMapper.toDTO(optionalUser.get());
	}

	@Override
	public List<UserResponseDTO> getUsers() {
		List<UserResponseDTO> users = new ArrayList<>();
		List<UserEntity> usersList = userEntityRepository.findAll();
		if (usersList != null) {
			for (UserEntity userEntity : usersList) {
				users.add(userMapper.toDTO(userEntity));
			}
		}
		return users;
	}

	@Override
	public void updateUser(Long userId, UserRequestDTO userRequestDTO) {
		Optional<UserEntity> optionalUser = userEntityRepository.findById(userId);
		if (optionalUser.isPresent()) {
			UserEntity userEntity = userMapper.toEntity(userRequestDTO);
			userEntity.setUserId(userId);
			userEntityRepository.save(userEntity);
		} else {
			throw new UserNotFoundException("User details are not found for given userid" + userId);
		}

	}

	@Override
	public void deleteUser(Long userId) {
		Optional<UserEntity> optionalUser = userEntityRepository.findById(userId);
		if (optionalUser.isEmpty()) {
			throw new UserNotFoundException("User details are not found for given userid" + userId);

		}
		userEntityRepository.delete(optionalUser.get());

	}

}


