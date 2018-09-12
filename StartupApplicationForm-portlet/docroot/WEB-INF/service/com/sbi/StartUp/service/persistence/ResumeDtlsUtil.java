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

import com.sbi.StartUp.model.ResumeDtls;

import java.util.List;

/**
 * The persistence utility for the resume dtls service. This utility wraps {@link ResumeDtlsPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author MAH97223
 * @see ResumeDtlsPersistence
 * @see ResumeDtlsPersistenceImpl
 * @generated
 */
public class ResumeDtlsUtil {
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
	public static void clearCache(ResumeDtls resumeDtls) {
		getPersistence().clearCache(resumeDtls);
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
	public static List<ResumeDtls> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ResumeDtls> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ResumeDtls> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static ResumeDtls update(ResumeDtls resumeDtls, boolean merge)
		throws SystemException {
		return getPersistence().update(resumeDtls, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static ResumeDtls update(ResumeDtls resumeDtls, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(resumeDtls, merge, serviceContext);
	}

	/**
	* Caches the resume dtls in the entity cache if it is enabled.
	*
	* @param resumeDtls the resume dtls
	*/
	public static void cacheResult(com.sbi.StartUp.model.ResumeDtls resumeDtls) {
		getPersistence().cacheResult(resumeDtls);
	}

	/**
	* Caches the resume dtlses in the entity cache if it is enabled.
	*
	* @param resumeDtlses the resume dtlses
	*/
	public static void cacheResult(
		java.util.List<com.sbi.StartUp.model.ResumeDtls> resumeDtlses) {
		getPersistence().cacheResult(resumeDtlses);
	}

	/**
	* Creates a new resume dtls with the primary key. Does not add the resume dtls to the database.
	*
	* @param ResumeId the primary key for the new resume dtls
	* @return the new resume dtls
	*/
	public static com.sbi.StartUp.model.ResumeDtls create(long ResumeId) {
		return getPersistence().create(ResumeId);
	}

	/**
	* Removes the resume dtls with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ResumeId the primary key of the resume dtls
	* @return the resume dtls that was removed
	* @throws com.sbi.StartUp.NoSuchResumeDtlsException if a resume dtls with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sbi.StartUp.model.ResumeDtls remove(long ResumeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sbi.StartUp.NoSuchResumeDtlsException {
		return getPersistence().remove(ResumeId);
	}

	public static com.sbi.StartUp.model.ResumeDtls updateImpl(
		com.sbi.StartUp.model.ResumeDtls resumeDtls, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(resumeDtls, merge);
	}

	/**
	* Returns the resume dtls with the primary key or throws a {@link com.sbi.StartUp.NoSuchResumeDtlsException} if it could not be found.
	*
	* @param ResumeId the primary key of the resume dtls
	* @return the resume dtls
	* @throws com.sbi.StartUp.NoSuchResumeDtlsException if a resume dtls with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sbi.StartUp.model.ResumeDtls findByPrimaryKey(
		long ResumeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sbi.StartUp.NoSuchResumeDtlsException {
		return getPersistence().findByPrimaryKey(ResumeId);
	}

	/**
	* Returns the resume dtls with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param ResumeId the primary key of the resume dtls
	* @return the resume dtls, or <code>null</code> if a resume dtls with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sbi.StartUp.model.ResumeDtls fetchByPrimaryKey(
		long ResumeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(ResumeId);
	}

	/**
	* Returns all the resume dtlses where createDate = &#63;.
	*
	* @param createDate the create date
	* @return the matching resume dtlses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sbi.StartUp.model.ResumeDtls> findBycreateDate(
		java.util.Date createDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBycreateDate(createDate);
	}

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
	public static java.util.List<com.sbi.StartUp.model.ResumeDtls> findBycreateDate(
		java.util.Date createDate, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBycreateDate(createDate, start, end);
	}

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
	public static java.util.List<com.sbi.StartUp.model.ResumeDtls> findBycreateDate(
		java.util.Date createDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBycreateDate(createDate, start, end, orderByComparator);
	}

	/**
	* Returns the first resume dtls in the ordered set where createDate = &#63;.
	*
	* @param createDate the create date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching resume dtls
	* @throws com.sbi.StartUp.NoSuchResumeDtlsException if a matching resume dtls could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sbi.StartUp.model.ResumeDtls findBycreateDate_First(
		java.util.Date createDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sbi.StartUp.NoSuchResumeDtlsException {
		return getPersistence()
				   .findBycreateDate_First(createDate, orderByComparator);
	}

	/**
	* Returns the first resume dtls in the ordered set where createDate = &#63;.
	*
	* @param createDate the create date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching resume dtls, or <code>null</code> if a matching resume dtls could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sbi.StartUp.model.ResumeDtls fetchBycreateDate_First(
		java.util.Date createDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBycreateDate_First(createDate, orderByComparator);
	}

	/**
	* Returns the last resume dtls in the ordered set where createDate = &#63;.
	*
	* @param createDate the create date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching resume dtls
	* @throws com.sbi.StartUp.NoSuchResumeDtlsException if a matching resume dtls could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sbi.StartUp.model.ResumeDtls findBycreateDate_Last(
		java.util.Date createDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sbi.StartUp.NoSuchResumeDtlsException {
		return getPersistence()
				   .findBycreateDate_Last(createDate, orderByComparator);
	}

	/**
	* Returns the last resume dtls in the ordered set where createDate = &#63;.
	*
	* @param createDate the create date
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching resume dtls, or <code>null</code> if a matching resume dtls could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sbi.StartUp.model.ResumeDtls fetchBycreateDate_Last(
		java.util.Date createDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBycreateDate_Last(createDate, orderByComparator);
	}

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
	public static com.sbi.StartUp.model.ResumeDtls[] findBycreateDate_PrevAndNext(
		long ResumeId, java.util.Date createDate,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sbi.StartUp.NoSuchResumeDtlsException {
		return getPersistence()
				   .findBycreateDate_PrevAndNext(ResumeId, createDate,
			orderByComparator);
	}

	/**
	* Returns all the resume dtlses.
	*
	* @return the resume dtlses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sbi.StartUp.model.ResumeDtls> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.sbi.StartUp.model.ResumeDtls> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.sbi.StartUp.model.ResumeDtls> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the resume dtlses where createDate = &#63; from the database.
	*
	* @param createDate the create date
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBycreateDate(java.util.Date createDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBycreateDate(createDate);
	}

	/**
	* Removes all the resume dtlses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of resume dtlses where createDate = &#63;.
	*
	* @param createDate the create date
	* @return the number of matching resume dtlses
	* @throws SystemException if a system exception occurred
	*/
	public static int countBycreateDate(java.util.Date createDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBycreateDate(createDate);
	}

	/**
	* Returns the number of resume dtlses.
	*
	* @return the number of resume dtlses
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ResumeDtlsPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ResumeDtlsPersistence)PortletBeanLocatorUtil.locate(com.sbi.StartUp.service.ClpSerializer.getServletContextName(),
					ResumeDtlsPersistence.class.getName());

			ReferenceRegistry.registerReference(ResumeDtlsUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(ResumeDtlsPersistence persistence) {
	}

	private static ResumeDtlsPersistence _persistence;
}