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

import com.sbi.StartUp.NoSuchResumeDtlsException;
import com.sbi.StartUp.model.ResumeDtls;
import com.sbi.StartUp.model.impl.ResumeDtlsImpl;
import com.sbi.StartUp.model.impl.ResumeDtlsModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * The persistence implementation for the resume dtls service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author MAH97223
 * @see ResumeDtlsPersistence
 * @see ResumeDtlsUtil
 * @generated
 */
public class ResumeDtlsPersistenceImpl extends BasePersistenceImpl<ResumeDtls>
	implements ResumeDtlsPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ResumeDtlsUtil} to access the resume dtls persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ResumeDtlsImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CREATEDATE =
		new FinderPath(ResumeDtlsModelImpl.ENTITY_CACHE_ENABLED,
			ResumeDtlsModelImpl.FINDER_CACHE_ENABLED, ResumeDtlsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBycreateDate",
			new String[] {
				Date.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREATEDATE =
		new FinderPath(ResumeDtlsModelImpl.ENTITY_CACHE_ENABLED,
			ResumeDtlsModelImpl.FINDER_CACHE_ENABLED, ResumeDtlsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBycreateDate",
			new String[] { Date.class.getName() },
			ResumeDtlsModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CREATEDATE = new FinderPath(ResumeDtlsModelImpl.ENTITY_CACHE_ENABLED,
			ResumeDtlsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBycreateDate",
			new String[] { Date.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ResumeDtlsModelImpl.ENTITY_CACHE_ENABLED,
			ResumeDtlsModelImpl.FINDER_CACHE_ENABLED, ResumeDtlsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ResumeDtlsModelImpl.ENTITY_CACHE_ENABLED,
			ResumeDtlsModelImpl.FINDER_CACHE_ENABLED, ResumeDtlsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ResumeDtlsModelImpl.ENTITY_CACHE_ENABLED,
			ResumeDtlsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the resume dtls in the entity cache if it is enabled.
	 *
	 * @param resumeDtls the resume dtls
	 */
	public void cacheResult(ResumeDtls resumeDtls) {
		EntityCacheUtil.putResult(ResumeDtlsModelImpl.ENTITY_CACHE_ENABLED,
			ResumeDtlsImpl.class, resumeDtls.getPrimaryKey(), resumeDtls);

		resumeDtls.resetOriginalValues();
	}

	/**
	 * Caches the resume dtlses in the entity cache if it is enabled.
	 *
	 * @param resumeDtlses the resume dtlses
	 */
	public void cacheResult(List<ResumeDtls> resumeDtlses) {
		for (ResumeDtls resumeDtls : resumeDtlses) {
			if (EntityCacheUtil.getResult(
						ResumeDtlsModelImpl.ENTITY_CACHE_ENABLED,
						ResumeDtlsImpl.class, resumeDtls.getPrimaryKey()) == null) {
				cacheResult(resumeDtls);
			}
			else {
				resumeDtls.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all resume dtlses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ResumeDtlsImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ResumeDtlsImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the resume dtls.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ResumeDtls resumeDtls) {
		EntityCacheUtil.removeResult(ResumeDtlsModelImpl.ENTITY_CACHE_ENABLED,
			ResumeDtlsImpl.class, resumeDtls.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ResumeDtls> resumeDtlses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ResumeDtls resumeDtls : resumeDtlses) {
			EntityCacheUtil.removeResult(ResumeDtlsModelImpl.ENTITY_CACHE_ENABLED,
				ResumeDtlsImpl.class, resumeDtls.getPrimaryKey());
		}
	}

	/**
	 * Creates a new resume dtls with the primary key. Does not add the resume dtls to the database.
	 *
	 * @param ResumeId the primary key for the new resume dtls
	 * @return the new resume dtls
	 */
	public ResumeDtls create(long ResumeId) {
		ResumeDtls resumeDtls = new ResumeDtlsImpl();

		resumeDtls.setNew(true);
		resumeDtls.setPrimaryKey(ResumeId);

		return resumeDtls;
	}

	/**
	 * Removes the resume dtls with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ResumeId the primary key of the resume dtls
	 * @return the resume dtls that was removed
	 * @throws com.sbi.StartUp.NoSuchResumeDtlsException if a resume dtls with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ResumeDtls remove(long ResumeId)
		throws NoSuchResumeDtlsException, SystemException {
		return remove(Long.valueOf(ResumeId));
	}

	/**
	 * Removes the resume dtls with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the resume dtls
	 * @return the resume dtls that was removed
	 * @throws com.sbi.StartUp.NoSuchResumeDtlsException if a resume dtls with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ResumeDtls remove(Serializable primaryKey)
		throws NoSuchResumeDtlsException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ResumeDtls resumeDtls = (ResumeDtls)session.get(ResumeDtlsImpl.class,
					primaryKey);

			if (resumeDtls == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchResumeDtlsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(resumeDtls);
		}
		catch (NoSuchResumeDtlsException nsee) {
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
	protected ResumeDtls removeImpl(ResumeDtls resumeDtls)
		throws SystemException {
		resumeDtls = toUnwrappedModel(resumeDtls);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, resumeDtls);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(resumeDtls);

		return resumeDtls;
	}

	@Override
	public ResumeDtls updateImpl(com.sbi.StartUp.model.ResumeDtls resumeDtls,
		boolean merge) throws SystemException {
		resumeDtls = toUnwrappedModel(resumeDtls);

		boolean isNew = resumeDtls.isNew();

		ResumeDtlsModelImpl resumeDtlsModelImpl = (ResumeDtlsModelImpl)resumeDtls;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, resumeDtls, merge);

			resumeDtls.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ResumeDtlsModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((resumeDtlsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREATEDATE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						resumeDtlsModelImpl.getOriginalCreateDate()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CREATEDATE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREATEDATE,
					args);

				args = new Object[] { resumeDtlsModelImpl.getCreateDate() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CREATEDATE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREATEDATE,
					args);
			}
		}

		EntityCacheUtil.putResult(ResumeDtlsModelImpl.ENTITY_CACHE_ENABLED,
			ResumeDtlsImpl.class, resumeDtls.getPrimaryKey(), resumeDtls);

		return resumeDtls;
	}

	protected ResumeDtls toUnwrappedModel(ResumeDtls resumeDtls) {
		if (resumeDtls instanceof ResumeDtlsImpl) {
			return resumeDtls;
		}

		ResumeDtlsImpl resumeDtlsImpl = new ResumeDtlsImpl();

		resumeDtlsImpl.setNew(resumeDtls.isNew());
		resumeDtlsImpl.setPrimaryKey(resumeDtls.getPrimaryKey());

		resumeDtlsImpl.setResumeId(resumeDtls.getResumeId());
		resumeDtlsImpl.setCreateDate(resumeDtls.getCreateDate());
		resumeDtlsImpl.setModifiedDate(resumeDtls.getModifiedDate());
		resumeDtlsImpl.setRegNum(resumeDtls.getRegNum());
		resumeDtlsImpl.setName(resumeDtls.getName());
		resumeDtlsImpl.setEmail(resumeDtls.getEmail());
		resumeDtlsImpl.setMnumber(resumeDtls.getMnumber());
		resumeDtlsImpl.setDob(resumeDtls.getDob());
		resumeDtlsImpl.setAddress_line_1(resumeDtls.getAddress_line_1());
		resumeDtlsImpl.setAddress_line_2(resumeDtls.getAddress_line_2());
		resumeDtlsImpl.setAddress_landmark(resumeDtls.getAddress_landmark());
		resumeDtlsImpl.setAddress_city(resumeDtls.getAddress_city());
		resumeDtlsImpl.setAddress_pin(resumeDtls.getAddress_pin());
		resumeDtlsImpl.setAddress_state(resumeDtls.getAddress_state());
		resumeDtlsImpl.setPerm_address_line_1(resumeDtls.getPerm_address_line_1());
		resumeDtlsImpl.setPerm_address_line_2(resumeDtls.getPerm_address_line_2());
		resumeDtlsImpl.setPerm_address_landmark(resumeDtls.getPerm_address_landmark());
		resumeDtlsImpl.setPerm_address_city(resumeDtls.getPerm_address_city());
		resumeDtlsImpl.setPerm_address_pin(resumeDtls.getPerm_address_pin());
		resumeDtlsImpl.setPerm_address_state(resumeDtls.getPerm_address_state());
		resumeDtlsImpl.setPan(resumeDtls.getPan());
		resumeDtlsImpl.setAadharNum(resumeDtls.getAadharNum());
		resumeDtlsImpl.setCarrerAspect(resumeDtls.getCarrerAspect());
		resumeDtlsImpl.setKeyITSkill(resumeDtls.getKeyITSkill());
		resumeDtlsImpl.setCertfTra(resumeDtls.getCertfTra());
		resumeDtlsImpl.setEmpyHistory(resumeDtls.getEmpyHistory());
		resumeDtlsImpl.setCoreComp(resumeDtls.getCoreComp());
		resumeDtlsImpl.setAccomplishment(resumeDtls.getAccomplishment());
		resumeDtlsImpl.setAcademics(resumeDtls.getAcademics());
		resumeDtlsImpl.setStatus(resumeDtls.getStatus());
		resumeDtlsImpl.setFlag(resumeDtls.isFlag());
		resumeDtlsImpl.setIndexno(resumeDtls.getIndexno());

		return resumeDtlsImpl;
	}

	/**
	 * Returns the resume dtls with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the resume dtls
	 * @return the resume dtls
	 * @throws com.liferay.portal.NoSuchModelException if a resume dtls with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ResumeDtls findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the resume dtls with the primary key or throws a {@link com.sbi.StartUp.NoSuchResumeDtlsException} if it could not be found.
	 *
	 * @param ResumeId the primary key of the resume dtls
	 * @return the resume dtls
	 * @throws com.sbi.StartUp.NoSuchResumeDtlsException if a resume dtls with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ResumeDtls findByPrimaryKey(long ResumeId)
		throws NoSuchResumeDtlsException, SystemException {
		ResumeDtls resumeDtls = fetchByPrimaryKey(ResumeId);

		if (resumeDtls == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + ResumeId);
			}

			throw new NoSuchResumeDtlsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				ResumeId);
		}

		return resumeDtls;
	}

	/**
	 * Returns the resume dtls with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the resume dtls
	 * @return the resume dtls, or <code>null</code> if a resume dtls with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ResumeDtls fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the resume dtls with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ResumeId the primary key of the resume dtls
	 * @return the resume dtls, or <code>null</code> if a resume dtls with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ResumeDtls fetchByPrimaryKey(long ResumeId)
		throws SystemException {
		ResumeDtls resumeDtls = (ResumeDtls)EntityCacheUtil.getResult(ResumeDtlsModelImpl.ENTITY_CACHE_ENABLED,
				ResumeDtlsImpl.class, ResumeId);

		if (resumeDtls == _nullResumeDtls) {
			return null;
		}

		if (resumeDtls == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				resumeDtls = (ResumeDtls)session.get(ResumeDtlsImpl.class,
						Long.valueOf(ResumeId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (resumeDtls != null) {
					cacheResult(resumeDtls);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(ResumeDtlsModelImpl.ENTITY_CACHE_ENABLED,
						ResumeDtlsImpl.class, ResumeId, _nullResumeDtls);
				}

				closeSession(session);
			}
		}

		return resumeDtls;
	}

	/**
	 * Returns all the resume dtlses where createDate = &#63;.
	 *
	 * @param createDate the create date
	 * @return the matching resume dtlses
	 * @throws SystemException if a system exception occurred
	 */
	public List<ResumeDtls> findBycreateDate(Date createDate)
		throws SystemException {
		return findBycreateDate(createDate, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	public List<ResumeDtls> findBycreateDate(Date createDate, int start, int end)
		throws SystemException {
		return findBycreateDate(createDate, start, end, null);
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
	public List<ResumeDtls> findBycreateDate(Date createDate, int start,
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

		List<ResumeDtls> list = (List<ResumeDtls>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ResumeDtls resumeDtls : list) {
				if (!Validator.equals(createDate, resumeDtls.getCreateDate())) {
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

			query.append(_SQL_SELECT_RESUMEDTLS_WHERE);

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
				query.append(ResumeDtlsModelImpl.ORDER_BY_JPQL);
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

				list = (List<ResumeDtls>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first resume dtls in the ordered set where createDate = &#63;.
	 *
	 * @param createDate the create date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching resume dtls
	 * @throws com.sbi.StartUp.NoSuchResumeDtlsException if a matching resume dtls could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ResumeDtls findBycreateDate_First(Date createDate,
		OrderByComparator orderByComparator)
		throws NoSuchResumeDtlsException, SystemException {
		ResumeDtls resumeDtls = fetchBycreateDate_First(createDate,
				orderByComparator);

		if (resumeDtls != null) {
			return resumeDtls;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("createDate=");
		msg.append(createDate);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchResumeDtlsException(msg.toString());
	}

	/**
	 * Returns the first resume dtls in the ordered set where createDate = &#63;.
	 *
	 * @param createDate the create date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching resume dtls, or <code>null</code> if a matching resume dtls could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ResumeDtls fetchBycreateDate_First(Date createDate,
		OrderByComparator orderByComparator) throws SystemException {
		List<ResumeDtls> list = findBycreateDate(createDate, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	public ResumeDtls findBycreateDate_Last(Date createDate,
		OrderByComparator orderByComparator)
		throws NoSuchResumeDtlsException, SystemException {
		ResumeDtls resumeDtls = fetchBycreateDate_Last(createDate,
				orderByComparator);

		if (resumeDtls != null) {
			return resumeDtls;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("createDate=");
		msg.append(createDate);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchResumeDtlsException(msg.toString());
	}

	/**
	 * Returns the last resume dtls in the ordered set where createDate = &#63;.
	 *
	 * @param createDate the create date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching resume dtls, or <code>null</code> if a matching resume dtls could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public ResumeDtls fetchBycreateDate_Last(Date createDate,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBycreateDate(createDate);

		List<ResumeDtls> list = findBycreateDate(createDate, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	public ResumeDtls[] findBycreateDate_PrevAndNext(long ResumeId,
		Date createDate, OrderByComparator orderByComparator)
		throws NoSuchResumeDtlsException, SystemException {
		ResumeDtls resumeDtls = findByPrimaryKey(ResumeId);

		Session session = null;

		try {
			session = openSession();

			ResumeDtls[] array = new ResumeDtlsImpl[3];

			array[0] = getBycreateDate_PrevAndNext(session, resumeDtls,
					createDate, orderByComparator, true);

			array[1] = resumeDtls;

			array[2] = getBycreateDate_PrevAndNext(session, resumeDtls,
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

	protected ResumeDtls getBycreateDate_PrevAndNext(Session session,
		ResumeDtls resumeDtls, Date createDate,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_RESUMEDTLS_WHERE);

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
			query.append(ResumeDtlsModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(resumeDtls);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ResumeDtls> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the resume dtlses.
	 *
	 * @return the resume dtlses
	 * @throws SystemException if a system exception occurred
	 */
	public List<ResumeDtls> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<ResumeDtls> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
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
	public List<ResumeDtls> findAll(int start, int end,
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

		List<ResumeDtls> list = (List<ResumeDtls>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_RESUMEDTLS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_RESUMEDTLS.concat(ResumeDtlsModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<ResumeDtls>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<ResumeDtls>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the resume dtlses where createDate = &#63; from the database.
	 *
	 * @param createDate the create date
	 * @throws SystemException if a system exception occurred
	 */
	public void removeBycreateDate(Date createDate) throws SystemException {
		for (ResumeDtls resumeDtls : findBycreateDate(createDate)) {
			remove(resumeDtls);
		}
	}

	/**
	 * Removes all the resume dtlses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (ResumeDtls resumeDtls : findAll()) {
			remove(resumeDtls);
		}
	}

	/**
	 * Returns the number of resume dtlses where createDate = &#63;.
	 *
	 * @param createDate the create date
	 * @return the number of matching resume dtlses
	 * @throws SystemException if a system exception occurred
	 */
	public int countBycreateDate(Date createDate) throws SystemException {
		Object[] finderArgs = new Object[] { createDate };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_CREATEDATE,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_RESUMEDTLS_WHERE);

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
	 * Returns the number of resume dtlses.
	 *
	 * @return the number of resume dtlses
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_RESUMEDTLS);

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
	 * Initializes the resume dtls persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.sbi.StartUp.model.ResumeDtls")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ResumeDtls>> listenersList = new ArrayList<ModelListener<ResumeDtls>>();

				for (String listenerClassName : listenerClassNames) {
					Class<?> clazz = getClass();

					listenersList.add((ModelListener<ResumeDtls>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ResumeDtlsImpl.class.getName());
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
	private static final String _SQL_SELECT_RESUMEDTLS = "SELECT resumeDtls FROM ResumeDtls resumeDtls";
	private static final String _SQL_SELECT_RESUMEDTLS_WHERE = "SELECT resumeDtls FROM ResumeDtls resumeDtls WHERE ";
	private static final String _SQL_COUNT_RESUMEDTLS = "SELECT COUNT(resumeDtls) FROM ResumeDtls resumeDtls";
	private static final String _SQL_COUNT_RESUMEDTLS_WHERE = "SELECT COUNT(resumeDtls) FROM ResumeDtls resumeDtls WHERE ";
	private static final String _FINDER_COLUMN_CREATEDATE_CREATEDATE_1 = "resumeDtls.createDate IS NULL";
	private static final String _FINDER_COLUMN_CREATEDATE_CREATEDATE_2 = "resumeDtls.createDate = ?";
	private static final String _ORDER_BY_ENTITY_ALIAS = "resumeDtls.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ResumeDtls exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ResumeDtls exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ResumeDtlsPersistenceImpl.class);
	private static ResumeDtls _nullResumeDtls = new ResumeDtlsImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ResumeDtls> toCacheModel() {
				return _nullResumeDtlsCacheModel;
			}
		};

	private static CacheModel<ResumeDtls> _nullResumeDtlsCacheModel = new CacheModel<ResumeDtls>() {
			public ResumeDtls toEntityModel() {
				return _nullResumeDtls;
			}
		};
}