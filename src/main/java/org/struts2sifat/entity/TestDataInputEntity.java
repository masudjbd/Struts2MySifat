package org.struts2sifat.entity;

import java.io.Serializable;

 
public class TestDataInputEntity implements Serializable {


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
	 *  point
	 */
	private String point;
	@Override
	public String toString() {

		StringBuffer sb = new StringBuffer();
		sb.append("person_id:").append(this.person_id);
		sb.append("\nname:").append(this.name);
		sb.append("\nage:").append(this.age);
		sb.append("\npoint:").append(this.point);

		return sb.toString();

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

	 
	public String getPoint() {
		return point;
	}
 
	public void setPoint(String point) {
		this.point = point;
	}


}
