package com.sbi.StartUp;

import com.sbi.StartUp.model.CapitalInf;
import com.sbi.StartUp.model.ResumeDtls;
import com.sbi.StartUp.model.SbiStartUp;
import com.sbi.StartUp.model.impl.CapitalInfImpl;
import com.sbi.StartUp.model.impl.SbiStartUpImpl;
import com.sbi.StartUp.model.impl.ResumeDtlsImpl;
import com.sbi.StartUp.service.CapitalInfLocalServiceUtil;
import com.sbi.StartUp.service.ResumeDtlsLocalServiceUtil;
import com.sbi.StartUp.service.SbiStartUpLocalServiceUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Junction;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.HttpHeaders;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.liferay.util.portlet.PortletProps;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringReader;
import java.security.Security;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletContext;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.html.simpleparser.HTMLWorker;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import com.sun.net.ssl.internal.ssl.Provider;

/**
 * Portlet implementation class sbicarloan
 */
public class StartUp extends MVCPortlet {

	private static Logger Log = Logger.getLogger(StartUp.class);
	DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

	String registered_name = "";
	String founders = "";
	String promoters = "";
	String date_of_establishment = "";
	String constitution = "";
	String address_line_1 = "";
	String address_line_2 = "";
	String address_landmark = "";
	String address_pin = "";
	String address_state = "";
	String address_city = "";
	String corporate_website = "";
	String corporate_email = "";
	String initial_founders = "";
	String is_promoter = "";
	String noofemp = "";
	String cp_promoters_names = "";
	String cp_promoters_addresses = "";
	String cp_promoters_amounts = "";

	String excluding_promoters = "";
	String description_of_product = "";
	String initial_capital = "";
	String monetary_value = "";
	String business_model = "";
	String current_capital = "";
	String current_promoters_name = "";

	String capital_infusion = "";
	String address_investors = "";
	String gross_revenue_year2_investors = "";
	String valuation_amount = "";
	String Loans_availed = "";
	String valuer_name = "";
	// Date valuation_date = null;
	String valuation_amount_rs = "";
	String loan_avail_source = "";
	String loan_avail_rs = "";
	// String gross_revenue = "";
	String gross_revenue_year1 = "";
	String gross_revenue_rs1 = "";
	String gross_revenue_year2 = "";
	String gross_revenue_rs2 = "";

	// added by rohit
	String revenue_project_year1 = "";
	String revenue_project_year2 = "";
	String revenue_project_year3 = "";

	String gross_projected_revenue_rs1 = "";
	String gross_projected_revenue_rs2 = "";
	String gross_projected_revenue_rs3 = "";

	// end
	String gross_revenue_year3 = "";
	String gross_revenue_rs3 = "";
	// String ebidta = "";
	String ebidta_year1 = "";
	String ebidta_rs1 = "";
	String ebidta_year2 = "";
	String ebidta_rs2 = "";
	String ebidta_year3 = "";
	String ebidta_rs3 = "";
	String net_profit = "";
	String net_profit_year1 = "";
	String net_profit_rs1 = "";
	String net_profit_year2 = "";
	String net_profit_rs2 = "";
	String net_profit_year3 = "";
	String net_profit_rs3 = "";
	String financial_assistance = "";
	String financial_bank_engagement = "";
	String financial_assi_purp = "";

	String revenue_projections = "";
	String agreeable_process = "";
	String gsr_department = "";
	String startupindia = "";
	String incubator = "";
	String errtext = "";
	ThemeDisplay themeDisplay;
	String action = "";

	String valuation_date = "";

	//
	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {

		String promoterCount = null;
		final PortletSession psession = renderRequest.getPortletSession();

		if (renderRequest.getParameter("jsp") == null) {
			getPortletContext().getRequestDispatcher("/html/startup/view.jsp")
			.include(renderRequest, renderResponse);
		} else if (renderRequest.getParameter("jsp") == "view") {
			if (renderRequest.getParameter("hidegsr") == "true") {
				renderRequest.setAttribute("hidegsr", "true");
			} else {
				renderRequest.setAttribute("hidegsr", "false");
			}
			getPortletContext().getRequestDispatcher("/html/startup/view.jsp")
			.include(renderRequest, renderResponse);
			psession.setAttribute("LIFERAY_SHARED_COUNT", promoterCount,
					PortletSession.APPLICATION_SCOPE);
		} else if (renderRequest.getParameter("jsp") != null) {

			String lfounders = renderRequest.getParameter("promoters");
			String regNum = renderRequest.getParameter("regnum");
			promoterCount = lfounders;
			String indexNo = fetchIndexNo(renderRequest, renderResponse);

			psession.setAttribute("LIFERAY_SHARED_COUNT", promoterCount,
					PortletSession.APPLICATION_SCOPE);
			renderRequest.setAttribute("indexno", indexNo);
			getPortletContext().getRequestDispatcher(
					"/html/startup/startupResume.jsp").include(renderRequest,
							renderResponse);

		}
	}

	private String fetchIndexNo(RenderRequest renderRequest,
			RenderResponse renderResponse) {
		// TODO Auto-generated method stub
		String indexNo = "";
		String regNum = renderRequest.getParameter("regnum");
		String founders = renderRequest.getParameter("promoters");
		String[] founderList = founders.split("\\,");
		ArrayList<Integer> listofIndex = new ArrayList<Integer>();
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(ResumeDtls.class);
		Criterion criterion = RestrictionsFactoryUtil.eq("RegNum", regNum);
		Criterion crit2 = RestrictionsFactoryUtil.eq("flag", true);
		Junction conjunction = RestrictionsFactoryUtil.conjunction();
		conjunction.add(criterion);
		conjunction.add(crit2);
		query.add(conjunction);

		List<ResumeDtls> list = null;
		String[] indexArray = null;
		try {
			list = (List) ResumeDtlsLocalServiceUtil.dynamicQuery(query);
			if (list.size() > 0) {

				for (int x = 0; x < list.size(); x++) {
					listofIndex.add(Integer.parseInt(list.get(x).getIndexno()));
				}
				int temp = 1;
				while (temp <= founderList.length) {

					if (!listofIndex.contains(temp)) {
						indexNo = Integer.toString(temp);
						break;
					} else {
						temp++;
					}
				}

			} else {
				indexNo = "1";
			}
		} catch (Exception ex) {

			indexNo = "1";
			 ex.printStackTrace();
			Log.info(ex);
			

		}
		return indexNo;
	}

	// public void SubmitForm(ActionRequest ar , ActionResponse aq) throws
	// Exception
	public void SubmitForm(ActionRequest ar, ActionResponse aq)
			throws Exception {

		// themeDiplay for current user information and etc ..
		ThemeDisplay themeDisplay = (ThemeDisplay) ar
				.getAttribute(WebKeys.THEME_DISPLAY);
		// Checking for null and checkRemoveXSSVeranablity xss security for all
		// fields
		UploadPortletRequest uploadrequest = PortalUtil
				.getUploadPortletRequest(ar);
		// HttpServletRequest = PortalUtil.getHttpServletRequest(ar);
		PortletSession sessionp = ar.getPortletSession();
		Date doe = new Date();
		Date doe1 = new Date();

		String regnum = (String) sessionp.getAttribute("regnum") != null ? (String) sessionp
				.getAttribute("regnum") : "";
				// System.out.println("---- Reg Num ---"+regnum);

				if (ParamUtil.getString(uploadrequest, "founders", StringPool.BLANK) != null) {

					founders = (String) ParamUtil.getString(uploadrequest, "founders",
							StringPool.BLANK);
					founders = ValidatorUtil.checkRemoveXSSVeranablity(founders);
					sessionp.setAttribute("founders", founders);
					aq.setRenderParameter("founders1", founders);
				}
				if (ParamUtil.getString(uploadrequest, "promoters", StringPool.BLANK) != null) {

					promoters = (String) ParamUtil.getString(uploadrequest,
							"promoters", StringPool.BLANK);
					promoters = ValidatorUtil.checkRemoveXSSVeranablity(promoters);
					sessionp.setAttribute("promoters", promoters);
					aq.setRenderParameter("promoters", promoters);
				}

				if (ParamUtil.getString(uploadrequest, "registered_name",
						StringPool.BLANK) != null) {
					registered_name = (String) ParamUtil.getString(uploadrequest,
							"registered_name", StringPool.BLANK);
					registered_name = ValidatorUtil
							.checkRemoveXSSVeranablity(registered_name);
					// aq.setRenderParameter("registered_name", registered_name);
					sessionp.setAttribute("registered_name", registered_name);
				}
				if (ParamUtil.getDate(uploadrequest, "date_of_establishment", df) != null) {
					date_of_establishment = (String) ParamUtil.getString(uploadrequest,
							"date_of_establishment", StringPool.BLANK);
					date_of_establishment = ValidatorUtil
							.checkRemoveXSSVeranablity(date_of_establishment);
					// aq.setRenderParameter("date_of_establishment",
					// ParamUtil.getString(uploadrequest, "date_of_establishment",
					// StringPool.BLANK));
					sessionp.setAttribute("date_of_establishment",
							date_of_establishment.toString());
					try {
						DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
						Date date = format.parse(date_of_establishment);
						// Date Dob1 = new Date() ;
						doe = date;
					} catch (Exception e) {
						// TODO: handle exception
						Log.error("Check  date format");
						
					}
				}

				if (ParamUtil
						.getString(uploadrequest, "constitution", StringPool.BLANK) != null) {
					constitution = (String) ParamUtil.getString(uploadrequest,
							"constitution", StringPool.BLANK);
					constitution = ValidatorUtil
							.checkRemoveXSSVeranablity(constitution);
					// aq.setRenderParameter("constitution", constitution);
					sessionp.setAttribute("constitution", constitution);
				}

				if (ParamUtil.getString(uploadrequest, "corporate_website",
						StringPool.BLANK) != null) {
					corporate_website = (String) ParamUtil.getString(uploadrequest,
							"corporate_website", StringPool.BLANK);
					corporate_website = ValidatorUtil
							.checkRemoveXSSVeranablity(corporate_website);
					// aq.setRenderParameter("corporate_website", corporate_website);
					sessionp.setAttribute("corporate_website", corporate_website);

				}

				if (ParamUtil.getString(uploadrequest, "corporate_email",
						StringPool.BLANK) != null) {
					corporate_email = (String) ParamUtil.getString(uploadrequest,
							"corporate_email", StringPool.BLANK);
					corporate_email = ValidatorUtil
							.checkRemoveXSSVeranablity(corporate_email);
					// aq.setRenderParameter("corporate_email", corporate_email);
					sessionp.setAttribute("corporate_email", corporate_email);
				}
				if (ParamUtil.getString(uploadrequest, "initial_founders",
						StringPool.BLANK) != null) {
					initial_founders = (String) ParamUtil.getString(uploadrequest,
							"initial_founders", StringPool.BLANK);
					initial_founders = ValidatorUtil
							.checkRemoveXSSVeranablity(initial_founders);
					sessionp.setAttribute("initial_founders", initial_founders);
				}

				if (ParamUtil.getString(uploadrequest, "excluding_promoters",
						StringPool.BLANK) != null) {
					excluding_promoters = (String) ParamUtil.getString(uploadrequest,
							"excluding_promoters", StringPool.BLANK);
					excluding_promoters = ValidatorUtil
							.checkRemoveXSSVeranablity(excluding_promoters);
					// aq.setRenderParameter("excluding_promoters",
					// excluding_promoters);
					sessionp.setAttribute("excluding_promoters", excluding_promoters);
				}

				if (ParamUtil.getString(uploadrequest, "description_of_product",
						StringPool.BLANK) != null) {
					description_of_product = (String) ParamUtil.getString(
							uploadrequest, "description_of_product", StringPool.BLANK);
					description_of_product = ValidatorUtil
							.checkRemoveXSSVeranablity(description_of_product);
					// aq.setRenderParameter("description_of_product",
					// description_of_product);
					sessionp.setAttribute("description_of_product",
							description_of_product);
					
					
				}
				if (ParamUtil.getString(uploadrequest, "financial_assistance_purpose",
						StringPool.BLANK) != null) {
					financial_assi_purp = (String) ParamUtil.getString(uploadrequest,
							"financial_assistance_purpose", StringPool.BLANK);
					financial_assi_purp = ValidatorUtil
							.checkRemoveXSSVeranablity(financial_assi_purp);
					// aq.setRenderParameter("financial_assi_purp",
					// financial_assi_purp);
					sessionp.setAttribute("financial_assi_purp", financial_assi_purp);
				}

				if (ParamUtil.getString(uploadrequest, "initial_capital",
						StringPool.BLANK) != null) {
					initial_capital = (String) ParamUtil.getString(uploadrequest,
							"initial_capital", StringPool.BLANK);
					initial_capital = ValidatorUtil
							.checkRemoveXSSVeranablity(initial_capital);
					// aq.setRenderParameter("initial_capital", initial_capital);
					sessionp.setAttribute("initial_capital", initial_capital);
				}

				if (ParamUtil.getString(uploadrequest, "monetary_value",
						StringPool.BLANK) != null) {
					monetary_value = (String) ParamUtil.getString(uploadrequest,
							"monetary_value", StringPool.BLANK);
					monetary_value = ValidatorUtil
							.checkRemoveXSSVeranablity(monetary_value);
					// aq.setRenderParameter("monetary_value", monetary_value);
					sessionp.setAttribute("monetary_value", monetary_value);
				}
				if (ParamUtil.getString(uploadrequest, "business_model",
						StringPool.BLANK) != null) {
					business_model = (String) ParamUtil.getString(uploadrequest,
							"business_model", StringPool.BLANK);
					business_model = ValidatorUtil
							.checkRemoveXSSVeranablity(business_model);
					// aq.setRenderParameter("business_model", business_model);
					sessionp.setAttribute("business_model", business_model);
				}

				if (ParamUtil.getString(uploadrequest, "current_capital",
						StringPool.BLANK) != null) {
					current_capital = (String) ParamUtil.getString(uploadrequest,
							"current_capital", StringPool.BLANK);
					current_capital = ValidatorUtil
							.checkRemoveXSSVeranablity(current_capital);
					// aq.setRenderParameter("current_capital", current_capital);
					sessionp.setAttribute("current_capital", current_capital);
				}

				if (ParamUtil.getString(uploadrequest, "capital_infusion",
						StringPool.BLANK) != null) {
					capital_infusion = (String) ParamUtil.getString(uploadrequest,
							"capital_infusion", StringPool.BLANK);
					// aq.setRenderParameter("capital_infusion",
					// ParamUtil.getString(uploadrequest, "capital_infusion",
					// StringPool.BLANK));
					sessionp.setAttribute("capital_infusion", capital_infusion);
				}

				if (ParamUtil.getString(uploadrequest, "gross_revenue_year2_investors",
						StringPool.BLANK) != null) {
					gross_revenue_year2_investors = (String) ParamUtil.getString(
							uploadrequest, "gross_revenue_year2_investors",
							StringPool.BLANK);
					// aq.setRenderParameter("gross_revenue_year2_investors",
					// ParamUtil.getString(uploadrequest,
					// "gross_revenue_year2_investors", StringPool.BLANK));
					sessionp.setAttribute("gross_revenue_year2_investors",
							gross_revenue_year2_investors);
				}

				if (ParamUtil.getString(uploadrequest, "valuation_amount",
						StringPool.BLANK) != null) {
					valuation_amount = (String) ParamUtil.getString(uploadrequest,
							"valuation_amount", StringPool.BLANK);
					// aq.setRenderParameter("valuation_amount",
					// ParamUtil.getString(uploadrequest, "valuation_amount",
					// StringPool.BLANK));
					sessionp.setAttribute("valuation_amount", valuation_amount);

				}

				if (ParamUtil.getString(uploadrequest, "Loans_availed",
						StringPool.BLANK) != null) {
					Loans_availed = (String) ParamUtil.getString(uploadrequest,
							"Loans_availed", StringPool.BLANK);
					// aq.setRenderParameter("Loans_availed",
					// ParamUtil.getString(uploadrequest, "Loans_availed",
					// StringPool.BLANK));
					sessionp.setAttribute("Loans_availed", Loans_availed);
				}

				if (ParamUtil.getString(uploadrequest, "valuer_name", StringPool.BLANK) != null) {
					valuer_name = (String) ParamUtil.getString(uploadrequest,
							"valuer_name", StringPool.BLANK);
					// aq.setRenderParameter("valuer_name",
					// ParamUtil.getString(uploadrequest, "valuer_name",
					// StringPool.BLANK));
					sessionp.setAttribute("valuer_name", valuer_name);
				}

				if (ParamUtil.getString(uploadrequest, "valuation_date",
						StringPool.BLANK) != null) {
					valuation_date = ParamUtil.getString(uploadrequest,
							"valuation_date", StringPool.BLANK);
					// valuation_date =
					// ValidatorUtil.checkRemoveXSSVeranablity(valuation_date);
					// aq.setRenderParameter("valuation_date",
					// ParamUtil.getString(uploadrequest, "valuation_date",
					// StringPool.BLANK));

					try {
						DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
						Date date = format.parse(valuation_date);
						// Date Dob1 = new Date() ;
						doe1 = date;
					} catch (Exception e) {
						Log.info("pls Check the date format"  +e.getMessage());
						

						// TODO: handle exception
					}
					sessionp.setAttribute("valuation_date", valuation_date);
				}
				if (ParamUtil.getString(uploadrequest, "valuation_amount_rs",
						StringPool.BLANK) != null) {
					valuation_amount_rs = (String) ParamUtil.getString(uploadrequest,
							"valuation_amount_rs", StringPool.BLANK);

					valuation_amount_rs = ValidatorUtil
							.checkRemoveXSSVeranablity(valuation_amount_rs);
					// aq.setRenderParameter("valuation_amount_rs",
					// valuation_amount_rs);
					sessionp.setAttribute("valuation_amount_rs", valuation_amount_rs);
				}

				if (ParamUtil.getString(uploadrequest, "loan_avail_source",
						StringPool.BLANK) != null) {
					loan_avail_source = (String) ParamUtil.getString(uploadrequest,
							"loan_avail_source", StringPool.BLANK);
					loan_avail_source = ValidatorUtil
							.checkRemoveXSSVeranablity(loan_avail_source);
					sessionp.setAttribute("loan_avail_source", loan_avail_source);
					// aq.setRenderParameter("loan_avail_source", loan_avail_source);
				}
				if (ParamUtil.getString(uploadrequest, "loan_avail_rs",
						StringPool.BLANK) != null) {
					loan_avail_rs = (String) ParamUtil.getString(uploadrequest,
							"loan_avail_rs", StringPool.BLANK);
					loan_avail_rs = ValidatorUtil
							.checkRemoveXSSVeranablity(loan_avail_rs);
					sessionp.setAttribute("loan_avail_rs", loan_avail_rs);
					// aq.setRenderParameter("loan_avail_rs", loan_avail_rs);
				}

				if (ParamUtil.getString(uploadrequest, "revenue_project_year1",
						StringPool.BLANK) != null) {
					revenue_project_year1 = (String) ParamUtil.getString(uploadrequest,
							"revenue_project_year1", StringPool.BLANK);
					revenue_project_year1 = ValidatorUtil
							.checkRemoveXSSVeranablity(revenue_project_year1);
					// aq.setRenderParameter("revenue_project_year1",
					// revenue_project_year1);
					sessionp.setAttribute("revenue_project_year1",
							revenue_project_year1);
				}

				if (ParamUtil.getString(uploadrequest, "revenue_project_year2",
						StringPool.BLANK) != null) {
					revenue_project_year2 = (String) ParamUtil.getString(uploadrequest,
							"revenue_project_year2", StringPool.BLANK);
					revenue_project_year2 = ValidatorUtil
							.checkRemoveXSSVeranablity(revenue_project_year2);
					// aq.setRenderParameter("revenue_project_year2",
					// revenue_project_year2);
					sessionp.setAttribute("revenue_project_year2",
							revenue_project_year2);
				}

				if (ParamUtil.getString(uploadrequest, "revenue_project_year3",
						StringPool.BLANK) != null) {
					revenue_project_year3 = (String) ParamUtil.getString(uploadrequest,
							"revenue_project_year3", StringPool.BLANK);
					revenue_project_year3 = ValidatorUtil
							.checkRemoveXSSVeranablity(revenue_project_year3);
					// aq.setRenderParameter("revenue_project_year3",
					// revenue_project_year3);
					sessionp.setAttribute("revenue_project_year3",
							revenue_project_year3);
				}

				if (ParamUtil.getString(uploadrequest, "gross_projected_revenue_rs1",
						StringPool.BLANK) != null) {
					gross_projected_revenue_rs1 = (String) ParamUtil.getString(
							uploadrequest, "gross_projected_revenue_rs1",
							StringPool.BLANK);
					gross_projected_revenue_rs1 = ValidatorUtil
							.checkRemoveXSSVeranablity(gross_projected_revenue_rs1);
					// aq.setRenderParameter("gross_projected_revenue_rs1",
					// gross_projected_revenue_rs1);
					sessionp.setAttribute("gross_projected_revenue_rs1",
							gross_projected_revenue_rs1);
				}

				if (ParamUtil.getString(uploadrequest, "gross_projected_revenue_rs2",
						StringPool.BLANK) != null) {
					gross_projected_revenue_rs2 = (String) ParamUtil.getString(
							uploadrequest, "gross_projected_revenue_rs2",
							StringPool.BLANK);
					gross_projected_revenue_rs2 = ValidatorUtil
							.checkRemoveXSSVeranablity(gross_projected_revenue_rs2);
					// aq.setRenderParameter("gross_projected_revenue_rs2",
					// gross_projected_revenue_rs2);
					sessionp.setAttribute("gross_projected_revenue_rs2",
							gross_projected_revenue_rs2);
				}

				if (ParamUtil.getString(uploadrequest, "gross_projected_revenue_rs3",
						StringPool.BLANK) != null) {
					gross_projected_revenue_rs3 = (String) ParamUtil.getString(
							uploadrequest, "gross_projected_revenue_rs3",
							StringPool.BLANK);
					gross_projected_revenue_rs3 = ValidatorUtil
							.checkRemoveXSSVeranablity(gross_projected_revenue_rs3);
					// aq.setRenderParameter("gross_projected_revenue_rs3",
					// gross_projected_revenue_rs3);
					sessionp.setAttribute("gross_projected_revenue_rs3",
							gross_projected_revenue_rs3);
				}

				if (ParamUtil.getString(uploadrequest, "gross_revenue_year1",
						StringPool.BLANK) != null) {
					gross_revenue_year1 = (String) ParamUtil.getString(uploadrequest,
							"gross_revenue_year1", StringPool.BLANK);
					gross_revenue_year1 = ValidatorUtil
							.checkRemoveXSSVeranablity(gross_revenue_year1);
					// aq.setRenderParameter("gross_revenue_year1",
					// gross_revenue_year1);
					sessionp.setAttribute("gross_revenue_year1", gross_revenue_year1);
				}

				if (ParamUtil.getString(uploadrequest, "gross_revenue_rs1",
						StringPool.BLANK) != null) {
					gross_revenue_rs1 = (String) ParamUtil.getString(uploadrequest,
							"gross_revenue_rs1", StringPool.BLANK);
					gross_revenue_rs1 = ValidatorUtil
							.checkRemoveXSSVeranablity(gross_revenue_rs1);
					// aq.setRenderParameter("gross_revenue_rs1", gross_revenue_rs1);
					sessionp.setAttribute("gross_revenue_rs1", gross_revenue_rs1);
				}

				if (ParamUtil.getString(uploadrequest, "gross_revenue_year2",
						StringPool.BLANK) != null) {

					gross_revenue_year2 = (String) ParamUtil.getString(uploadrequest,
							"gross_revenue_year2", StringPool.BLANK);
					gross_revenue_year2 = ValidatorUtil
							.checkRemoveXSSVeranablity(gross_revenue_year2);
					// aq.setRenderParameter("gross_revenue_year2",
					// gross_revenue_year2);
					sessionp.setAttribute("gross_revenue_year2", gross_revenue_year2);
				}
				if (ParamUtil.getString(uploadrequest, "gross_revenue_rs2",
						StringPool.BLANK) != null) {
					gross_revenue_rs2 = (String) ParamUtil.getString(uploadrequest,
							"gross_revenue_rs2", StringPool.BLANK);
					gross_revenue_rs2 = ValidatorUtil
							.checkRemoveXSSVeranablity(gross_revenue_rs2);
					// aq.setRenderParameter("gross_revenue_rs2", gross_revenue_rs2);
					sessionp.setAttribute("gross_revenue_rs2", gross_revenue_rs2);
				}

				if (ParamUtil.getString(uploadrequest, "gross_revenue_year3",
						StringPool.BLANK) != null) {
					gross_revenue_year3 = (String) ParamUtil.getString(uploadrequest,
							"gross_revenue_year3", StringPool.BLANK);
					gross_revenue_year3 = ValidatorUtil
							.checkRemoveXSSVeranablity(gross_revenue_year3);
					// aq.setRenderParameter("gross_revenue_year3",
					// gross_revenue_year3);
					sessionp.setAttribute("gross_revenue_year3", gross_revenue_year3);
				}

				if (ParamUtil.getString(uploadrequest, "gross_revenue_rs3",
						StringPool.BLANK) != null) {
					gross_revenue_rs3 = (String) ParamUtil.getString(uploadrequest,
							"gross_revenue_rs3", StringPool.BLANK);
					gross_revenue_rs3 = ValidatorUtil
							.checkRemoveXSSVeranablity(gross_revenue_rs3);
					// aq.setRenderParameter("gross_revenue_rs3", gross_revenue_rs3);
					sessionp.setAttribute("gross_revenue_rs3", gross_revenue_rs3);
				}

				// if(ParamUtil.getString(uploadrequest, "ebidta_year1",
				// StringPool.BLANK) != null){
				// ebidta_year1 = (String)ParamUtil.getString(uploadrequest,
				// "ebidta_year1", StringPool.BLANK);
				// ebidta_year1 = ValidatorUtil.checkRemoveXSSVeranablity(ebidta_year1);
				// aq.setRenderParameter("ebidta_year1", ebidta_year1);
				// }
				if (ParamUtil.getString(uploadrequest, "ebidta_rs1", StringPool.BLANK) != null) {
					ebidta_rs1 = (String) ParamUtil.getString(uploadrequest,
							"ebidta_rs1", StringPool.BLANK);
					ebidta_rs1 = ValidatorUtil.checkRemoveXSSVeranablity(ebidta_rs1);
					// aq.setRenderParameter("ebidta_rs1", ebidta_rs1);
					sessionp.setAttribute("ebidta_rs1", ebidta_rs1);

				}
				// if(ParamUtil.getString(uploadrequest, "gross_revenue_year2",
				// StringPool.BLANK) != null){
				// gross_revenue_year2 = (String)ParamUtil.getString(uploadrequest,
				// "gross_revenue_year2", StringPool.BLANK);
				// gross_revenue_year2 =
				// ValidatorUtil.checkRemoveXSSVeranablity(gross_revenue_year2);
				// aq.setRenderParameter("gross_revenue_year2", gross_revenue_year2);
				//
				// }
				if (ParamUtil.getString(uploadrequest, "ebidta_rs2", StringPool.BLANK) != null) {
					ebidta_rs2 = (String) ParamUtil.getString(uploadrequest,
							"ebidta_rs2", StringPool.BLANK);
					ebidta_rs2 = ValidatorUtil.checkRemoveXSSVeranablity(ebidta_rs2);
					// aq.setRenderParameter("ebidta_rs2", ebidta_rs2);
					sessionp.setAttribute("ebidta_rs2", ebidta_rs2);

				}

				if (ParamUtil.getString(uploadrequest, "cp_promoters_amounts",
						StringPool.BLANK) != null) {
					cp_promoters_amounts = (String) ParamUtil.getString(uploadrequest,
							"cp_promoters_amounts", StringPool.BLANK);
					cp_promoters_amounts = ValidatorUtil
							.checkRemoveXSSVeranablity(cp_promoters_amounts);
					// aq.setRenderParameter("cp_promoters_amounts",
					// cp_promoters_amounts);
					sessionp.setAttribute("cp_promoters_amounts", cp_promoters_amounts);

				}

				if (ParamUtil.getString(uploadrequest, "cp_promoters_addresses",
						StringPool.BLANK) != null) {
					cp_promoters_addresses = (String) ParamUtil.getString(
							uploadrequest, "cp_promoters_addresses", StringPool.BLANK);
					cp_promoters_addresses = ValidatorUtil
							.checkRemoveXSSVeranablity(cp_promoters_addresses);
					// aq.setRenderParameter("cp_promoters_addresses",
					// cp_promoters_addresses);
					sessionp.setAttribute("cp_promoters_addresses",
							cp_promoters_addresses);

				}
				if (ParamUtil.getString(uploadrequest, "cp_promoters_names",
						StringPool.BLANK) != null) {
					cp_promoters_names = (String) ParamUtil.getString(uploadrequest,
							"cp_promoters_names", StringPool.BLANK);
					cp_promoters_names = ValidatorUtil
							.checkRemoveXSSVeranablity(cp_promoters_names);
					// aq.setRenderParameter("cp_promoters_names", cp_promoters_names);
					sessionp.setAttribute("cp_promoters_names", cp_promoters_names);

				}
				if (ParamUtil.getString(uploadrequest, "noofemp", StringPool.BLANK) != null) {
					noofemp = (String) ParamUtil.getString(uploadrequest, "noofemp",
							StringPool.BLANK);
					noofemp = ValidatorUtil.checkRemoveXSSVeranablity(noofemp);
					// aq.setRenderParameter("noofemp", noofemp);
					sessionp.setAttribute("noofemp", noofemp);

				}
				// if(ParamUtil.getString(uploadrequest, "gross_revenue_year3",
				// StringPool.BLANK) != null){
				// gross_revenue_year3 = (String)ParamUtil.getString(uploadrequest,
				// "gross_revenue_year3", StringPool.BLANK);
				// gross_revenue_year3 =
				// ValidatorUtil.checkRemoveXSSVeranablity(gross_revenue_year3);
				// aq.setRenderParameter("gross_revenue_year3", gross_revenue_year3);
				//
				// }
				if (ParamUtil.getString(uploadrequest, "ebidta_rs3", StringPool.BLANK) != null) {
					ebidta_rs3 = (String) ParamUtil.getString(uploadrequest,
							"ebidta_rs3", StringPool.BLANK);
					ebidta_rs3 = ValidatorUtil.checkRemoveXSSVeranablity(ebidta_rs3);
					sessionp.setAttribute("ebidta_rs3", ebidta_rs3);
					// aq.setRenderParameter("ebidta_rs3", ebidta_rs3);

				}
				if (ParamUtil.getString(uploadrequest, "net_profit", StringPool.BLANK) != null) {
					net_profit = (String) ParamUtil.getString(uploadrequest,
							"net_profit", StringPool.BLANK);
					net_profit = ValidatorUtil.checkRemoveXSSVeranablity(net_profit);
					// aq.setRenderParameter("net_profit", net_profit);
					sessionp.setAttribute("net_profit", net_profit);

				}
				// if(ParamUtil.getString(uploadrequest, "gross_revenue_year1",
				// StringPool.BLANK) != null){
				// gross_revenue_year1 = (String)ParamUtil.getString(uploadrequest,
				// "gross_revenue_year1", StringPool.BLANK);
				// gross_revenue_year1 =
				// ValidatorUtil.checkRemoveXSSVeranablity(gross_revenue_year1);
				// aq.setRenderParameter("gross_revenue_year1", gross_revenue_year1);
				//
				// }
				if (ParamUtil.getString(uploadrequest, "net_profit_rs1",
						StringPool.BLANK) != null) {
					net_profit_rs1 = (String) ParamUtil.getString(uploadrequest,
							"net_profit_rs1", StringPool.BLANK);
					net_profit_rs1 = ValidatorUtil
							.checkRemoveXSSVeranablity(net_profit_rs1);
					// aq.setRenderParameter("net_profit_rs1", net_profit_rs1);
					sessionp.setAttribute("net_profit_rs1", net_profit_rs1);

				}
				// if(ParamUtil.getString(uploadrequest, "gross_revenue_year2",
				// StringPool.BLANK) != null){
				// gross_revenue_year2 = (String)ParamUtil.getString(uploadrequest,
				// "gross_revenue_year2", StringPool.BLANK);
				// gross_revenue_year2 =
				// ValidatorUtil.checkRemoveXSSVeranablity(gross_revenue_year2);
				// aq.setRenderParameter("gross_revenue_year2", gross_revenue_year2);
				//
				// }
				if (ParamUtil.getString(uploadrequest, "net_profit_rs2",
						StringPool.BLANK) != null) {
					net_profit_rs2 = (String) ParamUtil.getString(uploadrequest,
							"net_profit_rs2", StringPool.BLANK);
					net_profit_rs2 = ValidatorUtil
							.checkRemoveXSSVeranablity(net_profit_rs2);
					// aq.setRenderParameter("net_profit_rs2", net_profit_rs2);
					sessionp.setAttribute("net_profit_rs2", net_profit_rs2);

				}
				// if(ParamUtil.getString(uploadrequest, "gross_revenue_year3",
				// StringPool.BLANK) != null){
				// gross_revenue_year3 = (String)ParamUtil.getString(uploadrequest,
				// "gross_revenue_year3", StringPool.BLANK);
				// gross_revenue_year3 =
				// ValidatorUtil.checkRemoveXSSVeranablity(gross_revenue_year3);
				// aq.setRenderParameter("gross_revenue_year3", gross_revenue_year3);
				//
				// }
				if (ParamUtil.getString(uploadrequest, "net_profit_rs3",
						StringPool.BLANK) != null) {
					net_profit_rs3 = (String) ParamUtil.getString(uploadrequest,
							"net_profit_rs3", StringPool.BLANK);
					net_profit_rs3 = ValidatorUtil
							.checkRemoveXSSVeranablity(net_profit_rs3);
					// aq.setRenderParameter("net_profit_rs3", net_profit_rs3);
					sessionp.setAttribute("net_profit_rs3", net_profit_rs3);

				}
				if (ParamUtil.getString(uploadrequest, "financial_bank_engagement",
						StringPool.BLANK) != null) {
					financial_bank_engagement = (String) ParamUtil.getString(
							uploadrequest, "financial_bank_engagement",
							StringPool.BLANK);
					financial_bank_engagement = ValidatorUtil
							.checkRemoveXSSVeranablity(financial_bank_engagement);
					// aq.setRenderParameter("financial_bank_engagement",
					// financial_bank_engagement);
					sessionp.setAttribute("financial_bank_engagement",
							financial_bank_engagement);

				}
				if (ParamUtil.getString(uploadrequest, "financial_assistance",
						StringPool.BLANK) != null) {
					financial_assistance = (String) ParamUtil.getString(uploadrequest,
							"financial_assistance", StringPool.BLANK);
					financial_assistance = ValidatorUtil
							.checkRemoveXSSVeranablity(financial_assistance);
					// aq.setRenderParameter("financial_assistance",
					// financial_assistance);
					sessionp.setAttribute("financial_assistance", financial_assistance);

				}
				if (ParamUtil.getString(uploadrequest, "revenue_projections",
						StringPool.BLANK) != null) {
					revenue_projections = (String) ParamUtil.getString(uploadrequest,
							"revenue_projections", StringPool.BLANK);
					revenue_projections = ValidatorUtil
							.checkRemoveXSSVeranablity(revenue_projections);
					// aq.setRenderParameter("revenue_projections",
					// revenue_projections);
					sessionp.setAttribute("revenue_projections", revenue_projections);

				}

				if (ParamUtil.getString(uploadrequest, "agreeable_process",
						StringPool.BLANK) != null) {
					agreeable_process = (String) ParamUtil.getString(uploadrequest,
							"agreeable_process", StringPool.BLANK);
					agreeable_process = ValidatorUtil
							.checkRemoveXSSVeranablity(agreeable_process);
					// aq.setRenderParameter("agreeable_process", agreeable_process);
					sessionp.setAttribute("agreeable_process", agreeable_process);

				}
				if (ParamUtil.getString(uploadrequest, "gsr_department",
						StringPool.BLANK) != null) {
					gsr_department = (String) ParamUtil.getString(uploadrequest,
							"gsr_department", StringPool.BLANK);
					gsr_department = ValidatorUtil
							.checkRemoveXSSVeranablity(gsr_department);
					// aq.setRenderParameter("gsr_department", gsr_department);

				}
				if (ParamUtil
						.getString(uploadrequest, "startupindia", StringPool.BLANK) != null) {
					startupindia = (String) ParamUtil.getString(uploadrequest,
							"startupindia", StringPool.BLANK);
					startupindia = ValidatorUtil
							.checkRemoveXSSVeranablity(startupindia);
					// aq.setRenderParameter("startupindia", startupindia);
					sessionp.setAttribute("startupindia", startupindia);

				}
				if (ParamUtil.getString(uploadrequest, "incubator", StringPool.BLANK) != null) {
					incubator = (String) ParamUtil.getString(uploadrequest,
							"incubator", StringPool.BLANK);
					incubator = ValidatorUtil.checkRemoveXSSVeranablity(incubator);
					// aq.setRenderParameter("incubator", incubator);
					sessionp.setAttribute("incubator", incubator);

				}
				if (ParamUtil.getString(uploadrequest, "address_line_1",
						StringPool.BLANK) != null) {
					address_line_1 = (String) ParamUtil.getString(uploadrequest,
							"address_line_1", StringPool.BLANK);
					address_line_1 = ValidatorUtil
							.checkRemoveXSSVeranablity(address_line_1);
					// aq.setRenderParameter("address_line_1", address_line_1);
					sessionp.setAttribute("address_line_1", address_line_1);

				}
				if (ParamUtil.getString(uploadrequest, "address_line_2",
						StringPool.BLANK) != null) {
					address_line_2 = (String) ParamUtil.getString(uploadrequest,
							"address_line_2", StringPool.BLANK);
					address_line_2 = ValidatorUtil
							.checkRemoveXSSVeranablity(address_line_2);
					// aq.setRenderParameter("address_line_2", address_line_2);
					sessionp.setAttribute("address_line_2", address_line_2);

				}
				if (ParamUtil
						.getString(uploadrequest, "address_city", StringPool.BLANK) != null) {
					address_city = (String) ParamUtil.getString(uploadrequest,
							"address_city", StringPool.BLANK);
					address_city = ValidatorUtil
							.checkRemoveXSSVeranablity(address_city);
					// aq.setRenderParameter("address_city", address_city);
					sessionp.setAttribute("address_city", address_city);

				}
				if (ParamUtil.getString(uploadrequest, "address_pin", StringPool.BLANK) != null) {
					address_pin = (String) ParamUtil.getString(uploadrequest,
							"address_pin", StringPool.BLANK);
					address_pin = ValidatorUtil.checkRemoveXSSVeranablity(address_pin);
					// aq.setRenderParameter("address_pin", address_pin);
					sessionp.setAttribute("address_pin", address_pin);

				}
				if (ParamUtil.getString(uploadrequest, "address_landmark",
						StringPool.BLANK) != null) {
					address_landmark = (String) ParamUtil.getString(uploadrequest,
							"address_landmark", StringPool.BLANK);
					address_landmark = ValidatorUtil
							.checkRemoveXSSVeranablity(address_landmark);
					// aq.setRenderParameter("address_landmark", address_landmark);
					sessionp.setAttribute("address_landmark", address_landmark);

				}
				if (ParamUtil.getString(uploadrequest, "address_state",
						StringPool.BLANK) != null) {
					address_state = (String) ParamUtil.getString(uploadrequest,
							"address_state", StringPool.BLANK);
					address_state = ValidatorUtil
							.checkRemoveXSSVeranablity(address_state);
					// aq.setRenderParameter("address_state", address_state);
					sessionp.setAttribute("address_state", address_state);

				}

				// server side validation

				boolean validation = true;
				boolean captcha = true;

				String enteredCaptchaText = ParamUtil.getString(uploadrequest,
						"captchaText");
				PortletSession session = ar.getPortletSession();
				String captchaText = (String) getCaptchaValueFromSession(session);
				// String captchaText = (String)session.getAttribute("captchaURL");
				String jsp = null;

				if (Validator.isNull(captchaText)) {
					errtext = PortletProps.get("err.fault.sbi.eduloan.captcham");
					aq.setRenderParameter("errtext", errtext);
					captcha = false;
					validation = false;
				} else if (!captchaText.equals(enteredCaptchaText)) {
					errtext = PortletProps.get("err.fault.sbi.eduloan.captcha");
					aq.setRenderParameter("errtext", errtext);
					captcha = false;
					validation = false;
				}

				if (validation) {
					SbiStartUp StartUp = new SbiStartUpImpl();
					Date d = new Date();
					try {
						if (regnum.equalsIgnoreCase("")) {
							// System.out.println("--- Inserting New Records --");
							regnum = generateRandomNumber();
							// System.out.println("--- Randomly generated number is ..");
							StartUp.setUserName(themeDisplay.getUser().getFullName());

							StartUp.setCreateDate(d);
							StartUp.setModifiedDate(d);
							StartUp.setRegnum(regnum);
							StartUp.setRegistered_name(registered_name);
							StartUp.setDate_of_establishment(doe);
							StartUp.setConstitution(constitution);
							StartUp.setCorporate_website(corporate_website);
							StartUp.setCorporate_email(corporate_email);
							StartUp.setInitial_founders(founders);
							StartUp.setCurrent_promoters_name(promoters);
							StartUp.setNoofemp(noofemp);

							StartUp.setFinancial_assi_purp(financial_assi_purp);
							StartUp.setAddress_line_1(address_line_1);
							StartUp.setAddress_line_2(address_line_2);
							StartUp.setAddress_city(address_city);
							StartUp.setAddress_pin(address_pin);
							StartUp.setAddress_landmark(address_landmark);
							StartUp.setAddress_state(address_state);
							StartUp.setDescription_of_product(description_of_product);
							StartUp.setInitial_capital(initial_capital);
							StartUp.setMonetary_value(monetary_value);
							StartUp.setBusiness_model(business_model);
							StartUp.setCurrent_capital(current_capital);
							StartUp.setCapital_infusion(capital_infusion);

							StartUp.setLoans_availed(Loans_availed);
							StartUp.setValuer_name(valuer_name);
							StartUp.setValuation_date(doe1);
							StartUp.setValuation_amount_rs(valuation_amount_rs);
							StartUp.setLoan_avail_source(loan_avail_source);
							StartUp.setLoan_avail_rs(loan_avail_rs);
							// StartUp.setGross_revenue(gross_revenue);
							StartUp.setGross_revenue_year1(gross_revenue_year1);
							StartUp.setGross_revenue_rs1(gross_revenue_rs1);
							StartUp.setGross_revenue_year2(gross_revenue_year2);
							StartUp.setGross_revenue_rs2(gross_revenue_rs2);
							StartUp.setGross_revenue_year3(gross_revenue_year3);
							StartUp.setGross_revenue_rs3(gross_revenue_rs3);
							// StartUp.setEbidta(ebidta);
							StartUp.setEbidta_year1(gross_revenue_year1);
							StartUp.setEbidta_rs1(ebidta_rs1);
							StartUp.setEbidta_year2(gross_revenue_year2);
							StartUp.setEbidta_rs2(ebidta_rs2);
							StartUp.setEbidta_year3(gross_revenue_year3);
							StartUp.setEbidta_rs3(ebidta_rs3);

							StartUp.setNet_profit_year1(gross_revenue_year1);
							StartUp.setNet_profit_rs1(net_profit_rs1);
							StartUp.setNet_profit_year2(gross_revenue_year2);
							StartUp.setNet_profit_rs2(net_profit_rs2);
							StartUp.setNet_profit_year3(gross_revenue_year3);
							StartUp.setNet_profit_rs3(net_profit_rs3);

							StartUp.setFinancial_assistance(financial_assistance);
							StartUp.setFinancial_assi_purp(financial_assi_purp);
							StartUp.setFinancial_bank_engagement(financial_bank_engagement);
							StartUp.setAgreeable_process(agreeable_process);
							StartUp.setGsr_department(gsr_department);
							StartUp.setStartupindia(startupindia);
							StartUp.setIncubator(incubator);
							StartUp.setStatus("Initiated");

							StartUp.setGross_revenue_projected_year1(revenue_project_year1);
							StartUp.setProjected_revenue_rs1(gross_projected_revenue_rs1);

							StartUp.setGross_revenue_projected_year2(revenue_project_year2);
							StartUp.setProjected_revenue_rs2(gross_projected_revenue_rs2);

							StartUp.setGross_revenue_projected_year3(revenue_project_year3);
							StartUp.setProjected_revenue_rs3(gross_projected_revenue_rs3);
							StartUp.setFlag(true);
							sessionp.setAttribute("regnum", regnum);
							sessionp.setAttribute("StartUp", (StartUp));
							aq.setRenderParameter("regnum", regnum);
							// if(!captcha){
							// System.out.println("invalid captcha");
							// aq.setRenderParameter("hidegsr", "true");
							// aq.setRenderParameter("jsp", jsp);
							// }else{
							aq.setRenderParameter("hidegsr", "false");
							SbiStartUpLocalServiceUtil.addSbiStartUp(StartUp);
							jsp = "/html/startup/startupResume.jsp";
							aq.setRenderParameter("jsp", jsp);

							try {
								// SbiStartUp StartUp = new SbiStartUpImpl();
								// Auto increament primary key.
								// long l=
								// CounterLocalServiceUtil.increment(CapitalInf.class.getName());
								CapitalInf CapInfu = new CapitalInfImpl();

								CapInfu.setCreateDate(d);
								CapInfu.setModifiedDate(d);

								String promoterName = "";
								String promoterAddress = "";
								String promoterAmount = "";
								String[] cpPromoterNamesMV = cp_promoters_names
										.split(",");
								String[] cpPromoterAddressMV = cp_promoters_addresses
										.split("\\$");
								String[] cpPromoterAmount = cp_promoters_amounts
										.split(",");
								regnum = (String) sessionp.getAttribute("regnum");
								String capitalInfuKeys = "";
								for (int i = 0; i < cpPromoterNamesMV.length; i++) {
									long key = CounterLocalServiceUtil
											.increment(CapitalInf.class.getName());
									promoterName = cpPromoterNamesMV[i];
									promoterAddress = cpPromoterAddressMV[i];
									promoterAmount = cpPromoterAmount[i];
									CapInfu.setInfRefId(key);
									CapInfu.setRegNum(regnum);
									CapInfu.setModifiedDate(new Date());
									CapInfu.setCreateDate(new Date());
									CapInfu.setCp_promoters_name(promoterName);
									CapInfu.setCp_promoters_address(promoterAddress);
									CapInfu.setCp_promoters_amount(promoterAmount);
									CapitalInfLocalServiceUtil.addCapitalInf(CapInfu);
								}
								sessionp.setAttribute("capInfuKeys", capitalInfuKeys);
								sessionp.setAttribute("capinfulist", (CapInfu));
								clearSession(ar);
							} catch (Exception e) {
								
								 e.printStackTrace();
								 Log.info(e);
							}

						} else {

							StartUp = SbiStartUpLocalServiceUtil
									.fetchSbiStartUp(regnum);
							// StartUp.setUserName(themeDisplay.getUser().getFullName());
							StartUp.setModifiedDate(d);
							StartUp.setRegistered_name(registered_name);
							StartUp.setDate_of_establishment(doe);
							StartUp.setConstitution(constitution);
							StartUp.setCorporate_website(corporate_website);
							StartUp.setCorporate_email(corporate_email);
							StartUp.setInitial_founders(founders);
							StartUp.setCurrent_promoters_name(promoters);
							StartUp.setNoofemp(noofemp);
							StartUp.setFinancial_assi_purp(financial_assi_purp);
							StartUp.setAddress_line_1(address_line_1);
							StartUp.setAddress_line_2(address_line_2);
							StartUp.setAddress_city(address_city);
							StartUp.setAddress_pin(address_pin);
							StartUp.setAddress_landmark(address_landmark);
							StartUp.setAddress_state(address_state);
							StartUp.setDescription_of_product(description_of_product);
							StartUp.setInitial_capital(initial_capital);
							StartUp.setMonetary_value(monetary_value);
							StartUp.setBusiness_model(business_model);
							StartUp.setCurrent_capital(current_capital);
							StartUp.setCapital_infusion(capital_infusion);
							StartUp.setLoans_availed(Loans_availed);
							StartUp.setValuer_name(valuer_name);
							StartUp.setValuation_date(doe1);
							StartUp.setValuation_amount_rs(valuation_amount_rs);
							StartUp.setLoan_avail_source(loan_avail_source);
							StartUp.setLoan_avail_rs(loan_avail_rs);
							StartUp.setGross_revenue_year1(gross_revenue_year1);
							StartUp.setGross_revenue_rs1(gross_revenue_rs1);
							StartUp.setGross_revenue_year2(gross_revenue_year2);
							StartUp.setGross_revenue_rs2(gross_revenue_rs2);
							StartUp.setGross_revenue_year3(gross_revenue_year3);
							StartUp.setGross_revenue_rs3(gross_revenue_rs3);
							StartUp.setEbidta_year1(gross_revenue_year1);
							StartUp.setEbidta_rs1(ebidta_rs1);
							StartUp.setEbidta_year2(gross_revenue_year2);
							StartUp.setEbidta_rs2(ebidta_rs2);
							StartUp.setEbidta_year3(gross_revenue_year3);
							StartUp.setEbidta_rs3(ebidta_rs3);
							StartUp.setNet_profit_year1(gross_revenue_year1);
							StartUp.setNet_profit_rs1(net_profit_rs1);
							StartUp.setNet_profit_year2(gross_revenue_year2);
							StartUp.setNet_profit_rs2(net_profit_rs2);
							StartUp.setNet_profit_year3(gross_revenue_year3);
							StartUp.setNet_profit_rs3(net_profit_rs3);
							StartUp.setFinancial_assistance(financial_assistance);
							StartUp.setFinancial_assi_purp(financial_assi_purp);
							StartUp.setFinancial_bank_engagement(financial_bank_engagement);
							StartUp.setAgreeable_process(agreeable_process);
							StartUp.setGsr_department(gsr_department);
							StartUp.setStartupindia(startupindia);
							StartUp.setIncubator(incubator);
							StartUp.setGross_revenue_projected_year1(revenue_project_year1);
							StartUp.setProjected_revenue_rs1(gross_projected_revenue_rs1);
							StartUp.setGross_revenue_projected_year2(revenue_project_year2);
							StartUp.setProjected_revenue_rs2(gross_projected_revenue_rs2);
							StartUp.setGross_revenue_projected_year3(revenue_project_year3);
							StartUp.setProjected_revenue_rs3(gross_projected_revenue_rs3);
							StartUp.setStatus("Initiated");
							StartUp.setFlag(true);
							sessionp.setAttribute("regnum", regnum);
							sessionp.setAttribute("StartUp", (StartUp));
							aq.setRenderParameter("regnum", regnum);
							aq.setRenderParameter("hidegsr", "false");
							saveCapitalInfusion(ar, cp_promoters_names,
									cp_promoters_addresses, cp_promoters_amounts,
									regnum);
							sessionp.setAttribute("capInfuKeys", "");
							// if(!captcha){
							// System.out.println("invalid captcha 2");
							// aq.setRenderParameter("hidegsr", "true");
							// aq.setRenderParameter("jsp", jsp);
							//
							// }else{
							// System.out.println("valid captcha 2");
							SbiStartUpLocalServiceUtil.updateSbiStartUp(StartUp);
							// session.invalidate();
							jsp = "/html/startup/startupResume.jsp";
							aq.setRenderParameter("jsp", jsp);
							clearSession(ar);
							// }
						}
					} catch (Exception e) {
						
						 e.printStackTrace();
						 Log.info(e);
					}
				} else {
					if (!captcha) {
						aq.setRenderParameter("hidegsr", "true");
						jsp = "view";
						System.out.println("param " + ar.getParameter("jsp"));
						aq.setRenderParameter("jsp", jsp);

					} else {
						aq.setRenderParameter("hidegsr", "false");

						jsp = "/html/startup/startupResume.jsp";
						aq.setRenderParameter("jsp", jsp);
					}
				}

	}

	private void clearSession(PortletRequest request) {

		PortletSession sessionp = request.getPortletSession();

		sessionp.removeAttribute("registered_name");

		sessionp.removeAttribute("constitution");

		sessionp.removeAttribute("corporate_website");

		sessionp.removeAttribute("corporate_email");

		sessionp.removeAttribute("initial_founders");

		sessionp.removeAttribute("excluding_promoters");

		sessionp.removeAttribute("description_of_product");

		sessionp.removeAttribute("financial_assi_purp");

		sessionp.removeAttribute("initial_capital");

		sessionp.removeAttribute("monetary_value");

		sessionp.removeAttribute("business_model");

		sessionp.removeAttribute("current_capital");

		sessionp.removeAttribute("capital_infusion");

		sessionp.removeAttribute("gross_revenue_year2_investors");

		sessionp.removeAttribute("valuation_amount");

		sessionp.removeAttribute("Loans_availed");

		sessionp.removeAttribute("valuer_name");

		sessionp.removeAttribute("valuation_amount_rs");

		sessionp.removeAttribute("loan_avail_rs");

		sessionp.removeAttribute("revenue_project_year1");

		sessionp.removeAttribute("revenue_project_year2");

		sessionp.removeAttribute("revenue_project_year3");

		sessionp.removeAttribute("gross_projected_revenue_rs1");

		sessionp.removeAttribute("gross_projected_revenue_rs2");

		sessionp.removeAttribute("gross_projected_revenue_rs3");

		sessionp.removeAttribute("gross_revenue_year1");

		sessionp.removeAttribute("gross_revenue_rs1");

		sessionp.removeAttribute("gross_revenue_year2");

		sessionp.removeAttribute("gross_revenue_rs2");

		sessionp.removeAttribute("gross_revenue_year3");

		sessionp.removeAttribute("gross_revenue_rs3");

		sessionp.removeAttribute("ebidta_rs1");

		sessionp.removeAttribute("ebidta_rs2");

		sessionp.removeAttribute("cp_promoters_amounts");

		sessionp.removeAttribute("cp_promoters_addresses");

		sessionp.removeAttribute("cp_promoters_names");

		sessionp.removeAttribute("noofemp");

		sessionp.removeAttribute("ebidta_rs3");

		sessionp.removeAttribute("net_profit");

		sessionp.removeAttribute("net_profit_rs1");

		sessionp.removeAttribute("net_profit_rs2");

		sessionp.removeAttribute("net_profit_rs3");

		sessionp.removeAttribute("financial_bank_engagement");

		sessionp.removeAttribute("financial_assistance");

		sessionp.removeAttribute("revenue_projections");

		sessionp.removeAttribute("agreeable_process");

		sessionp.removeAttribute("startupindia");

		sessionp.removeAttribute("incubator");

		sessionp.removeAttribute("address_line_1");

		sessionp.removeAttribute("address_line_2");

		sessionp.removeAttribute("address_city");

		sessionp.removeAttribute("address_pin");

		sessionp.removeAttribute("address_landmark");

		sessionp.removeAttribute("address_state");

	}

	@SuppressWarnings("unchecked")
	public void serveResource(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws IOException,
			PortletException {
		// ArrayList<Long> imageids = new ArrayList<Long>();
		if (resourceRequest.getResourceID().equals("resumeUrl")) {

			saveResumeForm(resourceRequest, resourceResponse, true); // true
			// false
			// is to
			// check
			// if
			// this
			// is a
			// final
			// submit
			// of
			// resume
			// form
			// HttpServletRequest =
			// PortalUtil.getHttpServletRequest(resourceRequest);
			PortletSession sessionp = resourceRequest.getPortletSession(true);
			sessionp.setAttribute("resumeId", "");

			// System.out.println("--AFter Submit ----"+(String)sessionp.getAttribute("resumeId"));

		}// Update status in database
		else if (resourceRequest.getResourceID().equals("setStatus")) {

			int total = Integer.parseInt(resourceRequest.getParameter("total"));

			String ajaxString = resourceRequest.getParameter("ajaxdata");

			DynamicQuery query = DynamicQueryFactoryUtil
					.forClass(ResumeDtls.class);
			Criterion criterion = RestrictionsFactoryUtil.eq("RegNum",
					ajaxString);
			Criterion crit2 = RestrictionsFactoryUtil.eq("flag", true);
			Junction conjunction = RestrictionsFactoryUtil.conjunction();
			conjunction.add(criterion);
			conjunction.add(crit2);
			query.add(conjunction);
			List<ResumeDtls> list = null;

			JSONObject json = new JSONObject();
			try {
				list = (List) ResumeDtlsLocalServiceUtil.dynamicQuery(query);

				if (list.size() == total) {

					SbiStartUpLocalServiceUtil.updatestatus(ajaxString);
					// sendmail();

					// String emailbody =
					// PortletProps.get("entity.sbi.startup.mail.template.user");
					StringBuilder sb = new StringBuilder();
					sb.append("<html><head><title>Start Up Email</title></head><body>");
					sb.append("<div><h2>Dear Start-up Applicant,</h2><p>Thank you for submitting the application , which we will process and advice you suitably.</p><p>The reference number of your application is : <b>regNum</b></p><p>You can also check the status of the application at");
					sb.append("<a href=\"https://www.sbi.co.in/portal/web/services/status-enquiryversion1\" target=\"_blank\"> https://www.sbi.co.in/portal/web/services/status-enquiryversion1</a></p>");
					sb.append("<p>&nbsp;</p>");
					sb.append("<div>");
					sb.append("<h4>Team IT-Innovation & Quick Wins</h4>");
					sb.append("<p>State Bank Of India</p>");
					sb.append("<p>Global IT Center</p>");
					sb.append("<p>Sector 11, CBD Belapur</p>");
					sb.append("<p>Navi Mumbai - 400614</p>");
					sb.append("<p>Landline : 022 - 27566043</p>");
					sb.append("<p>Email : <a href=\"mailto:startup@sbi.co.in\">startup@sbi.co.in</a></p>");
					sb.append("</div>");
					sb.append("</body>");
					sb.append("</html>");
					String emailbody = sb.toString().replace("regNum",
							ajaxString);
					SbiStartUp sbiStartup = null;

					try {
						sbiStartup = SbiStartUpLocalServiceUtil
								.getSbiStartUp(ajaxString);
					} catch (PortalException e) {
						
						// TODO Auto-generated catch block
						 e.printStackTrace();
						 Log.info(e);
					} catch (SystemException e) {
						
						// TODO Auto-generated catch block
						 e.printStackTrace();
						 Log.info(e);
					}

					try {
						String emailUser = sbiStartup.getCorporate_email();
						sendMail(
								emailUser,
								PortletProps
								.get("entity.sbi.startup.mail.subject"),
								emailbody);

						/**
						 * 
						 * Sending Mail to Admin
						 * 
						 */

						// emailbody =
						// PortletProps.get("entity.sbi.startup.mail.template.admin");

						sb = new StringBuilder();
						Date createDate = sbiStartup.getCreateDate();
						String date = "";
						DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
						date = format.format(createDate);

						sb.append("<html><head></head><body><div><p>Start-up <b>Name</b> has submitted an application with reference number regNum on date</p>");
						sb.append("<p>Please take up for processing.</p></span></div></div></body></html>");
						String k = sb.toString();
						emailbody = k.replace("regNum", ajaxString);
						emailbody = emailbody.replace("date", date);
						emailbody = emailbody.replace("Name", sbiStartup
								.getRegistered_name().toString());
						// String emailAdmin= "startup@sbi.co.in";
						String emailAdmin = "dev_liferay.satyam@sbi.co.in";
						// String emailAdmin =
						// PortletProps.get("entity.sbi.startup.mail.adminemail");
						sendMail(
								emailAdmin,
								PortletProps
								.get("entity.sbi.startup.mail.subject"),
								emailbody);

					} catch (Exception ex) {
						
						Log.error("mail config issue", ex);
						// logger.info(ex);
		

					}

					PortletSession session = resourceRequest
							.getPortletSession();
					session.setAttribute("regnum", "");
					PrintWriter pw = resourceResponse.getWriter();

					json.put("key", "success");
					pw.print(json);
					pw.flush();
					pw.close();

				} else {
					PrintWriter pw = resourceResponse.getWriter();
					json.put("key", "error");
					pw.print(json);
					pw.flush();
					pw.close();
				}
			} catch (Exception ex) {
				// ex.printStackTrace();
				Log.info(ex);
			}
		} else if (resourceRequest.getResourceID().equals("captchaURL")) {
			// System.out.println("in captch");
			// System.out.println("captchaURL");
			try {
				// PortletSession session =
				// resourceRequest.getPortletSession(true);
				com.liferay.portal.kernel.captcha.CaptchaUtil.serveImage(
						resourceRequest, resourceResponse);

			} catch (Exception e) {
				Log.info(e);
				
				// TODO: handle exception

			}
		}

		else if (resourceRequest.getResourceID().equals("captchaURL1")) {
			// System.out.println("in captch");
			int width = 100;
			int height = 35;
			Random rdm = new Random();
			int rl = rdm.nextInt();

			String hash1 = Integer.toHexString(rl);

			String capstr = hash1.substring(0, 5);
			capstr = capstr.toUpperCase();
			PortletSession session = resourceRequest.getPortletSession();
			session.setAttribute("captchaURL1", capstr);

			Color background = new Color(215, 255, 245);

			Color fbl = new Color(0, 0, 0);

			Font fnt = new Font("Lucida Calligraphy", 1, 18);

			BufferedImage cpimg = new BufferedImage(width, height,
					BufferedImage.TYPE_INT_RGB);

			Graphics g = cpimg.createGraphics();

			g.setColor(background);

			g.fillRect(1, 1, width, height);

			g.setColor(fbl);

			g.setFont(fnt);

			g.drawString(capstr, 10, 25);

			g.setColor(background);

			// g.drawLine(10,17,80,17);

			// g.drawLine(10,22,80,22);
			resourceResponse.setContentType("image/jpeg");

			OutputStream strm = resourceResponse.getPortletOutputStream();

			ImageIO.write(cpimg, "jpeg", strm);
			strm.close();
		}

		else if (resourceRequest.getResourceID().equals("resetRegNum")) {
			System.out.println("in reset");
			// HttpServletRequest =
			// PortalUtil.getHttpServletRequest(resourceRequest);
			// System.out.println("===Reset reg num");
			PortletSession sessionp = resourceRequest.getPortletSession(true);
			// sessionp.setAttribute("regnum", "");
			sessionp.removeAttribute("regnum");
			// sessionp.setAttribute("capInfuKeys", "");
			sessionp.removeAttribute("capInfuKeys");
			sessionp.removeAttribute("StartUp");
			sessionp.removeAttribute("resumedetailspdf");
			sessionp.removeAttribute("registered_name");
			sessionp.removeAttribute("date_of_establishment");
			sessionp.removeAttribute("constitution");
			sessionp.removeAttribute("corporate_website");
			sessionp.removeAttribute("corporate_email");
			sessionp.removeAttribute("initial_founders");
			sessionp.removeAttribute("excluding_promoters");
			sessionp.removeAttribute("description_of_product");
			sessionp.removeAttribute("financial_assi_purp");
			sessionp.removeAttribute("initial_capital");
			sessionp.removeAttribute("monetary_value");
			sessionp.removeAttribute("business_model");
			sessionp.removeAttribute("current_capital");
			sessionp.removeAttribute("capital_infusion");
			sessionp.removeAttribute("gross_revenue_year2_investors");
			sessionp.removeAttribute("valuation_amount");
			sessionp.removeAttribute("Loans_availed");
			sessionp.removeAttribute("valuer_name");
			sessionp.removeAttribute("valuation_date");
			sessionp.removeAttribute("valuation_amount_rs");
			sessionp.removeAttribute("loan_avail_source");
			sessionp.removeAttribute("loan_avail_rs");
			sessionp.removeAttribute("revenue_project_year1");
			sessionp.removeAttribute("revenue_project_year2");
			sessionp.removeAttribute("revenue_project_year3");
			sessionp.removeAttribute("gross_projected_revenue_rs1");
			sessionp.removeAttribute("gross_projected_revenue_rs2");
			sessionp.removeAttribute("gross_projected_revenue_rs3");
			sessionp.removeAttribute("gross_revenue_year1");
			sessionp.removeAttribute("gross_revenue_rs1");
			sessionp.removeAttribute("gross_revenue_year2");
			sessionp.removeAttribute("gross_revenue_rs2");
			sessionp.removeAttribute("gross_revenue_year3");
			sessionp.removeAttribute("gross_revenue_rs3");
			sessionp.removeAttribute("ebidta_rs1");
			sessionp.removeAttribute("ebidta_rs2");
			sessionp.removeAttribute("cp_promoters_amounts");
			sessionp.removeAttribute("cp_promoters_addresses");
			sessionp.removeAttribute("cp_promoters_names");
			sessionp.removeAttribute("noofemp");
			sessionp.removeAttribute("ebidta_rs3");
			sessionp.removeAttribute("net_profit");
			sessionp.removeAttribute("net_profit_rs1");
			sessionp.removeAttribute("net_profit_rs2");
			sessionp.removeAttribute("net_profit_rs3");
			sessionp.removeAttribute("financial_bank_engagement");
			sessionp.removeAttribute("financial_assistance");
			sessionp.removeAttribute("revenue_projections");
			sessionp.removeAttribute("agreeable_process");
			sessionp.removeAttribute("startupindia");
			sessionp.removeAttribute("incubator");
			sessionp.removeAttribute("address_line_1");
			sessionp.removeAttribute("address_line_2");
			sessionp.removeAttribute("address_city");
			sessionp.removeAttribute("address_pin");
			sessionp.removeAttribute("address_landmark");
			sessionp.removeAttribute("address_state");
		}

		// Added by Syed
		else if (resourceRequest.getResourceID().equals("downloadpdfURL")) {

			PortletSession sessionp = resourceRequest.getPortletSession(true);
			// HttpServletRequest httpreq =
			// PortalUtil.getHttpServletRequest(resourceRequest);
			// HttpSession sessionp = httpreq.getSession(true);

			String userString = resourceRequest.getParameter("regnum");
			SbiStartUp startup = (SbiStartUp) sessionp.getAttribute("StartUp");
			// ResumeDtls resumeList
			// =(ResumeDtls)sessionp.getAttribute("resumedetailspdf");
			// CapitalInf capitalinf
			// =(CapitalInf)sessionp.getAttribute("capinfulist");

			convertToPdf(startup, userString, resourceResponse, resourceRequest);

			/*
			 * resourceResponse.setProperty("path", path); JSONObject json =
			 * (JSONObject) JSONFactoryUtil.createJSONObject();
			 * json.put("jsonData", path);
			 * resourceResponse.getWriter().write(json.toString());
			 */
		}

		else if (resourceRequest.getResourceID().equals("saveForm")) {

			saveForm(resourceRequest, resourceResponse);

		}

		else if (resourceRequest.getResourceID().equals("fetchForm")) {

			fetchForm(resourceRequest, resourceResponse);
		}

		else if (resourceRequest.getResourceID().equals("saveResumeForm")) {

			saveResumeForm(resourceRequest, resourceResponse, false);
		}

		else if (resourceRequest.getResourceID().equalsIgnoreCase(
				"fetchResumeForm")) {

			fetchResumeForm(resourceRequest, resourceResponse);
		}
	}

	private void saveResumeForm(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse, boolean isFinalSubmit) {

		Date Dob1 = new Date();

		// System.out.println("--- is FinalSubmit Resume Form .................---"+isFinalSubmit);

		// HttpServletRequest =
		// PortalUtil.getHttpServletRequest(resourceRequest);
		PortletSession sessionp = resourceRequest.getPortletSession(true);
		String resumeId = (String) sessionp.getAttribute("resumeId") != null ? (String) sessionp
				.getAttribute("resumeId") : "";
				System.out.println("--- Resume Id ---" + resumeId);
				String name = resourceRequest.getParameter("name");
				String Email = resourceRequest.getParameter("Email");
				String Mnumber = resourceRequest.getParameter("Mnumber");
				String Dob = resourceRequest.getParameter("Dob");
				String r_address_line_1 = resourceRequest
						.getParameter("r_address_line_1");
				String r_address_line_2 = resourceRequest
						.getParameter("r_address_line_2");
				String r_address_landmark = resourceRequest
						.getParameter("r_address_landmark");
				String r_address_city = resourceRequest.getParameter("r_address_city");
				String r_address_pin = resourceRequest.getParameter("r_address_pin");
				String r_address_state = resourceRequest
						.getParameter("r_address_state");
				String perm_address_line_1 = resourceRequest
						.getParameter("perm_address_line_1");
				String perm_address_line_2 = resourceRequest
						.getParameter("perm_address_line_2");
				String perm_address_landmark = resourceRequest
						.getParameter("perm_address_landmark");
				String perm_address_city = resourceRequest
						.getParameter("perm_address_city");
				String perm_address_pin = resourceRequest
						.getParameter("perm_address_pin");
				String perm_address_state = resourceRequest
						.getParameter("perm_address_state");
				String Pan = resourceRequest.getParameter("Pan");
				String AadharNum = resourceRequest.getParameter("AadharNum");
				String CarrerAspect = resourceRequest.getParameter("CarrerAspect");
				String KeyITSkill = resourceRequest.getParameter("KeyITSkill");
				String CertfTra = resourceRequest.getParameter("CertfTra");
				String EmpyHistory = resourceRequest.getParameter("EmpyHistory");
				String CoreComp = resourceRequest.getParameter("CoreComp");
				String Accomplishment = resourceRequest.getParameter("Accomplishment");
				String Academics = resourceRequest.getParameter("Academics");
				String regNum = resourceRequest.getParameter("regnum");
				String indexno = resourceRequest.getParameter("indexno");
				ResumeDtls StartUpResumedtls = new ResumeDtlsImpl();
				Date d = new Date();
				try {
					DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
					Date date = format.parse(Dob);
					// Date Dob1 = new Date() ;
					Dob1 = date;
					// System.out.println("---dob1"+Dob1);
				} catch (Exception e) {
					// logger.error(e);

					Log.info("check the date format");
					// System.out.println("====ex");
				}
				if (resumeId.equals("")) {
					try {
						long l = CounterLocalServiceUtil.increment(ResumeDtls.class
								.getName());

						StartUpResumedtls.setCreateDate(d);
						StartUpResumedtls.setModifiedDate(d);
						StartUpResumedtls.setResumeId(l);
						StartUpResumedtls.setRegNum(regNum);
						StartUpResumedtls.setName(name);
						StartUpResumedtls.setEmail(Email);
						StartUpResumedtls.setMnumber(Mnumber);
						StartUpResumedtls.setDob(Dob1);
						StartUpResumedtls.setAddress_line_1(r_address_line_1);
						StartUpResumedtls.setAddress_line_2(r_address_line_2);
						StartUpResumedtls.setAddress_landmark(r_address_landmark);
						StartUpResumedtls.setAddress_city(r_address_city);
						StartUpResumedtls.setAddress_pin(r_address_pin);
						StartUpResumedtls.setAddress_state(r_address_state);
						StartUpResumedtls.setPerm_address_line_1(perm_address_line_1);
						StartUpResumedtls.setPerm_address_line_2(perm_address_line_2);
						StartUpResumedtls
						.setPerm_address_landmark(perm_address_landmark);
						StartUpResumedtls.setPerm_address_city(perm_address_city);
						StartUpResumedtls.setPerm_address_pin(perm_address_pin);
						StartUpResumedtls.setPerm_address_state(perm_address_state);
						StartUpResumedtls.setPan(Pan);
						StartUpResumedtls.setAadharNum(AadharNum);
						StartUpResumedtls.setCarrerAspect(CarrerAspect);
						StartUpResumedtls.setKeyITSkill(KeyITSkill);
						StartUpResumedtls.setCertfTra(CertfTra);
						StartUpResumedtls.setEmpyHistory(EmpyHistory);
						StartUpResumedtls.setCoreComp(CoreComp);
						StartUpResumedtls.setAccomplishment(Accomplishment);
						StartUpResumedtls.setAcademics(Academics);
						StartUpResumedtls.setIndexno(indexno);
						StartUpResumedtls.setFlag(isFinalSubmit);
						sessionp.setAttribute("resumeId", Long.toString(l));

						ResumeDtlsLocalServiceUtil.addResumeDtls(StartUpResumedtls);
						sessionp.setAttribute("resumedetailspdf", StartUpResumedtls);
					} catch (Exception e) {
						// logger.error(e);
						// e.printStackTrace();
						Log.info(e);
					}
				} else {
					try {
						StartUpResumedtls = ResumeDtlsLocalServiceUtil
								.fetchResumeDtls(Long.parseLong(resumeId));
						StartUpResumedtls.setCreateDate(d);
						StartUpResumedtls.setModifiedDate(d);
						StartUpResumedtls.setName(name);
						StartUpResumedtls.setEmail(Email);
						StartUpResumedtls.setMnumber(Mnumber);
						StartUpResumedtls.setDob(Dob1);
						StartUpResumedtls.setAddress_line_1(r_address_line_1);
						StartUpResumedtls.setAddress_line_2(r_address_line_2);
						StartUpResumedtls.setAddress_landmark(r_address_landmark);
						StartUpResumedtls.setAddress_city(r_address_city);
						StartUpResumedtls.setAddress_pin(r_address_pin);
						StartUpResumedtls.setAddress_state(r_address_state);
						StartUpResumedtls.setPerm_address_line_1(perm_address_line_1);
						StartUpResumedtls.setPerm_address_line_2(perm_address_line_2);
						StartUpResumedtls
						.setPerm_address_landmark(perm_address_landmark);
						StartUpResumedtls.setPerm_address_city(perm_address_city);
						StartUpResumedtls.setPerm_address_pin(perm_address_pin);
						StartUpResumedtls.setPerm_address_state(perm_address_state);
						StartUpResumedtls.setPan(Pan);
						StartUpResumedtls.setAadharNum(AadharNum);
						StartUpResumedtls.setCarrerAspect(CarrerAspect);
						StartUpResumedtls.setKeyITSkill(KeyITSkill);
						StartUpResumedtls.setCertfTra(CertfTra);
						StartUpResumedtls.setEmpyHistory(EmpyHistory);
						StartUpResumedtls.setCoreComp(CoreComp);
						StartUpResumedtls.setAccomplishment(Accomplishment);
						StartUpResumedtls.setAcademics(Academics);
						StartUpResumedtls.setFlag(isFinalSubmit);
						ResumeDtlsLocalServiceUtil.updateResumeDtls(StartUpResumedtls);
						sessionp.setAttribute("resumedetailspdf", StartUpResumedtls);
					} catch (NumberFormatException e) {
						
						// TODO Auto-generated catch block
						 e.printStackTrace();
						 Log.info(e);
					} catch (SystemException e) {
						
						// TODO Auto-generated catch block
						 e.printStackTrace();
						 Log.info(e);
					}

				}

	}

	@SuppressWarnings("unchecked")
	private void fetchForm(ResourceRequest request, ResourceResponse response) {
		String regNum = request.getParameter("regNum") != null ? request
				.getParameter("regNum") : "";
				System.out.println("--- fetchForm Reg Num---" + regNum);
				String doe = request.getParameter("date_of_establishment");
				JSONObject jsonObject = new JSONObject();
				// System.out.println("-- Fetch Form ---"+doe);

				PrintWriter pw = null;
				boolean validation = false;
				String enteredCaptchaText = ParamUtil.getString(request, "captchaText");
				// System.out.println("---- Entered Captcha Text ----"+enteredCaptchaText);
				PortletSession session = request.getPortletSession(true);
				String captchaText = (String) session.getAttribute("captchaURL1");
				// System.out.println("---- From Session ----"+captchaText);
				if (Validator.isNull(captchaText)) {

					jsonObject.put("captcha", "Captcha is mandatory.");

					try {
						pw = response.getWriter();
						pw.print(jsonObject);
						pw.flush();
						pw.close();
					} catch (IOException e1) {
						Log.info(e1);
						
						// TODO Auto-generated catch block
					}

				} else if (!captchaText.equals(enteredCaptchaText)) {

					jsonObject.put("error", "Please Enter Valid Captcha.");

					try {
						pw = response.getWriter();
						pw.print(jsonObject);
						pw.flush();
						pw.close();
					} catch (IOException e1) {
						
						Log.info(e1);

					}
				} else {
					DynamicQuery query = DynamicQueryFactoryUtil
							.forClass(SbiStartUp.class);
					Criterion criterion = RestrictionsFactoryUtil.eq("regnum", regNum);
					query.add(criterion);
					List<SbiStartUp> list = null;
					try {
						list = (List) SbiStartUpLocalServiceUtil.dynamicQuery(query);
						if (list.size() > 0) {

							String status = list.get(0).getStatus();
							if (status.equalsIgnoreCase("Applied")
									|| status.equalsIgnoreCase("Submitted")) {
								// System.out.println("--- Your application has already been submitted");
								jsonObject.put("error",
										"Your application has already been submitted.");
							} else {
								boolean flag = list.get(0).getFlag();
								String promoters = list.get(0)
										.getCurrent_promoters_name();
								HttpServletRequest httpreq = PortalUtil
										.getHttpServletRequest(request);
								httpreq.setAttribute("regnum", regNum);
								PortletSession sessionp = request
										.getPortletSession(true);
								Date dbDate = list.get(0).getDate_of_establishment();

								DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
								String date = format.format(dbDate);

								if (flag == true) {
									if (date.equals(doe)) {
										jsonObject.put("promoters", promoters);
										jsonObject.put("error", "redirect");
									} else {
										jsonObject.put("error", "No Records Found,");
									}
								} else {
									if (date.equals(doe)) {
										jsonObject = createJSONResponse(list, regNum,
												request);
										sessionp.setAttribute("regnum", regNum);
									} else {
										jsonObject.put("error", "No Records Found,");
									}
								}
							}
						} else {
							jsonObject.put("error", "No Records Found,");
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						// System.out.println("---Portal exception not found ---");
						jsonObject.put("error", "No Records Found.");
					}
					try {
						pw = response.getWriter();
						pw.print(jsonObject);
						pw.flush();
						pw.close();
					} catch (IOException e1) {
						Log.info(e1);
						

					}
				}
	}

	private void fetchResumeForm(ResourceRequest request,
			ResourceResponse response) {

		String regNum = request.getParameter("regnum");
		String indexno = request.getParameter("indexno");

		// System.out.println("fetch"+param);
		// String[] values = param.split("~");
		// regNum = values[0];
		// indexno = values[1];
		SbiStartUp StartUp = null;
		JSONObject jsonObject = new JSONObject();
		// System.out.println("--fetchResumeForm ---"+indexno);
		// System.out.println("--fetchResumeForm Reg Num---"+regNum);
		PrintWriter pw = null;

		DynamicQuery query = DynamicQueryFactoryUtil.forClass(ResumeDtls.class);
		Criterion criterion = RestrictionsFactoryUtil.eq("RegNum", regNum);
		Criterion crit2 = RestrictionsFactoryUtil.eq("indexno", indexno);

		Junction conjunction = RestrictionsFactoryUtil.conjunction();
		conjunction.add(criterion);
		conjunction.add(crit2);

		query.add(conjunction);

		List<ResumeDtls> list = null;
		try {
			list = (List) ResumeDtlsLocalServiceUtil.dynamicQuery(query);
			// System.out.println("-- List Size --"+list.size());
			// HttpServletRequest = PortalUtil.getHttpServletRequest(request);
			PortletSession sessionp = request.getPortletSession(true);

			if (list.size() > 0) {

				Date dob = list.get(0).getDob();
				DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
				String date = format.format(dob);
				// Date Dob1 = new Date() ;

				sessionp.setAttribute("resumeId",
						Long.toString(list.get(0).getResumeId()));
				// System.out.println("--Fetch form resume Id ---"+Long.toString(list.get(0).getResumeId()));
				// System.out.println("--list.get(0).getName()"+list.get(0).getName());
				jsonObject.put("Email", list.get(0).getEmail().toString());
				jsonObject.put("Mnumber", list.get(0).getMnumber().toString());
				jsonObject.put("Dob", date);
				jsonObject.put("r_address_line_1", list.get(0)
						.getAddress_line_1().toString());
				jsonObject.put("r_address_line_2", list.get(0)
						.getAddress_line_2().toString());
				jsonObject.put("r_address_landmark", list.get(0)
						.getAddress_landmark().toString());
				jsonObject.put("r_address_city", list.get(0).getAddress_city()
						.toString());
				jsonObject.put("r_address_pin", list.get(0).getAddress_pin()
						.toString());
				jsonObject.put("r_address_state", list.get(0)
						.getAddress_state().toString());

				jsonObject.put("perm_address_line_1", list.get(0)
						.getPerm_address_line_1().toString());
				jsonObject.put("perm_address_line_2", list.get(0)
						.getPerm_address_line_2().toString());
				jsonObject.put("perm_address_landmark", list.get(0)
						.getPerm_address_landmark().toString());
				jsonObject.put("perm_address_city", list.get(0)
						.getPerm_address_city().toString());
				jsonObject.put("perm_address_pin", list.get(0)
						.getPerm_address_pin().toString());
				jsonObject.put("perm_address_state", list.get(0)
						.getPerm_address_state().toString());
				jsonObject.put("Pan", list.get(0).getPan().toString());
				jsonObject.put("AadharNum", list.get(0).getAadharNum()
						.toString());
				jsonObject.put("CarrerAspect", list.get(0).getCarrerAspect()
						.toString());
				jsonObject
				.put("CertfTra", list.get(0).getCertfTra().toString());
				jsonObject.put("EmpyHistory", list.get(0).getEmpyHistory()
						.toString());
				jsonObject
				.put("CoreComp", list.get(0).getCoreComp().toString());
				jsonObject.put("Accomplishment", list.get(0)
						.getAccomplishment().toString());
				jsonObject.put("Academics", list.get(0).getAcademics()
						.toString());

			} else {
				sessionp.setAttribute("resumeId", "");
			}
		} catch (Exception ex) {
			Log.info(ex);

		}
		try {
			pw = response.getWriter();
			pw.print(jsonObject);
			pw.flush();
			pw.close();
		} catch (IOException e1) {
			
			Log.info(e1);
			// TODO Auto-generated catch block

		}

	}

	@SuppressWarnings("unchecked")
	private JSONObject createJSONResponse(List<SbiStartUp> list, String regNum,
			PortletRequest request) {

		// System.out.println("Regnum"+regNum);
		Date dob = list.get(0).getDate_of_establishment();
		Date valuationDate = list.get(0).getValuation_date();
		PortletSession session = request.getPortletSession();

		DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		String date = format.format(dob);
		String valueDate = "";
		try {
			if (valuationDate != null)
				valueDate = format.format(valuationDate);
		} catch (Exception ex) {
			
			 ex.printStackTrace();
			 Log.info(ex);
		}

		// System.out.println("===Date"+date);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("error", "");
		jsonObject.put("registered_name", list.get(0).getRegistered_name()
				.toString());
		jsonObject.put("date_of_establishment", date);
		jsonObject
		.put("constitution", list.get(0).getConstitution().toString());
		jsonObject.put("address_line_1", list.get(0).getAddress_line_1()
				.toString());
		jsonObject.put("address_line_2", list.get(0).getAddress_line_2()
				.toString());
		jsonObject
		.put("address_city", list.get(0).getAddress_city().toString());
		jsonObject.put("address_landmark", list.get(0).getAddress_landmark()
				.toString());
		jsonObject.put("address_pin", list.get(0).getAddress_pin().toString());
		jsonObject.put("address_state", list.get(0).getAddress_state()
				.toString());
		jsonObject.put("corporate_email", list.get(0).getCorporate_email()
				.toString());
		jsonObject.put("corporate_website", list.get(0).getCorporate_website()
				.toString());
		jsonObject.put("noofemp", list.get(0).getNoofemp().toString());
		jsonObject.put("description_of_product", list.get(0)
				.getDescription_of_product().toString());
		jsonObject.put("business_model", list.get(0).getBusiness_model());
		jsonObject.put("monetary_value", list.get(0).getMonetary_value()
				.toString());
		jsonObject.put("initial_capital", list.get(0).getInitial_capital()
				.toString());
		jsonObject.put("current_capital", list.get(0).getCurrent_capital()
				.toString());
		jsonObject.put("valuer_name", list.get(0).getValuer_name().toString());
		jsonObject.put("valuation_date", valueDate);
		jsonObject.put("valuation_amount_rs", list.get(0)
				.getValuation_amount_rs().toString());
		jsonObject.put("loan_avail_source", list.get(0).getLoan_avail_source()
				.toString());
		jsonObject.put("loan_avail_rs", list.get(0).getLoan_avail_rs()
				.toString());

		jsonObject.put("gross_revenue_rs1", list.get(0).getGross_revenue_rs1()
				.toString());
		jsonObject.put("ebidta_rs1", list.get(0).getEbidta_rs1().toString());
		jsonObject.put("net_profit_rs1", list.get(0).getNet_profit_rs1()
				.toString());

		jsonObject.put("gross_revenue_rs2", list.get(0).getGross_revenue_rs2()
				.toString());
		jsonObject.put("ebidta_rs2", list.get(0).getEbidta_rs2().toString());
		jsonObject.put("net_profit_rs2", list.get(0).getNet_profit_rs2()
				.toString());

		jsonObject.put("gross_revenue_rs3", list.get(0).getGross_revenue_rs3()
				.toString());
		jsonObject.put("ebidta_rs3", list.get(0).getEbidta_rs3().toString());
		jsonObject.put("net_profit_rs3", list.get(0).getNet_profit_rs3()
				.toString());
		jsonObject.put("initial_founders", list.get(0).getInitial_founders()
				.toString());
		jsonObject.put("current_promoters_name", list.get(0)
				.getCurrent_promoters_name().toString());
		jsonObject.put("financial_bank_engagement", list.get(0)
				.getFinancial_bank_engagement().toString());
		jsonObject.put("financial_assistance", list.get(0)
				.getFinancial_assistance().toString());
		jsonObject.put("financial_assistance_purpose", list.get(0)
				.getFinancial_assi_purp().toString());
		jsonObject.put("gross_projected_revenue_rs1", list.get(0)
				.getProjected_revenue_rs1().toString());
		jsonObject.put("gross_projected_revenue_rs2", list.get(0)
				.getProjected_revenue_rs2().toString());
		jsonObject.put("gross_projected_revenue_rs3", list.get(0)
				.getProjected_revenue_rs3().toString());
		jsonObject.put("incubator", list.get(0).getIncubator().toString());
		jsonObject.put("agreeable_process", list.get(0).getAgreeable_process()
				.toString());
		jsonObject
		.put("startupindia", list.get(0).getStartupindia().toString());
		System.out.println("list.get(0).getInitial_founders().toString()"
				+ list.get(0).getInitial_founders().toString());

		String[] initialFoundersLength = list.get(0).getInitial_founders()
				.toString().split(",");

		System.out.println("--- Initial Founders Length ---"
				+ initialFoundersLength.length);

		jsonObject.put("initialFoundersTotal",
				Integer.toString(initialFoundersLength.length));
		DynamicQuery query2 = DynamicQueryFactoryUtil
				.forClass(CapitalInf.class);
		Criterion criterion2 = null;
		criterion2 = RestrictionsFactoryUtil.eq("RegNum", regNum);
		query2.add(criterion2);
		String capName = "";
		String capAdd = "";
		String capAmount = "";
		List<CapitalInf> list2 = null;
		String capitalInfuKeys = "";
		try {
			list2 = (List) CapitalInfLocalServiceUtil.dynamicQuery(query2);
			// System.out.println("list2(0)-----"+list2.size());
			if (list2.size() > 0) {
				for (int i = 0; i < list2.size(); i++) {
					capName += list2.get(i).getCp_promoters_name() + "$";
					capAdd += list2.get(i).getCp_promoters_address() + "$";
					capAmount += list2.get(i).getCp_promoters_amount() + "$";
					capitalInfuKeys += list2.get(i).getInfRefId() + ",";
				}

			}
			jsonObject.put("capName", capName);
			jsonObject.put("capAdd", capAdd);
			jsonObject.put("capAmount", capAmount);
			jsonObject.put("capInfuTotal", Integer.toString(list2.size()));
			session.setAttribute("capInfuKeys", capitalInfuKeys);
		} catch (Exception ex) {
			 ex.printStackTrace();
			
			 Log.info(ex);
		}

		return jsonObject;
	}

	private void saveForm(ResourceRequest request, ResourceResponse response) {

		System.out.println("--- in save form ---");
		String registered_name = "";
		String founders = "";
		String promoters = "";
		String capital_infusion = "";
		;
		String valuer_name = "";
		String valuation_amount_rs = "";
		String constitution = "";
		String address_line_1 = "";
		String address_line_2 = "";
		String address_landmark = "";
		String address_pin = "";
		String address_state = "";
		String address_city = "";
		String corporate_website = "";
		String corporate_email = "";
		String initial_founders = "";
		String noofemp = "";
		String cp_promoters_names = "";
		String cp_promoters_addresses = "";
		String cp_promoters_amounts = "";
		String excluding_promoters = "";
		String description_of_product = "";
		String initial_capital = "";
		String monetary_value = "";
		String business_model = "";
		String current_capital = "";
		String loan_avail_source = "";
		String loan_avail_rs = "";
		String gross_revenue_year1 = "";
		String gross_revenue_rs1 = "";
		String gross_revenue_year2 = "";
		String gross_revenue_rs2 = "";
		String revenue_project_year1 = "";
		String revenue_project_year2 = "";
		String revenue_project_year3 = "";
		String gross_projected_revenue_rs1 = "";
		String gross_projected_revenue_rs2 = "";
		String gross_projected_revenue_rs3 = "";
		String gross_revenue_year3 = "";
		String gross_revenue_rs3 = "";
		String ebidta_rs1 = "";
		String ebidta_rs2 = "";
		String ebidta_rs3 = "";
		String net_profit = "";
		String net_profit_rs1 = "";
		String net_profit_rs2 = "";
		String net_profit_rs3 = "";
		String financial_assistance = "";
		String financial_bank_engagement = "";
		String financial_assi_purp = "";
		String revenue_projections = "";
		String agreeable_process = "";
		String gsr_department = "";
		String startupindia = "";
		String incubator = "";
		String date_of_establishment = "";

		String valuation_date = "";
		Date doe = new Date();
		Date valuationDate = null;
		// HttpServletRequest = PortalUtil.getHttpServletRequest(request);
		PortletSession sessionp = request.getPortletSession(true);
		String regnum = (String) sessionp.getAttribute("regnum") != null ? (String) sessionp
				.getAttribute("regnum") : "";

				ThemeDisplay themeDisplay = (ThemeDisplay) request
						.getAttribute(WebKeys.THEME_DISPLAY);
				if (ParamUtil.getString(request, "founders", StringPool.BLANK) != null) {

					founders = (String) ParamUtil.getString(request, "founders",
							StringPool.BLANK);
					founders = ValidatorUtil.checkRemoveXSSVeranablity(founders);

				}
				if (ParamUtil.getString(request, "promoters", StringPool.BLANK) != null) {

					promoters = (String) ParamUtil.getString(request, "promoters",
							StringPool.BLANK);
					promoters = ValidatorUtil.checkRemoveXSSVeranablity(promoters);

				}

				if (ParamUtil.getString(request, "date_of_establishment",
						StringPool.BLANK) != null) {
					date_of_establishment = (String) ParamUtil.getString(request,
							"date_of_establishment", StringPool.BLANK);
					date_of_establishment = ValidatorUtil
							.checkRemoveXSSVeranablity(date_of_establishment);
					// System.out.println("----doe---"+date_of_establishment);

					try {
						DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
						Date date = format.parse(date_of_establishment);
						// Date Dob1 = new Date() ;
						doe = date;
						// System.out.println("==doe"+doe);
					} catch (Exception e) {
						Log.info("check the date formattt");
						
						// TODO: handle exception
						// System.out.println("exception---"+doe);
					}
				}

				if (ParamUtil.getString(request, "registered_name", StringPool.BLANK) != null) {
					registered_name = (String) ParamUtil.getString(request,
							"registered_name", StringPool.BLANK);
					registered_name = ValidatorUtil
							.checkRemoveXSSVeranablity(registered_name);
					// System.out.println("---registered_name"+registered_name);
				}

				if (ParamUtil.getString(request, "constitution", StringPool.BLANK) != null) {
					constitution = (String) ParamUtil.getString(request,
							"constitution", StringPool.BLANK);
					constitution = ValidatorUtil
							.checkRemoveXSSVeranablity(constitution);

				}

				if (ParamUtil.getString(request, "corporate_website", StringPool.BLANK) != null) {
					corporate_website = (String) ParamUtil.getString(request,
							"corporate_website", StringPool.BLANK);
					corporate_website = ValidatorUtil
							.checkRemoveXSSVeranablity(corporate_website);

				}

				if (ParamUtil.getString(request, "corporate_email", StringPool.BLANK) != null) {
					corporate_email = (String) ParamUtil.getString(request,
							"corporate_email", StringPool.BLANK);
					corporate_email = ValidatorUtil
							.checkRemoveXSSVeranablity(corporate_email);

				}
				if (ParamUtil.getString(request, "founders", StringPool.BLANK) != null) {
					initial_founders = (String) ParamUtil.getString(request,
							"founders", StringPool.BLANK);
					initial_founders = ValidatorUtil
							.checkRemoveXSSVeranablity(initial_founders);

				}

				if (ParamUtil.getString(request, "excluding_promoters",
						StringPool.BLANK) != null) {
					excluding_promoters = (String) ParamUtil.getString(request,
							"excluding_promoters", StringPool.BLANK);
					excluding_promoters = ValidatorUtil
							.checkRemoveXSSVeranablity(excluding_promoters);

				}

				if (ParamUtil.getString(request, "description_of_product",
						StringPool.BLANK) != null) {
					description_of_product = (String) ParamUtil.getString(request,
							"description_of_product", StringPool.BLANK);
					description_of_product = ValidatorUtil
							.checkRemoveXSSVeranablity(description_of_product);

				}
				if (ParamUtil.getString(request, "financial_assi_purp",
						StringPool.BLANK) != null) {
					financial_assi_purp = (String) ParamUtil.getString(request,
							"financial_assi_purp", StringPool.BLANK);
					financial_assi_purp = ValidatorUtil
							.checkRemoveXSSVeranablity(financial_assi_purp);

				}

				if (ParamUtil.getString(request, "initial_capital", StringPool.BLANK) != null) {
					initial_capital = (String) ParamUtil.getString(request,
							"initial_capital", StringPool.BLANK);
					initial_capital = ValidatorUtil
							.checkRemoveXSSVeranablity(initial_capital);
				}

				if (ParamUtil.getString(request, "monetary_value", StringPool.BLANK) != null) {
					monetary_value = (String) ParamUtil.getString(request,
							"monetary_value", StringPool.BLANK);
					monetary_value = ValidatorUtil
							.checkRemoveXSSVeranablity(monetary_value);
				}
				if (ParamUtil.getString(request, "business_model", StringPool.BLANK) != null) {
					business_model = (String) ParamUtil.getString(request,
							"business_model", StringPool.BLANK);
					business_model = ValidatorUtil
							.checkRemoveXSSVeranablity(business_model);
				}

				if (ParamUtil.getString(request, "current_capital", StringPool.BLANK) != null) {
					current_capital = (String) ParamUtil.getString(request,
							"current_capital", StringPool.BLANK);
					current_capital = ValidatorUtil
							.checkRemoveXSSVeranablity(current_capital);

				}

				if (ParamUtil.getString(request, "capital_infusion", StringPool.BLANK) != null) {
					capital_infusion = (String) ParamUtil.getString(request,
							"capital_infusion", StringPool.BLANK);

				}

				if (ParamUtil.getString(request, "valuation_amount", StringPool.BLANK) != null) {
					valuation_amount = (String) ParamUtil.getString(request,
							"valuation_amount", StringPool.BLANK);

				}

				if (ParamUtil.getString(request, "valuation_date", StringPool.BLANK) != null) {
					valuation_date = (String) ParamUtil.getString(request,
							"valuation_date", StringPool.BLANK);
					valuation_date = ValidatorUtil
							.checkRemoveXSSVeranablity(valuation_date);
					System.out.println("-- valuation date ---" + valuation_date);
					try {

						DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
						if (!valuation_date.equalsIgnoreCase("")) {
							Date date = format.parse(valuation_date);
							// Date Dob1 = new Date() ;
							valuationDate = date;
						}
						// System.out.println("==valuationDate"+valuationDate);
					} catch (Exception e) {
						
						Log.info("check the date format");
						// TODO: handle exception
						// System.out.println("exception---"+doe);
					}
				}

				if (ParamUtil.getString(request, "valuer_name", StringPool.BLANK) != null) {
					valuer_name = (String) ParamUtil.getString(request, "valuer_name",
							StringPool.BLANK);

				}

				if (ParamUtil.getString(request, "valuation_amount_rs",
						StringPool.BLANK) != null) {
					valuation_amount_rs = (String) ParamUtil.getString(request,
							"valuation_amount_rs", StringPool.BLANK);

					valuation_amount_rs = ValidatorUtil
							.checkRemoveXSSVeranablity(valuation_amount_rs);

				}

				if (ParamUtil.getString(request, "loan_avail_source", StringPool.BLANK) != null) {
					loan_avail_source = (String) ParamUtil.getString(request,
							"loan_avail_source", StringPool.BLANK);
					loan_avail_source = ValidatorUtil
							.checkRemoveXSSVeranablity(loan_avail_source);

				}
				if (ParamUtil.getString(request, "loan_avail_rs", StringPool.BLANK) != null) {
					loan_avail_rs = (String) ParamUtil.getString(request,
							"loan_avail_rs", StringPool.BLANK);
					loan_avail_rs = ValidatorUtil
							.checkRemoveXSSVeranablity(loan_avail_rs);

				}

				if (ParamUtil.getString(request, "revenue_project_year1",
						StringPool.BLANK) != null) {
					revenue_project_year1 = (String) ParamUtil.getString(request,
							"revenue_project_year1", StringPool.BLANK);
					revenue_project_year1 = ValidatorUtil
							.checkRemoveXSSVeranablity(revenue_project_year1);

				}

				if (ParamUtil.getString(request, "revenue_project_year2",
						StringPool.BLANK) != null) {
					revenue_project_year2 = (String) ParamUtil.getString(request,
							"revenue_project_year2", StringPool.BLANK);
					revenue_project_year2 = ValidatorUtil
							.checkRemoveXSSVeranablity(revenue_project_year2);

				}

				if (ParamUtil.getString(request, "revenue_project_year3",
						StringPool.BLANK) != null) {
					revenue_project_year3 = (String) ParamUtil.getString(request,
							"revenue_project_year3", StringPool.BLANK);
					revenue_project_year3 = ValidatorUtil
							.checkRemoveXSSVeranablity(revenue_project_year3);

				}
				if (ParamUtil.getString(request, "gross_projected_revenue_rs1",
						StringPool.BLANK) != null) {
					gross_projected_revenue_rs1 = (String) ParamUtil.getString(request,
							"gross_projected_revenue_rs1", StringPool.BLANK);
					gross_projected_revenue_rs1 = ValidatorUtil
							.checkRemoveXSSVeranablity(gross_projected_revenue_rs1);

				}

				if (ParamUtil.getString(request, "gross_projected_revenue_rs2",
						StringPool.BLANK) != null) {
					gross_projected_revenue_rs2 = (String) ParamUtil.getString(request,
							"gross_projected_revenue_rs2", StringPool.BLANK);
					gross_projected_revenue_rs2 = ValidatorUtil
							.checkRemoveXSSVeranablity(gross_projected_revenue_rs2);

				}

				if (ParamUtil.getString(request, "gross_projected_revenue_rs3",
						StringPool.BLANK) != null) {
					gross_projected_revenue_rs3 = (String) ParamUtil.getString(request,
							"gross_projected_revenue_rs3", StringPool.BLANK);
					gross_projected_revenue_rs3 = ValidatorUtil
							.checkRemoveXSSVeranablity(gross_projected_revenue_rs3);

				}
				if (ParamUtil.getString(request, "gross_revenue_year1",
						StringPool.BLANK) != null) {
					gross_revenue_year1 = (String) ParamUtil.getString(request,
							"gross_revenue_year1", StringPool.BLANK);
					gross_revenue_year1 = ValidatorUtil
							.checkRemoveXSSVeranablity(gross_revenue_year1);

				}

				if (ParamUtil.getString(request, "gross_revenue_rs1", StringPool.BLANK) != null) {
					gross_revenue_rs1 = (String) ParamUtil.getString(request,
							"gross_revenue_rs1", StringPool.BLANK);
					gross_revenue_rs1 = ValidatorUtil
							.checkRemoveXSSVeranablity(gross_revenue_rs1);

				}

				if (ParamUtil.getString(request, "gross_revenue_year2",
						StringPool.BLANK) != null) {

					gross_revenue_year2 = (String) ParamUtil.getString(request,
							"gross_revenue_year2", StringPool.BLANK);
					gross_revenue_year2 = ValidatorUtil
							.checkRemoveXSSVeranablity(gross_revenue_year2);

				}
				if (ParamUtil.getString(request, "gross_revenue_rs2", StringPool.BLANK) != null) {
					gross_revenue_rs2 = (String) ParamUtil.getString(request,
							"gross_revenue_rs2", StringPool.BLANK);
					gross_revenue_rs2 = ValidatorUtil
							.checkRemoveXSSVeranablity(gross_revenue_rs2);

				}

				if (ParamUtil.getString(request, "gross_revenue_year3",
						StringPool.BLANK) != null) {
					gross_revenue_year3 = (String) ParamUtil.getString(request,
							"gross_revenue_year3", StringPool.BLANK);
					gross_revenue_year3 = ValidatorUtil
							.checkRemoveXSSVeranablity(gross_revenue_year3);

				}

				if (ParamUtil.getString(request, "gross_revenue_rs3", StringPool.BLANK) != null) {
					gross_revenue_rs3 = (String) ParamUtil.getString(request,
							"gross_revenue_rs3", StringPool.BLANK);
					gross_revenue_rs3 = ValidatorUtil
							.checkRemoveXSSVeranablity(gross_revenue_rs3);

				}

				if (ParamUtil.getString(request, "ebidta_rs1", StringPool.BLANK) != null) {
					ebidta_rs1 = (String) ParamUtil.getString(request, "ebidta_rs1",
							StringPool.BLANK);
					ebidta_rs1 = ValidatorUtil.checkRemoveXSSVeranablity(ebidta_rs1);

				}

				if (ParamUtil.getString(request, "ebidta_rs2", StringPool.BLANK) != null) {
					ebidta_rs2 = (String) ParamUtil.getString(request, "ebidta_rs2",
							StringPool.BLANK);
					ebidta_rs2 = ValidatorUtil.checkRemoveXSSVeranablity(ebidta_rs2);

				}

				if (ParamUtil.getString(request, "cp_promoters_amounts",
						StringPool.BLANK) != null) {
					cp_promoters_amounts = (String) ParamUtil.getString(request,
							"cp_promoters_amounts", StringPool.BLANK);
					cp_promoters_amounts = ValidatorUtil
							.checkRemoveXSSVeranablity(cp_promoters_amounts);

				}

				if (ParamUtil.getString(request, "cp_promoters_addresses",
						StringPool.BLANK) != null) {
					cp_promoters_addresses = (String) ParamUtil.getString(request,
							"cp_promoters_addresses", StringPool.BLANK);
					cp_promoters_addresses = ValidatorUtil
							.checkRemoveXSSVeranablity(cp_promoters_addresses);

				}
				if (ParamUtil
						.getString(request, "cp_promoters_names", StringPool.BLANK) != null) {
					cp_promoters_names = (String) ParamUtil.getString(request,
							"cp_promoters_names", StringPool.BLANK);
					cp_promoters_names = ValidatorUtil
							.checkRemoveXSSVeranablity(cp_promoters_names);

				}
				if (ParamUtil.getString(request, "noofemp", StringPool.BLANK) != null) {
					noofemp = (String) ParamUtil.getString(request, "noofemp",
							StringPool.BLANK);
					noofemp = ValidatorUtil.checkRemoveXSSVeranablity(noofemp);

				}

				if (ParamUtil.getString(request, "ebidta_rs3", StringPool.BLANK) != null) {
					ebidta_rs3 = (String) ParamUtil.getString(request, "ebidta_rs3",
							StringPool.BLANK);
					ebidta_rs3 = ValidatorUtil.checkRemoveXSSVeranablity(ebidta_rs3);

				}
				if (ParamUtil.getString(request, "net_profit", StringPool.BLANK) != null) {
					net_profit = (String) ParamUtil.getString(request, "net_profit",
							StringPool.BLANK);
					net_profit = ValidatorUtil.checkRemoveXSSVeranablity(net_profit);

				}

				if (ParamUtil.getString(request, "net_profit_rs1", StringPool.BLANK) != null) {
					net_profit_rs1 = (String) ParamUtil.getString(request,
							"net_profit_rs1", StringPool.BLANK);
					net_profit_rs1 = ValidatorUtil
							.checkRemoveXSSVeranablity(net_profit_rs1);

				}

				if (ParamUtil.getString(request, "net_profit_rs2", StringPool.BLANK) != null) {
					net_profit_rs2 = (String) ParamUtil.getString(request,
							"net_profit_rs2", StringPool.BLANK);
					net_profit_rs2 = ValidatorUtil
							.checkRemoveXSSVeranablity(net_profit_rs2);

				}

				if (ParamUtil.getString(request, "net_profit_rs3", StringPool.BLANK) != null) {
					net_profit_rs3 = (String) ParamUtil.getString(request,
							"net_profit_rs3", StringPool.BLANK);
					net_profit_rs3 = ValidatorUtil
							.checkRemoveXSSVeranablity(net_profit_rs3);

				}
				if (ParamUtil.getString(request, "financial_bank_engagement",
						StringPool.BLANK) != null) {
					financial_bank_engagement = (String) ParamUtil.getString(request,
							"financial_bank_engagement", StringPool.BLANK);
					financial_bank_engagement = ValidatorUtil
							.checkRemoveXSSVeranablity(financial_bank_engagement);

				}
				if (ParamUtil.getString(request, "financial_assistance",
						StringPool.BLANK) != null) {
					financial_assistance = (String) ParamUtil.getString(request,
							"financial_assistance", StringPool.BLANK);
					financial_assistance = ValidatorUtil
							.checkRemoveXSSVeranablity(financial_assistance);

				}
				if (ParamUtil.getString(request, "revenue_projections",
						StringPool.BLANK) != null) {
					revenue_projections = (String) ParamUtil.getString(request,
							"revenue_projections", StringPool.BLANK);
					revenue_projections = ValidatorUtil
							.checkRemoveXSSVeranablity(revenue_projections);

				}

				if (ParamUtil.getString(request, "agreeable_process", StringPool.BLANK) != null) {
					agreeable_process = (String) ParamUtil.getString(request,
							"agreeable_process", StringPool.BLANK);
					agreeable_process = ValidatorUtil
							.checkRemoveXSSVeranablity(agreeable_process);

				}
				if (ParamUtil.getString(request, "gsr_department", StringPool.BLANK) != null) {
					gsr_department = (String) ParamUtil.getString(request,
							"gsr_department", StringPool.BLANK);
					gsr_department = ValidatorUtil
							.checkRemoveXSSVeranablity(gsr_department);

				}
				if (ParamUtil.getString(request, "startupindia", StringPool.BLANK) != null) {
					startupindia = (String) ParamUtil.getString(request,
							"startupindia", StringPool.BLANK);
					startupindia = ValidatorUtil
							.checkRemoveXSSVeranablity(startupindia);

				}
				if (ParamUtil.getString(request, "incubator", StringPool.BLANK) != null) {
					incubator = (String) ParamUtil.getString(request, "incubator",
							StringPool.BLANK);
					incubator = ValidatorUtil.checkRemoveXSSVeranablity(incubator);

				}
				if (ParamUtil.getString(request, "address_line_1", StringPool.BLANK) != null) {
					address_line_1 = (String) ParamUtil.getString(request,
							"address_line_1", StringPool.BLANK);
					address_line_1 = ValidatorUtil
							.checkRemoveXSSVeranablity(address_line_1);

				}
				if (ParamUtil.getString(request, "address_line_2", StringPool.BLANK) != null) {
					address_line_2 = (String) ParamUtil.getString(request,
							"address_line_2", StringPool.BLANK);
					address_line_2 = ValidatorUtil
							.checkRemoveXSSVeranablity(address_line_2);

				}
				if (ParamUtil.getString(request, "address_city", StringPool.BLANK) != null) {
					address_city = (String) ParamUtil.getString(request,
							"address_city", StringPool.BLANK);
					address_city = ValidatorUtil
							.checkRemoveXSSVeranablity(address_city);

				}
				if (ParamUtil.getString(request, "address_pin", StringPool.BLANK) != null) {
					address_pin = (String) ParamUtil.getString(request, "address_pin",
							StringPool.BLANK);
					address_pin = ValidatorUtil.checkRemoveXSSVeranablity(address_pin);

				}
				if (ParamUtil.getString(request, "address_landmark", StringPool.BLANK) != null) {
					address_landmark = (String) ParamUtil.getString(request,
							"address_landmark", StringPool.BLANK);
					address_landmark = ValidatorUtil
							.checkRemoveXSSVeranablity(address_landmark);

				}
				if (ParamUtil.getString(request, "address_state", StringPool.BLANK) != null) {
					address_state = (String) ParamUtil.getString(request,
							"address_state", StringPool.BLANK);
					address_state = ValidatorUtil
							.checkRemoveXSSVeranablity(address_state);

				}

				SbiStartUp StartUp = new SbiStartUpImpl();
				CapitalInf CapInfu = new CapitalInfImpl();
				Date d = new Date();

				CapInfu.setCreateDate(d);
				CapInfu.setModifiedDate(d);

				String promoterName = "";
				String promoterAddress = "";
				String promoterAmount = "";
				String[] cpPromoterNamesMV = cp_promoters_names.split(",");
				String[] cpPromoterAddressMV = cp_promoters_addresses.split("\\$");
				String[] cpPromoterAmount = cp_promoters_amounts.split(",");
				regnum = (String) sessionp.getAttribute("regnum") != null ? (String) sessionp
						.getAttribute("regnum") : "";

						try {
							if (regnum.equals("")) {
								regnum = generateRandomNumber();
								StartUp.setRegnum(regnum);
								StartUp.setUserName(themeDisplay.getUser().getFullName());

								StartUp.setCreateDate(d);
								StartUp.setModifiedDate(d);

								StartUp.setRegistered_name(registered_name);
								StartUp.setDate_of_establishment(doe);
								StartUp.setConstitution(constitution);

								StartUp.setCorporate_website(corporate_website);
								StartUp.setCorporate_email(corporate_email);
								StartUp.setInitial_founders(founders);
								StartUp.setCurrent_promoters_name(promoters);
								StartUp.setNoofemp(noofemp);

								StartUp.setFinancial_assi_purp(financial_assi_purp);
								StartUp.setAddress_line_1(address_line_1);
								StartUp.setAddress_line_2(address_line_2);
								StartUp.setAddress_city(address_city);
								StartUp.setAddress_pin(address_pin);
								StartUp.setAddress_landmark(address_landmark);
								StartUp.setAddress_state(address_state);
								StartUp.setDescription_of_product(description_of_product);
								StartUp.setInitial_capital(initial_capital);
								StartUp.setMonetary_value(monetary_value);
								StartUp.setBusiness_model(business_model);
								StartUp.setCurrent_capital(current_capital);
								StartUp.setCapital_infusion(capital_infusion);

								StartUp.setLoans_availed(Loans_availed);
								StartUp.setValuer_name(valuer_name);
								StartUp.setValuation_date(valuationDate);
								StartUp.setValuation_amount_rs(valuation_amount_rs);
								StartUp.setLoan_avail_source(loan_avail_source);
								StartUp.setLoan_avail_rs(loan_avail_rs);
								StartUp.setGross_revenue_year1(gross_revenue_year1);
								StartUp.setGross_revenue_rs1(gross_revenue_rs1);
								StartUp.setGross_revenue_year2(gross_revenue_year2);
								StartUp.setGross_revenue_rs2(gross_revenue_rs2);
								StartUp.setGross_revenue_year3(gross_revenue_year3);
								StartUp.setGross_revenue_rs3(gross_revenue_rs3);
								StartUp.setEbidta_year1(gross_revenue_year1);
								StartUp.setEbidta_rs1(ebidta_rs1);
								StartUp.setEbidta_year2(gross_revenue_year2);
								StartUp.setEbidta_rs2(ebidta_rs2);
								StartUp.setEbidta_year3(gross_revenue_year3);
								StartUp.setEbidta_rs3(ebidta_rs3);
								StartUp.setNet_profit_year1(gross_revenue_year1);
								StartUp.setNet_profit_rs1(net_profit_rs1);
								StartUp.setNet_profit_year2(gross_revenue_year2);
								StartUp.setNet_profit_rs2(net_profit_rs2);
								StartUp.setNet_profit_year3(gross_revenue_year3);
								StartUp.setNet_profit_rs3(net_profit_rs3);
								StartUp.setFinancial_assistance(financial_assistance);
								StartUp.setFinancial_assi_purp(financial_assi_purp);
								StartUp.setFinancial_bank_engagement(financial_bank_engagement);
								StartUp.setAgreeable_process(agreeable_process);
								StartUp.setGsr_department(gsr_department);
								StartUp.setStartupindia(startupindia);
								StartUp.setIncubator(incubator);
								StartUp.setStatus("Initiated");
								StartUp.setGross_revenue_projected_year1(revenue_project_year1);
								StartUp.setProjected_revenue_rs1(gross_projected_revenue_rs1);
								StartUp.setGross_revenue_projected_year2(revenue_project_year2);
								StartUp.setProjected_revenue_rs2(gross_projected_revenue_rs2);
								StartUp.setGross_revenue_projected_year3(revenue_project_year3);
								StartUp.setProjected_revenue_rs3(gross_projected_revenue_rs3);
								StartUp.setFlag(false);
								SbiStartUpLocalServiceUtil.addSbiStartUp(StartUp);

								try {
									// String emailbody =
									// PortletProps.get("entity.sbi.startup.mail.template.user");

									StringBuilder sb = new StringBuilder();
									sb.append("<html><body>");
									sb.append("<div><p>Thank you! Your application has been saved successfully. Your Registration Number is : <b>regNum</b></p>");
									sb.append("</div>");
									sb.append("<div>");
									sb.append("<h4>Team IT-Innovation & Quick Wins</h4>");
									sb.append("<p>State Bank Of India</p>");
									sb.append("<p>Global IT Center</p>");
									sb.append("<p>Sector 11, CBD Belapur</p>");
									sb.append("<p>Navi Mumbai - 400614</p>");
									sb.append("<p>Landline : 022 - 27566043</p>");
									sb.append("<p>Email : <a href=\"mailto:startup@sbi.co.in\">startup@sbi.co.in</a></p>");
									sb.append("</div>");
									sb.append("</body>");
									sb.append("</html>");

									String emailbody = sb.toString();
									emailbody = emailbody.replace("regNum", regnum);
									sendMail(
											corporate_email,
											PortletProps.get("entity.sbi.startup.mail.subject"),
											emailbody);
								} catch (Exception ex) {
									// logger.error(ex);
									// ex.printStackTrace();
									Log.info(ex);
								}

								sessionp.setAttribute("regnum", regnum);

								String capInfuKeys = "";
								for (int i = 0; i < cpPromoterNamesMV.length; i++) {
									long key = CounterLocalServiceUtil
											.increment(CapitalInf.class.getName());
									promoterName = cpPromoterNamesMV[i];
									promoterAddress = cpPromoterAddressMV[i];
									promoterAmount = cpPromoterAmount[i];
									CapInfu.setInfRefId(key);
									CapInfu.setRegNum(regnum);
									CapInfu.setCp_promoters_name(promoterName);
									CapInfu.setCp_promoters_address(promoterAddress);
									CapInfu.setCp_promoters_amount(promoterAmount);
									CapitalInfLocalServiceUtil.addCapitalInf(CapInfu);
									capInfuKeys += key + ",";
								}
								sessionp.setAttribute("capInfuKeys", capInfuKeys);

							} else {
								// System.out.println("----Reg Num ----"+regnum);
								StartUp = SbiStartUpLocalServiceUtil.fetchSbiStartUp(regnum);
								// StartUp.setUserName(themeDisplay.getUser().getFullName());
								StartUp.setModifiedDate(d);
								StartUp.setRegistered_name(registered_name);
								StartUp.setDate_of_establishment(doe);
								StartUp.setConstitution(constitution);
								StartUp.setCorporate_website(corporate_website);
								StartUp.setCorporate_email(corporate_email);
								StartUp.setInitial_founders(founders);
								StartUp.setCurrent_promoters_name(promoters);
								StartUp.setNoofemp(noofemp);
								StartUp.setFinancial_assi_purp(financial_assi_purp);
								StartUp.setAddress_line_1(address_line_1);
								StartUp.setAddress_line_2(address_line_2);
								StartUp.setAddress_city(address_city);
								StartUp.setAddress_pin(address_pin);
								StartUp.setAddress_landmark(address_landmark);
								StartUp.setAddress_state(address_state);
								StartUp.setDescription_of_product(description_of_product);
								StartUp.setInitial_capital(initial_capital);
								StartUp.setMonetary_value(monetary_value);
								StartUp.setBusiness_model(business_model);
								StartUp.setCurrent_capital(current_capital);
								StartUp.setCapital_infusion(capital_infusion);
								StartUp.setLoans_availed(Loans_availed);
								StartUp.setValuer_name(valuer_name);
								StartUp.setValuation_date(valuationDate);
								StartUp.setValuation_amount_rs(valuation_amount_rs);
								StartUp.setLoan_avail_source(loan_avail_source);
								StartUp.setLoan_avail_rs(loan_avail_rs);
								StartUp.setGross_revenue_year1(gross_revenue_year1);
								StartUp.setGross_revenue_rs1(gross_revenue_rs1);
								StartUp.setGross_revenue_year2(gross_revenue_year2);
								StartUp.setGross_revenue_rs2(gross_revenue_rs2);
								StartUp.setGross_revenue_year3(gross_revenue_year3);
								StartUp.setGross_revenue_rs3(gross_revenue_rs3);
								StartUp.setEbidta_year1(gross_revenue_year1);
								StartUp.setEbidta_rs1(ebidta_rs1);
								StartUp.setEbidta_year2(gross_revenue_year2);
								StartUp.setEbidta_rs2(ebidta_rs2);
								StartUp.setEbidta_year3(gross_revenue_year3);
								StartUp.setEbidta_rs3(ebidta_rs3);
								StartUp.setNet_profit_year1(gross_revenue_year1);
								StartUp.setNet_profit_rs1(net_profit_rs1);
								StartUp.setNet_profit_year2(gross_revenue_year2);
								StartUp.setNet_profit_rs2(net_profit_rs2);
								StartUp.setNet_profit_year3(gross_revenue_year3);
								StartUp.setNet_profit_rs3(net_profit_rs3);
								StartUp.setFinancial_assistance(financial_assistance);
								StartUp.setFinancial_assi_purp(financial_assi_purp);
								StartUp.setFinancial_bank_engagement(financial_bank_engagement);
								StartUp.setAgreeable_process(agreeable_process);
								StartUp.setGsr_department(gsr_department);
								StartUp.setStartupindia(startupindia);
								StartUp.setIncubator(incubator);
								StartUp.setGross_revenue_projected_year1(revenue_project_year1);
								StartUp.setProjected_revenue_rs1(gross_projected_revenue_rs1);
								StartUp.setGross_revenue_projected_year2(revenue_project_year2);
								StartUp.setProjected_revenue_rs2(gross_projected_revenue_rs2);
								StartUp.setGross_revenue_projected_year3(revenue_project_year3);
								StartUp.setProjected_revenue_rs3(gross_projected_revenue_rs3);
								StartUp.setFlag(false);
								StartUp.setStatus("Initiated");
								SbiStartUpLocalServiceUtil.updateSbiStartUp(StartUp);

								// TODO Updating CapitalInf

								saveCapitalInfusion(request, cp_promoters_names,
										cp_promoters_addresses, cp_promoters_amounts, regnum);

								System.out.println("-- -Print data ");

							}

							try {
								PrintWriter pw = response.getWriter();
								JSONObject json = new JSONObject();
								json.put("regnum", regnum);
								pw.print(json);
								pw.flush();
								pw.close();
							} catch (IOException e) {
							
								Log.info(e);
								// TODO Auto-generated catch block
								 e.printStackTrace();
							}

						} catch (SystemException e) {
							
							// TODO Auto-generated catch block
							 e.printStackTrace();
							 Log.info(e);
						}

						sessionp.setAttribute("regnum", regnum);

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

	public void saveCapitalInfusion(PortletRequest request,
			String cp_promoters_names, String cp_promoters_addresses,
			String cp_promoters_amounts, String regnum) {

		String promoterName = "";
		String promoterAddress = "";
		String promoterAmount = "";
		String[] cpPromoterNamesMV = cp_promoters_names.split(",");
		String[] cpPromoterAddressMV = cp_promoters_addresses.split("\\$");
		String[] cpPromoterAmount = cp_promoters_amounts.split(",");
		PortletSession sessionp = request.getPortletSession();
		CapitalInf CapInfu = new CapitalInfImpl();
		String capInfuKeys = (String) sessionp.getAttribute("capInfuKeys") != null ? (String) sessionp
				.getAttribute("capInfuKeys") : "";
				try {
					if (capInfuKeys.equalsIgnoreCase("")) {
						for (int i = 0; i < cpPromoterNamesMV.length; i++) {
							long key = CounterLocalServiceUtil
									.increment(CapitalInf.class.getName());
							promoterName = cpPromoterNamesMV[i];
							promoterAddress = cpPromoterAddressMV[i];
							promoterAmount = cpPromoterAmount[i];
							CapInfu.setInfRefId(key);
							CapInfu.setRegNum(regnum);
							CapInfu.setModifiedDate(new Date());
							CapInfu.setCreateDate(new Date());
							CapInfu.setCp_promoters_name(promoterName);
							CapInfu.setCp_promoters_address(promoterAddress);
							CapInfu.setCp_promoters_amount(promoterAmount);
							CapitalInfLocalServiceUtil.addCapitalInf(CapInfu);
							capInfuKeys += key + ",";
						}
						sessionp.setAttribute("capInfuKeys", capInfuKeys);
					} else {
						String[] keyArray = capInfuKeys.split(",");
						if (keyArray.length == cpPromoterNamesMV.length) {
							for (int i = 0; i < cpPromoterNamesMV.length; i++) {
								CapInfu = CapitalInfLocalServiceUtil
										.fetchCapitalInf(Long.parseLong(keyArray[i]));
								promoterName = cpPromoterNamesMV[i];
								promoterAddress = cpPromoterAddressMV[i];
								promoterAmount = cpPromoterAmount[i];
								CapInfu.setModifiedDate(new Date());
								CapInfu.setCp_promoters_name(promoterName);
								CapInfu.setCp_promoters_address(promoterAddress);
								CapInfu.setCp_promoters_amount(promoterAmount);
								CapitalInfLocalServiceUtil.updateCapitalInf(CapInfu);
							}
						}
						if (keyArray.length < cpPromoterNamesMV.length) {

							for (int i = 0; i < keyArray.length; i++) {
								CapInfu = CapitalInfLocalServiceUtil
										.fetchCapitalInf(Long.parseLong(keyArray[i]));
								promoterName = cpPromoterNamesMV[i];
								promoterAddress = cpPromoterAddressMV[i];
								promoterAmount = cpPromoterAmount[i];

								CapInfu.setCreateDate(new Date());
								CapInfu.setCp_promoters_name(promoterName);
								CapInfu.setCp_promoters_address(promoterAddress);
								CapInfu.setCp_promoters_amount(promoterAmount);
								CapitalInfLocalServiceUtil.updateCapitalInf(CapInfu);
							}
							for (int j = keyArray.length; j < cpPromoterNamesMV.length; j++) {
								long key = CounterLocalServiceUtil
										.increment(CapitalInf.class.getName());
								promoterName = cpPromoterNamesMV[j];
								promoterAddress = cpPromoterAddressMV[j];
								promoterAmount = cpPromoterAmount[j];
								CapInfu.setInfRefId(key);
								CapInfu.setRegNum(regnum);
								CapInfu.setModifiedDate(new Date());
								CapInfu.setCreateDate(new Date());
								CapInfu.setCp_promoters_name(promoterName);
								CapInfu.setCp_promoters_address(promoterAddress);
								CapInfu.setCp_promoters_amount(promoterAmount);
								CapitalInfLocalServiceUtil.addCapitalInf(CapInfu);
								capInfuKeys += key + ",";
							}
							sessionp.setAttribute("capInfuKeys", capInfuKeys);
						}
						if (keyArray.length > cpPromoterNamesMV.length) {
							for (int i = 0; i < keyArray.length; i++) {
								try {
									CapitalInfLocalServiceUtil.deleteCapitalInf(Long
											.parseLong(keyArray[i]));
								} catch (NumberFormatException e) {
									
									Log.info(e);

									// TODO Auto-generated catch block
									 e.printStackTrace();
								} catch (PortalException e) {
									// TODO Auto-generated catch block
									 e.printStackTrace();
									 Log.info(e);
									
								}
							}
							capInfuKeys = "";
							for (int i = 0; i < cpPromoterNamesMV.length; i++) {
								long key = CounterLocalServiceUtil
										.increment(CapitalInf.class.getName());
								promoterName = cpPromoterNamesMV[i];
								promoterAddress = cpPromoterAddressMV[i];
								promoterAmount = cpPromoterAmount[i];
								CapInfu.setInfRefId(key);
								CapInfu.setRegNum(regnum);
								CapInfu.setModifiedDate(new Date());
								CapInfu.setCreateDate(new Date());
								CapInfu.setCp_promoters_name(promoterName);
								CapInfu.setCp_promoters_address(promoterAddress);
								CapInfu.setCp_promoters_amount(promoterAmount);
								CapitalInfLocalServiceUtil.addCapitalInf(CapInfu);
								capInfuKeys = key + ",";
							}
							sessionp.setAttribute("capInfuKeys", capInfuKeys);

						}
					}
				} catch (Exception ex) {
					 ex.printStackTrace();
					 Log.info(ex);
					
				}
	}

	/*
	 * public void sendMail(String toAddress,String emailSubject,String
	 * emailBody){
	 * 
	 * Properties props = new Properties(); props.put("mail.smtp.host",
	 * PortletProps.get("entity.sbi.eduloan.mail.smtp.host")); // for gmail use
	 * smtp.gmail.com props.put("mail.smtp.auth",
	 * PortletProps.get("entity.sbi.eduloan.mail.smtp.auth"));
	 * props.put("mail.smtp.starttls.enable",
	 * PortletProps.get("entity.sbi.eduloan.mail.smtp.starttls.enable"));
	 * props.put("mail.smtp.port",
	 * PortletProps.get("entity.sbi.eduloan.mail.smtp.port"));
	 * props.put("mail.smtp.socketFactory.port",
	 * PortletProps.get("entity.sbi.eduloan.mail.smtp.socketFactory.port"));
	 * props.put("mail.smtp.socketFactory.class",
	 * PortletProps.get("entity.sbi.eduloan.mail.smtp.socketFactory.class"));
	 * props.put("mail.smtp.socketFactory.fallback",
	 * PortletProps.get("entity.sbi.eduloan.mail.smtp.socketFactory.fallback"));
	 * Session session = Session.getInstance(props, new
	 * javax.mail.Authenticator() { protected PasswordAuthentication
	 * getPasswordAuthentication() { return new
	 * PasswordAuthentication(PortletProps
	 * .get("entity.sbi.eduloan.admininternetaddressquery"),
	 * PortletProps.get("entity.sbi.eduloan.admininternetaddressquerypwd")); }
	 * });
	 * 
	 * try {
	 * 
	 * Message message = new MimeMessage(session); message.setFrom(new
	 * InternetAddress
	 * (PortletProps.get("entity.sbi.eduloan.admininternetaddressquery")));
	 * message.setRecipients(Message.RecipientType.TO,
	 * InternetAddress.parse(toAddress)); message.setSubject(emailSubject);
	 * 
	 * 
	 * 
	 * Multipart multipart = new MimeMultipart();
	 * 
	 * 
	 * MimeBodyPart textPart = new MimeBodyPart();
	 * 
	 * textPart.setContent(emailBody,
	 * "text/html; charset=utf-8; charset=us-ascii");
	 * 
	 * multipart.addBodyPart(textPart); message.setContent(multipart);
	 * 
	 * Transport.send( message ); System.out.println("--- Mail Sent ---");
	 * 
	 * } catch (MessagingException e) { throw new RuntimeException(e); } }
	 */

	public void sendMail(String toAddress, String emailSubject, String emailBody) {

		String strMailFROM = "sbiwebsite.inb@sbi.co.in";

		Session sess2 = null;
		Transport tr = null;
		MimeMessage msg = null;

		InternetAddress addressTO[] = (InternetAddress[]) null;
		InternetAddress addressCC[] = (InternetAddress[]) null;
		InternetAddress addressBCC[] = (InternetAddress[]) null;
		String fileName = "application";
		String mailSubject = (new StringBuilder("StartUp ")).append(fileName)
				.toString();

		Properties properties = System.getProperties();

		Security.addProvider(new Provider());

		properties.setProperty("mail.transport.protocol", "smtp");
		properties.setProperty("mail.host", "ems2.sbi.co.in");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.port", "465");
		properties.put("mail.debug", "true");
		properties.put("mail.smtp.socketFactory.port", "465");
		properties.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		properties.put("mail.smtp.socketFactory.fallback", "false");
		properties.setProperty("mail.smtp.quitwait", "false");
		Security.setProperty("ssl.SocketFactory.provider",
				"com.ibm.jsse2.SSLSocketFactoryImpl");
		Security.setProperty("ssl.ServerSocketFactory.provider",
				"com.ibm.jsse2.SSLServerSocketFactoryImpl");

		sess2 = Session.getInstance(properties, new Authenticator() {

			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("sbiwebsite.inb@sbi.co.in",
						"Test@123");
			}

		});
		sess2.setDebug(true);

		try {
			sess2.setDebug(true);
			tr = sess2.getTransport();
			msg = new MimeMessage(sess2);
			msg.setFrom(new InternetAddress(strMailFROM));
			addressTO = InternetAddress.parse(toAddress, false);
			msg.setRecipients(javax.mail.Message.RecipientType.TO, addressTO);
			msg.setSubject(mailSubject);

			Multipart multipart = new MimeMultipart();
			MimeBodyPart textPart = new MimeBodyPart();

			textPart.setContent(emailBody,
					"text/html; charset=utf-8; charset=us-ascii");
			multipart.addBodyPart(textPart);
			msg.setContent(multipart);

			tr.connect();
			tr.sendMessage(msg, addressTO);
			tr.sendMessage(msg, addressCC);
			tr.sendMessage(msg, addressBCC);
			tr.close();

		} catch (MessagingException mex) {
			 mex.printStackTrace();
			 Log.info("check mail server access");
		}
	}

	public static String generateRandomNumber() {

		long timeSeed = System.currentTimeMillis();
		double randSeed = Math.random() * 1000;
		long midSeed = (long) (timeSeed * randSeed);
		String s = midSeed + "";
		String subStr = s.substring(0, 8);
		return subStr;

	}

	@SuppressWarnings("deprecation")
	public String convertToPdf(SbiStartUp StartUp, String regNum,
			ResourceResponse response, ResourceRequest request)
					throws PortletException, IOException {

		DynamicQuery query = DynamicQueryFactoryUtil.forClass(ResumeDtls.class);
		Criterion criterion = RestrictionsFactoryUtil.eq("RegNum", regNum);
		query.add(criterion);
		List<ResumeDtls> resumeList = null;
		try {
			resumeList = (List) ResumeDtlsLocalServiceUtil.dynamicQuery(query);
		} catch (Exception ex) {

		}

		try {
			// Get the text that will be added to the PDF

			Document document = new Document();

			ByteArrayOutputStream baos = new ByteArrayOutputStream();

			// OutputStreambaos = new FileOutputStream(new File(regNum+".pdf"));

			PdfWriter.getInstance(document, baos);

			document.open();

			String dateOfEstablish = df.format(StartUp
					.getDate_of_establishment());
			String valutionDate = "";
			if (StartUp.getValuation_date() != null) {
				valutionDate = df.format(StartUp.getValuation_date());
			}
			HTMLWorker htmlWorker = new HTMLWorker(document);
			StringBuffer buf = new StringBuffer();

			query = DynamicQueryFactoryUtil.forClass(CapitalInf.class);
			criterion = RestrictionsFactoryUtil.eq("RegNum", regNum);
			query.add(criterion);
			List<CapitalInf> capitalInfList = null;
			try {
				capitalInfList = (List) CapitalInfLocalServiceUtil
						.dynamicQuery(query);
			} catch (Exception ex) {

			}

			String bankEngagement = StartUp.getFinancial_bank_engagement();

			System.out.println("-- Bank enagagement --" + bankEngagement);

			if (bankEngagement.equalsIgnoreCase("Procurement")) {
				bankEngagement = "Procurement of our Product/Services";
			} else if (bankEngagement.equalsIgnoreCase("Financialassistance")) {
				bankEngagement = "Financial Assistance from the Bank";
			}

			// ThemeDisplay themeDisp = (ThemeDisplay)
			// request.getAttribute(WebKeys.THEME_DISPLAY);

			StringBuffer Str1 = buf.append("<html><head></head><body>");
			/*
			 * if(themeDisp.getPathThemeImages() != null){
			 * buf.append("<div><img src= "+themeDisp.getPathThemeImages()+
			 * "/startup/logo.png  width='120' height='30' />  </div>"); }
			 */

			PortletSession session = request.getPortletSession();
			PortletContext ctx = session.getPortletContext();

			InputStream path = ctx.getResourceAsStream("/html/images/logo.png");
			System.out.println("---- path ---" + path);
			ByteArrayOutputStream buffer = new ByteArrayOutputStream();
			int nRead;
			byte[] data = new byte[16384];
			while ((nRead = path.read(data, 0, data.length)) != -1) {
				buffer.write(data, 0, nRead);
			}

			buffer.flush();
			com.itextpdf.text.Image img = com.itextpdf.text.Image
					.getInstance(buffer.toByteArray());
			img.scaleAbsolute(120.0F, 30.0F);
			document.add(img);

			buf.append("<div style='font-family:arial;font-size:7px;margin: 5px auto;padding:20px 10px; width:850px;'>"
					+ "<h3 style='color:#003d66;text-align:center;font-size:9px;'><b>Information Technology Innovation Start-up Engagement Programme (IT-ISEP)</b></h3>"
					+ "<h3 style='color:#003d66;text-align:center;font-size:9px;'><b>Start-up Application Form</b></h3>"
					+ " <table>");
			buf.append("<tr style='line-height:16px;'><td><b>1.</b><label><b>Registered name of start-up </b></label></td>"
					+ "<td>"
					+ StartUp.getRegistered_name()
					+ "</td>"
					+ "<td colspan='2'><b>2.</b><label><b>Date of establishment </b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>"
					+ dateOfEstablish + "</td></tr>");
			buf.append("<tr style='line-height:16px;'><td><b>3.</b><label><b>Constitution </b></label></td><td>"
					+ StartUp.getConstitution()
					+ "</td><td colspan='2'></td></tr>");
			buf.append("<tr style='line-height:16px;'><td colspan='4'><b>4.</b><label style='color:green'><b>Address of Corporate office</b></label></td></tr>");

			buf.append("<tr style='line-height:16px;'><td  colspan='4'>"
					+ "<table width='100%' border='0' cellspacing='0' cellpadding='0'>"
					+ "<tr><td><label><b>Address Line1</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>"
					+ StartUp.getAddress_line_1()
					+ "</td>"
					+ "<td><label><b>City</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>"
					+ StartUp.getAddress_city()
					+ "</td></tr>"
					+ "<tr><td><label><b>Address Line2</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>"
					+ StartUp.getAddress_line_2()
					+ "</td><td><label><b>PIN</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>"
					+ StartUp.getAddress_pin()
					+ "</td></tr>"
					+ "<tr><td><label><b>Landmark</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>"
					+ StartUp.getAddress_landmark()
					+ "</td><td><label><b>State</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>"
					+ StartUp.getAddress_state() + "</td></tr>");
			buf.append("<tr style='line-height:16px;'><td><b>5.</b><label><b>Corporate Email ID </b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>"
					+ StartUp.getCorporate_email()
					+ "</td>"
					+ "<td><b>6.</b><label><b>Corporate Website URL</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>"
					+ StartUp.getCorporate_website()
					+ "</td></tr></table></td></tr>");

			buf.append("<tr style='line-height:16px;'><td colspan='4'><b>7.</b><label><b>Names of all the initial founders </b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>"
					+ StartUp.getInitial_founders() + "</td></tr>");
			buf.append("<tr style='line-height:16px;'><td colspan='4'><label><b>Names of all the current promoters</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>"
					+ StartUp.getCurrent_promoters_name() + "</td></tr>");
			buf.append(" <tr style='line-height:16px;'><td colspan='4'><b>8.</b><label><b>No. of Employees</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>"
					+ StartUp.getNoofemp() + "</td></tr>");
			buf.append("<tr style='line-height:16px;'><td colspan='4'><b>9.</b><label><b>Brief description of product/service</b><br/></label>"
					+ StartUp.getDescription_of_product() + "</td></tr>");

			buf.append("<tr style='line-height:16px;'><td colspan='4'><b>10.</b><label><b>Brief description of business model</b><br/></label>"
					+ StartUp.getBusiness_model() + "</td></tr>");

			buf.append("<tr style='line-height:16px;'><td colspan='4'><b>11.</b><label><b>Differentiation and monetary value of the product / service for banking industry</b><br/></label>"
					+ StartUp.getMonetary_value() + "</td></tr>");
			buf.append("<tr style='line-height:16px;'><td colspan='4'><b>12.</b><label><b>Total initial capital by founders(in Lakhs)</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>"
					+ StartUp.getInitial_capital()
					+ "</td></tr>"
					+ "<tr style='line-height:16px;'><td colspan='4'><b>13.</b><label><b>Current capital(in Lakhs)</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>"
					+ StartUp.getCurrent_capital() + "</td></tr>");

			buf.append("<tr style='line-height:16px;'><td colspan='4'><b>14.</b><label><b>Capital infusion by Incubation Fund/ Angel Fund/ Private Equity Fund/ Accelerator/Angel Network duly registered with Securities and Exchange Board of India</b></label><br/><br/>");
			buf.append("<table class='inner-table' width='100%' style='line-height:27px;'>");

			buf.append("<tr valign='middle' style='line-height:16px; vertical-align:middle; padding-bottom:10px' bgcolor='#d2d2d2' align='middle' ><th>Name</th><th>Address</th><th>Amount</th></tr>");

			for (int loop = 0; loop < capitalInfList.size(); loop++) {
				buf.append("<tr style='line-height:16px;'><td>"
						+ capitalInfList.get(loop).getCp_promoters_name()
						+ "</td><td>"
						+ capitalInfList.get(loop).getCp_promoters_address()
						+ "</td><td>"
						+ capitalInfList.get(loop).getCp_promoters_amount()
						+ "</td></tr>");
			}
			buf.append("</table></td>");
			buf.append("</tr>");

			buf.append("<tr style='line-height:16px;'><td colspan='4'><b>15.</b><label><b>Has the valuation of the start-up been done during the past 12 months by an external entity? If Yes, give name of the valuing entity, date of valuation and the valuation amount.</b></label></td></tr>");
			buf.append("<tr style='line-height:16px;'><td colspan='2'><label><b>Name</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>"
					+ StartUp.getValuer_name()
					+ "</td></tr>"
					+ "<tr style='line-height:16px;'><td colspan='2'><label><b>Date</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>"
					+ valutionDate
					+ "</td><td  colspan='4'><label><b>Rs</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>"
					+ StartUp.getValuation_amount_rs() + "(in Lakhs)</td></tr>");
			buf.append("<tr style='line-height:16px;'><td colspan='4'><b>16.</b><label><b>Loans availed, if any</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label></td></tr>");
			buf.append("<tr style='line-height:16px;'><td colspan='2'><label><b>Source</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>"
					+ StartUp.getLoan_avail_source()
					+ "</td><td colspan='2'><label><b>Rs</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>"
					+ StartUp.getLoan_avail_rs() + "(in Lakhs)</td></tr>");

			buf.append("<tr style='line-height:16px;'><td colspan='4'><b>17.</b><label><b>Revenue Details of previous 3 financial years:</b></label><br/><br/>");
			buf.append("<table class='inner-table' width='100%' border='0' cellspacing='0' cellpadding='0' style='line-height:27px;'>"
					+ "<trvalign='middle' style='line-height:16px; vertical-align:middle; padding-bottom:10px' bgcolor='#d2d2d2' align='middle' ><th>Year</th><th>Gross Revenue (in Lakhs)</th><th>EBIDTA (in Lakhs)</th><th>Net Profit (in Lakhs)</th></tr>"
					+ "<tr style='line-height:16px;'><td><label><b>2015-2016</b></label></td><td>"
					+ StartUp.getGross_revenue_rs1()
					+ "</td><td></label>"
					+ StartUp.getEbidta_rs1()
					+ "</td><td>"
					+ StartUp.getNet_profit_rs1()
					+ "</td></tr>"
					+ "<tr style='line-height:16px;'><td><label><b>2014-2015</b></label></td>"
					+ "<td>"
					+ StartUp.getGross_revenue_rs2()
					+ "</td><td>"
					+ StartUp.getEbidta_rs2()
					+ "</td><td>"
					+ StartUp.getNet_profit_rs2()
					+ "</td></tr>"
					+ "<tr style='line-height:16px;'><td><label><b>2013-2014</b></label></td>"
					+ "<td>"
					+ StartUp.getGross_revenue_rs3()
					+ "</td><td>"
					+ StartUp.getEbidta_rs3()
					+ "</td><td>"
					+ StartUp.getNet_profit_rs3()
					+ "</td></tr></table></td></tr>");

			buf.append("<tr style='line-height:16px;'><td colspan='4'><b>18.</b><label><b>Type of engagement with the bank</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>"
					+ bankEngagement + "</td></tr>");
			if (!StartUp.getFinancial_bank_engagement().equalsIgnoreCase(
					"Procurement")) {
				buf.append("<tr style='line-height:16px;'><td colspan='4'><label class='pad1'><b>a. Type of financial assistance sought from SBI</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>"
						+ StartUp.getFinancial_assistance()
						+ "</td></tr>"
						+ "<tr style='line-height:16px;'><td colspan='4'><label class='pad1'><b>b. Purpose for the financial assistance</b><br/></label>"
						+ StartUp.getFinancial_assi_purp() + "</td></tr>");
			}
			buf.append("<tr style='line-height:16px;'><td colspan='4'><b>19.</b><label><b>Revenue projections for next 3 years (in Lakhs)</b></label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td></tr>"
					+ "<tr style='line-height:16px;'><td><label><b>2016-2017</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>"
					+ StartUp.getProjected_revenue_rs1()
					+ "</td><td><label><b>2016-2017</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>"
					+ StartUp.getProjected_revenue_rs2()
					+ "</td><td><label><b>2016-2017</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>"
					+ StartUp.getProjected_revenue_rs3()
					+ "</td><td></td></tr>");
			buf.append("<tr style='line-height:16px;'><td colspan='4'><b>20.</b><label><b>Are you agreeable to allowing the Bank to conduct a process audit of your entity?</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>"
					+ StartUp.getAgreeable_process() + "</td></tr>");
			buf.append("<tr style='line-height:16px;'><td colspan='4'><b>21.</b><label><b>Are you registered with an Incubator recognised by the Government of India (refer http://startupindia.gov.in for details)</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>"
					+ StartUp.getStartupindia() + "</td></tr>");

			if (StartUp.getStartupindia().equalsIgnoreCase("Yes")) {

				buf.append("<tr style='line-height:16px;'><td colspan='4'><label><b>21.a Provide name of the incubator</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>"
						+ StartUp.getIncubator() + "</td></tr>");
			}

			for (int i = 0; i < resumeList.size(); i++) {
				String dopresume = df.format(resumeList.get(i).getDob());
				/*
				 * buf.append("<tr><td colspan='4'><br/><br/><br/></td></tr>" +
				 * "<tr><td colspan='4'><h3 style='color: #003d66;text-align:center;font-size:9px;'><b>Format For Resumes</b></h3></td></tr>"
				 * + "<tr><td colspan='4'></td></tr>");
				 */

				buf.append("<tr><td colspan='4'><table width='100%'>"
						+ "<tr><td colspan='4'><h3 style='color: #003d66;text-align:center;font-size:9px;'><b>Format For Resumes</b></h3></td></tr>"
						+ "<tr><td colspan='4'><br/></td></tr>"
						+ "<tr style='line-height:16px;'><td><b>1.</b><label><b>Name</b></label></td><td>"
						+ resumeList.get(i).getName()
						+ "</td><td><b>2.</b><label><b>Email Address</b></label></td><td>"
						+ resumeList.get(i).getEmail() + "</td></tr>");
				buf.append("<tr style='line-height:16px;'><td><b>3. </b><label><b>Mobile Number</b></label></td><td>"

						+ resumeList.get(i).getMnumber()

						+ "</td><td><b>4. </b><label><b>Date of Birth</b></label></td><td>"
						+ dopresume + "</td></tr>");

				buf.append("<tr style='line-height:16px;'><td colspan='4'><b>5.</b><label style='color:green'><b>Current Residential Address</b></label></td></tr>");

				buf.append("<tr style='line-height:16px;'><td  colspan='4'>"
						+ "<table width='100%'>"
						+ "<tr><td><label><b>Address Line1</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>"
						+ resumeList.get(i).getAddress_line_1()
						+ "</td>"
						+ "<td><label><b>Address Line2</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>"
						+ resumeList.get(i).getAddress_line_2()
						+ "</td></tr>"
						+ "<tr><td><label><b>Landmark</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>"
						+ resumeList.get(i).getAddress_landmark()
						+ "</td><td><label><b>City</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>"
						+ resumeList.get(i).getAddress_city()
						+ "</td></tr>"
						+ "<tr><td><label><b>PIN</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>"
						+ resumeList.get(i).getAddress_pin()
						+ "</td><td><label><b>State</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>"
						+ resumeList.get(i).getAddress_state()
						+ "</td></tr></table></td></tr>");

				buf.append("<tr style='line-height:16px;'><td colspan='4'><b>6.</b><label style='color:green'><b>Permanent Residential Address</b></label></td></tr>");

				buf.append("<tr style='line-height:16px;'><td  colspan='4'>"
						+ "<table width='100%'>"
						+ "<tr><td><label><b>Address Line1</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>"
						+ resumeList.get(i).getPerm_address_line_1()
						+ "</td>"
						+ "<td><label><b>Address Line2</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>"
						+ resumeList.get(i).getPerm_address_line_2()
						+ "</td></tr>"
						+ "<tr><td><label><b>Landmark</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>"
						+ resumeList.get(i).getPerm_address_landmark()
						+ "</td><td><label><b>City</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>"
						+ resumeList.get(i).getPerm_address_city()
						+ "</td></tr>"
						+ "<tr><td><label><b>PIN</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>"
						+ resumeList.get(i).getPerm_address_pin()
						+ "</td><td><label><b>State</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>"
						+ resumeList.get(i).getPerm_address_state()
						+ "</td></tr></table></td></tr>");

				buf.append("<tr style='line-height:16px;'><td>7. <label><b>PAN</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label></td><td>"
						+ resumeList.get(i).getPan()
						+ "</td><td>8.<label><b>Aadhaar No.</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label></td><td>"
						+ resumeList.get(i).getAadharNum() + "</td></tr>");
				buf.append("<tr style='line-height:16px;'><td colspan='4'><b>9.</b><label><b>Career Abstract</b><br/></label>"
						+ resumeList.get(i).getCarrerAspect()
						+ "</td></tr>"
						+ "<tr style='line-height:16px;'><td colspan='4'><b>10.</b><label><b>Key I.T. Skills</b><br/></label>"
						+ resumeList.get(i).getKeyITSkill()
						+ "</td></tr>"
						+ "<tr style='line-height:16px;'><td colspan='4'><b>11.</b><label><b>Certifications/Trainings</b><br/></label>"
						+ resumeList.get(i).getCertfTra()
						+ "</td></tr>"
						+ "<tr style='line-height:16px;'><td colspan='4'><b>12.</b><label><b>Employment History</b><br/></label>"
						+ resumeList.get(i).getEmpyHistory()
						+ "</td></tr>"
						+ "<tr style='line-height:16px;'><td colspan='4'><b>13.</b><label><b>Core Competencies</b><br/></label>"
						+ resumeList.get(i).getCoreComp()
						+ "</td></tr>"
						+ "<tr style='line-height:16px;'><td colspan='4'><b>14.</b><label><b>Accomplishments</b><br/></label>"
						+ resumeList.get(i).getAccomplishment()
						+ "</td></tr>"
						+ "<tr style='line-height:16px;'><td colspan='4'><b>15.</b><label><b>Academics (give from graduation onwards)</b><br/></label>"
						+ resumeList.get(i).getAcademics()
						+ "</td></tr></table></td></tr>");

				buf.append("<br/>");
			}
			buf.append("</table></div></body></html>");

			htmlWorker.parse(new StringReader(Str1.toString()));

			document.close();

			PdfReader reader = new PdfReader(baos.toByteArray());
			reader.makeRemoteNamedDestinationsLocal();
			baos = new ByteArrayOutputStream();
			PdfStamper stamper = new PdfStamper(reader, baos);
			BaseFont bf = BaseFont.createFont(BaseFont.TIMES_ROMAN,
					BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
			PdfContentByte cb;
			int n = reader.getNumberOfPages();
			for (int i = 1; i <= n; i++) {
				cb = stamper.getOverContent(i);
				float x = cb.getPdfDocument().getPageSize().getWidth() / 2;
				cb.beginText();
				cb.setFontAndSize(bf, 8);
				cb.showTextAligned(PdfContentByte.ALIGN_CENTER, "Page " + i
						+ " of " + n, x, 5, 0);
				cb.endText();
			}
			stamper.close();

			response.setProperty(HttpHeaders.EXPIRES, "0");
			response.setProperty(HttpHeaders.CACHE_CONTROL,
					HttpHeaders.CACHE_CONTROL_NO_CACHE_VALUE);
			response.setProperty(HttpHeaders.CONTENT_DISPOSITION,
					"attachement;filename=\"" + StartUp.getRegnum() + ".pdf\"");
			response.setProperty(HttpHeaders.PRAGMA, HttpHeaders.PUBLIC);

			// response.setProperty(HttpHeaders.PRAGMA_NO_CACHE_VALUE,HttpHeaders.PRAGMA_PUBLIC_VALUE);

			// setting the content type
			response.setContentType("application/pdf");
			// the contentlength
			response.setContentLength(baos.size());
			// write ByteArrayOutputStream to the ServletOutputStream
			OutputStream os = response.getPortletOutputStream();
			baos.writeTo(os);
			os.flush();
			os.close();
		} catch (DocumentException e) {
			throw new IOException(e.getMessage());
		}
		return null;

	}

	// Added by Syed

}