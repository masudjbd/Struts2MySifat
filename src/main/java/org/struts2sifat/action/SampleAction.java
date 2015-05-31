package org.struts2sifat.action;



import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.struts2sifat.blogic.SampleBLogic;
import org.struts2sifat.common.Common;
import org.struts2sifat.entity.TestDataEntity;
import org.struts2sifat.entity.TestDataInputEntity;

import com.opensymphony.xwork2.ActionSupport;


 
public class SampleAction extends ActionSupport {

	 
	private Log log = LogFactory.getLog(SampleAction.class);

	 
	private static final long serialVersionUID = 1L;

	 
	private TestDataEntity testDataEntity;

	 
	private TestDataInputEntity testDataInputEntity;


	 
	private String inputError;


	 
	private String historyId;


	 
	public String selectData() throws Exception {

		if (log.isDebugEnabled()) {
			log.debug("****  selectData  ****");
		}

		if (log.isDebugEnabled()) {
			log.debug(" Input :" + testDataInputEntity.toString());
		}

		SampleBLogic blogic = new SampleBLogic();
//		testDataEntity = blogic.selectTestData(testDataInputEntity.getPerson_id());
		List<TestDataEntity> resultList = blogic.selectTestData(testDataInputEntity.getPerson_id());

		if (resultList == null) {
			addActionError(" error data ");
			return "input";
		}

		testDataEntity = resultList.get(0);

		if (log.isDebugEnabled()) {
			log.debug("****  selectData End ****");
		}

		return SUCCESS;
	}

	public String selectData2() throws Exception {

		if (log.isDebugEnabled()) {
			log.debug("****  selectData2  ****");
		}

		if (log.isDebugEnabled()) {
			log.debug(" Input :" + testDataInputEntity.toString());
		}

		SampleBLogic blogic = new SampleBLogic();
//		testDataEntity = blogic.selectTestData(testDataInputEntity.getPerson_id());
		List<TestDataEntity> resultList = blogic.selectTestData(testDataInputEntity.getPerson_id());

		if (resultList == null) {
			addActionError(" ID ");
		}

		testDataEntity = resultList.get(0);

		return SUCCESS;
	}
	 
	public void validateSelectData() {

		if (log.isDebugEnabled()) {
			log.debug("****  validateSelectData  ****");
			log.debug("testDataInputEntity.getPerson_id : "
					+ testDataInputEntity.getPerson_id());
		}

		// ID 
		if (Common.IsNullOrEmpty(testDataInputEntity.getPerson_id())) {

			addActionError(getText("invalid.fieldvalue.person_id"));
		}

		if (log.isDebugEnabled()) {
			log.debug("****  validateSelectData2  ****");
		}
	}

	 
	public String inputCheck() {

		//  Exception
//		inputError = null;
//		inputError.length();

		if (log.isDebugEnabled()) {
			log.debug("****  inputCheck  ****");
			log.debug("testDataInputEntity.getPoint : "
					+ testDataInputEntity.getPoint());
		}

		// ID 
		if (Common.IsNullOrEmpty(testDataInputEntity.getPoint())) {

			inputError = getText("invalid.fieldvalue.person_id.isnull");
		}else{

			try {
				Integer.parseInt(testDataInputEntity.getPoint());
			} catch(NumberFormatException e) {
				inputError = getText("invalid.fieldvalue.person_id.notNumber");
			}
		}

		if (Common.IsNullOrEmpty(inputError)){
			inputError = SUCCESS;
		}

		if (log.isDebugEnabled()) {
			log.debug("****  inputCheck  ****");
		}

		 
		return SUCCESS;

	}



	/**
	 * ポイント変更のアクション
	 */
	public String pointChange() {

		if (log.isDebugEnabled()) {

			log.debug("****  pointChange  ****");
			log.debug("testDataInputEntity.getPoint : "
					+ testDataInputEntity.getPoint());
			log.debug("****  pointChange end ****");
		}


		historyId = "007";
		// 画面遷移
		return SUCCESS;
	}

	////////////////////////////////////
	// Setter / Getter

	/**
	 * testDataEntityのgetter
	 *
	 * @return testDataEntity
	 */
	public TestDataEntity getTestDataEntity() {
		return testDataEntity;
	}

	/**
	 * testDataEntityのsetter
	 *
	 * @param _input 設定するtestDataentity
	 */
	public void setTestDataEntity(TestDataEntity _input) {
		this.testDataEntity = _input;
	}

	/**
	 * testDataInputEntityのgetter
	 *
	 * @return testDataInputEntity
	 */
	public TestDataInputEntity getTestDataInputEntity() {
		return testDataInputEntity;
	}

	/**
	 * testDataInputEntityのsetter
	 *
	 * @param _input 設定するtestDataInputEntity
	 */
	public void setTestDataInputEntity(TestDataInputEntity _input) {
		this.testDataInputEntity = _input;
	}

	/**
	 * inputErrorのsetter
	 *
	 * @param inputError 設定するinputError
	 */
	public void setInputError(String inputError) {
		this.inputError = inputError;
	}

	/**
	 * inputErrorのgetter
	 *
	 * @return inputError
	 */
	public String getInputError() {
		return inputError;
	}

	public String getHistoryId() {
		return historyId;
	}

	public void setHistoryId(String historyId) {
		this.historyId = historyId;
	}


}
