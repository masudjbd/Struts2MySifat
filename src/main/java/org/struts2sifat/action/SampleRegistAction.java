package org.struts2sifat.action;



import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.postgresql.util.PSQLException;

import org.struts2sifat.blogic.SampleBLogic;
import org.struts2sifat.common.Common;
import org.struts2sifat.entity.TestDataEntity;
import org.struts2sifat.entity.TestDataInputEntity;

import com.opensymphony.xwork2.ActionSupport;


 
public class SampleRegistAction extends ActionSupport {

	 
	private static final long serialVersionUID = -6647201572693844224L;

	 
	private Log log = LogFactory.getLog(SampleRegistAction.class);

	 
	private TestDataEntity testDataEntityTarget;

	 
	private TestDataInputEntity testDataInputEntity;

	 
	public String execute() throws Exception {

		return "init";
	}

	 
	public String registData() throws Exception {

		log.debug("**** registData Start ****");

		SampleBLogic blogic = new SampleBLogic();
		try {
			testDataEntityTarget = blogic.registData(testDataInputEntity);
		} catch (PSQLException e) {
			addActionError(getText("invalid.regist.duplicate_id",
					new String[] { testDataInputEntity.getPerson_id() }));
			return "input";
		}

		log.debug("**** registData End ****");

		return SUCCESS;
	}


	 
	public String selectResultData() throws Exception {

		log.debug("**** selectResultData Start ****");

		SampleBLogic blogic = new SampleBLogic();
		List<TestDataEntity> resultList = blogic.selectTestData(testDataInputEntity.getPerson_id());
		testDataEntityTarget = resultList.get(0);

		log.debug("**** selectResultData End ****");

		return SUCCESS;
	}


	 
	public void validateRegistData() {

		log.debug("****  validateRegistData START  ****");
		log.debug("testDataInputEntit\n"
				+ testDataInputEntity.toString());

		if (Common.IsNullOrEmpty(testDataInputEntity.getPerson_id())) {

			addActionError(getText("invalid.fieldvalue.person_id"));
		}

		if (Common.IsNullOrEmpty(testDataInputEntity.getName())) {

			addActionError(getText("invalid.fieldvalue.name"));
		}

		if (testDataInputEntity.getAge() == null || testDataInputEntity.getAge().intValue() < 0) {

			addActionError(getText("invalid.fieldvalue.age"));
		}

		log.debug("****  validateRegistData END  ****");
	}

	////////////////////////////////////
	// Setter / Getter

	/**
	 * testDataEntity getter
	 *
	 * @return testDataEntityTarget
	 */
	public TestDataEntity getTestDataEntityTarget() {
		return testDataEntityTarget;
	}

	/**
	 * testDataEntity setter
	 *
	 * @param testDataEntityTarget TestDataEntity
	 */
	public void setTestDataEntityTarget(TestDataEntity testDataEntity) {
		this.testDataEntityTarget = testDataEntity;
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
	 * @param testDataInputEntity testDataInputEntity
	 */
	public void setTestDataInputEntity(TestDataInputEntity testDataInputEntity) {

		this.testDataInputEntity = testDataInputEntity;
	}

}
