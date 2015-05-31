package org.struts2sifat.blogic;

import java.util.Date;
import java.util.List;

import org.struts2sifat.dao.JoinSampleDao;
import org.struts2sifat.entity.JoinDataEntity;
import org.struts2sifat.entity.JoinDataInputEntity;


/**
 * @author nttdbs_sugiim
 *
 */
public class JoinSampleBLogic {


 
	public List<JoinDataEntity> selectJoinData(String id) throws Exception {

		JoinSampleDao dao = new JoinSampleDao();
		return dao.selectJoinData(id);

	}

	 
	public JoinDataEntity registData(JoinDataInputEntity tdInputEntity)
			throws Exception {

		JoinSampleDao dao = new JoinSampleDao();
		JoinDataEntity tdEntity = new JoinDataEntity();

		tdEntity.setEvent_id(tdInputEntity.getEvent_id());
		tdEntity.setUser_name(tdInputEntity.getUser_name());
		tdEntity.setMailaddress(tdInputEntity.getMailaddress());
		tdEntity.setKey(tdInputEntity.getKey());
		tdEntity.setComment(tdInputEntity.getComment());
		tdEntity.setCancel_flg(tdInputEntity.getCancel_flg());
		//tdEntity.setUpdt_date(tdInputEntity.getUpdt_date());

		tdEntity.setUpdt_date(new Date());

		dao.registJoinData(tdEntity);

		return tdEntity;
	}

	/**
	 *
	public TestDataEntity updateData(JoinDataInputEntity tdInputEntity)
			throws Exception {

		SampleDao dao = new SampleDao();

		TestDataEntity tdEntity = new TestDataEntity();
		tdEntity.setPerson_id(tdInputEntity.getPerson_id());
		tdEntity.setName(tdInputEntity.getName());
		tdEntity.setAge(tdInputEntity.getAge());
		tdEntity.setLocation(tdInputEntity.getLocation());

		tdEntity.setUpdt_date(new Date());

		dao.updateTestData(tdEntity);

		return tdEntity;
	}
	 */

	/**
	 *
	public int deleteData(JoinDataInputEntity tdInputEntity)
			throws Exception {

		SampleDao dao = new SampleDao();

		int result = dao.deleteTestData(tdInputEntity.getPerson_id());

		return result;
	}
	 */

}
