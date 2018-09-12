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

import com.sbi.StartUp.model.SbiStartUp;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing SbiStartUp in entity cache.
 *
 * @author MAH97223
 * @see SbiStartUp
 * @generated
 */
public class SbiStartUpCacheModel implements CacheModel<SbiStartUp>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(151);

		sb.append("{regnum=");
		sb.append(regnum);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", registered_name=");
		sb.append(registered_name);
		sb.append(", date_of_establishment=");
		sb.append(date_of_establishment);
		sb.append(", constitution=");
		sb.append(constitution);
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
		sb.append(", corporate_email=");
		sb.append(corporate_email);
		sb.append(", corporate_website=");
		sb.append(corporate_website);
		sb.append(", initial_founders=");
		sb.append(initial_founders);
		sb.append(", current_promoters_name=");
		sb.append(current_promoters_name);
		sb.append(", noofemp=");
		sb.append(noofemp);
		sb.append(", description_of_product=");
		sb.append(description_of_product);
		sb.append(", initial_capital=");
		sb.append(initial_capital);
		sb.append(", monetary_value=");
		sb.append(monetary_value);
		sb.append(", business_model=");
		sb.append(business_model);
		sb.append(", current_capital=");
		sb.append(current_capital);
		sb.append(", capital_infusion=");
		sb.append(capital_infusion);
		sb.append(", Loans_availed=");
		sb.append(Loans_availed);
		sb.append(", valuer_name=");
		sb.append(valuer_name);
		sb.append(", valuation_date=");
		sb.append(valuation_date);
		sb.append(", valuation_amount_rs=");
		sb.append(valuation_amount_rs);
		sb.append(", loan_avail_source=");
		sb.append(loan_avail_source);
		sb.append(", loan_avail_rs=");
		sb.append(loan_avail_rs);
		sb.append(", gross_revenue_year1=");
		sb.append(gross_revenue_year1);
		sb.append(", gross_revenue_rs1=");
		sb.append(gross_revenue_rs1);
		sb.append(", gross_revenue_year2=");
		sb.append(gross_revenue_year2);
		sb.append(", gross_revenue_rs2=");
		sb.append(gross_revenue_rs2);
		sb.append(", gross_revenue_year3=");
		sb.append(gross_revenue_year3);
		sb.append(", gross_revenue_rs3=");
		sb.append(gross_revenue_rs3);
		sb.append(", ebidta_year1=");
		sb.append(ebidta_year1);
		sb.append(", ebidta_rs1=");
		sb.append(ebidta_rs1);
		sb.append(", ebidta_year2=");
		sb.append(ebidta_year2);
		sb.append(", ebidta_rs2=");
		sb.append(ebidta_rs2);
		sb.append(", ebidta_year3=");
		sb.append(ebidta_year3);
		sb.append(", ebidta_rs3=");
		sb.append(ebidta_rs3);
		sb.append(", gross_revenue_projected_year1=");
		sb.append(gross_revenue_projected_year1);
		sb.append(", projected_revenue_rs1=");
		sb.append(projected_revenue_rs1);
		sb.append(", gross_revenue_projected_year2=");
		sb.append(gross_revenue_projected_year2);
		sb.append(", projected_revenue_rs2=");
		sb.append(projected_revenue_rs2);
		sb.append(", gross_revenue_projected_year3=");
		sb.append(gross_revenue_projected_year3);
		sb.append(", projected_revenue_rs3=");
		sb.append(projected_revenue_rs3);
		sb.append(", projected_ebidta_year1=");
		sb.append(projected_ebidta_year1);
		sb.append(", projected_ebidta_rs1=");
		sb.append(projected_ebidta_rs1);
		sb.append(", projected_ebidta_year2=");
		sb.append(projected_ebidta_year2);
		sb.append(", projected_ebidta_rs2=");
		sb.append(projected_ebidta_rs2);
		sb.append(", projected_ebidta_year3=");
		sb.append(projected_ebidta_year3);
		sb.append(", projected_ebidta_rs3=");
		sb.append(projected_ebidta_rs3);
		sb.append(", projected_net_profit_year1=");
		sb.append(projected_net_profit_year1);
		sb.append(", projected_net_profit_rs1=");
		sb.append(projected_net_profit_rs1);
		sb.append(", projected_net_profit_year2=");
		sb.append(projected_net_profit_year2);
		sb.append(", projected_net_profit_rs2=");
		sb.append(projected_net_profit_rs2);
		sb.append(", projected_net_profit_year3=");
		sb.append(projected_net_profit_year3);
		sb.append(", projected_net_profit_rs3=");
		sb.append(projected_net_profit_rs3);
		sb.append(", net_profit_year1=");
		sb.append(net_profit_year1);
		sb.append(", net_profit_rs1=");
		sb.append(net_profit_rs1);
		sb.append(", net_profit_year2=");
		sb.append(net_profit_year2);
		sb.append(", net_profit_rs2=");
		sb.append(net_profit_rs2);
		sb.append(", net_profit_year3=");
		sb.append(net_profit_year3);
		sb.append(", net_profit_rs3=");
		sb.append(net_profit_rs3);
		sb.append(", financial_bank_engagement=");
		sb.append(financial_bank_engagement);
		sb.append(", financial_assistance=");
		sb.append(financial_assistance);
		sb.append(", financial_assi_purp=");
		sb.append(financial_assi_purp);
		sb.append(", agreeable_process=");
		sb.append(agreeable_process);
		sb.append(", gsr_department=");
		sb.append(gsr_department);
		sb.append(", startupindia=");
		sb.append(startupindia);
		sb.append(", incubator=");
		sb.append(incubator);
		sb.append(", status=");
		sb.append(status);
		sb.append(", flag=");
		sb.append(flag);
		sb.append("}");

		return sb.toString();
	}

	public SbiStartUp toEntityModel() {
		SbiStartUpImpl sbiStartUpImpl = new SbiStartUpImpl();

		if (regnum == null) {
			sbiStartUpImpl.setRegnum(StringPool.BLANK);
		}
		else {
			sbiStartUpImpl.setRegnum(regnum);
		}

		if (userName == null) {
			sbiStartUpImpl.setUserName(StringPool.BLANK);
		}
		else {
			sbiStartUpImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			sbiStartUpImpl.setCreateDate(null);
		}
		else {
			sbiStartUpImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			sbiStartUpImpl.setModifiedDate(null);
		}
		else {
			sbiStartUpImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (registered_name == null) {
			sbiStartUpImpl.setRegistered_name(StringPool.BLANK);
		}
		else {
			sbiStartUpImpl.setRegistered_name(registered_name);
		}

		if (date_of_establishment == Long.MIN_VALUE) {
			sbiStartUpImpl.setDate_of_establishment(null);
		}
		else {
			sbiStartUpImpl.setDate_of_establishment(new Date(
					date_of_establishment));
		}

		if (constitution == null) {
			sbiStartUpImpl.setConstitution(StringPool.BLANK);
		}
		else {
			sbiStartUpImpl.setConstitution(constitution);
		}

		if (address_line_1 == null) {
			sbiStartUpImpl.setAddress_line_1(StringPool.BLANK);
		}
		else {
			sbiStartUpImpl.setAddress_line_1(address_line_1);
		}

		if (address_line_2 == null) {
			sbiStartUpImpl.setAddress_line_2(StringPool.BLANK);
		}
		else {
			sbiStartUpImpl.setAddress_line_2(address_line_2);
		}

		if (address_landmark == null) {
			sbiStartUpImpl.setAddress_landmark(StringPool.BLANK);
		}
		else {
			sbiStartUpImpl.setAddress_landmark(address_landmark);
		}

		if (address_city == null) {
			sbiStartUpImpl.setAddress_city(StringPool.BLANK);
		}
		else {
			sbiStartUpImpl.setAddress_city(address_city);
		}

		if (address_pin == null) {
			sbiStartUpImpl.setAddress_pin(StringPool.BLANK);
		}
		else {
			sbiStartUpImpl.setAddress_pin(address_pin);
		}

		if (address_state == null) {
			sbiStartUpImpl.setAddress_state(StringPool.BLANK);
		}
		else {
			sbiStartUpImpl.setAddress_state(address_state);
		}

		if (corporate_email == null) {
			sbiStartUpImpl.setCorporate_email(StringPool.BLANK);
		}
		else {
			sbiStartUpImpl.setCorporate_email(corporate_email);
		}

		if (corporate_website == null) {
			sbiStartUpImpl.setCorporate_website(StringPool.BLANK);
		}
		else {
			sbiStartUpImpl.setCorporate_website(corporate_website);
		}

		if (initial_founders == null) {
			sbiStartUpImpl.setInitial_founders(StringPool.BLANK);
		}
		else {
			sbiStartUpImpl.setInitial_founders(initial_founders);
		}

		if (current_promoters_name == null) {
			sbiStartUpImpl.setCurrent_promoters_name(StringPool.BLANK);
		}
		else {
			sbiStartUpImpl.setCurrent_promoters_name(current_promoters_name);
		}

		if (noofemp == null) {
			sbiStartUpImpl.setNoofemp(StringPool.BLANK);
		}
		else {
			sbiStartUpImpl.setNoofemp(noofemp);
		}

		if (description_of_product == null) {
			sbiStartUpImpl.setDescription_of_product(StringPool.BLANK);
		}
		else {
			sbiStartUpImpl.setDescription_of_product(description_of_product);
		}

		if (initial_capital == null) {
			sbiStartUpImpl.setInitial_capital(StringPool.BLANK);
		}
		else {
			sbiStartUpImpl.setInitial_capital(initial_capital);
		}

		if (monetary_value == null) {
			sbiStartUpImpl.setMonetary_value(StringPool.BLANK);
		}
		else {
			sbiStartUpImpl.setMonetary_value(monetary_value);
		}

		if (business_model == null) {
			sbiStartUpImpl.setBusiness_model(StringPool.BLANK);
		}
		else {
			sbiStartUpImpl.setBusiness_model(business_model);
		}

		if (current_capital == null) {
			sbiStartUpImpl.setCurrent_capital(StringPool.BLANK);
		}
		else {
			sbiStartUpImpl.setCurrent_capital(current_capital);
		}

		if (capital_infusion == null) {
			sbiStartUpImpl.setCapital_infusion(StringPool.BLANK);
		}
		else {
			sbiStartUpImpl.setCapital_infusion(capital_infusion);
		}

		if (Loans_availed == null) {
			sbiStartUpImpl.setLoans_availed(StringPool.BLANK);
		}
		else {
			sbiStartUpImpl.setLoans_availed(Loans_availed);
		}

		if (valuer_name == null) {
			sbiStartUpImpl.setValuer_name(StringPool.BLANK);
		}
		else {
			sbiStartUpImpl.setValuer_name(valuer_name);
		}

		if (valuation_date == Long.MIN_VALUE) {
			sbiStartUpImpl.setValuation_date(null);
		}
		else {
			sbiStartUpImpl.setValuation_date(new Date(valuation_date));
		}

		if (valuation_amount_rs == null) {
			sbiStartUpImpl.setValuation_amount_rs(StringPool.BLANK);
		}
		else {
			sbiStartUpImpl.setValuation_amount_rs(valuation_amount_rs);
		}

		if (loan_avail_source == null) {
			sbiStartUpImpl.setLoan_avail_source(StringPool.BLANK);
		}
		else {
			sbiStartUpImpl.setLoan_avail_source(loan_avail_source);
		}

		if (loan_avail_rs == null) {
			sbiStartUpImpl.setLoan_avail_rs(StringPool.BLANK);
		}
		else {
			sbiStartUpImpl.setLoan_avail_rs(loan_avail_rs);
		}

		if (gross_revenue_year1 == null) {
			sbiStartUpImpl.setGross_revenue_year1(StringPool.BLANK);
		}
		else {
			sbiStartUpImpl.setGross_revenue_year1(gross_revenue_year1);
		}

		if (gross_revenue_rs1 == null) {
			sbiStartUpImpl.setGross_revenue_rs1(StringPool.BLANK);
		}
		else {
			sbiStartUpImpl.setGross_revenue_rs1(gross_revenue_rs1);
		}

		if (gross_revenue_year2 == null) {
			sbiStartUpImpl.setGross_revenue_year2(StringPool.BLANK);
		}
		else {
			sbiStartUpImpl.setGross_revenue_year2(gross_revenue_year2);
		}

		if (gross_revenue_rs2 == null) {
			sbiStartUpImpl.setGross_revenue_rs2(StringPool.BLANK);
		}
		else {
			sbiStartUpImpl.setGross_revenue_rs2(gross_revenue_rs2);
		}

		if (gross_revenue_year3 == null) {
			sbiStartUpImpl.setGross_revenue_year3(StringPool.BLANK);
		}
		else {
			sbiStartUpImpl.setGross_revenue_year3(gross_revenue_year3);
		}

		if (gross_revenue_rs3 == null) {
			sbiStartUpImpl.setGross_revenue_rs3(StringPool.BLANK);
		}
		else {
			sbiStartUpImpl.setGross_revenue_rs3(gross_revenue_rs3);
		}

		if (ebidta_year1 == null) {
			sbiStartUpImpl.setEbidta_year1(StringPool.BLANK);
		}
		else {
			sbiStartUpImpl.setEbidta_year1(ebidta_year1);
		}

		if (ebidta_rs1 == null) {
			sbiStartUpImpl.setEbidta_rs1(StringPool.BLANK);
		}
		else {
			sbiStartUpImpl.setEbidta_rs1(ebidta_rs1);
		}

		if (ebidta_year2 == null) {
			sbiStartUpImpl.setEbidta_year2(StringPool.BLANK);
		}
		else {
			sbiStartUpImpl.setEbidta_year2(ebidta_year2);
		}

		if (ebidta_rs2 == null) {
			sbiStartUpImpl.setEbidta_rs2(StringPool.BLANK);
		}
		else {
			sbiStartUpImpl.setEbidta_rs2(ebidta_rs2);
		}

		if (ebidta_year3 == null) {
			sbiStartUpImpl.setEbidta_year3(StringPool.BLANK);
		}
		else {
			sbiStartUpImpl.setEbidta_year3(ebidta_year3);
		}

		if (ebidta_rs3 == null) {
			sbiStartUpImpl.setEbidta_rs3(StringPool.BLANK);
		}
		else {
			sbiStartUpImpl.setEbidta_rs3(ebidta_rs3);
		}

		if (gross_revenue_projected_year1 == null) {
			sbiStartUpImpl.setGross_revenue_projected_year1(StringPool.BLANK);
		}
		else {
			sbiStartUpImpl.setGross_revenue_projected_year1(gross_revenue_projected_year1);
		}

		if (projected_revenue_rs1 == null) {
			sbiStartUpImpl.setProjected_revenue_rs1(StringPool.BLANK);
		}
		else {
			sbiStartUpImpl.setProjected_revenue_rs1(projected_revenue_rs1);
		}

		if (gross_revenue_projected_year2 == null) {
			sbiStartUpImpl.setGross_revenue_projected_year2(StringPool.BLANK);
		}
		else {
			sbiStartUpImpl.setGross_revenue_projected_year2(gross_revenue_projected_year2);
		}

		if (projected_revenue_rs2 == null) {
			sbiStartUpImpl.setProjected_revenue_rs2(StringPool.BLANK);
		}
		else {
			sbiStartUpImpl.setProjected_revenue_rs2(projected_revenue_rs2);
		}

		if (gross_revenue_projected_year3 == null) {
			sbiStartUpImpl.setGross_revenue_projected_year3(StringPool.BLANK);
		}
		else {
			sbiStartUpImpl.setGross_revenue_projected_year3(gross_revenue_projected_year3);
		}

		if (projected_revenue_rs3 == null) {
			sbiStartUpImpl.setProjected_revenue_rs3(StringPool.BLANK);
		}
		else {
			sbiStartUpImpl.setProjected_revenue_rs3(projected_revenue_rs3);
		}

		if (projected_ebidta_year1 == null) {
			sbiStartUpImpl.setProjected_ebidta_year1(StringPool.BLANK);
		}
		else {
			sbiStartUpImpl.setProjected_ebidta_year1(projected_ebidta_year1);
		}

		if (projected_ebidta_rs1 == null) {
			sbiStartUpImpl.setProjected_ebidta_rs1(StringPool.BLANK);
		}
		else {
			sbiStartUpImpl.setProjected_ebidta_rs1(projected_ebidta_rs1);
		}

		if (projected_ebidta_year2 == null) {
			sbiStartUpImpl.setProjected_ebidta_year2(StringPool.BLANK);
		}
		else {
			sbiStartUpImpl.setProjected_ebidta_year2(projected_ebidta_year2);
		}

		if (projected_ebidta_rs2 == null) {
			sbiStartUpImpl.setProjected_ebidta_rs2(StringPool.BLANK);
		}
		else {
			sbiStartUpImpl.setProjected_ebidta_rs2(projected_ebidta_rs2);
		}

		if (projected_ebidta_year3 == null) {
			sbiStartUpImpl.setProjected_ebidta_year3(StringPool.BLANK);
		}
		else {
			sbiStartUpImpl.setProjected_ebidta_year3(projected_ebidta_year3);
		}

		if (projected_ebidta_rs3 == null) {
			sbiStartUpImpl.setProjected_ebidta_rs3(StringPool.BLANK);
		}
		else {
			sbiStartUpImpl.setProjected_ebidta_rs3(projected_ebidta_rs3);
		}

		if (projected_net_profit_year1 == null) {
			sbiStartUpImpl.setProjected_net_profit_year1(StringPool.BLANK);
		}
		else {
			sbiStartUpImpl.setProjected_net_profit_year1(projected_net_profit_year1);
		}

		if (projected_net_profit_rs1 == null) {
			sbiStartUpImpl.setProjected_net_profit_rs1(StringPool.BLANK);
		}
		else {
			sbiStartUpImpl.setProjected_net_profit_rs1(projected_net_profit_rs1);
		}

		if (projected_net_profit_year2 == null) {
			sbiStartUpImpl.setProjected_net_profit_year2(StringPool.BLANK);
		}
		else {
			sbiStartUpImpl.setProjected_net_profit_year2(projected_net_profit_year2);
		}

		if (projected_net_profit_rs2 == null) {
			sbiStartUpImpl.setProjected_net_profit_rs2(StringPool.BLANK);
		}
		else {
			sbiStartUpImpl.setProjected_net_profit_rs2(projected_net_profit_rs2);
		}

		if (projected_net_profit_year3 == null) {
			sbiStartUpImpl.setProjected_net_profit_year3(StringPool.BLANK);
		}
		else {
			sbiStartUpImpl.setProjected_net_profit_year3(projected_net_profit_year3);
		}

		if (projected_net_profit_rs3 == null) {
			sbiStartUpImpl.setProjected_net_profit_rs3(StringPool.BLANK);
		}
		else {
			sbiStartUpImpl.setProjected_net_profit_rs3(projected_net_profit_rs3);
		}

		if (net_profit_year1 == null) {
			sbiStartUpImpl.setNet_profit_year1(StringPool.BLANK);
		}
		else {
			sbiStartUpImpl.setNet_profit_year1(net_profit_year1);
		}

		if (net_profit_rs1 == null) {
			sbiStartUpImpl.setNet_profit_rs1(StringPool.BLANK);
		}
		else {
			sbiStartUpImpl.setNet_profit_rs1(net_profit_rs1);
		}

		if (net_profit_year2 == null) {
			sbiStartUpImpl.setNet_profit_year2(StringPool.BLANK);
		}
		else {
			sbiStartUpImpl.setNet_profit_year2(net_profit_year2);
		}

		if (net_profit_rs2 == null) {
			sbiStartUpImpl.setNet_profit_rs2(StringPool.BLANK);
		}
		else {
			sbiStartUpImpl.setNet_profit_rs2(net_profit_rs2);
		}

		if (net_profit_year3 == null) {
			sbiStartUpImpl.setNet_profit_year3(StringPool.BLANK);
		}
		else {
			sbiStartUpImpl.setNet_profit_year3(net_profit_year3);
		}

		if (net_profit_rs3 == null) {
			sbiStartUpImpl.setNet_profit_rs3(StringPool.BLANK);
		}
		else {
			sbiStartUpImpl.setNet_profit_rs3(net_profit_rs3);
		}

		if (financial_bank_engagement == null) {
			sbiStartUpImpl.setFinancial_bank_engagement(StringPool.BLANK);
		}
		else {
			sbiStartUpImpl.setFinancial_bank_engagement(financial_bank_engagement);
		}

		if (financial_assistance == null) {
			sbiStartUpImpl.setFinancial_assistance(StringPool.BLANK);
		}
		else {
			sbiStartUpImpl.setFinancial_assistance(financial_assistance);
		}

		if (financial_assi_purp == null) {
			sbiStartUpImpl.setFinancial_assi_purp(StringPool.BLANK);
		}
		else {
			sbiStartUpImpl.setFinancial_assi_purp(financial_assi_purp);
		}

		if (agreeable_process == null) {
			sbiStartUpImpl.setAgreeable_process(StringPool.BLANK);
		}
		else {
			sbiStartUpImpl.setAgreeable_process(agreeable_process);
		}

		if (gsr_department == null) {
			sbiStartUpImpl.setGsr_department(StringPool.BLANK);
		}
		else {
			sbiStartUpImpl.setGsr_department(gsr_department);
		}

		if (startupindia == null) {
			sbiStartUpImpl.setStartupindia(StringPool.BLANK);
		}
		else {
			sbiStartUpImpl.setStartupindia(startupindia);
		}

		if (incubator == null) {
			sbiStartUpImpl.setIncubator(StringPool.BLANK);
		}
		else {
			sbiStartUpImpl.setIncubator(incubator);
		}

		if (status == null) {
			sbiStartUpImpl.setStatus(StringPool.BLANK);
		}
		else {
			sbiStartUpImpl.setStatus(status);
		}

		sbiStartUpImpl.setFlag(flag);

		sbiStartUpImpl.resetOriginalValues();

		return sbiStartUpImpl;
	}

	public String regnum;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String registered_name;
	public long date_of_establishment;
	public String constitution;
	public String address_line_1;
	public String address_line_2;
	public String address_landmark;
	public String address_city;
	public String address_pin;
	public String address_state;
	public String corporate_email;
	public String corporate_website;
	public String initial_founders;
	public String current_promoters_name;
	public String noofemp;
	public String description_of_product;
	public String initial_capital;
	public String monetary_value;
	public String business_model;
	public String current_capital;
	public String capital_infusion;
	public String Loans_availed;
	public String valuer_name;
	public long valuation_date;
	public String valuation_amount_rs;
	public String loan_avail_source;
	public String loan_avail_rs;
	public String gross_revenue_year1;
	public String gross_revenue_rs1;
	public String gross_revenue_year2;
	public String gross_revenue_rs2;
	public String gross_revenue_year3;
	public String gross_revenue_rs3;
	public String ebidta_year1;
	public String ebidta_rs1;
	public String ebidta_year2;
	public String ebidta_rs2;
	public String ebidta_year3;
	public String ebidta_rs3;
	public String gross_revenue_projected_year1;
	public String projected_revenue_rs1;
	public String gross_revenue_projected_year2;
	public String projected_revenue_rs2;
	public String gross_revenue_projected_year3;
	public String projected_revenue_rs3;
	public String projected_ebidta_year1;
	public String projected_ebidta_rs1;
	public String projected_ebidta_year2;
	public String projected_ebidta_rs2;
	public String projected_ebidta_year3;
	public String projected_ebidta_rs3;
	public String projected_net_profit_year1;
	public String projected_net_profit_rs1;
	public String projected_net_profit_year2;
	public String projected_net_profit_rs2;
	public String projected_net_profit_year3;
	public String projected_net_profit_rs3;
	public String net_profit_year1;
	public String net_profit_rs1;
	public String net_profit_year2;
	public String net_profit_rs2;
	public String net_profit_year3;
	public String net_profit_rs3;
	public String financial_bank_engagement;
	public String financial_assistance;
	public String financial_assi_purp;
	public String agreeable_process;
	public String gsr_department;
	public String startupindia;
	public String incubator;
	public String status;
	public boolean flag;
}