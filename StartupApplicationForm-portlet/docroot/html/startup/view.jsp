<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="javax.portlet.PortletSession"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@page import="com.liferay.util.portlet.PortletProps"%>
<%@page import="com.liferay.portlet.asset.model.AssetVocabulary"%>
<%@page import="com.liferay.portlet.asset.model.AssetCategory"%>
<%@page import="com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.OrderByComparator"%>
<%@page import="com.liferay.util.portlet.PortletProps"%>
<%@page import="com.liferay.portlet.asset.service.AssetVocabularyLocalServiceUtil"%>
<%@page import="java.util.List"%>


<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<portlet:defineObjects/>

<portlet:resourceURL var="saveForm" id="saveForm" />
<portlet:resourceURL var="fetchForm" id="fetchForm" />
<portlet:resourceURL var="resetRegNum" id="resetRegNum" />


<portlet:renderURL var="redirectResume">
	<portlet:param name="jsp" value="/html/startup/startupResume.jsp" />
	
</portlet:renderURL>

<link rel="stylesheet"
	href="<%=request.getContextPath()%>/custom/jquery-ui-1.10.3.custom.css">
	<link rel="stylesheet"
	href="<%=request.getContextPath()%>/custom/css/startup.css">

<script src="<%=request.getContextPath()%>/custom/jquery-1.9.1.min.js"></script>
<script src="<%=request.getContextPath()%>/custom/jquery-ui.js"></script>
<script src="<%=request.getContextPath()%>/custom/jquery.ui.widget.js"></script>
<script src="<%=request.getContextPath()%>/custom/jquery.ui.datepicker.js"></script>
 <script src="<%=request.getContextPath()%>/custom/js/startup.js"></script> 


<fmt:setBundle basename="portlet" />

<%
HttpServletRequest httpreq = PortalUtil.getHttpServletRequest(renderRequest);
		PortletSession sessionp = renderRequest.getPortletSession(true);
		
String errtext = "";
if (request.getParameter("errtext") != null) {
errtext = request.getParameter("errtext");
}
String errtextimage = "";
if(request.getParameter("errtextimage") != null){
	errtextimage = request.getParameter("errtextimage");
}

String registered_name="";
if(sessionp.getAttribute("registered_name") != null )
{
	registered_name = (String)sessionp.getAttribute("registered_name");
}
String promoters="";
if(sessionp.getAttribute("promoters") != null )
{
    promoters = (String)sessionp.getAttribute("promoters");
}
String founders="";
if(sessionp.getAttribute("founders") != null )
{
    founders = (String)sessionp.getAttribute("founders");
}


/*new changes 16/09  */

String cp_promoters_names="";
if(sessionp.getAttribute("cp_promoters_names") != null )
{
cp_promoters_names = (String)sessionp.getAttribute("cp_promoters_names");
}
String cp_promoters_addresses="";
if(sessionp.getAttribute("cp_promoters_addresses") != null )
{
cp_promoters_addresses = (String)sessionp.getAttribute("cp_promoters_addresses");
}
String cp_promoters_amounts="";
if(sessionp.getAttribute("cp_promoters_amounts") != null )
{
cp_promoters_amounts = (String)sessionp.getAttribute("cp_promoters_amounts");
}


String date_of_establishment = "";
 if ((String)sessionp.getAttribute("date_of_establishment")!= null) {
	date_of_establishment = (String)sessionp.getAttribute("date_of_establishment");
//date_of_establishment = request.getParameter("date_of_establishment"); */
} 
String constitution = "";
if ((String)sessionp.getAttribute("constitution")!= null) {
	constitution = (String)sessionp.getAttribute("constitution");
/* constitution = request.getParameter("constitution"); */
}
String corporate_office = "";
if ((String)sessionp.getAttribute("corporate_office")!= null) {
	corporate_office = (String)sessionp.getAttribute("corporate_office");
/* corporate_office = request.getParameter("corporate_office"); */
}

String address_line_1="";
if ((String)sessionp.getAttribute("address_line_1")!= null) {
	address_line_1 = (String)sessionp.getAttribute("address_line_1");
/* 	address_line_1 = request.getParameter("address_line_1"); */
}

String address_line_2="";
if ((String)sessionp.getAttribute("address_line_2")!= null) {
	address_line_2 = (String)sessionp.getAttribute("address_line_2");
	/* address_line_2 = request.getParameter("address_line_2"); */
}

String address_city="";
if ((String)sessionp.getAttribute("address_city") != null) {
	address_city = (String)sessionp.getAttribute("address_city");
	/* address_city = request.getParameter("address_city"); */
}
String address_landmark="";
if ((String)sessionp.getAttribute("address_landmark")!= null) {
	address_landmark = (String)sessionp.getAttribute("address_landmark");
	/* address_landmark = request.getParameter("address_landmark"); */
}

String address_pin="";
if ((String)sessionp.getAttribute("address_pin")!= null) {
	address_pin = (String)sessionp.getAttribute("address_pin");
	/* address_pin = request.getParameter("address_pin"); */
}
String address_state="";
if ((String)sessionp.getAttribute("address_state") != null) {
	address_state = (String)sessionp.getAttribute("address_state");
	/* address_state = request.getParameter("address_state"); */
}
String corporate_email = "";
if ((String)sessionp.getAttribute("corporate_email") != null) {
	corporate_email = (String)sessionp.getAttribute("corporate_email");
	/* corporate_email = request.getParameter("corporate_email"); */
}
String corporate_website = "";
if ((String)sessionp.getAttribute("corporate_website") != null) {
	corporate_website = (String)sessionp.getAttribute("corporate_website");
/* corporate_website = request.getParameter("corporate_website"); */
}
String initial_founders = "";
if ((String)sessionp.getAttribute("initial_founders") != null) {
	initial_founders = (String)sessionp.getAttribute("initial_founders");
/* initial_founders = request.getParameter("initial_founders"); */
}
String current_promoters_name = "";
if ((String)sessionp.getAttribute("current_promoters_name") != null) {
	current_promoters_name = (String)sessionp.getAttribute("current_promoters_name");
/* current_promoters_name = request.getParameter("current_promoters_name"); */
}
String noofemp = "";
if ((String)sessionp.getAttribute("noofemp") != null) {
	noofemp = (String)sessionp.getAttribute("noofemp");
	//noofemp = request.getParameter("noofemp");
}
String cp_promoters_name = "";
if ((String)sessionp.getAttribute("cp_promoters_name")!= null) {
	cp_promoters_name = (String)sessionp.getAttribute("cp_promoters_name");
	//cp_promoters_name = request.getParameter("cp_promoters_name");
}
String cp_promoters_address = "";
if ((String)sessionp.getAttribute("cp_promoters_address") != null) {
	cp_promoters_address = (String)sessionp.getAttribute("cp_promoters_address");
	/* cp_promoters_address = request.getParameter("cp_promoters_address"); */
}
String cp_promoters_amount = "";
if ((String)sessionp.getAttribute("cp_promoters_amount") != null) {
	cp_promoters_amount = (String)sessionp.getAttribute("cp_promoters_amount");
	/* cp_promoters_amount = request.getParameter("cp_promoters_amount"); */
}

String description_of_product = "";
if ((String)sessionp.getAttribute("description_of_product") != null) {
	description_of_product = (String)sessionp.getAttribute("description_of_product");
/* description_of_product = request.getParameter("description_of_product"); */
}
String initial_capital = "";
if ((String)sessionp.getAttribute("initial_capital") != null) {
	initial_capital = (String)sessionp.getAttribute("initial_capital");
//initial_capital = request.getParameter("initial_capital");
}
String monetary_value = "";
if ((String)sessionp.getAttribute("monetary_value") != null) {
	monetary_value = (String)sessionp.getAttribute("monetary_value");
//monetary_value = request.getParameter("monetary_value");
}
String business_model = "";
if ((String)sessionp.getAttribute("business_model") != null) {
	business_model = (String)sessionp.getAttribute("business_model");
//business_model = request.getParameter("business_model");
}
String current_capital = "";
if ((String)sessionp.getAttribute("current_capital") != null) {
	current_capital = (String)sessionp.getAttribute("current_capital");
//current_capital = request.getParameter("current_capital");
}
String capital_infusion = "";
if ((String)sessionp.getAttribute("capital_infusion") != null) {
	capital_infusion = (String)sessionp.getAttribute("capital_infusion");
//capital_infusion = request.getParameter("capital_infusion");
}
String address_investors = "";
if ((String)sessionp.getAttribute("address_investors") != null) {
	address_investors = (String)sessionp.getAttribute("address_investors");
//address_investors = request.getParameter("address_investors");
}
String valuation_amount = "";
if ((String)sessionp.getAttribute("valuation_amount") != null) {
	valuation_amount = (String)sessionp.getAttribute("valuation_amount");
//valuation_amount = request.getParameter("valuation_amount");
}

String Loans_availed = "";
if ((String)sessionp.getAttribute("Loans_availed") != null) {
	Loans_availed = (String)sessionp.getAttribute("Loans_availed");
//Loans_availed = request.getParameter("Loans_availed");
}
String valuer_name = "";
if ((String)sessionp.getAttribute("valuer_name") != null) {
	valuer_name = (String)sessionp.getAttribute("valuer_name");
	//valuer_name = request.getParameter("valuer_name");
}
String valuation_date = "";
 if ((String)sessionp.getAttribute("valuation_date") != null) {
	valuation_date = (String)sessionp.getAttribute("valuation_date");
	//valuation_date = request.getParameter("valuation_date");
} 
String valuation_amount_rs = "";
if ((String)sessionp.getAttribute("valuation_amount_rs") != null) {
	valuation_amount_rs = (String)sessionp.getAttribute("valuation_amount_rs");
	/* valuation_amount_rs = request.getParameter("valuation_amount_rs") */;
}
String loan_avail_source = "";
if ((String)sessionp.getAttribute("loan_avail_source") != null) {
	loan_avail_source =  (String)sessionp.getAttribute("loan_avail_source");
	//loan_avail_source = request.getParameter("loan_avail_source");
}
String loan_avail_rs = "";
if ((String)sessionp.getAttribute("loan_avail_rs") != null) {
	loan_avail_rs =  (String)sessionp.getAttribute("loan_avail_rs");
	/* loan_avail_rs = request.getParameter("loan_avail_rs"); */
}
String gross_revenue = "";
if ((String)sessionp.getAttribute("gross_revenue") != null) {
	gross_revenue =  (String)sessionp.getAttribute("gross_revenue");
//gross_revenue = request.getParameter("gross_revenue");
}
String gross_revenue_year1 = "";
if ((String)sessionp.getAttribute("gross_revenue_year1") != null) {
	gross_revenue_year1 =  (String)sessionp.getAttribute("gross_revenue_year1");
	/* gross_revenue_year1 = request.getParameter("gross_revenue_year1"); */
}
String gross_revenue_rs1 = "";
if ((String)sessionp.getAttribute("gross_revenue_rs1") != null) {
	gross_revenue_rs1 =  (String)sessionp.getAttribute("gross_revenue_rs1");
	//gross_revenue_rs1 = request.getParameter("gross_revenue_rs1");
}
String gross_revenue_year2 = "";
if ((String)sessionp.getAttribute("gross_revenue_year2")!= null) {
	gross_revenue_year2 =  (String)sessionp.getAttribute("gross_revenue_year2");
	//gross_revenue_year2 = request.getParameter("gross_revenue_year2");
}
String gross_revenue_rs2 = "";
if ((String)sessionp.getAttribute("gross_revenue_rs2") != null) {
	gross_revenue_rs2 =  (String)sessionp.getAttribute("gross_revenue_rs2");
	//gross_revenue_rs2 = request.getParameter("gross_revenue_rs2");
}
String gross_revenue_year3 = "";
if ((String)sessionp.getAttribute("gross_revenue_year3") != null) {
	gross_revenue_year3 =  (String)sessionp.getAttribute("gross_revenue_year3");
	//gross_revenue_year3 = request.getParameter("gross_revenue_year3");
}
String gross_revenue_rs3 = "";
if ((String)sessionp.getAttribute("gross_revenue_rs3") != null) {
	gross_revenue_rs3 =  (String)sessionp.getAttribute("gross_revenue_rs3");
	//gross_revenue_rs3 = request.getParameter("gross_revenue_rs3");
}
String ebidta = "";
if ((String)sessionp.getAttribute("ebidta") != null) {
	ebidta =  (String)sessionp.getAttribute("ebidta");
//ebidta = request.getParameter("ebidta");
}
String ebidta_year1 = "";
if ((String)sessionp.getAttribute("ebidta_year1") != null) {
	ebidta_year1 =  (String)sessionp.getAttribute("ebidta_year1");
	//ebidta_year1 = request.getParameter("ebidta_year1");
}
String ebidta_rs1 = "";
if ((String)sessionp.getAttribute("ebidta_rs1") != null) {
	ebidta_rs1 =  (String)sessionp.getAttribute("ebidta_rs1");
	//ebidta_rs1 = request.getParameter("ebidta_rs1");
}
String ebidta_year2 = "";
if ((String)sessionp.getAttribute("ebidta_year2") != null) {
	ebidta_year2 =  (String)sessionp.getAttribute("ebidta_year2");
	//ebidta_year2 = request.getParameter("ebidta_year2");
}
String ebidta_rs2 = "";
if ((String)sessionp.getAttribute("ebidta_rs2") != null) {
	ebidta_rs2 =  (String)sessionp.getAttribute("ebidta_rs2");
	//ebidta_rs2 = request.getParameter("ebidta_rs2");
}
String ebidta_year3 = "";
if ((String)sessionp.getAttribute("ebidta_year3") != null) {
	ebidta_year3 =  (String)sessionp.getAttribute("ebidta_year3");
	//ebidta_year3 = request.getParameter("ebidta_year3");
}
String ebidta_rs3 = "";
if ((String)sessionp.getAttribute("ebidta_rs3") != null) {
	ebidta_rs3 =  (String)sessionp.getAttribute("ebidta_rs3");
	//ebidta_rs3 = request.getParameter("ebidta_rs3");
}

String net_profit = "";
if ((String)sessionp.getAttribute("net_profit") != null) {
	net_profit =  (String)sessionp.getAttribute("net_profit");
//net_profit = request.getParameter("net_profit");
}
String net_profit_year1 = "";
if ((String)sessionp.getAttribute("net_profit_year1") != null) {
	net_profit_year1 =  (String)sessionp.getAttribute("net_profit_year1");
	//net_profit_year1 = request.getParameter("net_profit_year1");
}
String net_profit_rs1 = "";
if ((String)sessionp.getAttribute("net_profit_rs1") != null) {
	net_profit_rs1 =  (String)sessionp.getAttribute("net_profit_rs1");
	//net_profit_rs1 = request.getParameter("net_profit_rs1");
}
String net_profit_year2 = "";
if ((String)sessionp.getAttribute("net_profit_year2") != null) {
	net_profit_year2 =  (String)sessionp.getAttribute("net_profit_year2");
	//net_profit_year2 = request.getParameter("net_profit_year2");
}
String net_profit_rs2 = "";
if ((String)sessionp.getAttribute("net_profit_rs2") != null) {
	net_profit_rs2 =  (String)sessionp.getAttribute("net_profit_rs2");
	//net_profit_rs2 = request.getParameter("net_profit_rs2");
}
String net_profit_year3 = "";
if ((String)sessionp.getAttribute("net_profit_year3") != null) {
	net_profit_year3 =  (String)sessionp.getAttribute("net_profit_year3");
	//net_profit_year3 = request.getParameter("net_profit_year3");
}
String net_profit_rs3 = "";
if ((String)sessionp.getAttribute("net_profit_rs3") != null) {
	net_profit_rs3 =  (String)sessionp.getAttribute("net_profit_rs3");
	//net_profit_rs3 = request.getParameter("net_profit_rs3");
}

//added by rohit

String gross_projected_revenue_rs1 = "";
if ((String)sessionp.getAttribute("gross_projected_revenue_rs1") != null) {
	gross_projected_revenue_rs1 =  (String)sessionp.getAttribute("gross_projected_revenue_rs1");
	//gross_projected_revenue_rs1 = request.getParameter("gross_projected_revenue_rs1");
}
String gross_projected_revenue_rs2 = "";
if ((String)sessionp.getAttribute("gross_projected_revenue_rs2") != null) {
	gross_projected_revenue_rs2 =  (String)sessionp.getAttribute("gross_projected_revenue_rs2");
	//gross_projected_revenue_rs2 = request.getParameter("gross_projected_revenue_rs2");
}

String gross_projected_revenue_rs3 = "";
if ((String)sessionp.getAttribute("gross_projected_revenue_rs3") != null) {
	gross_projected_revenue_rs3 =  (String)sessionp.getAttribute("gross_projected_revenue_rs3");
	//gross_projected_revenue_rs2 = request.getParameter("gross_projected_revenue_rs3");
}

//end

 
String financial_bank_engagement = "";
if ((String)sessionp.getAttribute("financial_bank_engagement") != null) {
	financial_bank_engagement =  (String)sessionp.getAttribute("financial_bank_engagement");
	//financial_bank_engagement = request.getParameter("financial_bank_engagement");
}
String financial_assistance = "";
if ((String)sessionp.getAttribute("financial_assistance") != null) {
	financial_assistance =  (String)sessionp.getAttribute("financial_assistance");
//financial_assistance = request.getParameter("financial_assistance");
}
String financial_assi_purp = "";
if ((String)sessionp.getAttribute("financial_assi_purp") != null) {
	financial_assi_purp =  (String)sessionp.getAttribute("financial_assi_purp");
	//financial_assi_purp = request.getParameter("financial_assi_purp");
}
String revenue_projections = "";
if ((String)sessionp.getAttribute("revenue_projections") != null) {
	revenue_projections =  (String)sessionp.getAttribute("revenue_projections");
//revenue_projections = request.getParameter("revenue_projections");
}
String agreeable_process = "";
if ((String)sessionp.getAttribute("agreeable_process") != null) {
	agreeable_process =  (String)sessionp.getAttribute("agreeable_process");
//agreeable_process = request.getParameter("agreeable_process");
}

String startupindia = "";
if ((String)sessionp.getAttribute("startupindia") != null) {
	startupindia =  (String)sessionp.getAttribute("startupindia");
//startupindia = request.getParameter("startupindia");
}
String incubator = "";
if ((String)sessionp.getAttribute("incubator") != null) {
	incubator =  (String)sessionp.getAttribute("incubator");
//incubator = request.getParameter("incubator");
}

String gsrHide = "";
if (request.getParameter("hidegsr") != null) {
	gsrHide = request.getParameter("hidegsr");
}
%>

<script>

function validate() {

	
	var registered_name = $("#registered_name").val();
	if (registered_name == "") {
		$("#errdisplay").html(
				"<fmt:message key='err.fault.sbi.startup.registered_name' />");
		return false;
	}

	if (reg_name.test(registered_name) == false) {
		$("#errdisplay")
				.html(
						"<fmt:message key='err.fault.sbi.startup.registered_name_char' />");
		return false;
	}

	var date_of_establishment = $("#date_of_establishment").val();
	if (date_of_establishment == "") {
		$("#errdisplay")
				.html(
						"<fmt:message key='err.fault.sbi.startup.date_of_establishment' />");
		return false;
	}

	var constitution = $('#constitution :selected').val();
	if (constitution == 0) {
		$("#errdisplay").html(
				"<fmt:message key='err.fault.sbi.startup.constitution' />");
		return false;
	}
	// address validations
	var address_line_1 = $("#address_line_1").val();
	if (address_line_1 == "") {
		$("#errdisplay").html(
				"<fmt:message key='err.fault.sbi.startup.address_line_1' />");
		return false;
	}

	var address_city = $("#address_city").val();
	if (address_city == "") {
		$("#errdisplay").html(
				"<fmt:message key='err.fault.sbi.startup.address_city' />");
		return false;
	}
	var address_pin = $("#address_pin").val();
	if (address_pin == "") {
		$("#errdisplay").html(
				"<fmt:message key='err.fault.sbi.startup.address_pin' />");
		return false;
	}
	if (address_pin.length < 6) {
		$("#errdisplay").html(
				"<fmt:message key='err.fault.sbi.startup.address_pin_char' />");
		return false;
	}
	var address_state = $("#address_state :selected").val();
	if (address_state == 0) {
		$("#errdisplay").html(
				"<fmt:message key='err.fault.sbi.startup.address_state' />");
		return false;
	}
	// address validation ends

	var corporate_email = $("#corporate_email").val();
	if (corporate_email == "") {
		$("#errdisplay").html(
				"<fmt:message key='err.fault.sbi.startup.corporate_email' />");
		return false;
	}
	if (reg_email.test(corporate_email) == false) {
		$("#errdisplay")
				.html(
						"<fmt:message key='err.fault.sbi.startup.corporate_email_char' />");
		return false;
	}

	var corporate_website = $("#corporate_website").val();
	if (corporate_website == "") {
		$("#errdisplay")
				.html(
						"<fmt:message key='err.fault.sbi.startup.corporate_website' />");
		return false;
	}
	if (reg_url.test(corporate_website) == false) {
		$("#errdisplay")
				.html(
						"<fmt:message key='err.fault.sbi.startup.corporate_website_format' />");
		return false;
	}

	var flag = "";
	$("input[id=initial_founders]").each(
			function() {
				if (($(this).attr("placeholder") == $(this).val())
						|| (!$(this).val())) {
					$("#errdisplay").html("Field no 7 is mandatory");
					flag = "f7_err1";
					return false;
				}
				if (reg_name.test(($(this).val())) === false) {

					flag = "f7_err2";
					flag = "false";
					return false;
				}
			});

	if (flag != "false") {
		if ($('[name="is_promoter"]:checked').length < 1) {
			flag = "f7_err1";
			// return false;
		}
	}
	if (flag == "f7_err1") {
		$("#errdisplay").html("Field no 7 is mandatory");
		return false;
	}
	if (flag == "f7_err1") {
		$("#errdisplay")
				.html(
						"<fmt:message key='err.fault.sbi.startup.initial_founders_char' />");
		return false;
	}

	var constitution = $('#constitution :selected').val();
	if (constitution == "") {
		$("#errdisplay").html(
				"<fmt:message key='err.fault.sbi.startup.constitution' />");
		return false;
	}
	var noofemp = $("#noofemp").val();
	if (noofemp == "") {
		$("#errdisplay").html(
				"<fmt:message key='err.fault.sbi.startup.noofemp'/>");
		return false;
	} else if (!reg_digit.test(noofemp)) {
		$("#errdisplay").html(
				"<fmt:message key='err.fault.sbi.startup.noofemp_char'/>");
		return false;
	}

	var description_of_product = $("#description_of_product").val();
	if (description_of_product == "") {
		$("#errdisplay")
				.html(
						"<fmt:message key='err.fault.sbi.startup.description_of_product'/>");
		return false;
	}
	if (description_of_product.length > 1500) {
		$("#errdisplay")
				.html(
						"<fmt:message key='err.fault.sbi.startup.description_of_product_char'/>");
		return false;
	}

	var business_model = $("#business_model").val();
	if (business_model == "") {
		$("#errdisplay").html(
				"<fmt:message key='err.fault.sbi.startup.business_model'/>");
		return false;
	}
	if (business_model.length > 1500) {
		$("#errdisplay")
				.html(
						"<fmt:message key='err.fault.sbi.startup.business_model_char'/>");
		return false;
	}

	var monetary_value = $("#monetary_value").val();
	if (monetary_value == "") {
		$("#errdisplay").html(
				"<fmt:message key='err.fault.sbi.startup.monetary_value'/>");
		return false;
	}
	if (monetary_value.length > 1500) {
		$("#errdisplay")
				.html(
						"<fmt:message key='err.fault.sbi.startup.monetary_value_char'/>");
		return false;
	}

	var initial_capital = $("#initial_capital").val();
	if (initial_capital == "") {
		$("#errdisplay").html(
				"<fmt:message key='err.fault.sbi.startup.initial_capital'/>");
		return false;
	}
	var current_capital = $("#current_capital").val();
	if (current_capital == "") {
		$("#errdisplay").html(
				"<fmt:message key='err.fault.sbi.startup.current_capital'/>");
		return false;
	}

	$("#promotors_list tr.tr_clone")
			.each(
					function(i, tr) {
						var thisRow = $(this).closest('.tr_clone')[0];
						var cp_promoters_name = $(thisRow).find(
								" input#cp_promoters_name");
						var cp_promoters_address = $(thisRow).find(
								" textarea#cp_promoters_address");
						var cp_promoters_amount = $(thisRow).find(
								" input#cp_promoters_amount");

						if ($(cp_promoters_name).attr("placeholder") == cp_promoters_name
								.val())
							cp_promoters_name.val("");
						if ($(cp_promoters_address).attr("placeholder") == cp_promoters_address
								.val())
							cp_promoters_address.val("");
						if ($(cp_promoters_amount).attr("placeholder") == cp_promoters_amount
								.val())
							cp_promoters_amount.val("");
						if ($(cp_promoters_name).val().length === 0
								&& $(cp_promoters_address).val().length === 0
								&& $(cp_promoters_amount).val().length === 0) {
							return true;
						} else if ($(cp_promoters_name).val().length === 0
								|| $(cp_promoters_address).val().length === 0
								|| $(cp_promoters_amount).val().length === 0) {
							flag = "f14_err1";
							return false;

						}
					});

	if (flag == "f14_err1") {
		$("#errdisplay").html("Field no 14 is mandatory");
		return false;
	}

	var current_promoters_name = $("#current_promoters_name").val();
	if (current_promoters_name == "") {
		$("#errdisplay")
				.html(
						"<fmt:message key='err.fault.sbi.startup.current_promoters_name' />");
		return false;
	}

	// Added by Rohit on 14-08-2016

	var financial_bank_engagement = $('#financial_bank_engagement').prop(
			'selectedIndex');

	if (financial_bank_engagement == 0) {
		$("#errdisplay")
				.html(
						"<fmt:message key='err.fault.sbi.startup.financial_bank_engagement' />");
		return false;
	}
	if (financial_bank_engagement == 2) {
		var financial_assistance = $('#financial_assistance').prop(
				'selectedIndex');
		if (financial_assistance == 0) {
			$("#errdisplay")
					.html(
							"<fmt:message key='err.fault.sbi.startup.financial_assistance' />");
			return false;
		}

		var financial_assistance_purp = $("#financial_assistance_purpose")
				.val();
		if (financial_assistance_purp == "") {
			$("#errdisplay")
					.html(
							"<fmt:message key='err.fault.sbi.startup.financial_assistance_purpose'/>");
			return false;
		}
		if (financial_assistance_purp.length > 1500) {
			$("#errdisplay")
					.html(
							"<fmt:message key='err.fault.sbi.startup.financial_assistance_purpose_char'/>");
			return false;
		}
	}

	var gross_projected_revenue_rs1 = $("#gross_projected_revenue_rs1").val();
	if (gross_projected_revenue_rs1 == "") {
		$("#errdisplay")
				.html(
						"<fmt:message key='err.fault.sbi.startup.gross_revenue_projected'/>");
		return false;
	}
	var gross_projected_revenue_rs2 = $("#gross_projected_revenue_rs2").val();
	if (gross_projected_revenue_rs2 == "") {
		$("#errdisplay")
				.html(
						"<fmt:message key='err.fault.sbi.startup.gross_revenue_projected'/>");
		return false;
	}
	var gross_projected_revenue_rs3 = $("#gross_projected_revenue_rs3").val();
	if (gross_projected_revenue_rs3 == "") {
		$("#errdisplay")
				.html(
						"<fmt:message key='err.fault.sbi.startup.gross_revenue_projected'/>");
		return false;
	}

	var revenue_projections = $("#revenue_projections").val();
	if (revenue_projections == "") {
		$("#errdisplay")
				.html(
						"<fmt:message key='err.fault.sbi.startup.revenue_projections'/>");
		return false;
	}
	var isAgreeable_process = jQuery("input[name=agreeable_process]:checked")
			.val();
	if (!isAgreeable_process) {
		$("#errdisplay")
				.html(
						"<fmt:message key='err.fault.sbi.startup.isAgreeable_process'/>");
		return false;
	}

	var len = $("input[name=startupindia]:checked").size();
	if (len == 0) {
		$("#errdisplay").html(
				"<fmt:message key='err.fault.sbi.startup.isStartupindia'/>");
		return false;
	}
	var startupIndiaValue = jQuery("input[name=startupindia]:checked").val();
	if (startupIndiaValue == "Yes") {
		var incubator = $("#incubator").val();
		if (incubator == "") {
			$("#errdisplay").html(
					"<fmt:message key='err.fault.sbi.startup.incubator'/>");
			return false;
		}
	}

	$("#errdisplay").html("");

	founder_list();

	infused_promoter_list();
	return true;

}



function saveData() {

var registered_name = $("#registered_name").val();
var date_of_establishment = $("#date_of_establishment").val();
var corporate_website = $("#corporate_website").val();
var constitution = $('#constitution :selected').val();
var address_line_1 = $("#address_line_1").val();
var address_line_2 = $("#address_line_2").val();
var address_city = $("#address_city").val();
var address_landmark = $("#address_landmark").val();
var address_pin = $("#address_pin").val();
var address_state = $("#address_state :selected").val();
var noofemp = $("#noofemp").val();
var corporate_email = $("#corporate_email").val();
var description_of_product = $("#description_of_product").val();
var business_model = $("#business_model").val();
var monetary_value = $("#monetary_value").val();
var initial_capital = $("#initial_capital").val();
var current_capital = $("#current_capital").val();
var loan_avail_source = $("#loan_avail_source").val();
var loan_avail_rs = $("#loan_avail_rs").val();
var valuer_name = $("#valuer_name").val();
var valuation_date = $("#valuation_date").val();
var valuation_amount_rs = $("#valuation_amount_rs").val();

var gross_revenue_rs1 = $("#gross_revenue_rs1").val();
var ebidta_rs1 = $("#ebidta_rs1").val();
var net_profit_rs1 = $("#net_profit_rs1").val();

var gross_revenue_rs2 = $("#gross_revenue_rs2").val();
var ebidta_rs2 = $("#ebidta_rs2").val();
var net_profit_rs2 = $("#net_profit_rs2").val();

var gross_revenue_rs3 = $("#gross_revenue_rs3").val();
var ebidta_rs3 = $("#ebidta_rs3").val();
var net_profit_rs3 = $("#net_profit_rs3").val();

founder_list();
infused_promoter_list();

var founders = $("#founders").val();
var promoters = $("#promoters").val();
var cp_promoters_names = $("#cp_promoters_names").val();
var cp_promoters_addresses = $("#cp_promoters_addresses").val();
var cp_promoters_amounts = $("#cp_promoters_amounts").val();

var financial_bank_engagement = $('#financial_bank_engagement').val();
var financial_assistance = $('#financial_assistance').val();
var financial_assistance_purp = $('#financial_assistance_purpose').val();
var gross_projected_revenue_rs1 = $("#gross_projected_revenue_rs1").val();
var gross_projected_revenue_rs2 = $("#gross_projected_revenue_rs2").val();
var gross_projected_revenue_rs3 = $("#gross_projected_revenue_rs3").val();
var isAgreeable_process = jQuery("input[name=agreeable_process]:checked").val();
var gsr_department = jQuery("input[name=agreeable_process]:checked").val();
var isStartupindia = jQuery("input[name=startupindia]:checked").val();
var incubator = $("#incubator").val();
$.ajax({
url : "<%=saveForm%>",
type : "POST",
dataType : "json",
data : {

	"registered_name" : registered_name,
	"date_of_establishment" : date_of_establishment,
	"constitution" : constitution,
	"address_line_1" : address_line_1,
	"address_line_2" : address_line_2,
	"address_city" : address_city,
	"address_pin" : address_pin,
	"address_landmark" : address_landmark,
	"corporate_email" : corporate_email,
	"address_state" : address_state,
	"corporate_website" : corporate_website,
	// "founders" : founders,
	"constitution" : constitution,
	"noofemp" : noofemp,
	"loan_avail_source" : loan_avail_source,
	"loan_avail_rs" : loan_avail_rs,
	"description_of_product" : description_of_product,
	"business_model" : business_model,
	"monetary_value" : monetary_value,
	"initial_capital" : initial_capital,
	"current_capital" : current_capital,
	"gross_revenue_rs1" : gross_revenue_rs1,
	"valuer_name" : valuer_name,
	"valuation_date" : valuation_date,
	"valuation_amount_rs" : valuation_amount_rs,
	"ebidta_rs1" : ebidta_rs1,
	"net_profit_rs1" : net_profit_rs1,
	"gross_revenue_rs2" : gross_revenue_rs2,
	"ebidta_rs2" : ebidta_rs2,
	"net_profit_rs2" : net_profit_rs2,
	"gross_revenue_rs3" : gross_revenue_rs3,
	"ebidta_rs3" : ebidta_rs3,
	"net_profit_rs3" : net_profit_rs3,
	"promoters" : promoters,
	"founders" : founders,
	"cp_promoters_names" : cp_promoters_names,
	"cp_promoters_addresses" : cp_promoters_addresses,
	"cp_promoters_amounts" : cp_promoters_amounts,
	"agreeable_process" : isAgreeable_process,
	"startupindia" : isStartupindia,
	"incubator" : incubator,
	"gsr_department" : gsr_department,
	"financial_bank_engagement" : financial_bank_engagement,
	"financial_assistance" : financial_assistance,
	"financial_assistance_purp" : financial_assistance_purp,
	"gross_projected_revenue_rs1" : gross_projected_revenue_rs1,
	"gross_projected_revenue_rs2" : gross_projected_revenue_rs2,
	"gross_projected_revenue_rs3" : gross_projected_revenue_rs3,
},
success : function(data) {
	$("#errdisplay").html("");
	alert("Saved Successfully. Your Registration number is "
			+ data.regnum);
},

});

}



function fetchForm() {

var captchaText = $("#captchaT").val();
var ref_num = $("#check_reg_num").val();
var incorporation_date = $("#incorporation_date").val();
if (ref_num == "") {
$("#errdisplayfetch").html(
		"<fmt:message key='err.fault.sbi.startup.fetch' />");
return false;
}
if (incorporation_date == "") {
$("#errdisplayfetch").html("Date of establishment is mandatory.");
return false;
}
if (captchaText == "") {
$("#errdisplayfetch").html("Captcha is mandatory.");
return false;
}

$.ajax({

url : "<%=fetchForm%>",
type : "POST",
dataType : "json",
data : {
	"regNum" : ref_num,
	"captchaText" : captchaText,
	"date_of_establishment" : incorporation_date,
},
success : function(data) {
	var respCode = data.error;
	if (respCode == "redirect") {
		var promoters = data.promoters;
		var url = "<%=redirectResume%>";
		url += "&regnum=" + ref_num + "&promoters=" + promoters;
		window.location.href = url;
	}

	else if (respCode != "") {
		$("#errdisplayfetch").html(data.error);
	} else {
		$("#gsr_row").hide();
		$("#not_eligible").hide();
		$("#continue_row").hide();
		$("#partial").hide();
		$("#mainForm").show();
		$(".saveForm").prop('disabled', false);
		$(".saveForm").attr('title', '');
		$("#registered_name").val(data.registered_name);
		$("#date_of_establishment").val(data.date_of_establishment);
		$("#constitution").val(data.constitution);
		$("#address_line_1").val(data.address_line_1);
		$("#address_line_2").val(data.address_line_2);
		$("#address_city").val(data.address_city);
		$("#address_state").val(data.address_state);
		$("#address_landmark").val(data.address_landmark);
		$("#address_pin").val(data.address_pin);
		$("#corporate_email").val(data.corporate_email);
		$("#corporate_website").val(data.corporate_website);
		$("#noofemp").val(data.noofemp);
		$("#description_of_product").val(data.description_of_product);
		$("#business_model").val(data.business_model);
		$("#monetary_value").val(data.monetary_value);
		$("#initial_capital").val(data.initial_capital);
		$("#current_capital").val(data.current_capital);
		$("#valuer_name").val(data.valuer_name);
		$("#valuation_amount_rs").val(data.valuation_amount_rs);
		$("#valuation_date").val(data.valuation_date);
		$("#loan_avail_source").val(data.loan_avail_source);
		$("#loan_avail_rs").val(data.loan_avail_rs);
		$("#gross_revenue_rs1").val(data.gross_revenue_rs1);
		$("#ebidta_rs1").val(data.ebidta_rs1);
		$("#net_profit_rs1").val(data.net_profit_rs1);
		$("#gross_revenue_rs2").val(data.gross_revenue_rs2);
		$("#ebidta_rs2").val(data.ebidta_rs2);
		$("#net_profit_rs2").val(data.net_profit_rs2);
		$("#gross_revenue_rs3").val(data.gross_revenue_rs3);
		$("#ebidta_rs3").val(data.ebidta_rs3);
		$("#net_profit_rs3").val(data.net_profit_rs3);
		$("#financial_bank_engagement").val(
				data.financial_bank_engagement);
		if(data.financial_bank_engagement=="Financialassistance"){
			$("#typeOfFinancialAssist").show();
			$("#financial_assistance_purpose_id").show();
			$("#financial_assistance").val(data.financial_assistance);
			$("#financial_assistance_purpose").val(
					data.financial_assistance_purpose);
		}
		else{
			$("#typeOfFinancialAssist").hide();
		}
		$("#gross_projected_revenue_rs1").val(
				data.gross_projected_revenue_rs1);
		$("#gross_projected_revenue_rs2").val(
				data.gross_projected_revenue_rs2);
		$("#gross_projected_revenue_rs3").val(
				data.gross_projected_revenue_rs3);

		var agreeable_process = data.agreeable_process;
		var startupindia = data.startupindia;
		$("#agreeable_process_"+agreeable_process.toLowerCase()).prop('checked',true);
		$("#startupindia_"+startupindia.toLowerCase()).prop('checked',true);
		if(startupindia=="Yes"){
			hideShowIncubator(startupindia);
		}
		$("#incubator").val(data.incubator);
		var initialFounders = data.initial_founders;
		var current_promoters = data.current_promoters_name;
		var initialFoundersTotal = data.initialFoundersTotal;
		var capInfuTotal = data.capInfuTotal;
		var capName = data.capName;
		var capAddress = data.capAdd;
		var capAmount = data.capAmount;
		fetchPromoterTable(initialFounders,current_promoters,initialFoundersTotal);
		fetchCapitalInfuTable(capName, capAddress, capAmount,capInfuTotal);
	}
},

});
}


function resetRegNum() {

$.ajax({
url : "<%=resetRegNum%>",
type : "POST",
data : {

},
success : function(data) {
	reset();
},
});
}
/* new changes 16/09 */
function loadfromsession(){
	$(".saveForm").prop('disabled', false);
	$(".saveForm").attr('title', '');
	    $("#constitution").val("<%=constitution%>");
	    $("#address_state").val("<%=address_state%>");
	    var financial_bank_engagement = "<%=financial_bank_engagement%>";
	    $("#financial_bank_engagement").val("<%=financial_bank_engagement%>");
	    var agreeable_process = "<%=agreeable_process%>";
	    var startupindia = "<%=startupindia%>";
	    $("#agreeable_process_"+agreeable_process.toLowerCase()).prop('checked',true);
	    $("#startupindia_"+startupindia.toLowerCase()).prop('checked',true);
	    if(startupindia=="Yes"){
	        hideShowIncubator(startupindia);
	    }
	    var initial_founders = "<%=founders%>";
	    var current_promotors = "<%=promoters%>";
	    var cp_promoters_names = "<%=cp_promoters_names%>";
	    var cp_promoters_addresses = "<%=cp_promoters_addresses%>";
	  var cp_promoters_amounts = "<%=cp_promoters_amounts%>";
	    cp_promoters_names = cp_promoters_names.split(',').join('$');
	    cp_promoters_amounts = cp_promoters_amounts.split(',').join('$');
	    var initialfounderslen = initial_founders.split(",");
	    var capitalInfu = cp_promoters_names.split("$");
	    fetchPromoterTable(initial_founders,current_promotors,initialfounderslen.length);
	    fetchCapitalInfuTable(cp_promoters_names, cp_promoters_addresses, cp_promoters_amounts, capitalInfu.length);
	    if(financial_bank_engagement=="Financialassistance"){
	        $("#financial_assistance").val("<%=financial_assistance%>");
	        $("#typeOfFinancialAssist").show();
	        $("#financial_assistance_purpose_id").show();
	    }
	}


</script>

<portlet:actionURL var="actionName" name="SubmitForm">
    <portlet:param name="jspPage" value="/html/startup/startupResume.jsp" />  
</portlet:actionURL>


<portlet:actionURL name="Addquery" var="addquery" />

<!--Start -->
<div id="content-area">

	<div class="edu-form">

<!-- 		<div class="clearfix" id="header"> -->
<%-- 			<div class="form-title" style="font-size:15px; line-height:18px;"><fmt:message key="lbl.sbi.startup.sbi_heading" /></div> --%>
<!-- 		</div> -->
 		<div class="clearfix" id="header"> 
 			<h2><fmt:message key="lbl.sbi.startup.sbi_heading" /></h2>
 		</div> 
		<hr></hr>
		
		<div class="clearfix" id="header">
			<div class="form-title"  style="font-size:13px;">Start-up Application Form</div>
		</div>
		
		<portlet:actionURL name="SubmitForm" var="SubmitForm" />
	
<aui:form name="a" enctype="multipart/form-data"  id="configform" action="<%=SubmitForm.toString() %>" method="POST" >

<input type="hidden" value="<%=founders %>" name="founders" id="founders"/>
<input type="hidden" value="<%=promoters %>" name="promoters" id="promoters"/>
<input type="hidden" value="<%=cp_promoters_names %>" name="cp_promoters_names" id="cp_promoters_names"/>
<input type="hidden" value="<%=cp_promoters_addresses %>" name="cp_promoters_addresses" id="cp_promoters_addresses"/>
<input type="hidden" value="<%=cp_promoters_amounts %>" name="cp_promoters_amounts" id="cp_promoters_amounts"/>
<input type="hidden" value="<%=gsrHide %>" name="gsrHide" id="gsrHide"/>
	<!-- -STRAT - GSR Department ----->

		  <div class="edu-form-row" id="gsr_row">
				<div class="edu-form-leftcol width100perc" >
					<label for="gsr_department">  <fmt:message
							key="lbl.sbi.startup.gsr_department" />
					</label> 
					
					<span class="border_dotted"></span>
					<br/>
					<span class="aggrible_btn" style="">
					<input style="border:none" type="radio" name="gsr_department" id="gsr_department_yes" class="aggrible_btn_text"
						value="Yes" onClick="hideShowContinueForm(this)">Yes
					</span>
					<span class="aggrible_btn" style="">
						<input  style="border:none" type="radio" name="gsr_department" id="gsr_department_no" class="aggrible_btn_text"
						value="No" onClick="hideShowContinueForm(this)">No
					</span>
<!-- 					<input name="gsr_department" id="gsr_department" style="width:94%;" -->
<%-- 						  value="<%=gsr_department%>"> --%>
				</div>
			</div>
			
			
			<!------END------GSR---Department----------->

<div class="edu-form-row" style="display:none;" id="not_eligible">

				<div class="edu-form-leftcol width100perc">
					<label for="gsr_not_eligible" class="err-msg">  <fmt:message
							key="err.fault.sbi.startup.gsr_not_eligible" />
					</label> 
				</div>
</div>

<div id="continue_row" style="display:none;">
		<ul class="start_new">
			<li><input type="button" id="new" value="Start New"></li>
			<li><input type="button" id="cont" value="Continue With Partially Filled"></li>
		</ul>
	</div>

<div class="clearfix"></div>
<div id="partial" class="hide">
			<div class ="row">
			<p>
				<div id="errdisplayfetch" class="err-msg"></div>
			</p>
			</div>

			<div class="row">
				<p>
					<span class="red-mandate">*</span> Required Fields
				</p>
			</div>
			
			<div class="row">
				<label>Registration Number <span class="red-mandate">*</span></label>
				<input type="text" name="" id="check_reg_num" value="" onkeypress="OnlyNumericEntry(event)"/>
			</div>
			
			<div class="row">		
				<label>Date of Establishment <span class="red-mandate">*</span></label>
				<input type="text" name="" value="" id="incorporation_date"/>
			</div>
			
			<div class="row">		
				<label>Captcha <span class="red-mandate">*</span></label>
						<portlet:resourceURL var="captchaURL1" id="captchaURL1"/>
				<img src="<%=captchaURL1 %>" id=captchaImg" name="captchaImg" class="captchaPartial">
				&nbsp;<img id="refreshPartialCaptcha"
						src="<%=request.getContextPath()%>/html/images/refresh.png">
			</div>
			
			<div class="row">		
			</div>
				<input type="text" name="" value="" id="captchaT"/>
			<br/>	
			<div class="row start_new">
				<input type="button" name="" value="Proceed" class="pro-btn" onclick="fetchForm()"/>
			</div>
	</div>


<!-- ----main form---- -->
<!-- <div style="display:none;" id="mainForm"> -->
<div id="mainForm"> 
		<div class="edu-form-row">

				<div class="edu-form-leftcol">
				<p>
					<span class="red-mandate">*</span> Required Fields
				</p>
				</div>

				<div class="edu-form-righttcol">
					&nbsp;&nbsp;<input  type="button" class="saveForm" title="Button will be enabled after all fields till field 5 have been filled." disabled onclick="saveForm()"  
  					value='<fmt:message key="lbl.sbi.startup.save_btn" />'> 
				</div>

			</div>			
			<p>&nbsp;</p>
			<div class="clearfix"></div>
			<div id="errdisplay" class="err-msg"><%=errtext%></div>
			<div id="successdisplay" class="success-msg"></div>

			<div class="edu-form-row">

				<div class="edu-form-leftcol">
					<label for="Registered name of start-up">
					<fmt:message key="lbl.sbi.startup.registered_name" /> 
					<span class="red-mandate">*</span>
					</label> 
					<input name="registered_name" id="registered_name" 	value="<%=registered_name%>" maxlength="<fmt:message
							key="lbl.sbi.startup.name.max_chars"/>">
				</div>

				<div class="edu-form-righttcol">
					<label for="Date of establishment ">
						<fmt:message key="lbl.sbi.startup.establishment" />
						<span class="red-mandate">*</span>
					</label> 
						<input type="text" name="date_of_establishment" id="date_of_establishment" size="30" readonly="readonly"  value="<%=date_of_establishment %>" />
				</div>

			</div>			
			<p>&nbsp;</p>
			<div class="clearfix"></div>			
			<div class="edu-form-row">			
				<div class="edu-form-leftcol width100perc">
					<label for="Constitution">
					<fmt:message key="lbl.sbi.startup.constitution" />
					<span class="red-mandate">*</span>
					</label>
					<select style="width:220px;margin-left:0px;width:98%;" name="constitution" id="constitution">
					<option value="0"> --please select-- </option>
						<option value="Registered Partnership">Registered
							Partnership</option>
						<option value="Ltd. Liability Partnership">Ltd. Liability
							Partnership</option>
						<option value="Pvt. Ltd. Co.">Pvt. Ltd. Co.</option>
					</select>
				</div>
			</div>
						
			<div class="clearfix"></div>
			<!-- <div class="edu-form-row">
				<div class="edu-form-leftcol width100perc">
					<label for="load-limit"> <fmt:message
							key="lbl.sbi.startup.corporate_office" />  <span class="red-mandate">*</span></label> 
						<textarea name="corporate_office" id="acorporate_officedd" rows="6" style=""><%=corporate_office %></textarea>
				</div>
			</div>-->	
			
			<!-- -start new adderrss-- -->
			<div class="new_address_outer">
			<p>&nbsp;</p>
				<label for="Sanction"> 
					<fmt:message	key="lbl.sbi.startup.address_details" />
					<span class="red-mandate">*</span>
				</label>				
				<span class="border_dotted"></span>
			<div class="edu-form-row">
				<div class="edu-form-leftcol">
					<label for="address_line_1"> 
						<fmt:message key="lbl.sbi.startup.address_line_1" />
					</label> 
					<input  name="address_line_1" id="address_line_1" value="<%=address_line_1%>" maxlength="<fmt:message key="lbl.sbi.startup.name.max_chars"/>">
				</div>
				<div class="edu-form-righttcol">
					<label for="address_line_2">  <fmt:message
							key="lbl.sbi.startup.address_line_2" /></label> <input  name="address_line_2"
						id="address_line_2" value="<%=address_line_2%>" maxlength="<fmt:message key="lbl.sbi.startup.name.max_chars"/>">
				</div>
			</div>			
			<p>&nbsp;</p>
			<div class="clearfix"></div>
			<div class="edu-form-row">
				<div class="edu-form-leftcol">
					<label for="address_landmark">  <fmt:message
							key="lbl.sbi.startup.address_landmark" /></label> <input  name="address_landmark"
						id="address_landmark" value="<%=address_landmark%>" maxlength="<fmt:message key="lbl.sbi.startup.name.max_chars"/>">
				</div>
				<div class="edu-form-righttcol">
					<label for="address_city">  <fmt:message
							key="lbl.sbi.startup.address_city" /></label> <input  name="address_city"
						id="address_city" value="<%=address_city%>" onkeypress="onlyCharacters(this,event)" maxlength="<fmt:message key="lbl.sbi.startup.name.max_chars"/>">
				</div>				
			</div>			
			<p>&nbsp;</p>
			<div class="clearfix"></div>
			<div class="edu-form-row">
				<div class="edu-form-leftcol">
					<label for="address_pin"> 
					<fmt:message
							key="lbl.sbi.startup.address_pin" /></label> <input  name="address_pin"
						id="address_pin" value="<%=address_pin%>" maxlength="6" onkeypress="OnlyNumericEntry(event)">
				</div>
				<div class="edu-form-righttcol">
				<label for="address_state"><fmt:message key="lbl.sbi.startup.address_state" /></label>
				<select name="address_state" id="address_state" style="width: 235px; ">
				<option value="0"> --please select-- </option>
					<%		
					ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
						long vocabularyId = 0;
						List<AssetVocabulary> vlist = null;						
						vlist = AssetVocabularyLocalServiceUtil.getGroupVocabularies(themeDisplay.getScopeGroupId());
						for(AssetVocabulary av : vlist){
							if(av.getName().equalsIgnoreCase(PortletProps.get("entity.sbi.eduloan.location"))){
								vocabularyId = av.getVocabularyId();
							}
						}
						OrderByComparator obc = null;						
						List<AssetCategory> clist = AssetCategoryLocalServiceUtil.getVocabularyCategories(vocabularyId, 0, AssetCategoryLocalServiceUtil.getVocabularyCategoriesCount(vocabularyId), obc);
						for(AssetCategory ac : clist){						
							if(ac.getName().equalsIgnoreCase("India")){
								OrderByComparator obcs = null;						
								List<AssetCategory> clists = AssetCategoryLocalServiceUtil.getChildCategories(ac.getCategoryId());
								for(AssetCategory acs : clists){									
									%><option value="<%=acs.getName() %>"><%=acs.getName() %></option><%
								}
							}
							
						}
					%>			
				<%-- 	<label for="address_state">  <fmt:message
							key="lbl.sbi.startup.address_state" /></label> <input  name="address_state"
						id="address_state" value="<%=address_state%>"> --%>
						</select>		
		</div>
			</div>			
			<p>&nbsp;</p>
			<div class="clearfix"></div>
			</div>
			
			<!----Address-END---->
			
			<!-- corporate Email -->
						
			<div class="edu-form-row">
				<!-- <label for="Corporate Email"> 
					<fmt:message	key="lbl.sbi.startup.corporate_email" />
				</label>-->				
				<span class="border_dotted"></span>
				<div class="edu-form-leftcol">
					<label for="Sanction">  
					<fmt:message key="lbl.sbi.startup.corporate_email" />
					<span class="red-mandate">*</span>
				</label> <input type="text" onblur="enableSaveButton()"
						name="corporate_email" id="corporate_email" size="30"
						  value="<%=corporate_email%>" />
				</div>
				<div class="edu-form-righttcol">
					<label for="Sanction">  
						<fmt:message key="lbl.sbi.startup.corporate_website" />
						<span class="red-mandate">*</span>
					</label>
					 <input type="text" placeholder = "http(s)://www.example.com"
						name="corporate_website" id="corporate_website" size="30"
						  value="<%=corporate_website%>" />
				</div>				
			</div>
			<!-- corporate Email end -->
				
			
			<p>&nbsp;</p>
			<div class="clearfix"></div>

			<!--<div class="branchnamequerydiv"></div>-->

			<div class="edu-form-row">
				<div class="edu-form-leftcol width100perc">
					<label for="branch-code">  
					<fmt:message key="lbl.sbi.startup.current_promoters_name" />
					<span class="red-mandate">*</span>
					</label>
					<div id="founder_list">
					<table id="founders_list" style="width:100%;">
						<tr class="tr_found">
						
						<td id="initial_found_0">
						<input placeholder="Name" name="initial_founders" id="initial_founders" class="initial_founders" value="<%=initial_founders%>" style="float:left;"  onkeypress="onlyCharacters(this,event)" maxlength="<fmt:message key="lbl.sbi.startup.name.max_chars"/>">
						</td>
						<td id="chk_prom_0">
 						<span class="is_chk_pro" style="margin:6px 0px 0px 0px;float:left;"> 
					 	<input type="checkbox" name="is_promoter" id = "is_promoter" placeholder="Name" style="border:none;box-shadow:none;width:13px;margin: 0px 0px 0px 0px;float:left;">
					 </span> 
					 <span style="margin:6px 0px 0px 6px;float:left;"><fmt:message key="lbl.sbi.startup.is_promoters" /></span>
						</td>
						
						<td>
						<span style="border: none;box-shadow: none;margin:8px 0px 0px 0px;float: left;">
						 <a href="javascript:void(0);" onclick="addRow('founders_list')">
<!-- 						 <input type = "button" value="Add More" style="width: 55px;font-size: 10px;padding: 5px 5px 5px 5px;border: none;font-weight: bold;"> -->
						 	<img src="<%=request.getContextPath()%>/html/images/plus.png" width="25" height="25" border="1" >
						 </a>
						 <a href="javascript:void(0);" class="minibox"  onclick="deleteRow('founders_list',this)">
						 	<img src="<%=request.getContextPath()%>/html/images/minus.png" width="25" height="25" border="1" >
						 </a>
					 </span>
						</td>
						
						</tr>
					</table>
					 
					 
					 
					 
					 </div>
				</div>
		</div>
		<p>&nbsp;</p>
		<div class="edu-form-row">
				<div class="edu-form-leftcol">
					<label for="excluding_promoters">  
					<fmt:message key="lbl.sbi.startup.excluding_promoters" />
					<span class="red-mandate">*</span>
					</label> <input  name="noofemp"
						id="noofemp" value="<%=noofemp%>" onkeypress="OnlyNumericEntry(event)" maxlength=" <fmt:message
							key="lbl.sbi.startup.emp.max_chars" />">
				</div>

		</div>
		<p>&nbsp;</p>
		<div class="clearfix"></div>
			
			<!---New Added Fields--->

			<div class="edu-form-row">
				<div class="edu-form-leftcol width100perc">
					<label for="branch-code"> <fmt:message
							key="lbl.sbi.startup.description_of_product" /><span
						class="red-mandate">*</span>						
					</label>
					<textarea name="description_of_product" onkeyup="getDesc(this)"
					id="description_of_product" rows="6" style="" ><%=description_of_product %></textarea>
					<span class="fltr_text"><fmt:message key="lbl.sbi.startup.characters_left" /> <lab id="count_description_of_product">
					1500</lable></span>
					 
				</div>
		</div>
		<p>&nbsp;</p>
		<div class="edu-form-row">
				<div class="edu-form-leftcol width100perc">
					<label for="load-limit"> 
						<fmt:message key="lbl.sbi.startup.business_model" /> 
						<span class="red-mandate">*</span>							
					</label> 
						<textarea name="business_model" onkeyup="getModel(this)" id="business_model" rows="6" style=""><%=business_model %></textarea>
						<span class="fltr_text"><fmt:message key="lbl.sbi.startup.characters_left" /> <lable id="count_business_model">1500</lable></span>
				</div>

			</div>
			<p>&nbsp;</p>
			
			<div class="clearfix"></div>


			<div class="edu-form-row">
				<div class="edu-form-leftcol width100perc">
					<label for="Sanction">
						<fmt:message key="lbl.sbi.startup.monetary_value" />
						<span class="red-mandate">*</span>							
					</label>
<!-- 					 <input type="text" name="monetary_value" id="monetary_value" class="width94perc" style="width:94%;" -->
<%-- 						size="30"  value="<%=monetary_value%>" /> --%>
						<textarea name="monetary_value" id="monetary_value" onkeyup="getMonetary(this)" rows="6" style=""><%=monetary_value %></textarea>
						<span class="fltr_text"><fmt:message key="lbl.sbi.startup.characters_left" /> <lable id="count_monetary_value">1500</lable></span>
				</div>

			</div>
			<p>&nbsp;</p>
			<div class="clearfix"></div>
			<div class="edu-form-row">
				<div class="edu-form-leftcol">
					<label for="branch-name" style="width: 265px;"> 
					<fmt:message key="lbl.sbi.startup.initial_capital" />
					<span class="red-mandate">*</span>						
					</label> <input name="initial_capital" maxlength="8" id="initial_capital" class="width94perc"
						value="<%=initial_capital%>" onkeypress="checkRS(this,event)" onblur="addZero(this,event)"/>
				</div>
				
				<div class="edu-form-righttcol">
					<label for="branch-code"> 
						<fmt:message key="lbl.sbi.startup.current_capital" />
						<span class="red-mandate">*</span>
					</label> 
					<input maxlength="8" name="current_capital"
						id="current_capital" value="<%=current_capital%>" onkeypress="checkRS(this,event)" onblur="addZero(this,event)">
				</div>
			</div>
			<p>&nbsp;</p>
			
			<div class="clearfix"></div>
		
			<p>&nbsp;</p>
			<div class="edu-form-row">
			<label for="capital_infusion">  <fmt:message key="lbl.sbi.startup.capital_infusion" />
					</label>
					<br/>
			<span class="border_dotted"></span>
			<div>
					<table id="promotors_list" style="width:100%;">
						<tr class="tr_clone">
						
						<td id="ficp_name_0">
						<input name="cp_promoters_name"  onkeypress="onlyCharacters(this,event)" id="cp_promoters_name" placeholder="Name"  class="cp_promoters_name" value="<%=cp_promoters_name%>" style="float:left;width:150px" maxlength="<fmt:message key="lbl.sbi.startup.name.max_chars"/>">
						</td>
						<td id="ficp_address_0">
						<textarea name="cp_promoters_address" id="cp_promoters_address"   class="cp_promoters_address" placeholder="Address"  rows="4" style="width:150px;resize:none;" maxlength="<fmt:message key="lbl.sbi.startup.capInfAdd.max_chars"/>"><%=cp_promoters_address %></textarea>
					 	</td>
						<td id="ficp_amount_0">
						<input name="cp_promoters_amount" id="cp_promoters_amount"  placeholder="Amount(in Lakhs)" class="cp_promoters_amount" value="<%=cp_promoters_amount%>" 
						style="float:left;width: 111px;" onblur="addZero(this,event)" onkeypress="checkRS(this,event)" maxlength="8">
						</td>
						<td>
						<span style="border: none;box-shadow: none;margin:8px 0px 0px 0px;float: left;">
						<!--   <a href="javascript:void(0);" onclick="addRowpromotor('promotors_list')"> -->
<!-- 						 <input type = "button" value="Add More" style="width: 55px;font-size: 10px;padding: 5px 5px 5px 5px;border: none;font-weight: bold;"> -->
						 <!--  	<img src="<%=request.getContextPath()%>/html/images/plus.png" width="25" height="25" border="1" > -->
					<!-- 	 </a> -->
						 <a href="javascript:void(0);">
<!-- 						 <input type = "button" value="Add More" style="width: 55px;font-size: 10px;padding: 5px 5px 5px 5px;border: none;font-weight: bold;"> -->
						 	<img class="tr_clone_add" src="<%=request.getContextPath()%>/html/images/plus.png" width="25" height="25" border="1" >
						 </a>
						<!--  <a href="javascript:void(0);" class="minibox" onclick="deleteRow('promotors_list',this)">
						 	<img src="<%=request.getContextPath()%>/html/images/minus.png" width="25" height="25" border="1" >
						 </a> -->
						 <a href="javascript:void(0);" class="minibox" >
						 	<img class="tr_clone_remove" src="<%=request.getContextPath()%>/html/images/minus.png" width="25" height="25" border="1" >
						 </a>
					 </span>
						</td>
						
						</tr>
					</table>
					</div>
			<%-- 	<div class="edu-form-leftcol" style="width:125px;margin-right:10px;">
					<label for="cp_promoters_name">  <fmt:message
							key="lbl.sbi.startup.cp_name" /></label> 
					<input  name="cp_promoters_name"
						id="cp_promoters_name" value="<%=cp_promoters_name%>"  style="width:100px;">
				</div>
				<div class="edu-form-leftcol" style="width:125px;margin-right:10px;">
					<label for="cp_promoters_address">  <fmt:message
							key="lbl.sbi.startup.cp_address" /></label> 
						<!--<input  name="excluding_promoters"	id="excluding_promoters" value="<%=cp_promoters_address%>" onkeypress="OnlyNumericEntry(event)"  style="width:100px;">-->
						<textarea name="cp_promoters_address" id="cp_promoters_address" rows="4" style="width:100px;resize:none;"><%=address_investors %></textarea>
					
				</div>
				<div class="edu-form-leftcol" style="width:125px;margin-right:10px;">
					<label for="cp_promoters_amount">  <fmt:message
							key="lbl.sbi.startup.cp_amount" /></label> <input  name="cp_promoters_amount"
						id="cp_promoters_amount" value="<%=cp_promoters_amount%>" onkeypress="OnlyNumericEntry(event)"  style="width:100px;">
				</div>
				<div class="edu-form-leftcol" style="width:125px;margin-right:10px;">
					<label for="excluding_promoters">  <fmt:message
							key="lbl.sbi.startup.addMore" /></label>
						 <input  name="excluding_promoters"
						id="excluding_promoters" value="<%=excluding_promoters%>" onkeypress="OnlyNumericEntry(event)"  style="width:100px;">
				</div> --%>
			</div>
			<p>&nbsp;</p>

			<!--<div class="branchnamequerydiv"></div>-->

			<!-- --<div class="edu-form-row">				
				<div class="edu-form-leftcol width100perc">
					<label for="capital_infusion">  <fmt:message key="lbl.sbi.startup.capital_infusion" /><span
						class="red-mandate">*</span>
					</label> <input name="capital_infusion" id="capital_infusion" style="width:94%;"
						value="<%=capital_infusion%>" onkeypress="OnlyNumericEntry(event)">
				</div>

			</div>-->
			<p>&nbsp;</p>
			<div class="clearfix"></div>


			<!---->
<%-- 
			<div class="edu-form-row">

				<div class="edu-form-leftcol width100perc">
					<label for="address_investors"> <fmt:message
							key="lbl.sbi.startup.address_investors" /><span
						class="red-mandate">*</span>
					</label> 
					<textarea name="address_investors" id="address_investors" rows="6" style=""><%=address_investors %></textarea>
				</div>

			</div>
			<p>&nbsp;</p> --%>
			<div class="edu-form-row">			
			<label for="valuation_amount">
				<fmt:message key="lbl.sbi.startup.valuation_amount" />
<!-- 				<span class="red-mandate">*</span> -->
			</label>
			<span class="border_dotted"></span>
				<div class="edu-form-leftcol width100perc">
										
					<div class="width170px">
					<label for="valuer_name"> <fmt:message
							key="lbl.sbi.startup.valuer_name" />
					</label> 
					<input type="text" name="valuer_name" id="valuer_name"
						size="30" onkeypress="onlyCharacters(this,event)"  value="<%=valuer_name%>" style="width:140px;" maxlength="<fmt:message key="lbl.sbi.startup.name.max_chars"/>"/>
					</div>
					<div class="width170px">
					<label for="valuation_date"> <fmt:message
							key="lbl.sbi.startup.valuation_date" />
					</label> 
					<input type="text" name="valuation_date" id="valuation_date"
						size="30"  value="<%=valuation_date%>"  style="width:140px;"/>
					</div>
					<div class="width170px">
					<label for="valuation_amount_rs"> <fmt:message
							key="lbl.sbi.startup.valuation_amount_rs" />
					</label> 
					<input type="text" name="valuation_amount_rs" id="valuation_amount_rs"
						size="30" maxlength="8"  value="<%=valuation_amount_rs%>" style="width:140px;" onblur="addZero(this,event)" onkeypress="checkRS(this,event)" />
					</div>					
				</div>
			</div>
			<p>&nbsp;</p>
			<div class="clearfix"></div>
			<div class="edu-form-row">				
				<label for="Sanction"> 
					<fmt:message	key="lbl.sbi.startup.Loans_availed" />
				</label>				
				<span class="border_dotted"></span>									
				<div class="edu-form-leftcol">	
				<label for="loan_avail_source"> <fmt:message
							key="lbl.sbi.startup.loan_avail_source" /></label>		
					<input type="text" name="loan_avail_source" id="loan_avail_source"
						size="30" onkeypress="onlyCharacters(this,event)"  value="<%=loan_avail_source%>" maxlength="<fmt:message key="lbl.sbi.startup.name.max_chars"/>"/>
				</div>	
				<div class="edu-form-righttcol">	
					<label for="loan_avail_rs"> <fmt:message
							key="lbl.sbi.startup.loan_avail_rs" /></label>
					<input type="text" name="loan_avail_rs" id="loan_avail_rs"
						size="30"  maxlength="8" value="<%=loan_avail_rs%>" onblur="addZero(this,event)" onkeypress="checkRS(this,event)"/>
				</div>
			</div>
			<p>&nbsp;</p>
			<div class="clearfix"></div>
			
			<!-----START YEAR RUPEES----->
			
			<div class="edu-form-row">
				<div class="outer_border" style="border:1px solid #C8C9CA;float:left;padding:6px 10px 5px 5px;">
				
				<label for="Sanction"> 
					<fmt:message	key="lbl.sbi.startup.gross_revenue_details" />
<!-- 					<span class="red-mandate">*</span> -->
				</label>				
				<span class="border_dotted"></span>
				<br/>
				<div class="new_year_defines" style="width:100px;float:left;">
				<label for="gross_revenue"> 
						<fmt:message key="lbl.sbi.startup.gross_revenue" />
					</label>
				<span class="border_dotted"></span>	
				<div class="edu-form-leftcol" style="width:100px;">
					
					<span class="margin-top10px" style="float:left;margin-top:28px;width:100%;">
						<label for="gross_revenue_year1" id = "gross_revenue_year1"> 
							<fmt:message key="lbl.sbi.startup.curr_fin_year" />
						</label>
						<input type="hidden" class="gross_revenue_year1" name="gross_revenue_year1" id="gross_revenue_year1"
						value="<fmt:message key="lbl.sbi.startup.curr_fin_year" />"
						>
					</span>
<!-- 					<input type="text" class="gross_revenue_year1" name="gross_revenue_year1" id="gross_revenue_year1" tabindex="1" -->
<%-- 						size="30" value="<%=gross_revenue_year1%>" onkeypress="OnlyNumericEntry(event)" /> --%>
					<br/><br/>
<!-- 						<label for="gross_revenue_year2">  -->
<%-- 						<fmt:message key="lbl.sbi.startup.gross_revenue_year" /><span --%>
<!-- 						class="red-mandate">*</span> -->
<!-- 					</label> -->
					<span class="margin-top10px" style="float:left;margin-top:45px;width:100%;">
					<label for="gross_revenue_year2"  id = "gross_revenue_year2"> 
						<fmt:message key="lbl.sbi.startup.prev_fin_year" />
					</label>
					<input type="hidden" class="gross_revenue_year2" name="gross_revenue_year2" id="gross_revenue_year2" value="<fmt:message key="lbl.sbi.startup.prev_fin_year" />">
					</span>
<!-- 					<input type="text" name="gross_revenue_year2" id="gross_revenue_year2"   tabindex="3" -->
<%-- 						size="30" value="<%=gross_revenue_year2%>" onkeypress="OnlyNumericEntry(event)"/> --%>
					<br/><br/>
<!-- 					<label for="gross_revenue_year3">  -->
<%-- 						<fmt:message key="lbl.sbi.startup.gross_revenue_year" /><span --%>
<!-- 						class="red-mandate">*</span> -->
<!-- 					</label> -->
					<span class="margin-top10px" style="float:left;margin-top:45px;width:100%;">
					<label for="gross_revenue_year3" id = "gross_revenue_year3"> 
						<fmt:message key="lbl.sbi.startup.last_fin_year" />
					</label>
					<input type="hidden" class="gross_revenue_year3" name="gross_revenue_year3" id="gross_revenue_year3" value="<fmt:message key="lbl.sbi.startup.last_fin_year" />">
					</span>
<!-- 					<input type="text" name="gross_revenue_year3" id="gross_revenue_year3" -->
<%-- 						size="30" value="<%=gross_revenue_year3%>" onkeypress="OnlyNumericEntry(event)"/>					 --%>
					<br/><br/>	
					</div>
				</div>
				
				<div class="edu-form-leftcol" style="width:115px;margin-left:25px;">
					<label for="gross_revenue"> 
						<fmt:message key="lbl.sbi.startup.gross_revenue_title" />
					</label>
					<span class="border_dotted"></span>	
					
					<label for="gross_revenue_rs1"> 
						<fmt:message key="lbl.sbi.startup.gross_revenue_rs" />
					</label>
					<input name="gross_revenue_rs1" id="gross_revenue_rs1" tabindex="2"
						value="<%=gross_revenue_rs1%>" maxlength="8" onblur="addZero(this,event)" onkeypress="checkRS(this,event)" style="width:100px;"/>
					<br/><br/>
						<label for="gross_revenue_rs2"> 
						<fmt:message key="lbl.sbi.startup.gross_revenue_rs" />
					</label>
					<input name="gross_revenue_rs2" id="gross_revenue_rs2" tabindex="4"
						value="<%=gross_revenue_rs2%>" maxlength="8" onblur="addZero(this,event)" onkeypress="checkRS(this,event)" style="width:100px;" />					
					<br/><br/>		
					<label for="gross_revenue_rs3"> 
						<fmt:message key="lbl.sbi.startup.gross_revenue_rs" />
					</label>
				<input name="gross_revenue_rs3" maxlength="8" id="gross_revenue_rs3" value="<%=gross_revenue_rs3%>" onblur="addZero(this,event)" onkeypress="checkRS(this,event)" style="width:100px;"/>
				<br/><br/>										
				</div>
				
				<!----NEW EBIDTA START---->
				
				<div class="new_ebidta_define" style="width:115px;margin-left:25px;float:left;">
				<label for="ebidta"> <fmt:message
							key="lbl.sbi.startup.ebidta" /></label>	
				<span class="border_dotted"></span>				
				<div class="edu-form-leftcol">				
				<label for="ebidta_rs1"> 
						<fmt:message key="lbl.sbi.startup.gross_revenue_rs" />
					</label>
					<input name="ebidta_rs1" id="ebidta_rs1"
						value="<%=ebidta_rs1%>" maxlength="8" onblur="addZero(this,event)" onkeypress="checkRS(this,event)"  style="width:100px;" />
					<br/><br/>
					<label for="ebidta_rs2"> 
						<fmt:message key="lbl.sbi.startup.gross_revenue_rs" />
					</label>
					<input name="ebidta_rs2" id="ebidta_rs2"
						value="<%=ebidta_rs2%>" maxlength="8" onblur="addZero(this,event)" onkeypress="checkRS(this,event)"   style="width:100px;"/>
						<br/><br/>
				<label for="ebidta_rs3"> 
						<fmt:message key="lbl.sbi.startup.gross_revenue_rs" />
					</label>
					<input name="ebidta_rs3" id="ebidta_rs3"
						value="<%=ebidta_rs3%>" maxlength="8" onblur="addZero(this,event)" onkeypress="checkRS(this,event)"  style="width:100px;"/>
					<br/><br/>
				</div>
			
				</div>
				
				<!-- NEW EBIDTA END -->
				<!-- define new_netprofit start-->
				<div class="new_netprofit" style="width:115px;margin-left:25px;float:left;">
				<label for="net_profit">  <fmt:message
							key="lbl.sbi.startup.net_profit" />
					</label>
				<span class="border_dotted"></span>
				<div class="edu-form-leftcol">					
					<label for="net_profit_rs1"> 
						<fmt:message key="lbl.sbi.startup.gross_revenue_rs" />
					</label>
					<input name="net_profit_rs1" id="net_profit_rs1"
						value="<%=net_profit_rs1%>" maxlength="8" onblur="addZero(this,event)" onkeypress="checkRS(this,event)"   style="width:100px;"/>
					<br/><br/>	
						
					<label for="net_profit_rs2"> 
						<fmt:message key="lbl.sbi.startup.gross_revenue_rs" />
					</label>
					<input name="net_profit_rs2" id="net_profit_rs2"
						value="<%=net_profit_rs2%>" maxlength="8" onblur="addZero(this,event)" onkeypress="checkRS(this,event)"  style="width:100px;"/>										
					<br/><br/>	
					<label for="net_profit_rs3"> 
						<fmt:message key="lbl.sbi.startup.gross_revenue_rs" />
					</label>
					<input name="net_profit_rs3" id="net_profit_rs3"
						value="<%=net_profit_rs3%>" maxlength="8" onblur="addZero(this,event)" onkeypress="checkRS(this,event)"  style="width:100px;"/>
<%-- 					 <input name="net_profit" id="net_profit" value="<%=net_profit%>"> --%>
				<br/><br/>
				</div>
				
				</div><!-- define new_netprofit END -->
				
			</div>
				
			</div>
			<p>&nbsp;</p>
			<div class="clearfix"></div>			


			<div class="clearfix"></div>
            <div class="edu-form-row width100perc">
				<div class="edu-form-leftcol">
					<label for="financial_bank_engagement"> 
						<fmt:message key="lbl.sbi.startup.financial_bank_engagement" />
						<span class="red-mandate">*</span>
					</label> 
					<select style="width: 535px" name="financial_bank_engagement"
						id="financial_bank_engagement" onchange="hideShowDiv()">	
						<option value="0"> --please select-- </option>					 
						<option value="Procurement" id="0">Procurement of our Product/Services</option>
						<option value="Financialassistance" id="1">Financial Assistance from the Bank</option>						 
					</select>
				</div>
			</div>
			<div class="clearfix"></div>            
			<div class="edu-form-row" id="typeOfFinancialAssist">
				<div class="edu-form-leftcol width100perc" >
					<label for="financial_assistance"> 
						<fmt:message key="lbl.sbi.startup.schemename" />
						<span class="red-mandate">*</span>
					</label> 
					<select   style="width:535px;" name="financial_assistance"
						id="financial_assistance">
						<option value="0"> --please select-- </option>
						<option value="Equity without IPR">Equity without IPR</option>
						<option value="Equity with Joint IPR">Equity with Joint IPR</option>
						<option value="Equity with Restricted IPR">Equity with Restricted IPR</option>
						<option value="Mezzanine Equity">Mezzanine Equity</option>
						<option value="Short Term Loan">Short Term Loan</option>
						<option value="Long Term Loan">Long Term Loan</option>
						<option   value="Equity with perpetual,
							unlimited free license for use of the technology in State Bank
							Group">Equity with perpetual,
							unlimited free license for use of the technology in State Bank
							Group</option>
						<option value="Grant">Grant</option>
					</select>
				</div>
		</div>
		
			<div class="clearfix"></div>
			<p>&nbsp;</p>
			<div class="edu-form-row" id="financial_assistance_purpose_id" style="display:none;">
				<div class="edu-form-leftcol width100perc">
					<label for="financial_assistance">  <fmt:message
							key="lbl.sbi.startup.financial_assistance" /><span
						class="red-mandate">*</span>
						
					</label> 
						<textarea name="financial_assistance_purpose" onkeyup="financialAssistance(this)" id="financial_assistance_purpose" rows="6" style="" maxlength="<fmt:message
							key="lbl.sbi.startup.max_chars" />"><%=financial_assi_purp %></textarea>
						<span class="fltr_text"><fmt:message key="lbl.sbi.startup.characters_left" /> <lable id="count_financial_assistance_purpose">1500</lable></span>
				</div>

				</div>
			<div class="clearfix"></div>           
			
<!-- 			<div class="edu-form-row"> -->
<!-- 				<div class="edu-form-leftcol"> -->
<%-- 					<label for="revenue_projections">  <fmt:message --%>
<%-- 							key="lbl.sbi.startup.revenue_projections" /><span --%>
<!-- 						class="red-mandate">*</span> -->
<!-- 						<span class="border_dotted"></span>	 -->
				<!-- 					</label> <input name="revenue_projections" id="revenue_projections" -->
				<%-- 						  value="<%=revenue_projections%>" onkeypress="OnlyNumericEntry(event)"> --%>
<!-- 				</div>			 -->
<!-- 			</div>	 -->
						<div class="edu-form-row">
				<div class="outer_border" style="border:1px solid #C8C9CA;float:left;padding:6px 10px 5px 5px;">
				
				<label for="revenue_projections"> 
					<fmt:message	key="lbl.sbi.startup.revenue_projections" />
					<span class="red-mandate">*</span>
				</label>				
				<span class="border_dotted"></span>
				<br/>
				<div class="new_year_defines" style="width:100%;float:left;">
				<div class="edu-form-leftcol" style="width:100%;float:left;">
					
					<span class="margin-top10px" style="width:150px;margin-left:25px;float:left;text-align:center;">
						<label for="gross_revenue_project_year1" id = "gross_revenue_year1"> 
							<fmt:message key="lbl.sbi.startup.curr_fin_year_plus_one" />
						</label>
						<input type="hidden" class="gross_revenue_year1" name="revenue_project_year1" id="revenue_project_year1"
						value="<fmt:message key="lbl.sbi.startup.curr_fin_year_plus_one" />"
						>
					</span>
<!-- 					<input type="text" class="gross_revenue_year1" name="gross_revenue_year1" id="gross_revenue_year1" tabindex="1" -->
<%-- 						size="30" value="<%=gross_revenue_year1%>" onkeypress="OnlyNumericEntry(event)" /> --%>
					
<!-- 						<label for="gross_revenue_year2">  -->
<%-- 						<fmt:message key="lbl.sbi.startup.gross_revenue_year" /><span --%>
<!-- 						class="red-mandate">*</span> -->
<!-- 					</label> -->
					<span class="margin-top10px" style="width:150px;margin-left:25px;float:left;text-align:center;">
					<label for="gross_revenue_project_year2"  id = "gross_revenue_project_year2"> 
						<fmt:message key="lbl.sbi.startup.curr_fin_year_plus_two" />
					</label>
					<input type="hidden" class="gross_revenue_year2" name="revenue_project_year2" id="revenue_project_year2" 
					value="<fmt:message key="lbl.sbi.startup.curr_fin_year_plus_two" />">
					</span>
<!-- 					<input type="text" name="gross_revenue_year2" id="gross_revenue_year2"   tabindex="3" -->
<%-- 						size="30" value="<%=gross_revenue_year2%>" onkeypress="OnlyNumericEntry(event)"/> --%>
					
<!-- 					<label for="gross_revenue_year3">  -->
<%-- 						<fmt:message key="lbl.sbi.startup.gross_revenue_year" /><span --%>
<!-- 						class="red-mandate">*</span> -->
<!-- 					</label> -->
					<span class="margin-top10px" style="width:150px;margin-left:25px;float:left;text-align:center;">
					<label for="gross_revenue_project_year2" id = "gross_rproject_year3"> 
						<fmt:message key="lbl.sbi.startup.curr_fin_year_plus_three" />
					</label>
					<input type="hidden" class="gross_revenue_year3" name="revenue_project_year3" id="revenue_project_year3" 
					value="<fmt:message key="lbl.sbi.startup.curr_fin_year_plus_three" />">
					</span>
<!-- 					<input type="text" name="gross_revenue_year3" id="gross_revenue_year3" -->
<%-- 						size="30" value="<%=gross_revenue_year3%>" onkeypress="OnlyNumericEntry(event)"/>					 --%>
						
					</div>
				</div>
				
				<div class="edu-form-leftcol" style="width:150px;margin-left:25px;">					
					<input name="gross_projected_revenue_rs1" maxlength="8" id="gross_projected_revenue_rs1" tabindex="2"
						value="<%=gross_projected_revenue_rs1%>" onblur="addZero(this,event)" onkeypress="checkRS(this,event)" style="width:125px;"/>
					
						<br/><br/>										
				</div>
				
				<!----Revenue projection START---->
				
				<div class="new_ebidta_define" style="width:150px;margin-left:25px;float:left;">			
				<div class="edu-form-leftcol">
					<input name="gross_projected_revenue_rs2" id="gross_projected_revenue_rs2"
						value="<%=gross_projected_revenue_rs2%>" maxlength="8" onblur="addZero(this,event)" onkeypress="checkRS(this,event)"  style="width:125px;" />
					<br/><br/>					
				</div>			
				</div>
				
				
				<div class="new_netprofit" style="width:150px;margin-left:25px;float:left;">
					<div class="edu-form-leftcol">
						<input name="gross_projected_revenue_rs3" id="gross_projected_revenue_rs3"
							value="<%=gross_projected_revenue_rs3%>" onblur="addZero(this,event)" maxlength="8" onkeypress="checkRS(this,event)"   style="width:125px;"/>
						<br/><br/>					
					</div>				
				</div>
				
			</div>
				
			</div>
			<div class="clearfix"></div>   
			<p>&nbsp;</p>
			
			<div class="edu-form-row">
				<div class="edu-form-leftcol width100perc">
					<label for="agreeable_process">  
					<fmt:message key="lbl.sbi.startup.agreeable_process" />
					<span class="red-mandate">*</span>
					</label>
					  <br/>
<!-- 					<input name = "agreeable_process" id="agreeable_process" -->
<%-- 						value="<%=agreeable_process%>"> --%>
						<span class="aggrible_btn" style="">
						<input type="radio" name="agreeable_process" id="agreeable_process_yes" class="aggrible_btn_text"
						value="Yes">Yes
						</span>
						<span class="aggrible_btn" style="">
						<input type="radio" name="agreeable_process" id="agreeable_process_no" class="aggrible_btn_text"
						value="No">No
						</span>
				</div>
			</div>
			<p>&nbsp;</p>
			<div class="clearfix"></div>
			
		
			<div class="clearfix"></div>
			<br/><br/>
			<!------STRAT----Incubator---Department ----->
			
			<div class="edu-form-row">
				<div class="edu-form-leftcol width100perc">
					<label for="startupindia"> 
					 <fmt:message	key="lbl.sbi.startup.startupindia" />
					 <span class="red-mandate">*</span>
					</label> 
					
					<span class="border_dotted"></span>
					<br/>
					<span class="aggrible_btn" style="">
					<input type="radio" name="startupindia" id="startupindia_yes" class="aggrible_btn_text"
						value="Yes" onClick="hideShowIncubator(this)">Yes
					</span>
					<span class="aggrible_btn" style="">
						<input type="radio" name="startupindia" id="startupindia_no" class="aggrible_btn_text"
						value="No" onClick="hideShowIncubator(this)">No
					</span>
<!-- 					<input name="startupindia" id="startupindia" class="width94per" style="width:94%;" -->
<%-- 						value="<%=startupindia%>"> --%>
				</div>
			</div>
			<p>&nbsp;</p>
			<!------END------GSR----Department ----->
		
			<div class="clearfix"></div>


			<div class="edu-form-row" id="incubator_row" style="display:none;">
				<div class="edu-form-leftcol width100perc">
					<label for="incubator">  
					<fmt:message key="lbl.sbi.startup.incubator" />
					<span class="red-mandate">*</span>
					</label> <input name="incubator" id="incubator"  class="width94per" style="width:94%;"
						value="<%=incubator%>">
				</div></div>
				<p>&nbsp;</p>
				<div>
<%-- 		<portlet:resourceURL var="captchaURL" id="captchaURL" /> --%>
<%-- 		<liferay-ui:captcha url="<%=captchaURL%>" />  --%>
<!-- 		</div> -->
		
<!--  		<div style="position:absolute; margin-left:205px; padding-top:27px; cursor: pointer;">  -->
<!-- 	<div > -->
<!--          <img id="refreshCaptchaActivity"  -->
<%--          src="<%= request.getContextPath()%>/html/images/refresh.png">  --%>
<!--         </div> -->
        
        <div class="edu-form-row">

				<portlet:resourceURL var="captchaURL" id="captchaURL"/>
				<liferay-ui:captcha url="<%=captchaURL%>" />
				<!-- <div style="padding: 23px 0 0 5px; cursor: pointer;"> -->
<!-- 				<div style="position:absolute; cursor: pointer;"> -->
<!-- 					<img id="refreshCaptchaActivity" -->
<%-- 						src="<%=request.getContextPath()%>/html/images/refresh.png"> --%>
<!-- 				</div> -->
			</div>
<!-- 				<hr> -->
<!-- 					<div class="form-title">Name and Signature Image</div> -->
<!-- 	<hr> -->
	
<!-- 	<div class="edu-form-row"> -->
	
<%-- 		<div id="errdisplayimage" class="err-msgimage"><%=errtextimage%></div>	 --%>
		
<!-- 		<div class="edu-form-single-col" style="width:100%"> -->
		 
<!-- 		<input type="file" name="NameandsigImage" id="NameandsigImage" > -->
<!-- 		<button class="button" type="button" onclick="addMoreFiles()">Upload</button>  -->
	 
<!-- 		<div class="drag-area" id="drag-area"></div> -->
		
<!-- 		</div> -->
		
<!-- 	</div> -->
			<p>&nbsp;</p>
			<p>&nbsp;</p>
			<div class="clearfix"></div>
			
			<p> <span style="color:red;font-weight:bold;">NOTE:&nbsp;&nbsp;</span>
			 
			No documents should be submitted along with the application. However, documents as required will be called for if the application is found to be prima facie suitable for further evaluation.
			
			<div class="edu-form-row">
			<!-- <div class="btn-right" style="width: 100%;margin-left: 38%;padding-bottom:20px;" >
  			<input  type="submit"  onclick="return validate()" style="width: 165px;" value='<fmt:message key="bttn.sbi.eduloan.submitquery" />'  >
  			
  			</div> --> 
	  			<div class="edu-form-row">

				<div class="edu-form-leftcol">
				 	<input  type="submit"  onclick="return validate()" class="startup_date"  style="padding:4px 8px;"  
  					value='<fmt:message key="bttn.sbi.eduloan.submitquery" />'  >
  					
  					
  					<%-- 
  					<input  type="submit"  onClick="infused_promoter_list()"  style="width: 165px;"  
  					value='<fmt:message key="bttn.sbi.eduloan.submitquery" />'  > --%>
  					
  
				</div>

				<div class="edu-form-righttcol">
					<input  type="button" disabled="disabled" class="saveForm" id="saveForm1" onclick="saveForm()"   
  					value='<fmt:message key="lbl.sbi.startup.save_btn" />'  > 
				</div>

			</div>			
			</div>
		
			<p>&nbsp;</p>		
			<!---END NEW Added ---->


</aui:form>


			<!-- END Interest Subsidy related query  -->
</div>
<!-- ---main form ends--- -->

<script>

jQuery("#refreshCaptchaActivity").click(
function() {

	jQuery(".captcha").attr(
			"src",
			jQuery(".captcha").attr("src") + "&force="
					+ new Date().getMilliseconds());
	return false;
});

jQuery("#refreshPartialCaptcha").click(
function() {

	jQuery(".captchaPartial").attr(
			"src",
			jQuery(".captchaPartial").attr("src") + "&force="
					+ new Date().getMilliseconds());
	return false;
});

</script>
		
		<!--END #inner -->
	</div>


