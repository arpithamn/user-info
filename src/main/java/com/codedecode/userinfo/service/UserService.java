package com.codedecode.userinfo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.codedecode.userinfo.dto.UserDTO;
import com.codedecode.userinfo.entity.User;
import com.codedecode.userinfo.mapper.UserMapper;
import com.codedecode.userinfo.repo.UserRepo;
import com.google.common.base.Optional;

@Service
public class UserService {
	
	@Autowired
	UserRepo userRepo;

	public UserDTO addUserInDb(UserDTO userDTO) {
		    System.out.println("I am here4" +userDTO);
		    User savedUser = userRepo.save(UserMapper.INSTANCE.mapUserDTOToUser(userDTO));
		    return UserMapper.INSTANCE.mapUserToUserDTO(savedUser);

		    
	}
	 public ResponseEntity<UserDTO> fetchUserDetailsById(Integer userId) {
         java.util.Optional<User> fetchedUser =  userRepo.findById(userId);
         if(fetchedUser.isPresent())
             return new ResponseEntity<>(UserMapper.INSTANCE.mapUserToUserDTO(fetchedUser.get()), HttpStatus.OK);
         return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

    }
	

	

}
