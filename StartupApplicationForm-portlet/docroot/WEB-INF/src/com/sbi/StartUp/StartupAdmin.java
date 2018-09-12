package com.sbi.StartUp;

import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.portlet.PortletClassLoaderUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.sbi.StartUp.model.CapitalInf;
import com.sbi.StartUp.model.ResumeDtls;
import com.sbi.StartUp.model.SbiStartUp;
import com.sbi.StartUp.model.impl.SbiStartUpImpl;
import com.sbi.StartUp.service.ResumeDtlsLocalServiceUtil;
import com.sbi.StartUp.service.SbiStartUpLocalServiceUtil;
 
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
 

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

/**
 * Portlet implementation class StartupAdmin
 */
public class StartupAdmin extends MVCPortlet {
 
	private static Logger Log = Logger.getLogger(StartupAdmin.class);
	/*@Override
    public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
        throws IOException, PortletException {
	String promoterCount = null;
	final PortletSession psession = renderRequest.getPortletSession();
	
	if(renderRequest.getParameter("jsp") == null){
		getPortletContext().getRequestDispatcher("/html/startup/view.jsp").include(
				renderRequest, renderResponse);
		psession.setAttribute("LIFERAY_SHARED_COUNT", promoterCount, PortletSession.APPLICATION_SCOPE);	
	}else if(renderRequest.getParameter("jsp") != null){
		
		String founders = renderRequest.getParameter("initial_founders");
		promoterCount = founders;
		psession.setAttribute("LIFERAY_SHARED_COUNT", promoterCount, PortletSession.APPLICATION_SCOPE);
		getPortletContext().getRequestDispatcher("/html/startup/startupResume.jsp").include(
				renderRequest, renderResponse);
		
	}
	
}*/
	@Override
	public void serveResource(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws IOException,
			PortletException {
		
			String resourceId = resourceRequest.getResourceID();
			 
			
			if(resourceId.equalsIgnoreCase("updateStatusAjax")){
				
				String status = resourceRequest.getParameter("status");
				String regnum = resourceRequest.getParameter("regnum");
			 
				SbiStartUpLocalServiceUtil.updatestatus(status, regnum);
			}
			
			if(resourceId.equalsIgnoreCase("search")){
				 

				PortletRequestDispatcher dispatcher = 
			 			getPortletContext().getRequestDispatcher
			 			("/html/startupadmin/searchResult.jsp?type=search");
			 	dispatcher.include(resourceRequest, resourceResponse);
			 	
			}
			if(resourceId.equalsIgnoreCase("reset")){
				 

				PortletRequestDispatcher dispatcher = 
			 			getPortletContext().getRequestDispatcher
			 			("/html/startupadmin/searchResult.jsp?type=reset");
			 	dispatcher.include(resourceRequest, resourceResponse);
			 	
			}
			else if(resourceId.equalsIgnoreCase("adminDownloadpdfURL")){ 
				System.out.println("regnum");
				
				
			     System.out.println(ParamUtil.getString(resourceRequest,"regnum"));				
			   
				    String regNum=(String)resourceRequest.getParameter("regnum");
				     System.out.println("regnum" + regNum);
				     //String regNum="10554297";
				     
				     SbiStartUp lStartUp = null;
					try {
						lStartUp = SbiStartUpLocalServiceUtil.fetchSbiStartUp(regNum);
					} catch (SystemException e) {
					
						// TODO Auto-generated catch block
						Log.info(e);
						
						
						
					}
				     
					StartUp strtup = new StartUp();
				    strtup.convertToPdf(lStartUp, regNum, resourceResponse, resourceRequest);	

			} 
			
	}
	 public void detailsURL(ActionRequest ar , ActionResponse aq) throws Exception
	    {
			// set up the view
		    aq.setRenderParameter("jspPage", "/html/startupadmin/entrydisplay.jsp");    
		    aq.setRenderParameter("regNum", (String)ar.getParameter("regNum"));  
		    
	    }
	    
	 public void promoterURL(ActionRequest ar , ActionResponse aq) throws Exception
	    {
			// set up the view
		    aq.setRenderParameter("jspPage", "/html/startupadmin/promoterdetails.jsp");    
		    aq.setRenderParameter("regNum", (String)ar.getParameter("regNum"));    
		 
		   
	    }
	    public void searchURL(ActionRequest ar , ActionResponse aq) throws Exception
	    {
		    aq.setRenderParameter("jspPage", "/html/startup/view.jsp"); 
		
	    }
	   
	}



