package org.struts2sifat.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.struts2sifat.common.Common;
import org.struts2sifat.entity.JoinDataEntity;

 
public class JoinSampleDao extends CommonDao {

	/**
	 */
	private Log log = LogFactory.getLog(this.getClass());

	/**
	 * Constructor
	 *
	 */
	public JoinSampleDao() throws NamingException {

		super();

	}


	/**
	 */
	public List<JoinDataEntity> selectJoinData(String id)
			throws Exception {

		log.debug("Test ");

		boolean idIsExist = false;

		if (!Common.IsNullOrEmpty(id)) {
			idIsExist = true;
		}

		Connection con = super.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<JoinDataEntity> list = null;

		try {
			// String SQL = "select event_id, user_name, mailaddress, key, comment, cancel_flg, updt_date from T_Test; ";
			StringBuffer sbSQL = new StringBuffer();
			sbSQL.append("select event_id, user_name, mailaddress, key, comment, cancel_flg, updt_date from T_PERSON");

			if (idIsExist) {
				sbSQL.append(" where event_id = ? ");
			}

			pstmt = con.prepareStatement(sbSQL.toString());
			//pstmt.setQueryTimeout(CommonDao.getSqlExcuteTimeout());

			if (idIsExist) {
				pstmt.setString(1, id);
			}

			rs = pstmt.executeQuery();

			// Iterate through the data in the result set and display it.
			while (rs.next()) {

				if (list == null) {
					list = new ArrayList<JoinDataEntity>();
				}

				JoinDataEntity tdEntitiy = null;
				tdEntitiy = new JoinDataEntity();
				tdEntitiy.setEvent_id(rs.getString("event_id"));
				tdEntitiy.setUser_name(rs.getString("user_name"));
				tdEntitiy.setMailaddress(rs.getString("mailaddress"));
				tdEntitiy.setKey(rs.getString("key"));
				tdEntitiy.setComment(rs.getString("comment"));
				tdEntitiy.setCancel_flg(rs.getBoolean("cancel_flg"));
				tdEntitiy.setUpdt_date(rs.getDate("updt_date"));
				list.add(tdEntitiy);
			}
		}

		finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (Exception e) {
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
				}
			}
		}
		return list;
	}

	 
	public int registJoinData(JoinDataEntity tdEntity)
			throws Exception {

		log.debug("Test ");

		Connection con = super.getConnection();
		PreparedStatement pstmt = null;
		int rs = 0;

		try {

			String SQL = "INSERT INTO t_join (event_id, user_name, mailaddress, key, comment, cancel_flg, updt_date) VALUES (?, ?, ?, ?, ?, ?, ?);";
			//String SQL = "select event_id, user_name, mailaddress, key, comment, cancel_flg, updt_date from t_join; ";

			pstmt = con.prepareStatement(SQL);
//			pstmt.setQueryTimeout(CommonDao.getSqlExcuteTimeout());

			pstmt.setString(1, tdEntity.getEvent_id());
			pstmt.setString(2, tdEntity.getUser_name());
			pstmt.setString(3, tdEntity.getMailaddress());
			pstmt.setString(4, tdEntity.getKey());
			pstmt.setString(5, tdEntity.getComment());
			pstmt.setBoolean(6, tdEntity.getCancel_flg());
			pstmt.setDate(7, new java.sql.Date(tdEntity.getUpdt_date().getTime()));  

			// Insert, Update executeUpdate
			rs = pstmt.executeUpdate();

		}

		finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (Exception e) {
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
				}
			}
		}

		System.out.println("**** SampleDAO.registJoinData  " + rs + " ****");

		return rs;
	}

	/**
	 *
	public int updateTestData(TestDataEntity tdEntity)
			throws Exception {


		Connection con = super.getConnection();
		PreparedStatement pstmt = null;
		int rs = 0;

		try {

			String SQL = "UPDATE T_PERSON SET name = ?, age = ?, location = ?, updt_date = ? WHERE person_id = ?;";
			//String SQL = "select person_id, name, age, loaction, updt_date from T_Test; ";

			pstmt = con.prepareStatement(SQL);
//			pstmt.setQueryTimeout(CommonDao.getSqlExcuteTimeout());

			pstmt.setString(1, tdEntity.getName());
			pstmt.setInt(2, tdEntity.getAge());
			pstmt.setString(3, tdEntity.getLocation());
			pstmt.setDate(4, new java.sql.Date(tdEntity.getUpdt_date().getTime()));  
			pstmt.setString(5, tdEntity.getPerson_id());

			rs = pstmt.executeUpdate();

		}

		finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (Exception e) {
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
				}
			}
		}


		return rs;
	}
	 */

	/**
	public int deleteTestData(String person_id)
			throws Exception {

		Connection con = super.getConnection();
		PreparedStatement pstmt = null;
		int rs = 0;

		try {

			String SQL = "DELETE FROM T_PERSON WHERE person_id = ?;";
			//String SQL = "select person_id, name, age, location, updt_date from T_Test; ";

			pstmt = con.prepareStatement(SQL);
//			pstmt.setQueryTimeout(CommonDao.getSqlExcuteTimeout());

			pstmt.setString(1, person_id);

			// Insert, UpdateはexecuteUpdate
			rs = pstmt.executeUpdate();

		}

		finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (Exception e) {
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
				}
			}
		}


		return rs;
	}
	 */

}
