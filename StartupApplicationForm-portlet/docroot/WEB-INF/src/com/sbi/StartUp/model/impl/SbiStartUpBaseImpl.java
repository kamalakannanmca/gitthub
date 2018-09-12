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

package com.sbi.StartUp.model.impl;

import com.liferay.portal.kernel.exception.SystemException;

import com.sbi.StartUp.model.SbiStartUp;
import com.sbi.StartUp.service.SbiStartUpLocalServiceUtil;

/**
 * The extended model base implementation for the SbiStartUp service. Represents a row in the &quot;SbiStartUp_SbiStartUp&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link SbiStartUpImpl}.
 * </p>
 *
 * @author MAH97223
 * @see SbiStartUpImpl
 * @see com.sbi.StartUp.model.SbiStartUp
 * @generated
 */
public abstract class SbiStartUpBaseImpl extends SbiStartUpModelImpl
	implements SbiStartUp {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a sbi start up model instance should use the {@link SbiStartUp} interface instead.
	 */
	public void persist() throws SystemException {
		if (this.isNew()) {
			SbiStartUpLocalServiceUtil.addSbiStartUp(this);
		}
		else {
			SbiStartUpLocalServiceUtil.updateSbiStartUp(this);
		}
	}
}