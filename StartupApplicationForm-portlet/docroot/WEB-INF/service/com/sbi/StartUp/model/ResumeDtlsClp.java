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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.sbi.StartUp.service.ClpSerializer;
import com.sbi.StartUp.service.ResumeDtlsLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author MAH97223
 */
public class ResumeDtlsClp extends BaseModelImpl<ResumeDtls>
	implements ResumeDtls {
	public ResumeDtlsClp() {
	}

	public Class<?> getModelClass() {
		return ResumeDtls.class;
	}

	public String getModelClassName() {
		return ResumeDtls.class.getName();
	}

	public long getPrimaryKey() {
		return _ResumeId;
	}

	public void setPrimaryKey(long primaryKey) {
		setResumeId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_ResumeId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("ResumeId", getResumeId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("RegNum", getRegNum());
		attributes.put("Name", getName());
		attributes.put("Email", getEmail());
		attributes.put("Mnumber", getMnumber());
		attributes.put("Dob", getDob());
		attributes.put("address_line_1", getAddress_line_1());
		attributes.put("address_line_2", getAddress_line_2());
		attributes.put("address_landmark", getAddress_landmark());
		attributes.put("address_city", getAddress_city());
		attributes.put("address_pin", getAddress_pin());
		attributes.put("address_state", getAddress_state());
		attributes.put("perm_address_line_1", getPerm_address_line_1());
		attributes.put("perm_address_line_2", getPerm_address_line_2());
		attributes.put("perm_address_landmark", getPerm_address_landmark());
		attributes.put("perm_address_city", getPerm_address_city());
		attributes.put("perm_address_pin", getPerm_address_pin());
		attributes.put("perm_address_state", getPerm_address_state());
		attributes.put("Pan", getPan());
		attributes.put("AadharNum", getAadharNum());
		attributes.put("CarrerAspect", getCarrerAspect());
		attributes.put("KeyITSkill", getKeyITSkill());
		attributes.put("CertfTra", getCertfTra());
		attributes.put("EmpyHistory", getEmpyHistory());
		attributes.put("CoreComp", getCoreComp());
		attributes.put("Accomplishment", getAccomplishment());
		attributes.put("Academics", getAcademics());
		attributes.put("status", getStatus());
		attributes.put("flag", getFlag());
		attributes.put("indexno", getIndexno());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long ResumeId = (Long)attributes.get("ResumeId");

		if (ResumeId != null) {
			setResumeId(ResumeId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String RegNum = (String)attributes.get("RegNum");

		if (RegNum != null) {
			setRegNum(RegNum);
		}

		String Name = (String)attributes.get("Name");

		if (Name != null) {
			setName(Name);
		}

		String Email = (String)attributes.get("Email");

		if (Email != null) {
			setEmail(Email);
		}

		String Mnumber = (String)attributes.get("Mnumber");

		if (Mnumber != null) {
			setMnumber(Mnumber);
		}

		Date Dob = (Date)attributes.get("Dob");

		if (Dob != null) {
			setDob(Dob);
		}

		String address_line_1 = (String)attributes.get("address_line_1");

		if (address_line_1 != null) {
			setAddress_line_1(address_line_1);
		}

		String address_line_2 = (String)attributes.get("address_line_2");

		if (address_line_2 != null) {
			setAddress_line_2(address_line_2);
		}

		String address_landmark = (String)attributes.get("address_landmark");

		if (address_landmark != null) {
			setAddress_landmark(address_landmark);
		}

		String address_city = (String)attributes.get("address_city");

		if (address_city != null) {
			setAddress_city(address_city);
		}

		String address_pin = (String)attributes.get("address_pin");

		if (address_pin != null) {
			setAddress_pin(address_pin);
		}

		String address_state = (String)attributes.get("address_state");

		if (address_state != null) {
			setAddress_state(address_state);
		}

		String perm_address_line_1 = (String)attributes.get(
				"perm_address_line_1");

		if (perm_address_line_1 != null) {
			setPerm_address_line_1(perm_address_line_1);
		}

		String perm_address_line_2 = (String)attributes.get(
				"perm_address_line_2");

		if (perm_address_line_2 != null) {
			setPerm_address_line_2(perm_address_line_2);
		}

		String perm_address_landmark = (String)attributes.get(
				"perm_address_landmark");

		if (perm_address_landmark != null) {
			setPerm_address_landmark(perm_address_landmark);
		}

		String perm_address_city = (String)attributes.get("perm_address_city");

		if (perm_address_city != null) {
			setPerm_address_city(perm_address_city);
		}

		String perm_address_pin = (String)attributes.get("perm_address_pin");

		if (perm_address_pin != null) {
			setPerm_address_pin(perm_address_pin);
		}

		String perm_address_state = (String)attributes.get("perm_address_state");

		if (perm_address_state != null) {
			setPerm_address_state(perm_address_state);
		}

		String Pan = (String)attributes.get("Pan");

		if (Pan != null) {
			setPan(Pan);
		}

		String AadharNum = (String)attributes.get("AadharNum");

		if (AadharNum != null) {
			setAadharNum(AadharNum);
		}

		String CarrerAspect = (String)attributes.get("CarrerAspect");

		if (CarrerAspect != null) {
			setCarrerAspect(CarrerAspect);
		}

		String KeyITSkill = (String)attributes.get("KeyITSkill");

		if (KeyITSkill != null) {
			setKeyITSkill(KeyITSkill);
		}

		String CertfTra = (String)attributes.get("CertfTra");

		if (CertfTra != null) {
			setCertfTra(CertfTra);
		}

		String EmpyHistory = (String)attributes.get("EmpyHistory");

		if (EmpyHistory != null) {
			setEmpyHistory(EmpyHistory);
		}

		String CoreComp = (String)attributes.get("CoreComp");

		if (CoreComp != null) {
			setCoreComp(CoreComp);
		}

		String Accomplishment = (String)attributes.get("Accomplishment");

		if (Accomplishment != null) {
			setAccomplishment(Accomplishment);
		}

		String Academics = (String)attributes.get("Academics");

		if (Academics != null) {
			setAcademics(Academics);
		}

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Boolean flag = (Boolean)attributes.get("flag");

		if (flag != null) {
			setFlag(flag);
		}

		String indexno = (String)attributes.get("indexno");

		if (indexno != null) {
			setIndexno(indexno);
		}
	}

	public long getResumeId() {
		return _ResumeId;
	}

	public void setResumeId(long ResumeId) {
		_ResumeId = ResumeId;

		if (_resumeDtlsRemoteModel != null) {
			try {
				Class<?> clazz = _resumeDtlsRemoteModel.getClass();

				Method method = clazz.getMethod("setResumeId", long.class);

				method.invoke(_resumeDtlsRemoteModel, ResumeId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;

		if (_resumeDtlsRemoteModel != null) {
			try {
				Class<?> clazz = _resumeDtlsRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_resumeDtlsRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;

		if (_resumeDtlsRemoteModel != null) {
			try {
				Class<?> clazz = _resumeDtlsRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_resumeDtlsRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getRegNum() {
		return _RegNum;
	}

	public void setRegNum(String RegNum) {
		_RegNum = RegNum;

		if (_resumeDtlsRemoteModel != null) {
			try {
				Class<?> clazz = _resumeDtlsRemoteModel.getClass();

				Method method = clazz.getMethod("setRegNum", String.class);

				method.invoke(_resumeDtlsRemoteModel, RegNum);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getName() {
		return _Name;
	}

	public void setName(String Name) {
		_Name = Name;

		if (_resumeDtlsRemoteModel != null) {
			try {
				Class<?> clazz = _resumeDtlsRemoteModel.getClass();

				Method method = clazz.getMethod("setName", String.class);

				method.invoke(_resumeDtlsRemoteModel, Name);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getEmail() {
		return _Email;
	}

	public void setEmail(String Email) {
		_Email = Email;

		if (_resumeDtlsRemoteModel != null) {
			try {
				Class<?> clazz = _resumeDtlsRemoteModel.getClass();

				Method method = clazz.getMethod("setEmail", String.class);

				method.invoke(_resumeDtlsRemoteModel, Email);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getMnumber() {
		return _Mnumber;
	}

	public void setMnumber(String Mnumber) {
		_Mnumber = Mnumber;

		if (_resumeDtlsRemoteModel != null) {
			try {
				Class<?> clazz = _resumeDtlsRemoteModel.getClass();

				Method method = clazz.getMethod("setMnumber", String.class);

				method.invoke(_resumeDtlsRemoteModel, Mnumber);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public Date getDob() {
		return _Dob;
	}

	public void setDob(Date Dob) {
		_Dob = Dob;

		if (_resumeDtlsRemoteModel != null) {
			try {
				Class<?> clazz = _resumeDtlsRemoteModel.getClass();

				Method method = clazz.getMethod("setDob", Date.class);

				method.invoke(_resumeDtlsRemoteModel, Dob);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getAddress_line_1() {
		return _address_line_1;
	}

	public void setAddress_line_1(String address_line_1) {
		_address_line_1 = address_line_1;

		if (_resumeDtlsRemoteModel != null) {
			try {
				Class<?> clazz = _resumeDtlsRemoteModel.getClass();

				Method method = clazz.getMethod("setAddress_line_1",
						String.class);

				method.invoke(_resumeDtlsRemoteModel, address_line_1);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getAddress_line_2() {
		return _address_line_2;
	}

	public void setAddress_line_2(String address_line_2) {
		_address_line_2 = address_line_2;

		if (_resumeDtlsRemoteModel != null) {
			try {
				Class<?> clazz = _resumeDtlsRemoteModel.getClass();

				Method method = clazz.getMethod("setAddress_line_2",
						String.class);

				method.invoke(_resumeDtlsRemoteModel, address_line_2);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getAddress_landmark() {
		return _address_landmark;
	}

	public void setAddress_landmark(String address_landmark) {
		_address_landmark = address_landmark;

		if (_resumeDtlsRemoteModel != null) {
			try {
				Class<?> clazz = _resumeDtlsRemoteModel.getClass();

				Method method = clazz.getMethod("setAddress_landmark",
						String.class);

				method.invoke(_resumeDtlsRemoteModel, address_landmark);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getAddress_city() {
		return _address_city;
	}

	public void setAddress_city(String address_city) {
		_address_city = address_city;

		if (_resumeDtlsRemoteModel != null) {
			try {
				Class<?> clazz = _resumeDtlsRemoteModel.getClass();

				Method method = clazz.getMethod("setAddress_city", String.class);

				method.invoke(_resumeDtlsRemoteModel, address_city);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getAddress_pin() {
		return _address_pin;
	}

	public void setAddress_pin(String address_pin) {
		_address_pin = address_pin;

		if (_resumeDtlsRemoteModel != null) {
			try {
				Class<?> clazz = _resumeDtlsRemoteModel.getClass();

				Method method = clazz.getMethod("setAddress_pin", String.class);

				method.invoke(_resumeDtlsRemoteModel, address_pin);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getAddress_state() {
		return _address_state;
	}

	public void setAddress_state(String address_state) {
		_address_state = address_state;

		if (_resumeDtlsRemoteModel != null) {
			try {
				Class<?> clazz = _resumeDtlsRemoteModel.getClass();

				Method method = clazz.getMethod("setAddress_state", String.class);

				method.invoke(_resumeDtlsRemoteModel, address_state);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getPerm_address_line_1() {
		return _perm_address_line_1;
	}

	public void setPerm_address_line_1(String perm_address_line_1) {
		_perm_address_line_1 = perm_address_line_1;

		if (_resumeDtlsRemoteModel != null) {
			try {
				Class<?> clazz = _resumeDtlsRemoteModel.getClass();

				Method method = clazz.getMethod("setPerm_address_line_1",
						String.class);

				method.invoke(_resumeDtlsRemoteModel, perm_address_line_1);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getPerm_address_line_2() {
		return _perm_address_line_2;
	}

	public void setPerm_address_line_2(String perm_address_line_2) {
		_perm_address_line_2 = perm_address_line_2;

		if (_resumeDtlsRemoteModel != null) {
			try {
				Class<?> clazz = _resumeDtlsRemoteModel.getClass();

				Method method = clazz.getMethod("setPerm_address_line_2",
						String.class);

				method.invoke(_resumeDtlsRemoteModel, perm_address_line_2);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getPerm_address_landmark() {
		return _perm_address_landmark;
	}

	public void setPerm_address_landmark(String perm_address_landmark) {
		_perm_address_landmark = perm_address_landmark;

		if (_resumeDtlsRemoteModel != null) {
			try {
				Class<?> clazz = _resumeDtlsRemoteModel.getClass();

				Method method = clazz.getMethod("setPerm_address_landmark",
						String.class);

				method.invoke(_resumeDtlsRemoteModel, perm_address_landmark);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getPerm_address_city() {
		return _perm_address_city;
	}

	public void setPerm_address_city(String perm_address_city) {
		_perm_address_city = perm_address_city;

		if (_resumeDtlsRemoteModel != null) {
			try {
				Class<?> clazz = _resumeDtlsRemoteModel.getClass();

				Method method = clazz.getMethod("setPerm_address_city",
						String.class);

				method.invoke(_resumeDtlsRemoteModel, perm_address_city);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getPerm_address_pin() {
		return _perm_address_pin;
	}

	public void setPerm_address_pin(String perm_address_pin) {
		_perm_address_pin = perm_address_pin;

		if (_resumeDtlsRemoteModel != null) {
			try {
				Class<?> clazz = _resumeDtlsRemoteModel.getClass();

				Method method = clazz.getMethod("setPerm_address_pin",
						String.class);

				method.invoke(_resumeDtlsRemoteModel, perm_address_pin);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getPerm_address_state() {
		return _perm_address_state;
	}

	public void setPerm_address_state(String perm_address_state) {
		_perm_address_state = perm_address_state;

		if (_resumeDtlsRemoteModel != null) {
			try {
				Class<?> clazz = _resumeDtlsRemoteModel.getClass();

				Method method = clazz.getMethod("setPerm_address_state",
						String.class);

				method.invoke(_resumeDtlsRemoteModel, perm_address_state);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getPan() {
		return _Pan;
	}

	public void setPan(String Pan) {
		_Pan = Pan;

		if (_resumeDtlsRemoteModel != null) {
			try {
				Class<?> clazz = _resumeDtlsRemoteModel.getClass();

				Method method = clazz.getMethod("setPan", String.class);

				method.invoke(_resumeDtlsRemoteModel, Pan);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getAadharNum() {
		return _AadharNum;
	}

	public void setAadharNum(String AadharNum) {
		_AadharNum = AadharNum;

		if (_resumeDtlsRemoteModel != null) {
			try {
				Class<?> clazz = _resumeDtlsRemoteModel.getClass();

				Method method = clazz.getMethod("setAadharNum", String.class);

				method.invoke(_resumeDtlsRemoteModel, AadharNum);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getCarrerAspect() {
		return _CarrerAspect;
	}

	public void setCarrerAspect(String CarrerAspect) {
		_CarrerAspect = CarrerAspect;

		if (_resumeDtlsRemoteModel != null) {
			try {
				Class<?> clazz = _resumeDtlsRemoteModel.getClass();

				Method method = clazz.getMethod("setCarrerAspect", String.class);

				method.invoke(_resumeDtlsRemoteModel, CarrerAspect);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getKeyITSkill() {
		return _KeyITSkill;
	}

	public void setKeyITSkill(String KeyITSkill) {
		_KeyITSkill = KeyITSkill;

		if (_resumeDtlsRemoteModel != null) {
			try {
				Class<?> clazz = _resumeDtlsRemoteModel.getClass();

				Method method = clazz.getMethod("setKeyITSkill", String.class);

				method.invoke(_resumeDtlsRemoteModel, KeyITSkill);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getCertfTra() {
		return _CertfTra;
	}

	public void setCertfTra(String CertfTra) {
		_CertfTra = CertfTra;

		if (_resumeDtlsRemoteModel != null) {
			try {
				Class<?> clazz = _resumeDtlsRemoteModel.getClass();

				Method method = clazz.getMethod("setCertfTra", String.class);

				method.invoke(_resumeDtlsRemoteModel, CertfTra);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getEmpyHistory() {
		return _EmpyHistory;
	}

	public void setEmpyHistory(String EmpyHistory) {
		_EmpyHistory = EmpyHistory;

		if (_resumeDtlsRemoteModel != null) {
			try {
				Class<?> clazz = _resumeDtlsRemoteModel.getClass();

				Method method = clazz.getMethod("setEmpyHistory", String.class);

				method.invoke(_resumeDtlsRemoteModel, EmpyHistory);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getCoreComp() {
		return _CoreComp;
	}

	public void setCoreComp(String CoreComp) {
		_CoreComp = CoreComp;

		if (_resumeDtlsRemoteModel != null) {
			try {
				Class<?> clazz = _resumeDtlsRemoteModel.getClass();

				Method method = clazz.getMethod("setCoreComp", String.class);

				method.invoke(_resumeDtlsRemoteModel, CoreComp);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getAccomplishment() {
		return _Accomplishment;
	}

	public void setAccomplishment(String Accomplishment) {
		_Accomplishment = Accomplishment;

		if (_resumeDtlsRemoteModel != null) {
			try {
				Class<?> clazz = _resumeDtlsRemoteModel.getClass();

				Method method = clazz.getMethod("setAccomplishment",
						String.class);

				method.invoke(_resumeDtlsRemoteModel, Accomplishment);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getAcademics() {
		return _Academics;
	}

	public void setAcademics(String Academics) {
		_Academics = Academics;

		if (_resumeDtlsRemoteModel != null) {
			try {
				Class<?> clazz = _resumeDtlsRemoteModel.getClass();

				Method method = clazz.getMethod("setAcademics", String.class);

				method.invoke(_resumeDtlsRemoteModel, Academics);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getStatus() {
		return _status;
	}

	public void setStatus(String status) {
		_status = status;

		if (_resumeDtlsRemoteModel != null) {
			try {
				Class<?> clazz = _resumeDtlsRemoteModel.getClass();

				Method method = clazz.getMethod("setStatus", String.class);

				method.invoke(_resumeDtlsRemoteModel, status);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public boolean getFlag() {
		return _flag;
	}

	public boolean isFlag() {
		return _flag;
	}

	public void setFlag(boolean flag) {
		_flag = flag;

		if (_resumeDtlsRemoteModel != null) {
			try {
				Class<?> clazz = _resumeDtlsRemoteModel.getClass();

				Method method = clazz.getMethod("setFlag", boolean.class);

				method.invoke(_resumeDtlsRemoteModel, flag);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getIndexno() {
		return _indexno;
	}

	public void setIndexno(String indexno) {
		_indexno = indexno;

		if (_resumeDtlsRemoteModel != null) {
			try {
				Class<?> clazz = _resumeDtlsRemoteModel.getClass();

				Method method = clazz.getMethod("setIndexno", String.class);

				method.invoke(_resumeDtlsRemoteModel, indexno);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getResumeDtlsRemoteModel() {
		return _resumeDtlsRemoteModel;
	}

	public void setResumeDtlsRemoteModel(BaseModel<?> resumeDtlsRemoteModel) {
		_resumeDtlsRemoteModel = resumeDtlsRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _resumeDtlsRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_resumeDtlsRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			ResumeDtlsLocalServiceUtil.addResumeDtls(this);
		}
		else {
			ResumeDtlsLocalServiceUtil.updateResumeDtls(this);
		}
	}

	@Override
	public ResumeDtls toEscapedModel() {
		return (ResumeDtls)ProxyUtil.newProxyInstance(ResumeDtls.class.getClassLoader(),
			new Class[] { ResumeDtls.class }, new AutoEscapeBeanHandler(this));
	}

	public ResumeDtls toUnescapedModel() {
		return this;
	}

	@Override
	public Object clone() {
		ResumeDtlsClp clone = new ResumeDtlsClp();

		clone.setResumeId(getResumeId());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setRegNum(getRegNum());
		clone.setName(getName());
		clone.setEmail(getEmail());
		clone.setMnumber(getMnumber());
		clone.setDob(getDob());
		clone.setAddress_line_1(getAddress_line_1());
		clone.setAddress_line_2(getAddress_line_2());
		clone.setAddress_landmark(getAddress_landmark());
		clone.setAddress_city(getAddress_city());
		clone.setAddress_pin(getAddress_pin());
		clone.setAddress_state(getAddress_state());
		clone.setPerm_address_line_1(getPerm_address_line_1());
		clone.setPerm_address_line_2(getPerm_address_line_2());
		clone.setPerm_address_landmark(getPerm_address_landmark());
		clone.setPerm_address_city(getPerm_address_city());
		clone.setPerm_address_pin(getPerm_address_pin());
		clone.setPerm_address_state(getPerm_address_state());
		clone.setPan(getPan());
		clone.setAadharNum(getAadharNum());
		clone.setCarrerAspect(getCarrerAspect());
		clone.setKeyITSkill(getKeyITSkill());
		clone.setCertfTra(getCertfTra());
		clone.setEmpyHistory(getEmpyHistory());
		clone.setCoreComp(getCoreComp());
		clone.setAccomplishment(getAccomplishment());
		clone.setAcademics(getAcademics());
		clone.setStatus(getStatus());
		clone.setFlag(getFlag());
		clone.setIndexno(getIndexno());

		return clone;
	}

	public int compareTo(ResumeDtls resumeDtls) {
		int value = 0;

		value = DateUtil.compareTo(getCreateDate(), resumeDtls.getCreateDate());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ResumeDtlsClp)) {
			return false;
		}

		ResumeDtlsClp resumeDtls = (ResumeDtlsClp)obj;

		long primaryKey = resumeDtls.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(65);

		sb.append("{ResumeId=");
		sb.append(getResumeId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", RegNum=");
		sb.append(getRegNum());
		sb.append(", Name=");
		sb.append(getName());
		sb.append(", Email=");
		sb.append(getEmail());
		sb.append(", Mnumber=");
		sb.append(getMnumber());
		sb.append(", Dob=");
		sb.append(getDob());
		sb.append(", address_line_1=");
		sb.append(getAddress_line_1());
		sb.append(", address_line_2=");
		sb.append(getAddress_line_2());
		sb.append(", address_landmark=");
		sb.append(getAddress_landmark());
		sb.append(", address_city=");
		sb.append(getAddress_city());
		sb.append(", address_pin=");
		sb.append(getAddress_pin());
		sb.append(", address_state=");
		sb.append(getAddress_state());
		sb.append(", perm_address_line_1=");
		sb.append(getPerm_address_line_1());
		sb.append(", perm_address_line_2=");
		sb.append(getPerm_address_line_2());
		sb.append(", perm_address_landmark=");
		sb.append(getPerm_address_landmark());
		sb.append(", perm_address_city=");
		sb.append(getPerm_address_city());
		sb.append(", perm_address_pin=");
		sb.append(getPerm_address_pin());
		sb.append(", perm_address_state=");
		sb.append(getPerm_address_state());
		sb.append(", Pan=");
		sb.append(getPan());
		sb.append(", AadharNum=");
		sb.append(getAadharNum());
		sb.append(", CarrerAspect=");
		sb.append(getCarrerAspect());
		sb.append(", KeyITSkill=");
		sb.append(getKeyITSkill());
		sb.append(", CertfTra=");
		sb.append(getCertfTra());
		sb.append(", EmpyHistory=");
		sb.append(getEmpyHistory());
		sb.append(", CoreComp=");
		sb.append(getCoreComp());
		sb.append(", Accomplishment=");
		sb.append(getAccomplishment());
		sb.append(", Academics=");
		sb.append(getAcademics());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", flag=");
		sb.append(getFlag());
		sb.append(", indexno=");
		sb.append(getIndexno());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(100);

		sb.append("<model><model-name>");
		sb.append("com.sbi.StartUp.model.ResumeDtls");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>ResumeId</column-name><column-value><![CDATA[");
		sb.append(getResumeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>RegNum</column-name><column-value><![CDATA[");
		sb.append(getRegNum());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Email</column-name><column-value><![CDATA[");
		sb.append(getEmail());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Mnumber</column-name><column-value><![CDATA[");
		sb.append(getMnumber());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Dob</column-name><column-value><![CDATA[");
		sb.append(getDob());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>address_line_1</column-name><column-value><![CDATA[");
		sb.append(getAddress_line_1());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>address_line_2</column-name><column-value><![CDATA[");
		sb.append(getAddress_line_2());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>address_landmark</column-name><column-value><![CDATA[");
		sb.append(getAddress_landmark());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>address_city</column-name><column-value><![CDATA[");
		sb.append(getAddress_city());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>address_pin</column-name><column-value><![CDATA[");
		sb.append(getAddress_pin());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>address_state</column-name><column-value><![CDATA[");
		sb.append(getAddress_state());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>perm_address_line_1</column-name><column-value><![CDATA[");
		sb.append(getPerm_address_line_1());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>perm_address_line_2</column-name><column-value><![CDATA[");
		sb.append(getPerm_address_line_2());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>perm_address_landmark</column-name><column-value><![CDATA[");
		sb.append(getPerm_address_landmark());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>perm_address_city</column-name><column-value><![CDATA[");
		sb.append(getPerm_address_city());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>perm_address_pin</column-name><column-value><![CDATA[");
		sb.append(getPerm_address_pin());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>perm_address_state</column-name><column-value><![CDATA[");
		sb.append(getPerm_address_state());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Pan</column-name><column-value><![CDATA[");
		sb.append(getPan());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>AadharNum</column-name><column-value><![CDATA[");
		sb.append(getAadharNum());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>CarrerAspect</column-name><column-value><![CDATA[");
		sb.append(getCarrerAspect());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>KeyITSkill</column-name><column-value><![CDATA[");
		sb.append(getKeyITSkill());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>CertfTra</column-name><column-value><![CDATA[");
		sb.append(getCertfTra());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>EmpyHistory</column-name><column-value><![CDATA[");
		sb.append(getEmpyHistory());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>CoreComp</column-name><column-value><![CDATA[");
		sb.append(getCoreComp());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Accomplishment</column-name><column-value><![CDATA[");
		sb.append(getAccomplishment());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Academics</column-name><column-value><![CDATA[");
		sb.append(getAcademics());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>flag</column-name><column-value><![CDATA[");
		sb.append(getFlag());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>indexno</column-name><column-value><![CDATA[");
		sb.append(getIndexno());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
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
	private BaseModel<?> _resumeDtlsRemoteModel;
}