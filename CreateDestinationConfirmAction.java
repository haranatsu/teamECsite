package com.internousdev.rose.action;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.rose.util.InputChecker;
import com.opensymphony.xwork2.ActionSupport;

public class CreateDestinationConfirmAction extends ActionSupport implements SessionAware{

	private String familyNameRe;
	private String firstNameRe;
	private String familyNameKanaRe;
	private String firstNameKanaRe;
	private String address;
	private String phoneNumber;
	private String mailAddress;
	private Map<String,Object>session;

	private List<String> familyNameErrorMessageList;
	private List<String> firstNameErrorMessageList;
	private List<String> familyNameKanaErrorMessageList;
	private List<String> firstNameKanaErrorMessageList;
	private List<String> addressErrorMessageList;
	private List<String> phoneNumberErrorMessageList;
	private List<String> mailAddressErrorMessageList;
	private List<String> passCheck;

	public String execute(){
		boolean loginFlg = Boolean.valueOf(String.valueOf(session.get("loginFlg")));
		if(loginFlg==false) {
			return "loginError";
		}

		String result=ERROR;

		//住所にスペースが入力されている場合は@@@を代入
		String tempAddress=null;
		if(StringUtils.isBlank(address) && !"".equals(address)){
			tempAddress="@@@";
		}else {
			tempAddress=address;
		}

		session.put("familyNameRe",familyNameRe);
		session.put("firstNameRe",firstNameRe);
		session.put("familyNameKanaRe",familyNameKanaRe);
		session.put("firstNameKanaRe",firstNameKanaRe);
		session.put("address",address);
		session.put("phoneNumber",phoneNumber);
		session.put("mailAddress",mailAddress);

		InputChecker inputChecker = new InputChecker();

		familyNameErrorMessageList = inputChecker.doCheck("姓",familyNameRe,1,16,true,true,true,false,true,false);
		firstNameErrorMessageList = inputChecker.doCheck("名",firstNameRe,1,16,true,true,true,false,true,false);
		familyNameKanaErrorMessageList = inputChecker.doCheck("姓ふりがな",familyNameKanaRe,1,16,false,false,true,false,false,false);
		firstNameKanaErrorMessageList = inputChecker.doCheck("名ふりがな",firstNameKanaRe,1,16,false,false,true,false,false,false);
		addressErrorMessageList = inputChecker.doCheck("住所",tempAddress,10,50,true,true,true,true,true,true);
		phoneNumberErrorMessageList = inputChecker.doCheck("電話番号",phoneNumber,10,13,false,false,false,true,false,false);
		passCheck=inputChecker.doCheckForEmail(mailAddress);

		//ひとつでもエラーメッセージリストがあったらエラーを返す
		if (familyNameErrorMessageList.size() > 0
				|| firstNameErrorMessageList.size() > 0
				|| familyNameKanaErrorMessageList.size() > 0
				|| firstNameKanaErrorMessageList.size() > 0
				|| addressErrorMessageList.size() > 0
				|| phoneNumberErrorMessageList.size() > 0
				|| passCheck.size() > 0) {
			result = ERROR;

		} else {
			result = SUCCESS;
		}
		return result;
	}

	public List<String> getFamilyNameErrorMessageList() {
		return familyNameErrorMessageList;
	}

	public void setFamilyNameErrorMessageList(List<String> familyNameErrorMessageList) {
		this.familyNameErrorMessageList = familyNameErrorMessageList;
	}

	public List<String> getFirstNameErrorMessageList() {
		return firstNameErrorMessageList;
	}

	public void setFirstNameErrorMessageList(List<String> firstNameErrorMessageList) {
		this.firstNameErrorMessageList = firstNameErrorMessageList;
	}

	public List<String> getFamilyNameKanaErrorMessageList() {
		return familyNameKanaErrorMessageList;
	}

	public void setFamilyNameKanaErrorMessageList(List<String> familyNameKanaErrorMessageList) {
		this.familyNameKanaErrorMessageList = familyNameKanaErrorMessageList;
	}

	public List<String> getFirstNameKanaErrorMessageList() {
		return firstNameKanaErrorMessageList;
	}

	public void setFirstNameKanaErrorMessageList(List<String> firstNameKanaErrorMessageList) {
		this.firstNameKanaErrorMessageList = firstNameKanaErrorMessageList;
	}

	public List<String> getAddressErrorMessageList() {
		return addressErrorMessageList;
	}

	public void setAddressErrorMessageList(List<String> addressErrorMessageList) {
		this.addressErrorMessageList = addressErrorMessageList;
	}

	public List<String> getPhoneNumberErrorMessageList() {
		return phoneNumberErrorMessageList;
	}

	public void setPhoneNumberErrorMessageList(List<String> phoneNumberErrorMessageList) {
		this.phoneNumberErrorMessageList = phoneNumberErrorMessageList;
	}

	public List<String> getMailAddressErrorMessageList() {
		return mailAddressErrorMessageList;
	}

	public void setMailAddressErrorMessageList(List<String> mailAddressErrorMessageList) {
		this.mailAddressErrorMessageList = mailAddressErrorMessageList;
	}

	public String getFamilyNameRe() {
		return familyNameRe;
	}

	public void setFamilyNameRe(String familyNameRe) {
		this.familyNameRe = familyNameRe;
	}

	public String getFirstNameRe() {
		return firstNameRe;
	}

	public void setFirstNameRe(String firstNameRe) {
		this.firstNameRe = firstNameRe;
	}

	public String getFamilyNameKanaRe() {
		return familyNameKanaRe;
	}

	public void setFamilyNameKanaRe(String familyNameKanaRe) {
		this.familyNameKanaRe = familyNameKanaRe;
	}

	public String getFirstNameKanaRe() {
		return firstNameKanaRe;
	}

	public void setFirstNameKanaRe(String firstNameKanaRe) {
		this.firstNameKanaRe = firstNameKanaRe;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getMailAddress() {
		return mailAddress;
	}

	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public List<String> getPassCheck() {
		return passCheck;
	}

	public void setPassCheck(List<String> passCheck) {
		this.passCheck = passCheck;
	}
}
