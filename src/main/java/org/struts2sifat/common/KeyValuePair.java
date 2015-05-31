package org.struts2sifat.common;

import java.io.Serializable;

/**
 *
 */
public class KeyValuePair implements Serializable {

	/**
	 */
	private static final long serialVersionUID = 1L;

	/**
	 */
	private Integer key;

	/**
	 */
	private String Value;

	/**
	 *
	 */
	public Integer getKey() {
		return key;
	}

	/**
	 */
	public void setKey(Integer key) {
		this.key = key;
	}

	/**
	 */
	public String getValue() {
		return Value;
	}

	/**
	 */
	public void setValue(String value) {
		Value = value;
	}

	/**
	 *            value
	 */
	public KeyValuePair(Integer key, String value) {
		super();
		this.key = key;
		Value = value;
	}
}
