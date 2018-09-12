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
import com.sbi.StartUp.service.SbiStartUpLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author MAH97223
 */
public class SbiStartUpClp extends BaseModelImpl<SbiStartUp>
	implements SbiStartUp {
	public SbiStartUpClp() {
	}

	public Class<?> getModelClass() {
		return SbiStartUp.class;
	}

	public String getModelClassName() {
		return SbiStartUp.class.getName();
	}

	public String getPrimaryKey() {
		return _regnum;
	}

	public void setPrimaryKey(String primaryKey) {
		setRegnum(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return _regnum;
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((String)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("regnum", getRegnum());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("registered_name", getRegistered_name());
		attributes.put("date_of_establishment", getDate_of_establishment());
		attributes.put("constitution", getConstitution());
		attributes.put("address_line_1", getAddress_line_1());
		attributes.put("address_line_2", getAddress_line_2());
		attributes.put("address_landmark", getAddress_landmark());
		attributes.put("address_city", getAddress_city());
		attributes.put("address_pin", getAddress_pin());
		attributes.put("address_state", getAddress_state());
		attributes.put("corporate_email", getCorporate_email());
		attributes.put("corporate_website", getCorporate_website());
		attributes.put("initial_founders", getInitial_founders());
		attributes.put("current_promoters_name", getCurrent_promoters_name());
		attributes.put("noofemp", getNoofemp());
		attributes.put("description_of_product", getDescription_of_product());
		attributes.put("initial_capital", getInitial_capital());
		attributes.put("monetary_value", getMonetary_value());
		attributes.put("business_model", getBusiness_model());
		attributes.put("current_capital", getCurrent_capital());
		attributes.put("capital_infusion", getCapital_infusion());
		attributes.put("Loans_availed", getLoans_availed());
		attributes.put("valuer_name", getValuer_name());
		attributes.put("valuation_date", getValuation_date());
		attributes.put("valuation_amount_rs", getValuation_amount_rs());
		attributes.put("loan_avail_source", getLoan_avail_source());
		attributes.put("loan_avail_rs", getLoan_avail_rs());
		attributes.put("gross_revenue_year1", getGross_revenue_year1());
		attributes.put("gross_revenue_rs1", getGross_revenue_rs1());
		attributes.put("gross_revenue_year2", getGross_revenue_year2());
		attributes.put("gross_revenue_rs2", getGross_revenue_rs2());
		attributes.put("gross_revenue_year3", getGross_revenue_year3());
		attributes.put("gross_revenue_rs3", getGross_revenue_rs3());
		attributes.put("ebidta_year1", getEbidta_year1());
		attributes.put("ebidta_rs1", getEbidta_rs1());
		attributes.put("ebidta_year2", getEbidta_year2());
		attributes.put("ebidta_rs2", getEbidta_rs2());
		attributes.put("ebidta_year3", getEbidta_year3());
		attributes.put("ebidta_rs3", getEbidta_rs3());
		attributes.put("gross_revenue_projected_year1",
			getGross_revenue_projected_year1());
		attributes.put("projected_revenue_rs1", getProjected_revenue_rs1());
		attributes.put("gross_revenue_projected_year2",
			getGross_revenue_projected_year2());
		attributes.put("projected_revenue_rs2", getProjected_revenue_rs2());
		attributes.put("gross_revenue_projected_year3",
			getGross_revenue_projected_year3());
		attributes.put("projected_revenue_rs3", getProjected_revenue_rs3());
		attributes.put("projected_ebidta_year1", getProjected_ebidta_year1());
		attributes.put("projected_ebidta_rs1", getProjected_ebidta_rs1());
		attributes.put("projected_ebidta_year2", getProjected_ebidta_year2());
		attributes.put("projected_ebidta_rs2", getProjected_ebidta_rs2());
		attributes.put("projected_ebidta_year3", getProjected_ebidta_year3());
		attributes.put("projected_ebidta_rs3", getProjected_ebidta_rs3());
		attributes.put("projected_net_profit_year1",
			getProjected_net_profit_year1());
		attributes.put("projected_net_profit_rs1", getProjected_net_profit_rs1());
		attributes.put("projected_net_profit_year2",
			getProjected_net_profit_year2());
		attributes.put("projected_net_profit_rs2", getProjected_net_profit_rs2());
		attributes.put("projected_net_profit_year3",
			getProjected_net_profit_year3());
		attributes.put("projected_net_profit_rs3", getProjected_net_profit_rs3());
		attributes.put("net_profit_year1", getNet_profit_year1());
		attributes.put("net_profit_rs1", getNet_profit_rs1());
		attributes.put("net_profit_year2", getNet_profit_year2());
		attributes.put("net_profit_rs2", getNet_profit_rs2());
		attributes.put("net_profit_year3", getNet_profit_year3());
		attributes.put("net_profit_rs3", getNet_profit_rs3());
		attributes.put("financial_bank_engagement",
			getFinancial_bank_engagement());
		attributes.put("financial_assistance", getFinancial_assistance());
		attributes.put("financial_assi_purp", getFinancial_assi_purp());
		attributes.put("agreeable_process", getAgreeable_process());
		attributes.put("gsr_department", getGsr_department());
		attributes.put("startupindia", getStartupindia());
		attributes.put("incubator", getIncubator());
		attributes.put("status", getStatus());
		attributes.put("flag", getFlag());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String regnum = (String)attributes.get("regnum");

		if (regnum != null) {
			setRegnum(regnum);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String registered_name = (String)attributes.get("registered_name");

		if (registered_name != null) {
			setRegistered_name(registered_name);
		}

		Date date_of_establishment = (Date)attributes.get(
				"date_of_establishment");

		if (date_of_establishment != null) {
			setDate_of_establishment(date_of_establishment);
		}

		String constitution = (String)attributes.get("constitution");

		if (constitution != null) {
			setConstitution(constitution);
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

		String corporate_email = (String)attributes.get("corporate_email");

		if (corporate_email != null) {
			setCorporate_email(corporate_email);
		}

		String corporate_website = (String)attributes.get("corporate_website");

		if (corporate_website != null) {
			setCorporate_website(corporate_website);
		}

		String initial_founders = (String)attributes.get("initial_founders");

		if (initial_founders != null) {
			setInitial_founders(initial_founders);
		}

		String current_promoters_name = (String)attributes.get(
				"current_promoters_name");

		if (current_promoters_name != null) {
			setCurrent_promoters_name(current_promoters_name);
		}

		String noofemp = (String)attributes.get("noofemp");

		if (noofemp != null) {
			setNoofemp(noofemp);
		}

		String description_of_product = (String)attributes.get(
				"description_of_product");

		if (description_of_product != null) {
			setDescription_of_product(description_of_product);
		}

		String initial_capital = (String)attributes.get("initial_capital");

		if (initial_capital != null) {
			setInitial_capital(initial_capital);
		}

		String monetary_value = (String)attributes.get("monetary_value");

		if (monetary_value != null) {
			setMonetary_value(monetary_value);
		}

		String business_model = (String)attributes.get("business_model");

		if (business_model != null) {
			setBusiness_model(business_model);
		}

		String current_capital = (String)attributes.get("current_capital");

		if (current_capital != null) {
			setCurrent_capital(current_capital);
		}

		String capital_infusion = (String)attributes.get("capital_infusion");

		if (capital_infusion != null) {
			setCapital_infusion(capital_infusion);
		}

		String Loans_availed = (String)attributes.get("Loans_availed");

		if (Loans_availed != null) {
			setLoans_availed(Loans_availed);
		}

		String valuer_name = (String)attributes.get("valuer_name");

		if (valuer_name != null) {
			setValuer_name(valuer_name);
		}

		Date valuation_date = (Date)attributes.get("valuation_date");

		if (valuation_date != null) {
			setValuation_date(valuation_date);
		}

		String valuation_amount_rs = (String)attributes.get(
				"valuation_amount_rs");

		if (valuation_amount_rs != null) {
			setValuation_amount_rs(valuation_amount_rs);
		}

		String loan_avail_source = (String)attributes.get("loan_avail_source");

		if (loan_avail_source != null) {
			setLoan_avail_source(loan_avail_source);
		}

		String loan_avail_rs = (String)attributes.get("loan_avail_rs");

		if (loan_avail_rs != null) {
			setLoan_avail_rs(loan_avail_rs);
		}

		String gross_revenue_year1 = (String)attributes.get(
				"gross_revenue_year1");

		if (gross_revenue_year1 != null) {
			setGross_revenue_year1(gross_revenue_year1);
		}

		String gross_revenue_rs1 = (String)attributes.get("gross_revenue_rs1");

		if (gross_revenue_rs1 != null) {
			setGross_revenue_rs1(gross_revenue_rs1);
		}

		String gross_revenue_year2 = (String)attributes.get(
				"gross_revenue_year2");

		if (gross_revenue_year2 != null) {
			setGross_revenue_year2(gross_revenue_year2);
		}

		String gross_revenue_rs2 = (String)attributes.get("gross_revenue_rs2");

		if (gross_revenue_rs2 != null) {
			setGross_revenue_rs2(gross_revenue_rs2);
		}

		String gross_revenue_year3 = (String)attributes.get(
				"gross_revenue_year3");

		if (gross_revenue_year3 != null) {
			setGross_revenue_year3(gross_revenue_year3);
		}

		String gross_revenue_rs3 = (String)attributes.get("gross_revenue_rs3");

		if (gross_revenue_rs3 != null) {
			setGross_revenue_rs3(gross_revenue_rs3);
		}

		String ebidta_year1 = (String)attributes.get("ebidta_year1");

		if (ebidta_year1 != null) {
			setEbidta_year1(ebidta_year1);
		}

		String ebidta_rs1 = (String)attributes.get("ebidta_rs1");

		if (ebidta_rs1 != null) {
			setEbidta_rs1(ebidta_rs1);
		}

		String ebidta_year2 = (String)attributes.get("ebidta_year2");

		if (ebidta_year2 != null) {
			setEbidta_year2(ebidta_year2);
		}

		String ebidta_rs2 = (String)attributes.get("ebidta_rs2");

		if (ebidta_rs2 != null) {
			setEbidta_rs2(ebidta_rs2);
		}

		String ebidta_year3 = (String)attributes.get("ebidta_year3");

		if (ebidta_year3 != null) {
			setEbidta_year3(ebidta_year3);
		}

		String ebidta_rs3 = (String)attributes.get("ebidta_rs3");

		if (ebidta_rs3 != null) {
			setEbidta_rs3(ebidta_rs3);
		}

		String gross_revenue_projected_year1 = (String)attributes.get(
				"gross_revenue_projected_year1");

		if (gross_revenue_projected_year1 != null) {
			setGross_revenue_projected_year1(gross_revenue_projected_year1);
		}

		String projected_revenue_rs1 = (String)attributes.get(
				"projected_revenue_rs1");

		if (projected_revenue_rs1 != null) {
			setProjected_revenue_rs1(projected_revenue_rs1);
		}

		String gross_revenue_projected_year2 = (String)attributes.get(
				"gross_revenue_projected_year2");

		if (gross_revenue_projected_year2 != null) {
			setGross_revenue_projected_year2(gross_revenue_projected_year2);
		}

		String projected_revenue_rs2 = (String)attributes.get(
				"projected_revenue_rs2");

		if (projected_revenue_rs2 != null) {
			setProjected_revenue_rs2(projected_revenue_rs2);
		}

		String gross_revenue_projected_year3 = (String)attributes.get(
				"gross_revenue_projected_year3");

		if (gross_revenue_projected_year3 != null) {
			setGross_revenue_projected_year3(gross_revenue_projected_year3);
		}

		String projected_revenue_rs3 = (String)attributes.get(
				"projected_revenue_rs3");

		if (projected_revenue_rs3 != null) {
			setProjected_revenue_rs3(projected_revenue_rs3);
		}

		String projected_ebidta_year1 = (String)attributes.get(
				"projected_ebidta_year1");

		if (projected_ebidta_year1 != null) {
			setProjected_ebidta_year1(projected_ebidta_year1);
		}

		String projected_ebidta_rs1 = (String)attributes.get(
				"projected_ebidta_rs1");

		if (projected_ebidta_rs1 != null) {
			setProjected_ebidta_rs1(projected_ebidta_rs1);
		}

		String projected_ebidta_year2 = (String)attributes.get(
				"projected_ebidta_year2");

		if (projected_ebidta_year2 != null) {
			setProjected_ebidta_year2(projected_ebidta_year2);
		}

		String projected_ebidta_rs2 = (String)attributes.get(
				"projected_ebidta_rs2");

		if (projected_ebidta_rs2 != null) {
			setProjected_ebidta_rs2(projected_ebidta_rs2);
		}

		String projected_ebidta_year3 = (String)attributes.get(
				"projected_ebidta_year3");

		if (projected_ebidta_year3 != null) {
			setProjected_ebidta_year3(projected_ebidta_year3);
		}

		String projected_ebidta_rs3 = (String)attributes.get(
				"projected_ebidta_rs3");

		if (projected_ebidta_rs3 != null) {
			setProjected_ebidta_rs3(projected_ebidta_rs3);
		}

		String projected_net_profit_year1 = (String)attributes.get(
				"projected_net_profit_year1");

		if (projected_net_profit_year1 != null) {
			setProjected_net_profit_year1(projected_net_profit_year1);
		}

		String projected_net_profit_rs1 = (String)attributes.get(
				"projected_net_profit_rs1");

		if (projected_net_profit_rs1 != null) {
			setProjected_net_profit_rs1(projected_net_profit_rs1);
		}

		String projected_net_profit_year2 = (String)attributes.get(
				"projected_net_profit_year2");

		if (projected_net_profit_year2 != null) {
			setProjected_net_profit_year2(projected_net_profit_year2);
		}

		String projected_net_profit_rs2 = (String)attributes.get(
				"projected_net_profit_rs2");

		if (projected_net_profit_rs2 != null) {
			setProjected_net_profit_rs2(projected_net_profit_rs2);
		}

		String projected_net_profit_year3 = (String)attributes.get(
				"projected_net_profit_year3");

		if (projected_net_profit_year3 != null) {
			setProjected_net_profit_year3(projected_net_profit_year3);
		}

		String projected_net_profit_rs3 = (String)attributes.get(
				"projected_net_profit_rs3");

		if (projected_net_profit_rs3 != null) {
			setProjected_net_profit_rs3(projected_net_profit_rs3);
		}

		String net_profit_year1 = (String)attributes.get("net_profit_year1");

		if (net_profit_year1 != null) {
			setNet_profit_year1(net_profit_year1);
		}

		String net_profit_rs1 = (String)attributes.get("net_profit_rs1");

		if (net_profit_rs1 != null) {
			setNet_profit_rs1(net_profit_rs1);
		}

		String net_profit_year2 = (String)attributes.get("net_profit_year2");

		if (net_profit_year2 != null) {
			setNet_profit_year2(net_profit_year2);
		}

		String net_profit_rs2 = (String)attributes.get("net_profit_rs2");

		if (net_profit_rs2 != null) {
			setNet_profit_rs2(net_profit_rs2);
		}

		String net_profit_year3 = (String)attributes.get("net_profit_year3");

		if (net_profit_year3 != null) {
			setNet_profit_year3(net_profit_year3);
		}

		String net_profit_rs3 = (String)attributes.get("net_profit_rs3");

		if (net_profit_rs3 != null) {
			setNet_profit_rs3(net_profit_rs3);
		}

		String financial_bank_engagement = (String)attributes.get(
				"financial_bank_engagement");

		if (financial_bank_engagement != null) {
			setFinancial_bank_engagement(financial_bank_engagement);
		}

		String financial_assistance = (String)attributes.get(
				"financial_assistance");

		if (financial_assistance != null) {
			setFinancial_assistance(financial_assistance);
		}

		String financial_assi_purp = (String)attributes.get(
				"financial_assi_purp");

		if (financial_assi_purp != null) {
			setFinancial_assi_purp(financial_assi_purp);
		}

		String agreeable_process = (String)attributes.get("agreeable_process");

		if (agreeable_process != null) {
			setAgreeable_process(agreeable_process);
		}

		String gsr_department = (String)attributes.get("gsr_department");

		if (gsr_department != null) {
			setGsr_department(gsr_department);
		}

		String startupindia = (String)attributes.get("startupindia");

		if (startupindia != null) {
			setStartupindia(startupindia);
		}

		String incubator = (String)attributes.get("incubator");

		if (incubator != null) {
			setIncubator(incubator);
		}

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Boolean flag = (Boolean)attributes.get("flag");

		if (flag != null) {
			setFlag(flag);
		}
	}

	public String getRegnum() {
		return _regnum;
	}

	public void setRegnum(String regnum) {
		_regnum = regnum;

		if (_sbiStartUpRemoteModel != null) {
			try {
				Class<?> clazz = _sbiStartUpRemoteModel.getClass();

				Method method = clazz.getMethod("setRegnum", String.class);

				method.invoke(_sbiStartUpRemoteModel, regnum);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;

		if (_sbiStartUpRemoteModel != null) {
			try {
				Class<?> clazz = _sbiStartUpRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_sbiStartUpRemoteModel, userName);
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

		if (_sbiStartUpRemoteModel != null) {
			try {
				Class<?> clazz = _sbiStartUpRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_sbiStartUpRemoteModel, createDate);
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

		if (_sbiStartUpRemoteModel != null) {
			try {
				Class<?> clazz = _sbiStartUpRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_sbiStartUpRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getRegistered_name() {
		return _registered_name;
	}

	public void setRegistered_name(String registered_name) {
		_registered_name = registered_name;

		if (_sbiStartUpRemoteModel != null) {
			try {
				Class<?> clazz = _sbiStartUpRemoteModel.getClass();

				Method method = clazz.getMethod("setRegistered_name",
						String.class);

				method.invoke(_sbiStartUpRemoteModel, registered_name);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public Date getDate_of_establishment() {
		return _date_of_establishment;
	}

	public void setDate_of_establishment(Date date_of_establishment) {
		_date_of_establishment = date_of_establishment;

		if (_sbiStartUpRemoteModel != null) {
			try {
				Class<?> clazz = _sbiStartUpRemoteModel.getClass();

				Method method = clazz.getMethod("setDate_of_establishment",
						Date.class);

				method.invoke(_sbiStartUpRemoteModel, date_of_establishment);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getConstitution() {
		return _constitution;
	}

	public void setConstitution(String constitution) {
		_constitution = constitution;

		if (_sbiStartUpRemoteModel != null) {
			try {
				Class<?> clazz = _sbiStartUpRemoteModel.getClass();

				Method method = clazz.getMethod("setConstitution", String.class);

				method.invoke(_sbiStartUpRemoteModel, constitution);
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

		if (_sbiStartUpRemoteModel != null) {
			try {
				Class<?> clazz = _sbiStartUpRemoteModel.getClass();

				Method method = clazz.getMethod("setAddress_line_1",
						String.class);

				method.invoke(_sbiStartUpRemoteModel, address_line_1);
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

		if (_sbiStartUpRemoteModel != null) {
			try {
				Class<?> clazz = _sbiStartUpRemoteModel.getClass();

				Method method = clazz.getMethod("setAddress_line_2",
						String.class);

				method.invoke(_sbiStartUpRemoteModel, address_line_2);
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

		if (_sbiStartUpRemoteModel != null) {
			try {
				Class<?> clazz = _sbiStartUpRemoteModel.getClass();

				Method method = clazz.getMethod("setAddress_landmark",
						String.class);

				method.invoke(_sbiStartUpRemoteModel, address_landmark);
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

		if (_sbiStartUpRemoteModel != null) {
			try {
				Class<?> clazz = _sbiStartUpRemoteModel.getClass();

				Method method = clazz.getMethod("setAddress_city", String.class);

				method.invoke(_sbiStartUpRemoteModel, address_city);
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

		if (_sbiStartUpRemoteModel != null) {
			try {
				Class<?> clazz = _sbiStartUpRemoteModel.getClass();

				Method method = clazz.getMethod("setAddress_pin", String.class);

				method.invoke(_sbiStartUpRemoteModel, address_pin);
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

		if (_sbiStartUpRemoteModel != null) {
			try {
				Class<?> clazz = _sbiStartUpRemoteModel.getClass();

				Method method = clazz.getMethod("setAddress_state", String.class);

				method.invoke(_sbiStartUpRemoteModel, address_state);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getCorporate_email() {
		return _corporate_email;
	}

	public void setCorporate_email(String corporate_email) {
		_corporate_email = corporate_email;

		if (_sbiStartUpRemoteModel != null) {
			try {
				Class<?> clazz = _sbiStartUpRemoteModel.getClass();

				Method method = clazz.getMethod("setCorporate_email",
						String.class);

				method.invoke(_sbiStartUpRemoteModel, corporate_email);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getCorporate_website() {
		return _corporate_website;
	}

	public void setCorporate_website(String corporate_website) {
		_corporate_website = corporate_website;

		if (_sbiStartUpRemoteModel != null) {
			try {
				Class<?> clazz = _sbiStartUpRemoteModel.getClass();

				Method method = clazz.getMethod("setCorporate_website",
						String.class);

				method.invoke(_sbiStartUpRemoteModel, corporate_website);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getInitial_founders() {
		return _initial_founders;
	}

	public void setInitial_founders(String initial_founders) {
		_initial_founders = initial_founders;

		if (_sbiStartUpRemoteModel != null) {
			try {
				Class<?> clazz = _sbiStartUpRemoteModel.getClass();

				Method method = clazz.getMethod("setInitial_founders",
						String.class);

				method.invoke(_sbiStartUpRemoteModel, initial_founders);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getCurrent_promoters_name() {
		return _current_promoters_name;
	}

	public void setCurrent_promoters_name(String current_promoters_name) {
		_current_promoters_name = current_promoters_name;

		if (_sbiStartUpRemoteModel != null) {
			try {
				Class<?> clazz = _sbiStartUpRemoteModel.getClass();

				Method method = clazz.getMethod("setCurrent_promoters_name",
						String.class);

				method.invoke(_sbiStartUpRemoteModel, current_promoters_name);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getNoofemp() {
		return _noofemp;
	}

	public void setNoofemp(String noofemp) {
		_noofemp = noofemp;

		if (_sbiStartUpRemoteModel != null) {
			try {
				Class<?> clazz = _sbiStartUpRemoteModel.getClass();

				Method method = clazz.getMethod("setNoofemp", String.class);

				method.invoke(_sbiStartUpRemoteModel, noofemp);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getDescription_of_product() {
		return _description_of_product;
	}

	public void setDescription_of_product(String description_of_product) {
		_description_of_product = description_of_product;

		if (_sbiStartUpRemoteModel != null) {
			try {
				Class<?> clazz = _sbiStartUpRemoteModel.getClass();

				Method method = clazz.getMethod("setDescription_of_product",
						String.class);

				method.invoke(_sbiStartUpRemoteModel, description_of_product);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getInitial_capital() {
		return _initial_capital;
	}

	public void setInitial_capital(String initial_capital) {
		_initial_capital = initial_capital;

		if (_sbiStartUpRemoteModel != null) {
			try {
				Class<?> clazz = _sbiStartUpRemoteModel.getClass();

				Method method = clazz.getMethod("setInitial_capital",
						String.class);

				method.invoke(_sbiStartUpRemoteModel, initial_capital);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getMonetary_value() {
		return _monetary_value;
	}

	public void setMonetary_value(String monetary_value) {
		_monetary_value = monetary_value;

		if (_sbiStartUpRemoteModel != null) {
			try {
				Class<?> clazz = _sbiStartUpRemoteModel.getClass();

				Method method = clazz.getMethod("setMonetary_value",
						String.class);

				method.invoke(_sbiStartUpRemoteModel, monetary_value);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getBusiness_model() {
		return _business_model;
	}

	public void setBusiness_model(String business_model) {
		_business_model = business_model;

		if (_sbiStartUpRemoteModel != null) {
			try {
				Class<?> clazz = _sbiStartUpRemoteModel.getClass();

				Method method = clazz.getMethod("setBusiness_model",
						String.class);

				method.invoke(_sbiStartUpRemoteModel, business_model);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getCurrent_capital() {
		return _current_capital;
	}

	public void setCurrent_capital(String current_capital) {
		_current_capital = current_capital;

		if (_sbiStartUpRemoteModel != null) {
			try {
				Class<?> clazz = _sbiStartUpRemoteModel.getClass();

				Method method = clazz.getMethod("setCurrent_capital",
						String.class);

				method.invoke(_sbiStartUpRemoteModel, current_capital);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getCapital_infusion() {
		return _capital_infusion;
	}

	public void setCapital_infusion(String capital_infusion) {
		_capital_infusion = capital_infusion;

		if (_sbiStartUpRemoteModel != null) {
			try {
				Class<?> clazz = _sbiStartUpRemoteModel.getClass();

				Method method = clazz.getMethod("setCapital_infusion",
						String.class);

				method.invoke(_sbiStartUpRemoteModel, capital_infusion);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getLoans_availed() {
		return _Loans_availed;
	}

	public void setLoans_availed(String Loans_availed) {
		_Loans_availed = Loans_availed;

		if (_sbiStartUpRemoteModel != null) {
			try {
				Class<?> clazz = _sbiStartUpRemoteModel.getClass();

				Method method = clazz.getMethod("setLoans_availed", String.class);

				method.invoke(_sbiStartUpRemoteModel, Loans_availed);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getValuer_name() {
		return _valuer_name;
	}

	public void setValuer_name(String valuer_name) {
		_valuer_name = valuer_name;

		if (_sbiStartUpRemoteModel != null) {
			try {
				Class<?> clazz = _sbiStartUpRemoteModel.getClass();

				Method method = clazz.getMethod("setValuer_name", String.class);

				method.invoke(_sbiStartUpRemoteModel, valuer_name);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public Date getValuation_date() {
		return _valuation_date;
	}

	public void setValuation_date(Date valuation_date) {
		_valuation_date = valuation_date;

		if (_sbiStartUpRemoteModel != null) {
			try {
				Class<?> clazz = _sbiStartUpRemoteModel.getClass();

				Method method = clazz.getMethod("setValuation_date", Date.class);

				method.invoke(_sbiStartUpRemoteModel, valuation_date);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getValuation_amount_rs() {
		return _valuation_amount_rs;
	}

	public void setValuation_amount_rs(String valuation_amount_rs) {
		_valuation_amount_rs = valuation_amount_rs;

		if (_sbiStartUpRemoteModel != null) {
			try {
				Class<?> clazz = _sbiStartUpRemoteModel.getClass();

				Method method = clazz.getMethod("setValuation_amount_rs",
						String.class);

				method.invoke(_sbiStartUpRemoteModel, valuation_amount_rs);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getLoan_avail_source() {
		return _loan_avail_source;
	}

	public void setLoan_avail_source(String loan_avail_source) {
		_loan_avail_source = loan_avail_source;

		if (_sbiStartUpRemoteModel != null) {
			try {
				Class<?> clazz = _sbiStartUpRemoteModel.getClass();

				Method method = clazz.getMethod("setLoan_avail_source",
						String.class);

				method.invoke(_sbiStartUpRemoteModel, loan_avail_source);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getLoan_avail_rs() {
		return _loan_avail_rs;
	}

	public void setLoan_avail_rs(String loan_avail_rs) {
		_loan_avail_rs = loan_avail_rs;

		if (_sbiStartUpRemoteModel != null) {
			try {
				Class<?> clazz = _sbiStartUpRemoteModel.getClass();

				Method method = clazz.getMethod("setLoan_avail_rs", String.class);

				method.invoke(_sbiStartUpRemoteModel, loan_avail_rs);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getGross_revenue_year1() {
		return _gross_revenue_year1;
	}

	public void setGross_revenue_year1(String gross_revenue_year1) {
		_gross_revenue_year1 = gross_revenue_year1;

		if (_sbiStartUpRemoteModel != null) {
			try {
				Class<?> clazz = _sbiStartUpRemoteModel.getClass();

				Method method = clazz.getMethod("setGross_revenue_year1",
						String.class);

				method.invoke(_sbiStartUpRemoteModel, gross_revenue_year1);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getGross_revenue_rs1() {
		return _gross_revenue_rs1;
	}

	public void setGross_revenue_rs1(String gross_revenue_rs1) {
		_gross_revenue_rs1 = gross_revenue_rs1;

		if (_sbiStartUpRemoteModel != null) {
			try {
				Class<?> clazz = _sbiStartUpRemoteModel.getClass();

				Method method = clazz.getMethod("setGross_revenue_rs1",
						String.class);

				method.invoke(_sbiStartUpRemoteModel, gross_revenue_rs1);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getGross_revenue_year2() {
		return _gross_revenue_year2;
	}

	public void setGross_revenue_year2(String gross_revenue_year2) {
		_gross_revenue_year2 = gross_revenue_year2;

		if (_sbiStartUpRemoteModel != null) {
			try {
				Class<?> clazz = _sbiStartUpRemoteModel.getClass();

				Method method = clazz.getMethod("setGross_revenue_year2",
						String.class);

				method.invoke(_sbiStartUpRemoteModel, gross_revenue_year2);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getGross_revenue_rs2() {
		return _gross_revenue_rs2;
	}

	public void setGross_revenue_rs2(String gross_revenue_rs2) {
		_gross_revenue_rs2 = gross_revenue_rs2;

		if (_sbiStartUpRemoteModel != null) {
			try {
				Class<?> clazz = _sbiStartUpRemoteModel.getClass();

				Method method = clazz.getMethod("setGross_revenue_rs2",
						String.class);

				method.invoke(_sbiStartUpRemoteModel, gross_revenue_rs2);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getGross_revenue_year3() {
		return _gross_revenue_year3;
	}

	public void setGross_revenue_year3(String gross_revenue_year3) {
		_gross_revenue_year3 = gross_revenue_year3;

		if (_sbiStartUpRemoteModel != null) {
			try {
				Class<?> clazz = _sbiStartUpRemoteModel.getClass();

				Method method = clazz.getMethod("setGross_revenue_year3",
						String.class);

				method.invoke(_sbiStartUpRemoteModel, gross_revenue_year3);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getGross_revenue_rs3() {
		return _gross_revenue_rs3;
	}

	public void setGross_revenue_rs3(String gross_revenue_rs3) {
		_gross_revenue_rs3 = gross_revenue_rs3;

		if (_sbiStartUpRemoteModel != null) {
			try {
				Class<?> clazz = _sbiStartUpRemoteModel.getClass();

				Method method = clazz.getMethod("setGross_revenue_rs3",
						String.class);

				method.invoke(_sbiStartUpRemoteModel, gross_revenue_rs3);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getEbidta_year1() {
		return _ebidta_year1;
	}

	public void setEbidta_year1(String ebidta_year1) {
		_ebidta_year1 = ebidta_year1;

		if (_sbiStartUpRemoteModel != null) {
			try {
				Class<?> clazz = _sbiStartUpRemoteModel.getClass();

				Method method = clazz.getMethod("setEbidta_year1", String.class);

				method.invoke(_sbiStartUpRemoteModel, ebidta_year1);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getEbidta_rs1() {
		return _ebidta_rs1;
	}

	public void setEbidta_rs1(String ebidta_rs1) {
		_ebidta_rs1 = ebidta_rs1;

		if (_sbiStartUpRemoteModel != null) {
			try {
				Class<?> clazz = _sbiStartUpRemoteModel.getClass();

				Method method = clazz.getMethod("setEbidta_rs1", String.class);

				method.invoke(_sbiStartUpRemoteModel, ebidta_rs1);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getEbidta_year2() {
		return _ebidta_year2;
	}

	public void setEbidta_year2(String ebidta_year2) {
		_ebidta_year2 = ebidta_year2;

		if (_sbiStartUpRemoteModel != null) {
			try {
				Class<?> clazz = _sbiStartUpRemoteModel.getClass();

				Method method = clazz.getMethod("setEbidta_year2", String.class);

				method.invoke(_sbiStartUpRemoteModel, ebidta_year2);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getEbidta_rs2() {
		return _ebidta_rs2;
	}

	public void setEbidta_rs2(String ebidta_rs2) {
		_ebidta_rs2 = ebidta_rs2;

		if (_sbiStartUpRemoteModel != null) {
			try {
				Class<?> clazz = _sbiStartUpRemoteModel.getClass();

				Method method = clazz.getMethod("setEbidta_rs2", String.class);

				method.invoke(_sbiStartUpRemoteModel, ebidta_rs2);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getEbidta_year3() {
		return _ebidta_year3;
	}

	public void setEbidta_year3(String ebidta_year3) {
		_ebidta_year3 = ebidta_year3;

		if (_sbiStartUpRemoteModel != null) {
			try {
				Class<?> clazz = _sbiStartUpRemoteModel.getClass();

				Method method = clazz.getMethod("setEbidta_year3", String.class);

				method.invoke(_sbiStartUpRemoteModel, ebidta_year3);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getEbidta_rs3() {
		return _ebidta_rs3;
	}

	public void setEbidta_rs3(String ebidta_rs3) {
		_ebidta_rs3 = ebidta_rs3;

		if (_sbiStartUpRemoteModel != null) {
			try {
				Class<?> clazz = _sbiStartUpRemoteModel.getClass();

				Method method = clazz.getMethod("setEbidta_rs3", String.class);

				method.invoke(_sbiStartUpRemoteModel, ebidta_rs3);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getGross_revenue_projected_year1() {
		return _gross_revenue_projected_year1;
	}

	public void setGross_revenue_projected_year1(
		String gross_revenue_projected_year1) {
		_gross_revenue_projected_year1 = gross_revenue_projected_year1;

		if (_sbiStartUpRemoteModel != null) {
			try {
				Class<?> clazz = _sbiStartUpRemoteModel.getClass();

				Method method = clazz.getMethod("setGross_revenue_projected_year1",
						String.class);

				method.invoke(_sbiStartUpRemoteModel,
					gross_revenue_projected_year1);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getProjected_revenue_rs1() {
		return _projected_revenue_rs1;
	}

	public void setProjected_revenue_rs1(String projected_revenue_rs1) {
		_projected_revenue_rs1 = projected_revenue_rs1;

		if (_sbiStartUpRemoteModel != null) {
			try {
				Class<?> clazz = _sbiStartUpRemoteModel.getClass();

				Method method = clazz.getMethod("setProjected_revenue_rs1",
						String.class);

				method.invoke(_sbiStartUpRemoteModel, projected_revenue_rs1);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getGross_revenue_projected_year2() {
		return _gross_revenue_projected_year2;
	}

	public void setGross_revenue_projected_year2(
		String gross_revenue_projected_year2) {
		_gross_revenue_projected_year2 = gross_revenue_projected_year2;

		if (_sbiStartUpRemoteModel != null) {
			try {
				Class<?> clazz = _sbiStartUpRemoteModel.getClass();

				Method method = clazz.getMethod("setGross_revenue_projected_year2",
						String.class);

				method.invoke(_sbiStartUpRemoteModel,
					gross_revenue_projected_year2);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getProjected_revenue_rs2() {
		return _projected_revenue_rs2;
	}

	public void setProjected_revenue_rs2(String projected_revenue_rs2) {
		_projected_revenue_rs2 = projected_revenue_rs2;

		if (_sbiStartUpRemoteModel != null) {
			try {
				Class<?> clazz = _sbiStartUpRemoteModel.getClass();

				Method method = clazz.getMethod("setProjected_revenue_rs2",
						String.class);

				method.invoke(_sbiStartUpRemoteModel, projected_revenue_rs2);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getGross_revenue_projected_year3() {
		return _gross_revenue_projected_year3;
	}

	public void setGross_revenue_projected_year3(
		String gross_revenue_projected_year3) {
		_gross_revenue_projected_year3 = gross_revenue_projected_year3;

		if (_sbiStartUpRemoteModel != null) {
			try {
				Class<?> clazz = _sbiStartUpRemoteModel.getClass();

				Method method = clazz.getMethod("setGross_revenue_projected_year3",
						String.class);

				method.invoke(_sbiStartUpRemoteModel,
					gross_revenue_projected_year3);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getProjected_revenue_rs3() {
		return _projected_revenue_rs3;
	}

	public void setProjected_revenue_rs3(String projected_revenue_rs3) {
		_projected_revenue_rs3 = projected_revenue_rs3;

		if (_sbiStartUpRemoteModel != null) {
			try {
				Class<?> clazz = _sbiStartUpRemoteModel.getClass();

				Method method = clazz.getMethod("setProjected_revenue_rs3",
						String.class);

				method.invoke(_sbiStartUpRemoteModel, projected_revenue_rs3);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getProjected_ebidta_year1() {
		return _projected_ebidta_year1;
	}

	public void setProjected_ebidta_year1(String projected_ebidta_year1) {
		_projected_ebidta_year1 = projected_ebidta_year1;

		if (_sbiStartUpRemoteModel != null) {
			try {
				Class<?> clazz = _sbiStartUpRemoteModel.getClass();

				Method method = clazz.getMethod("setProjected_ebidta_year1",
						String.class);

				method.invoke(_sbiStartUpRemoteModel, projected_ebidta_year1);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getProjected_ebidta_rs1() {
		return _projected_ebidta_rs1;
	}

	public void setProjected_ebidta_rs1(String projected_ebidta_rs1) {
		_projected_ebidta_rs1 = projected_ebidta_rs1;

		if (_sbiStartUpRemoteModel != null) {
			try {
				Class<?> clazz = _sbiStartUpRemoteModel.getClass();

				Method method = clazz.getMethod("setProjected_ebidta_rs1",
						String.class);

				method.invoke(_sbiStartUpRemoteModel, projected_ebidta_rs1);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getProjected_ebidta_year2() {
		return _projected_ebidta_year2;
	}

	public void setProjected_ebidta_year2(String projected_ebidta_year2) {
		_projected_ebidta_year2 = projected_ebidta_year2;

		if (_sbiStartUpRemoteModel != null) {
			try {
				Class<?> clazz = _sbiStartUpRemoteModel.getClass();

				Method method = clazz.getMethod("setProjected_ebidta_year2",
						String.class);

				method.invoke(_sbiStartUpRemoteModel, projected_ebidta_year2);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getProjected_ebidta_rs2() {
		return _projected_ebidta_rs2;
	}

	public void setProjected_ebidta_rs2(String projected_ebidta_rs2) {
		_projected_ebidta_rs2 = projected_ebidta_rs2;

		if (_sbiStartUpRemoteModel != null) {
			try {
				Class<?> clazz = _sbiStartUpRemoteModel.getClass();

				Method method = clazz.getMethod("setProjected_ebidta_rs2",
						String.class);

				method.invoke(_sbiStartUpRemoteModel, projected_ebidta_rs2);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getProjected_ebidta_year3() {
		return _projected_ebidta_year3;
	}

	public void setProjected_ebidta_year3(String projected_ebidta_year3) {
		_projected_ebidta_year3 = projected_ebidta_year3;

		if (_sbiStartUpRemoteModel != null) {
			try {
				Class<?> clazz = _sbiStartUpRemoteModel.getClass();

				Method method = clazz.getMethod("setProjected_ebidta_year3",
						String.class);

				method.invoke(_sbiStartUpRemoteModel, projected_ebidta_year3);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getProjected_ebidta_rs3() {
		return _projected_ebidta_rs3;
	}

	public void setProjected_ebidta_rs3(String projected_ebidta_rs3) {
		_projected_ebidta_rs3 = projected_ebidta_rs3;

		if (_sbiStartUpRemoteModel != null) {
			try {
				Class<?> clazz = _sbiStartUpRemoteModel.getClass();

				Method method = clazz.getMethod("setProjected_ebidta_rs3",
						String.class);

				method.invoke(_sbiStartUpRemoteModel, projected_ebidta_rs3);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getProjected_net_profit_year1() {
		return _projected_net_profit_year1;
	}

	public void setProjected_net_profit_year1(String projected_net_profit_year1) {
		_projected_net_profit_year1 = projected_net_profit_year1;

		if (_sbiStartUpRemoteModel != null) {
			try {
				Class<?> clazz = _sbiStartUpRemoteModel.getClass();

				Method method = clazz.getMethod("setProjected_net_profit_year1",
						String.class);

				method.invoke(_sbiStartUpRemoteModel, projected_net_profit_year1);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getProjected_net_profit_rs1() {
		return _projected_net_profit_rs1;
	}

	public void setProjected_net_profit_rs1(String projected_net_profit_rs1) {
		_projected_net_profit_rs1 = projected_net_profit_rs1;

		if (_sbiStartUpRemoteModel != null) {
			try {
				Class<?> clazz = _sbiStartUpRemoteModel.getClass();

				Method method = clazz.getMethod("setProjected_net_profit_rs1",
						String.class);

				method.invoke(_sbiStartUpRemoteModel, projected_net_profit_rs1);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getProjected_net_profit_year2() {
		return _projected_net_profit_year2;
	}

	public void setProjected_net_profit_year2(String projected_net_profit_year2) {
		_projected_net_profit_year2 = projected_net_profit_year2;

		if (_sbiStartUpRemoteModel != null) {
			try {
				Class<?> clazz = _sbiStartUpRemoteModel.getClass();

				Method method = clazz.getMethod("setProjected_net_profit_year2",
						String.class);

				method.invoke(_sbiStartUpRemoteModel, projected_net_profit_year2);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getProjected_net_profit_rs2() {
		return _projected_net_profit_rs2;
	}

	public void setProjected_net_profit_rs2(String projected_net_profit_rs2) {
		_projected_net_profit_rs2 = projected_net_profit_rs2;

		if (_sbiStartUpRemoteModel != null) {
			try {
				Class<?> clazz = _sbiStartUpRemoteModel.getClass();

				Method method = clazz.getMethod("setProjected_net_profit_rs2",
						String.class);

				method.invoke(_sbiStartUpRemoteModel, projected_net_profit_rs2);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getProjected_net_profit_year3() {
		return _projected_net_profit_year3;
	}

	public void setProjected_net_profit_year3(String projected_net_profit_year3) {
		_projected_net_profit_year3 = projected_net_profit_year3;

		if (_sbiStartUpRemoteModel != null) {
			try {
				Class<?> clazz = _sbiStartUpRemoteModel.getClass();

				Method method = clazz.getMethod("setProjected_net_profit_year3",
						String.class);

				method.invoke(_sbiStartUpRemoteModel, projected_net_profit_year3);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getProjected_net_profit_rs3() {
		return _projected_net_profit_rs3;
	}

	public void setProjected_net_profit_rs3(String projected_net_profit_rs3) {
		_projected_net_profit_rs3 = projected_net_profit_rs3;

		if (_sbiStartUpRemoteModel != null) {
			try {
				Class<?> clazz = _sbiStartUpRemoteModel.getClass();

				Method method = clazz.getMethod("setProjected_net_profit_rs3",
						String.class);

				method.invoke(_sbiStartUpRemoteModel, projected_net_profit_rs3);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getNet_profit_year1() {
		return _net_profit_year1;
	}

	public void setNet_profit_year1(String net_profit_year1) {
		_net_profit_year1 = net_profit_year1;

		if (_sbiStartUpRemoteModel != null) {
			try {
				Class<?> clazz = _sbiStartUpRemoteModel.getClass();

				Method method = clazz.getMethod("setNet_profit_year1",
						String.class);

				method.invoke(_sbiStartUpRemoteModel, net_profit_year1);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getNet_profit_rs1() {
		return _net_profit_rs1;
	}

	public void setNet_profit_rs1(String net_profit_rs1) {
		_net_profit_rs1 = net_profit_rs1;

		if (_sbiStartUpRemoteModel != null) {
			try {
				Class<?> clazz = _sbiStartUpRemoteModel.getClass();

				Method method = clazz.getMethod("setNet_profit_rs1",
						String.class);

				method.invoke(_sbiStartUpRemoteModel, net_profit_rs1);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getNet_profit_year2() {
		return _net_profit_year2;
	}

	public void setNet_profit_year2(String net_profit_year2) {
		_net_profit_year2 = net_profit_year2;

		if (_sbiStartUpRemoteModel != null) {
			try {
				Class<?> clazz = _sbiStartUpRemoteModel.getClass();

				Method method = clazz.getMethod("setNet_profit_year2",
						String.class);

				method.invoke(_sbiStartUpRemoteModel, net_profit_year2);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getNet_profit_rs2() {
		return _net_profit_rs2;
	}

	public void setNet_profit_rs2(String net_profit_rs2) {
		_net_profit_rs2 = net_profit_rs2;

		if (_sbiStartUpRemoteModel != null) {
			try {
				Class<?> clazz = _sbiStartUpRemoteModel.getClass();

				Method method = clazz.getMethod("setNet_profit_rs2",
						String.class);

				method.invoke(_sbiStartUpRemoteModel, net_profit_rs2);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getNet_profit_year3() {
		return _net_profit_year3;
	}

	public void setNet_profit_year3(String net_profit_year3) {
		_net_profit_year3 = net_profit_year3;

		if (_sbiStartUpRemoteModel != null) {
			try {
				Class<?> clazz = _sbiStartUpRemoteModel.getClass();

				Method method = clazz.getMethod("setNet_profit_year3",
						String.class);

				method.invoke(_sbiStartUpRemoteModel, net_profit_year3);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getNet_profit_rs3() {
		return _net_profit_rs3;
	}

	public void setNet_profit_rs3(String net_profit_rs3) {
		_net_profit_rs3 = net_profit_rs3;

		if (_sbiStartUpRemoteModel != null) {
			try {
				Class<?> clazz = _sbiStartUpRemoteModel.getClass();

				Method method = clazz.getMethod("setNet_profit_rs3",
						String.class);

				method.invoke(_sbiStartUpRemoteModel, net_profit_rs3);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getFinancial_bank_engagement() {
		return _financial_bank_engagement;
	}

	public void setFinancial_bank_engagement(String financial_bank_engagement) {
		_financial_bank_engagement = financial_bank_engagement;

		if (_sbiStartUpRemoteModel != null) {
			try {
				Class<?> clazz = _sbiStartUpRemoteModel.getClass();

				Method method = clazz.getMethod("setFinancial_bank_engagement",
						String.class);

				method.invoke(_sbiStartUpRemoteModel, financial_bank_engagement);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getFinancial_assistance() {
		return _financial_assistance;
	}

	public void setFinancial_assistance(String financial_assistance) {
		_financial_assistance = financial_assistance;

		if (_sbiStartUpRemoteModel != null) {
			try {
				Class<?> clazz = _sbiStartUpRemoteModel.getClass();

				Method method = clazz.getMethod("setFinancial_assistance",
						String.class);

				method.invoke(_sbiStartUpRemoteModel, financial_assistance);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getFinancial_assi_purp() {
		return _financial_assi_purp;
	}

	public void setFinancial_assi_purp(String financial_assi_purp) {
		_financial_assi_purp = financial_assi_purp;

		if (_sbiStartUpRemoteModel != null) {
			try {
				Class<?> clazz = _sbiStartUpRemoteModel.getClass();

				Method method = clazz.getMethod("setFinancial_assi_purp",
						String.class);

				method.invoke(_sbiStartUpRemoteModel, financial_assi_purp);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getAgreeable_process() {
		return _agreeable_process;
	}

	public void setAgreeable_process(String agreeable_process) {
		_agreeable_process = agreeable_process;

		if (_sbiStartUpRemoteModel != null) {
			try {
				Class<?> clazz = _sbiStartUpRemoteModel.getClass();

				Method method = clazz.getMethod("setAgreeable_process",
						String.class);

				method.invoke(_sbiStartUpRemoteModel, agreeable_process);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getGsr_department() {
		return _gsr_department;
	}

	public void setGsr_department(String gsr_department) {
		_gsr_department = gsr_department;

		if (_sbiStartUpRemoteModel != null) {
			try {
				Class<?> clazz = _sbiStartUpRemoteModel.getClass();

				Method method = clazz.getMethod("setGsr_department",
						String.class);

				method.invoke(_sbiStartUpRemoteModel, gsr_department);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getStartupindia() {
		return _startupindia;
	}

	public void setStartupindia(String startupindia) {
		_startupindia = startupindia;

		if (_sbiStartUpRemoteModel != null) {
			try {
				Class<?> clazz = _sbiStartUpRemoteModel.getClass();

				Method method = clazz.getMethod("setStartupindia", String.class);

				method.invoke(_sbiStartUpRemoteModel, startupindia);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getIncubator() {
		return _incubator;
	}

	public void setIncubator(String incubator) {
		_incubator = incubator;

		if (_sbiStartUpRemoteModel != null) {
			try {
				Class<?> clazz = _sbiStartUpRemoteModel.getClass();

				Method method = clazz.getMethod("setIncubator", String.class);

				method.invoke(_sbiStartUpRemoteModel, incubator);
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

		if (_sbiStartUpRemoteModel != null) {
			try {
				Class<?> clazz = _sbiStartUpRemoteModel.getClass();

				Method method = clazz.getMethod("setStatus", String.class);

				method.invoke(_sbiStartUpRemoteModel, status);
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

		if (_sbiStartUpRemoteModel != null) {
			try {
				Class<?> clazz = _sbiStartUpRemoteModel.getClass();

				Method method = clazz.getMethod("setFlag", boolean.class);

				method.invoke(_sbiStartUpRemoteModel, flag);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getSbiStartUpRemoteModel() {
		return _sbiStartUpRemoteModel;
	}

	public void setSbiStartUpRemoteModel(BaseModel<?> sbiStartUpRemoteModel) {
		_sbiStartUpRemoteModel = sbiStartUpRemoteModel;
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

		Class<?> remoteModelClass = _sbiStartUpRemoteModel.getClass();

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

		Object returnValue = method.invoke(_sbiStartUpRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			SbiStartUpLocalServiceUtil.addSbiStartUp(this);
		}
		else {
			SbiStartUpLocalServiceUtil.updateSbiStartUp(this);
		}
	}

	@Override
	public SbiStartUp toEscapedModel() {
		return (SbiStartUp)ProxyUtil.newProxyInstance(SbiStartUp.class.getClassLoader(),
			new Class[] { SbiStartUp.class }, new AutoEscapeBeanHandler(this));
	}

	public SbiStartUp toUnescapedModel() {
		return this;
	}

	@Override
	public Object clone() {
		SbiStartUpClp clone = new SbiStartUpClp();

		clone.setRegnum(getRegnum());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setRegistered_name(getRegistered_name());
		clone.setDate_of_establishment(getDate_of_establishment());
		clone.setConstitution(getConstitution());
		clone.setAddress_line_1(getAddress_line_1());
		clone.setAddress_line_2(getAddress_line_2());
		clone.setAddress_landmark(getAddress_landmark());
		clone.setAddress_city(getAddress_city());
		clone.setAddress_pin(getAddress_pin());
		clone.setAddress_state(getAddress_state());
		clone.setCorporate_email(getCorporate_email());
		clone.setCorporate_website(getCorporate_website());
		clone.setInitial_founders(getInitial_founders());
		clone.setCurrent_promoters_name(getCurrent_promoters_name());
		clone.setNoofemp(getNoofemp());
		clone.setDescription_of_product(getDescription_of_product());
		clone.setInitial_capital(getInitial_capital());
		clone.setMonetary_value(getMonetary_value());
		clone.setBusiness_model(getBusiness_model());
		clone.setCurrent_capital(getCurrent_capital());
		clone.setCapital_infusion(getCapital_infusion());
		clone.setLoans_availed(getLoans_availed());
		clone.setValuer_name(getValuer_name());
		clone.setValuation_date(getValuation_date());
		clone.setValuation_amount_rs(getValuation_amount_rs());
		clone.setLoan_avail_source(getLoan_avail_source());
		clone.setLoan_avail_rs(getLoan_avail_rs());
		clone.setGross_revenue_year1(getGross_revenue_year1());
		clone.setGross_revenue_rs1(getGross_revenue_rs1());
		clone.setGross_revenue_year2(getGross_revenue_year2());
		clone.setGross_revenue_rs2(getGross_revenue_rs2());
		clone.setGross_revenue_year3(getGross_revenue_year3());
		clone.setGross_revenue_rs3(getGross_revenue_rs3());
		clone.setEbidta_year1(getEbidta_year1());
		clone.setEbidta_rs1(getEbidta_rs1());
		clone.setEbidta_year2(getEbidta_year2());
		clone.setEbidta_rs2(getEbidta_rs2());
		clone.setEbidta_year3(getEbidta_year3());
		clone.setEbidta_rs3(getEbidta_rs3());
		clone.setGross_revenue_projected_year1(getGross_revenue_projected_year1());
		clone.setProjected_revenue_rs1(getProjected_revenue_rs1());
		clone.setGross_revenue_projected_year2(getGross_revenue_projected_year2());
		clone.setProjected_revenue_rs2(getProjected_revenue_rs2());
		clone.setGross_revenue_projected_year3(getGross_revenue_projected_year3());
		clone.setProjected_revenue_rs3(getProjected_revenue_rs3());
		clone.setProjected_ebidta_year1(getProjected_ebidta_year1());
		clone.setProjected_ebidta_rs1(getProjected_ebidta_rs1());
		clone.setProjected_ebidta_year2(getProjected_ebidta_year2());
		clone.setProjected_ebidta_rs2(getProjected_ebidta_rs2());
		clone.setProjected_ebidta_year3(getProjected_ebidta_year3());
		clone.setProjected_ebidta_rs3(getProjected_ebidta_rs3());
		clone.setProjected_net_profit_year1(getProjected_net_profit_year1());
		clone.setProjected_net_profit_rs1(getProjected_net_profit_rs1());
		clone.setProjected_net_profit_year2(getProjected_net_profit_year2());
		clone.setProjected_net_profit_rs2(getProjected_net_profit_rs2());
		clone.setProjected_net_profit_year3(getProjected_net_profit_year3());
		clone.setProjected_net_profit_rs3(getProjected_net_profit_rs3());
		clone.setNet_profit_year1(getNet_profit_year1());
		clone.setNet_profit_rs1(getNet_profit_rs1());
		clone.setNet_profit_year2(getNet_profit_year2());
		clone.setNet_profit_rs2(getNet_profit_rs2());
		clone.setNet_profit_year3(getNet_profit_year3());
		clone.setNet_profit_rs3(getNet_profit_rs3());
		clone.setFinancial_bank_engagement(getFinancial_bank_engagement());
		clone.setFinancial_assistance(getFinancial_assistance());
		clone.setFinancial_assi_purp(getFinancial_assi_purp());
		clone.setAgreeable_process(getAgreeable_process());
		clone.setGsr_department(getGsr_department());
		clone.setStartupindia(getStartupindia());
		clone.setIncubator(getIncubator());
		clone.setStatus(getStatus());
		clone.setFlag(getFlag());

		return clone;
	}

	public int compareTo(SbiStartUp sbiStartUp) {
		int value = 0;

		value = DateUtil.compareTo(getCreateDate(), sbiStartUp.getCreateDate());

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

		if (!(obj instanceof SbiStartUpClp)) {
			return false;
		}

		SbiStartUpClp sbiStartUp = (SbiStartUpClp)obj;

		String primaryKey = sbiStartUp.getPrimaryKey();

		if (getPrimaryKey().equals(primaryKey)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return getPrimaryKey().hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(151);

		sb.append("{regnum=");
		sb.append(getRegnum());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", registered_name=");
		sb.append(getRegistered_name());
		sb.append(", date_of_establishment=");
		sb.append(getDate_of_establishment());
		sb.append(", constitution=");
		sb.append(getConstitution());
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
		sb.append(", corporate_email=");
		sb.append(getCorporate_email());
		sb.append(", corporate_website=");
		sb.append(getCorporate_website());
		sb.append(", initial_founders=");
		sb.append(getInitial_founders());
		sb.append(", current_promoters_name=");
		sb.append(getCurrent_promoters_name());
		sb.append(", noofemp=");
		sb.append(getNoofemp());
		sb.append(", description_of_product=");
		sb.append(getDescription_of_product());
		sb.append(", initial_capital=");
		sb.append(getInitial_capital());
		sb.append(", monetary_value=");
		sb.append(getMonetary_value());
		sb.append(", business_model=");
		sb.append(getBusiness_model());
		sb.append(", current_capital=");
		sb.append(getCurrent_capital());
		sb.append(", capital_infusion=");
		sb.append(getCapital_infusion());
		sb.append(", Loans_availed=");
		sb.append(getLoans_availed());
		sb.append(", valuer_name=");
		sb.append(getValuer_name());
		sb.append(", valuation_date=");
		sb.append(getValuation_date());
		sb.append(", valuation_amount_rs=");
		sb.append(getValuation_amount_rs());
		sb.append(", loan_avail_source=");
		sb.append(getLoan_avail_source());
		sb.append(", loan_avail_rs=");
		sb.append(getLoan_avail_rs());
		sb.append(", gross_revenue_year1=");
		sb.append(getGross_revenue_year1());
		sb.append(", gross_revenue_rs1=");
		sb.append(getGross_revenue_rs1());
		sb.append(", gross_revenue_year2=");
		sb.append(getGross_revenue_year2());
		sb.append(", gross_revenue_rs2=");
		sb.append(getGross_revenue_rs2());
		sb.append(", gross_revenue_year3=");
		sb.append(getGross_revenue_year3());
		sb.append(", gross_revenue_rs3=");
		sb.append(getGross_revenue_rs3());
		sb.append(", ebidta_year1=");
		sb.append(getEbidta_year1());
		sb.append(", ebidta_rs1=");
		sb.append(getEbidta_rs1());
		sb.append(", ebidta_year2=");
		sb.append(getEbidta_year2());
		sb.append(", ebidta_rs2=");
		sb.append(getEbidta_rs2());
		sb.append(", ebidta_year3=");
		sb.append(getEbidta_year3());
		sb.append(", ebidta_rs3=");
		sb.append(getEbidta_rs3());
		sb.append(", gross_revenue_projected_year1=");
		sb.append(getGross_revenue_projected_year1());
		sb.append(", projected_revenue_rs1=");
		sb.append(getProjected_revenue_rs1());
		sb.append(", gross_revenue_projected_year2=");
		sb.append(getGross_revenue_projected_year2());
		sb.append(", projected_revenue_rs2=");
		sb.append(getProjected_revenue_rs2());
		sb.append(", gross_revenue_projected_year3=");
		sb.append(getGross_revenue_projected_year3());
		sb.append(", projected_revenue_rs3=");
		sb.append(getProjected_revenue_rs3());
		sb.append(", projected_ebidta_year1=");
		sb.append(getProjected_ebidta_year1());
		sb.append(", projected_ebidta_rs1=");
		sb.append(getProjected_ebidta_rs1());
		sb.append(", projected_ebidta_year2=");
		sb.append(getProjected_ebidta_year2());
		sb.append(", projected_ebidta_rs2=");
		sb.append(getProjected_ebidta_rs2());
		sb.append(", projected_ebidta_year3=");
		sb.append(getProjected_ebidta_year3());
		sb.append(", projected_ebidta_rs3=");
		sb.append(getProjected_ebidta_rs3());
		sb.append(", projected_net_profit_year1=");
		sb.append(getProjected_net_profit_year1());
		sb.append(", projected_net_profit_rs1=");
		sb.append(getProjected_net_profit_rs1());
		sb.append(", projected_net_profit_year2=");
		sb.append(getProjected_net_profit_year2());
		sb.append(", projected_net_profit_rs2=");
		sb.append(getProjected_net_profit_rs2());
		sb.append(", projected_net_profit_year3=");
		sb.append(getProjected_net_profit_year3());
		sb.append(", projected_net_profit_rs3=");
		sb.append(getProjected_net_profit_rs3());
		sb.append(", net_profit_year1=");
		sb.append(getNet_profit_year1());
		sb.append(", net_profit_rs1=");
		sb.append(getNet_profit_rs1());
		sb.append(", net_profit_year2=");
		sb.append(getNet_profit_year2());
		sb.append(", net_profit_rs2=");
		sb.append(getNet_profit_rs2());
		sb.append(", net_profit_year3=");
		sb.append(getNet_profit_year3());
		sb.append(", net_profit_rs3=");
		sb.append(getNet_profit_rs3());
		sb.append(", financial_bank_engagement=");
		sb.append(getFinancial_bank_engagement());
		sb.append(", financial_assistance=");
		sb.append(getFinancial_assistance());
		sb.append(", financial_assi_purp=");
		sb.append(getFinancial_assi_purp());
		sb.append(", agreeable_process=");
		sb.append(getAgreeable_process());
		sb.append(", gsr_department=");
		sb.append(getGsr_department());
		sb.append(", startupindia=");
		sb.append(getStartupindia());
		sb.append(", incubator=");
		sb.append(getIncubator());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", flag=");
		sb.append(getFlag());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(229);

		sb.append("<model><model-name>");
		sb.append("com.sbi.StartUp.model.SbiStartUp");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>regnum</column-name><column-value><![CDATA[");
		sb.append(getRegnum());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
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
			"<column><column-name>registered_name</column-name><column-value><![CDATA[");
		sb.append(getRegistered_name());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>date_of_establishment</column-name><column-value><![CDATA[");
		sb.append(getDate_of_establishment());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>constitution</column-name><column-value><![CDATA[");
		sb.append(getConstitution());
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
			"<column><column-name>corporate_email</column-name><column-value><![CDATA[");
		sb.append(getCorporate_email());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>corporate_website</column-name><column-value><![CDATA[");
		sb.append(getCorporate_website());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>initial_founders</column-name><column-value><![CDATA[");
		sb.append(getInitial_founders());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>current_promoters_name</column-name><column-value><![CDATA[");
		sb.append(getCurrent_promoters_name());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>noofemp</column-name><column-value><![CDATA[");
		sb.append(getNoofemp());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description_of_product</column-name><column-value><![CDATA[");
		sb.append(getDescription_of_product());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>initial_capital</column-name><column-value><![CDATA[");
		sb.append(getInitial_capital());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>monetary_value</column-name><column-value><![CDATA[");
		sb.append(getMonetary_value());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>business_model</column-name><column-value><![CDATA[");
		sb.append(getBusiness_model());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>current_capital</column-name><column-value><![CDATA[");
		sb.append(getCurrent_capital());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>capital_infusion</column-name><column-value><![CDATA[");
		sb.append(getCapital_infusion());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>Loans_availed</column-name><column-value><![CDATA[");
		sb.append(getLoans_availed());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>valuer_name</column-name><column-value><![CDATA[");
		sb.append(getValuer_name());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>valuation_date</column-name><column-value><![CDATA[");
		sb.append(getValuation_date());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>valuation_amount_rs</column-name><column-value><![CDATA[");
		sb.append(getValuation_amount_rs());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>loan_avail_source</column-name><column-value><![CDATA[");
		sb.append(getLoan_avail_source());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>loan_avail_rs</column-name><column-value><![CDATA[");
		sb.append(getLoan_avail_rs());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>gross_revenue_year1</column-name><column-value><![CDATA[");
		sb.append(getGross_revenue_year1());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>gross_revenue_rs1</column-name><column-value><![CDATA[");
		sb.append(getGross_revenue_rs1());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>gross_revenue_year2</column-name><column-value><![CDATA[");
		sb.append(getGross_revenue_year2());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>gross_revenue_rs2</column-name><column-value><![CDATA[");
		sb.append(getGross_revenue_rs2());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>gross_revenue_year3</column-name><column-value><![CDATA[");
		sb.append(getGross_revenue_year3());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>gross_revenue_rs3</column-name><column-value><![CDATA[");
		sb.append(getGross_revenue_rs3());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ebidta_year1</column-name><column-value><![CDATA[");
		sb.append(getEbidta_year1());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ebidta_rs1</column-name><column-value><![CDATA[");
		sb.append(getEbidta_rs1());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ebidta_year2</column-name><column-value><![CDATA[");
		sb.append(getEbidta_year2());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ebidta_rs2</column-name><column-value><![CDATA[");
		sb.append(getEbidta_rs2());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ebidta_year3</column-name><column-value><![CDATA[");
		sb.append(getEbidta_year3());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ebidta_rs3</column-name><column-value><![CDATA[");
		sb.append(getEbidta_rs3());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>gross_revenue_projected_year1</column-name><column-value><![CDATA[");
		sb.append(getGross_revenue_projected_year1());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>projected_revenue_rs1</column-name><column-value><![CDATA[");
		sb.append(getProjected_revenue_rs1());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>gross_revenue_projected_year2</column-name><column-value><![CDATA[");
		sb.append(getGross_revenue_projected_year2());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>projected_revenue_rs2</column-name><column-value><![CDATA[");
		sb.append(getProjected_revenue_rs2());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>gross_revenue_projected_year3</column-name><column-value><![CDATA[");
		sb.append(getGross_revenue_projected_year3());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>projected_revenue_rs3</column-name><column-value><![CDATA[");
		sb.append(getProjected_revenue_rs3());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>projected_ebidta_year1</column-name><column-value><![CDATA[");
		sb.append(getProjected_ebidta_year1());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>projected_ebidta_rs1</column-name><column-value><![CDATA[");
		sb.append(getProjected_ebidta_rs1());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>projected_ebidta_year2</column-name><column-value><![CDATA[");
		sb.append(getProjected_ebidta_year2());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>projected_ebidta_rs2</column-name><column-value><![CDATA[");
		sb.append(getProjected_ebidta_rs2());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>projected_ebidta_year3</column-name><column-value><![CDATA[");
		sb.append(getProjected_ebidta_year3());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>projected_ebidta_rs3</column-name><column-value><![CDATA[");
		sb.append(getProjected_ebidta_rs3());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>projected_net_profit_year1</column-name><column-value><![CDATA[");
		sb.append(getProjected_net_profit_year1());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>projected_net_profit_rs1</column-name><column-value><![CDATA[");
		sb.append(getProjected_net_profit_rs1());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>projected_net_profit_year2</column-name><column-value><![CDATA[");
		sb.append(getProjected_net_profit_year2());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>projected_net_profit_rs2</column-name><column-value><![CDATA[");
		sb.append(getProjected_net_profit_rs2());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>projected_net_profit_year3</column-name><column-value><![CDATA[");
		sb.append(getProjected_net_profit_year3());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>projected_net_profit_rs3</column-name><column-value><![CDATA[");
		sb.append(getProjected_net_profit_rs3());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>net_profit_year1</column-name><column-value><![CDATA[");
		sb.append(getNet_profit_year1());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>net_profit_rs1</column-name><column-value><![CDATA[");
		sb.append(getNet_profit_rs1());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>net_profit_year2</column-name><column-value><![CDATA[");
		sb.append(getNet_profit_year2());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>net_profit_rs2</column-name><column-value><![CDATA[");
		sb.append(getNet_profit_rs2());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>net_profit_year3</column-name><column-value><![CDATA[");
		sb.append(getNet_profit_year3());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>net_profit_rs3</column-name><column-value><![CDATA[");
		sb.append(getNet_profit_rs3());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>financial_bank_engagement</column-name><column-value><![CDATA[");
		sb.append(getFinancial_bank_engagement());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>financial_assistance</column-name><column-value><![CDATA[");
		sb.append(getFinancial_assistance());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>financial_assi_purp</column-name><column-value><![CDATA[");
		sb.append(getFinancial_assi_purp());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>agreeable_process</column-name><column-value><![CDATA[");
		sb.append(getAgreeable_process());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>gsr_department</column-name><column-value><![CDATA[");
		sb.append(getGsr_department());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>startupindia</column-name><column-value><![CDATA[");
		sb.append(getStartupindia());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>incubator</column-name><column-value><![CDATA[");
		sb.append(getIncubator());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>flag</column-name><column-value><![CDATA[");
		sb.append(getFlag());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _regnum;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _registered_name;
	private Date _date_of_establishment;
	private String _constitution;
	private String _address_line_1;
	private String _address_line_2;
	private String _address_landmark;
	private String _address_city;
	private String _address_pin;
	private String _address_state;
	private String _corporate_email;
	private String _corporate_website;
	private String _initial_founders;
	private String _current_promoters_name;
	private String _noofemp;
	private String _description_of_product;
	private String _initial_capital;
	private String _monetary_value;
	private String _business_model;
	private String _current_capital;
	private String _capital_infusion;
	private String _Loans_availed;
	private String _valuer_name;
	private Date _valuation_date;
	private String _valuation_amount_rs;
	private String _loan_avail_source;
	private String _loan_avail_rs;
	private String _gross_revenue_year1;
	private String _gross_revenue_rs1;
	private String _gross_revenue_year2;
	private String _gross_revenue_rs2;
	private String _gross_revenue_year3;
	private String _gross_revenue_rs3;
	private String _ebidta_year1;
	private String _ebidta_rs1;
	private String _ebidta_year2;
	private String _ebidta_rs2;
	private String _ebidta_year3;
	private String _ebidta_rs3;
	private String _gross_revenue_projected_year1;
	private String _projected_revenue_rs1;
	private String _gross_revenue_projected_year2;
	private String _projected_revenue_rs2;
	private String _gross_revenue_projected_year3;
	private String _projected_revenue_rs3;
	private String _projected_ebidta_year1;
	private String _projected_ebidta_rs1;
	private String _projected_ebidta_year2;
	private String _projected_ebidta_rs2;
	private String _projected_ebidta_year3;
	private String _projected_ebidta_rs3;
	private String _projected_net_profit_year1;
	private String _projected_net_profit_rs1;
	private String _projected_net_profit_year2;
	private String _projected_net_profit_rs2;
	private String _projected_net_profit_year3;
	private String _projected_net_profit_rs3;
	private String _net_profit_year1;
	private String _net_profit_rs1;
	private String _net_profit_year2;
	private String _net_profit_rs2;
	private String _net_profit_year3;
	private String _net_profit_rs3;
	private String _financial_bank_engagement;
	private String _financial_assistance;
	private String _financial_assi_purp;
	private String _agreeable_process;
	private String _gsr_department;
	private String _startupindia;
	private String _incubator;
	private String _status;
	private boolean _flag;
	private BaseModel<?> _sbiStartUpRemoteModel;
}