package com.internousdev.rose.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class CreateDestinationAction extends ActionSupport implements SessionAware{

	private Map<String,Object> session;
	private String backFlg;

	public String execute() {

		//ログインしていなかった場合、ログインエラー画面へ
		boolean loginFlg = Boolean.valueOf(String.valueOf(session.get("loginFlg")));
		if(loginFlg == false) {
			return "loginError";
		}

		if(backFlg==null) {
			session.remove("familyNameRe");
			session.remove("firstNameRe");
			session.remove("familyNameKanaRe");
			session.remove("firstNameKanaRe");
			session.remove("address");
			session.remove("phoneNumber");
			session.remove("mailAddress");
		}

		return SUCCESS;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String getBackFlg() {
		return backFlg;
	}

	public void setBackFlg(String backFlg) {
		this.backFlg = backFlg;
	}
}
