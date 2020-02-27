package com.internousdev.rose.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.rose.dao.DestinationInfoDAO;
import com.opensymphony.xwork2.ActionSupport;

public class CreateDestinationCompleteAction extends ActionSupport implements SessionAware {

	private Map<String,Object>session;

	public String execute() throws SQLException{

		boolean loginFlg = Boolean.valueOf(String.valueOf(session.get("loginFlg")));
		if(loginFlg==false) {
			return "loginError";
		}

		String result=ERROR;

		DestinationInfoDAO destinationInfoDAO=new DestinationInfoDAO();

		int count=destinationInfoDAO.destinationInfoInsert(
				String.valueOf(session.get("userId")),
				String.valueOf(session.get("familyNameRe")),
				String.valueOf(session.get("firstNameRe")),
				String.valueOf(session.get("familyNameKanaRe")),
				String.valueOf(session.get("firstNameKanaRe")),
				String.valueOf(session.get("address")),
				String.valueOf(session.get("phoneNumber")),
				String.valueOf(session.get("mailAddress")));

		if(count>0) {
			result=SUCCESS;
		}

		session.remove("familyNameRe");
		session.remove("firstNameRe");
		session.remove("familyNameKanaRe");
		session.remove("firstNameKanaRe");
		session.remove("address");
		session.remove("phoneNumber");
		session.remove("mailAddress");

		return result;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}