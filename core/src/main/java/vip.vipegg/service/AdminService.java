package vip.vipegg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vip.vipegg.dao.AdminDao;
import vip.vipegg.model.Admin;
import vip.vipegg.model.Product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yujie on 2017/8/17.
 * 招股金服
 */
@Service
public class AdminService {

    @Autowired
    private AdminDao entityDao;

    public List<Admin> findByProperties(Map<String, Object> propValueMap, Integer offset, Integer length) {
        return entityDao.findByProperties(propValueMap, offset, length);
    }

    public List<Admin> findByProperty(String name, Object value) {
        Map map = new HashMap();
        map.put(name, value);
        List<Admin> all = findByProperties(map, null, null);
        return all;
    }
}
