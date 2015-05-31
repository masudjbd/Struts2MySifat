package org.struts2sifat.entity;

import java.io.Serializable;

 
public class JoinDataInputEntity implements Serializable {


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
	 *  point
	 */
	private String point;
	@Override
	public String toString() {

		StringBuffer sb = new StringBuffer();
		sb.append("event_id:").append(this.event_id);
		sb.append("\nuser_name:").append(this.user_name);
		sb.append("\nmailaddress:").append(this.mailaddress);
		sb.append("\nkey:").append(this.key);
		sb.append("\ncomment:").append(this.comment);
		sb.append("\ncancel_flg:").append(this.cancel_flg);
		sb.append("\npoint:").append(this.point);

		return sb.toString();

	}

	 
	public String getEvent_id() {
		return event_id;
	}
	 
	public void setEvent_id(String event_id) {
		this.event_id = event_id;
	}

	 
	public String getUser_name() {
		return user_name;
	}

	 
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	 
	public String getMailaddress() {
		return mailaddress;
	}
	 
	public void setMailaddress(String mailaddress) {
		this.mailaddress = mailaddress;
	}

	 
	public String getKey() {
		return key;
	}
	 
	public void setKey(String key) {
		this.key = key;
	}

	 
	public String getComment() {
		return comment;
	}
	 
	public void setComment(String comment) {
		this.comment = comment;
	}

	 
	public Boolean getCancel_flg() {
		return cancel_flg;
	}

	 
	public void setCancel_flg(Boolean cancel_flg) {
		this.cancel_flg = cancel_flg;
	}

	 
	public String getPoint() {
		return point;
	}

	 
	public void setPoint(String point) {
		this.point = point;
	}


}
