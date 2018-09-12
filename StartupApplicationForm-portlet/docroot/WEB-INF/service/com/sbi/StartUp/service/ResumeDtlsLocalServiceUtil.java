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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * The utility for the resume dtls local service. This utility wraps {@link com.sbi.StartUp.service.impl.ResumeDtlsLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author MAH97223
 * @see ResumeDtlsLocalService
 * @see com.sbi.StartUp.service.base.ResumeDtlsLocalServiceBaseImpl
 * @see com.sbi.StartUp.service.impl.ResumeDtlsLocalServiceImpl
 * @generated
 */
public class ResumeDtlsLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.sbi.StartUp.service.impl.ResumeDtlsLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the resume dtls to the database. Also notifies the appropriate model listeners.
	*
	* @param resumeDtls the resume dtls
	* @return the resume dtls that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.sbi.StartUp.model.ResumeDtls addResumeDtls(
		com.sbi.StartUp.model.ResumeDtls resumeDtls)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addResumeDtls(resumeDtls);
	}

	/**
	* Creates a new resume dtls with the primary key. Does not add the resume dtls to the database.
	*
	* @param ResumeId the primary key for the new resume dtls
	* @return the new resume dtls
	*/
	public static com.sbi.StartUp.model.ResumeDtls createResumeDtls(
		long ResumeId) {
		return getService().createResumeDtls(ResumeId);
	}

	/**
	* Deletes the resume dtls with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ResumeId the primary key of the resume dtls
	* @return the resume dtls that was removed
	* @throws PortalException if a resume dtls with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sbi.StartUp.model.ResumeDtls deleteResumeDtls(
		long ResumeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteResumeDtls(ResumeId);
	}

	/**
	* Deletes the resume dtls from the database. Also notifies the appropriate model listeners.
	*
	* @param resumeDtls the resume dtls
	* @return the resume dtls that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.sbi.StartUp.model.ResumeDtls deleteResumeDtls(
		com.sbi.StartUp.model.ResumeDtls resumeDtls)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteResumeDtls(resumeDtls);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	public static com.sbi.StartUp.model.ResumeDtls fetchResumeDtls(
		long ResumeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchResumeDtls(ResumeId);
	}

	/**
	* Returns the resume dtls with the primary key.
	*
	* @param ResumeId the primary key of the resume dtls
	* @return the resume dtls
	* @throws PortalException if a resume dtls with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sbi.StartUp.model.ResumeDtls getResumeDtls(long ResumeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getResumeDtls(ResumeId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<com.sbi.StartUp.model.ResumeDtls> getResumeDtlses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getResumeDtlses(start, end);
	}

	/**
	* Returns the number of resume dtlses.
	*
	* @return the number of resume dtlses
	* @throws SystemException if a system exception occurred
	*/
	public static int getResumeDtlsesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getResumeDtlsesCount();
	}

	/**
	* Updates the resume dtls in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param resumeDtls the resume dtls
	* @return the resume dtls that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.sbi.StartUp.model.ResumeDtls updateResumeDtls(
		com.sbi.StartUp.model.ResumeDtls resumeDtls)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateResumeDtls(resumeDtls);
	}

	/**
	* Updates the resume dtls in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param resumeDtls the resume dtls
	* @param merge whether to merge the resume dtls with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the resume dtls that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.sbi.StartUp.model.ResumeDtls updateResumeDtls(
		com.sbi.StartUp.model.ResumeDtls resumeDtls, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateResumeDtls(resumeDtls, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static void clearService() {
		_service = null;
	}

	public static ResumeDtlsLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					ResumeDtlsLocalService.class.getName());

			if (invokableLocalService instanceof ResumeDtlsLocalService) {
				_service = (ResumeDtlsLocalService)invokableLocalService;
			}
			else {
				_service = new ResumeDtlsLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(ResumeDtlsLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated
	 */
	public void setService(ResumeDtlsLocalService service) {
	}

	private static ResumeDtlsLocalService _service;
}