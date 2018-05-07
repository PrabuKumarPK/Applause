package com.applause.service;

import org.springframework.stereotype.Service;

import com.applause.dto.UserProfileDto;


public interface IUserProfileService {

	public UserProfileDto getUserServ(UserProfileDto userprofiledto);
	public boolean verifyUserLoginServ(String email,String pwd);
}
