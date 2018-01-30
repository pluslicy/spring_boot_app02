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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(value="用户相关API")
@RestController
@RequestMapping(path= {"/users"})
public class UserController {
	@Autowired
	private IUserService userService;
	
	@ApiOperation(value="查询所有用户",notes="将所有用户信息都查询出来")
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
	
	@ApiOperation(value="通过ID查询用户")
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
	
	@ApiOperation(value="保存用户信息")
	@PostMapping(path= {"/save"}, consumes= {"application/x-www-form-urlencoded"})
	public String save(@ApiParam(value="user", required=true) @ModelAttribute User user) {
		try {
			userService.save(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "成功啦";
	}
}
