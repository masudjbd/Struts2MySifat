package org.struts2sifat.blogic;

import java.util.Date;
import java.util.List;

import org.struts2sifat.dao.SampleDao;
import org.struts2sifat.entity.TestDataEntity;
import org.struts2sifat.entity.TestDataInputEntity;


/**
 *
 */
public class SampleBLogic {


	/**
	 *
	 */
	public List<TestDataEntity> selectTestData(String id) throws Exception {

		SampleDao dao = new SampleDao();
		return dao.selectTestData(id);

	}

	/**
	 *
	 */
	public TestDataEntity registData(TestDataInputEntity tdInputEntity)
			throws Exception {

		SampleDao dao = new SampleDao();
		TestDataEntity tdEntity = new TestDataEntity();

		tdEntity.setPerson_id(tdInputEntity.getPerson_id());
		tdEntity.setName(tdInputEntity.getName());
		tdEntity.setAge(tdInputEntity.getAge());

		tdEntity.setUpdt_date(new Date());

		dao.registTestData(tdEntity);

		return tdEntity;
	}

	/**
	 *
	 */
	public TestDataEntity updateData(TestDataInputEntity tdInputEntity)
			throws Exception {

		SampleDao dao = new SampleDao();

		TestDataEntity tdEntity = new TestDataEntity();
		tdEntity.setPerson_id(tdInputEntity.getPerson_id());
		tdEntity.setName(tdInputEntity.getName());
		tdEntity.setAge(tdInputEntity.getAge());

		tdEntity.setUpdt_date(new Date());

		dao.updateTestData(tdEntity);

		return tdEntity;
	}

	/**
	 *
	 */
	public int deleteData(TestDataInputEntity tdInputEntity)
			throws Exception {

		SampleDao dao = new SampleDao();

		int result = dao.deleteTestData(tdInputEntity.getPerson_id());

		return result;
	}

}
