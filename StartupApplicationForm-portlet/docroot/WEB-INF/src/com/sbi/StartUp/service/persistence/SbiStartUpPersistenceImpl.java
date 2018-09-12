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

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.CalendarUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.sbi.StartUp.NoSuchSbiStartUpException;
import com.sbi.StartUp.model.SbiStartUp;
import com.sbi.StartUp.model.impl.SbiStartUpImpl;
import com.sbi.StartUp.model.impl.SbiStartUpModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * The persistence implementation for the sbi start up service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author MAH97223
 * @see SbiStartUpPersistence
 * @see SbiStartUpUtil
 * @generated
 */
public class SbiStartUpPersistenceImpl extends BasePersistenceImpl<SbiStartUp>
	implements SbiStartUpPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SbiStartUpUtil} to access the sbi start up persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SbiStartUpImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CREATEDATE =
		new FinderPath(SbiStartUpModelImpl.ENTITY_CACHE_ENABLED,
			SbiStartUpModelImpl.FINDER_CACHE_ENABLED, SbiStartUpImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBycreateDate",
			new String[] {
				Date.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREATEDATE =
		new FinderPath(SbiStartUpModelImpl.ENTITY_CACHE_ENABLED,
			SbiStartUpModelImpl.FINDER_CACHE_ENABLED, SbiStartUpImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBycreateDate",
			new String[] { Date.class.getName() },
			SbiStartUpModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CREATEDATE = new FinderPath(SbiStartUpModelImpl.ENTITY_CACHE_ENABLED,
			SbiStartUpModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBycreateDate",
			new String[] { Date.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SbiStartUpModelImpl.ENTITY_CACHE_ENABLED,
			SbiStartUpModelImpl.FINDER_CACHE_ENABLED, SbiStartUpImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SbiStartUpModelImpl.ENTITY_CACHE_ENABLED,
			SbiStartUpModelImpl.FINDER_CACHE_ENABLED, SbiStartUpImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SbiStartUpModelImpl.ENTITY_CACHE_ENABLED,
			SbiStartUpModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the sbi start up in the entity cache if it is enabled.
	 *
	 * @param sbiStartUp the sbi start up
	 */
	public void cacheResult(SbiStartUp sbiStartUp) {
		EntityCacheUtil.putResult(SbiStartUpModelImpl.ENTITY_CACHE_ENABLED,
			SbiStartUpImpl.class, sbiStartUp.getPrimaryKey(), sbiStartUp);

		sbiStartUp.resetOriginalValues();
	}

	/**
	 * Caches the sbi start ups in the entity cache if it is enabled.
	 *
	 * @param sbiStartUps the sbi start ups
	 */
	public void cacheResult(List<SbiStartUp> sbiStartUps) {
		for (SbiStartUp sbiStartUp : sbiStartUps) {
			if (EntityCacheUtil.getResult(
						SbiStartUpModelImpl.ENTITY_CACHE_ENABLED,
						SbiStartUpImpl.class, sbiStartUp.getPrimaryKey()) == null) {
				cacheResult(sbiStartUp);
			}
			else {
				sbiStartUp.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all sbi start ups.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SbiStartUpImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SbiStartUpImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the sbi start up.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SbiStartUp sbiStartUp) {
		EntityCacheUtil.removeResult(SbiStartUpModelImpl.ENTITY_CACHE_ENABLED,
			SbiStartUpImpl.class, sbiStartUp.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<SbiStartUp> sbiStartUps) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SbiStartUp sbiStartUp : sbiStartUps) {
			EntityCacheUtil.removeResult(SbiStartUpModelImpl.ENTITY_CACHE_ENABLED,
				SbiStartUpImpl.class, sbiStartUp.getPrimaryKey());
		}
	}

	/**
	 * Creates a new sbi start up with the primary key. Does not add the sbi start up to the database.
	 *
	 * @param regnum the primary key for the new sbi start up
	 * @return the new sbi start up
	 */
	public SbiStartUp create(String regnum) {
		SbiStartUp sbiStartUp = new SbiStartUpImpl();

		sbiStartUp.setNew(true);
		sbiStartUp.setPrimaryKey(regnum);

		return sbiStartUp;
	}

	/**
	 * Removes the sbi start up with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param regnum the primary key of the sbi start up
	 * @return the sbi start up that was removed
	 * @throws com.sbi.StartUp.NoSuchSbiStartUpException if a sbi start up with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SbiStartUp remove(String regnum)
		throws NoSuchSbiStartUpException, SystemException {
		return remove((Serializable)regnum);
	}

	/**
	 * Removes the sbi start up with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the sbi start up
	 * @return the sbi start up that was removed
	 * @throws com.sbi.StartUp.NoSuchSbiStartUpException if a sbi start up with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SbiStartUp remove(Serializable primaryKey)
		throws NoSuchSbiStartUpException, SystemException {
		Session session = null;

		try {
			session = openSession();

			SbiStartUp sbiStartUp = (SbiStartUp)session.get(SbiStartUpImpl.class,
					primaryKey);

			if (sbiStartUp == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSbiStartUpException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(sbiStartUp);
		}
		catch (NoSuchSbiStartUpException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected SbiStartUp removeImpl(SbiStartUp sbiStartUp)
		throws SystemException {
		sbiStartUp = toUnwrappedModel(sbiStartUp);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, sbiStartUp);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(sbiStartUp);

		return sbiStartUp;
	}

	@Override
	public SbiStartUp updateImpl(com.sbi.StartUp.model.SbiStartUp sbiStartUp,
		boolean merge) throws SystemException {
		sbiStartUp = toUnwrappedModel(sbiStartUp);

		boolean isNew = sbiStartUp.isNew();

		SbiStartUpModelImpl sbiStartUpModelImpl = (SbiStartUpModelImpl)sbiStartUp;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, sbiStartUp, merge);

			sbiStartUp.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !SbiStartUpModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((sbiStartUpModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREATEDATE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						sbiStartUpModelImpl.getOriginalCreateDate()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CREATEDATE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREATEDATE,
					args);

				args = new Object[] { sbiStartUpModelImpl.getCreateDate() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CREATEDATE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREATEDATE,
					args);
			}
		}

		EntityCacheUtil.putResult(SbiStartUpModelImpl.ENTITY_CACHE_ENABLED,
			SbiStartUpImpl.class, sbiStartUp.getPrimaryKey(), sbiStartUp);

		return sbiStartUp;
	}

	protected SbiStartUp toUnwrappedModel(SbiStartUp sbiStartUp) {
		if (sbiStartUp instanceof SbiStartUpImpl) {
			return sbiStartUp;
		}

		SbiStartUpImpl sbiStartUpImpl = new SbiStartUpImpl();

		sbiStartUpImpl.setNew(sbiStartUp.isNew());
		sbiStartUpImpl.setPrimaryKey(sbiStartUp.getPrimaryKey());

		sbiStartUpImpl.setRegnum(sbiStartUp.getRegnum());
		sbiStartUpImpl.setUserName(sbiStartUp.getUserName());
		sbiStartUpImpl.setCreateDate(sbiStartUp.getCreateDate());
		sbiStartUpImpl.setModifiedDate(sbiStartUp.getModifiedDate());
		sbiStartUpImpl.setRegistered_name(sbiStartUp.getRegistered_name());
		sbiStartUpImpl.setDate_of_establishment(sbiStartUp.getDate_of_establishment());
		sbiStartUpImpl.setConstitution(sbiStartUp.getConstitution());
		sbiStartUpImpl.setAddress_line_1(sbiStartUp.getAddress_line_1());
		sbiStartUpImpl.setAddress_line_2(sbiStartUp.getAddress_line_2());
		sbiStartUpImpl.setAddress_landmark(sbiStartUp.getAddress_landmark());
		sbiStartUpImpl.setAddress_city(sbiStartUp.getAddress_city());
		sbiStartUpImpl.setAddress_pin(sbiStartUp.getAddress_pin());
		sbiStartUpImpl.setAddress_state(sbiStartUp.getAddress_state());
		sbiStartUpImpl.setCorporate_email(sbiStartUp.getCorporate_email());
		sbiStartUpImpl.setCorporate_website(sbiStartUp.getCorporate_website());
		sbiStartUpImpl.setInitial_founders(sbiStartUp.getInitial_founders());
		sbiStartUpImpl.setCurrent_promoters_name(sbiStartUp.getCurrent_promoters_name());
		sbiStartUpImpl.setNoofemp(sbiStartUp.getNoofemp());
		sbiStartUpImpl.setDescription_of_product(sbiStartUp.getDescription_of_product());
		sbiStartUpImpl.setInitial_capital(sbiStartUp.getInitial_capital());
		sbiStartUpImpl.setMonetary_value(sbiStartUp.getMonetary_value());
		sbiStartUpImpl.setBusiness_model(sbiStartUp.getBusiness_model());
		sbiStartUpImpl.setCurrent_capital(sbiStartUp.getCurrent_capital());
		sbiStartUpImpl.setCapital_infusion(sbiStartUp.getCapital_infusion());
		sbiStartUpImpl.setLoans_availed(sbiStartUp.getLoans_availed());
		sbiStartUpImpl.setValuer_name(sbiStartUp.getValuer_name());
		sbiStartUpImpl.setValuation_date(sbiStartUp.getValuation_date());
		sbiStartUpImpl.setValuation_amount_rs(sbiStartUp.getValuation_amount_rs());
		sbiStartUpImpl.setLoan_avail_source(sbiStartUp.getLoan_avail_source());
		sbiStartUpImpl.setLoan_avail_rs(sbiStartUp.getLoan_avail_rs());
		sbiStartUpImpl.setGross_revenue_year1(sbiStartUp.getGross_revenue_year1());
		sbiStartUpImpl.setGross_revenue_rs1(sbiStartUp.getGross_revenue_rs1());
		sbiStartUpImpl.setGross_revenue_year2(sbiStartUp.getGross_revenue_year2());
		sbiStartUpImpl.setGross_revenue_rs2(sbiStartUp.getGross_revenue_rs2());
		sbiStartUpImpl.setGross_revenue_year3(sbiStartUp.getGross_revenue_year3());
		sbiStartUpImpl.setGross_revenue_rs3(sbiStartUp.getGross_revenue_rs3());
		sbiStartUpImpl.setEbidta_year1(sbiStartUp.getEbidta_year1());
		sbiStartUpImpl.setEbidta_rs1(sbiStartUp.getEbidta_rs1());
		sbiStartUpImpl.setEbidta_year2(sbiStartUp.getEbidta_year2());
		sbiStartUpImpl.setEbidta_rs2(sbiStartUp.getEbidta_rs2());
		sbiStartUpImpl.setEbidta_year3(sbiStartUp.getEbidta_year3());
		sbiStartUpImpl.setEbidta_rs3(sbiStartUp.getEbidta_rs3());
		sbiStartUpImpl.setGross_revenue_projected_year1(sbiStartUp.getGross_revenue_projected_year1());
		sbiStartUpImpl.setProjected_revenue_rs1(sbiStartUp.getProjected_revenue_rs1());
		sbiStartUpImpl.setGross_revenue_projected_year2(sbiStartUp.getGross_revenue_projected_year2());
		sbiStartUpImpl.setProjected_revenue_rs2(sbiStartUp.getProjected_revenue_rs2());
		sbiStartUpImpl.setGross_revenue_projected_year3(sbiStartUp.getGross_revenue_projected_year3());
		sbiStartUpImpl.setProjected_revenue_rs3(sbiStartUp.getProjected_revenue_rs3());
		sbiStartUpImpl.setProjected_ebidta_year1(sbiStartUp.getProjected_ebidta_year1());
		sbiStartUpImpl.setProjected_ebidta_rs1(sbiStartUp.getProjected_ebidta_rs1());
		sbiStartUpImpl.setProjected_ebidta_year2(sbiStartUp.getProjected_ebidta_year2());
		sbiStartUpImpl.setProjected_ebidta_rs2(sbiStartUp.getProjected_ebidta_rs2());
		sbiStartUpImpl.setProjected_ebidta_year3(sbiStartUp.getProjected_ebidta_year3());
		sbiStartUpImpl.setProjected_ebidta_rs3(sbiStartUp.getProjected_ebidta_rs3());
		sbiStartUpImpl.setProjected_net_profit_year1(sbiStartUp.getProjected_net_profit_year1());
		sbiStartUpImpl.setProjected_net_profit_rs1(sbiStartUp.getProjected_net_profit_rs1());
		sbiStartUpImpl.setProjected_net_profit_year2(sbiStartUp.getProjected_net_profit_year2());
		sbiStartUpImpl.setProjected_net_profit_rs2(sbiStartUp.getProjected_net_profit_rs2());
		sbiStartUpImpl.setProjected_net_profit_year3(sbiStartUp.getProjected_net_profit_year3());
		sbiStartUpImpl.setProjected_net_profit_rs3(sbiStartUp.getProjected_net_profit_rs3());
		sbiStartUpImpl.setNet_profit_year1(sbiStartUp.getNet_profit_year1());
		sbiStartUpImpl.setNet_profit_rs1(sbiStartUp.getNet_profit_rs1());
		sbiStartUpImpl.setNet_profit_year2(sbiStartUp.getNet_profit_year2());
		sbiStartUpImpl.setNet_profit_rs2(sbiStartUp.getNet_profit_rs2());
		sbiStartUpImpl.setNet_profit_year3(sbiStartUp.getNet_profit_year3());
		sbiStartUpImpl.setNet_profit_rs3(sbiStartUp.getNet_profit_rs3());
		sbiStartUpImpl.setFinancial_bank_engagement(sbiStartUp.getFinancial_bank_engagement());
		sbiStartUpImpl.setFinancial_assistance(sbiStartUp.getFinancial_assistance());
		sbiStartUpImpl.setFinancial_assi_purp(sbiStartUp.getFinancial_assi_purp());
		sbiStartUpImpl.setAgreeable_process(sbiStartUp.getAgreeable_process());
		sbiStartUpImpl.setGsr_department(sbiStartUp.getGsr_department());
		sbiStartUpImpl.setStartupindia(sbiStartUp.getStartupindia());
		sbiStartUpImpl.setIncubator(sbiStartUp.getIncubator());
		sbiStartUpImpl.setStatus(sbiStartUp.getStatus());
		sbiStartUpImpl.setFlag(sbiStartUp.isFlag());

		return sbiStartUpImpl;
	}

	/**
	 * Returns the sbi start up with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the sbi start up
	 * @return the sbi start up
	 * @throws com.liferay.portal.NoSuchModelException if a sbi start up with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SbiStartUp findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey((String)primaryKey);
	}

	/**
	 * Returns the sbi start up with the primary key or throws a {@link com.sbi.StartUp.NoSuchSbiStartUpException} if it could not be found.
	 *
	 * @param regnum the primary key of the sbi start up
	 * @return the sbi start up
	 * @throws com.sbi.StartUp.NoSuchSbiStartUpException if a sbi start up with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SbiStartUp findByPrimaryKey(String regnum)
		throws NoSuchSbiStartUpException, SystemException {
		SbiStartUp sbiStartUp = fetchByPrimaryKey(regnum);

		if (sbiStartUp == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + regnum);
			}

			throw new NoSuchSbiStartUpException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				regnum);
		}

		return sbiStartUp;
	}

	/**
	 * Returns the sbi start up with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the sbi start up
	 * @return the sbi start up, or <code>null</code> if a sbi start up with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public SbiStartUp fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey((String)primaryKey);
	}

	/**
	 * Returns the sbi start up with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param regnum the primary key of the sbi start up
	 * @return the sbi start up, or <code>null</code> if a sbi start up with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SbiStartUp fetchByPrimaryKey(String regnum)
		throws SystemException {
		SbiStartUp sbiStartUp = (SbiStartUp)EntityCacheUtil.getResult(SbiStartUpModelImpl.ENTITY_CACHE_ENABLED,
				SbiStartUpImpl.class, regnum);

		if (sbiStartUp == _nullSbiStartUp) {
			return null;
		}

		if (sbiStartUp == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				sbiStartUp = (SbiStartUp)session.get(SbiStartUpImpl.class,
						regnum);
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (sbiStartUp != null) {
					cacheResult(sbiStartUp);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(SbiStartUpModelImpl.ENTITY_CACHE_ENABLED,
						SbiStartUpImpl.class, regnum, _nullSbiStartUp);
				}

				closeSession(session);
			}
		}

		return sbiStartUp;
	}

	/**
	 * Returns all the sbi start ups where createDate = &#63;.
	 *
	 * @param createDate the create date
	 * @return the matching sbi start ups
	 * @throws SystemException if a system exception occurred
	 */
	public List<SbiStartUp> findBycreateDate(Date createDate)
		throws SystemException {
		return findBycreateDate(createDate, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

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
	public List<SbiStartUp> findBycreateDate(Date createDate, int start, int end)
		throws SystemException {
		return findBycreateDate(createDate, start, end, null);
	}

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
	public List<SbiStartUp> findBycreateDate(Date createDate, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREATEDATE;
			finderArgs = new Object[] { createDate };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CREATEDATE;
			finderArgs = new Object[] { createDate, start, end, orderByComparator };
		}

		List<SbiStartUp> list = (List<SbiStartUp>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (SbiStartUp sbiStartUp : list) {
				if (!Validator.equals(createDate, sbiStartUp.getCreateDate())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_SBISTARTUP_WHERE);

			if (createDate == null) {
				query.append(_FINDER_COLUMN_CREATEDATE_CREATEDATE_1);
			}
			else {
				query.append(_FINDER_COLUMN_CREATEDATE_CREATEDATE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(SbiStartUpModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (createDate != null) {
					qPos.add(CalendarUtil.getTimestamp(createDate));
				}

				list = (List<SbiStartUp>)QueryUtil.list(q, getDialect(), start,
						end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first sbi start up in the ordered set where createDate = &#63;.
	 *
	 * @param createDate the create date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sbi start up
	 * @throws com.sbi.StartUp.NoSuchSbiStartUpException if a matching sbi start up could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SbiStartUp findBycreateDate_First(Date createDate,
		OrderByComparator orderByComparator)
		throws NoSuchSbiStartUpException, SystemException {
		SbiStartUp sbiStartUp = fetchBycreateDate_First(createDate,
				orderByComparator);

		if (sbiStartUp != null) {
			return sbiStartUp;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("createDate=");
		msg.append(createDate);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSbiStartUpException(msg.toString());
	}

	/**
	 * Returns the first sbi start up in the ordered set where createDate = &#63;.
	 *
	 * @param createDate the create date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching sbi start up, or <code>null</code> if a matching sbi start up could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SbiStartUp fetchBycreateDate_First(Date createDate,
		OrderByComparator orderByComparator) throws SystemException {
		List<SbiStartUp> list = findBycreateDate(createDate, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last sbi start up in the ordered set where createDate = &#63;.
	 *
	 * @param createDate the create date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sbi start up
	 * @throws com.sbi.StartUp.NoSuchSbiStartUpException if a matching sbi start up could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SbiStartUp findBycreateDate_Last(Date createDate,
		OrderByComparator orderByComparator)
		throws NoSuchSbiStartUpException, SystemException {
		SbiStartUp sbiStartUp = fetchBycreateDate_Last(createDate,
				orderByComparator);

		if (sbiStartUp != null) {
			return sbiStartUp;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("createDate=");
		msg.append(createDate);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSbiStartUpException(msg.toString());
	}

	/**
	 * Returns the last sbi start up in the ordered set where createDate = &#63;.
	 *
	 * @param createDate the create date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching sbi start up, or <code>null</code> if a matching sbi start up could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public SbiStartUp fetchBycreateDate_Last(Date createDate,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBycreateDate(createDate);

		List<SbiStartUp> list = findBycreateDate(createDate, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	public SbiStartUp[] findBycreateDate_PrevAndNext(String regnum,
		Date createDate, OrderByComparator orderByComparator)
		throws NoSuchSbiStartUpException, SystemException {
		SbiStartUp sbiStartUp = findByPrimaryKey(regnum);

		Session session = null;

		try {
			session = openSession();

			SbiStartUp[] array = new SbiStartUpImpl[3];

			array[0] = getBycreateDate_PrevAndNext(session, sbiStartUp,
					createDate, orderByComparator, true);

			array[1] = sbiStartUp;

			array[2] = getBycreateDate_PrevAndNext(session, sbiStartUp,
					createDate, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SbiStartUp getBycreateDate_PrevAndNext(Session session,
		SbiStartUp sbiStartUp, Date createDate,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SBISTARTUP_WHERE);

		if (createDate == null) {
			query.append(_FINDER_COLUMN_CREATEDATE_CREATEDATE_1);
		}
		else {
			query.append(_FINDER_COLUMN_CREATEDATE_CREATEDATE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(SbiStartUpModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (createDate != null) {
			qPos.add(CalendarUtil.getTimestamp(createDate));
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(sbiStartUp);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<SbiStartUp> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the sbi start ups.
	 *
	 * @return the sbi start ups
	 * @throws SystemException if a system exception occurred
	 */
	public List<SbiStartUp> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<SbiStartUp> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

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
	public List<SbiStartUp> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = new Object[] { start, end, orderByComparator };

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<SbiStartUp> list = (List<SbiStartUp>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SBISTARTUP);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SBISTARTUP.concat(SbiStartUpModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<SbiStartUp>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<SbiStartUp>)QueryUtil.list(q, getDialect(),
							start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the sbi start ups where createDate = &#63; from the database.
	 *
	 * @param createDate the create date
	 * @throws SystemException if a system exception occurred
	 */
	public void removeBycreateDate(Date createDate) throws SystemException {
		for (SbiStartUp sbiStartUp : findBycreateDate(createDate)) {
			remove(sbiStartUp);
		}
	}

	/**
	 * Removes all the sbi start ups from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (SbiStartUp sbiStartUp : findAll()) {
			remove(sbiStartUp);
		}
	}

	/**
	 * Returns the number of sbi start ups where createDate = &#63;.
	 *
	 * @param createDate the create date
	 * @return the number of matching sbi start ups
	 * @throws SystemException if a system exception occurred
	 */
	public int countBycreateDate(Date createDate) throws SystemException {
		Object[] finderArgs = new Object[] { createDate };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_CREATEDATE,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SBISTARTUP_WHERE);

			if (createDate == null) {
				query.append(_FINDER_COLUMN_CREATEDATE_CREATEDATE_1);
			}
			else {
				query.append(_FINDER_COLUMN_CREATEDATE_CREATEDATE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (createDate != null) {
					qPos.add(CalendarUtil.getTimestamp(createDate));
				}

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CREATEDATE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of sbi start ups.
	 *
	 * @return the number of sbi start ups
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_SBISTARTUP);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the sbi start up persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sbi.StartUp.model.SbiStartUp")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<SbiStartUp>> listenersList = new ArrayList<ModelListener<SbiStartUp>>();

				for (String listenerClassName : listenerClassNames) {
					Class<?> clazz = getClass();

					listenersList.add((ModelListener<SbiStartUp>)InstanceFactory.newInstance(
							clazz.getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(SbiStartUpImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = CapitalInfPersistence.class)
	protected CapitalInfPersistence capitalInfPersistence;
	@BeanReference(type = ResumeDtlsPersistence.class)
	protected ResumeDtlsPersistence resumeDtlsPersistence;
	@BeanReference(type = SbiStartUpPersistence.class)
	protected SbiStartUpPersistence sbiStartUpPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_SBISTARTUP = "SELECT sbiStartUp FROM SbiStartUp sbiStartUp";
	private static final String _SQL_SELECT_SBISTARTUP_WHERE = "SELECT sbiStartUp FROM SbiStartUp sbiStartUp WHERE ";
	private static final String _SQL_COUNT_SBISTARTUP = "SELECT COUNT(sbiStartUp) FROM SbiStartUp sbiStartUp";
	private static final String _SQL_COUNT_SBISTARTUP_WHERE = "SELECT COUNT(sbiStartUp) FROM SbiStartUp sbiStartUp WHERE ";
	private static final String _FINDER_COLUMN_CREATEDATE_CREATEDATE_1 = "sbiStartUp.createDate IS NULL";
	private static final String _FINDER_COLUMN_CREATEDATE_CREATEDATE_2 = "sbiStartUp.createDate = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "sbiStartUp.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SbiStartUp exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No SbiStartUp exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SbiStartUpPersistenceImpl.class);
	private static SbiStartUp _nullSbiStartUp = new SbiStartUpImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<SbiStartUp> toCacheModel() {
				return _nullSbiStartUpCacheModel;
			}
		};

	private static CacheModel<SbiStartUp> _nullSbiStartUpCacheModel = new CacheModel<SbiStartUp>() {
			public SbiStartUp toEntityModel() {
				return _nullSbiStartUp;
			}
		};
}