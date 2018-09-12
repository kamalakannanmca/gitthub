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

package com.sbi.StartUp.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link SbiStartUpService}.
 * </p>
 *
 * @author    MAH97223
 * @see       SbiStartUpService
 * @generated
 */
public class SbiStartUpServiceWrapper implements SbiStartUpService,
	ServiceWrapper<SbiStartUpService> {
	public SbiStartUpServiceWrapper(SbiStartUpService sbiStartUpService) {
		_sbiStartUpService = sbiStartUpService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _sbiStartUpService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_sbiStartUpService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _sbiStartUpService.invokeMethod(name, parameterTypes, arguments);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public SbiStartUpService getWrappedSbiStartUpService() {
		return _sbiStartUpService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedSbiStartUpService(SbiStartUpService sbiStartUpService) {
		_sbiStartUpService = sbiStartUpService;
	}

	public SbiStartUpService getWrappedService() {
		return _sbiStartUpService;
	}

	public void setWrappedService(SbiStartUpService sbiStartUpService) {
		_sbiStartUpService = sbiStartUpService;
	}

	private SbiStartUpService _sbiStartUpService;
}