<%@page import="com.liferay.portal.kernel.dao.orm.Order"%>
<%@page import="com.liferay.portal.kernel.dao.orm.OrderFactoryUtil"%>
<%@page import="java.util.Comparator"%>
<%@page import="java.util.Collections"%>
<%@page import="javax.portlet.PortletSession"%>
<%@page import="javax.xml.bind.ParseConversionEvent"%>
<%@page import="com.sbi.StartUp.model.impl.SbiStartUpModelImpl"%>
<%@page import="com.sbi.StartUp.StartUp"%>
<%@page import="com.sbi.StartUp.service.SbiStartUpLocalServiceUtil"%>
<%@page import="com.sbi.StartUp.service.ResumeDtlsLocalServiceUtil"%>
<%@page import="com.sbi.StartUp.model.SbiStartUp"%>
<%@page import="com.sbi.StartUp.model.ResumeDtls"%>
<%@page import="com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Calendar"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.Criterion"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQuery"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portlet.asset.service.AssetCategoryPropertyLocalServiceUtil"%>
<%@page import="com.liferay.portlet.asset.model.AssetCategoryProperty"%>
<%@page import="com.liferay.portlet.documentlibrary.model.DLFileEntry"%>
<%@page import="com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil"%>
 <%@page import="java.text.DateFormat"%>
 <%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.liferay.portlet.asset.model.AssetVocabulary"%>
<%@page import="com.liferay.portlet.asset.model.AssetCategory"%>
<%@page import="com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.OrderByComparator"%>
<%@page import="com.liferay.util.portlet.PortletProps"%>
<%@page import="com.liferay.portlet.asset.service.AssetVocabularyLocalServiceUtil"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="javax.portlet.PortletURL" %>
<%@ page import="javax.portlet.ResourceURL" %>
<%@ page import="javax.portlet.WindowState" %>
<%@page	import="com.liferay.portal.security.permission.PermissionChecker"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<portlet:resourceURL var="updateStatusAjax" id="updateStatusAjax"/>
<portlet:resourceURL var="statusFilterAjax" id="statusFilterAjax"/>
<portlet:resourceURL var="adminDownloadpdfURL" id="adminDownloadpdfURL">

</portlet:resourceURL>

<portlet:defineObjects />





 <link rel="stylesheet"
	href="<%=request.getContextPath()%>/custom/jquery-ui-1.10.3.custom.css">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/custom/css/admin.css">
	 <link rel="stylesheet"
	href="<%=request.getContextPath()%>/custom/css/jquery.dataTables.css">
<script src="<%=request.getContextPath()%>/custom/jquery-1.9.1.min.js"></script>
<script src="<%=renderRequest.getContextPath()%>/custom/js/jquery.dataTables.js"></script>

<script src="<%=request.getContextPath()%>/custom/jquery-ui.js"></script>

<script src="<%=request.getContextPath()%>/custom/jquery.ui.widget.js"></script>
<script
	src="<%=request.getContextPath()%>/custom/jquery.ui.datepicker.js"></script>
	<script
	src="<%=request.getContextPath()%>/custom/js/admin.js"></script>
<fmt:setBundle basename="portlet"/>


<portlet:actionURL var="searchURL" name="searchURL">
    <portlet:param name="jspPage" value="/html/startup/view.jsp" />
</portlet:actionURL>

<div id="content-area1">

 <div class="clearfix" id="header"> 
 			<h2><fmt:message key="lbl.sbi.startup.sbi_heading" /></h2>
 		</div> 
	<hr></hr>


<%
Order defaultOrder = OrderFactoryUtil.desc("createDate");
	DynamicQuery querySbiStartUp = DynamicQueryFactoryUtil
			.forClass(SbiStartUp.class);
	Criterion criterion = null;
	criterion=RestrictionsFactoryUtil.ne("status","Initiated");
	querySbiStartUp.add(criterion);
	querySbiStartUp.addOrder(defaultOrder);
	List<SbiStartUp> list = null;
	
	try {
		list = (List)SbiStartUpLocalServiceUtil.dynamicQuery(querySbiStartUp);
	
	} catch (Exception ex) {
		ex.printStackTrace();
	}

	
	
%>

<portlet:resourceURL var="search" id="search"/>
<portlet:resourceURL var="searchTxt" id="searchTxt"/>
<portlet:resourceURL var="reset" id="reset"/>
<script>

$( document ).ready(function() {
	 $('#userTable').DataTable({
		"aLengthMenu": [[5, 10, 15,30,50,100,-1], [5, 10, 15,30,50,100, "All"]],
       "iDisplayLength": 5,
       bProcessing  : true,
       sProcessing  : true,
       sPaginationType : 'full_numbers',
       oLanguage: {
           oPaginate: {
               sPrevious: '<img style="width:25px; height:25px;margin:10px 10px -8px 0px" src="<%=request.getContextPath()%>/custom/images/prev.png"></img>',
               sNext: '<img style="width:25px; height:25px;margin:10px 10px -8px 0px" src="<%=request.getContextPath()%>/custom/images/next.png"></img>'
           }
       }
       
	});
	
  });

function updateStatus(selectedId,regnum){
	if(confirm("Are you sure you want to Update this?")){
		var value      = $('#'+selectedId+' option:selected').val();
		$.ajax({
	    	url : "<%=response.encodeURL(updateStatusAjax.toString())%>",
	    	type : "post",
	    	data : {"regnum" :regnum,"status" : value},
	    	success : function(content){
	    		window.location.reload();
	    	},
	    });
    }
    else{
        return false;
    }
	
	
}

function statusFilter(selectedId){
	var value      = $('#'+selectedId+' option:selected').val();
	if(value != "0"){
	if(confirm("Click ok to fetch details")){
		
		 $.post("<%=response.encodeURL(statusFilterAjax.toString())%>",
				    {
				        status: value,
				      
				    },
				    function(data){
				    	
				       $("#searchHtml").html("");
				       $("#searchHtml").html(data);
				    });
		
    }
    else{
        return false;
    }
	
	}
}


function search(){
	
	var value      = $('#searchStatus option:selected').val();
	var fromDate = $('#fromDate').val();
	var toDate = $('#toDate').val();
	
	console.log("calues ... "+value + fromDate + toDate);
	if(value=="0" && fromDate=="" && toDate==""){
		$("#errdisplay").html("<fmt:message key='err.fault.sbi.startup.searchcriteriadate' />");
		return false;
	}
	if(fromDate!="" && toDate==""){
		$("#errdisplay").html("<fmt:message key='err.fault.sbi.startup.todateerror' />");
		   return false;
	}
	else if(fromDate=="" && toDate!=""){
		$("#errdisplay").html("<fmt:message key='err.fault.sbi.startup.fromdateerror' />");
		   return false;
	}
	else{
		var startDate = new Date(fromDate);
		var endDate = new Date(toDate);
		if(value == "0"){
			value = "";
		}
		if (startDate > endDate){
				$("#errdisplay").html("<fmt:message key='err.fault.sbi.startup.datediff' />");
			   return false;
			}
		else{
			$("#errdisplay").html("");
			 $.post("<%=response.encodeURL(search.toString())%>",
					    {
					        status: value,
					        fromDate: fromDate,
					        toDate: toDate
					    },
					    function(data){
					    	
					       $("#searchHtml").html("");
					       $("#searchHtml").html(data);
					    });
		}
	}
	
}

function resetSearch(){
	
	$("#searchStatus").prop('selectedIndex', 0);
	$('#fromDate').val("");
	$('#toDate').val("");	
	
	$("#errdisplay").html("");
	 $.post("<%=response.encodeURL(reset.toString())%>",
			    {
			        type: "reset"
			        
			    },
			    function(data){
			    	
			       $("#searchHtml").html("");
			       $("#searchHtml").html(data);
			    });
	
}


</script>

<div>
<div id="errdisplay" class="err-msg"></div>
<%-- <form name="<portlet:namespace/>search" action="<%=searchURL.toString()%>" method="post" > --%>
				
				<span class="aligndate">
				<label for="From Date">
						<fmt:message key="lbl.sbi.startup.fromDate" />
				</label> 
				<input type="text" name="fromDate" id="fromDate" size="26" 
				readonly="readonly" />
				</span>
				
				<span class="aligntodate">
				<label for="To Date ">
						<fmt:message key="lbl.sbi.startup.toDate" />
				</label> 
				<input type="text" name="toDate" id="toDate" size="26" 
				readonly="readonly"   />
				</span>

				
				<span class="aligntodate">
					<label for="Status"><fmt:message key="lbl.sbi.startup.admin.status" /></label> 	
<!-- 				 <select name="searchStatus" id="searchStatus" onchange="statusFilter(this.id)"> -->
				</span>
				 <select name="searchStatus" id="searchStatus">  
 						<option value="0" id="0">--please select--  
 						 </option>  

 						  <option value="<fmt:message key='lbl.sbi.startup.status_applied'/>"  
  						  id="1"><fmt:message key='lbl.sbi.startup.status_applied'/>  
 						 </option> 
  						 <option value="<fmt:message key='lbl.sbi.startup.status_stageone'/>"  
 						  id="2"><fmt:message key='lbl.sbi.startup.status_stageone'/> 
 						 </option>  
 					 <option value="<fmt:message key='lbl.sbi.startup.status_stagetwo'/>"   
  						 id="3"><fmt:message key='lbl.sbi.startup.status_stagetwo'/>  
 						 </option>  
 						 <option value="<fmt:message key='lbl.sbi.startup.status_approved'/>"  
 						  id="4"><fmt:message key='lbl.sbi.startup.status_approved'/>  
 						 </option>  
 						 <option value="<fmt:message key='lbl.sbi.startup.status_rejected'/>"  
  						  id="5"><fmt:message key='lbl.sbi.startup.status_rejected'/>  
  						 </option> 

  				</select>  
  				<span class="start_new">
				<input type="button" value="Search" onclick="search()" class="adminsearch">
				<input type="button" value="Clear" onclick="resetSearch()">
				</span>
<!-- 				</form> -->
<br>
<br>
</div>




<div class="data_details_main" id="searchHtml">
<table id="userTable" class="display table adminsear_mar" cellspacing="0" width="100%">
 <thead>
            <tr>
                <th><fmt:message key='lbl.sbi.startup.admin.srno'/></th>
                <th><fmt:message key='lbl.sbi.startup.admin.doa'/></th>
                <th><fmt:message key='lbl.sbi.startup.admin.refnum'/></th>
                <th><fmt:message key='lbl.sbi.startup.admin.regname'/></th>
                <th><fmt:message key='lbl.sbi.startup.admin.cwu'/></th>
                <th><fmt:message key='lbl.sbi.startup.admin.appstatus'/></th>
                <th><fmt:message key='lbl.sbi.startup.admin.approvereject'/></th>
            </tr>
 </thead>
<tbody>


 <%int i = 1;for(SbiStartUp curUser:list){ %>
  <tr>
 
                <td><%=i%></td>
                <%
                DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
					String	s = format.format(curUser.getCreateDate());	
                %>
                <td><%=s%></td>
                 
<%--                 <td class="regPdf" style="cursor:pointer; text-decoration:underline; color:#06C;"><a onclick="showPdf(<%=curUser.getRegnum()%>)" href="javascript:void(0)" target="_blank"><%=curUser.getRegnum()%></a></td> --%>
<%--                 <td class="regPdf" style="cursor:pointer; text-decoration:underline; color:#06C;"><a href="#" id="<%=curUser.getRegnum()%>" onclick="showPdf(<%=curUser.getRegnum()%>)" target="_blank"><%=curUser.getRegnum()%></a></td> --%>
                 <td class="regPdf" style="cursor:pointer; text-decoration:underline; color:#06C;"><a href="<%=adminDownloadpdfURL.toString() %>&regnum=<%=curUser.getRegnum()%>" id="<%=curUser.getRegnum()%>" target="_blank"><%=curUser.getRegnum()%></a></td>
                 <td><%=curUser.getRegistered_name()%></td>
                 <td><a href="<%=curUser.getCorporate_website()%>" target="_blank"><%=curUser.getCorporate_website()%></a></td>
                 <td><%=curUser.getStatus()%></td>
                 <td id="changeStatus_<%=curUser.getRegnum()%>">
                 
                 <select name="Change Status" class="change" id="changeStatus_<%=curUser.getRegnum()%>" onchange="updateStatus(this.id,<%=curUser.getRegnum()%>)">
						 <option value="<%=curUser.getStatus()%>" id="0"><%=curUser.getStatus()%>
						 </option>
						 <%if(!curUser.getStatus().equals("Applied")){ %>
						  <option value="<fmt:message key='lbl.sbi.startup.status_applied'/>"
						  id="1"><fmt:message key='lbl.sbi.startup.status_applied'/>
						 </option>
						 <%} %>
						 <%if(!curUser.getStatus().equals("1st Stage Approved")){ %>
						 <option value="<fmt:message key='lbl.sbi.startup.status_stageone'/>"
						  id="2"><fmt:message key='lbl.sbi.startup.status_stageone'/>
						 </option>
						 <%} %>
						 <%if(!curUser.getStatus().equals("2nd Stage Approved")){ %>
						 <option value="<fmt:message key='lbl.sbi.startup.status_stagetwo'/>" 
						 id="3"><fmt:message key='lbl.sbi.startup.status_stagetwo'/>
						 </option>
						 <%} %>
						 <%if(!curUser.getStatus().equals("Approved")){ %>
						 <option value="<fmt:message key='lbl.sbi.startup.status_approved'/>"
						  id="4"><fmt:message key='lbl.sbi.startup.status_approved'/>
						 </option>
						 <%} %>
						 <%if(!curUser.getStatus().equals("Rejected")){ %>
						 <option value="<fmt:message key='lbl.sbi.startup.status_rejected'/>"
						  id="5"><fmt:message key='lbl.sbi.startup.status_rejected'/>
						 </option>
						 <%} %>

					</select>
                 
                 </td>
            </tr>
          <%i++;} %>

</tbody>
</table>



</div><!-- details END---->

</div>