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
 * This class is a wrapper for {@link CapitalInf}.
 * </p>
 *
 * @author    MAH97223
 * @see       CapitalInf
 * @generated
 */
public class CapitalInfWrapper implements CapitalInf, ModelWrapper<CapitalInf> {
	public CapitalInfWrapper(CapitalInf capitalInf) {
		_capitalInf = capitalInf;
	}

	public Class<?> getModelClass() {
		return CapitalInf.class;
	}

	public String getModelClassName() {
		return CapitalInf.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("InfRefId", getInfRefId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("RegNum", getRegNum());
		attributes.put("cp_promoters_name", getCp_promoters_name());
		attributes.put("cp_promoters_address", getCp_promoters_address());
		attributes.put("cp_promoters_amount", getCp_promoters_amount());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		Long InfRefId = (Long)attributes.get("InfRefId");

		if (InfRefId != null) {
			setInfRefId(InfRefId);
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

		String cp_promoters_name = (String)attributes.get("cp_promoters_name");

		if (cp_promoters_name != null) {
			setCp_promoters_name(cp_promoters_name);
		}

		String cp_promoters_address = (String)attributes.get(
				"cp_promoters_address");

		if (cp_promoters_address != null) {
			setCp_promoters_address(cp_promoters_address);
		}

		String cp_promoters_amount = (String)attributes.get(
				"cp_promoters_amount");

		if (cp_promoters_amount != null) {
			setCp_promoters_amount(cp_promoters_amount);
		}
	}

	/**
	* Returns the primary key of this capital inf.
	*
	* @return the primary key of this capital inf
	*/
	public long getPrimaryKey() {
		return _capitalInf.getPrimaryKey();
	}

	/**
	* Sets the primary key of this capital inf.
	*
	* @param primaryKey the primary key of this capital inf
	*/
	public void setPrimaryKey(long primaryKey) {
		_capitalInf.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the inf ref ID of this capital inf.
	*
	* @return the inf ref ID of this capital inf
	*/
	public long getInfRefId() {
		return _capitalInf.getInfRefId();
	}

	/**
	* Sets the inf ref ID of this capital inf.
	*
	* @param InfRefId the inf ref ID of this capital inf
	*/
	public void setInfRefId(long InfRefId) {
		_capitalInf.setInfRefId(InfRefId);
	}

	/**
	* Returns the create date of this capital inf.
	*
	* @return the create date of this capital inf
	*/
	public java.util.Date getCreateDate() {
		return _capitalInf.getCreateDate();
	}

	/**
	* Sets the create date of this capital inf.
	*
	* @param createDate the create date of this capital inf
	*/
	public void setCreateDate(java.util.Date createDate) {
		_capitalInf.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this capital inf.
	*
	* @return the modified date of this capital inf
	*/
	public java.util.Date getModifiedDate() {
		return _capitalInf.getModifiedDate();
	}

	/**
	* Sets the modified date of this capital inf.
	*
	* @param modifiedDate the modified date of this capital inf
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_capitalInf.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the reg num of this capital inf.
	*
	* @return the reg num of this capital inf
	*/
	public java.lang.String getRegNum() {
		return _capitalInf.getRegNum();
	}

	/**
	* Sets the reg num of this capital inf.
	*
	* @param RegNum the reg num of this capital inf
	*/
	public void setRegNum(java.lang.String RegNum) {
		_capitalInf.setRegNum(RegNum);
	}

	/**
	* Returns the cp_promoters_name of this capital inf.
	*
	* @return the cp_promoters_name of this capital inf
	*/
	public java.lang.String getCp_promoters_name() {
		return _capitalInf.getCp_promoters_name();
	}

	/**
	* Sets the cp_promoters_name of this capital inf.
	*
	* @param cp_promoters_name the cp_promoters_name of this capital inf
	*/
	public void setCp_promoters_name(java.lang.String cp_promoters_name) {
		_capitalInf.setCp_promoters_name(cp_promoters_name);
	}

	/**
	* Returns the cp_promoters_address of this capital inf.
	*
	* @return the cp_promoters_address of this capital inf
	*/
	public java.lang.String getCp_promoters_address() {
		return _capitalInf.getCp_promoters_address();
	}

	/**
	* Sets the cp_promoters_address of this capital inf.
	*
	* @param cp_promoters_address the cp_promoters_address of this capital inf
	*/
	public void setCp_promoters_address(java.lang.String cp_promoters_address) {
		_capitalInf.setCp_promoters_address(cp_promoters_address);
	}

	/**
	* Returns the cp_promoters_amount of this capital inf.
	*
	* @return the cp_promoters_amount of this capital inf
	*/
	public java.lang.String getCp_promoters_amount() {
		return _capitalInf.getCp_promoters_amount();
	}

	/**
	* Sets the cp_promoters_amount of this capital inf.
	*
	* @param cp_promoters_amount the cp_promoters_amount of this capital inf
	*/
	public void setCp_promoters_amount(java.lang.String cp_promoters_amount) {
		_capitalInf.setCp_promoters_amount(cp_promoters_amount);
	}

	public boolean isNew() {
		return _capitalInf.isNew();
	}

	public void setNew(boolean n) {
		_capitalInf.setNew(n);
	}

	public boolean isCachedModel() {
		return _capitalInf.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_capitalInf.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _capitalInf.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _capitalInf.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_capitalInf.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _capitalInf.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_capitalInf.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new CapitalInfWrapper((CapitalInf)_capitalInf.clone());
	}

	public int compareTo(com.sbi.StartUp.model.CapitalInf capitalInf) {
		return _capitalInf.compareTo(capitalInf);
	}

	@Override
	public int hashCode() {
		return _capitalInf.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.sbi.StartUp.model.CapitalInf> toCacheModel() {
		return _capitalInf.toCacheModel();
	}

	public com.sbi.StartUp.model.CapitalInf toEscapedModel() {
		return new CapitalInfWrapper(_capitalInf.toEscapedModel());
	}

	public com.sbi.StartUp.model.CapitalInf toUnescapedModel() {
		return new CapitalInfWrapper(_capitalInf.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _capitalInf.toString();
	}

	public java.lang.String toXmlString() {
		return _capitalInf.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_capitalInf.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CapitalInfWrapper)) {
			return false;
		}

		CapitalInfWrapper capitalInfWrapper = (CapitalInfWrapper)obj;

		if (Validator.equals(_capitalInf, capitalInfWrapper._capitalInf)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public CapitalInf getWrappedCapitalInf() {
		return _capitalInf;
	}

	public CapitalInf getWrappedModel() {
		return _capitalInf;
	}

	public void resetOriginalValues() {
		_capitalInf.resetOriginalValues();
	}

	private CapitalInf _capitalInf;
}