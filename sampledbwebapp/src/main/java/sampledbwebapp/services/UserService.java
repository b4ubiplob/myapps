package sampledbwebapp.services;

import java.util.ArrayList;
import java.util.List;

import sampledbwebapp.dao.UserDao;
import sampledbwebapp.entities.TUser;
import sampledbwebapp.tos.UserTO;

public class UserService {
	
	private UserDao userDao;
	
	public UserService() {
		userDao = new UserDao();
	}
	
	public List<UserTO> getAllUsers() {
		List<UserTO> userTOs = new ArrayList<>();
		List<TUser> tUsers = userDao.getAllUsers();
		for (TUser tUser : tUsers) {
			
			userTOs.add(getUserTO(tUser));
		}
		return userTOs;
	}
	
	private UserTO getUserTO(TUser tUser) {
		UserTO userTO = new UserTO();
		userTO.setId(tUser.getId());
		userTO.setUsername(tUser.getUsername());
		userTO.setCreatedDate(tUser.getCreatedOn());
		return userTO;
	}
	
	public UserTO createUser(UserTO userTO) {
		TUser tUser = new TUser();
		tUser.setUsername(userTO.getUsername());
		tUser.setPassword(userTO.getPassword());
		TUser savedTUser = userDao.createUser(tUser);
		return getUserTO(savedTUser);
	}

}
