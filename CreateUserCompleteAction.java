package com.internousdev.rose.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.rose.dao.UserInfoDAO;
import com.opensymphony.xwork2.ActionSupport;

public class CreateUserCompleteAction extends ActionSupport implements SessionAware{

	private Map<String,Object>session;

	public String execute() throws SQLException{

		String result=ERROR;

		UserInfoDAO userInfoDAO=new UserInfoDAO();

		int count=userInfoDAO.createUser(
				String.valueOf(session.get("familyName")),
				String.valueOf(session.get("firstName")),
				String.valueOf(session.get("familyNameKana")),
				String.valueOf(session.get("firstNameKana")),
				String.valueOf(session.get("sex")),
				String.valueOf(session.get("email")),
				String.valueOf(session.get("userIdForCreateUser")),
				String.valueOf(session.get("password")));

		if(count>0) {
			result=SUCCESS;
			session.put("createUserFlg","1");
		}

		session.remove("familyName");
		session.remove("firstName");
		session.remove("familyNameKana");
		session.remove("firstNameKana");
		session.remove("sex");
		session.remove("email");
		session.remove("password");

		return result;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}