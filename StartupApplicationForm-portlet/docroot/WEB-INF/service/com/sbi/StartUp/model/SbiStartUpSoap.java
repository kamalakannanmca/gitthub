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
 * This class is used by SOAP remote services, specifically {@link com.sbi.StartUp.service.http.SbiStartUpServiceSoap}.
 *
 * @author    MAH97223
 * @see       com.sbi.StartUp.service.http.SbiStartUpServiceSoap
 * @generated
 */
public class SbiStartUpSoap implements Serializable {
	public static SbiStartUpSoap toSoapModel(SbiStartUp model) {
		SbiStartUpSoap soapModel = new SbiStartUpSoap();

		soapModel.setRegnum(model.getRegnum());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setRegistered_name(model.getRegistered_name());
		soapModel.setDate_of_establishment(model.getDate_of_establishment());
		soapModel.setConstitution(model.getConstitution());
		soapModel.setAddress_line_1(model.getAddress_line_1());
		soapModel.setAddress_line_2(model.getAddress_line_2());
		soapModel.setAddress_landmark(model.getAddress_landmark());
		soapModel.setAddress_city(model.getAddress_city());
		soapModel.setAddress_pin(model.getAddress_pin());
		soapModel.setAddress_state(model.getAddress_state());
		soapModel.setCorporate_email(model.getCorporate_email());
		soapModel.setCorporate_website(model.getCorporate_website());
		soapModel.setInitial_founders(model.getInitial_founders());
		soapModel.setCurrent_promoters_name(model.getCurrent_promoters_name());
		soapModel.setNoofemp(model.getNoofemp());
		soapModel.setDescription_of_product(model.getDescription_of_product());
		soapModel.setInitial_capital(model.getInitial_capital());
		soapModel.setMonetary_value(model.getMonetary_value());
		soapModel.setBusiness_model(model.getBusiness_model());
		soapModel.setCurrent_capital(model.getCurrent_capital());
		soapModel.setCapital_infusion(model.getCapital_infusion());
		soapModel.setLoans_availed(model.getLoans_availed());
		soapModel.setValuer_name(model.getValuer_name());
		soapModel.setValuation_date(model.getValuation_date());
		soapModel.setValuation_amount_rs(model.getValuation_amount_rs());
		soapModel.setLoan_avail_source(model.getLoan_avail_source());
		soapModel.setLoan_avail_rs(model.getLoan_avail_rs());
		soapModel.setGross_revenue_year1(model.getGross_revenue_year1());
		soapModel.setGross_revenue_rs1(model.getGross_revenue_rs1());
		soapModel.setGross_revenue_year2(model.getGross_revenue_year2());
		soapModel.setGross_revenue_rs2(model.getGross_revenue_rs2());
		soapModel.setGross_revenue_year3(model.getGross_revenue_year3());
		soapModel.setGross_revenue_rs3(model.getGross_revenue_rs3());
		soapModel.setEbidta_year1(model.getEbidta_year1());
		soapModel.setEbidta_rs1(model.getEbidta_rs1());
		soapModel.setEbidta_year2(model.getEbidta_year2());
		soapModel.setEbidta_rs2(model.getEbidta_rs2());
		soapModel.setEbidta_year3(model.getEbidta_year3());
		soapModel.setEbidta_rs3(model.getEbidta_rs3());
		soapModel.setGross_revenue_projected_year1(model.getGross_revenue_projected_year1());
		soapModel.setProjected_revenue_rs1(model.getProjected_revenue_rs1());
		soapModel.setGross_revenue_projected_year2(model.getGross_revenue_projected_year2());
		soapModel.setProjected_revenue_rs2(model.getProjected_revenue_rs2());
		soapModel.setGross_revenue_projected_year3(model.getGross_revenue_projected_year3());
		soapModel.setProjected_revenue_rs3(model.getProjected_revenue_rs3());
		soapModel.setProjected_ebidta_year1(model.getProjected_ebidta_year1());
		soapModel.setProjected_ebidta_rs1(model.getProjected_ebidta_rs1());
		soapModel.setProjected_ebidta_year2(model.getProjected_ebidta_year2());
		soapModel.setProjected_ebidta_rs2(model.getProjected_ebidta_rs2());
		soapModel.setProjected_ebidta_year3(model.getProjected_ebidta_year3());
		soapModel.setProjected_ebidta_rs3(model.getProjected_ebidta_rs3());
		soapModel.setProjected_net_profit_year1(model.getProjected_net_profit_year1());
		soapModel.setProjected_net_profit_rs1(model.getProjected_net_profit_rs1());
		soapModel.setProjected_net_profit_year2(model.getProjected_net_profit_year2());
		soapModel.setProjected_net_profit_rs2(model.getProjected_net_profit_rs2());
		soapModel.setProjected_net_profit_year3(model.getProjected_net_profit_year3());
		soapModel.setProjected_net_profit_rs3(model.getProjected_net_profit_rs3());
		soapModel.setNet_profit_year1(model.getNet_profit_year1());
		soapModel.setNet_profit_rs1(model.getNet_profit_rs1());
		soapModel.setNet_profit_year2(model.getNet_profit_year2());
		soapModel.setNet_profit_rs2(model.getNet_profit_rs2());
		soapModel.setNet_profit_year3(model.getNet_profit_year3());
		soapModel.setNet_profit_rs3(model.getNet_profit_rs3());
		soapModel.setFinancial_bank_engagement(model.getFinancial_bank_engagement());
		soapModel.setFinancial_assistance(model.getFinancial_assistance());
		soapModel.setFinancial_assi_purp(model.getFinancial_assi_purp());
		soapModel.setAgreeable_process(model.getAgreeable_process());
		soapModel.setGsr_department(model.getGsr_department());
		soapModel.setStartupindia(model.getStartupindia());
		soapModel.setIncubator(model.getIncubator());
		soapModel.setStatus(model.getStatus());
		soapModel.setFlag(model.getFlag());

		return soapModel;
	}

	public static SbiStartUpSoap[] toSoapModels(SbiStartUp[] models) {
		SbiStartUpSoap[] soapModels = new SbiStartUpSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SbiStartUpSoap[][] toSoapModels(SbiStartUp[][] models) {
		SbiStartUpSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SbiStartUpSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SbiStartUpSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SbiStartUpSoap[] toSoapModels(List<SbiStartUp> models) {
		List<SbiStartUpSoap> soapModels = new ArrayList<SbiStartUpSoap>(models.size());

		for (SbiStartUp model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SbiStartUpSoap[soapModels.size()]);
	}

	public SbiStartUpSoap() {
	}

	public String getPrimaryKey() {
		return _regnum;
	}

	public void setPrimaryKey(String pk) {
		setRegnum(pk);
	}

	public String getRegnum() {
		return _regnum;
	}

	public void setRegnum(String regnum) {
		_regnum = regnum;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
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

	public String getRegistered_name() {
		return _registered_name;
	}

	public void setRegistered_name(String registered_name) {
		_registered_name = registered_name;
	}

	public Date getDate_of_establishment() {
		return _date_of_establishment;
	}

	public void setDate_of_establishment(Date date_of_establishment) {
		_date_of_establishment = date_of_establishment;
	}

	public String getConstitution() {
		return _constitution;
	}

	public void setConstitution(String constitution) {
		_constitution = constitution;
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

	public String getCorporate_email() {
		return _corporate_email;
	}

	public void setCorporate_email(String corporate_email) {
		_corporate_email = corporate_email;
	}

	public String getCorporate_website() {
		return _corporate_website;
	}

	public void setCorporate_website(String corporate_website) {
		_corporate_website = corporate_website;
	}

	public String getInitial_founders() {
		return _initial_founders;
	}

	public void setInitial_founders(String initial_founders) {
		_initial_founders = initial_founders;
	}

	public String getCurrent_promoters_name() {
		return _current_promoters_name;
	}

	public void setCurrent_promoters_name(String current_promoters_name) {
		_current_promoters_name = current_promoters_name;
	}

	public String getNoofemp() {
		return _noofemp;
	}

	public void setNoofemp(String noofemp) {
		_noofemp = noofemp;
	}

	public String getDescription_of_product() {
		return _description_of_product;
	}

	public void setDescription_of_product(String description_of_product) {
		_description_of_product = description_of_product;
	}

	public String getInitial_capital() {
		return _initial_capital;
	}

	public void setInitial_capital(String initial_capital) {
		_initial_capital = initial_capital;
	}

	public String getMonetary_value() {
		return _monetary_value;
	}

	public void setMonetary_value(String monetary_value) {
		_monetary_value = monetary_value;
	}

	public String getBusiness_model() {
		return _business_model;
	}

	public void setBusiness_model(String business_model) {
		_business_model = business_model;
	}

	public String getCurrent_capital() {
		return _current_capital;
	}

	public void setCurrent_capital(String current_capital) {
		_current_capital = current_capital;
	}

	public String getCapital_infusion() {
		return _capital_infusion;
	}

	public void setCapital_infusion(String capital_infusion) {
		_capital_infusion = capital_infusion;
	}

	public String getLoans_availed() {
		return _Loans_availed;
	}

	public void setLoans_availed(String Loans_availed) {
		_Loans_availed = Loans_availed;
	}

	public String getValuer_name() {
		return _valuer_name;
	}

	public void setValuer_name(String valuer_name) {
		_valuer_name = valuer_name;
	}

	public Date getValuation_date() {
		return _valuation_date;
	}

	public void setValuation_date(Date valuation_date) {
		_valuation_date = valuation_date;
	}

	public String getValuation_amount_rs() {
		return _valuation_amount_rs;
	}

	public void setValuation_amount_rs(String valuation_amount_rs) {
		_valuation_amount_rs = valuation_amount_rs;
	}

	public String getLoan_avail_source() {
		return _loan_avail_source;
	}

	public void setLoan_avail_source(String loan_avail_source) {
		_loan_avail_source = loan_avail_source;
	}

	public String getLoan_avail_rs() {
		return _loan_avail_rs;
	}

	public void setLoan_avail_rs(String loan_avail_rs) {
		_loan_avail_rs = loan_avail_rs;
	}

	public String getGross_revenue_year1() {
		return _gross_revenue_year1;
	}

	public void setGross_revenue_year1(String gross_revenue_year1) {
		_gross_revenue_year1 = gross_revenue_year1;
	}

	public String getGross_revenue_rs1() {
		return _gross_revenue_rs1;
	}

	public void setGross_revenue_rs1(String gross_revenue_rs1) {
		_gross_revenue_rs1 = gross_revenue_rs1;
	}

	public String getGross_revenue_year2() {
		return _gross_revenue_year2;
	}

	public void setGross_revenue_year2(String gross_revenue_year2) {
		_gross_revenue_year2 = gross_revenue_year2;
	}

	public String getGross_revenue_rs2() {
		return _gross_revenue_rs2;
	}

	public void setGross_revenue_rs2(String gross_revenue_rs2) {
		_gross_revenue_rs2 = gross_revenue_rs2;
	}

	public String getGross_revenue_year3() {
		return _gross_revenue_year3;
	}

	public void setGross_revenue_year3(String gross_revenue_year3) {
		_gross_revenue_year3 = gross_revenue_year3;
	}

	public String getGross_revenue_rs3() {
		return _gross_revenue_rs3;
	}

	public void setGross_revenue_rs3(String gross_revenue_rs3) {
		_gross_revenue_rs3 = gross_revenue_rs3;
	}

	public String getEbidta_year1() {
		return _ebidta_year1;
	}

	public void setEbidta_year1(String ebidta_year1) {
		_ebidta_year1 = ebidta_year1;
	}

	public String getEbidta_rs1() {
		return _ebidta_rs1;
	}

	public void setEbidta_rs1(String ebidta_rs1) {
		_ebidta_rs1 = ebidta_rs1;
	}

	public String getEbidta_year2() {
		return _ebidta_year2;
	}

	public void setEbidta_year2(String ebidta_year2) {
		_ebidta_year2 = ebidta_year2;
	}

	public String getEbidta_rs2() {
		return _ebidta_rs2;
	}

	public void setEbidta_rs2(String ebidta_rs2) {
		_ebidta_rs2 = ebidta_rs2;
	}

	public String getEbidta_year3() {
		return _ebidta_year3;
	}

	public void setEbidta_year3(String ebidta_year3) {
		_ebidta_year3 = ebidta_year3;
	}

	public String getEbidta_rs3() {
		return _ebidta_rs3;
	}

	public void setEbidta_rs3(String ebidta_rs3) {
		_ebidta_rs3 = ebidta_rs3;
	}

	public String getGross_revenue_projected_year1() {
		return _gross_revenue_projected_year1;
	}

	public void setGross_revenue_projected_year1(
		String gross_revenue_projected_year1) {
		_gross_revenue_projected_year1 = gross_revenue_projected_year1;
	}

	public String getProjected_revenue_rs1() {
		return _projected_revenue_rs1;
	}

	public void setProjected_revenue_rs1(String projected_revenue_rs1) {
		_projected_revenue_rs1 = projected_revenue_rs1;
	}

	public String getGross_revenue_projected_year2() {
		return _gross_revenue_projected_year2;
	}

	public void setGross_revenue_projected_year2(
		String gross_revenue_projected_year2) {
		_gross_revenue_projected_year2 = gross_revenue_projected_year2;
	}

	public String getProjected_revenue_rs2() {
		return _projected_revenue_rs2;
	}

	public void setProjected_revenue_rs2(String projected_revenue_rs2) {
		_projected_revenue_rs2 = projected_revenue_rs2;
	}

	public String getGross_revenue_projected_year3() {
		return _gross_revenue_projected_year3;
	}

	public void setGross_revenue_projected_year3(
		String gross_revenue_projected_year3) {
		_gross_revenue_projected_year3 = gross_revenue_projected_year3;
	}

	public String getProjected_revenue_rs3() {
		return _projected_revenue_rs3;
	}

	public void setProjected_revenue_rs3(String projected_revenue_rs3) {
		_projected_revenue_rs3 = projected_revenue_rs3;
	}

	public String getProjected_ebidta_year1() {
		return _projected_ebidta_year1;
	}

	public void setProjected_ebidta_year1(String projected_ebidta_year1) {
		_projected_ebidta_year1 = projected_ebidta_year1;
	}

	public String getProjected_ebidta_rs1() {
		return _projected_ebidta_rs1;
	}

	public void setProjected_ebidta_rs1(String projected_ebidta_rs1) {
		_projected_ebidta_rs1 = projected_ebidta_rs1;
	}

	public String getProjected_ebidta_year2() {
		return _projected_ebidta_year2;
	}

	public void setProjected_ebidta_year2(String projected_ebidta_year2) {
		_projected_ebidta_year2 = projected_ebidta_year2;
	}

	public String getProjected_ebidta_rs2() {
		return _projected_ebidta_rs2;
	}

	public void setProjected_ebidta_rs2(String projected_ebidta_rs2) {
		_projected_ebidta_rs2 = projected_ebidta_rs2;
	}

	public String getProjected_ebidta_year3() {
		return _projected_ebidta_year3;
	}

	public void setProjected_ebidta_year3(String projected_ebidta_year3) {
		_projected_ebidta_year3 = projected_ebidta_year3;
	}

	public String getProjected_ebidta_rs3() {
		return _projected_ebidta_rs3;
	}

	public void setProjected_ebidta_rs3(String projected_ebidta_rs3) {
		_projected_ebidta_rs3 = projected_ebidta_rs3;
	}

	public String getProjected_net_profit_year1() {
		return _projected_net_profit_year1;
	}

	public void setProjected_net_profit_year1(String projected_net_profit_year1) {
		_projected_net_profit_year1 = projected_net_profit_year1;
	}

	public String getProjected_net_profit_rs1() {
		return _projected_net_profit_rs1;
	}

	public void setProjected_net_profit_rs1(String projected_net_profit_rs1) {
		_projected_net_profit_rs1 = projected_net_profit_rs1;
	}

	public String getProjected_net_profit_year2() {
		return _projected_net_profit_year2;
	}

	public void setProjected_net_profit_year2(String projected_net_profit_year2) {
		_projected_net_profit_year2 = projected_net_profit_year2;
	}

	public String getProjected_net_profit_rs2() {
		return _projected_net_profit_rs2;
	}

	public void setProjected_net_profit_rs2(String projected_net_profit_rs2) {
		_projected_net_profit_rs2 = projected_net_profit_rs2;
	}

	public String getProjected_net_profit_year3() {
		return _projected_net_profit_year3;
	}

	public void setProjected_net_profit_year3(String projected_net_profit_year3) {
		_projected_net_profit_year3 = projected_net_profit_year3;
	}

	public String getProjected_net_profit_rs3() {
		return _projected_net_profit_rs3;
	}

	public void setProjected_net_profit_rs3(String projected_net_profit_rs3) {
		_projected_net_profit_rs3 = projected_net_profit_rs3;
	}

	public String getNet_profit_year1() {
		return _net_profit_year1;
	}

	public void setNet_profit_year1(String net_profit_year1) {
		_net_profit_year1 = net_profit_year1;
	}

	public String getNet_profit_rs1() {
		return _net_profit_rs1;
	}

	public void setNet_profit_rs1(String net_profit_rs1) {
		_net_profit_rs1 = net_profit_rs1;
	}

	public String getNet_profit_year2() {
		return _net_profit_year2;
	}

	public void setNet_profit_year2(String net_profit_year2) {
		_net_profit_year2 = net_profit_year2;
	}

	public String getNet_profit_rs2() {
		return _net_profit_rs2;
	}

	public void setNet_profit_rs2(String net_profit_rs2) {
		_net_profit_rs2 = net_profit_rs2;
	}

	public String getNet_profit_year3() {
		return _net_profit_year3;
	}

	public void setNet_profit_year3(String net_profit_year3) {
		_net_profit_year3 = net_profit_year3;
	}

	public String getNet_profit_rs3() {
		return _net_profit_rs3;
	}

	public void setNet_profit_rs3(String net_profit_rs3) {
		_net_profit_rs3 = net_profit_rs3;
	}

	public String getFinancial_bank_engagement() {
		return _financial_bank_engagement;
	}

	public void setFinancial_bank_engagement(String financial_bank_engagement) {
		_financial_bank_engagement = financial_bank_engagement;
	}

	public String getFinancial_assistance() {
		return _financial_assistance;
	}

	public void setFinancial_assistance(String financial_assistance) {
		_financial_assistance = financial_assistance;
	}

	public String getFinancial_assi_purp() {
		return _financial_assi_purp;
	}

	public void setFinancial_assi_purp(String financial_assi_purp) {
		_financial_assi_purp = financial_assi_purp;
	}

	public String getAgreeable_process() {
		return _agreeable_process;
	}

	public void setAgreeable_process(String agreeable_process) {
		_agreeable_process = agreeable_process;
	}

	public String getGsr_department() {
		return _gsr_department;
	}

	public void setGsr_department(String gsr_department) {
		_gsr_department = gsr_department;
	}

	public String getStartupindia() {
		return _startupindia;
	}

	public void setStartupindia(String startupindia) {
		_startupindia = startupindia;
	}

	public String getIncubator() {
		return _incubator;
	}

	public void setIncubator(String incubator) {
		_incubator = incubator;
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
}