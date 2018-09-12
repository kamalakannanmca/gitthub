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

import com.liferay.portal.service.persistence.BasePersistence;

import com.sbi.StartUp.model.CapitalInf;

/**
 * The persistence interface for the capital inf service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author MAH97223
 * @see CapitalInfPersistenceImpl
 * @see CapitalInfUtil
 * @generated
 */
public interface CapitalInfPersistence extends BasePersistence<CapitalInf> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CapitalInfUtil} to access the capital inf persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the capital inf in the entity cache if it is enabled.
	*
	* @param capitalInf the capital inf
	*/
	public void cacheResult(com.sbi.StartUp.model.CapitalInf capitalInf);

	/**
	* Caches the capital infs in the entity cache if it is enabled.
	*
	* @param capitalInfs the capital infs
	*/
	public void cacheResult(
		java.util.List<com.sbi.StartUp.model.CapitalInf> capitalInfs);

	/**
	* Creates a new capital inf with the primary key. Does not add the capital inf to the database.
	*
	* @param InfRefId the primary key for the new capital inf
	* @return the new capital inf
	*/
	public com.sbi.StartUp.model.CapitalInf create(long InfRefId);

	/**
	* Removes the capital inf with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param InfRefId the primary key of the capital inf
	* @return the capital inf that was removed
	* @throws com.sbi.StartUp.NoSuchCapitalInfException if a capital inf with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sbi.StartUp.model.CapitalInf remove(long InfRefId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sbi.StartUp.NoSuchCapitalInfException;

	public com.sbi.StartUp.model.CapitalInf updateImpl(
		com.sbi.StartUp.model.CapitalInf capitalInf, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the capital inf with the primary key or throws a {@link com.sbi.StartUp.NoSuchCapitalInfException} if it could not be found.
	*
	* @param InfRefId the primary key of the capital inf
	* @return the capital inf
	* @throws com.sbi.StartUp.NoSuchCapitalInfException if a capital inf with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sbi.StartUp.model.CapitalInf findByPrimaryKey(long InfRefId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sbi.StartUp.NoSuchCapitalInfException;

	/**
	* Returns the capital inf with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param InfRefId the primary key of the capital inf
	* @return the capital inf, or <code>null</code> if a capital inf with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sbi.StartUp.model.CapitalInf fetchByPrimaryKey(long InfRefId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the capital infs where createDate = &#63;.
	*
	* @param createDate the create date
	* @return the matching capital infs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sbi.StartUp.model.CapitalInf> findBycreateDate(
		java.util.Date createDate)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sbi.StartUp.model.CapitalInf> findBycreateDate(
		java.util.Date createDate, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sbi.StartUp.model.CapitalInf> findBycreateDate(
		java.util.Date createDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first capital inf in the ordered set where createDate = &#63;.
	*
	* @param createDate the create date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching capital inf
	* @throws com.sbi.StartUp.NoSuchCapitalInfException if a matching capital inf could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sbi.StartUp.model.CapitalInf findBycreateDate_First(
		java.util.Date createDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sbi.StartUp.NoSuchCapitalInfException;

	/**
	* Returns the first capital inf in the ordered set where createDate = &#63;.
	*
	* @param createDate the create date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching capital inf, or <code>null</code> if a matching capital inf could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sbi.StartUp.model.CapitalInf fetchBycreateDate_First(
		java.util.Date createDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last capital inf in the ordered set where createDate = &#63;.
	*
	* @param createDate the create date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching capital inf
	* @throws com.sbi.StartUp.NoSuchCapitalInfException if a matching capital inf could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sbi.StartUp.model.CapitalInf findBycreateDate_Last(
		java.util.Date createDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sbi.StartUp.NoSuchCapitalInfException;

	/**
	* Returns the last capital inf in the ordered set where createDate = &#63;.
	*
	* @param createDate the create date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching capital inf, or <code>null</code> if a matching capital inf could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sbi.StartUp.model.CapitalInf fetchBycreateDate_Last(
		java.util.Date createDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sbi.StartUp.model.CapitalInf[] findBycreateDate_PrevAndNext(
		long InfRefId, java.util.Date createDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sbi.StartUp.NoSuchCapitalInfException;

	/**
	* Returns all the capital infs.
	*
	* @return the capital infs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sbi.StartUp.model.CapitalInf> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sbi.StartUp.model.CapitalInf> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sbi.StartUp.model.CapitalInf> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the capital infs where createDate = &#63; from the database.
	*
	* @param createDate the create date
	* @throws SystemException if a system exception occurred
	*/
	public void removeBycreateDate(java.util.Date createDate)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the capital infs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of capital infs where createDate = &#63;.
	*
	* @param createDate the create date
	* @return the number of matching capital infs
	* @throws SystemException if a system exception occurred
	*/
	public int countBycreateDate(java.util.Date createDate)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of capital infs.
	*
	* @return the number of capital infs
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}