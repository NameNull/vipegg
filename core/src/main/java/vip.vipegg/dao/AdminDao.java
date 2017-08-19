package vip.vipegg.dao;

import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import vip.vipegg.dao.common.HibernateDaoSupport;
import vip.vipegg.model.Admin;

import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Created by yujie on 2017/8/17.
 * 招股金服
 */
@Repository
public class AdminDao extends HibernateDaoSupport {
    private Logger logger = LoggerFactory.getLogger(AdminDao.class);

    public List<Admin> findByProperties(Map<String, Object> propValueMap, Integer offset, Integer length) {
        StringBuilder hqlBuf = new StringBuilder(" from Admin as model where 1=1 ");
        for (String key : propValueMap.keySet()) {
            hqlBuf.append("and model.").append(key).append("=? ");
        }
        hqlBuf.append("order by model.id desc");

        Query query = getSession().createQuery(hqlBuf.toString());

        Object[] vals = propValueMap.values().toArray();
        for (int i=0; i<vals.length; i++) {
            query.setParameter(i, vals[i]);
        }
        if (Objects.nonNull(offset) && Objects.nonNull(length)) {
            query.setFirstResult(offset);
            query.setMaxResults(length);
        } else if (Objects.nonNull(length)) {
            query.setMaxResults(length);
        }

        logger.info("find admin by properties");
        return query.list();
    }
}
