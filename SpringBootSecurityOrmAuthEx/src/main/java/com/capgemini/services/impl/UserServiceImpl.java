package com.capgemini.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.model.User;
import com.capgemini.repo.UserRepository;
import com.capgemini.services.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserRepository repo;
	
	public Integer save(User user) {
		return repo.save(user).getUid() ;
	}

}
