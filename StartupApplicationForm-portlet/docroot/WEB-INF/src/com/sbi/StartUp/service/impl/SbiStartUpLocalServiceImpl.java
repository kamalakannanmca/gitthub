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

package com.sbi.StartUp.service.impl;
import com.sbi.StartUp.service.base.SbiStartUpLocalServiceBaseImpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.liferay.portal.kernel.dao.jdbc.DataAccess;

/**
 * The implementation of the sbi start up local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.sbi.StartUp.service.SbiStartUpLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author MAH97223
 * @see com.sbi.StartUp.service.base.SbiStartUpLocalServiceBaseImpl
 * @see com.sbi.StartUp.service.SbiStartUpLocalServiceUtil
 */
public class SbiStartUpLocalServiceImpl extends SbiStartUpLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.sbi.StartUp.service.SbiStartUpLocalServiceUtil} to access the sbi start up local service.
	 */
	public int updatestatus(String regnum){
		 PreparedStatement stmt = null;
		 int result = 0;
		 Connection connection;
		try {
			connection = DataAccess.getConnection();
			 
			//String sqlquery = "update `sbicoinUat`.`sbistartup_sbistartup` set status = 'Applied' where regnum = "+regnum;
			String sqlquery = "UPDATE SBISTARTUP_SBISTARTUP SET status = 'Applied' where regnum = "+regnum;
		//	"UPDATE SBISTARTUP_SBISTARTUP SET status = 'Applied' where regnum = "+regnum;
			 
			 stmt = connection.prepareStatement(sqlquery);
			 result = stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			 
			e.printStackTrace();
		}	
	
		 
		 
		return result;
	}
	public int updatestatus(String status,String regnum){
		 PreparedStatement stmt = null;
		 int result = 0;
		 Connection connection;
		try {
			connection = DataAccess.getConnection();
			//String sqlquery = "update `sbicoin`.`sbistartup_sbistartup` set status = 'Submitted' where regnum = "+regnum;
			String sqlquery = "UPDATE SBISTARTUP_SBISTARTUP SET status = '"+status+"' where regnum = "+regnum;
		 
			 
			 stmt = connection.prepareStatement(sqlquery);
			 result = stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	 
		
		return result;
}
}