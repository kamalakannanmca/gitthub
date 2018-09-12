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

package com.sbi.StartUp.service.base;

import com.liferay.counter.service.CounterLocalService;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.PersistedModel;
import com.liferay.portal.service.BaseLocalServiceImpl;
import com.liferay.portal.service.PersistedModelLocalServiceRegistryUtil;
import com.liferay.portal.service.ResourceLocalService;
import com.liferay.portal.service.ResourceService;
import com.liferay.portal.service.UserLocalService;
import com.liferay.portal.service.UserService;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;

import com.sbi.StartUp.model.SbiStartUp;
import com.sbi.StartUp.service.CapitalInfLocalService;
import com.sbi.StartUp.service.CapitalInfService;
import com.sbi.StartUp.service.ResumeDtlsLocalService;
import com.sbi.StartUp.service.ResumeDtlsService;
import com.sbi.StartUp.service.SbiStartUpLocalService;
import com.sbi.StartUp.service.SbiStartUpService;
import com.sbi.StartUp.service.persistence.CapitalInfPersistence;
import com.sbi.StartUp.service.persistence.ResumeDtlsPersistence;
import com.sbi.StartUp.service.persistence.SbiStartUpPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * The base implementation of the sbi start up local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.sbi.StartUp.service.impl.SbiStartUpLocalServiceImpl}.
 * </p>
 *
 * @author MAH97223
 * @see com.sbi.StartUp.service.impl.SbiStartUpLocalServiceImpl
 * @see com.sbi.StartUp.service.SbiStartUpLocalServiceUtil
 * @generated
 */
public abstract class SbiStartUpLocalServiceBaseImpl
	extends BaseLocalServiceImpl implements SbiStartUpLocalService,
		IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.sbi.StartUp.service.SbiStartUpLocalServiceUtil} to access the sbi start up local service.
	 */

	/**
	 * Adds the sbi start up to the database. Also notifies the appropriate model listeners.
	 *
	 * @param sbiStartUp the sbi start up
	 * @return the sbi start up that was added
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	public SbiStartUp addSbiStartUp(SbiStartUp sbiStartUp)
		throws SystemException {
		sbiStartUp.setNew(true);

		return sbiStartUpPersistence.update(sbiStartUp, false);
	}

	/**
	 * Creates a new sbi start up with the primary key. Does not add the sbi start up to the database.
	 *
	 * @param regnum the primary key for the new sbi start up
	 * @return the new sbi start up
	 */
	public SbiStartUp createSbiStartUp(String regnum) {
		return sbiStartUpPersistence.create(regnum);
	}

	/**
	 * Deletes the sbi start up with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param regnum the primary key of the sbi start up
	 * @return the sbi start up that was removed
	 * @throws PortalException if a sbi start up with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	public SbiStartUp deleteSbiStartUp(String regnum)
		throws PortalException, SystemException {
		return sbiStartUpPersistence.remove(regnum);
	}

	/**
	 * Deletes the sbi start up from the database. Also notifies the appropriate model listeners.
	 *
	 * @param sbiStartUp the sbi start up
	 * @return the sbi start up that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	public SbiStartUp deleteSbiStartUp(SbiStartUp sbiStartUp)
		throws SystemException {
		return sbiStartUpPersistence.remove(sbiStartUp);
	}

	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(SbiStartUp.class,
			clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return sbiStartUpPersistence.findWithDynamicQuery(dynamicQuery);
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
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return sbiStartUpPersistence.findWithDynamicQuery(dynamicQuery, start,
			end);
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
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return sbiStartUpPersistence.findWithDynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	 * Returns the number of rows that match the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows that match the dynamic query
	 * @throws SystemException if a system exception occurred
	 */
	public long dynamicQueryCount(DynamicQuery dynamicQuery)
		throws SystemException {
		return sbiStartUpPersistence.countWithDynamicQuery(dynamicQuery);
	}

	public SbiStartUp fetchSbiStartUp(String regnum) throws SystemException {
		return sbiStartUpPersistence.fetchByPrimaryKey(regnum);
	}

	/**
	 * Returns the sbi start up with the primary key.
	 *
	 * @param regnum the primary key of the sbi start up
	 * @return the sbi start up
	 * @throws PortalException if a sbi start up with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SbiStartUp getSbiStartUp(String regnum)
		throws PortalException, SystemException {
		return sbiStartUpPersistence.findByPrimaryKey(regnum);
	}

	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return sbiStartUpPersistence.findByPrimaryKey(primaryKeyObj);
	}

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
	public List<SbiStartUp> getSbiStartUps(int start, int end)
		throws SystemException {
		return sbiStartUpPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of sbi start ups.
	 *
	 * @return the number of sbi start ups
	 * @throws SystemException if a system exception occurred
	 */
	public int getSbiStartUpsCount() throws SystemException {
		return sbiStartUpPersistence.countAll();
	}

	/**
	 * Updates the sbi start up in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param sbiStartUp the sbi start up
	 * @return the sbi start up that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	public SbiStartUp updateSbiStartUp(SbiStartUp sbiStartUp)
		throws SystemException {
		return updateSbiStartUp(sbiStartUp, true);
	}

	/**
	 * Updates the sbi start up in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param sbiStartUp the sbi start up
	 * @param merge whether to merge the sbi start up with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	 * @return the sbi start up that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	public SbiStartUp updateSbiStartUp(SbiStartUp sbiStartUp, boolean merge)
		throws SystemException {
		sbiStartUp.setNew(false);

		return sbiStartUpPersistence.update(sbiStartUp, merge);
	}

	/**
	 * Returns the capital inf local service.
	 *
	 * @return the capital inf local service
	 */
	public CapitalInfLocalService getCapitalInfLocalService() {
		return capitalInfLocalService;
	}

	/**
	 * Sets the capital inf local service.
	 *
	 * @param capitalInfLocalService the capital inf local service
	 */
	public void setCapitalInfLocalService(
		CapitalInfLocalService capitalInfLocalService) {
		this.capitalInfLocalService = capitalInfLocalService;
	}

	/**
	 * Returns the capital inf remote service.
	 *
	 * @return the capital inf remote service
	 */
	public CapitalInfService getCapitalInfService() {
		return capitalInfService;
	}

	/**
	 * Sets the capital inf remote service.
	 *
	 * @param capitalInfService the capital inf remote service
	 */
	public void setCapitalInfService(CapitalInfService capitalInfService) {
		this.capitalInfService = capitalInfService;
	}

	/**
	 * Returns the capital inf persistence.
	 *
	 * @return the capital inf persistence
	 */
	public CapitalInfPersistence getCapitalInfPersistence() {
		return capitalInfPersistence;
	}

	/**
	 * Sets the capital inf persistence.
	 *
	 * @param capitalInfPersistence the capital inf persistence
	 */
	public void setCapitalInfPersistence(
		CapitalInfPersistence capitalInfPersistence) {
		this.capitalInfPersistence = capitalInfPersistence;
	}

	/**
	 * Returns the resume dtls local service.
	 *
	 * @return the resume dtls local service
	 */
	public ResumeDtlsLocalService getResumeDtlsLocalService() {
		return resumeDtlsLocalService;
	}

	/**
	 * Sets the resume dtls local service.
	 *
	 * @param resumeDtlsLocalService the resume dtls local service
	 */
	public void setResumeDtlsLocalService(
		ResumeDtlsLocalService resumeDtlsLocalService) {
		this.resumeDtlsLocalService = resumeDtlsLocalService;
	}

	/**
	 * Returns the resume dtls remote service.
	 *
	 * @return the resume dtls remote service
	 */
	public ResumeDtlsService getResumeDtlsService() {
		return resumeDtlsService;
	}

	/**
	 * Sets the resume dtls remote service.
	 *
	 * @param resumeDtlsService the resume dtls remote service
	 */
	public void setResumeDtlsService(ResumeDtlsService resumeDtlsService) {
		this.resumeDtlsService = resumeDtlsService;
	}

	/**
	 * Returns the resume dtls persistence.
	 *
	 * @return the resume dtls persistence
	 */
	public ResumeDtlsPersistence getResumeDtlsPersistence() {
		return resumeDtlsPersistence;
	}

	/**
	 * Sets the resume dtls persistence.
	 *
	 * @param resumeDtlsPersistence the resume dtls persistence
	 */
	public void setResumeDtlsPersistence(
		ResumeDtlsPersistence resumeDtlsPersistence) {
		this.resumeDtlsPersistence = resumeDtlsPersistence;
	}

	/**
	 * Returns the sbi start up local service.
	 *
	 * @return the sbi start up local service
	 */
	public SbiStartUpLocalService getSbiStartUpLocalService() {
		return sbiStartUpLocalService;
	}

	/**
	 * Sets the sbi start up local service.
	 *
	 * @param sbiStartUpLocalService the sbi start up local service
	 */
	public void setSbiStartUpLocalService(
		SbiStartUpLocalService sbiStartUpLocalService) {
		this.sbiStartUpLocalService = sbiStartUpLocalService;
	}

	/**
	 * Returns the sbi start up remote service.
	 *
	 * @return the sbi start up remote service
	 */
	public SbiStartUpService getSbiStartUpService() {
		return sbiStartUpService;
	}

	/**
	 * Sets the sbi start up remote service.
	 *
	 * @param sbiStartUpService the sbi start up remote service
	 */
	public void setSbiStartUpService(SbiStartUpService sbiStartUpService) {
		this.sbiStartUpService = sbiStartUpService;
	}

	/**
	 * Returns the sbi start up persistence.
	 *
	 * @return the sbi start up persistence
	 */
	public SbiStartUpPersistence getSbiStartUpPersistence() {
		return sbiStartUpPersistence;
	}

	/**
	 * Sets the sbi start up persistence.
	 *
	 * @param sbiStartUpPersistence the sbi start up persistence
	 */
	public void setSbiStartUpPersistence(
		SbiStartUpPersistence sbiStartUpPersistence) {
		this.sbiStartUpPersistence = sbiStartUpPersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the resource remote service.
	 *
	 * @return the resource remote service
	 */
	public ResourceService getResourceService() {
		return resourceService;
	}

	/**
	 * Sets the resource remote service.
	 *
	 * @param resourceService the resource remote service
	 */
	public void setResourceService(ResourceService resourceService) {
		this.resourceService = resourceService;
	}

	/**
	 * Returns the resource persistence.
	 *
	 * @return the resource persistence
	 */
	public ResourcePersistence getResourcePersistence() {
		return resourcePersistence;
	}

	/**
	 * Sets the resource persistence.
	 *
	 * @param resourcePersistence the resource persistence
	 */
	public void setResourcePersistence(ResourcePersistence resourcePersistence) {
		this.resourcePersistence = resourcePersistence;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		Class<?> clazz = getClass();

		_classLoader = clazz.getClassLoader();

		PersistedModelLocalServiceRegistryUtil.register("com.sbi.StartUp.model.SbiStartUp",
			sbiStartUpLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"com.sbi.StartUp.model.SbiStartUp");
	}

	/**
	 * Returns the Spring bean ID for this bean.
	 *
	 * @return the Spring bean ID for this bean
	 */
	public String getBeanIdentifier() {
		return _beanIdentifier;
	}

	/**
	 * Sets the Spring bean ID for this bean.
	 *
	 * @param beanIdentifier the Spring bean ID for this bean
	 */
	public void setBeanIdentifier(String beanIdentifier) {
		_beanIdentifier = beanIdentifier;
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		if (contextClassLoader != _classLoader) {
			currentThread.setContextClassLoader(_classLoader);
		}

		try {
			return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
		}
		finally {
			if (contextClassLoader != _classLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	protected Class<?> getModelClass() {
		return SbiStartUp.class;
	}

	protected String getModelClassName() {
		return SbiStartUp.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = sbiStartUpPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = CapitalInfLocalService.class)
	protected CapitalInfLocalService capitalInfLocalService;
	@BeanReference(type = CapitalInfService.class)
	protected CapitalInfService capitalInfService;
	@BeanReference(type = CapitalInfPersistence.class)
	protected CapitalInfPersistence capitalInfPersistence;
	@BeanReference(type = ResumeDtlsLocalService.class)
	protected ResumeDtlsLocalService resumeDtlsLocalService;
	@BeanReference(type = ResumeDtlsService.class)
	protected ResumeDtlsService resumeDtlsService;
	@BeanReference(type = ResumeDtlsPersistence.class)
	protected ResumeDtlsPersistence resumeDtlsPersistence;
	@BeanReference(type = SbiStartUpLocalService.class)
	protected SbiStartUpLocalService sbiStartUpLocalService;
	@BeanReference(type = SbiStartUpService.class)
	protected SbiStartUpService sbiStartUpService;
	@BeanReference(type = SbiStartUpPersistence.class)
	protected SbiStartUpPersistence sbiStartUpPersistence;
	@BeanReference(type = CounterLocalService.class)
	protected CounterLocalService counterLocalService;
	@BeanReference(type = ResourceLocalService.class)
	protected ResourceLocalService resourceLocalService;
	@BeanReference(type = ResourceService.class)
	protected ResourceService resourceService;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserLocalService.class)
	protected UserLocalService userLocalService;
	@BeanReference(type = UserService.class)
	protected UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private String _beanIdentifier;
	private ClassLoader _classLoader;
	private SbiStartUpLocalServiceClpInvoker _clpInvoker = new SbiStartUpLocalServiceClpInvoker();
}