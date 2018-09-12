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

package com.sbi.StartUp.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.sbi.StartUp.model.CapitalInf;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing CapitalInf in entity cache.
 *
 * @author MAH97223
 * @see CapitalInf
 * @generated
 */
public class CapitalInfCacheModel implements CacheModel<CapitalInf>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{InfRefId=");
		sb.append(InfRefId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", RegNum=");
		sb.append(RegNum);
		sb.append(", cp_promoters_name=");
		sb.append(cp_promoters_name);
		sb.append(", cp_promoters_address=");
		sb.append(cp_promoters_address);
		sb.append(", cp_promoters_amount=");
		sb.append(cp_promoters_amount);
		sb.append("}");

		return sb.toString();
	}

	public CapitalInf toEntityModel() {
		CapitalInfImpl capitalInfImpl = new CapitalInfImpl();

		capitalInfImpl.setInfRefId(InfRefId);

		if (createDate == Long.MIN_VALUE) {
			capitalInfImpl.setCreateDate(null);
		}
		else {
			capitalInfImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			capitalInfImpl.setModifiedDate(null);
		}
		else {
			capitalInfImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (RegNum == null) {
			capitalInfImpl.setRegNum(StringPool.BLANK);
		}
		else {
			capitalInfImpl.setRegNum(RegNum);
		}

		if (cp_promoters_name == null) {
			capitalInfImpl.setCp_promoters_name(StringPool.BLANK);
		}
		else {
			capitalInfImpl.setCp_promoters_name(cp_promoters_name);
		}

		if (cp_promoters_address == null) {
			capitalInfImpl.setCp_promoters_address(StringPool.BLANK);
		}
		else {
			capitalInfImpl.setCp_promoters_address(cp_promoters_address);
		}

		if (cp_promoters_amount == null) {
			capitalInfImpl.setCp_promoters_amount(StringPool.BLANK);
		}
		else {
			capitalInfImpl.setCp_promoters_amount(cp_promoters_amount);
		}

		capitalInfImpl.resetOriginalValues();

		return capitalInfImpl;
	}

	public long InfRefId;
	public long createDate;
	public long modifiedDate;
	public String RegNum;
	public String cp_promoters_name;
	public String cp_promoters_address;
	public String cp_promoters_amount;
}