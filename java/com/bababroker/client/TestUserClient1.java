package com.bababroker.client;

import java.math.BigDecimal;
import java.util.List;

import com.bababroker.dao.UserDAO;
import com.bababroker.dao.UserDAOImpl;
import com.bababroker.model.UserT;

public class TestUserClient1 {

	public static void main(String[] args) {
		
		
		//UserDAO<UserT, String> userDAO = new UserDAOImpl<UserT, String>(JPATemplate.getEntityManager(), UserT.class);

		//Add operations

//		userDAO.save(new UserT("Nick", "nickjomaffa@gmail.com", new BigDecimal(1), "bulb"));
//		//userDAO.save(new UserT("Mike1", "goon1", "mike@mike.com1", true));
//
//		//userDAO.save(new UserT("Nick", "nickjomaffa@gmail.com", new BigDecimal(1), "bulb"));
//
////		customerDAO.add(new JPACustomer("Michael Phelps", new Date()));
////		customerDAO.add(new JPACustomer("Jennifer Love Hewitt", new Date(86, 9, 5)));
////		customerDAO.add(new JPACustomer("Lou Vega", new Date(56, 3, 16)));
////		customerDAO.add(new JPACustomer("Samantha Carey", new Date(92, 7, 22)));
//		
//		//Delete operations
////		customerDAO.delete(5);
////		customerDAO.delete(6);
////		customerDAO.delete(7);
////		customerDAO.delete(8);
//		
//		//Find operations
//		//System.out.println(customerDAO.find(1));
//		List<UserT> list =  userDAO.findAll();
//		for (UserT c : list){
//			System.out.println(c);
//		}

	}

}
