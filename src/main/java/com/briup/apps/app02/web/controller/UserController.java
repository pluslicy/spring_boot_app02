package com.briup.apps.app02.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.briup.apps.app02.bean.User;
import com.briup.apps.app02.service.IUserService;
import com.fasterxml.jackson.annotation.JsonRawValue;

@RestController
@RequestMapping(path= {"/users"})
public class UserController {
	@Autowired
	private IUserService userService;
	
	@GetMapping(path= {"/findAll"})
	@JsonRawValue
	public List<User> findAll() {
		List<User> users = new ArrayList<>();
		try {
			users = userService.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return users;
	}
	
	@GetMapping(path= {"/findById"})
	@JsonRawValue
	public User findById(@RequestParam long id) {
		User user = null;
		try {
			user = userService.findById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	
	@PostMapping(path= {"/save"}, consumes= {"application/x-www-form-urlencoded"})
	public String save(@ModelAttribute User user) {
		try {
			userService.save(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "成功啦";
	}
}
