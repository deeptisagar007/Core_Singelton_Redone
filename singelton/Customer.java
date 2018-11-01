package com.deepti.singelton;

import java.io.Serializable;

@SuppressWarnings("serial")
public final class Customer implements Serializable {
	private int cId;
	private String cName;
	private String cAddress;
	private long cCityPinCode;
	private String cPassWord;

	/**
	 * @param cId
	 * @param cName
	 * @param cAddress
	 * @param cCityPinCode
	 * @param cPassWord
	 */
	public Customer(int cId, String cName, String cAddress, long cCityPinCode, String cPassWord) {
		this.cId = cId;
		this.cName = cName;
		this.cAddress = cAddress;
		this.cCityPinCode = cCityPinCode;
		this.cPassWord = cPassWord;
		System.out.println(
				"Make Password transient to make password unaccessable, while serializing also Password will se set as null in th file");
	}

}
