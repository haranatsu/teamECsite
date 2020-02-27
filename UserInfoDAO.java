package com.internousdev.rose.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.rose.dto.UserInfoDTO;
import com.internousdev.rose.util.DBConnector;

public class UserInfoDAO {

	//DBにユーザー情報を入れる
	public int createUser(String familyName, String firstName, String familyNameKana, String firstNameKana, String sex, String email, String userId, String password) throws SQLException{

		DBConnector db=new DBConnector();
		Connection con=db.getConnection();

		String sql="INSERT INTO user_info(user_id,password,family_name,first_name,family_name_kana,first_name_kana,sex,email,regist_date,update_date) VALUES(?,?,?,?,?,?,?,?,now(),now())";

		int count = 0;

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			ps.setString(2, password);
			ps.setString(3, familyName);
			ps.setString(4, firstName);
			ps.setString(5, familyNameKana);
			ps.setString(6, firstNameKana);
			ps.setString(7, sex);
			ps.setString(8, email);

			count = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
		return count;
	}
//----------  ここまで  -------------

//DBからマイページにユーザー情報を参照するためのselect文
	public UserInfoDTO selectMyPage(String userId)throws SQLException{

		UserInfoDTO userInfoDTO=new UserInfoDTO();
		DBConnector db=new DBConnector();
		Connection con=db.getConnection();

		String sql="select family_name,first_name,family_name_kana,first_name_kana,sex,email from user_info where user_id=?";

		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,userId);

			ResultSet rs=ps.executeQuery();
//rsにデータを入れてuserInfoDTOにsetする
			if(rs.next()) {
				userInfoDTO.setFamilyName(rs.getString("family_name"));
				userInfoDTO.setFirstName(rs.getString("first_name"));
				userInfoDTO.setFamilyNameKana(rs.getString("family_name_kana"));
				userInfoDTO.setFirstNameKana(rs.getString("first_name_kana"));
				userInfoDTO.setSex(rs.getInt("sex"));
				userInfoDTO.setEmail(rs.getString("email"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userInfoDTO;
	}
//----------  ここまで  -------------

//ログイン認証機能に値を引っ張ってくるためのselect文
	public boolean isExistsUserInfo(String userId,String password) throws SQLException{

		DBConnector db=new DBConnector();
		Connection con=db.getConnection();

		boolean result=false;

		String sql="select count(*) as count from user_info where user_id=? and password=?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				if (rs.getInt("count") > 0) {
					result = true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
		return result;
	}
//----------  ここまで  -----------

//DBからユーザーIDだけ引っ張ってくる
	public boolean idCount(String userId) throws SQLException {

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql = "select count(*) AS COUNT FROM user_info where user_id=?";
		boolean result = false;

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			//実行
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				//件数があるならfalse
				if (rs.getInt("COUNT") > 0) {
					result = true;
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}
//----------  ここまで  -----------

//passwordを更新するためのupdate文
	public int updatePassword(String password,String userId)throws SQLException{

		DBConnector db=new DBConnector();
		Connection con=db.getConnection();

		String sql="update user_info set password=? where user_id=?";

		//int型のresの変数を作る
		int res=0;

		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,password);
			ps.setString(2,userId);

			res=ps.executeUpdate();//resが上書きされたら件数が入る

		}catch(SQLException e) {
			e.printStackTrace();
		}
		return res;
	}
//-------  ここまで  --------

//passwordを更新する際、ユーザーIDとパスワードが一致するユーザーIDをselectする
	public int selectPassword(String userId,String password)throws SQLException{

		DBConnector db=new DBConnector();
		Connection con=db.getConnection();

		String sql="select count(*) AS COUNT FROM user_info where user_id=? and password=?";

		int count=0;

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				count = rs.getInt("COUNT");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
//-------  ここまで  -------
}