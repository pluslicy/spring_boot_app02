package com.briup.apps.app02.bean;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 用户类
 * */
@ApiModel(value="user",description="用户类")
public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(value="用户ID")
	private Long id;
	@ApiModelProperty(value="用户姓名", required=true)
	private String name;
	@ApiModelProperty(value="用户性别", required=true)
	private String gender;
	@ApiModelProperty(value="出生日期",required=true)
	private String birth;
	public User() {
		
	}
	
	public User(Long id, String name, String gender, String birth) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.birth = birth;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", gender=" + gender + ", birth=" + birth + "]";
	}
}
