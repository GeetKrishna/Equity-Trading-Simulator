package com.bababroker.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bababroker.model.Block;
import com.bababroker.model.UserT;
@Repository
public class UserDAOImpl extends GenericDAOImpl<UserT, String> implements UserDAO{

	public UserDAOImpl() {
		super(UserT.class);
		// TODO Auto-generated constructor stub
	}

	@Transactional
	public void saveU(UserT user) {
		super.save(user);
		
	}

	@Transactional
	public void updateU(UserT user) {
		super.update(user);
		
	}


	@Transactional
	public List<UserT> findAllU() {
		// TODO Auto-generated method stub
		return super.findAll();
	}

	@Transactional
	public void deleteU(UserT user) {
		super.delete(user);
		
	}
	@Transactional
	public UserT findByIdU(String id) {
		// TODO Auto-generated method stub
		return super.findById(id);
	}
}
