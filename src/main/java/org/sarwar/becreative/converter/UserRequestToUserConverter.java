package org.sarwar.becreative.converter;

import org.sarwar.becreative.entity.User;
import org.sarwar.becreative.model.UserRequest;
import org.springframework.core.convert.converter.Converter;

public class UserRequestToUserConverter implements Converter<UserRequest, User> {

	@Override
	public User convert(UserRequest userRequest) {
		User user = new User();
		if(userRequest.getUserId() != null) user.setUserId(userRequest.getUserId());
		if(userRequest.getMiddleName() != null && userRequest.getMiddleName().length() != 0) user.setMiddleName(userRequest.getMiddleName());
		if(userRequest.getZip() != null && userRequest.getZip().length() != 0) user.setZip(userRequest.getZip());
		user.setFirstName(userRequest.getFirstName());
		user.setLastName(userRequest.getLastName());
		user.setPhoneNumber(userRequest.getPhoneNumber());
		user.setAge(userRequest.getAge());
		user.setGender(userRequest.getGender());
		return user;
	}

}
