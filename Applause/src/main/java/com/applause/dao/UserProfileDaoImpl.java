package com.applause.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.applause.dto.UserProfileDto;
import com.applause.util.SFactory;

public class UserProfileDaoImpl implements IUserProfileDao {

	public SessionFactory sessionfactory = null;
	public Session session = null;
	public Transaction transaction = null;
	String result = null;
	boolean valid_user = false;

	public String newUserDao(UserProfileDto upd) {

		try {
			if (upd != null) {
				sessionfactory = SFactory.getSessionFactory();
				session = sessionfactory.getCurrentSession();
				System.out.println("Session:" + session.hashCode());
				transaction = session.beginTransaction();
				session.saveOrUpdate(upd);
				transaction.commit();
				System.out.println("transaction commited");
				// result=Integer.valueOf(upd.getUser_id());
				result = "Data inserted successfully";
				System.out.println("Result is::" + result);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				SFactory.closeSessionFactory();
			}
		}
		return result;
	}

	public UserProfileDto getUserDao(UserProfileDto upd) {
		try {
			sessionfactory = SFactory.getSessionFactory();
			session = sessionfactory.getCurrentSession();
			transaction = session.beginTransaction();
			upd = (UserProfileDto) session.get(UserProfileDto.class,
					upd.getUser_id());
			// result="Deleted Successfully";
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sessionfactory != null) {
				sessionfactory.close();
			}
		}
		return upd;
	}

	public boolean userLogin(String email, String pwd) {
		try
		{
			if((email!=null && !email.isEmpty())&&(pwd!=null && !pwd.isEmpty()))
			{
				sessionfactory=SFactory.getSessionFactory();
				session=sessionfactory.openSession();
				Query login_verfy_quey=session.createQuery("from UserProfileDto up where up.email=:email and up.password=:pwd");
				login_verfy_quey.setParameter("email", email);
				login_verfy_quey.setParameter("pwd", pwd);
				@SuppressWarnings("rawtypes")
				List l=login_verfy_quey.list();
				if(!l.isEmpty()&&l.size()>=1)
				{
					valid_user=true;
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if (sessionfactory != null) {
				sessionfactory.close();
			}
		}
		return valid_user;
	}

	public static void main(String[] args) {
		UserProfileDaoImpl upd = new UserProfileDaoImpl();
		UserProfileDto up = new UserProfileDto();
		/*System.out.println("------");

		up.setUser_name("yhnk");
		up.setAddress2("ahdkask");
		up.setAddress1("Unknown");
		up.setPassword("abc@123");*/
		//upd.newUserDao(up);
		// up.setUser_id(494562);
		//abc@mail.com----123
		 /* up.setUser_id(494562);
		  up=upd.getUserDao(up);
		  System.out.println(up.getEmail()+"----"+up.getPassword());*/
		Boolean res=upd.userLogin("abc@mail.com", "123");
		System.out.println(res);
	}

}
