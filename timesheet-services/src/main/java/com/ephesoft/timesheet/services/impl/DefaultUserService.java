package com.ephesoft.timesheet.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ephesoft.timesheet.core.ApplicationException;
import com.ephesoft.timesheet.core.model.ResponseCode;
import com.ephesoft.timesheet.core.model.User;
import com.ephesoft.timesheet.core.model.dao.UserDao;
import com.ephesoft.timesheet.services.UserService;

@Service
public class DefaultUserService implements UserService {
	
	@Autowired UserDao userDao;

	@Override
	public User getUserById(long id) {
		return userDao.findOne(User.class, id);
	}

	@Override
	public User validateUser(String username, String password) throws ApplicationException {
		User user = userDao.validateUser(username, password);
		if (user == null) {
			throw new ApplicationException(ResponseCode.UNAUTHORISED);
		}
		return user;
	}

}
