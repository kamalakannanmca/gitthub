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

import com.sbi.StartUp.service.CapitalInfLocalServiceUtil;
import com.sbi.StartUp.service.ClpSerializer;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author MAH97223
 */
public class CapitalInfClp extends BaseModelImpl<CapitalInf>
	implements CapitalInf {
	public CapitalInfClp() {
	}

	public Class<?> getModelClass() {
		return CapitalInf.class;
	}

	public String getModelClassName() {
		return CapitalInf.class.getName();
	}

	public long getPrimaryKey() {
		return _InfRefId;
	}

	public void setPrimaryKey(long primaryKey) {
		setInfRefId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_InfRefId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
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

	@Override
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

	public long getInfRefId() {
		return _InfRefId;
	}

	public void setInfRefId(long InfRefId) {
		_InfRefId = InfRefId;

		if (_capitalInfRemoteModel != null) {
			try {
				Class<?> clazz = _capitalInfRemoteModel.getClass();

				Method method = clazz.getMethod("setInfRefId", long.class);

				method.invoke(_capitalInfRemoteModel, InfRefId);
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

		if (_capitalInfRemoteModel != null) {
			try {
				Class<?> clazz = _capitalInfRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_capitalInfRemoteModel, createDate);
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

		if (_capitalInfRemoteModel != null) {
			try {
				Class<?> clazz = _capitalInfRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_capitalInfRemoteModel, modifiedDate);
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

		if (_capitalInfRemoteModel != null) {
			try {
				Class<?> clazz = _capitalInfRemoteModel.getClass();

				Method method = clazz.getMethod("setRegNum", String.class);

				method.invoke(_capitalInfRemoteModel, RegNum);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getCp_promoters_name() {
		return _cp_promoters_name;
	}

	public void setCp_promoters_name(String cp_promoters_name) {
		_cp_promoters_name = cp_promoters_name;

		if (_capitalInfRemoteModel != null) {
			try {
				Class<?> clazz = _capitalInfRemoteModel.getClass();

				Method method = clazz.getMethod("setCp_promoters_name",
						String.class);

				method.invoke(_capitalInfRemoteModel, cp_promoters_name);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getCp_promoters_address() {
		return _cp_promoters_address;
	}

	public void setCp_promoters_address(String cp_promoters_address) {
		_cp_promoters_address = cp_promoters_address;

		if (_capitalInfRemoteModel != null) {
			try {
				Class<?> clazz = _capitalInfRemoteModel.getClass();

				Method method = clazz.getMethod("setCp_promoters_address",
						String.class);

				method.invoke(_capitalInfRemoteModel, cp_promoters_address);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getCp_promoters_amount() {
		return _cp_promoters_amount;
	}

	public void setCp_promoters_amount(String cp_promoters_amount) {
		_cp_promoters_amount = cp_promoters_amount;

		if (_capitalInfRemoteModel != null) {
			try {
				Class<?> clazz = _capitalInfRemoteModel.getClass();

				Method method = clazz.getMethod("setCp_promoters_amount",
						String.class);

				method.invoke(_capitalInfRemoteModel, cp_promoters_amount);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getCapitalInfRemoteModel() {
		return _capitalInfRemoteModel;
	}

	public void setCapitalInfRemoteModel(BaseModel<?> capitalInfRemoteModel) {
		_capitalInfRemoteModel = capitalInfRemoteModel;
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

		Class<?> remoteModelClass = _capitalInfRemoteModel.getClass();

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

		Object returnValue = method.invoke(_capitalInfRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			CapitalInfLocalServiceUtil.addCapitalInf(this);
		}
		else {
			CapitalInfLocalServiceUtil.updateCapitalInf(this);
		}
	}

	@Override
	public CapitalInf toEscapedModel() {
		return (CapitalInf)ProxyUtil.newProxyInstance(CapitalInf.class.getClassLoader(),
			new Class[] { CapitalInf.class }, new AutoEscapeBeanHandler(this));
	}

	public CapitalInf toUnescapedModel() {
		return this;
	}

	@Override
	public Object clone() {
		CapitalInfClp clone = new CapitalInfClp();

		clone.setInfRefId(getInfRefId());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setRegNum(getRegNum());
		clone.setCp_promoters_name(getCp_promoters_name());
		clone.setCp_promoters_address(getCp_promoters_address());
		clone.setCp_promoters_amount(getCp_promoters_amount());

		return clone;
	}

	public int compareTo(CapitalInf capitalInf) {
		int value = 0;

		value = DateUtil.compareTo(getCreateDate(), capitalInf.getCreateDate());

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

		if (!(obj instanceof CapitalInfClp)) {
			return false;
		}

		CapitalInfClp capitalInf = (CapitalInfClp)obj;

		long primaryKey = capitalInf.getPrimaryKey();

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
		StringBundler sb = new StringBundler(15);

		sb.append("{InfRefId=");
		sb.append(getInfRefId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", RegNum=");
		sb.append(getRegNum());
		sb.append(", cp_promoters_name=");
		sb.append(getCp_promoters_name());
		sb.append(", cp_promoters_address=");
		sb.append(getCp_promoters_address());
		sb.append(", cp_promoters_amount=");
		sb.append(getCp_promoters_amount());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(25);

		sb.append("<model><model-name>");
		sb.append("com.sbi.StartUp.model.CapitalInf");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>InfRefId</column-name><column-value><![CDATA[");
		sb.append(getInfRefId());
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
			"<column><column-name>cp_promoters_name</column-name><column-value><![CDATA[");
		sb.append(getCp_promoters_name());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cp_promoters_address</column-name><column-value><![CDATA[");
		sb.append(getCp_promoters_address());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cp_promoters_amount</column-name><column-value><![CDATA[");
		sb.append(getCp_promoters_amount());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _InfRefId;
	private Date _createDate;
	private Date _modifiedDate;
	private String _RegNum;
	private String _cp_promoters_name;
	private String _cp_promoters_address;
	private String _cp_promoters_amount;
	private BaseModel<?> _capitalInfRemoteModel;
}