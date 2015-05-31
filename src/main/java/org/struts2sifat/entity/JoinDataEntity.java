package org.struts2sifat.entity;

import java.io.Serializable;
import java.util.Date;

/**
 *
 *
 */
public class JoinDataEntity implements Serializable {


	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 *  event_ID
	 */
	private String event_id;

	/**
	 *  user_name
	 */
	private String user_name;

	/**
	 *  mailaddress
	 */
	private String mailaddress;

	/**
	 *  key
	 */
	private String key;

	/**
	 *  comment
	 */
	private String comment;

	/**
	 *  cancel_flg
	 */
	private Boolean cancel_flg;

	/**
	 *  update date
	 */
	private Date updt_date;

	@Override
	public String toString() {
		return "JoinDataEntity ["
				+ (event_id != null ? "event_id=" + event_id + ", " : "")
				+ (user_name != null ? "user_name=" + user_name + ", " : "")
				+ (mailaddress != null ? "mailaddress=" + mailaddress + ", " : "")
				+ (key != null ? "key=" + key + ", " : "")
				+ (comment != null ? "comment=" + comment + ", " : "")
				+ (cancel_flg != null ? "cancel_flg=" + cancel_flg + ", " : "")
				+ (updt_date != null ? "updt_date=" + updt_date : "") + "]";
	}

	/**
	 *
	 * @return ID
	 */
	public String getEvent_id() {
		return event_id;
	}
	/**
	 *
	 */
	public void setEvent_id(String event_id) {
		this.event_id = event_id;
	}

	/**
	 *
	 */
	public String getUser_name() {
		return user_name;
	}

	/**
	 */
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	/**
	 */
	public String getMailaddress() {
		return mailaddress;
	}
	/**
	 */
	public void setMailaddress(String mailaddress) {
		this.mailaddress = mailaddress;
	}

	/**
	 */
	public String getKey() {
		return key;
	}
	/**
	 */
	public void setKey(String key) {
		this.key = key;
	}

	/**
	 */
	public String getComment() {
		return comment;
	}
	/**
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

	/**
	 */
	public Boolean getCancel_flg() {
		return cancel_flg;
	}

	/**
	 */
	public void setCancel_flg(Boolean cancel_flg) {
		this.cancel_flg = cancel_flg;
	}

	/**
	 */
	public Date getUpdt_date() {
		return updt_date;
	}
	/**
	 */
	public void setUpdt_date(Date updt_date) {
		this.updt_date = updt_date;
	}


}
