package com.sbi.StartUp;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.liferay.util.portlet.PortletProps;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.List;

import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.sbi.StartUp.model.SbiStartUp;

import javax.portlet.PortletException;
import javax.portlet.PortletSession;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.apache.log4j.Logger;

import com.sbi.StartUp.service.SbiStartUpLocalServiceUtil;
/**
 * Portlet implementation class UserQuery
 */
public class UserQuery extends MVCPortlet {
	private static Logger Log = Logger.getLogger(UserQuery.class);
	String postedquery = "";

    boolean validation = true;           
    String errtext = "";
    

	public void serveResource(ResourceRequest resourceRequest,
            ResourceResponse resourceResponse) throws IOException, PortletException {			
		if(resourceRequest.getResourceID().equals("UserQueryURL")){
			
			String userString=resourceRequest.getParameter("ajaxdata");
			String enteredCaptchaText=resourceRequest.getParameter("captcha");
			boolean captcha = false;
			
			//String enteredCaptchaText = ParamUtil.getString(uploadrequest, "captchaText");
			System.out.println(" enteredCaptchaText" + enteredCaptchaText);
		    PortletSession session = resourceRequest.getPortletSession();
		    String captchaText = (String)getCaptchaValueFromSession(session);
		    String jsp = null;
		    if(Validator.isNull(captchaText)){ 
		    	
		       	errtext = PortletProps.get("err.fault.sbi.eduloan.captcham");
		      captcha = false;
	       	  	validation = false;
		    }else if(!captchaText.equals(enteredCaptchaText)){
		       	errtext = PortletProps.get("err.fault.sbi.eduloan.captcha");
		       	captcha = false;
	       	  	validation = false;
		    }else{
		    	captcha = true;
	       	  	validation = true;
		    }
	             
		    if(captcha){
			
			DynamicQuery query = DynamicQueryFactoryUtil.forClass(SbiStartUp.class);
		    Criterion criterion = null;
		    
		    String status = "";
		    query.add(PropertyFactoryUtil.forName("regnum").eq(userString));
		    		
		    		List<SbiStartUp> list = null;
		    		try{
		    		    list = (List)SbiStartUpLocalServiceUtil.dynamicQuery(query);
		    		   
		    		    SbiStartUp sbi = list.get(0); 
		    		    status = sbi.getStatus();
		    		    System.out.println("status "+status);
		    		    PrintWriter writer = resourceResponse.getWriter();

		    		    writer.write(status);
		    		}catch(Exception ex){
		    			Log.info(ex);
		    			ex.printStackTrace();
		    			
		    			System.out.println("in catch ");
		    			status = "Invalid";
		    		    PrintWriter writer = resourceResponse.getWriter();
		    		    writer.write(status);
		    		    Log.info(ex);
		    		    Log.error(ex);

		    		}
		    		
		    }else{
		    	resourceResponse.setContentType("text/html;charset=UTF-8");
		    	resourceResponse.getWriter().write("Fail");
		    	
		    }
		    
		    
		    }
		    
		 
		else if(resourceRequest.getResourceID().equals("captchaURL")){ 
			 
				try {
			     	com.liferay.portal.kernel.captcha.CaptchaUtil.serveImage(resourceRequest, resourceResponse);			     	
			      
			 	} catch (Exception e) {
			 		Log.info(e);
			 		
			 		// TODO: handle exception
			 		 
			 		
			 	}
			
		}
			
	}	

	private String getCaptchaValueFromSession(PortletSession session) {
		Enumeration<String> atNames = session.getAttributeNames();
		while (atNames.hasMoreElements()) {
		String name = atNames.nextElement();
		if (name.contains("CAPTCHA_TEXT")) {
		    return (String) session.getAttribute(name);
			}
		}
		return null;
		}
		        


}		
		 