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

import com.sbi.StartUp.NoSuchCapitalInfException;
import com.sbi.StartUp.model.CapitalInf;
import com.sbi.StartUp.model.impl.CapitalInfImpl;
import com.sbi.StartUp.model.impl.CapitalInfModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * The persistence implementation for the capital inf service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author MAH97223
 * @see CapitalInfPersistence
 * @see CapitalInfUtil
 * @generated
 */
public class CapitalInfPersistenceImpl extends BasePersistenceImpl<CapitalInf>
	implements CapitalInfPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CapitalInfUtil} to access the capital inf persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CapitalInfImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CREATEDATE =
		new FinderPath(CapitalInfModelImpl.ENTITY_CACHE_ENABLED,
			CapitalInfModelImpl.FINDER_CACHE_ENABLED, CapitalInfImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBycreateDate",
			new String[] {
				Date.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREATEDATE =
		new FinderPath(CapitalInfModelImpl.ENTITY_CACHE_ENABLED,
			CapitalInfModelImpl.FINDER_CACHE_ENABLED, CapitalInfImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBycreateDate",
			new String[] { Date.class.getName() },
			CapitalInfModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CREATEDATE = new FinderPath(CapitalInfModelImpl.ENTITY_CACHE_ENABLED,
			CapitalInfModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBycreateDate",
			new String[] { Date.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CapitalInfModelImpl.ENTITY_CACHE_ENABLED,
			CapitalInfModelImpl.FINDER_CACHE_ENABLED, CapitalInfImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CapitalInfModelImpl.ENTITY_CACHE_ENABLED,
			CapitalInfModelImpl.FINDER_CACHE_ENABLED, CapitalInfImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CapitalInfModelImpl.ENTITY_CACHE_ENABLED,
			CapitalInfModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the capital inf in the entity cache if it is enabled.
	 *
	 * @param capitalInf the capital inf
	 */
	public void cacheResult(CapitalInf capitalInf) {
		EntityCacheUtil.putResult(CapitalInfModelImpl.ENTITY_CACHE_ENABLED,
			CapitalInfImpl.class, capitalInf.getPrimaryKey(), capitalInf);

		capitalInf.resetOriginalValues();
	}

	/**
	 * Caches the capital infs in the entity cache if it is enabled.
	 *
	 * @param capitalInfs the capital infs
	 */
	public void cacheResult(List<CapitalInf> capitalInfs) {
		for (CapitalInf capitalInf : capitalInfs) {
			if (EntityCacheUtil.getResult(
						CapitalInfModelImpl.ENTITY_CACHE_ENABLED,
						CapitalInfImpl.class, capitalInf.getPrimaryKey()) == null) {
				cacheResult(capitalInf);
			}
			else {
				capitalInf.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all capital infs.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(CapitalInfImpl.class.getName());
		}

		EntityCacheUtil.clearCache(CapitalInfImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the capital inf.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CapitalInf capitalInf) {
		EntityCacheUtil.removeResult(CapitalInfModelImpl.ENTITY_CACHE_ENABLED,
			CapitalInfImpl.class, capitalInf.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<CapitalInf> capitalInfs) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CapitalInf capitalInf : capitalInfs) {
			EntityCacheUtil.removeResult(CapitalInfModelImpl.ENTITY_CACHE_ENABLED,
				CapitalInfImpl.class, capitalInf.getPrimaryKey());
		}
	}

	/**
	 * Creates a new capital inf with the primary key. Does not add the capital inf to the database.
	 *
	 * @param InfRefId the primary key for the new capital inf
	 * @return the new capital inf
	 */
	public CapitalInf create(long InfRefId) {
		CapitalInf capitalInf = new CapitalInfImpl();

		capitalInf.setNew(true);
		capitalInf.setPrimaryKey(InfRefId);

		return capitalInf;
	}

	/**
	 * Removes the capital inf with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param InfRefId the primary key of the capital inf
	 * @return the capital inf that was removed
	 * @throws com.sbi.StartUp.NoSuchCapitalInfException if a capital inf with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CapitalInf remove(long InfRefId)
		throws NoSuchCapitalInfException, SystemException {
		return remove(Long.valueOf(InfRefId));
	}

	/**
	 * Removes the capital inf with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the capital inf
	 * @return the capital inf that was removed
	 * @throws com.sbi.StartUp.NoSuchCapitalInfException if a capital inf with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CapitalInf remove(Serializable primaryKey)
		throws NoSuchCapitalInfException, SystemException {
		Session session = null;

		try {
			session = openSession();

			CapitalInf capitalInf = (CapitalInf)session.get(CapitalInfImpl.class,
					primaryKey);

			if (capitalInf == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCapitalInfException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(capitalInf);
		}
		catch (NoSuchCapitalInfException nsee) {
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
	protected CapitalInf removeImpl(CapitalInf capitalInf)
		throws SystemException {
		capitalInf = toUnwrappedModel(capitalInf);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, capitalInf);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(capitalInf);

		return capitalInf;
	}

	@Override
	public CapitalInf updateImpl(com.sbi.StartUp.model.CapitalInf capitalInf,
		boolean merge) throws SystemException {
		capitalInf = toUnwrappedModel(capitalInf);

		boolean isNew = capitalInf.isNew();

		CapitalInfModelImpl capitalInfModelImpl = (CapitalInfModelImpl)capitalInf;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, capitalInf, merge);

			capitalInf.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !CapitalInfModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((capitalInfModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREATEDATE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						capitalInfModelImpl.getOriginalCreateDate()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CREATEDATE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREATEDATE,
					args);

				args = new Object[] { capitalInfModelImpl.getCreateDate() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CREATEDATE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREATEDATE,
					args);
			}
		}

		EntityCacheUtil.putResult(CapitalInfModelImpl.ENTITY_CACHE_ENABLED,
			CapitalInfImpl.class, capitalInf.getPrimaryKey(), capitalInf);

		return capitalInf;
	}

	protected CapitalInf toUnwrappedModel(CapitalInf capitalInf) {
		if (capitalInf instanceof CapitalInfImpl) {
			return capitalInf;
		}

		CapitalInfImpl capitalInfImpl = new CapitalInfImpl();

		capitalInfImpl.setNew(capitalInf.isNew());
		capitalInfImpl.setPrimaryKey(capitalInf.getPrimaryKey());

		capitalInfImpl.setInfRefId(capitalInf.getInfRefId());
		capitalInfImpl.setCreateDate(capitalInf.getCreateDate());
		capitalInfImpl.setModifiedDate(capitalInf.getModifiedDate());
		capitalInfImpl.setRegNum(capitalInf.getRegNum());
		capitalInfImpl.setCp_promoters_name(capitalInf.getCp_promoters_name());
		capitalInfImpl.setCp_promoters_address(capitalInf.getCp_promoters_address());
		capitalInfImpl.setCp_promoters_amount(capitalInf.getCp_promoters_amount());

		return capitalInfImpl;
	}

	/**
	 * Returns the capital inf with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the capital inf
	 * @return the capital inf
	 * @throws com.liferay.portal.NoSuchModelException if a capital inf with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CapitalInf findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the capital inf with the primary key or throws a {@link com.sbi.StartUp.NoSuchCapitalInfException} if it could not be found.
	 *
	 * @param InfRefId the primary key of the capital inf
	 * @return the capital inf
	 * @throws com.sbi.StartUp.NoSuchCapitalInfException if a capital inf with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CapitalInf findByPrimaryKey(long InfRefId)
		throws NoSuchCapitalInfException, SystemException {
		CapitalInf capitalInf = fetchByPrimaryKey(InfRefId);

		if (capitalInf == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + InfRefId);
			}

			throw new NoSuchCapitalInfException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				InfRefId);
		}

		return capitalInf;
	}

	/**
	 * Returns the capital inf with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the capital inf
	 * @return the capital inf, or <code>null</code> if a capital inf with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CapitalInf fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the capital inf with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param InfRefId the primary key of the capital inf
	 * @return the capital inf, or <code>null</code> if a capital inf with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CapitalInf fetchByPrimaryKey(long InfRefId)
		throws SystemException {
		CapitalInf capitalInf = (CapitalInf)EntityCacheUtil.getResult(CapitalInfModelImpl.ENTITY_CACHE_ENABLED,
				CapitalInfImpl.class, InfRefId);

		if (capitalInf == _nullCapitalInf) {
			return null;
		}

		if (capitalInf == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				capitalInf = (CapitalInf)session.get(CapitalInfImpl.class,
						Long.valueOf(InfRefId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (capitalInf != null) {
					cacheResult(capitalInf);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(CapitalInfModelImpl.ENTITY_CACHE_ENABLED,
						CapitalInfImpl.class, InfRefId, _nullCapitalInf);
				}

				closeSession(session);
			}
		}

		return capitalInf;
	}

	/**
	 * Returns all the capital infs where createDate = &#63;.
	 *
	 * @param createDate the create date
	 * @return the matching capital infs
	 * @throws SystemException if a system exception occurred
	 */
	public List<CapitalInf> findBycreateDate(Date createDate)
		throws SystemException {
		return findBycreateDate(createDate, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	public List<CapitalInf> findBycreateDate(Date createDate, int start, int end)
		throws SystemException {
		return findBycreateDate(createDate, start, end, null);
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
	public List<CapitalInf> findBycreateDate(Date createDate, int start,
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

		List<CapitalInf> list = (List<CapitalInf>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CapitalInf capitalInf : list) {
				if (!Validator.equals(createDate, capitalInf.getCreateDate())) {
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

			query.append(_SQL_SELECT_CAPITALINF_WHERE);

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
				query.append(CapitalInfModelImpl.ORDER_BY_JPQL);
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

				list = (List<CapitalInf>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first capital inf in the ordered set where createDate = &#63;.
	 *
	 * @param createDate the create date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching capital inf
	 * @throws com.sbi.StartUp.NoSuchCapitalInfException if a matching capital inf could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CapitalInf findBycreateDate_First(Date createDate,
		OrderByComparator orderByComparator)
		throws NoSuchCapitalInfException, SystemException {
		CapitalInf capitalInf = fetchBycreateDate_First(createDate,
				orderByComparator);

		if (capitalInf != null) {
			return capitalInf;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("createDate=");
		msg.append(createDate);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCapitalInfException(msg.toString());
	}

	/**
	 * Returns the first capital inf in the ordered set where createDate = &#63;.
	 *
	 * @param createDate the create date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching capital inf, or <code>null</code> if a matching capital inf could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CapitalInf fetchBycreateDate_First(Date createDate,
		OrderByComparator orderByComparator) throws SystemException {
		List<CapitalInf> list = findBycreateDate(createDate, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	public CapitalInf findBycreateDate_Last(Date createDate,
		OrderByComparator orderByComparator)
		throws NoSuchCapitalInfException, SystemException {
		CapitalInf capitalInf = fetchBycreateDate_Last(createDate,
				orderByComparator);

		if (capitalInf != null) {
			return capitalInf;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("createDate=");
		msg.append(createDate);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCapitalInfException(msg.toString());
	}

	/**
	 * Returns the last capital inf in the ordered set where createDate = &#63;.
	 *
	 * @param createDate the create date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching capital inf, or <code>null</code> if a matching capital inf could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public CapitalInf fetchBycreateDate_Last(Date createDate,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBycreateDate(createDate);

		List<CapitalInf> list = findBycreateDate(createDate, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	public CapitalInf[] findBycreateDate_PrevAndNext(long InfRefId,
		Date createDate, OrderByComparator orderByComparator)
		throws NoSuchCapitalInfException, SystemException {
		CapitalInf capitalInf = findByPrimaryKey(InfRefId);

		Session session = null;

		try {
			session = openSession();

			CapitalInf[] array = new CapitalInfImpl[3];

			array[0] = getBycreateDate_PrevAndNext(session, capitalInf,
					createDate, orderByComparator, true);

			array[1] = capitalInf;

			array[2] = getBycreateDate_PrevAndNext(session, capitalInf,
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

	protected CapitalInf getBycreateDate_PrevAndNext(Session session,
		CapitalInf capitalInf, Date createDate,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CAPITALINF_WHERE);

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
			query.append(CapitalInfModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(capitalInf);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CapitalInf> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the capital infs.
	 *
	 * @return the capital infs
	 * @throws SystemException if a system exception occurred
	 */
	public List<CapitalInf> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<CapitalInf> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
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
	public List<CapitalInf> findAll(int start, int end,
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

		List<CapitalInf> list = (List<CapitalInf>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_CAPITALINF);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CAPITALINF.concat(CapitalInfModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<CapitalInf>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<CapitalInf>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the capital infs where createDate = &#63; from the database.
	 *
	 * @param createDate the create date
	 * @throws SystemException if a system exception occurred
	 */
	public void removeBycreateDate(Date createDate) throws SystemException {
		for (CapitalInf capitalInf : findBycreateDate(createDate)) {
			remove(capitalInf);
		}
	}

	/**
	 * Removes all the capital infs from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (CapitalInf capitalInf : findAll()) {
			remove(capitalInf);
		}
	}

	/**
	 * Returns the number of capital infs where createDate = &#63;.
	 *
	 * @param createDate the create date
	 * @return the number of matching capital infs
	 * @throws SystemException if a system exception occurred
	 */
	public int countBycreateDate(Date createDate) throws SystemException {
		Object[] finderArgs = new Object[] { createDate };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_CREATEDATE,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CAPITALINF_WHERE);

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
	 * Returns the number of capital infs.
	 *
	 * @return the number of capital infs
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_CAPITALINF);

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
	 * Initializes the capital inf persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sbi.StartUp.model.CapitalInf")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<CapitalInf>> listenersList = new ArrayList<ModelListener<CapitalInf>>();

				for (String listenerClassName : listenerClassNames) {
					Class<?> clazz = getClass();

					listenersList.add((ModelListener<CapitalInf>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(CapitalInfImpl.class.getName());
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
	private static final String _SQL_SELECT_CAPITALINF = "SELECT capitalInf FROM CapitalInf capitalInf";
	private static final String _SQL_SELECT_CAPITALINF_WHERE = "SELECT capitalInf FROM CapitalInf capitalInf WHERE ";
	private static final String _SQL_COUNT_CAPITALINF = "SELECT COUNT(capitalInf) FROM CapitalInf capitalInf";
	private static final String _SQL_COUNT_CAPITALINF_WHERE = "SELECT COUNT(capitalInf) FROM CapitalInf capitalInf WHERE ";
	private static final String _FINDER_COLUMN_CREATEDATE_CREATEDATE_1 = "capitalInf.createDate IS NULL";
	private static final String _FINDER_COLUMN_CREATEDATE_CREATEDATE_2 = "capitalInf.createDate = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "capitalInf.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No CapitalInf exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No CapitalInf exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(CapitalInfPersistenceImpl.class);
	private static CapitalInf _nullCapitalInf = new CapitalInfImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<CapitalInf> toCacheModel() {
				return _nullCapitalInfCacheModel;
			}
		};

	private static CacheModel<CapitalInf> _nullCapitalInfCacheModel = new CacheModel<CapitalInf>() {
			public CapitalInf toEntityModel() {
				return _nullCapitalInf;
			}
		};
}