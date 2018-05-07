package com.applause.service;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import com.applause.dao.UserProfileDaoImpl;
import com.applause.dto.UserProfileDto;

@Service
public class UserProfileServiceImpl implements IUserProfileService {
	UserProfileDaoImpl userprofiledaoimpl;

	public void setUserprofiledaoimpl(UserProfileDaoImpl userprofiledaoimpl) {
		this.userprofiledaoimpl = userprofiledaoimpl;
	}

	public UserProfileDto newUserServ(UserProfileDto userprofiledto) {
		try {
			if (userprofiledto != null) {

				String result = userprofiledaoimpl.newUserDao(userprofiledto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userprofiledto;
	}

	/*
	 * public UserProfileDto getUserServ(UserProfileDto userprofiledto) { try {
	 * if (userprofiledto != null) { ApplicationContext factory=new
	 * ClassPathXmlApplicationContext(configLocation)
	 * 
	 * @SuppressWarnings("deprecation")
	 * 
	 * userprofiledto = userprofiledaoimpl.getUserDao(userprofiledto);
	 * System.out.println(userprofiledto.getUser_name()); } } catch (Exception
	 * e) { e.printStackTrace(); } return userprofiledto; }
	 */
	public boolean verifyUserLoginServ(String email, String pwd) {
		boolean login_status = false;
		try
		{
			if((email!=null && !email.isEmpty())&&(pwd!=null && !pwd.isEmpty()))
			{
				login_status=userprofiledaoimpl.userLogin(email, pwd);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return login_status;
	}

	public static void main(String[] args) {
		UserProfileServiceImpl s = new UserProfileServiceImpl();
		UserProfileDto d = new UserProfileDto();
		d.setUser_id(494562);
		s.getUserServ(d);
	}

	public UserProfileDto getUserServ(UserProfileDto userprofiledto) {
		// TODO Auto-generated method stub
		return null;
	}

}
