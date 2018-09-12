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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ResumeDtls}.
 * </p>
 *
 * @author    MAH97223
 * @see       ResumeDtls
 * @generated
 */
public class ResumeDtlsWrapper implements ResumeDtls, ModelWrapper<ResumeDtls> {
	public ResumeDtlsWrapper(ResumeDtls resumeDtls) {
		_resumeDtls = resumeDtls;
	}

	public Class<?> getModelClass() {
		return ResumeDtls.class;
	}

	public String getModelClassName() {
		return ResumeDtls.class.getName();
	}

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

	/**
	* Returns the primary key of this resume dtls.
	*
	* @return the primary key of this resume dtls
	*/
	public long getPrimaryKey() {
		return _resumeDtls.getPrimaryKey();
	}

	/**
	* Sets the primary key of this resume dtls.
	*
	* @param primaryKey the primary key of this resume dtls
	*/
	public void setPrimaryKey(long primaryKey) {
		_resumeDtls.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the resume ID of this resume dtls.
	*
	* @return the resume ID of this resume dtls
	*/
	public long getResumeId() {
		return _resumeDtls.getResumeId();
	}

	/**
	* Sets the resume ID of this resume dtls.
	*
	* @param ResumeId the resume ID of this resume dtls
	*/
	public void setResumeId(long ResumeId) {
		_resumeDtls.setResumeId(ResumeId);
	}

	/**
	* Returns the create date of this resume dtls.
	*
	* @return the create date of this resume dtls
	*/
	public java.util.Date getCreateDate() {
		return _resumeDtls.getCreateDate();
	}

	/**
	* Sets the create date of this resume dtls.
	*
	* @param createDate the create date of this resume dtls
	*/
	public void setCreateDate(java.util.Date createDate) {
		_resumeDtls.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this resume dtls.
	*
	* @return the modified date of this resume dtls
	*/
	public java.util.Date getModifiedDate() {
		return _resumeDtls.getModifiedDate();
	}

	/**
	* Sets the modified date of this resume dtls.
	*
	* @param modifiedDate the modified date of this resume dtls
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_resumeDtls.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the reg num of this resume dtls.
	*
	* @return the reg num of this resume dtls
	*/
	public java.lang.String getRegNum() {
		return _resumeDtls.getRegNum();
	}

	/**
	* Sets the reg num of this resume dtls.
	*
	* @param RegNum the reg num of this resume dtls
	*/
	public void setRegNum(java.lang.String RegNum) {
		_resumeDtls.setRegNum(RegNum);
	}

	/**
	* Returns the name of this resume dtls.
	*
	* @return the name of this resume dtls
	*/
	public java.lang.String getName() {
		return _resumeDtls.getName();
	}

	/**
	* Sets the name of this resume dtls.
	*
	* @param Name the name of this resume dtls
	*/
	public void setName(java.lang.String Name) {
		_resumeDtls.setName(Name);
	}

	/**
	* Returns the email of this resume dtls.
	*
	* @return the email of this resume dtls
	*/
	public java.lang.String getEmail() {
		return _resumeDtls.getEmail();
	}

	/**
	* Sets the email of this resume dtls.
	*
	* @param Email the email of this resume dtls
	*/
	public void setEmail(java.lang.String Email) {
		_resumeDtls.setEmail(Email);
	}

	/**
	* Returns the mnumber of this resume dtls.
	*
	* @return the mnumber of this resume dtls
	*/
	public java.lang.String getMnumber() {
		return _resumeDtls.getMnumber();
	}

	/**
	* Sets the mnumber of this resume dtls.
	*
	* @param Mnumber the mnumber of this resume dtls
	*/
	public void setMnumber(java.lang.String Mnumber) {
		_resumeDtls.setMnumber(Mnumber);
	}

	/**
	* Returns the dob of this resume dtls.
	*
	* @return the dob of this resume dtls
	*/
	public java.util.Date getDob() {
		return _resumeDtls.getDob();
	}

	/**
	* Sets the dob of this resume dtls.
	*
	* @param Dob the dob of this resume dtls
	*/
	public void setDob(java.util.Date Dob) {
		_resumeDtls.setDob(Dob);
	}

	/**
	* Returns the address_line_1 of this resume dtls.
	*
	* @return the address_line_1 of this resume dtls
	*/
	public java.lang.String getAddress_line_1() {
		return _resumeDtls.getAddress_line_1();
	}

	/**
	* Sets the address_line_1 of this resume dtls.
	*
	* @param address_line_1 the address_line_1 of this resume dtls
	*/
	public void setAddress_line_1(java.lang.String address_line_1) {
		_resumeDtls.setAddress_line_1(address_line_1);
	}

	/**
	* Returns the address_line_2 of this resume dtls.
	*
	* @return the address_line_2 of this resume dtls
	*/
	public java.lang.String getAddress_line_2() {
		return _resumeDtls.getAddress_line_2();
	}

	/**
	* Sets the address_line_2 of this resume dtls.
	*
	* @param address_line_2 the address_line_2 of this resume dtls
	*/
	public void setAddress_line_2(java.lang.String address_line_2) {
		_resumeDtls.setAddress_line_2(address_line_2);
	}

	/**
	* Returns the address_landmark of this resume dtls.
	*
	* @return the address_landmark of this resume dtls
	*/
	public java.lang.String getAddress_landmark() {
		return _resumeDtls.getAddress_landmark();
	}

	/**
	* Sets the address_landmark of this resume dtls.
	*
	* @param address_landmark the address_landmark of this resume dtls
	*/
	public void setAddress_landmark(java.lang.String address_landmark) {
		_resumeDtls.setAddress_landmark(address_landmark);
	}

	/**
	* Returns the address_city of this resume dtls.
	*
	* @return the address_city of this resume dtls
	*/
	public java.lang.String getAddress_city() {
		return _resumeDtls.getAddress_city();
	}

	/**
	* Sets the address_city of this resume dtls.
	*
	* @param address_city the address_city of this resume dtls
	*/
	public void setAddress_city(java.lang.String address_city) {
		_resumeDtls.setAddress_city(address_city);
	}

	/**
	* Returns the address_pin of this resume dtls.
	*
	* @return the address_pin of this resume dtls
	*/
	public java.lang.String getAddress_pin() {
		return _resumeDtls.getAddress_pin();
	}

	/**
	* Sets the address_pin of this resume dtls.
	*
	* @param address_pin the address_pin of this resume dtls
	*/
	public void setAddress_pin(java.lang.String address_pin) {
		_resumeDtls.setAddress_pin(address_pin);
	}

	/**
	* Returns the address_state of this resume dtls.
	*
	* @return the address_state of this resume dtls
	*/
	public java.lang.String getAddress_state() {
		return _resumeDtls.getAddress_state();
	}

	/**
	* Sets the address_state of this resume dtls.
	*
	* @param address_state the address_state of this resume dtls
	*/
	public void setAddress_state(java.lang.String address_state) {
		_resumeDtls.setAddress_state(address_state);
	}

	/**
	* Returns the perm_address_line_1 of this resume dtls.
	*
	* @return the perm_address_line_1 of this resume dtls
	*/
	public java.lang.String getPerm_address_line_1() {
		return _resumeDtls.getPerm_address_line_1();
	}

	/**
	* Sets the perm_address_line_1 of this resume dtls.
	*
	* @param perm_address_line_1 the perm_address_line_1 of this resume dtls
	*/
	public void setPerm_address_line_1(java.lang.String perm_address_line_1) {
		_resumeDtls.setPerm_address_line_1(perm_address_line_1);
	}

	/**
	* Returns the perm_address_line_2 of this resume dtls.
	*
	* @return the perm_address_line_2 of this resume dtls
	*/
	public java.lang.String getPerm_address_line_2() {
		return _resumeDtls.getPerm_address_line_2();
	}

	/**
	* Sets the perm_address_line_2 of this resume dtls.
	*
	* @param perm_address_line_2 the perm_address_line_2 of this resume dtls
	*/
	public void setPerm_address_line_2(java.lang.String perm_address_line_2) {
		_resumeDtls.setPerm_address_line_2(perm_address_line_2);
	}

	/**
	* Returns the perm_address_landmark of this resume dtls.
	*
	* @return the perm_address_landmark of this resume dtls
	*/
	public java.lang.String getPerm_address_landmark() {
		return _resumeDtls.getPerm_address_landmark();
	}

	/**
	* Sets the perm_address_landmark of this resume dtls.
	*
	* @param perm_address_landmark the perm_address_landmark of this resume dtls
	*/
	public void setPerm_address_landmark(java.lang.String perm_address_landmark) {
		_resumeDtls.setPerm_address_landmark(perm_address_landmark);
	}

	/**
	* Returns the perm_address_city of this resume dtls.
	*
	* @return the perm_address_city of this resume dtls
	*/
	public java.lang.String getPerm_address_city() {
		return _resumeDtls.getPerm_address_city();
	}

	/**
	* Sets the perm_address_city of this resume dtls.
	*
	* @param perm_address_city the perm_address_city of this resume dtls
	*/
	public void setPerm_address_city(java.lang.String perm_address_city) {
		_resumeDtls.setPerm_address_city(perm_address_city);
	}

	/**
	* Returns the perm_address_pin of this resume dtls.
	*
	* @return the perm_address_pin of this resume dtls
	*/
	public java.lang.String getPerm_address_pin() {
		return _resumeDtls.getPerm_address_pin();
	}

	/**
	* Sets the perm_address_pin of this resume dtls.
	*
	* @param perm_address_pin the perm_address_pin of this resume dtls
	*/
	public void setPerm_address_pin(java.lang.String perm_address_pin) {
		_resumeDtls.setPerm_address_pin(perm_address_pin);
	}

	/**
	* Returns the perm_address_state of this resume dtls.
	*
	* @return the perm_address_state of this resume dtls
	*/
	public java.lang.String getPerm_address_state() {
		return _resumeDtls.getPerm_address_state();
	}

	/**
	* Sets the perm_address_state of this resume dtls.
	*
	* @param perm_address_state the perm_address_state of this resume dtls
	*/
	public void setPerm_address_state(java.lang.String perm_address_state) {
		_resumeDtls.setPerm_address_state(perm_address_state);
	}

	/**
	* Returns the pan of this resume dtls.
	*
	* @return the pan of this resume dtls
	*/
	public java.lang.String getPan() {
		return _resumeDtls.getPan();
	}

	/**
	* Sets the pan of this resume dtls.
	*
	* @param Pan the pan of this resume dtls
	*/
	public void setPan(java.lang.String Pan) {
		_resumeDtls.setPan(Pan);
	}

	/**
	* Returns the aadhar num of this resume dtls.
	*
	* @return the aadhar num of this resume dtls
	*/
	public java.lang.String getAadharNum() {
		return _resumeDtls.getAadharNum();
	}

	/**
	* Sets the aadhar num of this resume dtls.
	*
	* @param AadharNum the aadhar num of this resume dtls
	*/
	public void setAadharNum(java.lang.String AadharNum) {
		_resumeDtls.setAadharNum(AadharNum);
	}

	/**
	* Returns the carrer aspect of this resume dtls.
	*
	* @return the carrer aspect of this resume dtls
	*/
	public java.lang.String getCarrerAspect() {
		return _resumeDtls.getCarrerAspect();
	}

	/**
	* Sets the carrer aspect of this resume dtls.
	*
	* @param CarrerAspect the carrer aspect of this resume dtls
	*/
	public void setCarrerAspect(java.lang.String CarrerAspect) {
		_resumeDtls.setCarrerAspect(CarrerAspect);
	}

	/**
	* Returns the key i t skill of this resume dtls.
	*
	* @return the key i t skill of this resume dtls
	*/
	public java.lang.String getKeyITSkill() {
		return _resumeDtls.getKeyITSkill();
	}

	/**
	* Sets the key i t skill of this resume dtls.
	*
	* @param KeyITSkill the key i t skill of this resume dtls
	*/
	public void setKeyITSkill(java.lang.String KeyITSkill) {
		_resumeDtls.setKeyITSkill(KeyITSkill);
	}

	/**
	* Returns the certf tra of this resume dtls.
	*
	* @return the certf tra of this resume dtls
	*/
	public java.lang.String getCertfTra() {
		return _resumeDtls.getCertfTra();
	}

	/**
	* Sets the certf tra of this resume dtls.
	*
	* @param CertfTra the certf tra of this resume dtls
	*/
	public void setCertfTra(java.lang.String CertfTra) {
		_resumeDtls.setCertfTra(CertfTra);
	}

	/**
	* Returns the empy history of this resume dtls.
	*
	* @return the empy history of this resume dtls
	*/
	public java.lang.String getEmpyHistory() {
		return _resumeDtls.getEmpyHistory();
	}

	/**
	* Sets the empy history of this resume dtls.
	*
	* @param EmpyHistory the empy history of this resume dtls
	*/
	public void setEmpyHistory(java.lang.String EmpyHistory) {
		_resumeDtls.setEmpyHistory(EmpyHistory);
	}

	/**
	* Returns the core comp of this resume dtls.
	*
	* @return the core comp of this resume dtls
	*/
	public java.lang.String getCoreComp() {
		return _resumeDtls.getCoreComp();
	}

	/**
	* Sets the core comp of this resume dtls.
	*
	* @param CoreComp the core comp of this resume dtls
	*/
	public void setCoreComp(java.lang.String CoreComp) {
		_resumeDtls.setCoreComp(CoreComp);
	}

	/**
	* Returns the accomplishment of this resume dtls.
	*
	* @return the accomplishment of this resume dtls
	*/
	public java.lang.String getAccomplishment() {
		return _resumeDtls.getAccomplishment();
	}

	/**
	* Sets the accomplishment of this resume dtls.
	*
	* @param Accomplishment the accomplishment of this resume dtls
	*/
	public void setAccomplishment(java.lang.String Accomplishment) {
		_resumeDtls.setAccomplishment(Accomplishment);
	}

	/**
	* Returns the academics of this resume dtls.
	*
	* @return the academics of this resume dtls
	*/
	public java.lang.String getAcademics() {
		return _resumeDtls.getAcademics();
	}

	/**
	* Sets the academics of this resume dtls.
	*
	* @param Academics the academics of this resume dtls
	*/
	public void setAcademics(java.lang.String Academics) {
		_resumeDtls.setAcademics(Academics);
	}

	/**
	* Returns the status of this resume dtls.
	*
	* @return the status of this resume dtls
	*/
	public java.lang.String getStatus() {
		return _resumeDtls.getStatus();
	}

	/**
	* Sets the status of this resume dtls.
	*
	* @param status the status of this resume dtls
	*/
	public void setStatus(java.lang.String status) {
		_resumeDtls.setStatus(status);
	}

	/**
	* Returns the flag of this resume dtls.
	*
	* @return the flag of this resume dtls
	*/
	public boolean getFlag() {
		return _resumeDtls.getFlag();
	}

	/**
	* Returns <code>true</code> if this resume dtls is flag.
	*
	* @return <code>true</code> if this resume dtls is flag; <code>false</code> otherwise
	*/
	public boolean isFlag() {
		return _resumeDtls.isFlag();
	}

	/**
	* Sets whether this resume dtls is flag.
	*
	* @param flag the flag of this resume dtls
	*/
	public void setFlag(boolean flag) {
		_resumeDtls.setFlag(flag);
	}

	/**
	* Returns the indexno of this resume dtls.
	*
	* @return the indexno of this resume dtls
	*/
	public java.lang.String getIndexno() {
		return _resumeDtls.getIndexno();
	}

	/**
	* Sets the indexno of this resume dtls.
	*
	* @param indexno the indexno of this resume dtls
	*/
	public void setIndexno(java.lang.String indexno) {
		_resumeDtls.setIndexno(indexno);
	}

	public boolean isNew() {
		return _resumeDtls.isNew();
	}

	public void setNew(boolean n) {
		_resumeDtls.setNew(n);
	}

	public boolean isCachedModel() {
		return _resumeDtls.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_resumeDtls.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _resumeDtls.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _resumeDtls.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_resumeDtls.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _resumeDtls.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_resumeDtls.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ResumeDtlsWrapper((ResumeDtls)_resumeDtls.clone());
	}

	public int compareTo(com.sbi.StartUp.model.ResumeDtls resumeDtls) {
		return _resumeDtls.compareTo(resumeDtls);
	}

	@Override
	public int hashCode() {
		return _resumeDtls.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.sbi.StartUp.model.ResumeDtls> toCacheModel() {
		return _resumeDtls.toCacheModel();
	}

	public com.sbi.StartUp.model.ResumeDtls toEscapedModel() {
		return new ResumeDtlsWrapper(_resumeDtls.toEscapedModel());
	}

	public com.sbi.StartUp.model.ResumeDtls toUnescapedModel() {
		return new ResumeDtlsWrapper(_resumeDtls.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _resumeDtls.toString();
	}

	public java.lang.String toXmlString() {
		return _resumeDtls.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_resumeDtls.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ResumeDtlsWrapper)) {
			return false;
		}

		ResumeDtlsWrapper resumeDtlsWrapper = (ResumeDtlsWrapper)obj;

		if (Validator.equals(_resumeDtls, resumeDtlsWrapper._resumeDtls)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public ResumeDtls getWrappedResumeDtls() {
		return _resumeDtls;
	}

	public ResumeDtls getWrappedModel() {
		return _resumeDtls;
	}

	public void resetOriginalValues() {
		_resumeDtls.resetOriginalValues();
	}

	private ResumeDtls _resumeDtls;
}