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
 * This class is a wrapper for {@link SbiStartUp}.
 * </p>
 *
 * @author    MAH97223
 * @see       SbiStartUp
 * @generated
 */
public class SbiStartUpWrapper implements SbiStartUp, ModelWrapper<SbiStartUp> {
	public SbiStartUpWrapper(SbiStartUp sbiStartUp) {
		_sbiStartUp = sbiStartUp;
	}

	public Class<?> getModelClass() {
		return SbiStartUp.class;
	}

	public String getModelClassName() {
		return SbiStartUp.class.getName();
	}

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

	/**
	* Returns the primary key of this sbi start up.
	*
	* @return the primary key of this sbi start up
	*/
	public java.lang.String getPrimaryKey() {
		return _sbiStartUp.getPrimaryKey();
	}

	/**
	* Sets the primary key of this sbi start up.
	*
	* @param primaryKey the primary key of this sbi start up
	*/
	public void setPrimaryKey(java.lang.String primaryKey) {
		_sbiStartUp.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the regnum of this sbi start up.
	*
	* @return the regnum of this sbi start up
	*/
	public java.lang.String getRegnum() {
		return _sbiStartUp.getRegnum();
	}

	/**
	* Sets the regnum of this sbi start up.
	*
	* @param regnum the regnum of this sbi start up
	*/
	public void setRegnum(java.lang.String regnum) {
		_sbiStartUp.setRegnum(regnum);
	}

	/**
	* Returns the user name of this sbi start up.
	*
	* @return the user name of this sbi start up
	*/
	public java.lang.String getUserName() {
		return _sbiStartUp.getUserName();
	}

	/**
	* Sets the user name of this sbi start up.
	*
	* @param userName the user name of this sbi start up
	*/
	public void setUserName(java.lang.String userName) {
		_sbiStartUp.setUserName(userName);
	}

	/**
	* Returns the create date of this sbi start up.
	*
	* @return the create date of this sbi start up
	*/
	public java.util.Date getCreateDate() {
		return _sbiStartUp.getCreateDate();
	}

	/**
	* Sets the create date of this sbi start up.
	*
	* @param createDate the create date of this sbi start up
	*/
	public void setCreateDate(java.util.Date createDate) {
		_sbiStartUp.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this sbi start up.
	*
	* @return the modified date of this sbi start up
	*/
	public java.util.Date getModifiedDate() {
		return _sbiStartUp.getModifiedDate();
	}

	/**
	* Sets the modified date of this sbi start up.
	*
	* @param modifiedDate the modified date of this sbi start up
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_sbiStartUp.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the registered_name of this sbi start up.
	*
	* @return the registered_name of this sbi start up
	*/
	public java.lang.String getRegistered_name() {
		return _sbiStartUp.getRegistered_name();
	}

	/**
	* Sets the registered_name of this sbi start up.
	*
	* @param registered_name the registered_name of this sbi start up
	*/
	public void setRegistered_name(java.lang.String registered_name) {
		_sbiStartUp.setRegistered_name(registered_name);
	}

	/**
	* Returns the date_of_establishment of this sbi start up.
	*
	* @return the date_of_establishment of this sbi start up
	*/
	public java.util.Date getDate_of_establishment() {
		return _sbiStartUp.getDate_of_establishment();
	}

	/**
	* Sets the date_of_establishment of this sbi start up.
	*
	* @param date_of_establishment the date_of_establishment of this sbi start up
	*/
	public void setDate_of_establishment(java.util.Date date_of_establishment) {
		_sbiStartUp.setDate_of_establishment(date_of_establishment);
	}

	/**
	* Returns the constitution of this sbi start up.
	*
	* @return the constitution of this sbi start up
	*/
	public java.lang.String getConstitution() {
		return _sbiStartUp.getConstitution();
	}

	/**
	* Sets the constitution of this sbi start up.
	*
	* @param constitution the constitution of this sbi start up
	*/
	public void setConstitution(java.lang.String constitution) {
		_sbiStartUp.setConstitution(constitution);
	}

	/**
	* Returns the address_line_1 of this sbi start up.
	*
	* @return the address_line_1 of this sbi start up
	*/
	public java.lang.String getAddress_line_1() {
		return _sbiStartUp.getAddress_line_1();
	}

	/**
	* Sets the address_line_1 of this sbi start up.
	*
	* @param address_line_1 the address_line_1 of this sbi start up
	*/
	public void setAddress_line_1(java.lang.String address_line_1) {
		_sbiStartUp.setAddress_line_1(address_line_1);
	}

	/**
	* Returns the address_line_2 of this sbi start up.
	*
	* @return the address_line_2 of this sbi start up
	*/
	public java.lang.String getAddress_line_2() {
		return _sbiStartUp.getAddress_line_2();
	}

	/**
	* Sets the address_line_2 of this sbi start up.
	*
	* @param address_line_2 the address_line_2 of this sbi start up
	*/
	public void setAddress_line_2(java.lang.String address_line_2) {
		_sbiStartUp.setAddress_line_2(address_line_2);
	}

	/**
	* Returns the address_landmark of this sbi start up.
	*
	* @return the address_landmark of this sbi start up
	*/
	public java.lang.String getAddress_landmark() {
		return _sbiStartUp.getAddress_landmark();
	}

	/**
	* Sets the address_landmark of this sbi start up.
	*
	* @param address_landmark the address_landmark of this sbi start up
	*/
	public void setAddress_landmark(java.lang.String address_landmark) {
		_sbiStartUp.setAddress_landmark(address_landmark);
	}

	/**
	* Returns the address_city of this sbi start up.
	*
	* @return the address_city of this sbi start up
	*/
	public java.lang.String getAddress_city() {
		return _sbiStartUp.getAddress_city();
	}

	/**
	* Sets the address_city of this sbi start up.
	*
	* @param address_city the address_city of this sbi start up
	*/
	public void setAddress_city(java.lang.String address_city) {
		_sbiStartUp.setAddress_city(address_city);
	}

	/**
	* Returns the address_pin of this sbi start up.
	*
	* @return the address_pin of this sbi start up
	*/
	public java.lang.String getAddress_pin() {
		return _sbiStartUp.getAddress_pin();
	}

	/**
	* Sets the address_pin of this sbi start up.
	*
	* @param address_pin the address_pin of this sbi start up
	*/
	public void setAddress_pin(java.lang.String address_pin) {
		_sbiStartUp.setAddress_pin(address_pin);
	}

	/**
	* Returns the address_state of this sbi start up.
	*
	* @return the address_state of this sbi start up
	*/
	public java.lang.String getAddress_state() {
		return _sbiStartUp.getAddress_state();
	}

	/**
	* Sets the address_state of this sbi start up.
	*
	* @param address_state the address_state of this sbi start up
	*/
	public void setAddress_state(java.lang.String address_state) {
		_sbiStartUp.setAddress_state(address_state);
	}

	/**
	* Returns the corporate_email of this sbi start up.
	*
	* @return the corporate_email of this sbi start up
	*/
	public java.lang.String getCorporate_email() {
		return _sbiStartUp.getCorporate_email();
	}

	/**
	* Sets the corporate_email of this sbi start up.
	*
	* @param corporate_email the corporate_email of this sbi start up
	*/
	public void setCorporate_email(java.lang.String corporate_email) {
		_sbiStartUp.setCorporate_email(corporate_email);
	}

	/**
	* Returns the corporate_website of this sbi start up.
	*
	* @return the corporate_website of this sbi start up
	*/
	public java.lang.String getCorporate_website() {
		return _sbiStartUp.getCorporate_website();
	}

	/**
	* Sets the corporate_website of this sbi start up.
	*
	* @param corporate_website the corporate_website of this sbi start up
	*/
	public void setCorporate_website(java.lang.String corporate_website) {
		_sbiStartUp.setCorporate_website(corporate_website);
	}

	/**
	* Returns the initial_founders of this sbi start up.
	*
	* @return the initial_founders of this sbi start up
	*/
	public java.lang.String getInitial_founders() {
		return _sbiStartUp.getInitial_founders();
	}

	/**
	* Sets the initial_founders of this sbi start up.
	*
	* @param initial_founders the initial_founders of this sbi start up
	*/
	public void setInitial_founders(java.lang.String initial_founders) {
		_sbiStartUp.setInitial_founders(initial_founders);
	}

	/**
	* Returns the current_promoters_name of this sbi start up.
	*
	* @return the current_promoters_name of this sbi start up
	*/
	public java.lang.String getCurrent_promoters_name() {
		return _sbiStartUp.getCurrent_promoters_name();
	}

	/**
	* Sets the current_promoters_name of this sbi start up.
	*
	* @param current_promoters_name the current_promoters_name of this sbi start up
	*/
	public void setCurrent_promoters_name(
		java.lang.String current_promoters_name) {
		_sbiStartUp.setCurrent_promoters_name(current_promoters_name);
	}

	/**
	* Returns the noofemp of this sbi start up.
	*
	* @return the noofemp of this sbi start up
	*/
	public java.lang.String getNoofemp() {
		return _sbiStartUp.getNoofemp();
	}

	/**
	* Sets the noofemp of this sbi start up.
	*
	* @param noofemp the noofemp of this sbi start up
	*/
	public void setNoofemp(java.lang.String noofemp) {
		_sbiStartUp.setNoofemp(noofemp);
	}

	/**
	* Returns the description_of_product of this sbi start up.
	*
	* @return the description_of_product of this sbi start up
	*/
	public java.lang.String getDescription_of_product() {
		return _sbiStartUp.getDescription_of_product();
	}

	/**
	* Sets the description_of_product of this sbi start up.
	*
	* @param description_of_product the description_of_product of this sbi start up
	*/
	public void setDescription_of_product(
		java.lang.String description_of_product) {
		_sbiStartUp.setDescription_of_product(description_of_product);
	}

	/**
	* Returns the initial_capital of this sbi start up.
	*
	* @return the initial_capital of this sbi start up
	*/
	public java.lang.String getInitial_capital() {
		return _sbiStartUp.getInitial_capital();
	}

	/**
	* Sets the initial_capital of this sbi start up.
	*
	* @param initial_capital the initial_capital of this sbi start up
	*/
	public void setInitial_capital(java.lang.String initial_capital) {
		_sbiStartUp.setInitial_capital(initial_capital);
	}

	/**
	* Returns the monetary_value of this sbi start up.
	*
	* @return the monetary_value of this sbi start up
	*/
	public java.lang.String getMonetary_value() {
		return _sbiStartUp.getMonetary_value();
	}

	/**
	* Sets the monetary_value of this sbi start up.
	*
	* @param monetary_value the monetary_value of this sbi start up
	*/
	public void setMonetary_value(java.lang.String monetary_value) {
		_sbiStartUp.setMonetary_value(monetary_value);
	}

	/**
	* Returns the business_model of this sbi start up.
	*
	* @return the business_model of this sbi start up
	*/
	public java.lang.String getBusiness_model() {
		return _sbiStartUp.getBusiness_model();
	}

	/**
	* Sets the business_model of this sbi start up.
	*
	* @param business_model the business_model of this sbi start up
	*/
	public void setBusiness_model(java.lang.String business_model) {
		_sbiStartUp.setBusiness_model(business_model);
	}

	/**
	* Returns the current_capital of this sbi start up.
	*
	* @return the current_capital of this sbi start up
	*/
	public java.lang.String getCurrent_capital() {
		return _sbiStartUp.getCurrent_capital();
	}

	/**
	* Sets the current_capital of this sbi start up.
	*
	* @param current_capital the current_capital of this sbi start up
	*/
	public void setCurrent_capital(java.lang.String current_capital) {
		_sbiStartUp.setCurrent_capital(current_capital);
	}

	/**
	* Returns the capital_infusion of this sbi start up.
	*
	* @return the capital_infusion of this sbi start up
	*/
	public java.lang.String getCapital_infusion() {
		return _sbiStartUp.getCapital_infusion();
	}

	/**
	* Sets the capital_infusion of this sbi start up.
	*
	* @param capital_infusion the capital_infusion of this sbi start up
	*/
	public void setCapital_infusion(java.lang.String capital_infusion) {
		_sbiStartUp.setCapital_infusion(capital_infusion);
	}

	/**
	* Returns the loans_availed of this sbi start up.
	*
	* @return the loans_availed of this sbi start up
	*/
	public java.lang.String getLoans_availed() {
		return _sbiStartUp.getLoans_availed();
	}

	/**
	* Sets the loans_availed of this sbi start up.
	*
	* @param Loans_availed the loans_availed of this sbi start up
	*/
	public void setLoans_availed(java.lang.String Loans_availed) {
		_sbiStartUp.setLoans_availed(Loans_availed);
	}

	/**
	* Returns the valuer_name of this sbi start up.
	*
	* @return the valuer_name of this sbi start up
	*/
	public java.lang.String getValuer_name() {
		return _sbiStartUp.getValuer_name();
	}

	/**
	* Sets the valuer_name of this sbi start up.
	*
	* @param valuer_name the valuer_name of this sbi start up
	*/
	public void setValuer_name(java.lang.String valuer_name) {
		_sbiStartUp.setValuer_name(valuer_name);
	}

	/**
	* Returns the valuation_date of this sbi start up.
	*
	* @return the valuation_date of this sbi start up
	*/
	public java.util.Date getValuation_date() {
		return _sbiStartUp.getValuation_date();
	}

	/**
	* Sets the valuation_date of this sbi start up.
	*
	* @param valuation_date the valuation_date of this sbi start up
	*/
	public void setValuation_date(java.util.Date valuation_date) {
		_sbiStartUp.setValuation_date(valuation_date);
	}

	/**
	* Returns the valuation_amount_rs of this sbi start up.
	*
	* @return the valuation_amount_rs of this sbi start up
	*/
	public java.lang.String getValuation_amount_rs() {
		return _sbiStartUp.getValuation_amount_rs();
	}

	/**
	* Sets the valuation_amount_rs of this sbi start up.
	*
	* @param valuation_amount_rs the valuation_amount_rs of this sbi start up
	*/
	public void setValuation_amount_rs(java.lang.String valuation_amount_rs) {
		_sbiStartUp.setValuation_amount_rs(valuation_amount_rs);
	}

	/**
	* Returns the loan_avail_source of this sbi start up.
	*
	* @return the loan_avail_source of this sbi start up
	*/
	public java.lang.String getLoan_avail_source() {
		return _sbiStartUp.getLoan_avail_source();
	}

	/**
	* Sets the loan_avail_source of this sbi start up.
	*
	* @param loan_avail_source the loan_avail_source of this sbi start up
	*/
	public void setLoan_avail_source(java.lang.String loan_avail_source) {
		_sbiStartUp.setLoan_avail_source(loan_avail_source);
	}

	/**
	* Returns the loan_avail_rs of this sbi start up.
	*
	* @return the loan_avail_rs of this sbi start up
	*/
	public java.lang.String getLoan_avail_rs() {
		return _sbiStartUp.getLoan_avail_rs();
	}

	/**
	* Sets the loan_avail_rs of this sbi start up.
	*
	* @param loan_avail_rs the loan_avail_rs of this sbi start up
	*/
	public void setLoan_avail_rs(java.lang.String loan_avail_rs) {
		_sbiStartUp.setLoan_avail_rs(loan_avail_rs);
	}

	/**
	* Returns the gross_revenue_year1 of this sbi start up.
	*
	* @return the gross_revenue_year1 of this sbi start up
	*/
	public java.lang.String getGross_revenue_year1() {
		return _sbiStartUp.getGross_revenue_year1();
	}

	/**
	* Sets the gross_revenue_year1 of this sbi start up.
	*
	* @param gross_revenue_year1 the gross_revenue_year1 of this sbi start up
	*/
	public void setGross_revenue_year1(java.lang.String gross_revenue_year1) {
		_sbiStartUp.setGross_revenue_year1(gross_revenue_year1);
	}

	/**
	* Returns the gross_revenue_rs1 of this sbi start up.
	*
	* @return the gross_revenue_rs1 of this sbi start up
	*/
	public java.lang.String getGross_revenue_rs1() {
		return _sbiStartUp.getGross_revenue_rs1();
	}

	/**
	* Sets the gross_revenue_rs1 of this sbi start up.
	*
	* @param gross_revenue_rs1 the gross_revenue_rs1 of this sbi start up
	*/
	public void setGross_revenue_rs1(java.lang.String gross_revenue_rs1) {
		_sbiStartUp.setGross_revenue_rs1(gross_revenue_rs1);
	}

	/**
	* Returns the gross_revenue_year2 of this sbi start up.
	*
	* @return the gross_revenue_year2 of this sbi start up
	*/
	public java.lang.String getGross_revenue_year2() {
		return _sbiStartUp.getGross_revenue_year2();
	}

	/**
	* Sets the gross_revenue_year2 of this sbi start up.
	*
	* @param gross_revenue_year2 the gross_revenue_year2 of this sbi start up
	*/
	public void setGross_revenue_year2(java.lang.String gross_revenue_year2) {
		_sbiStartUp.setGross_revenue_year2(gross_revenue_year2);
	}

	/**
	* Returns the gross_revenue_rs2 of this sbi start up.
	*
	* @return the gross_revenue_rs2 of this sbi start up
	*/
	public java.lang.String getGross_revenue_rs2() {
		return _sbiStartUp.getGross_revenue_rs2();
	}

	/**
	* Sets the gross_revenue_rs2 of this sbi start up.
	*
	* @param gross_revenue_rs2 the gross_revenue_rs2 of this sbi start up
	*/
	public void setGross_revenue_rs2(java.lang.String gross_revenue_rs2) {
		_sbiStartUp.setGross_revenue_rs2(gross_revenue_rs2);
	}

	/**
	* Returns the gross_revenue_year3 of this sbi start up.
	*
	* @return the gross_revenue_year3 of this sbi start up
	*/
	public java.lang.String getGross_revenue_year3() {
		return _sbiStartUp.getGross_revenue_year3();
	}

	/**
	* Sets the gross_revenue_year3 of this sbi start up.
	*
	* @param gross_revenue_year3 the gross_revenue_year3 of this sbi start up
	*/
	public void setGross_revenue_year3(java.lang.String gross_revenue_year3) {
		_sbiStartUp.setGross_revenue_year3(gross_revenue_year3);
	}

	/**
	* Returns the gross_revenue_rs3 of this sbi start up.
	*
	* @return the gross_revenue_rs3 of this sbi start up
	*/
	public java.lang.String getGross_revenue_rs3() {
		return _sbiStartUp.getGross_revenue_rs3();
	}

	/**
	* Sets the gross_revenue_rs3 of this sbi start up.
	*
	* @param gross_revenue_rs3 the gross_revenue_rs3 of this sbi start up
	*/
	public void setGross_revenue_rs3(java.lang.String gross_revenue_rs3) {
		_sbiStartUp.setGross_revenue_rs3(gross_revenue_rs3);
	}

	/**
	* Returns the ebidta_year1 of this sbi start up.
	*
	* @return the ebidta_year1 of this sbi start up
	*/
	public java.lang.String getEbidta_year1() {
		return _sbiStartUp.getEbidta_year1();
	}

	/**
	* Sets the ebidta_year1 of this sbi start up.
	*
	* @param ebidta_year1 the ebidta_year1 of this sbi start up
	*/
	public void setEbidta_year1(java.lang.String ebidta_year1) {
		_sbiStartUp.setEbidta_year1(ebidta_year1);
	}

	/**
	* Returns the ebidta_rs1 of this sbi start up.
	*
	* @return the ebidta_rs1 of this sbi start up
	*/
	public java.lang.String getEbidta_rs1() {
		return _sbiStartUp.getEbidta_rs1();
	}

	/**
	* Sets the ebidta_rs1 of this sbi start up.
	*
	* @param ebidta_rs1 the ebidta_rs1 of this sbi start up
	*/
	public void setEbidta_rs1(java.lang.String ebidta_rs1) {
		_sbiStartUp.setEbidta_rs1(ebidta_rs1);
	}

	/**
	* Returns the ebidta_year2 of this sbi start up.
	*
	* @return the ebidta_year2 of this sbi start up
	*/
	public java.lang.String getEbidta_year2() {
		return _sbiStartUp.getEbidta_year2();
	}

	/**
	* Sets the ebidta_year2 of this sbi start up.
	*
	* @param ebidta_year2 the ebidta_year2 of this sbi start up
	*/
	public void setEbidta_year2(java.lang.String ebidta_year2) {
		_sbiStartUp.setEbidta_year2(ebidta_year2);
	}

	/**
	* Returns the ebidta_rs2 of this sbi start up.
	*
	* @return the ebidta_rs2 of this sbi start up
	*/
	public java.lang.String getEbidta_rs2() {
		return _sbiStartUp.getEbidta_rs2();
	}

	/**
	* Sets the ebidta_rs2 of this sbi start up.
	*
	* @param ebidta_rs2 the ebidta_rs2 of this sbi start up
	*/
	public void setEbidta_rs2(java.lang.String ebidta_rs2) {
		_sbiStartUp.setEbidta_rs2(ebidta_rs2);
	}

	/**
	* Returns the ebidta_year3 of this sbi start up.
	*
	* @return the ebidta_year3 of this sbi start up
	*/
	public java.lang.String getEbidta_year3() {
		return _sbiStartUp.getEbidta_year3();
	}

	/**
	* Sets the ebidta_year3 of this sbi start up.
	*
	* @param ebidta_year3 the ebidta_year3 of this sbi start up
	*/
	public void setEbidta_year3(java.lang.String ebidta_year3) {
		_sbiStartUp.setEbidta_year3(ebidta_year3);
	}

	/**
	* Returns the ebidta_rs3 of this sbi start up.
	*
	* @return the ebidta_rs3 of this sbi start up
	*/
	public java.lang.String getEbidta_rs3() {
		return _sbiStartUp.getEbidta_rs3();
	}

	/**
	* Sets the ebidta_rs3 of this sbi start up.
	*
	* @param ebidta_rs3 the ebidta_rs3 of this sbi start up
	*/
	public void setEbidta_rs3(java.lang.String ebidta_rs3) {
		_sbiStartUp.setEbidta_rs3(ebidta_rs3);
	}

	/**
	* Returns the gross_revenue_projected_year1 of this sbi start up.
	*
	* @return the gross_revenue_projected_year1 of this sbi start up
	*/
	public java.lang.String getGross_revenue_projected_year1() {
		return _sbiStartUp.getGross_revenue_projected_year1();
	}

	/**
	* Sets the gross_revenue_projected_year1 of this sbi start up.
	*
	* @param gross_revenue_projected_year1 the gross_revenue_projected_year1 of this sbi start up
	*/
	public void setGross_revenue_projected_year1(
		java.lang.String gross_revenue_projected_year1) {
		_sbiStartUp.setGross_revenue_projected_year1(gross_revenue_projected_year1);
	}

	/**
	* Returns the projected_revenue_rs1 of this sbi start up.
	*
	* @return the projected_revenue_rs1 of this sbi start up
	*/
	public java.lang.String getProjected_revenue_rs1() {
		return _sbiStartUp.getProjected_revenue_rs1();
	}

	/**
	* Sets the projected_revenue_rs1 of this sbi start up.
	*
	* @param projected_revenue_rs1 the projected_revenue_rs1 of this sbi start up
	*/
	public void setProjected_revenue_rs1(java.lang.String projected_revenue_rs1) {
		_sbiStartUp.setProjected_revenue_rs1(projected_revenue_rs1);
	}

	/**
	* Returns the gross_revenue_projected_year2 of this sbi start up.
	*
	* @return the gross_revenue_projected_year2 of this sbi start up
	*/
	public java.lang.String getGross_revenue_projected_year2() {
		return _sbiStartUp.getGross_revenue_projected_year2();
	}

	/**
	* Sets the gross_revenue_projected_year2 of this sbi start up.
	*
	* @param gross_revenue_projected_year2 the gross_revenue_projected_year2 of this sbi start up
	*/
	public void setGross_revenue_projected_year2(
		java.lang.String gross_revenue_projected_year2) {
		_sbiStartUp.setGross_revenue_projected_year2(gross_revenue_projected_year2);
	}

	/**
	* Returns the projected_revenue_rs2 of this sbi start up.
	*
	* @return the projected_revenue_rs2 of this sbi start up
	*/
	public java.lang.String getProjected_revenue_rs2() {
		return _sbiStartUp.getProjected_revenue_rs2();
	}

	/**
	* Sets the projected_revenue_rs2 of this sbi start up.
	*
	* @param projected_revenue_rs2 the projected_revenue_rs2 of this sbi start up
	*/
	public void setProjected_revenue_rs2(java.lang.String projected_revenue_rs2) {
		_sbiStartUp.setProjected_revenue_rs2(projected_revenue_rs2);
	}

	/**
	* Returns the gross_revenue_projected_year3 of this sbi start up.
	*
	* @return the gross_revenue_projected_year3 of this sbi start up
	*/
	public java.lang.String getGross_revenue_projected_year3() {
		return _sbiStartUp.getGross_revenue_projected_year3();
	}

	/**
	* Sets the gross_revenue_projected_year3 of this sbi start up.
	*
	* @param gross_revenue_projected_year3 the gross_revenue_projected_year3 of this sbi start up
	*/
	public void setGross_revenue_projected_year3(
		java.lang.String gross_revenue_projected_year3) {
		_sbiStartUp.setGross_revenue_projected_year3(gross_revenue_projected_year3);
	}

	/**
	* Returns the projected_revenue_rs3 of this sbi start up.
	*
	* @return the projected_revenue_rs3 of this sbi start up
	*/
	public java.lang.String getProjected_revenue_rs3() {
		return _sbiStartUp.getProjected_revenue_rs3();
	}

	/**
	* Sets the projected_revenue_rs3 of this sbi start up.
	*
	* @param projected_revenue_rs3 the projected_revenue_rs3 of this sbi start up
	*/
	public void setProjected_revenue_rs3(java.lang.String projected_revenue_rs3) {
		_sbiStartUp.setProjected_revenue_rs3(projected_revenue_rs3);
	}

	/**
	* Returns the projected_ebidta_year1 of this sbi start up.
	*
	* @return the projected_ebidta_year1 of this sbi start up
	*/
	public java.lang.String getProjected_ebidta_year1() {
		return _sbiStartUp.getProjected_ebidta_year1();
	}

	/**
	* Sets the projected_ebidta_year1 of this sbi start up.
	*
	* @param projected_ebidta_year1 the projected_ebidta_year1 of this sbi start up
	*/
	public void setProjected_ebidta_year1(
		java.lang.String projected_ebidta_year1) {
		_sbiStartUp.setProjected_ebidta_year1(projected_ebidta_year1);
	}

	/**
	* Returns the projected_ebidta_rs1 of this sbi start up.
	*
	* @return the projected_ebidta_rs1 of this sbi start up
	*/
	public java.lang.String getProjected_ebidta_rs1() {
		return _sbiStartUp.getProjected_ebidta_rs1();
	}

	/**
	* Sets the projected_ebidta_rs1 of this sbi start up.
	*
	* @param projected_ebidta_rs1 the projected_ebidta_rs1 of this sbi start up
	*/
	public void setProjected_ebidta_rs1(java.lang.String projected_ebidta_rs1) {
		_sbiStartUp.setProjected_ebidta_rs1(projected_ebidta_rs1);
	}

	/**
	* Returns the projected_ebidta_year2 of this sbi start up.
	*
	* @return the projected_ebidta_year2 of this sbi start up
	*/
	public java.lang.String getProjected_ebidta_year2() {
		return _sbiStartUp.getProjected_ebidta_year2();
	}

	/**
	* Sets the projected_ebidta_year2 of this sbi start up.
	*
	* @param projected_ebidta_year2 the projected_ebidta_year2 of this sbi start up
	*/
	public void setProjected_ebidta_year2(
		java.lang.String projected_ebidta_year2) {
		_sbiStartUp.setProjected_ebidta_year2(projected_ebidta_year2);
	}

	/**
	* Returns the projected_ebidta_rs2 of this sbi start up.
	*
	* @return the projected_ebidta_rs2 of this sbi start up
	*/
	public java.lang.String getProjected_ebidta_rs2() {
		return _sbiStartUp.getProjected_ebidta_rs2();
	}

	/**
	* Sets the projected_ebidta_rs2 of this sbi start up.
	*
	* @param projected_ebidta_rs2 the projected_ebidta_rs2 of this sbi start up
	*/
	public void setProjected_ebidta_rs2(java.lang.String projected_ebidta_rs2) {
		_sbiStartUp.setProjected_ebidta_rs2(projected_ebidta_rs2);
	}

	/**
	* Returns the projected_ebidta_year3 of this sbi start up.
	*
	* @return the projected_ebidta_year3 of this sbi start up
	*/
	public java.lang.String getProjected_ebidta_year3() {
		return _sbiStartUp.getProjected_ebidta_year3();
	}

	/**
	* Sets the projected_ebidta_year3 of this sbi start up.
	*
	* @param projected_ebidta_year3 the projected_ebidta_year3 of this sbi start up
	*/
	public void setProjected_ebidta_year3(
		java.lang.String projected_ebidta_year3) {
		_sbiStartUp.setProjected_ebidta_year3(projected_ebidta_year3);
	}

	/**
	* Returns the projected_ebidta_rs3 of this sbi start up.
	*
	* @return the projected_ebidta_rs3 of this sbi start up
	*/
	public java.lang.String getProjected_ebidta_rs3() {
		return _sbiStartUp.getProjected_ebidta_rs3();
	}

	/**
	* Sets the projected_ebidta_rs3 of this sbi start up.
	*
	* @param projected_ebidta_rs3 the projected_ebidta_rs3 of this sbi start up
	*/
	public void setProjected_ebidta_rs3(java.lang.String projected_ebidta_rs3) {
		_sbiStartUp.setProjected_ebidta_rs3(projected_ebidta_rs3);
	}

	/**
	* Returns the projected_net_profit_year1 of this sbi start up.
	*
	* @return the projected_net_profit_year1 of this sbi start up
	*/
	public java.lang.String getProjected_net_profit_year1() {
		return _sbiStartUp.getProjected_net_profit_year1();
	}

	/**
	* Sets the projected_net_profit_year1 of this sbi start up.
	*
	* @param projected_net_profit_year1 the projected_net_profit_year1 of this sbi start up
	*/
	public void setProjected_net_profit_year1(
		java.lang.String projected_net_profit_year1) {
		_sbiStartUp.setProjected_net_profit_year1(projected_net_profit_year1);
	}

	/**
	* Returns the projected_net_profit_rs1 of this sbi start up.
	*
	* @return the projected_net_profit_rs1 of this sbi start up
	*/
	public java.lang.String getProjected_net_profit_rs1() {
		return _sbiStartUp.getProjected_net_profit_rs1();
	}

	/**
	* Sets the projected_net_profit_rs1 of this sbi start up.
	*
	* @param projected_net_profit_rs1 the projected_net_profit_rs1 of this sbi start up
	*/
	public void setProjected_net_profit_rs1(
		java.lang.String projected_net_profit_rs1) {
		_sbiStartUp.setProjected_net_profit_rs1(projected_net_profit_rs1);
	}

	/**
	* Returns the projected_net_profit_year2 of this sbi start up.
	*
	* @return the projected_net_profit_year2 of this sbi start up
	*/
	public java.lang.String getProjected_net_profit_year2() {
		return _sbiStartUp.getProjected_net_profit_year2();
	}

	/**
	* Sets the projected_net_profit_year2 of this sbi start up.
	*
	* @param projected_net_profit_year2 the projected_net_profit_year2 of this sbi start up
	*/
	public void setProjected_net_profit_year2(
		java.lang.String projected_net_profit_year2) {
		_sbiStartUp.setProjected_net_profit_year2(projected_net_profit_year2);
	}

	/**
	* Returns the projected_net_profit_rs2 of this sbi start up.
	*
	* @return the projected_net_profit_rs2 of this sbi start up
	*/
	public java.lang.String getProjected_net_profit_rs2() {
		return _sbiStartUp.getProjected_net_profit_rs2();
	}

	/**
	* Sets the projected_net_profit_rs2 of this sbi start up.
	*
	* @param projected_net_profit_rs2 the projected_net_profit_rs2 of this sbi start up
	*/
	public void setProjected_net_profit_rs2(
		java.lang.String projected_net_profit_rs2) {
		_sbiStartUp.setProjected_net_profit_rs2(projected_net_profit_rs2);
	}

	/**
	* Returns the projected_net_profit_year3 of this sbi start up.
	*
	* @return the projected_net_profit_year3 of this sbi start up
	*/
	public java.lang.String getProjected_net_profit_year3() {
		return _sbiStartUp.getProjected_net_profit_year3();
	}

	/**
	* Sets the projected_net_profit_year3 of this sbi start up.
	*
	* @param projected_net_profit_year3 the projected_net_profit_year3 of this sbi start up
	*/
	public void setProjected_net_profit_year3(
		java.lang.String projected_net_profit_year3) {
		_sbiStartUp.setProjected_net_profit_year3(projected_net_profit_year3);
	}

	/**
	* Returns the projected_net_profit_rs3 of this sbi start up.
	*
	* @return the projected_net_profit_rs3 of this sbi start up
	*/
	public java.lang.String getProjected_net_profit_rs3() {
		return _sbiStartUp.getProjected_net_profit_rs3();
	}

	/**
	* Sets the projected_net_profit_rs3 of this sbi start up.
	*
	* @param projected_net_profit_rs3 the projected_net_profit_rs3 of this sbi start up
	*/
	public void setProjected_net_profit_rs3(
		java.lang.String projected_net_profit_rs3) {
		_sbiStartUp.setProjected_net_profit_rs3(projected_net_profit_rs3);
	}

	/**
	* Returns the net_profit_year1 of this sbi start up.
	*
	* @return the net_profit_year1 of this sbi start up
	*/
	public java.lang.String getNet_profit_year1() {
		return _sbiStartUp.getNet_profit_year1();
	}

	/**
	* Sets the net_profit_year1 of this sbi start up.
	*
	* @param net_profit_year1 the net_profit_year1 of this sbi start up
	*/
	public void setNet_profit_year1(java.lang.String net_profit_year1) {
		_sbiStartUp.setNet_profit_year1(net_profit_year1);
	}

	/**
	* Returns the net_profit_rs1 of this sbi start up.
	*
	* @return the net_profit_rs1 of this sbi start up
	*/
	public java.lang.String getNet_profit_rs1() {
		return _sbiStartUp.getNet_profit_rs1();
	}

	/**
	* Sets the net_profit_rs1 of this sbi start up.
	*
	* @param net_profit_rs1 the net_profit_rs1 of this sbi start up
	*/
	public void setNet_profit_rs1(java.lang.String net_profit_rs1) {
		_sbiStartUp.setNet_profit_rs1(net_profit_rs1);
	}

	/**
	* Returns the net_profit_year2 of this sbi start up.
	*
	* @return the net_profit_year2 of this sbi start up
	*/
	public java.lang.String getNet_profit_year2() {
		return _sbiStartUp.getNet_profit_year2();
	}

	/**
	* Sets the net_profit_year2 of this sbi start up.
	*
	* @param net_profit_year2 the net_profit_year2 of this sbi start up
	*/
	public void setNet_profit_year2(java.lang.String net_profit_year2) {
		_sbiStartUp.setNet_profit_year2(net_profit_year2);
	}

	/**
	* Returns the net_profit_rs2 of this sbi start up.
	*
	* @return the net_profit_rs2 of this sbi start up
	*/
	public java.lang.String getNet_profit_rs2() {
		return _sbiStartUp.getNet_profit_rs2();
	}

	/**
	* Sets the net_profit_rs2 of this sbi start up.
	*
	* @param net_profit_rs2 the net_profit_rs2 of this sbi start up
	*/
	public void setNet_profit_rs2(java.lang.String net_profit_rs2) {
		_sbiStartUp.setNet_profit_rs2(net_profit_rs2);
	}

	/**
	* Returns the net_profit_year3 of this sbi start up.
	*
	* @return the net_profit_year3 of this sbi start up
	*/
	public java.lang.String getNet_profit_year3() {
		return _sbiStartUp.getNet_profit_year3();
	}

	/**
	* Sets the net_profit_year3 of this sbi start up.
	*
	* @param net_profit_year3 the net_profit_year3 of this sbi start up
	*/
	public void setNet_profit_year3(java.lang.String net_profit_year3) {
		_sbiStartUp.setNet_profit_year3(net_profit_year3);
	}

	/**
	* Returns the net_profit_rs3 of this sbi start up.
	*
	* @return the net_profit_rs3 of this sbi start up
	*/
	public java.lang.String getNet_profit_rs3() {
		return _sbiStartUp.getNet_profit_rs3();
	}

	/**
	* Sets the net_profit_rs3 of this sbi start up.
	*
	* @param net_profit_rs3 the net_profit_rs3 of this sbi start up
	*/
	public void setNet_profit_rs3(java.lang.String net_profit_rs3) {
		_sbiStartUp.setNet_profit_rs3(net_profit_rs3);
	}

	/**
	* Returns the financial_bank_engagement of this sbi start up.
	*
	* @return the financial_bank_engagement of this sbi start up
	*/
	public java.lang.String getFinancial_bank_engagement() {
		return _sbiStartUp.getFinancial_bank_engagement();
	}

	/**
	* Sets the financial_bank_engagement of this sbi start up.
	*
	* @param financial_bank_engagement the financial_bank_engagement of this sbi start up
	*/
	public void setFinancial_bank_engagement(
		java.lang.String financial_bank_engagement) {
		_sbiStartUp.setFinancial_bank_engagement(financial_bank_engagement);
	}

	/**
	* Returns the financial_assistance of this sbi start up.
	*
	* @return the financial_assistance of this sbi start up
	*/
	public java.lang.String getFinancial_assistance() {
		return _sbiStartUp.getFinancial_assistance();
	}

	/**
	* Sets the financial_assistance of this sbi start up.
	*
	* @param financial_assistance the financial_assistance of this sbi start up
	*/
	public void setFinancial_assistance(java.lang.String financial_assistance) {
		_sbiStartUp.setFinancial_assistance(financial_assistance);
	}

	/**
	* Returns the financial_assi_purp of this sbi start up.
	*
	* @return the financial_assi_purp of this sbi start up
	*/
	public java.lang.String getFinancial_assi_purp() {
		return _sbiStartUp.getFinancial_assi_purp();
	}

	/**
	* Sets the financial_assi_purp of this sbi start up.
	*
	* @param financial_assi_purp the financial_assi_purp of this sbi start up
	*/
	public void setFinancial_assi_purp(java.lang.String financial_assi_purp) {
		_sbiStartUp.setFinancial_assi_purp(financial_assi_purp);
	}

	/**
	* Returns the agreeable_process of this sbi start up.
	*
	* @return the agreeable_process of this sbi start up
	*/
	public java.lang.String getAgreeable_process() {
		return _sbiStartUp.getAgreeable_process();
	}

	/**
	* Sets the agreeable_process of this sbi start up.
	*
	* @param agreeable_process the agreeable_process of this sbi start up
	*/
	public void setAgreeable_process(java.lang.String agreeable_process) {
		_sbiStartUp.setAgreeable_process(agreeable_process);
	}

	/**
	* Returns the gsr_department of this sbi start up.
	*
	* @return the gsr_department of this sbi start up
	*/
	public java.lang.String getGsr_department() {
		return _sbiStartUp.getGsr_department();
	}

	/**
	* Sets the gsr_department of this sbi start up.
	*
	* @param gsr_department the gsr_department of this sbi start up
	*/
	public void setGsr_department(java.lang.String gsr_department) {
		_sbiStartUp.setGsr_department(gsr_department);
	}

	/**
	* Returns the startupindia of this sbi start up.
	*
	* @return the startupindia of this sbi start up
	*/
	public java.lang.String getStartupindia() {
		return _sbiStartUp.getStartupindia();
	}

	/**
	* Sets the startupindia of this sbi start up.
	*
	* @param startupindia the startupindia of this sbi start up
	*/
	public void setStartupindia(java.lang.String startupindia) {
		_sbiStartUp.setStartupindia(startupindia);
	}

	/**
	* Returns the incubator of this sbi start up.
	*
	* @return the incubator of this sbi start up
	*/
	public java.lang.String getIncubator() {
		return _sbiStartUp.getIncubator();
	}

	/**
	* Sets the incubator of this sbi start up.
	*
	* @param incubator the incubator of this sbi start up
	*/
	public void setIncubator(java.lang.String incubator) {
		_sbiStartUp.setIncubator(incubator);
	}

	/**
	* Returns the status of this sbi start up.
	*
	* @return the status of this sbi start up
	*/
	public java.lang.String getStatus() {
		return _sbiStartUp.getStatus();
	}

	/**
	* Sets the status of this sbi start up.
	*
	* @param status the status of this sbi start up
	*/
	public void setStatus(java.lang.String status) {
		_sbiStartUp.setStatus(status);
	}

	/**
	* Returns the flag of this sbi start up.
	*
	* @return the flag of this sbi start up
	*/
	public boolean getFlag() {
		return _sbiStartUp.getFlag();
	}

	/**
	* Returns <code>true</code> if this sbi start up is flag.
	*
	* @return <code>true</code> if this sbi start up is flag; <code>false</code> otherwise
	*/
	public boolean isFlag() {
		return _sbiStartUp.isFlag();
	}

	/**
	* Sets whether this sbi start up is flag.
	*
	* @param flag the flag of this sbi start up
	*/
	public void setFlag(boolean flag) {
		_sbiStartUp.setFlag(flag);
	}

	public boolean isNew() {
		return _sbiStartUp.isNew();
	}

	public void setNew(boolean n) {
		_sbiStartUp.setNew(n);
	}

	public boolean isCachedModel() {
		return _sbiStartUp.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_sbiStartUp.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _sbiStartUp.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _sbiStartUp.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_sbiStartUp.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _sbiStartUp.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_sbiStartUp.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SbiStartUpWrapper((SbiStartUp)_sbiStartUp.clone());
	}

	public int compareTo(com.sbi.StartUp.model.SbiStartUp sbiStartUp) {
		return _sbiStartUp.compareTo(sbiStartUp);
	}

	@Override
	public int hashCode() {
		return _sbiStartUp.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.sbi.StartUp.model.SbiStartUp> toCacheModel() {
		return _sbiStartUp.toCacheModel();
	}

	public com.sbi.StartUp.model.SbiStartUp toEscapedModel() {
		return new SbiStartUpWrapper(_sbiStartUp.toEscapedModel());
	}

	public com.sbi.StartUp.model.SbiStartUp toUnescapedModel() {
		return new SbiStartUpWrapper(_sbiStartUp.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _sbiStartUp.toString();
	}

	public java.lang.String toXmlString() {
		return _sbiStartUp.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_sbiStartUp.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SbiStartUpWrapper)) {
			return false;
		}

		SbiStartUpWrapper sbiStartUpWrapper = (SbiStartUpWrapper)obj;

		if (Validator.equals(_sbiStartUp, sbiStartUpWrapper._sbiStartUp)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public SbiStartUp getWrappedSbiStartUp() {
		return _sbiStartUp;
	}

	public SbiStartUp getWrappedModel() {
		return _sbiStartUp;
	}

	public void resetOriginalValues() {
		_sbiStartUp.resetOriginalValues();
	}

	private SbiStartUp _sbiStartUp;
}