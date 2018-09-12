
<%@page import="com.liferay.portal.kernel.dao.orm.Order"%>
<%@page import="com.liferay.portal.kernel.dao.orm.OrderFactoryUtil"%>
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
<%@page import="java.text.*"%>
<%@page import="com.liferay.portlet.asset.service.AssetCategoryPropertyLocalServiceUtil"%>
<%@page import="com.liferay.portlet.asset.model.AssetCategoryProperty"%>
<%@page import="com.liferay.portlet.documentlibrary.model.DLFileEntry"%>
<%@page import="com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil"%>
 
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
<portlet:defineObjects/>

<portlet:resourceURL var="updateStatusAjax" id="updateStatusAjax"/>
<portlet:resourceURL var="statusFilterAjax" id="statusFilterAjax"/>
<portlet:resourceURL var="adminDownloadpdfURL" id="adminDownloadpdfURL">

</portlet:resourceURL>

	<link rel="stylesheet" href="<%=request.getContextPath()%>/custom/css/searchresult.css">
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

 
 </script>
<%
	String qry = request.getParameter("type");
	List<SbiStartUp> list = null;
	Order defaultOrder = OrderFactoryUtil.desc("createDate");
 	if(qry.equals("search")){
		
		
		String status = "";
		String fromDate="";
		String toDate="";
		
		if (request.getParameter("fromDate") != null) {
			fromDate = (String) request.getParameter("fromDate");

		}
		if (request.getParameter("toDate") != null) {
			toDate = (String) request.getParameter("toDate");

		}
 		if (request.getParameter("status") != null) {
 			status = (String) request.getParameter("status");

 		}
 		
	  DynamicQuery querySbiStartUp = DynamicQueryFactoryUtil
			.forClass(SbiStartUp.class);
	  
	  Criterion criterion = null;
	  if(!status.equalsIgnoreCase("")){
	 		criterion=RestrictionsFactoryUtil.eq("status",status);
	 	}
	 	else{
	 		criterion=RestrictionsFactoryUtil.ne("status", "Initiated");
	 	}
//	  criterion=RestrictionsFactoryUtil.ne("status", "Initiated");
	 if(!fromDate.equalsIgnoreCase("") && !toDate.equalsIgnoreCase(""))
	 {
		
		 DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		 Date from = format.parse(fromDate);
		 Date to = format.parse(toDate);
		  Calendar cal1 = Calendar.getInstance();
		
		  Calendar cal2 = Calendar.getInstance();
		  cal1.setTime(from);
		  cal2.setTime(to);
		  cal2.add(Calendar.DATE, 1);
		  
		 Criterion crit2 = RestrictionsFactoryUtil.between("createDate", cal1.getTime(), cal2.getTime());
		querySbiStartUp.add(crit2);
	 }
		
	querySbiStartUp.add(criterion);
	querySbiStartUp.addOrder(defaultOrder);
	
	try {
		list = (List)SbiStartUpLocalServiceUtil.dynamicQuery(querySbiStartUp);
		//list = listtmp;
		
	} catch (Exception ex) {
		ex.printStackTrace();
	}
 	}
	
 	else if(qry.equals("reset")){
 		DynamicQuery querySbiStartUp = DynamicQueryFactoryUtil
 				.forClass(SbiStartUp.class);
 		Criterion criterion = null;
 		criterion=RestrictionsFactoryUtil.ne("status","Initiated");
 		querySbiStartUp.add(criterion);
 		querySbiStartUp.addOrder(defaultOrder);
 		try {
 			list = (List)SbiStartUpLocalServiceUtil.dynamicQuery(querySbiStartUp);
 			
 		} catch (Exception ex) {
 			ex.printStackTrace();
 		}

// 		String status = "";
// 		if (request.getParameter("status") != null) {
// 			status = (String) request.getParameter("status");

// 		}
			
		
		
		
// 	  DynamicQuery querySbiStartUp1 = DynamicQueryFactoryUtil
// 			.forClass(SbiStartUp.class);
	
	
    

// 	Criterion criterion = null;
// 	if(!status.equalsIgnoreCase("")){
// 		criterion=RestrictionsFactoryUtil.eq("status",status);
// 	}
// 	else{
// 		criterion=RestrictionsFactoryUtil.ne("status", "Initiated");
// 	}

		
// 	querySbiStartUp1.add(criterion);

	
// 	try {
// 		list = (List)SbiStartUpLocalServiceUtil.dynamicQuery(querySbiStartUp1);
		
		
// 	} catch (Exception ex) {
// 		ex.printStackTrace();
// 	}
	}

%>
<fmt:setBundle basename="portlet"/>

<table id="userTable" class="display table adminsear_mar" cellspacing="0" width="100%" >
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
                 
                <td class="regPdf" style="cursor:pointer; text-decoration:underline; color:#06C;" ><a href="<%=adminDownloadpdfURL.toString() %>&regnum=<%=curUser.getRegnum()%>" id="<%=curUser.getRegnum()%>" target="_blank"><%=curUser.getRegnum()%></a></td>
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

