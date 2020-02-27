package com.internousdev.rose.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.rose.dto.DestinationInfoDTO;
import com.internousdev.rose.util.DBConnector;

public class DestinationInfoDAO {

	//DBに格納するinsert文
	public int destinationInfoInsert(String userId,String familyName, String firstName, String familyNameKana, String firstNameKana,String address,String phoneNumber,String mailAddress) throws SQLException {

		DBConnector db=new DBConnector();
		Connection con=db.getConnection();

		String sql="INSERT INTO destination_info(user_id,family_name,first_name,family_name_kana,first_name_kana,user_address,tel_number,email,regist_date,update_date)VALUES(?,?,?,?,?,?,?,?,now(),now())";

		int count=0;

		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,userId);
			ps.setString(2,familyName);
			ps.setString(3,firstName);
			ps.setString(4,familyNameKana);
			ps.setString(5,firstNameKana);
			ps.setString(6,address);
			ps.setString(7,phoneNumber);
			ps.setString(8,mailAddress);

			count = ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			con.close();
		}
		return count;
	}

	public List<DestinationInfoDTO> getDestinationInfo(String userId) throws SQLException{

		DBConnector db=new DBConnector();
		Connection con=db.getConnection();

		List<DestinationInfoDTO> destinationInfoDtoList=new ArrayList<DestinationInfoDTO>();

		String sql ="SELECT id,family_name,first_name,family_name_kana,first_name_kana,email,tel_number,user_address FROM destination_info WHERE user_id=?";

		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,userId);

			ResultSet rs=ps.executeQuery();

			while(rs.next()) {
				DestinationInfoDTO destinationInfoDTO=new DestinationInfoDTO();
				destinationInfoDTO.setId(rs.getInt("id"));
				destinationInfoDTO.setFamilyName(rs.getString("family_name"));
				destinationInfoDTO.setFirstName(rs.getString("first_name"));
				destinationInfoDTO.setFamilyNameKana(rs.getString("family_name_kana"));
				destinationInfoDTO.setFirstNameKana(rs.getString("first_name_kana"));
				destinationInfoDTO.setUserAddress(rs.getString("user_address"));
				destinationInfoDTO.setTelNumber(rs.getString("tel_number"));
				destinationInfoDTO.setEmail(rs.getString("email"));
				destinationInfoDtoList.add(destinationInfoDTO);

			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			con.close();
		}
		return destinationInfoDtoList;
	}

	public int deleteDestination(String destinationId) throws SQLException {

		DBConnector db=new DBConnector();
		Connection con=db.getConnection();

		String sql="DELETE FROM destination_info WHERE id=?";
		int result=0;

		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,destinationId);

			result=ps.executeUpdate();

			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				con.close();
			}
			return result;
		}
}