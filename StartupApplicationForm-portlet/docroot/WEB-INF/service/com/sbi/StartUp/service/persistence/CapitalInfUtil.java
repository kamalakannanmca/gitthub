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

package com.sbi.StartUp.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.sbi.StartUp.model.CapitalInf;

import java.util.List;

/**
 * The persistence utility for the capital inf service. This utility wraps {@link CapitalInfPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author MAH97223
 * @see CapitalInfPersistence
 * @see CapitalInfPersistenceImpl
 * @generated
 */
public class CapitalInfUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(CapitalInf capitalInf) {
		getPersistence().clearCache(capitalInf);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<CapitalInf> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CapitalInf> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CapitalInf> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static CapitalInf update(CapitalInf capitalInf, boolean merge)
		throws SystemException {
		return getPersistence().update(capitalInf, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static CapitalInf update(CapitalInf capitalInf, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(capitalInf, merge, serviceContext);
	}

	/**
	* Caches the capital inf in the entity cache if it is enabled.
	*
	* @param capitalInf the capital inf
	*/
	public static void cacheResult(com.sbi.StartUp.model.CapitalInf capitalInf) {
		getPersistence().cacheResult(capitalInf);
	}

	/**
	* Caches the capital infs in the entity cache if it is enabled.
	*
	* @param capitalInfs the capital infs
	*/
	public static void cacheResult(
		java.util.List<com.sbi.StartUp.model.CapitalInf> capitalInfs) {
		getPersistence().cacheResult(capitalInfs);
	}

	/**
	* Creates a new capital inf with the primary key. Does not add the capital inf to the database.
	*
	* @param InfRefId the primary key for the new capital inf
	* @return the new capital inf
	*/
	public static com.sbi.StartUp.model.CapitalInf create(long InfRefId) {
		return getPersistence().create(InfRefId);
	}

	/**
	* Removes the capital inf with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param InfRefId the primary key of the capital inf
	* @return the capital inf that was removed
	* @throws com.sbi.StartUp.NoSuchCapitalInfException if a capital inf with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sbi.StartUp.model.CapitalInf remove(long InfRefId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sbi.StartUp.NoSuchCapitalInfException {
		return getPersistence().remove(InfRefId);
	}

	public static com.sbi.StartUp.model.CapitalInf updateImpl(
		com.sbi.StartUp.model.CapitalInf capitalInf, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(capitalInf, merge);
	}

	/**
	* Returns the capital inf with the primary key or throws a {@link com.sbi.StartUp.NoSuchCapitalInfException} if it could not be found.
	*
	* @param InfRefId the primary key of the capital inf
	* @return the capital inf
	* @throws com.sbi.StartUp.NoSuchCapitalInfException if a capital inf with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sbi.StartUp.model.CapitalInf findByPrimaryKey(
		long InfRefId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sbi.StartUp.NoSuchCapitalInfException {
		return getPersistence().findByPrimaryKey(InfRefId);
	}

	/**
	* Returns the capital inf with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param InfRefId the primary key of the capital inf
	* @return the capital inf, or <code>null</code> if a capital inf with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sbi.StartUp.model.CapitalInf fetchByPrimaryKey(
		long InfRefId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(InfRefId);
	}

	/**
	* Returns all the capital infs where createDate = &#63;.
	*
	* @param createDate the create date
	* @return the matching capital infs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sbi.StartUp.model.CapitalInf> findBycreateDate(
		java.util.Date createDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBycreateDate(createDate);
	}

	/**
	* Returns a range of all the capital infs where createDate = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param createDate the create date
	* @param start the lower bound of the range of capital infs
	* @param end the upper bound of the range of capital infs (not inclusive)
	* @return the range of matching capital infs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sbi.StartUp.model.CapitalInf> findBycreateDate(
		java.util.Date createDate, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBycreateDate(createDate, start, end);
	}

	/**
	* Returns an ordered range of all the capital infs where createDate = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param createDate the create date
	* @param start the lower bound of the range of capital infs
	* @param end the upper bound of the range of capital infs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching capital infs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sbi.StartUp.model.CapitalInf> findBycreateDate(
		java.util.Date createDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBycreateDate(createDate, start, end, orderByComparator);
	}

	/**
	* Returns the first capital inf in the ordered set where createDate = &#63;.
	*
	* @param createDate the create date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching capital inf
	* @throws com.sbi.StartUp.NoSuchCapitalInfException if a matching capital inf could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sbi.StartUp.model.CapitalInf findBycreateDate_First(
		java.util.Date createDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sbi.StartUp.NoSuchCapitalInfException {
		return getPersistence()
				   .findBycreateDate_First(createDate, orderByComparator);
	}

	/**
	* Returns the first capital inf in the ordered set where createDate = &#63;.
	*
	* @param createDate the create date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching capital inf, or <code>null</code> if a matching capital inf could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sbi.StartUp.model.CapitalInf fetchBycreateDate_First(
		java.util.Date createDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBycreateDate_First(createDate, orderByComparator);
	}

	/**
	* Returns the last capital inf in the ordered set where createDate = &#63;.
	*
	* @param createDate the create date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching capital inf
	* @throws com.sbi.StartUp.NoSuchCapitalInfException if a matching capital inf could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sbi.StartUp.model.CapitalInf findBycreateDate_Last(
		java.util.Date createDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sbi.StartUp.NoSuchCapitalInfException {
		return getPersistence()
				   .findBycreateDate_Last(createDate, orderByComparator);
	}

	/**
	* Returns the last capital inf in the ordered set where createDate = &#63;.
	*
	* @param createDate the create date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching capital inf, or <code>null</code> if a matching capital inf could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sbi.StartUp.model.CapitalInf fetchBycreateDate_Last(
		java.util.Date createDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBycreateDate_Last(createDate, orderByComparator);
	}

	/**
	* Returns the capital infs before and after the current capital inf in the ordered set where createDate = &#63;.
	*
	* @param InfRefId the primary key of the current capital inf
	* @param createDate the create date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next capital inf
	* @throws com.sbi.StartUp.NoSuchCapitalInfException if a capital inf with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sbi.StartUp.model.CapitalInf[] findBycreateDate_PrevAndNext(
		long InfRefId, java.util.Date createDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sbi.StartUp.NoSuchCapitalInfException {
		return getPersistence()
				   .findBycreateDate_PrevAndNext(InfRefId, createDate,
			orderByComparator);
	}

	/**
	* Returns all the capital infs.
	*
	* @return the capital infs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sbi.StartUp.model.CapitalInf> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the capital infs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of capital infs
	* @param end the upper bound of the range of capital infs (not inclusive)
	* @return the range of capital infs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sbi.StartUp.model.CapitalInf> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the capital infs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of capital infs
	* @param end the upper bound of the range of capital infs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of capital infs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sbi.StartUp.model.CapitalInf> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the capital infs where createDate = &#63; from the database.
	*
	* @param createDate the create date
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBycreateDate(java.util.Date createDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBycreateDate(createDate);
	}

	/**
	* Removes all the capital infs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of capital infs where createDate = &#63;.
	*
	* @param createDate the create date
	* @return the number of matching capital infs
	* @throws SystemException if a system exception occurred
	*/
	public static int countBycreateDate(java.util.Date createDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBycreateDate(createDate);
	}

	/**
	* Returns the number of capital infs.
	*
	* @return the number of capital infs
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static CapitalInfPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (CapitalInfPersistence)PortletBeanLocatorUtil.locate(com.sbi.StartUp.service.ClpSerializer.getServletContextName(),
					CapitalInfPersistence.class.getName());

			ReferenceRegistry.registerReference(CapitalInfUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(CapitalInfPersistence persistence) {
	}

	private static CapitalInfPersistence _persistence;
}