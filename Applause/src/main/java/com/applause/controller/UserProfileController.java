package com.applause.controller;


import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.applause.dto.UserProfileDto;
import com.applause.service.UserProfileServiceImpl;

@Controller
public class UserProfileController {
	@Autowired
	UserProfileServiceImpl userprofileservimpl;
	@Autowired
	UserProfileDto userForm; 
	//emp emp;
	@RequestMapping(value="/Home", method = RequestMethod.GET)
	public String Home(Map<String, Object> model)
	{
		try
		{
			//UserProfileDto userForm = new UserProfileDto();    
	        model.put("userForm", userForm);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return "Welcome";		
	}
	
	@RequestMapping(value = "/newEmployee", method = RequestMethod.POST)
	public ModelAndView newEmployee(@ModelAttribute("userForm") UserProfileDto up,Map<String, Object> model) {
		System.out.println("User Form::"+up.getEmail());
		ModelAndView modelAndView=null;
		try
		{
			if(up!=null)
			{
				modelAndView=new ModelAndView("newEmployee");
				UserProfileDto udo=userprofileservimpl.newUserServ(up);
				System.out.println(udo+"udo");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return modelAndView;
		
	}
	@RequestMapping(value="/userLogin",method=RequestMethod.POST)
	public ModelAndView userLogin(@ModelAttribute("userForm") UserProfileDto up,Map<String, Object> model)
	{
		String email=up.getEmail();
		String pwd=up.getPassword();
		System.out.println("User Form::"+up.getEmail());
		ModelAndView modelAndView=null;
		try
		{
			if(up!=null)
			{
				modelAndView=new ModelAndView("newEmployee");
				Boolean res=userprofileservimpl.verifyUserLoginServ(email, pwd);
				System.out.println(res);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return modelAndView;
		
	}

	
	
}
