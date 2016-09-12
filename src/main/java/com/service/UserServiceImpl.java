package com.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

import com.domain.User;

@Service
public class UserServiceImpl implements UserService{

	public static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@CachePut(value="users",key="123")
	@Override
	public User find(User user) {
			logger.info("db");
			return new User();
	   }
}
