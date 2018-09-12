/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.sbi.StartUp.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.sbi.StartUp.service.http.CapitalInfServiceSoap}.
 *
 * @author    MAH97223
 * @see       com.sbi.StartUp.service.http.CapitalInfServiceSoap
 * @generated
 */
public class CapitalInfSoap implements Serializable {
	public static CapitalInfSoap toSoapModel(CapitalInf model) {
		CapitalInfSoap soapModel = new CapitalInfSoap();

		soapModel.setInfRefId(model.getInfRefId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setRegNum(model.getRegNum());
		soapModel.setCp_promoters_name(model.getCp_promoters_name());
		soapModel.setCp_promoters_address(model.getCp_promoters_address());
		soapModel.setCp_promoters_amount(model.getCp_promoters_amount());

		return soapModel;
	}

	public static CapitalInfSoap[] toSoapModels(CapitalInf[] models) {
		CapitalInfSoap[] soapModels = new CapitalInfSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CapitalInfSoap[][] toSoapModels(CapitalInf[][] models) {
		CapitalInfSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CapitalInfSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CapitalInfSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CapitalInfSoap[] toSoapModels(List<CapitalInf> models) {
		List<CapitalInfSoap> soapModels = new ArrayList<CapitalInfSoap>(models.size());

		for (CapitalInf model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CapitalInfSoap[soapModels.size()]);
	}

	public CapitalInfSoap() {
	}

	public long getPrimaryKey() {
		return _InfRefId;
	}

	public void setPrimaryKey(long pk) {
		setInfRefId(pk);
	}

	public long getInfRefId() {
		return _InfRefId;
	}

	public void setInfRefId(long InfRefId) {
		_InfRefId = InfRefId;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getRegNum() {
		return _RegNum;
	}

	public void setRegNum(String RegNum) {
		_RegNum = RegNum;
	}

	public String getCp_promoters_name() {
		return _cp_promoters_name;
	}

	public void setCp_promoters_name(String cp_promoters_name) {
		_cp_promoters_name = cp_promoters_name;
	}

	public String getCp_promoters_address() {
		return _cp_promoters_address;
	}

	public void setCp_promoters_address(String cp_promoters_address) {
		_cp_promoters_address = cp_promoters_address;
	}

	public String getCp_promoters_amount() {
		return _cp_promoters_amount;
	}

	public void setCp_promoters_amount(String cp_promoters_amount) {
		_cp_promoters_amount = cp_promoters_amount;
	}

	private long _InfRefId;
	private Date _createDate;
	private Date _modifiedDate;
	private String _RegNum;
	private String _cp_promoters_name;
	private String _cp_promoters_address;
	private String _cp_promoters_amount;
}