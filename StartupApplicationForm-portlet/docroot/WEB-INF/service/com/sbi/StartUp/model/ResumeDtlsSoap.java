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
 * This class is used by SOAP remote services, specifically {@link com.sbi.StartUp.service.http.ResumeDtlsServiceSoap}.
 *
 * @author    MAH97223
 * @see       com.sbi.StartUp.service.http.ResumeDtlsServiceSoap
 * @generated
 */
public class ResumeDtlsSoap implements Serializable {
	public static ResumeDtlsSoap toSoapModel(ResumeDtls model) {
		ResumeDtlsSoap soapModel = new ResumeDtlsSoap();

		soapModel.setResumeId(model.getResumeId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setRegNum(model.getRegNum());
		soapModel.setName(model.getName());
		soapModel.setEmail(model.getEmail());
		soapModel.setMnumber(model.getMnumber());
		soapModel.setDob(model.getDob());
		soapModel.setAddress_line_1(model.getAddress_line_1());
		soapModel.setAddress_line_2(model.getAddress_line_2());
		soapModel.setAddress_landmark(model.getAddress_landmark());
		soapModel.setAddress_city(model.getAddress_city());
		soapModel.setAddress_pin(model.getAddress_pin());
		soapModel.setAddress_state(model.getAddress_state());
		soapModel.setPerm_address_line_1(model.getPerm_address_line_1());
		soapModel.setPerm_address_line_2(model.getPerm_address_line_2());
		soapModel.setPerm_address_landmark(model.getPerm_address_landmark());
		soapModel.setPerm_address_city(model.getPerm_address_city());
		soapModel.setPerm_address_pin(model.getPerm_address_pin());
		soapModel.setPerm_address_state(model.getPerm_address_state());
		soapModel.setPan(model.getPan());
		soapModel.setAadharNum(model.getAadharNum());
		soapModel.setCarrerAspect(model.getCarrerAspect());
		soapModel.setKeyITSkill(model.getKeyITSkill());
		soapModel.setCertfTra(model.getCertfTra());
		soapModel.setEmpyHistory(model.getEmpyHistory());
		soapModel.setCoreComp(model.getCoreComp());
		soapModel.setAccomplishment(model.getAccomplishment());
		soapModel.setAcademics(model.getAcademics());
		soapModel.setStatus(model.getStatus());
		soapModel.setFlag(model.getFlag());
		soapModel.setIndexno(model.getIndexno());

		return soapModel;
	}

	public static ResumeDtlsSoap[] toSoapModels(ResumeDtls[] models) {
		ResumeDtlsSoap[] soapModels = new ResumeDtlsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ResumeDtlsSoap[][] toSoapModels(ResumeDtls[][] models) {
		ResumeDtlsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ResumeDtlsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ResumeDtlsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ResumeDtlsSoap[] toSoapModels(List<ResumeDtls> models) {
		List<ResumeDtlsSoap> soapModels = new ArrayList<ResumeDtlsSoap>(models.size());

		for (ResumeDtls model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ResumeDtlsSoap[soapModels.size()]);
	}

	public ResumeDtlsSoap() {
	}

	public long getPrimaryKey() {
		return _ResumeId;
	}

	public void setPrimaryKey(long pk) {
		setResumeId(pk);
	}

	public long getResumeId() {
		return _ResumeId;
	}

	public void setResumeId(long ResumeId) {
		_ResumeId = ResumeId;
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

	public String getName() {
		return _Name;
	}

	public void setName(String Name) {
		_Name = Name;
	}

	public String getEmail() {
		return _Email;
	}

	public void setEmail(String Email) {
		_Email = Email;
	}

	public String getMnumber() {
		return _Mnumber;
	}

	public void setMnumber(String Mnumber) {
		_Mnumber = Mnumber;
	}

	public Date getDob() {
		return _Dob;
	}

	public void setDob(Date Dob) {
		_Dob = Dob;
	}

	public String getAddress_line_1() {
		return _address_line_1;
	}

	public void setAddress_line_1(String address_line_1) {
		_address_line_1 = address_line_1;
	}

	public String getAddress_line_2() {
		return _address_line_2;
	}

	public void setAddress_line_2(String address_line_2) {
		_address_line_2 = address_line_2;
	}

	public String getAddress_landmark() {
		return _address_landmark;
	}

	public void setAddress_landmark(String address_landmark) {
		_address_landmark = address_landmark;
	}

	public String getAddress_city() {
		return _address_city;
	}

	public void setAddress_city(String address_city) {
		_address_city = address_city;
	}

	public String getAddress_pin() {
		return _address_pin;
	}

	public void setAddress_pin(String address_pin) {
		_address_pin = address_pin;
	}

	public String getAddress_state() {
		return _address_state;
	}

	public void setAddress_state(String address_state) {
		_address_state = address_state;
	}

	public String getPerm_address_line_1() {
		return _perm_address_line_1;
	}

	public void setPerm_address_line_1(String perm_address_line_1) {
		_perm_address_line_1 = perm_address_line_1;
	}

	public String getPerm_address_line_2() {
		return _perm_address_line_2;
	}

	public void setPerm_address_line_2(String perm_address_line_2) {
		_perm_address_line_2 = perm_address_line_2;
	}

	public String getPerm_address_landmark() {
		return _perm_address_landmark;
	}

	public void setPerm_address_landmark(String perm_address_landmark) {
		_perm_address_landmark = perm_address_landmark;
	}

	public String getPerm_address_city() {
		return _perm_address_city;
	}

	public void setPerm_address_city(String perm_address_city) {
		_perm_address_city = perm_address_city;
	}

	public String getPerm_address_pin() {
		return _perm_address_pin;
	}

	public void setPerm_address_pin(String perm_address_pin) {
		_perm_address_pin = perm_address_pin;
	}

	public String getPerm_address_state() {
		return _perm_address_state;
	}

	public void setPerm_address_state(String perm_address_state) {
		_perm_address_state = perm_address_state;
	}

	public String getPan() {
		return _Pan;
	}

	public void setPan(String Pan) {
		_Pan = Pan;
	}

	public String getAadharNum() {
		return _AadharNum;
	}

	public void setAadharNum(String AadharNum) {
		_AadharNum = AadharNum;
	}

	public String getCarrerAspect() {
		return _CarrerAspect;
	}

	public void setCarrerAspect(String CarrerAspect) {
		_CarrerAspect = CarrerAspect;
	}

	public String getKeyITSkill() {
		return _KeyITSkill;
	}

	public void setKeyITSkill(String KeyITSkill) {
		_KeyITSkill = KeyITSkill;
	}

	public String getCertfTra() {
		return _CertfTra;
	}

	public void setCertfTra(String CertfTra) {
		_CertfTra = CertfTra;
	}

	public String getEmpyHistory() {
		return _EmpyHistory;
	}

	public void setEmpyHistory(String EmpyHistory) {
		_EmpyHistory = EmpyHistory;
	}

	public String getCoreComp() {
		return _CoreComp;
	}

	public void setCoreComp(String CoreComp) {
		_CoreComp = CoreComp;
	}

	public String getAccomplishment() {
		return _Accomplishment;
	}

	public void setAccomplishment(String Accomplishment) {
		_Accomplishment = Accomplishment;
	}

	public String getAcademics() {
		return _Academics;
	}

	public void setAcademics(String Academics) {
		_Academics = Academics;
	}

	public String getStatus() {
		return _status;
	}

	public void setStatus(String status) {
		_status = status;
	}

	public boolean getFlag() {
		return _flag;
	}

	public boolean isFlag() {
		return _flag;
	}

	public void setFlag(boolean flag) {
		_flag = flag;
	}

	public String getIndexno() {
		return _indexno;
	}

	public void setIndexno(String indexno) {
		_indexno = indexno;
	}

	private long _ResumeId;
	private Date _createDate;
	private Date _modifiedDate;
	private String _RegNum;
	private String _Name;
	private String _Email;
	private String _Mnumber;
	private Date _Dob;
	private String _address_line_1;
	private String _address_line_2;
	private String _address_landmark;
	private String _address_city;
	private String _address_pin;
	private String _address_state;
	private String _perm_address_line_1;
	private String _perm_address_line_2;
	private String _perm_address_landmark;
	private String _perm_address_city;
	private String _perm_address_pin;
	private String _perm_address_state;
	private String _Pan;
	private String _AadharNum;
	private String _CarrerAspect;
	private String _KeyITSkill;
	private String _CertfTra;
	private String _EmpyHistory;
	private String _CoreComp;
	private String _Accomplishment;
	private String _Academics;
	private String _status;
	private boolean _flag;
	private String _indexno;
}