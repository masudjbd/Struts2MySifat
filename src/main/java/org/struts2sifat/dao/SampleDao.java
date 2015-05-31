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
import org.struts2sifat.entity.TestDataEntity;

/**
 *
 */
public class SampleDao extends CommonDao {

	/**
	 */
	private Log log = LogFactory.getLog(this.getClass());

	/**
	 *
	 */
	public SampleDao() throws NamingException {

		super();

	}


	/**
	 */
	public List<TestDataEntity> selectTestData(String id)
			throws Exception {

		log.debug("Test ");

		boolean idIsExist = false;

		if (!Common.IsNullOrEmpty(id)) {
			idIsExist = true;
		}

		Connection con = super.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<TestDataEntity> list = null;

		try {
			// String SQL = "select person_id, name, age, updt_date from T_Test; ";
			StringBuffer sbSQL = new StringBuffer();
			sbSQL.append("select person_id, name, age, updt_date from T_PERSON");

			if (idIsExist) {
				sbSQL.append(" where person_id = ? ");
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
					list = new ArrayList<TestDataEntity>();
				}

				TestDataEntity tdEntitiy = null;
				tdEntitiy = new TestDataEntity();
				tdEntitiy.setPerson_id(rs.getString("person_id"));
				tdEntitiy.setName(rs.getString("name"));
				tdEntitiy.setAge(rs.getInt("age"));
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

	/**
	 */
	public int registTestData(TestDataEntity tdEntity)
			throws Exception {

		log.debug("Test ");

		Connection con = super.getConnection();
		PreparedStatement pstmt = null;
		int rs = 0;

		try {

			String SQL = "INSERT INTO T_PERSON (person_id, name, age, updt_date) VALUES (?, ?, ?, ?);";
			//String SQL = "select person_id, name, age, updt_date from T_Test; ";

			pstmt = con.prepareStatement(SQL);
//			pstmt.setQueryTimeout(CommonDao.getSqlExcuteTimeout());

			pstmt.setString(1, tdEntity.getPerson_id());
			pstmt.setString(2, tdEntity.getName());
			pstmt.setInt(3, tdEntity.getAge());
			pstmt.setDate(4, new java.sql.Date(tdEntity.getUpdt_date().getTime())); // 暫定対応

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

	/**
	 *
	 */
	public int updateTestData(TestDataEntity tdEntity)
			throws Exception {

		log.debug("Test ");

		Connection con = super.getConnection();
		PreparedStatement pstmt = null;
		int rs = 0;

		try {

			String SQL = "UPDATE T_PERSON SET name = ?, age = ?, updt_date = ? WHERE person_id = ?;";
			//String SQL = "select person_id, name, age, updt_date from T_Test; ";

			pstmt = con.prepareStatement(SQL);
//			pstmt.setQueryTimeout(CommonDao.getSqlExcuteTimeout());

			pstmt.setString(1, tdEntity.getName());
			pstmt.setInt(2, tdEntity.getAge());
			pstmt.setDate(3, new java.sql.Date(tdEntity.getUpdt_date().getTime()));  
			pstmt.setString(4, tdEntity.getPerson_id());

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

		System.out.println("**** SampleDAO.updateTestData  " + rs + " ****");

		return rs;
	}

	public int deleteTestData(String person_id)
			throws Exception {


		Connection con = super.getConnection();
		PreparedStatement pstmt = null;
		int rs = 0;

		try {

			String SQL = "DELETE FROM T_PERSON WHERE person_id = ?;";
			//String SQL = "select person_id, name, age, updt_date from T_Test; ";

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

}