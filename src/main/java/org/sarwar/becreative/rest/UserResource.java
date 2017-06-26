package org.sarwar.becreative.rest;

import java.util.Optional;
import java.util.UUID;

import org.sarwar.becreative.converter.UserToUserResponseConverter;
import org.sarwar.becreative.customexception.UserAlreadyExistException;
import org.sarwar.becreative.customexception.UserNotFoundException;
import org.sarwar.becreative.entity.User;
import org.sarwar.becreative.model.UserRequest;
import org.sarwar.becreative.model.UserResponse;
import org.sarwar.becreative.repository.PageableUserRepository;
import org.sarwar.becreative.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ResourceConstants.USER_MANAGEMENT_V1)
public class UserResource {

	@Autowired
	PageableUserRepository pageableUserRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	ConversionService conversionService;

	@RequestMapping(path = "/users", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Page<UserResponse> getUsers(Pageable pageable) {

		Page<User> users = pageableUserRepository.findAll(pageable);
		return users.map(new UserToUserResponseConverter());
	}

	@RequestMapping(path = "/users", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> createUser(@RequestBody UserRequest userRequest) {
		Optional<User> currentUser = userRepository.findByUserId(userRequest.getUserId());
		if (currentUser.isPresent()) {
			return new ResponseEntity<>(new UserAlreadyExistException(userRequest.getUserId().toString()),
					HttpStatus.CONFLICT);
		} else {
			User user = conversionService.convert(userRequest, User.class);
			userRepository.save(user);
			UserResponse userResponse = conversionService.convert(user, UserResponse.class);
			return new ResponseEntity<>(userResponse, HttpStatus.CREATED);
		}

	}

	@RequestMapping(path = "/users/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> updateUser(@PathVariable("id") UUID id, @RequestBody UserRequest userRequest) {
		Optional<User> currentUser = userRepository.findByUserId(id);
		if (currentUser.isPresent()) {
			User user = conversionService.convert(userRequest, User.class);
			userRepository.save(user);
			UserResponse userResponse = conversionService.convert(user, UserResponse.class);
			return new ResponseEntity<>(userResponse, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(new UserNotFoundException(id.toString()), HttpStatus.NOT_FOUND);
		}
	}

}
