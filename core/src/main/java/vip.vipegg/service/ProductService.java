package vip.vipegg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vip.vipegg.dao.ProductDao;
import vip.vipegg.model.Product;

import java.util.List;
import java.util.Map;

/**
 * Created by yujie on 2017/8/17.
 * 招股金服
 */
@Service
public class ProductService{

    @Autowired
    private ProductDao entityDao;

    public void save(Product entity) {
        entityDao.save(entity);
    }

    public void delete(Product entity) {
        entityDao.delete(entity);
    }

    public void update(Product entity) {
        entityDao.update(entity);
    }

    public Product findById(int id) {
        return entityDao.findById(id);
    }

    public List<Product> findByProperties(Map<String, Object> propValueMap, Integer offset, Integer length) {
        return entityDao.findByProperties(propValueMap, offset, length);
    }

    public int countByProperties(Map<String, Object> propValueMap) {
        return entityDao.countByProperties(propValueMap);
    }
}
