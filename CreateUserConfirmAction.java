package com.internousdev.rose.action;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.rose.dao.UserInfoDAO;
import com.internousdev.rose.util.CommonUtility;
import com.internousdev.rose.util.InputChecker;
import com.opensymphony.xwork2.ActionSupport;

public class CreateUserConfirmAction extends ActionSupport implements SessionAware {

	private String familyName;
	private String firstName;
	private String familyNameKana;
	private String firstNameKana;
	private String sex;
	private String email;
	private String userId;
	private String password;
	private Map<String,Object>session;
	private String errorMessage;

	private List<String> familyNameErrorMessageList;
	private List<String> firstNameErrorMessageList;
	private List<String> familyNameKanaErrorMessageList;
	private List<String> firstNameKanaErrorMessageList;
	private List<String> emailErrorMessageList;
	private List<String> userIdErrorMessageList;
	private List<String> passwordErrorMessageList;

	private Boolean idResult;

	private String setExistsErrorMessage;


	public String execute() throws SQLException {

		String result=ERROR;

		//再入力時に表示したい値をsessionに格納
		session.put("familyName",familyName);
		session.put("firstName",firstName);
		session.put("familyNameKana",familyNameKana);
		session.put("firstNameKana",firstNameKana);
		session.put("sex",sex);
		session.put("email",email);
		session.put("userIdForCreateUser",userId);
		session.put("password",password);

		setSex(String.valueOf(session.get("sex")));

		InputChecker inputChecker=new InputChecker();

		familyNameErrorMessageList = inputChecker.doCheck("姓",familyName,1,16,true,true,true,false,true,false);
		firstNameErrorMessageList = inputChecker.doCheck("名",firstName,1,16,true,true,true,false,true,false);
		familyNameKanaErrorMessageList = inputChecker.doCheck("姓ふりがな",familyNameKana,1,16,false,false,true,false,false,false);
		firstNameKanaErrorMessageList = inputChecker.doCheck("名ふりがな",firstNameKana,1,16,false,false,true,false,false,false);
		emailErrorMessageList = inputChecker.doCheckForEmail(email);
		userIdErrorMessageList = inputChecker.doCheck("ユーザーID",userId,1,8,true,false,false,true,false,false);
		passwordErrorMessageList = inputChecker.doCheck("パスワード",password,1,16,true,false,false,true,false,false);

		//エラーメッセージリストがひとつでも存在したら、エラーのまま返す
		if(familyNameErrorMessageList.size()>0
				|| firstNameErrorMessageList.size()>0
				|| familyNameKanaErrorMessageList.size()>0
				|| firstNameKanaErrorMessageList.size()>0
				|| emailErrorMessageList.size()>0
				|| userIdErrorMessageList.size()>0
				||passwordErrorMessageList.size()>0) {
			return result;
		}

			UserInfoDAO userInfoDAO=new UserInfoDAO();
			//ユーザーIDの存在確認 ユーザーIDが存在しない場合、2文字目から16文字目までが*で隠されたパスワード設定する
			if(userInfoDAO.idCount(userId)) {
				setExistsErrorMessage="使用できないユーザーIDです。";
			}else {
				CommonUtility com=new CommonUtility();
				password=com.concealPassword(password);//実行

				result=SUCCESS;
			}
			return result;
		}

	public String getFamilyName() {
		return familyName;
	}
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getFamilyNameKana1() {
		return familyNameKana;
	}
	public void setFamilyNameKana1(String familyNameKana) {
		this.familyNameKana = familyNameKana;
	}

	public String getFirstNameKana() {
		return firstNameKana;
	}
	public void setFirstNameKana(String firstNameKana) {
		this.firstNameKana = firstNameKana;
	}

	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getFamilyNameKana() {
		return familyNameKana;
	}

	public void setFamilyNameKana(String familyNameKana) {
		this.familyNameKana = familyNameKana;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
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

	public List<String> getEmailErrorMessageList() {
		return emailErrorMessageList;
	}

	public void setEmailErrorMessageList(List<String> emailErrorMessageList) {
		this.emailErrorMessageList = emailErrorMessageList;
	}

	public List<String> getUserIdErrorMessageList() {
		return userIdErrorMessageList;
	}

	public void setUserIdErrorMessageList(List<String> userIdErrorMessageList) {
		this.userIdErrorMessageList = userIdErrorMessageList;
	}

	public List<String> getPasswordErrorMessageList() {
		return passwordErrorMessageList;
	}

	public void setPasswordErrorMessageList(List<String> passwordErrorMessageList) {
		this.passwordErrorMessageList = passwordErrorMessageList;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public Boolean getIdResult() {
		return idResult;
	}

	public void setIdResult(Boolean idResult) {
		this.idResult = idResult;
	}

	public String getSetExistsErrorMessage() {
		return setExistsErrorMessage;
	}

	public void setSetExistsErrorMessage(String setExistsErrorMessage) {
		this.setExistsErrorMessage = setExistsErrorMessage;
	}

}