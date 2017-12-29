package com.bababroker.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bababroker.dao.UserDAO;
import com.bababroker.model.UserT;


@Component
public class UserServices {

	@Autowired
	private UserDAO userdao;
	public boolean validateUser(UserT user) {

		Boolean flag = null;
		UserT fetchedUser = userdao.findByIdU(user.getUsername());

		if (fetchedUser != null)
			if (user.getPassword().equals(fetchedUser.getPassword()))
				return true;
			else
				return false;
		else
			return false;

	}
}
