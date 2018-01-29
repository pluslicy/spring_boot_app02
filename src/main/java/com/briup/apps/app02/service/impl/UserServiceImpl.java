package com.briup.apps.app02.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.apps.app02.bean.User;
import com.briup.apps.app02.dao.UserMapper;
import com.briup.apps.app02.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public List<User> findAll() throws Exception {
		return userMapper.findAll();
	}

	@Override
	public User findById(long id) throws Exception {
		return userMapper.findById(id);
	}

	@Override
	public void save(User user) throws Exception {
		userMapper.save(user);
	}

}
