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

import com.sbi.StartUp.model.ResumeDtls;

/**
 * The persistence interface for the resume dtls service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author MAH97223
 * @see ResumeDtlsPersistenceImpl
 * @see ResumeDtlsUtil
 * @generated
 */
public interface ResumeDtlsPersistence extends BasePersistence<ResumeDtls> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ResumeDtlsUtil} to access the resume dtls persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the resume dtls in the entity cache if it is enabled.
	*
	* @param resumeDtls the resume dtls
	*/
	public void cacheResult(com.sbi.StartUp.model.ResumeDtls resumeDtls);

	/**
	* Caches the resume dtlses in the entity cache if it is enabled.
	*
	* @param resumeDtlses the resume dtlses
	*/
	public void cacheResult(
		java.util.List<com.sbi.StartUp.model.ResumeDtls> resumeDtlses);

	/**
	* Creates a new resume dtls with the primary key. Does not add the resume dtls to the database.
	*
	* @param ResumeId the primary key for the new resume dtls
	* @return the new resume dtls
	*/
	public com.sbi.StartUp.model.ResumeDtls create(long ResumeId);

	/**
	* Removes the resume dtls with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ResumeId the primary key of the resume dtls
	* @return the resume dtls that was removed
	* @throws com.sbi.StartUp.NoSuchResumeDtlsException if a resume dtls with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sbi.StartUp.model.ResumeDtls remove(long ResumeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sbi.StartUp.NoSuchResumeDtlsException;

	public com.sbi.StartUp.model.ResumeDtls updateImpl(
		com.sbi.StartUp.model.ResumeDtls resumeDtls, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the resume dtls with the primary key or throws a {@link com.sbi.StartUp.NoSuchResumeDtlsException} if it could not be found.
	*
	* @param ResumeId the primary key of the resume dtls
	* @return the resume dtls
	* @throws com.sbi.StartUp.NoSuchResumeDtlsException if a resume dtls with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sbi.StartUp.model.ResumeDtls findByPrimaryKey(long ResumeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sbi.StartUp.NoSuchResumeDtlsException;

	/**
	* Returns the resume dtls with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param ResumeId the primary key of the resume dtls
	* @return the resume dtls, or <code>null</code> if a resume dtls with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sbi.StartUp.model.ResumeDtls fetchByPrimaryKey(long ResumeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the resume dtlses where createDate = &#63;.
	*
	* @param createDate the create date
	* @return the matching resume dtlses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sbi.StartUp.model.ResumeDtls> findBycreateDate(
		java.util.Date createDate)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the resume dtlses where createDate = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param createDate the create date
	* @param start the lower bound of the range of resume dtlses
	* @param end the upper bound of the range of resume dtlses (not inclusive)
	* @return the range of matching resume dtlses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sbi.StartUp.model.ResumeDtls> findBycreateDate(
		java.util.Date createDate, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the resume dtlses where createDate = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param createDate the create date
	* @param start the lower bound of the range of resume dtlses
	* @param end the upper bound of the range of resume dtlses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching resume dtlses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sbi.StartUp.model.ResumeDtls> findBycreateDate(
		java.util.Date createDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first resume dtls in the ordered set where createDate = &#63;.
	*
	* @param createDate the create date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching resume dtls
	* @throws com.sbi.StartUp.NoSuchResumeDtlsException if a matching resume dtls could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sbi.StartUp.model.ResumeDtls findBycreateDate_First(
		java.util.Date createDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sbi.StartUp.NoSuchResumeDtlsException;

	/**
	* Returns the first resume dtls in the ordered set where createDate = &#63;.
	*
	* @param createDate the create date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching resume dtls, or <code>null</code> if a matching resume dtls could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sbi.StartUp.model.ResumeDtls fetchBycreateDate_First(
		java.util.Date createDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last resume dtls in the ordered set where createDate = &#63;.
	*
	* @param createDate the create date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching resume dtls
	* @throws com.sbi.StartUp.NoSuchResumeDtlsException if a matching resume dtls could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sbi.StartUp.model.ResumeDtls findBycreateDate_Last(
		java.util.Date createDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sbi.StartUp.NoSuchResumeDtlsException;

	/**
	* Returns the last resume dtls in the ordered set where createDate = &#63;.
	*
	* @param createDate the create date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching resume dtls, or <code>null</code> if a matching resume dtls could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sbi.StartUp.model.ResumeDtls fetchBycreateDate_Last(
		java.util.Date createDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the resume dtlses before and after the current resume dtls in the ordered set where createDate = &#63;.
	*
	* @param ResumeId the primary key of the current resume dtls
	* @param createDate the create date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next resume dtls
	* @throws com.sbi.StartUp.NoSuchResumeDtlsException if a resume dtls with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sbi.StartUp.model.ResumeDtls[] findBycreateDate_PrevAndNext(
		long ResumeId, java.util.Date createDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sbi.StartUp.NoSuchResumeDtlsException;

	/**
	* Returns all the resume dtlses.
	*
	* @return the resume dtlses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sbi.StartUp.model.ResumeDtls> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the resume dtlses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of resume dtlses
	* @param end the upper bound of the range of resume dtlses (not inclusive)
	* @return the range of resume dtlses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sbi.StartUp.model.ResumeDtls> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the resume dtlses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of resume dtlses
	* @param end the upper bound of the range of resume dtlses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of resume dtlses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sbi.StartUp.model.ResumeDtls> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the resume dtlses where createDate = &#63; from the database.
	*
	* @param createDate the create date
	* @throws SystemException if a system exception occurred
	*/
	public void removeBycreateDate(java.util.Date createDate)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the resume dtlses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of resume dtlses where createDate = &#63;.
	*
	* @param createDate the create date
	* @return the number of matching resume dtlses
	* @throws SystemException if a system exception occurred
	*/
	public int countBycreateDate(java.util.Date createDate)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of resume dtlses.
	*
	* @return the number of resume dtlses
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}