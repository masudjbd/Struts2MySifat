package org.struts2sifat.action;



import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.postgresql.util.PSQLException;

import org.struts2sifat.blogic.JoinSampleBLogic;
import org.struts2sifat.common.Common;
import org.struts2sifat.entity.JoinDataEntity;
import org.struts2sifat.entity.JoinDataInputEntity;

import com.opensymphony.xwork2.ActionSupport;


 
public class TYGERRegistAction extends ActionSupport {

	 
	private static final long serialVersionUID = -6647201572693844224L;

	 
	private Log log = LogFactory.getLog(TYGERRegistAction.class);

	 
	private JoinDataEntity joinDataEntityTarget;

	 
	private JoinDataInputEntity joinDataInputEntity;

	 
	public String execute() throws Exception {

		return "init";
	}

	 
	public String registData() throws Exception {

		log.debug("**** registData Start ****");

		JoinSampleBLogic blogic = new JoinSampleBLogic();
		try {
			joinDataEntityTarget = blogic.registData(joinDataInputEntity);
		} catch (PSQLException e) {
			addActionError(getText("invalid.regist.duplicate_id",
					new String[] { joinDataInputEntity.getEvent_id() }));
			return "input";
		}

		log.debug("**** registData End ****");

		return SUCCESS;
	}


	/**
	 *
	 * @return success
	 */
	public String selectResultData() throws Exception {

		log.debug("**** selectResultData Start ****");

		JoinSampleBLogic blogic = new JoinSampleBLogic();
		List<JoinDataEntity> resultList = blogic.selectJoinData(joinDataInputEntity.getEvent_id());
		joinDataEntityTarget = resultList.get(0);

		log.debug("**** selectResultData End ****");

		return SUCCESS;
	}


	/**
	 */
	public void validateRegistData() {

		log.debug("****  validateRegistData START  ****");
		log.debug("testDataInputEntit\n"
				+ joinDataInputEntity.toString());

		if (Common.IsNullOrEmpty(joinDataInputEntity.getUser_name())) {

			addActionError(getText("invalid.fieldvalue.user_name"));
		}

		if (Common.IsNullOrEmpty(joinDataInputEntity.getMailaddress())) {

			addActionError(getText("invalid.fieldvalue.mailaddress"));
		}

		//if (Common.IsNullOrEmpty(joinDataInputEntity.getKey())) {

		//	addActionError(getText("invalid.fieldvalue.key"));
		//}

		if (Common.IsNullOrEmpty(joinDataInputEntity.getComment())) {

			addActionError(getText("invalid.fieldvalue.comment"));
		}

		//if (testDataInputEntity.getAge() == null || testDataInputEntity.getAge().intValue() < 0) {

		//	addActionError(getText("invalid.fieldvalue.age"));
		//}

		log.debug("****  validateRegistData END  ****");
	}

	////////////////////////////////////
	// Setter / Getter

	/**
	 * joinDataEntity getter
	 *
	 * @return joinDataEntityTarget
	 */
	public JoinDataEntity getJoinDataEntityTarget() {
		return joinDataEntityTarget;
	}

	/**
	 * joinDataEntity setter
	 *
	 * @param joinDataEntityTarget   JoinDataEntity
	 */
	public void setJoinDataEntityTarget(JoinDataEntity joinDataEntity) {
		this.joinDataEntityTarget = joinDataEntity;
	}

	/**
	 * joinDataInputEntity getter
	 *
	 * @return joinDataInputEntity
	 */
	public JoinDataInputEntity getJoinDataInputEntity() {
		return joinDataInputEntity;
	}

	/**
	 * joinDataInputEntity setter
	 *
	 * @param joinDataInputEntity  joinDataInputEntity
	 */
	public void setJoinDataInputEntity(JoinDataInputEntity joinDataInputEntity) {

		this.joinDataInputEntity = joinDataInputEntity;
	}

}
