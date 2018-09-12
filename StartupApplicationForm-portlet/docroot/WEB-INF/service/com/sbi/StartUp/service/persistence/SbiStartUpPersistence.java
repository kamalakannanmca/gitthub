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

import com.sbi.StartUp.model.SbiStartUp;

/**
 * The persistence interface for the sbi start up service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author MAH97223
 * @see SbiStartUpPersistenceImpl
 * @see SbiStartUpUtil
 * @generated
 */
public interface SbiStartUpPersistence extends BasePersistence<SbiStartUp> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SbiStartUpUtil} to access the sbi start up persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the sbi start up in the entity cache if it is enabled.
	*
	* @param sbiStartUp the sbi start up
	*/
	public void cacheResult(com.sbi.StartUp.model.SbiStartUp sbiStartUp);

	/**
	* Caches the sbi start ups in the entity cache if it is enabled.
	*
	* @param sbiStartUps the sbi start ups
	*/
	public void cacheResult(
		java.util.List<com.sbi.StartUp.model.SbiStartUp> sbiStartUps);

	/**
	* Creates a new sbi start up with the primary key. Does not add the sbi start up to the database.
	*
	* @param regnum the primary key for the new sbi start up
	* @return the new sbi start up
	*/
	public com.sbi.StartUp.model.SbiStartUp create(java.lang.String regnum);

	/**
	* Removes the sbi start up with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param regnum the primary key of the sbi start up
	* @return the sbi start up that was removed
	* @throws com.sbi.StartUp.NoSuchSbiStartUpException if a sbi start up with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sbi.StartUp.model.SbiStartUp remove(java.lang.String regnum)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sbi.StartUp.NoSuchSbiStartUpException;

	public com.sbi.StartUp.model.SbiStartUp updateImpl(
		com.sbi.StartUp.model.SbiStartUp sbiStartUp, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the sbi start up with the primary key or throws a {@link com.sbi.StartUp.NoSuchSbiStartUpException} if it could not be found.
	*
	* @param regnum the primary key of the sbi start up
	* @return the sbi start up
	* @throws com.sbi.StartUp.NoSuchSbiStartUpException if a sbi start up with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sbi.StartUp.model.SbiStartUp findByPrimaryKey(
		java.lang.String regnum)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sbi.StartUp.NoSuchSbiStartUpException;

	/**
	* Returns the sbi start up with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param regnum the primary key of the sbi start up
	* @return the sbi start up, or <code>null</code> if a sbi start up with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sbi.StartUp.model.SbiStartUp fetchByPrimaryKey(
		java.lang.String regnum)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the sbi start ups where createDate = &#63;.
	*
	* @param createDate the create date
	* @return the matching sbi start ups
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sbi.StartUp.model.SbiStartUp> findBycreateDate(
		java.util.Date createDate)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the sbi start ups where createDate = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param createDate the create date
	* @param start the lower bound of the range of sbi start ups
	* @param end the upper bound of the range of sbi start ups (not inclusive)
	* @return the range of matching sbi start ups
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sbi.StartUp.model.SbiStartUp> findBycreateDate(
		java.util.Date createDate, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the sbi start ups where createDate = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param createDate the create date
	* @param start the lower bound of the range of sbi start ups
	* @param end the upper bound of the range of sbi start ups (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching sbi start ups
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sbi.StartUp.model.SbiStartUp> findBycreateDate(
		java.util.Date createDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first sbi start up in the ordered set where createDate = &#63;.
	*
	* @param createDate the create date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching sbi start up
	* @throws com.sbi.StartUp.NoSuchSbiStartUpException if a matching sbi start up could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sbi.StartUp.model.SbiStartUp findBycreateDate_First(
		java.util.Date createDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sbi.StartUp.NoSuchSbiStartUpException;

	/**
	* Returns the first sbi start up in the ordered set where createDate = &#63;.
	*
	* @param createDate the create date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching sbi start up, or <code>null</code> if a matching sbi start up could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sbi.StartUp.model.SbiStartUp fetchBycreateDate_First(
		java.util.Date createDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last sbi start up in the ordered set where createDate = &#63;.
	*
	* @param createDate the create date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching sbi start up
	* @throws com.sbi.StartUp.NoSuchSbiStartUpException if a matching sbi start up could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sbi.StartUp.model.SbiStartUp findBycreateDate_Last(
		java.util.Date createDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sbi.StartUp.NoSuchSbiStartUpException;

	/**
	* Returns the last sbi start up in the ordered set where createDate = &#63;.
	*
	* @param createDate the create date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching sbi start up, or <code>null</code> if a matching sbi start up could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sbi.StartUp.model.SbiStartUp fetchBycreateDate_Last(
		java.util.Date createDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the sbi start ups before and after the current sbi start up in the ordered set where createDate = &#63;.
	*
	* @param regnum the primary key of the current sbi start up
	* @param createDate the create date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next sbi start up
	* @throws com.sbi.StartUp.NoSuchSbiStartUpException if a sbi start up with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sbi.StartUp.model.SbiStartUp[] findBycreateDate_PrevAndNext(
		java.lang.String regnum, java.util.Date createDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sbi.StartUp.NoSuchSbiStartUpException;

	/**
	* Returns all the sbi start ups.
	*
	* @return the sbi start ups
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sbi.StartUp.model.SbiStartUp> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the sbi start ups.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of sbi start ups
	* @param end the upper bound of the range of sbi start ups (not inclusive)
	* @return the range of sbi start ups
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sbi.StartUp.model.SbiStartUp> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the sbi start ups.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of sbi start ups
	* @param end the upper bound of the range of sbi start ups (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of sbi start ups
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sbi.StartUp.model.SbiStartUp> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the sbi start ups where createDate = &#63; from the database.
	*
	* @param createDate the create date
	* @throws SystemException if a system exception occurred
	*/
	public void removeBycreateDate(java.util.Date createDate)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the sbi start ups from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of sbi start ups where createDate = &#63;.
	*
	* @param createDate the create date
	* @return the number of matching sbi start ups
	* @throws SystemException if a system exception occurred
	*/
	public int countBycreateDate(java.util.Date createDate)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of sbi start ups.
	*
	* @return the number of sbi start ups
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}