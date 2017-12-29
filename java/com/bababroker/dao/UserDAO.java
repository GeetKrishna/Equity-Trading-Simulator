package com.bababroker.dao;

import java.util.List;

import com.bababroker.model.Block;
import com.bababroker.model.UserT;

public interface UserDAO extends GenericDAO<UserT, String> {

	void saveU(UserT user);
	void updateU(UserT user);
	UserT findByIdU(String id);
	List<UserT> findAllU();
	void deleteU(UserT user);
}
