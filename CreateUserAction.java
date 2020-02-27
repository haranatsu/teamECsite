package com.internousdev.rose.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class CreateUserAction extends ActionSupport implements SessionAware {

	private Map<String, Object> session;
	private String backFlg;

	public String execute() {
		if(backFlg==null) {
			session.remove("familyName");
			session.remove("firstName");
			session.remove("familyNameKana");
			session.remove("firstNameKana");
			session.remove("sex");
			session.remove("email");
			session.remove("password");
			session.remove("userId");
		}
		return SUCCESS;
	}

	public String getBackFlg() {
		return backFlg;
	}
	public void setBackFlg(String backFlg) {
		this.backFlg = backFlg;
	}
	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;


	}
}
