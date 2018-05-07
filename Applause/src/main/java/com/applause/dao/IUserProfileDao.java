package com.applause.dao;

import com.applause.dto.UserProfileDto;

public interface IUserProfileDao {
	public String newUserDao(UserProfileDto upd);
	public UserProfileDto getUserDao(UserProfileDto upd);
	public boolean userLogin(String email,String pwd);
}
