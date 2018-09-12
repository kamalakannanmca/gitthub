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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the ResumeDtls service. Represents a row in the &quot;SbiStartUp_ResumeDtls&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.sbi.StartUp.model.impl.ResumeDtlsModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.sbi.StartUp.model.impl.ResumeDtlsImpl}.
 * </p>
 *
 * @author MAH97223
 * @see ResumeDtls
 * @see com.sbi.StartUp.model.impl.ResumeDtlsImpl
 * @see com.sbi.StartUp.model.impl.ResumeDtlsModelImpl
 * @generated
 */
public interface ResumeDtlsModel extends BaseModel<ResumeDtls> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a resume dtls model instance should use the {@link ResumeDtls} interface instead.
	 */

	/**
	 * Returns the primary key of this resume dtls.
	 *
	 * @return the primary key of this resume dtls
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this resume dtls.
	 *
	 * @param primaryKey the primary key of this resume dtls
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the resume ID of this resume dtls.
	 *
	 * @return the resume ID of this resume dtls
	 */
	public long getResumeId();

	/**
	 * Sets the resume ID of this resume dtls.
	 *
	 * @param ResumeId the resume ID of this resume dtls
	 */
	public void setResumeId(long ResumeId);

	/**
	 * Returns the create date of this resume dtls.
	 *
	 * @return the create date of this resume dtls
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this resume dtls.
	 *
	 * @param createDate the create date of this resume dtls
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this resume dtls.
	 *
	 * @return the modified date of this resume dtls
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this resume dtls.
	 *
	 * @param modifiedDate the modified date of this resume dtls
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the reg num of this resume dtls.
	 *
	 * @return the reg num of this resume dtls
	 */
	@AutoEscape
	public String getRegNum();

	/**
	 * Sets the reg num of this resume dtls.
	 *
	 * @param RegNum the reg num of this resume dtls
	 */
	public void setRegNum(String RegNum);

	/**
	 * Returns the name of this resume dtls.
	 *
	 * @return the name of this resume dtls
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this resume dtls.
	 *
	 * @param Name the name of this resume dtls
	 */
	public void setName(String Name);

	/**
	 * Returns the email of this resume dtls.
	 *
	 * @return the email of this resume dtls
	 */
	@AutoEscape
	public String getEmail();

	/**
	 * Sets the email of this resume dtls.
	 *
	 * @param Email the email of this resume dtls
	 */
	public void setEmail(String Email);

	/**
	 * Returns the mnumber of this resume dtls.
	 *
	 * @return the mnumber of this resume dtls
	 */
	@AutoEscape
	public String getMnumber();

	/**
	 * Sets the mnumber of this resume dtls.
	 *
	 * @param Mnumber the mnumber of this resume dtls
	 */
	public void setMnumber(String Mnumber);

	/**
	 * Returns the dob of this resume dtls.
	 *
	 * @return the dob of this resume dtls
	 */
	public Date getDob();

	/**
	 * Sets the dob of this resume dtls.
	 *
	 * @param Dob the dob of this resume dtls
	 */
	public void setDob(Date Dob);

	/**
	 * Returns the address_line_1 of this resume dtls.
	 *
	 * @return the address_line_1 of this resume dtls
	 */
	@AutoEscape
	public String getAddress_line_1();

	/**
	 * Sets the address_line_1 of this resume dtls.
	 *
	 * @param address_line_1 the address_line_1 of this resume dtls
	 */
	public void setAddress_line_1(String address_line_1);

	/**
	 * Returns the address_line_2 of this resume dtls.
	 *
	 * @return the address_line_2 of this resume dtls
	 */
	@AutoEscape
	public String getAddress_line_2();

	/**
	 * Sets the address_line_2 of this resume dtls.
	 *
	 * @param address_line_2 the address_line_2 of this resume dtls
	 */
	public void setAddress_line_2(String address_line_2);

	/**
	 * Returns the address_landmark of this resume dtls.
	 *
	 * @return the address_landmark of this resume dtls
	 */
	@AutoEscape
	public String getAddress_landmark();

	/**
	 * Sets the address_landmark of this resume dtls.
	 *
	 * @param address_landmark the address_landmark of this resume dtls
	 */
	public void setAddress_landmark(String address_landmark);

	/**
	 * Returns the address_city of this resume dtls.
	 *
	 * @return the address_city of this resume dtls
	 */
	@AutoEscape
	public String getAddress_city();

	/**
	 * Sets the address_city of this resume dtls.
	 *
	 * @param address_city the address_city of this resume dtls
	 */
	public void setAddress_city(String address_city);

	/**
	 * Returns the address_pin of this resume dtls.
	 *
	 * @return the address_pin of this resume dtls
	 */
	@AutoEscape
	public String getAddress_pin();

	/**
	 * Sets the address_pin of this resume dtls.
	 *
	 * @param address_pin the address_pin of this resume dtls
	 */
	public void setAddress_pin(String address_pin);

	/**
	 * Returns the address_state of this resume dtls.
	 *
	 * @return the address_state of this resume dtls
	 */
	@AutoEscape
	public String getAddress_state();

	/**
	 * Sets the address_state of this resume dtls.
	 *
	 * @param address_state the address_state of this resume dtls
	 */
	public void setAddress_state(String address_state);

	/**
	 * Returns the perm_address_line_1 of this resume dtls.
	 *
	 * @return the perm_address_line_1 of this resume dtls
	 */
	@AutoEscape
	public String getPerm_address_line_1();

	/**
	 * Sets the perm_address_line_1 of this resume dtls.
	 *
	 * @param perm_address_line_1 the perm_address_line_1 of this resume dtls
	 */
	public void setPerm_address_line_1(String perm_address_line_1);

	/**
	 * Returns the perm_address_line_2 of this resume dtls.
	 *
	 * @return the perm_address_line_2 of this resume dtls
	 */
	@AutoEscape
	public String getPerm_address_line_2();

	/**
	 * Sets the perm_address_line_2 of this resume dtls.
	 *
	 * @param perm_address_line_2 the perm_address_line_2 of this resume dtls
	 */
	public void setPerm_address_line_2(String perm_address_line_2);

	/**
	 * Returns the perm_address_landmark of this resume dtls.
	 *
	 * @return the perm_address_landmark of this resume dtls
	 */
	@AutoEscape
	public String getPerm_address_landmark();

	/**
	 * Sets the perm_address_landmark of this resume dtls.
	 *
	 * @param perm_address_landmark the perm_address_landmark of this resume dtls
	 */
	public void setPerm_address_landmark(String perm_address_landmark);

	/**
	 * Returns the perm_address_city of this resume dtls.
	 *
	 * @return the perm_address_city of this resume dtls
	 */
	@AutoEscape
	public String getPerm_address_city();

	/**
	 * Sets the perm_address_city of this resume dtls.
	 *
	 * @param perm_address_city the perm_address_city of this resume dtls
	 */
	public void setPerm_address_city(String perm_address_city);

	/**
	 * Returns the perm_address_pin of this resume dtls.
	 *
	 * @return the perm_address_pin of this resume dtls
	 */
	@AutoEscape
	public String getPerm_address_pin();

	/**
	 * Sets the perm_address_pin of this resume dtls.
	 *
	 * @param perm_address_pin the perm_address_pin of this resume dtls
	 */
	public void setPerm_address_pin(String perm_address_pin);

	/**
	 * Returns the perm_address_state of this resume dtls.
	 *
	 * @return the perm_address_state of this resume dtls
	 */
	@AutoEscape
	public String getPerm_address_state();

	/**
	 * Sets the perm_address_state of this resume dtls.
	 *
	 * @param perm_address_state the perm_address_state of this resume dtls
	 */
	public void setPerm_address_state(String perm_address_state);

	/**
	 * Returns the pan of this resume dtls.
	 *
	 * @return the pan of this resume dtls
	 */
	@AutoEscape
	public String getPan();

	/**
	 * Sets the pan of this resume dtls.
	 *
	 * @param Pan the pan of this resume dtls
	 */
	public void setPan(String Pan);

	/**
	 * Returns the aadhar num of this resume dtls.
	 *
	 * @return the aadhar num of this resume dtls
	 */
	@AutoEscape
	public String getAadharNum();

	/**
	 * Sets the aadhar num of this resume dtls.
	 *
	 * @param AadharNum the aadhar num of this resume dtls
	 */
	public void setAadharNum(String AadharNum);

	/**
	 * Returns the carrer aspect of this resume dtls.
	 *
	 * @return the carrer aspect of this resume dtls
	 */
	@AutoEscape
	public String getCarrerAspect();

	/**
	 * Sets the carrer aspect of this resume dtls.
	 *
	 * @param CarrerAspect the carrer aspect of this resume dtls
	 */
	public void setCarrerAspect(String CarrerAspect);

	/**
	 * Returns the key i t skill of this resume dtls.
	 *
	 * @return the key i t skill of this resume dtls
	 */
	@AutoEscape
	public String getKeyITSkill();

	/**
	 * Sets the key i t skill of this resume dtls.
	 *
	 * @param KeyITSkill the key i t skill of this resume dtls
	 */
	public void setKeyITSkill(String KeyITSkill);

	/**
	 * Returns the certf tra of this resume dtls.
	 *
	 * @return the certf tra of this resume dtls
	 */
	@AutoEscape
	public String getCertfTra();

	/**
	 * Sets the certf tra of this resume dtls.
	 *
	 * @param CertfTra the certf tra of this resume dtls
	 */
	public void setCertfTra(String CertfTra);

	/**
	 * Returns the empy history of this resume dtls.
	 *
	 * @return the empy history of this resume dtls
	 */
	@AutoEscape
	public String getEmpyHistory();

	/**
	 * Sets the empy history of this resume dtls.
	 *
	 * @param EmpyHistory the empy history of this resume dtls
	 */
	public void setEmpyHistory(String EmpyHistory);

	/**
	 * Returns the core comp of this resume dtls.
	 *
	 * @return the core comp of this resume dtls
	 */
	@AutoEscape
	public String getCoreComp();

	/**
	 * Sets the core comp of this resume dtls.
	 *
	 * @param CoreComp the core comp of this resume dtls
	 */
	public void setCoreComp(String CoreComp);

	/**
	 * Returns the accomplishment of this resume dtls.
	 *
	 * @return the accomplishment of this resume dtls
	 */
	@AutoEscape
	public String getAccomplishment();

	/**
	 * Sets the accomplishment of this resume dtls.
	 *
	 * @param Accomplishment the accomplishment of this resume dtls
	 */
	public void setAccomplishment(String Accomplishment);

	/**
	 * Returns the academics of this resume dtls.
	 *
	 * @return the academics of this resume dtls
	 */
	@AutoEscape
	public String getAcademics();

	/**
	 * Sets the academics of this resume dtls.
	 *
	 * @param Academics the academics of this resume dtls
	 */
	public void setAcademics(String Academics);

	/**
	 * Returns the status of this resume dtls.
	 *
	 * @return the status of this resume dtls
	 */
	@AutoEscape
	public String getStatus();

	/**
	 * Sets the status of this resume dtls.
	 *
	 * @param status the status of this resume dtls
	 */
	public void setStatus(String status);

	/**
	 * Returns the flag of this resume dtls.
	 *
	 * @return the flag of this resume dtls
	 */
	public boolean getFlag();

	/**
	 * Returns <code>true</code> if this resume dtls is flag.
	 *
	 * @return <code>true</code> if this resume dtls is flag; <code>false</code> otherwise
	 */
	public boolean isFlag();

	/**
	 * Sets whether this resume dtls is flag.
	 *
	 * @param flag the flag of this resume dtls
	 */
	public void setFlag(boolean flag);

	/**
	 * Returns the indexno of this resume dtls.
	 *
	 * @return the indexno of this resume dtls
	 */
	@AutoEscape
	public String getIndexno();

	/**
	 * Sets the indexno of this resume dtls.
	 *
	 * @param indexno the indexno of this resume dtls
	 */
	public void setIndexno(String indexno);

	public boolean isNew();

	public void setNew(boolean n);

	public boolean isCachedModel();

	public void setCachedModel(boolean cachedModel);

	public boolean isEscapedModel();

	public Serializable getPrimaryKeyObj();

	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	public ExpandoBridge getExpandoBridge();

	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	public Object clone();

	public int compareTo(ResumeDtls resumeDtls);

	public int hashCode();

	public CacheModel<ResumeDtls> toCacheModel();

	public ResumeDtls toEscapedModel();

	public ResumeDtls toUnescapedModel();

	public String toString();

	public String toXmlString();
}