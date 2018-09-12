<%@page import="com.sbi.StartUp.model.SbiStartUp"%>
<%@page import="com.sbi.StartUp.StartUp"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.ArrayList"%>
<%@page import="javax.portlet.PortletSession"%>
<%@page import="com.liferay.util.portlet.PortletProps"%>
<%@page import="com.liferay.portal.kernel.dao.orm.Criterion"%>
<%@page import="com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQuery"%>
<%@page import="com.sbi.StartUp.service.SbiStartUpLocalServiceUtil"%>
<%@page import="com.sbi.StartUp.model.SbiStartUpModel"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@page import="com.liferay.util.portlet.PortletProps"%>
<%@page import="com.liferay.portlet.asset.model.AssetVocabulary"%>
<%@page import="com.liferay.portlet.asset.model.AssetCategory"%>
<%@page import="com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.OrderByComparator"%>
<%@page import="com.liferay.util.portlet.PortletProps"%>
<%@page import="com.liferay.portlet.asset.service.AssetVocabularyLocalServiceUtil"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<portlet:defineObjects />

<link rel="stylesheet" href="<%=request.getContextPath()%>/custom/jquery-ui-1.10.3.custom.css">

<link rel="stylesheet" href="<%=request.getContextPath()%>/custom/css/startup.css">
<script src="<%=request.getContextPath()%>/custom/jquery-1.9.1.min.js"></script>
<script src="<%=request.getContextPath()%>/custom/jquery-ui.js"></script>
<script src="<%=request.getContextPath()%>/js/jspdf.debug.js"></script>


<script src="<%=request.getContextPath()%>/custom/jquery.ui.widget.js"></script>
<script src="<%=request.getContextPath()%>/custom/jquery.ui.datepicker.js"></script>
<%
 

List<String> myarray = Arrays.asList(renderRequest.getParameter("promoters").split(","));
System.out.println("my aarray "+ request.getParameter("promoters").toString());
int count = 1;
int var = myarray.size();
 
%>


<fmt:setBundle basename="portlet" />

<%
String promoters="";
if (request.getParameter("promoters") != null) {
	promoters = request.getParameter("promoters");
}


String indexNo = "1";

if (request.getAttribute("indexno") != null) {
	indexNo = (String)request.getAttribute("indexno");
	System.out.println("--indexNO--"+indexNo);
}

String r_address_line_1="";
if (request.getParameter("r_address_line_1") != null) {
	r_address_line_1 = request.getParameter("r_address_line_1");
}

String r_address_line_2="";
if (request.getParameter("r_address_line_2") != null) {
	r_address_line_2 = request.getParameter("r_address_line_2");
}

String r_address_city="";
if (request.getParameter("r_address_city") != null) {
	r_address_city = request.getParameter("r_address_city");
}
String r_address_landmark="";
if (request.getParameter("r_address_landmark") != null) {
	r_address_landmark = request.getParameter("r_address_landmark");
}

String r_address_pin="";
if (request.getParameter("r_address_pin") != null) {
	r_address_pin = request.getParameter("r_address_pin");
}
String r_address_state="";
if (request.getParameter("r_address_state") != null) {
	r_address_state = request.getParameter("r_address_state");
}


String errtext = "";
if (request.getParameter("errtext") != null) {
errtext = request.getParameter("errtext");
}

String regNum="";
if(request.getParameter("regnum") != null )
{
	regNum = request.getParameter("regnum");
}
 

String Name="";
if(request.getParameter("Name") != null )
{
	Name = request.getParameter("Name");
}
String Email = "";
if (request.getParameter("Email") != null) {
	Email = request.getParameter("Email");
}
String Mnumber = "";
if (request.getParameter("Mnumber") != null) {
	Mnumber = request.getParameter("Mnumber");
}
String Dob = "";
if (request.getParameter("Dob") != null) {
	Dob = request.getParameter("Dob");
}
String CurrentAdd = "";
if (request.getParameter("CurrentAdd") != null) {
	CurrentAdd = request.getParameter("CurrentAdd");
}
String PermResiAdd = "";
if (request.getParameter("PermResiAdd") != null) {
	PermResiAdd = request.getParameter("PermResiAdd");
}
String Pan = "";
if (request.getParameter("Pan") != null) {
	Pan = request.getParameter("Pan");
}
String AadharNum = "";
if (request.getParameter("AadharNum") != null) {
	AadharNum = request.getParameter("AadharNum");
}
String CarrerAspect = "";
if (request.getParameter("CarrerAspect") != null) {
	CarrerAspect = request.getParameter("CarrerAspect");
}
String KeyITSkill = "";
if (request.getParameter("KeyITSkill") != null) {
	KeyITSkill = request.getParameter("KeyITSkill");
}
String CertfTra = "";
if (request.getParameter("CertfTra") != null) {
	CertfTra = request.getParameter("CertfTra");
}
String EmpyHistory = "";
if (request.getParameter("EmpyHistory") != null) {
	EmpyHistory = request.getParameter("EmpyHistory");
}
String CoreComp = "";
if (request.getParameter("CoreComp") != null) {
	CoreComp = request.getParameter("CoreComp");
}
String Accomplishment = "";
if (request.getParameter("Accomplishment") != null) {
	Accomplishment = request.getParameter("Accomplishment");
}
String Academics = "";
if (request.getParameter("Academics") != null) {
	Academics = request.getParameter("Academics");
}
 

String perm_address_line_1="";
if (request.getParameter("perm_address_line_1") != null) {
	perm_address_line_1 = request.getParameter("perm_address_line_1");
}

String perm_address_line_2="";
if (request.getParameter("perm_address_line_2") != null) {
	perm_address_line_2 = request.getParameter("perm_address_line_2");
}

String perm_address_city="";
if (request.getParameter("perm_address_city") != null) {
	perm_address_city = request.getParameter("perm_address_city");
}
String perm_address_landmark="";
if (request.getParameter("perm_address_landmark") != null) {
	perm_address_landmark = request.getParameter("perm_address_landmark");
}

String perm_address_pin="";
if (request.getParameter("perm_address_pin") != null) {
	perm_address_pin = request.getParameter("perm_address_pin");
}
String perm_address_state="";
if (request.getParameter("perm_address_state") != null) {
	perm_address_state = request.getParameter("perm_address_state");
}

%>

 

<style>


 
</style>

<portlet:resourceURL var="resumeUrl" id="resumeUrl" />
<portlet:resourceURL var="setStatus" id="setStatus"/>
<portlet:resourceURL var="downloadpdfURL" id="downloadpdfURL"/>
<portlet:resourceURL var="fetchResumeForm" id="fetchResumeForm"/>
<portlet:resourceURL var="saveResumeForm" id="saveResumeForm"/>
<script type="text/javascript">


var reg_name = /^[A-Za-z\s]{1,}[\._-]{0,1}[A-Za-z\s]{0,}$/;
var reg_digit = /^(([1-9]*)|(([1-9]*).([0-9]*)))$/;
var reg_email = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
var reg_specialchar = /^[a-zA-Z0-9 !@,._-]*$/;
var reg_alfanum = /^[a-zA-Z0-9]*$/;
var reg_phone = /^[0-9\-\+]{9,15}$/;
var reg_url = /^(http|https|ftp):\/\/[a-z0-9]+([\-\.]{1}[a-z0-9]+)*\.[a-z]{2,5}(:[0-9]{1,5})?(\/.*)?$/i; 
var reg_pan = /^([A-Z]{5}[0-9]{4}[A-Z]{1})$/;

$(function() {
    $(".Dob").datepicker({
    	dateFormat: 'dd-mm-yy',
      changeMonth: true,
      changeYear: true,
      yearRange: "-100:+0",
      maxDate: '+0d'
    });
});





function validate(form){
	
//$('#rimp').prop('disabled',false);
//$('#queryshemename').prop('disabled',false);

 var Name= $("#Name"+form).val();
if(Name == "")
{
	$("#errdisplay").html("<fmt:message key='err.fault.sbi.startup.Name' />");
   return false;
}
// if(registered_name.length > 50)
// {
// $("#errdisplay").html("<fmt:message key='err.fault.sbi.startup.registered_name' />");
//    return false;
// }

if(reg_name.test(Name) == false)
{
$("#errdisplay").html("<fmt:message key='err.fault.sbi.startup.name_char' />");
   return false;
}

var Email = $("#Email"+form).val();
if(Email == "")
{
	$("#errdisplay").html("<fmt:message key='err.fault.sbi.startup.Email' />");
    return false;
}
if(reg_email.test(Email) == false)
{
	$("#errdisplay").html("<fmt:message key='err.fault.sbi.startup.Email_char' />");
    return false;
}


var Mnumber = $("#Mnumber"+form).val();
if(Mnumber == "")
{
	$("#errdisplay").html("<fmt:message key='err.fault.sbi.startup.Mnumber'/>");
    return false;
}else if(Mnumber.length < 10){
	$("#errdisplay").html("<fmt:message key='err.fault.sbi.startup.Mnumber_digit'/>");
    return false;
}else if(!reg_digit.test(Mnumber)){
	$("#errdisplay").html("<fmt:message key='err.fault.sbi.startup.Mnumber_char'/>");
    return false;
}


var Dob = $("#Dob"+form).val();
if(Dob == "")
{
	$("#errdisplay").html("<fmt:message key='err.fault.sbi.startup.Dob' />");
    return false;
}

var r_address_line_1= $("#r_address_line_1" + form).val();
if(r_address_line_1 == "")
{
	$("#errdisplay").html("<fmt:message key='err.fault.sbi.startup.r_address_line_1' />");
   return false;
}

 var r_address_line_2= $("#r_address_line_2"+form).val();
 if(r_address_line_2 == "")
 {
 	$("#errdisplay").html("<fmt:message key='err.fault.sbi.startup.r_address_line_2' />");
    return false;
 }
 var r_address_landmark= $("#r_address_landmark" + form).val();
 if(r_address_landmark == "")
 {
 	$("#errdisplay").html("<fmt:message key='err.fault.sbi.startup.r_address_landmark' />");
    return false;
 }
var r_address_city= $("#r_address_city"+form).val();
if(r_address_city == "")
{
	$("#errdisplay").html("<fmt:message key='err.fault.sbi.startup.r_address_city' />");
   return false;
}
var r_address_pin= $("#r_address_pin"+form).val();
if(r_address_pin == "")
{
	$("#errdisplay").html("<fmt:message key='err.fault.sbi.startup.r_address_pin' />");
   return false;
}
if(r_address_pin.length < 6)
{
	$("#errdisplay").html("<fmt:message key='err.fault.sbi.startup.r_address_pin_char' />");
   return false;
}

var r_address_state= $("#r_address_state"+form).val();
if(r_address_state == "")
{
	$("#errdisplay").html("<fmt:message key='err.fault.sbi.startup.r_address_state' />");
   return false;
}
//address validation ends

/* var perm_address_line_1= $("#perm_address_line_1" + form).val();
if(perm_address_line_1 == "")
{
	$("#errdisplay").html("<fmt:message key='err.fault.sbi.startup.perm_address_line_1' />");
   return false;
} */
// var perm_address_line_2= $("#perm_address_line_2"+form).val();
// if(perm_address_line_2 == "")
// {
// 	$("#errdisplay").html("<fmt:message key='err.fault.sbi.startup.perm_address_line_2' />");
//    return false;
// }
// var perm_address_landmark= $("#perm_address_landmark" + form).val();
// if(perm_address_landmark == "")
// {
// 	$("#errdisplay").html("<fmt:message key='err.fault.sbi.startup.perm_address_landmark' />");
//    return false;
// }

/* var perm_address_city= $("#perm_address_city"+form).val();
if(perm_address_city == "")
{
	$("#errdisplay").html("<fmt:message key='err.fault.sbi.startup.perm_address_city' />");
   return false;
}
var perm_address_pin= $("#perm_address_pin"+form).val();
if(perm_address_pin == "")
{
	$("#errdisplay").html("<fmt:message key='err.fault.sbi.startup.perm_address_pin' />");
   return false;
}
if(perm_address_pin.length < 6)
{
	$("#errdisplay").html("<fmt:message key='err.fault.sbi.startup.perm_address_pin_char' />");
   return false;
}
var perm_address_state= $("#perm_address_state"+form).val();


if(perm_address_state == "")
{
	$("#errdisplay").html("<fmt:message key='err.fault.sbi.startup.perm_address_state' />");
   return false;
} */


var Pan = $("#Pan"+form).val();
Pan = Pan.toUpperCase();
if(Pan == "")
{
	$("#errdisplay").html("<fmt:message key='err.fault.sbi.startup.Pan'/>");
    return false;
}else if(!reg_pan.test(Pan)){
	$("#errdisplay").html("<fmt:message key='err.fault.sbi.startup.Pan_format'/>");
    return false;
}


var aadharNumber= $("#AadharNum"+form).val();
if(aadharNumber != "" && aadharNumber.length<12)
{
	
	$("#errdisplay").html("<fmt:message key='err.fault.sbi.startup.AadharNum' />");
   return false;
}



var CarrerAspect = $("#CarrerAspect"+form).val();
if(CarrerAspect.length >1500)
{
	$("#errdisplay").html("<fmt:message key='err.fault.sbi.startup.CarrerAspect_char'/>");
    return false;
}

var KeyITSkill = $("#KeyITSkill"+form).val();
if(KeyITSkill.length >1500)
{
	$("#errdisplay").html("<fmt:message key='err.fault.sbi.startup.KeyITSkill_char'/>");
    return false;
}

var CertfTra = $("#CertfTra"+form).val();
if(CertfTra.length >1500)
{
	$("#errdisplay").html("<fmt:message key='err.fault.sbi.startup.CertfTra_char'/>");
    return false;
}

var EmpyHistory = $("#EmpyHistory"+form).val();
if(EmpyHistory.length >1500)
{
	$("#errdisplay").html("<fmt:message key='err.fault.sbi.startup.EmpyHistory_char'/>");
    return false;
}


var CoreComp = $("#CoreComp"+form).val();
if(CoreComp == "")
{
	$("#errdisplay").html("<fmt:message key='err.fault.sbi.startup.CoreComp'/>");
    return false;
}

if(CoreComp.length >1500)
{
	$("#errdisplay").html("<fmt:message key='err.fault.sbi.startup.CoreComp_char'/>");
    return false;
}
Accomplishment
var Accomplishment = $("#Accomplishment"+form).val();
if(Accomplishment.length >1500)
{
	$("#errdisplay").html("<fmt:message key='err.fault.sbi.startup.Accomplishment_char'/>");
    return false;
}

var Academics = $("#Academics"+form).val();
if(Academics == "")
{
	$("#errdisplay").html("<fmt:message key='err.fault.sbi.startup.Academics'/>");
    return false;
}
if(Academics.length >1500)
{
	$("#errdisplay").html("<fmt:message key='err.fault.sbi.startup.Academics_char'/>");
    return false;
}

var PermResiAdd=$("#PermResiAdd"+form).val();
if(PermResiAdd == "")
{
	$("#errdisplay").html("<fmt:message key='err.fault.sbi.startup.PermResiAdd'/>");
    return false;
}

showresumes(form);
return true;
}

//validate method ends

$('#configreset').click(function(){
    $('#configform')[0].reset();
});


function ompandrimp(){
var one = 0;
var two = 0;

if(parseInt($("#omp").val()) != null){
one = parseInt($("#omp").val());
}
if(parseInt($("#rimp").val()) != null){
two = parseInt($("#rimp").val());
}
$("#nmp").val(one + two);
if((one + two) > 24)
{
$("#errdisplay").html("<fmt:message key='err.fault.sbi.startup.rimpomp' />");
$("#nmp").val(one);
}else{
$("#errdisplay").html("");}

}


// function OnlyNumericEntry(event){
//     if((event.keyCode < 48 || event.keyCode > 57)) {
//     event.returnValue = false;
// 	}
// }



function navigate(btnId){
	
// 		var currentPage = $("#resume").val();
		var currentPage = ""; 
		var total = $("#total").val();
		var regNum = "<%=regNum%>";
		if(btnId=="first"){
			currentPage = "1";
			
			for(var loop=1;loop<=total;loop++){
				$("#configform"+loop).hide();
			}
			$("#configform"+currentPage).show();
			getData(regNum,currentPage);
			
		}
		if(btnId=="last"){
			currentPage = total;
			
			for(var loop=1;loop<=total;loop++){
				$("#configform"+loop).hide();
			}
			$("#configform"+currentPage).show();
			getData(regNum,currentPage);
			$("#currentPage").val(currentPage);
		}
		
		if(btnId=="prev"){
			currentPage = $("#currentPage").val();
			
			currentPage = parseInt(currentPage) - 1;
			if(parseInt(currentPage)<1)
				{
					currentPage = total;
				}
			for(var loop=1;loop<=total;loop++){
				$("#configform"+loop).hide();
			}
			$("#configform"+currentPage).show();
			getData(regNum,currentPage);
			$("#currentPage").val(currentPage);
		}
		if(btnId=="next"){
			currentPage = $("#currentPage").val();
			
			currentPage = parseInt(currentPage) + 1;
			if(parseInt(currentPage)>total)
				{
					currentPage = "1";
				}
			for(var loop=1;loop<=total;loop++){
				$("#configform"+loop).hide();
			}
			$("#configform"+currentPage).show();
			getData(regNum,currentPage);
			$("#currentPage").val(currentPage);
		}	
		
		$('html, body').animate({
	        scrollTop: $("#content-area").offset().top
	    }, 2000);
}



function showresumes(form){
	
	var  name= $("#Name"+form).val();
	var Email=$("#Email"+form).val();
	var Mnumber=$("#Mnumber"+form).val();
	var Dob=$("#Dob"+form).val();
	var r_address_line_1=$("#r_address_line_1"+form).val();
	var r_address_line_2=$("#r_address_line_2"+form).val();
	var r_address_landmark=$("#r_address_landmark"+form).val();
	var r_address_city=$("#r_address_city"+form).val();
	var r_address_pin=$("#r_address_pin"+form).val();
	var r_address_state=$("#r_address_state"+form).val();
	var perm_address_line_1=$("#perm_address_line_1"+form).val();
	var perm_address_line_2=$("#perm_address_line_2"+form).val();
	var perm_address_landmark=$("#perm_address_landmark"+form).val();
	var perm_address_city=$("#perm_address_city"+form).val();
	var perm_address_pin=$("#perm_address_pin"+form).val();
	var perm_address_state=$("#perm_address_state"+form).val();
	var Pan=$("#Pan"+form).val();
	var AadharNum=$("#AadharNum"+form).val();
	var CarrerAspect=$("#CarrerAspect"+form).val();
	var KeyITSkill=$("#KeyITSkill"+form).val();
	var CertfTra=$("#CertfTra"+form).val();
	var EmpyHistory=$("#EmpyHistory"+form).val();
	var CoreComp=$("#CoreComp"+form).val();
	var Accomplishment=$("#Accomplishment"+form).val();
	var Academics=$("#Academics"+form).val();
	var regNum=$("#regNum").val();
	var resume=form;
	//var resume=form.ip.value;
	
	var total=$("#total").val();
	//var ajaxdata=name+":"+Email+":"+Mnumber+":"+Dob+":"+r_address_line_1+":"+r_address_line_2+":"+r_address_landmark+":"+r_address_city+":"+r_address_pin+":"+r_address_state+":"+perm_address_line_1+":"+perm_address_line_2+":"+perm_address_landmark+":"+perm_address_city+":"+perm_address_pin+":"+perm_address_state+":"+Pan+":"+AadharNum+":"+CarrerAspect+":"+KeyITSkill+":"+CertfTra+":"+EmpyHistory+":"+CoreComp+":"+Accomplishment+":"+Academics+":"+regNum;
	 
		//$('#branchname').addClass('loadinggif');
		
		$.ajax({
			url : "<%=resumeUrl%>",
			type : "post",
// 			contentType: "application/json",
//             dataType: "json",
			data : {
				"name" : name,
				"Email" : Email,
				"Mnumber" : Mnumber,
				"Dob" : Dob,
				"r_address_line_1" : r_address_line_1,
				"r_address_line_2" : r_address_line_2,
				"r_address_landmark" : r_address_landmark,
				"r_address_city" : r_address_city,
				"r_address_pin" : r_address_pin,
				"r_address_state" : r_address_state,
				"perm_address_line_1" : perm_address_line_1,
				"perm_address_line_2" : perm_address_line_2,
				"perm_address_landmark" : perm_address_landmark,
				"perm_address_city" : perm_address_city,
				"perm_address_pin" : perm_address_pin,
				"perm_address_state" : perm_address_state,
				"Pan" : Pan,
				"AadharNum" : AadharNum,
				"CarrerAspect" : CarrerAspect,
				"KeyITSkill" : KeyITSkill,
				"CertfTra" : CertfTra, 
				"EmpyHistory" : EmpyHistory,
				"CoreComp" : CoreComp, 
				"Accomplishment" : Accomplishment,
				"Academics" : Academics,
				"regNum" : regNum, 
				"indexno" : form,
			},
			success : function(content){
				setStatus(regNum,resume);		
			},
		});

	
}

function setStatus(regNum,resume){
	$("#errdisplay").html("");
	var total = "<%=var%>";
	$.ajax({
		url : "<%=setStatus%>",
		type : "post",
		dataType: "json",
		data : {
			"ajaxdata" : regNum,
			"total" : total,
		},
		success : function(data){
			if(data.key=="success"){
				$('#accordion1').hide();
				$('#success').show();
				$("#navigateButtons").hide();
			}
			else{
				
					$("#errdisplay").html("");
					$('#configform'+resume).hide();
					//$('#configform'+resume)[0].reset();
					resume++;
					if(resume>total){
						resume = "1";
					}
					$('#configform'+resume).show();
					getData(regNum,resume);		
					$("#currentPage").val(resume);
			
				
			}
		},
	});

}
$( document ).ready(function() {
	
	$("#configform"+<%=indexNo%>).show();
	$("#currentPage").val(<%=indexNo%>);
	
	getData('<%=regNum%>','<%=indexNo%>');
	$( function() {
	    $( "#accordion" ).accordion({
	    	collapsible: false,
	    	disabled:true
	    	});
	  } );

	
	$("#monetary_value").keyup(function(){
		$("#count_academics").text(" " + (1500 - $(this).val().length));
	});
});


function saveForm(form){
	
	var name= $("#Name"+form).val();
	var Email=$("#Email"+form).val();
	var Mnumber=$("#Mnumber"+form).val();
	var Dob=$("#Dob"+form).val();
	var r_address_line_1=$("#r_address_line_1"+form).val();
	var r_address_line_2=$("#r_address_line_2"+form).val();
	var r_address_landmark=$("#r_address_landmark"+form).val();
	var r_address_city=$("#r_address_city"+form).val();
	var r_address_pin=$("#r_address_pin"+form).val();
	var r_address_state=$("#r_address_state"+form).val();
	var perm_address_line_1=$("#perm_address_line_1"+form).val();
	var perm_address_line_2=$("#perm_address_line_2"+form).val();
	var perm_address_landmark=$("#perm_address_landmark"+form).val();
	var perm_address_city=$("#perm_address_city"+form).val();
	var perm_address_pin=$("#perm_address_pin"+form).val();
	var perm_address_state=$("#perm_address_state"+form).val();
	var Pan=$("#Pan"+form).val();
	var AadharNum=$("#AadharNum"+form).val();
	var CarrerAspect=$("#CarrerAspect"+form).val();
	var KeyITSkill=$("#KeyITSkill"+form).val();
	var CertfTra=$("#CertfTra"+form).val();
	var EmpyHistory=$("#EmpyHistory"+form).val();
	var CoreComp=$("#CoreComp"+form).val();
	var Accomplishment=$("#Accomplishment"+form).val();
	var Academics=$("#Academics"+form).val();
	var regNum=$("#regNum").val();
	
	
	$.ajax({
		url : "<%=saveResumeForm%>",
		type : "post",
		data : {
			"name" : name,
			"Email" : Email,
			"Mnumber" : Mnumber,
			"Dob" : Dob,
			"r_address_line_1" : r_address_line_1,
			"r_address_line_2" : r_address_line_2,
			"r_address_landmark" : r_address_landmark,
			"r_address_city" : r_address_city,
			"r_address_pin" : r_address_pin,
			"r_address_state" : r_address_state,
			"perm_address_line_1" : perm_address_line_1,
			"perm_address_line_2" : perm_address_line_2,
			"perm_address_landmark" : perm_address_landmark,
			"perm_address_city" : perm_address_city,
			"perm_address_pin" : perm_address_pin,
			"perm_address_state" : perm_address_state,
			"Pan" : Pan,
			"AadharNum" : AadharNum,
			"CarrerAspect" : CarrerAspect,
			"KeyITSkill" : KeyITSkill,
			"CertfTra" : CertfTra, 
			"EmpyHistory" : EmpyHistory,
			"CoreComp" : CoreComp, 
			"Accomplishment" : Accomplishment,
			"Academics" : Academics,
			"regNum" : regNum, 
			"indexno" : form,
		},
		success : function(content){
			
			$("#errdisplay").html("");
			//$("#successdisplay").html("Saved Successfully. Your Registration Number is "+regNum);
				alert("Saved Successfully. Your Registration Number is "+regNum);
		
// 			$('html, body').animate({
// 		        scrollTop: $("#content-area").offset().top
// 		    }, 2000);
			
// 			setTimeout(function(){
// 				$("#successdisplay").html("");
// 				}, 5000);
			
		},
	});
	
}


function getData(regnum,indexno){
	
	

	var url = "<%=fetchResumeForm%>";
	;
	$.ajax({
		data : {
			"regnum" : regnum,
			"indexno" : indexno,
		},
		url : url,
		type : "POST",
		dataType: "json",
		success : function(data){
			
			$("#Email"+indexno).val(data.Email);
			$("#Mnumber"+indexno).val(data.Mnumber);
			$("#Dob"+indexno).val(data.Dob);
			$("#r_address_line_1"+indexno).val(data.r_address_line_1);
			$("#r_address_line_2"+indexno).val(data.r_address_line_2);
			$("#r_address_landmark"+indexno).val(data.r_address_landmark);
			$("#r_address_city"+indexno).val(data.r_address_city);
			$("#r_address_pin"+indexno).val(data.r_address_pin);
			$("#r_address_state"+indexno).val(data.perm_address_state);
			$("#perm_address_line_1"+indexno).val(data.perm_address_line_1);
			$("#perm_address_line_2"+indexno).val(data.perm_address_line_2);
			$("#perm_address_landmark"+indexno).val(data.perm_address_landmark);
			$("#perm_address_city"+indexno).val(data.perm_address_city);
			$("#perm_address_pin"+indexno).val(data.perm_address_pin);
			$("#perm_address_state"+indexno).val(data.perm_address_state);
	    
			$("#Pan"+indexno).val(data.Pan);
			$("#AadharNum"+indexno).val(data.AadharNum);
	    	$("#CarrerAspect"+indexno).val(data.CarrerAspect);
	    	$("#CertfTra"+indexno).val(data.CertfTra);
	    	$("#EmpyHistory"+indexno).val(data.EmpyHistory);
	    	$("#CoreComp"+indexno).val(data.CoreComp);
	    	$("#Accomplishment"+indexno).val(data.Accomplishment);
	    	$("#Academics"+indexno).val(data.Academics);
		},
		
	});
	
}

function getCountAcademics(eve){
	var newID = "#count_"+eve.id;
	if ($(eve).val().length > 1500) {
		  $("#"+eve.id).val($("#"+eve.id).val().substring(0,1500));
	  }
	$(newID).text(" " + (1500 - $(eve).val().length));
}

function getCountAccomplishments(eve){
	var newID = "#count_"+eve.id;
	if ($(eve).val().length > 1500) {
		  $("#"+eve.id).val($("#"+eve.id).val().substring(0,1500));
	  }
	$(newID).text(" " + (1500 - $(eve).val().length));
}

function getCountCoreComp(eve){
	var newID = "#count_"+eve.id;
	if ($(eve).val().length > 1500) {
		  $("#"+eve.id).val($("#"+eve.id).val().substring(0,1500));
	  }
	$(newID).text(" " + (1500 - $(eve).val().length));
}

function getCountEmpHistory(eve){
	var newID = "#count_"+eve.id;
	if ($(eve).val().length > 1500) {
		  $("#"+eve.id).val($("#"+eve.id).val().substring(0,1500));
	  }
	$(newID).text(" " + (1500 - $(eve).val().length));
}

function getCountCerts(eve){
	var newID = "#count_"+eve.id;
	if ($(eve).val().length > 1500) {
		  $("#"+eve.id).val($("#"+eve.id).val().substring(0,1500));
	  }
	$(newID).text(" " + (1500 - $(eve).val().length));
}

function getCountKeySkills(eve){
	var newID = "#count_"+eve.id;
	if ($(eve).val().length > 1500) {
		  $("#"+eve.id).val($("#"+eve.id).val().substring(0,1500));
	  }
	$(newID).text(" " + (1500 - $(eve).val().length));
}

function getCountCareerAbs(eve){
	var newID = "#count_"+eve.id;
	if ($(eve).val().length > 1500) {
		  $("#"+eve.id).val($("#"+eve.id).val().substring(0,1500));
	  }
	$(newID).text(" " + (1500 - $(eve).val().length));
}

function checkAddress(eve,form){
	var is_same_address = jQuery("input[name=is_same_address]:checked").val();
	//alert(is_same_address);
	if(is_same_address == "yes"){
		$("#perm_address_line_1"+form).val($("#r_address_line_1"+form).val());
		$("#perm_address_line_2"+form).val($("#r_address_line_2"+form).val());
		$("#perm_address_landmark"+form).val($("#r_address_landmark"+form).val());
		$("#perm_address_city"+form).val($("#r_address_city"+form).val());
		$("#perm_address_pin"+form).val($("#r_address_pin"+form).val());
		$("#perm_address_state"+form).val($("#r_address_state"+form).val());
		
	}else{
		$("#perm_address_line_1"+form).val("");
		$("#perm_address_line_2"+form).val("");
		$("#perm_address_landmark"+form).val("");
		$("#perm_address_city"+form).val("");
		$("#perm_address_pin"+form).val("");
		$("#perm_address_state"+form).val("");
		
	}
}

function OnlyNumericEntry(event){
	var key = event.keyCode || event.which;
    if((key < 48 || key > 57)) {
    	event.preventDefault();
	}
}

function onlyCharacters(id, event) {
	var key = event.keyCode || event.which;
	if ((key > 64 && key < 91)
		|| (key > 96 && key < 123) || key == 32)
	return true;
	else
		event.preventDefault();
}


</script>





<!--Start -->
<div id="content-area">

	<div class="edu-form">

<div class="clearfix" id="header"> 
 			<h2><fmt:message key="lbl.sbi.startup.sbi_heading" /></h2>
 		</div> 
		<hr></hr>
		<div>
			<div id="errdisplay" class="err-msg"></div>
			<div id="successdisplay" class="success-msg"></div>
		</div>
		<input type="hidden" name="currentPage" id="currentPage" value="">
		
		<hr></hr>
		<portlet:actionURL name="SubmitForm" var="SubmitForm" />
		<div id="success" style="display:none;border: 1px solid #e2e2e2;padding: 25px 20px 25px 30px;background: #dff0d8;color: #3c763d;line-height: 25px;">
			
			<label>Your application form has been successfully submitted! Please note the Reference Number for future purpose: <span class="bold_id" style="font-weight:bold;font-size:18px;color:#f00;" >&nbsp;<%=regNum%>
			
			 </span>
			        </label>

			<div class="start_new">
			<a href="<%=downloadpdfURL.toString()%>" target="_blank"><input type="button" value="Download Application Form"> </a>
			</div>
			
			
			<div>
			<br><br>
			<p style="font-weight:bold;color : rgb(60,118,61) !important"> Should you need any further clarification, please write to us at <span> <a href="mailto:startup@sbi.co.in" style="text-decoration:underline">startup@sbi.co.in</a></span></p>
			
			</div>
		</div>
		<div id="accordion1" style="background:none;">
	<% for(int i=1;i <= var; i++){ %>	
	
<form name="a" enctype="multipart/form-data" id="configform<%=i %>" class="configform" onSubmit="" method="post" style="display:none;">

	<input type="hidden" name="resume" id="resume" value="<%=i%>">
	<input type="hidden" name="total" id="total" value="<%=var%>">
	<input type="hidden" name="regNum" id="regNum" value="<%=regNum%>">
 	<input type="hidden" name="name" id="name" value="<%=myarray.get(i-1)%>"> 
			
			
			
			
			
			<div class="edu-form-row">
 			<div class="edu-form-leftcol">
 			
			</div>
			<div class="edu-form-righttcol">				
						<input  type="button" class="saveForm"  onclick="saveForm(<%=i %>)" 
  					value='<fmt:message key="lbl.sbi.startup.save_btn" />'>
				</div>
			</div>
			<div class="clearfix"></div>
			<div class="edu-form-row">
				<div class="edu-form-leftcol">
					<label for="Name">
					<fmt:message key="lbl.sbi.startup.resume_name" /> 
					</label>
					
					<input type="text" name="Name" disabled id="Name<%=i %>" value="<%=myarray.get(i-1)%>">
<%-- 					<label ><%=Name %></label> --%>
				</div>

				<div class="edu-form-righttcol">
					<label for="Email">
						<fmt:message key="lbl.sbi.startup.resume_email" />
						<span class="red-mandate">*</span>
					</label> 
					<input type="text" name="Email" id="Email<%=i %>" value="<%=Email %>" />
				</div>
			</div>
			
		
			

		
			<div class="clearfix"></div>
			
			<div class="edu-form-row">
				<div class="edu-form-leftcol">
					<label for="Mnumber">
					<fmt:message key="lbl.sbi.startup.resume_mob" />
					<span class="red-mandate">*</span>
					</label> 
					<input name="Mnumber" id="Mnumber<%=i %>"
						value="<%=Mnumber%>" maxlength="10" size="10" onkeypress="OnlyNumericEntry(event)">
				</div>

				<div class="edu-form-righttcol">
					<label for="Dob">
						<fmt:message key="lbl.sbi.startup.resume_dob" />
						<span class="red-mandate">*</span>
					</label>						
						<input type="text" class="Dob" name="Dob" id="Dob<%=i %>" size="30"  value="<%=Dob%>"  style=""/>
				</div>
			</div>
			<div class="clearfix"></div>		
			
			<!-- -start current address--- -->
			
			<div class="new_address_outer">
			<p>&nbsp;</p>
			<label for="Sanction"> 
					<fmt:message	key="lbl.sbi.startup.resume_current_residential" />
					<span class="red-mandate">*</span>
				</label>				
				<span class="border_dotted"></span>
			<div class="edu-form-row">
				<div class="edu-form-leftcol">
					<label for="r_address_line_1<%=i %>"> 
					 <fmt:message key="lbl.sbi.startup.address_line_1" />
					 </label> <input  name="r_address_line_1<%=i %>"
						id="r_address_line_1<%=i %>" value="<%=r_address_line_1%>" maxlength="<fmt:message key="lbl.sbi.startup.name.max_chars"/>">
				</div>
				<div class="edu-form-righttcol">
					<label for="r_address_line_2<%=i %>">  
					<fmt:message key="lbl.sbi.startup.address_line_2" /></label> 
					<input  name="r_address_line_2<%=i %>" id="r_address_line_2<%=i %>" value="<%=r_address_line_2%>" maxlength="<fmt:message key="lbl.sbi.startup.name.max_chars"/>">
				</div>
			</div>			
			<p>&nbsp;</p>
			<div class="clearfix"></div>
			<div class="edu-form-row">
				<div class="edu-form-leftcol">
					<label for="r_address_landmark<%=i %>">  <fmt:message
							key="lbl.sbi.startup.address_landmark" /></label> <input  name="r_address_landmark<%=i %>"
						id="r_address_landmark<%=i %>" value="<%=r_address_landmark%>" maxlength="<fmt:message key="lbl.sbi.startup.name.max_chars"/>">
				</div>
				<div class="edu-form-righttcol">
					<label for="r_address_city<%=i %>">  <fmt:message
							key="lbl.sbi.startup.address_city" /></label> <input  name="r_address_city<%=i %>"
						id="r_address_city<%=i %>" value="<%=r_address_city%>" onkeypress="onlyCharacters(this,event)">
				</div>				
			</div>			
			<p>&nbsp;</p>
			<div class="clearfix"></div>
			<div class="edu-form-row">
				<div class="edu-form-leftcol">
					<label for="r_address_pin<%=i %>">  <fmt:message
							key="lbl.sbi.startup.address_pin" /></label> <input  name="r_address_pin<%=i %>"
						id="r_address_pin<%=i %>" value="<%=r_address_pin%>"  onkeypress="OnlyNumericEntry(event)" maxlength="6">
				</div>
				<div class="edu-form-righttcol">
					<label for="r_address_state<%=i %>">  <fmt:message
							key="lbl.sbi.startup.address_state" /></label> 
<%-- 						<input  name="r_address_state<%=i %>" --%>
<%-- 						id="r_address_state<%=i %>" value="<%=r_address_state%>"> --%>
		<select onchange="selectstate()" name="r_address_state" id="r_address_state<%=i %>" style="width: 235px; ">
		<option value=""> --please select-- </option>
					<%		
					List<AssetCategory> clists = null;
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
								 clists = AssetCategoryLocalServiceUtil.getChildCategories(ac.getCategoryId());
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
			<div class="clearfix"></div>
			</div>
			
			<!-- -end current address--- -->
			
			<!-- -START Permanent address--- -->
			
			<div class="new_address_outer">
			<p>&nbsp;</p>
			<label for="Sanction"> 
					<span style="float:left;"><fmt:message	key="lbl.sbi.startup.resume_permanent_residential" /></span>
					
					<span class="is_chk_pr_add" style="margin:0px 5px 0px 30px;float:left; padding-left:90px;">
					 <input type="checkbox" name="is_same_address"
					 id="is_same_address" onclick="checkAddress(this,<%=i %>)" value="yes"
					  style="border:none;box-shadow:none;width:13px;margin: 0px 0px 0px 0px;float:left;">
					 </span>
					 <span style="float:left;"><fmt:message
							key="lbl.sbi.startup.address_same" /></span>
				</label>				
				<span class="border_dotted"></span>
			<div class="edu-form-row">
				<div class="edu-form-leftcol">
					<label for="perm_address_line_1<%=i %>">  <fmt:message
							key="lbl.sbi.startup.perm_address_line_1" /></label> <input  name="perm_address_line_1<%=i %>"
						id="perm_address_line_1<%=i %>" value="<%=perm_address_line_1%>" maxlength="<fmt:message key="lbl.sbi.startup.name.max_chars"/>">
				</div>
				<div class="edu-form-righttcol">
					<label for="perm_address_line_2<%=i %>">  <fmt:message
							key="lbl.sbi.startup.perm_address_line_2" /></label> <input  name="perm_address_line_2<%=i %>"
						id="perm_address_line_2<%=i %>" value="<%=perm_address_line_2%>" maxlength="<fmt:message key="lbl.sbi.startup.name.max_chars"/>">
				</div>
			</div>			
			<p>&nbsp;</p>
			<div class="clearfix"></div>
			<div class="edu-form-row">
				<div class="edu-form-leftcol">
					<label for="perm_address_landmark<%=i %>">  <fmt:message
							key="lbl.sbi.startup.perm_address_landmark" /></label> <input  name="perm_address_landmark<%=i %>"
						id="perm_address_landmark<%=i %>" value="<%=perm_address_landmark%>" maxlength="<fmt:message key="lbl.sbi.startup.name.max_chars"/>">
				</div>
				<div class="edu-form-righttcol">
					<label for="perm_address_city<%=i %>">  <fmt:message
							key="lbl.sbi.startup.perm_address_city" /></label> <input  name="perm_address_city<%=i %>"
						id="perm_address_city<%=i %>" value="<%=perm_address_city%>" onkeypress="onlyCharacters(this,event)">
				</div>				
			</div>			
			<p>&nbsp;</p>
			<div class="clearfix"></div>
			<div class="edu-form-row">
				<div class="edu-form-leftcol">
					<label for="perm_address_pin<%=i %>">  <fmt:message
							key="lbl.sbi.startup.perm_address_pin" /></label> <input  name="perm_address_pin<%=i %>"
						id="perm_address_pin<%=i %>" value="<%=perm_address_pin%>" onkeypress="OnlyNumericEntry(event)" maxlength="6">
				</div>
				<div class="edu-form-righttcol">
					<label for="perm_address_state<%=i %>">  <fmt:message
							key="lbl.sbi.startup.perm_address_state" /></label> 
		<select onchange="selectstate()" name="perm_address_state" id="perm_address_state<%=i %>" style="width: 235px; ">
		<option value="0"> --please select-- </option>
				<% for(AssetCategory acs : clists){									
					%><option value="<%=acs.getName() %>"><%=acs.getName() %></option><%
				}%>
				<%-- 	<label for="address_state">  <fmt:message
							key="lbl.sbi.startup.address_state" /></label> <input  name="address_state"
						id="address_state" value="<%=address_state%>"> --%>
			</select>	
				</div>
			</div>			
			<p>&nbsp;</p>
			<div class="clearfix"></div>
			</div>
			
			<!-- -END Permanent address--- -->
			
		
			<div class="edu-form-row">
				<div class="edu-form-leftcol">
					<label for="Pan"><fmt:message
							key="lbl.sbi.startup.resume_pan" /> <span
						class="red-mandate">*</span>
					</label> 
					<input name="Pan" id="Pan<%=i %>" value="<%=Pan%>" maxlength="10" size="10">
				</div>

				<div class="edu-form-righttcol">
					<label for="AadharNum">
						<fmt:message key="lbl.sbi.startup.resume_aadhar" />
					</label>
						<input type="text" name="AadharNum" id="AadharNum<%=i %>" value="<%=AadharNum %>" maxlength="12"  onkeypress="OnlyNumericEntry(event)" />
				</div>
			</div>
			<div class="clearfix"></div>
			<p>&nbsp;</p>
			<div class="edu-form-row">
				<div class="edu-form-leftcol width100perc">
					<label for="CarrerAspect"><fmt:message
							key="lbl.sbi.startup.resume_career_abstract" /> 
					</label>
					<textarea name="CarrerAspect" id="CarrerAspect<%=i %>" rows="6" style="" onkeyup="getCountCareerAbs(this)"><%=CarrerAspect %></textarea>
					<span class="fltr_text"><fmt:message key="lbl.sbi.startup.characters_left" /> <lable id="count_CarrerAspect<%=i%>">1500</lable></span> 					
				</div>	
			</div>
			
			<div class="clearfix"></div>
			<p>&nbsp;</p>						
			<div class="edu-form-row">
				<div class="edu-form-leftcol width100perc">
					<label for="KeyITSkill">
						<fmt:message key="lbl.sbi.startup.resume_keyskills" />
					</label>
						<textarea name="KeyITSkill" id="KeyITSkill<%=i %>" rows="6" style="" onkeyup="getCountKeySkills(this)"><%=KeyITSkill %></textarea>
						<span class="fltr_text"><fmt:message key="lbl.sbi.startup.characters_left" /> <lable id="count_KeyITSkill<%=i%>">1500</lable></span>
				</div>
			</div>
			<div class="clearfix"></div>
			<p>&nbsp;</p>
			<div class="edu-form-row">
				<div class="edu-form-leftcol width100perc">
					<label for="CertfTra"><fmt:message
							key="lbl.sbi.startup.resume_trainings" />
					</label> 
					<textarea name="CertfTra" id="CertfTra<%=i %>" rows="6" style="" onkeyup="getCountCerts(this)"><%=CertfTra %></textarea>
					<span class="fltr_text"><fmt:message key="lbl.sbi.startup.characters_left" /> <lable id="count_CertfTra<%=i%>">1500</lable></span>
				</div>
			</div>				
			<div class="clearfix"></div>	
			<p>&nbsp;</p>				
			<div class="edu-form-row">
				<div class="edu-form-leftcol width100perc">
					<label for="EmpyHistory">
						<fmt:message key="lbl.sbi.startup.resume_emphistory" />
					</label>
						<textarea name="EmpyHistory" id="EmpyHistory<%=i %>" rows="6" style="" onkeyup="getCountEmpHistory(this)"><%=EmpyHistory %></textarea>
						<span class="fltr_text"><fmt:message key="lbl.sbi.startup.characters_left" /> <lable id="count_EmpyHistory<%=i%>">1500</lable></span>
				</div>
			</div>
			<div class="clearfix"></div>			
			<p>&nbsp;</p>
			<div class="edu-form-row">
				<div class="edu-form-leftcol width100perc">
					<label for="CoreComp"><fmt:message
							key="lbl.sbi.startup.resume_core" /> <span
						class="red-mandate">*</span>
					</label> 
					<textarea name="CoreComp" id="CoreComp<%=i %>" rows="6" style="" onkeyup="getCountCoreComp(this)"><%=CoreComp %></textarea>
					<span class="fltr_text"><fmt:message key="lbl.sbi.startup.characters_left" /> <lable id="count_CoreComp<%=i%>">1500</lable></span>
				</div>
			</div>			
			<div class="clearfix"></div>
			<p>&nbsp;</p>						
			<div class="edu-form-row">
				<div class="edu-form-leftcol width100perc">
					<label for="Accomplishment">
						<fmt:message key="lbl.sbi.startup.resume_accomplishments" />
					</label>
						<textarea name="Accomplishment" id="Accomplishment<%=i %>" rows="6" style="" onkeyup="getCountAccomplishments(this)"><%=Accomplishment %></textarea>
						<span class="fltr_text"><fmt:message key="lbl.sbi.startup.characters_left" /> <lable id="count_Accomplishment<%=i%>">1500</lable></span>
				</div>
			</div>
			
			<div class="clearfix"></div>			
		<p>&nbsp;</p>
			<div class="edu-form-row">
				<div class="edu-form-leftcol width100perc">
					<label for="Academics"><fmt:message
							key="lbl.sbi.startup.resume_academics" /> <span
						class="red-mandate">*</span>
					</label> 					
					<textarea name="Academics" id="Academics<%=i %>" rows="6" style="" onkeyup="getCountAcademics(this)"><%=Academics%></textarea>
					<span class="fltr_text"><fmt:message key="lbl.sbi.startup.characters_left" /> <lable id="count_Academics<%=i%>">1500</lable></span>
				</div>				
			</div>
			
			<!-- END Interest Subsidy related query  -->

		<div class="clearfix"></div>
			<p>&nbsp;</p>
			<div class="edu-form-row">
 			<div class="edu-form-leftcol">
				<div style="width: 100%;" >
	<%--  			<input  type="submit"  onclick="return validate()" style="width: 165px;" value='<fmt:message key="bttn.sbi.eduloan.submitquery" />'  ></div> --%>
	 			<input  type="button"  onclick="return validate(<%=i %>)"  value='<fmt:message key="bttn.sbi.eduloan.submitquery" />'  >
	 			</div> 
			
			</div>
			<div class="edu-form-righttcol">				
						<input  type="button" class="saveForm"  onclick="saveForm(<%=i %>)"
  					value='<fmt:message key="lbl.sbi.startup.save_btn" />'>
				</div>
			</div>
			<p>&nbsp;</p>	

		</form>
		<%} 
		
		%>
		</div>
		<div class="clearfix"
		></div>
		
		
		<div class="row" id="navigateButtons">
		<%if(var > 1){ %>
			<div class="edu-form-row">
 			<div class="edu-form-leftcol">
				<div style="width: 100%;" >
	 				<a href="javascript:void(0);" onclick="navigate('prev')">
						 <img src="<%=request.getContextPath()%>/html/images/prev_btn.png" width="25" height="25" border="1" >
					</a>
	 			</div> 
			</div>
			<div  style="float:right;width: 41px;">				
						<a href="javascript:void(0);" onclick="navigate('next')">
						 <img src="<%=request.getContextPath()%>/html/images/next_btn.png" width="25" height="25" border="1" >
					</a>
				</div>
			</div>
		
			<div class="clearfix"></div>
		<%} %>
		</div>
			
		
		
		
	</div>
	
	
</div>

