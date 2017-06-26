package org.sarwar.becreative.converter;

import org.sarwar.becreative.entity.User;
import org.sarwar.becreative.model.UserResponse;
import org.springframework.core.convert.converter.Converter;
public class UserToUserResponseConverter implements Converter<User, UserResponse>{

	@Override
	public UserResponse convert(User user) {
		UserResponse userResponse = new UserResponse();
		if(user.getUserId() != null) userResponse.setUserId(user.getUserId());
		if(user.getMiddleName() != null && user.getMiddleName().length() != 0) userResponse.setMiddleName(user.getMiddleName());
		if(user.getZip() != null && user.getZip().length() != 0) userResponse.setZip(user.getZip());
		userResponse.setFirstName(user.getFirstName());
		userResponse.setLastName(user.getLastName());
		userResponse.setPhoneNumber(user.getPhoneNumber());
		userResponse.setAge(user.getAge());
		userResponse.setGender(user.getGender());
		return userResponse;
	}

}
