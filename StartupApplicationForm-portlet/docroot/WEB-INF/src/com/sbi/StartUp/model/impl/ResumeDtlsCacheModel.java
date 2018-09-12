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

import com.sbi.StartUp.model.ResumeDtls;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing ResumeDtls in entity cache.
 *
 * @author MAH97223
 * @see ResumeDtls
 * @generated
 */
public class ResumeDtlsCacheModel implements CacheModel<ResumeDtls>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(65);

		sb.append("{ResumeId=");
		sb.append(ResumeId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", RegNum=");
		sb.append(RegNum);
		sb.append(", Name=");
		sb.append(Name);
		sb.append(", Email=");
		sb.append(Email);
		sb.append(", Mnumber=");
		sb.append(Mnumber);
		sb.append(", Dob=");
		sb.append(Dob);
		sb.append(", address_line_1=");
		sb.append(address_line_1);
		sb.append(", address_line_2=");
		sb.append(address_line_2);
		sb.append(", address_landmark=");
		sb.append(address_landmark);
		sb.append(", address_city=");
		sb.append(address_city);
		sb.append(", address_pin=");
		sb.append(address_pin);
		sb.append(", address_state=");
		sb.append(address_state);
		sb.append(", perm_address_line_1=");
		sb.append(perm_address_line_1);
		sb.append(", perm_address_line_2=");
		sb.append(perm_address_line_2);
		sb.append(", perm_address_landmark=");
		sb.append(perm_address_landmark);
		sb.append(", perm_address_city=");
		sb.append(perm_address_city);
		sb.append(", perm_address_pin=");
		sb.append(perm_address_pin);
		sb.append(", perm_address_state=");
		sb.append(perm_address_state);
		sb.append(", Pan=");
		sb.append(Pan);
		sb.append(", AadharNum=");
		sb.append(AadharNum);
		sb.append(", CarrerAspect=");
		sb.append(CarrerAspect);
		sb.append(", KeyITSkill=");
		sb.append(KeyITSkill);
		sb.append(", CertfTra=");
		sb.append(CertfTra);
		sb.append(", EmpyHistory=");
		sb.append(EmpyHistory);
		sb.append(", CoreComp=");
		sb.append(CoreComp);
		sb.append(", Accomplishment=");
		sb.append(Accomplishment);
		sb.append(", Academics=");
		sb.append(Academics);
		sb.append(", status=");
		sb.append(status);
		sb.append(", flag=");
		sb.append(flag);
		sb.append(", indexno=");
		sb.append(indexno);
		sb.append("}");

		return sb.toString();
	}

	public ResumeDtls toEntityModel() {
		ResumeDtlsImpl resumeDtlsImpl = new ResumeDtlsImpl();

		resumeDtlsImpl.setResumeId(ResumeId);

		if (createDate == Long.MIN_VALUE) {
			resumeDtlsImpl.setCreateDate(null);
		}
		else {
			resumeDtlsImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			resumeDtlsImpl.setModifiedDate(null);
		}
		else {
			resumeDtlsImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (RegNum == null) {
			resumeDtlsImpl.setRegNum(StringPool.BLANK);
		}
		else {
			resumeDtlsImpl.setRegNum(RegNum);
		}

		if (Name == null) {
			resumeDtlsImpl.setName(StringPool.BLANK);
		}
		else {
			resumeDtlsImpl.setName(Name);
		}

		if (Email == null) {
			resumeDtlsImpl.setEmail(StringPool.BLANK);
		}
		else {
			resumeDtlsImpl.setEmail(Email);
		}

		if (Mnumber == null) {
			resumeDtlsImpl.setMnumber(StringPool.BLANK);
		}
		else {
			resumeDtlsImpl.setMnumber(Mnumber);
		}

		if (Dob == Long.MIN_VALUE) {
			resumeDtlsImpl.setDob(null);
		}
		else {
			resumeDtlsImpl.setDob(new Date(Dob));
		}

		if (address_line_1 == null) {
			resumeDtlsImpl.setAddress_line_1(StringPool.BLANK);
		}
		else {
			resumeDtlsImpl.setAddress_line_1(address_line_1);
		}

		if (address_line_2 == null) {
			resumeDtlsImpl.setAddress_line_2(StringPool.BLANK);
		}
		else {
			resumeDtlsImpl.setAddress_line_2(address_line_2);
		}

		if (address_landmark == null) {
			resumeDtlsImpl.setAddress_landmark(StringPool.BLANK);
		}
		else {
			resumeDtlsImpl.setAddress_landmark(address_landmark);
		}

		if (address_city == null) {
			resumeDtlsImpl.setAddress_city(StringPool.BLANK);
		}
		else {
			resumeDtlsImpl.setAddress_city(address_city);
		}

		if (address_pin == null) {
			resumeDtlsImpl.setAddress_pin(StringPool.BLANK);
		}
		else {
			resumeDtlsImpl.setAddress_pin(address_pin);
		}

		if (address_state == null) {
			resumeDtlsImpl.setAddress_state(StringPool.BLANK);
		}
		else {
			resumeDtlsImpl.setAddress_state(address_state);
		}

		if (perm_address_line_1 == null) {
			resumeDtlsImpl.setPerm_address_line_1(StringPool.BLANK);
		}
		else {
			resumeDtlsImpl.setPerm_address_line_1(perm_address_line_1);
		}

		if (perm_address_line_2 == null) {
			resumeDtlsImpl.setPerm_address_line_2(StringPool.BLANK);
		}
		else {
			resumeDtlsImpl.setPerm_address_line_2(perm_address_line_2);
		}

		if (perm_address_landmark == null) {
			resumeDtlsImpl.setPerm_address_landmark(StringPool.BLANK);
		}
		else {
			resumeDtlsImpl.setPerm_address_landmark(perm_address_landmark);
		}

		if (perm_address_city == null) {
			resumeDtlsImpl.setPerm_address_city(StringPool.BLANK);
		}
		else {
			resumeDtlsImpl.setPerm_address_city(perm_address_city);
		}

		if (perm_address_pin == null) {
			resumeDtlsImpl.setPerm_address_pin(StringPool.BLANK);
		}
		else {
			resumeDtlsImpl.setPerm_address_pin(perm_address_pin);
		}

		if (perm_address_state == null) {
			resumeDtlsImpl.setPerm_address_state(StringPool.BLANK);
		}
		else {
			resumeDtlsImpl.setPerm_address_state(perm_address_state);
		}

		if (Pan == null) {
			resumeDtlsImpl.setPan(StringPool.BLANK);
		}
		else {
			resumeDtlsImpl.setPan(Pan);
		}

		if (AadharNum == null) {
			resumeDtlsImpl.setAadharNum(StringPool.BLANK);
		}
		else {
			resumeDtlsImpl.setAadharNum(AadharNum);
		}

		if (CarrerAspect == null) {
			resumeDtlsImpl.setCarrerAspect(StringPool.BLANK);
		}
		else {
			resumeDtlsImpl.setCarrerAspect(CarrerAspect);
		}

		if (KeyITSkill == null) {
			resumeDtlsImpl.setKeyITSkill(StringPool.BLANK);
		}
		else {
			resumeDtlsImpl.setKeyITSkill(KeyITSkill);
		}

		if (CertfTra == null) {
			resumeDtlsImpl.setCertfTra(StringPool.BLANK);
		}
		else {
			resumeDtlsImpl.setCertfTra(CertfTra);
		}

		if (EmpyHistory == null) {
			resumeDtlsImpl.setEmpyHistory(StringPool.BLANK);
		}
		else {
			resumeDtlsImpl.setEmpyHistory(EmpyHistory);
		}

		if (CoreComp == null) {
			resumeDtlsImpl.setCoreComp(StringPool.BLANK);
		}
		else {
			resumeDtlsImpl.setCoreComp(CoreComp);
		}

		if (Accomplishment == null) {
			resumeDtlsImpl.setAccomplishment(StringPool.BLANK);
		}
		else {
			resumeDtlsImpl.setAccomplishment(Accomplishment);
		}

		if (Academics == null) {
			resumeDtlsImpl.setAcademics(StringPool.BLANK);
		}
		else {
			resumeDtlsImpl.setAcademics(Academics);
		}

		if (status == null) {
			resumeDtlsImpl.setStatus(StringPool.BLANK);
		}
		else {
			resumeDtlsImpl.setStatus(status);
		}

		resumeDtlsImpl.setFlag(flag);

		if (indexno == null) {
			resumeDtlsImpl.setIndexno(StringPool.BLANK);
		}
		else {
			resumeDtlsImpl.setIndexno(indexno);
		}

		resumeDtlsImpl.resetOriginalValues();

		return resumeDtlsImpl;
	}

	public long ResumeId;
	public long createDate;
	public long modifiedDate;
	public String RegNum;
	public String Name;
	public String Email;
	public String Mnumber;
	public long Dob;
	public String address_line_1;
	public String address_line_2;
	public String address_landmark;
	public String address_city;
	public String address_pin;
	public String address_state;
	public String perm_address_line_1;
	public String perm_address_line_2;
	public String perm_address_landmark;
	public String perm_address_city;
	public String perm_address_pin;
	public String perm_address_state;
	public String Pan;
	public String AadharNum;
	public String CarrerAspect;
	public String KeyITSkill;
	public String CertfTra;
	public String EmpyHistory;
	public String CoreComp;
	public String Accomplishment;
	public String Academics;
	public String status;
	public boolean flag;
	public String indexno;
}