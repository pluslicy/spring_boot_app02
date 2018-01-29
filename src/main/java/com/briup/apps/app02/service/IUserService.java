package com.briup.apps.app02.service;

import java.util.List;

import com.briup.apps.app02.bean.User;


public interface IUserService {
	List<User> findAll() throws Exception;
	
	User findById(long id) throws Exception;
	
	void save(User user) throws Exception;
}
