<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.dao.orm.Criterion"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQuery"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@page import="com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil"%>
<%@page import="com.sbi.StartUp.service.SbiStartUpLocalServiceUtil"%>
<%@page import="com.sbi.StartUp.service.ResumeDtlsLocalServiceUtil"%>
<%@page import="com.sbi.StartUp.model.SbiStartUp"%>
<%@page import="com.sbi.StartUp.model.ResumeDtls"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>

	<link rel="stylesheet" href="<%=request.getContextPath()%>/custom/jquery-ui-1.10.3.custom.css">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/custom/css/style.css">
	<script src="<%=request.getContextPath()%>/custom/jquery-1.9.1.min.js"></script>
	<script src="<%=request.getContextPath()%>/custom/jquery-ui.js"></script>
	<script src="<%=request.getContextPath()%>/custom/jquery.ui.widget.js"></script>
	<script src="<%=request.getContextPath()%>/custom/jquery.ui.datepicker.js"></script>
	<fmt:setBundle basename="portlet"/>


<portlet:defineObjects />

<portlet:resourceURL var="UserQueryURL"  id="UserQueryURL" />
<%
String errtext = "";
if (request.getParameter("errtext") != null) {
errtext = request.getParameter("errtext");
}
%>

<script type="text/javascript">
$( document ).ready(function() {
$('#refreshCaptchaActivity').hide();
});

$('#configreset').click(function(){
    $('#configform')[0].reset();
});

function validate(){
	
	var regNumq= $("#reg_numq").val();
	if(regNumq == "")
	{
		$("#errdisplay").html("<fmt:message key='err.fault.sbi.startup.status_reg_num' />");
	   return false;
	}	
	UserQuery();
	return true;
}
function goBack(){
	$('.aui-form')[0].reset();
	$('.aui-form').show();
	$('#success').hide();
    

}
function UserQuery() {
	var regNum=$("#reg_numq").val();
	var captcha=$("#<portlet:namespace/>captchaText").val();
	
$.ajax({
	url : "<%=UserQueryURL%>",
	type : "post",
	data : {
		"ajaxdata" : regNum,
		"captcha" : captcha,},
	success : function(content){
	
	if(content == "Fail"){
		$("#errdisplay").html("<fmt:message key='err.fault.sbi.eduloan.captcha' />");
		}else if(content == "Invalid"){
			$("#errdisplay").html("<fmt:message key='err.fault.sbi.startup.enquiry_error' />");
		}else{
			$('.aui-form').hide();
			$("#errdisplay").html("");
			$('#success').html("<label>Your application status is <span class='bold_id' style='font-weight:bold;font-size:18px;color:#f00;' >&nbsp;"+content+"</span></label> </br><input type='button' name='goBack' value='Back' onclick='goBack();'/> <div><p><p style='font-weight:bold;color : rgb(60,118,61) !important;width:100%;float:left;margin-top: 5px; '> Should you need any further clarification, please write to us at <span>   <a href=\"mailto:startup@sbi.co.in\" style='text-decoration:underline'>startup@sbi.co.in</a> </span></p></p></div>");
			$('#success').show();	
		}
	},
	
});
}

</script>

 <portlet:actionURL name="userQuery" var="userQuery" /> 

<!--Start -->
<div id="content_area">
<div id="errdisplay" class="err-msg"><%=errtext%></div>
<div id="success" class="row" style="display:none;padding: 25px 20px 25px 30px;color: #3c763d;line-height: 25px;">
	<input type="button" name="goBack" value="Back" onclick="goBack();"/> 
		</div>

<aui:form class="queryForm" name="<portlet:namespace/>a"   id="configform" action="" onSubmit="" method="post" >
	<div class="row">
		<h2 class="start">Status Enquiry</h2>
		<span class="fields"><sup>*</sup>Required Fields</span>
	</div>
	
	
	<div class="row">
		<label>Enter your reference number for your status <sup>*</sup></label>
		<input type="text" id="reg_numq" name="reg_numq" value="" >
	</div>
		
	<div class="row" style="position:relative">
		<label>Please enter the text as shown below <sup>*</sup></label>
		<portlet:resourceURL var="captchaURL" id="captchaURL" />
		<liferay-ui:captcha url="<%=captchaURL%>" /> 
		<img id="refreshCaptchaActivity1" 
 						src="<%=request.getContextPath()%>/html/images/refresh.png"> 
<!-- 		<input type="text" name="" value=""/> <span class="captcha"><img src="images/captcha.jpg" alt="captcha" id="captcha"/></span> <span> <a href="#" title="refresh"><img src="images/refresh.png" alt="refresh"/></a></span> -->
	</div>
		
	<div class="row">
		<input  type="button" onclick="validate()" value="<fmt:message key='bttn.sbi.eduloan.submitUserQuery' />"  >
	</div>

	<div id="status_banner">&nbsp;</div>
	
	</aui:form>  
</div>

<script>
jQuery("#refreshCaptchaActivity1").click(function()
  {
 
 jQuery(".captcha").attr("src", jQuery(".captcha").attr("src")+"&force=" + new Date().getMilliseconds());
 return false;
  });
</script>


 
