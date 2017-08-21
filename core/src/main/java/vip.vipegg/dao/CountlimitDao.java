package vip.vipegg.dao;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import vip.vipegg.dao.common.HibernateDaoSupport;
import vip.vipegg.model.CountLimit;

import java.util.List;

import static org.hibernate.criterion.Example.create;

@Repository
public class CountlimitDao extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory
			.getLogger(CountlimitDao.class);
	
	public static final String IP = "ip";
	public static final String COUNT = "count";

	public void save(CountLimit transientInstance) {
		log.debug("saving CountLimit instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(CountLimit persistentInstance) {
		log.debug("deleting CountLimit instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public CountLimit findById(Integer id) {
		log.debug("getting CountLimit instance with id: " + id);
		try {
			CountLimit instance = (CountLimit) getSession().get(
					"CountLimit", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<CountLimit> findByExample(CountLimit instance) {
		log.debug("finding Countlimit instance by example");
		try {
			List<CountLimit> results = (List<CountLimit>) getSession()
					.createCriteria("CountLimit").add(create(instance))
					.list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding CountLimit instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from CountLimit as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<CountLimit> findByIp(Object fip) {
		return findByProperty(IP, fip);
	}

	public List<CountLimit> findByCount(Object fcount) {
		return findByProperty(COUNT, fcount);
	}

	public List findAll() {
		log.debug("finding all CountLimit instances");
		try {
			String queryString = "from CountLimit";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public CountLimit merge(CountLimit detachedInstance) {
		log.debug("merging CountLimit instance");
		try {
			CountLimit result = (CountLimit) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(CountLimit instance) {
		log.debug("attaching dirty CountLimit instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(CountLimit instance) {
		log.debug("attaching clean CountLimit instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
	
	public List<CountLimit> list(int firstResult, int maxResults, String filter, boolean isFY) {
		List<CountLimit> list = null;
		log.debug("finding CountLimit instance with filter");
		try {
			String queryString = "from CountLimit "+filter;
			Query queryObject = getSession().createQuery(queryString);
			if(isFY){
				queryObject.setFirstResult(firstResult);
				queryObject.setMaxResults(maxResults);
			}
			list = queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by CountLimit name failed", re);
			throw re;
		}
		return list;
	}
}