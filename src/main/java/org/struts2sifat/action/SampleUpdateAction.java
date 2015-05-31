package org.struts2sifat.action;



import java.util.List;

import org.struts2sifat.blogic.SampleBLogic;
import org.struts2sifat.common.Common;
import org.struts2sifat.entity.TestDataEntity;
import org.struts2sifat.entity.TestDataInputEntity;

import com.opensymphony.xwork2.ActionSupport;


 
public class SampleUpdateAction extends ActionSupport {

	 
	private static final long serialVersionUID = 1L;

	 
	private List<TestDataEntity> testDataEntityList;

	 
	private TestDataEntity testDataEntityTarget;

	 
	private TestDataInputEntity testDataInputEntity;

	 
	public String execute() throws Exception {

		return "init";
	}

	 
	public String selectData() throws Exception {

		System.out.println("****  selectData  ****");

		SampleBLogic blogic = new SampleBLogic();
		testDataEntityList = blogic.selectTestData(testDataInputEntity.getPerson_id());

		System.out.println("****  selectData End ****");

		if (testDataEntityList == null) {
			addActionError(getText("person.notFound"));
			return "init";
		}

		return "search";
	}

	/**
	 *
	 * @return updateDisplay
	 */
	public String updateDisplay() throws Exception {

		String person_id = testDataInputEntity.getPerson_id();

		System.out.println("**** SampleUpdateAction.execute person_id = " + person_id +  "  ****");

		SampleBLogic blogic = new SampleBLogic();
		List<TestDataEntity> resultList = blogic.selectTestData(person_id);

		if (resultList != null) {
			testDataEntityTarget = resultList.get(0);
		} else {
			addActionError(" err ");
			return "init";
		}

		return "updateDisplay";
	}

	/**
	 *
	 * @return update
	 */
	public String updateData() throws Exception {

		System.out.println("****  updateData START ****");

		SampleBLogic blogic = new SampleBLogic();
		testDataEntityTarget = blogic.updateData(testDataInputEntity);

		System.out.println("****  updateData END ****");

//		return "update";
		return "success";
	}

	/**
	 */
	public void validateUpdateData() {

		System.out.println("****  validateUpdateData START  ****");
		System.out.println("testDataInputEntity\n" + testDataInputEntity.toString());

		if (Common.IsNullOrEmpty(testDataInputEntity.getName())) {

			addActionError(getText("invalid.fieldvalue.name"));
		}

		if (testDataInputEntity.getAge() == null || testDataInputEntity.getAge().intValue() < 0) {

			addActionError(getText("invalid.fieldvalue.age"));
		}

		System.out.println("****  validateUpdateData END  ****");
	}

	/**
	 *
	 * @return delete
	 */
	public String deleteData() throws Exception {

		System.out.println("****  deleteData START ****");

		SampleBLogic blogic = new SampleBLogic();
		int result = blogic.deleteData(testDataInputEntity);

		if (result == 0) {
			addActionError(getText("invalid.delete.id_not_found",
					new String[] { testDataInputEntity.getPerson_id() }));
			return "input";
		}

		System.out.println("****  deleteData END **** 結果:" + result);

		return "delete";
	}


	////////////////////////////////////
	// Setter / Getter
	/**
	 * testDataEntityList getter
	 *
	 * @return testDataEntityList
	 */
	public List<TestDataEntity> getTestDataEntityList() {
		return testDataEntityList;
	}

	/**
	 * testDataEntityList setter
	 *
	 * @param testDataEntityList TestDataEntity
	 */
	public void setTestDataEntityList(List<TestDataEntity> testDataEntityList) {
		this.testDataEntityList = testDataEntityList;
	}

	/**
	 * testDataInputEntity getter
	 *
	 * @return testDataInputEntity
	 */
	public TestDataInputEntity getTestDataInputEntity() {
		return testDataInputEntity;
	}

	/**
	 * testDataInputEntity setter
	 *
	 * @param testDataInputEntity  testDataInputEntity
	 */
	public void setTestDataInputEntity(TestDataInputEntity testDataInputEntity) {

		this.testDataInputEntity = testDataInputEntity;
	}

	/**
	 * @return testDataEntityTarget
	 */
	public TestDataEntity getTestDataEntityTarget() {
		return testDataEntityTarget;
	}

	/**
	 * @param testDataEntityTarget  testDataEntityTarget
	 */
	public void setTestDataEntityTarget(TestDataEntity testDataTarget) {
		this.testDataEntityTarget = testDataTarget;
	}


}
