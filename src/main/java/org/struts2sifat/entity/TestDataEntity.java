package org.struts2sifat.entity;

import java.io.Serializable;
import java.util.Date;

 
public class TestDataEntity implements Serializable {


	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 *  ID
	 */
	private String person_id;

	/**
	 *  name
	 */
	private String name;

	/**
	 *  age
	 */
	private Integer age;

	/**
	 *  update date
	 */
	private Date updt_date;

	 
	@Override
	public String toString() {
		return "TestDataEntity ["
				+ (person_id != null ? "person_id=" + person_id + ", " : "")
				+ (name != null ? "name=" + name + ", " : "")
				+ (age != null ? "age=" + age + ", " : "")
				+ (updt_date != null ? "updt_date=" + updt_date : "") + "]";
	}

	 
	public String getPerson_id() {
		return person_id;
	}


	 
	public void setPerson_id(String person_id) {
		this.person_id = person_id;
	}
	 
	public String getName() {
		return name;
	}
	 
	public void setName(String name) {
		this.name = name;
	}
	 
	public Integer getAge() {
		return age;
	}
	 
	public void setAge(Integer age) {
		this.age = age;
	}

	 
	public Date getUpdt_date() {
		return updt_date;
	}
	 
	public void setUpdt_date(Date updt_date) {
		this.updt_date = updt_date;
	}


}
