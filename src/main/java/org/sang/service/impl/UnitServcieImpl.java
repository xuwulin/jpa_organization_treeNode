package org.sang.service.impl;

import org.sang.dao.UnitDao;
import org.sang.bean.Unit;
import org.sang.service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnitServcieImpl implements UnitService {

    @Autowired
    UnitDao unitDao;

    @Override
    public List<Unit> saveAll(Iterable<Unit> list) {
        return unitDao.saveAll(list);
    }

    @Override
    public List<Unit> findAllUnit() {
        return unitDao.findAll();
    }

    @Override
    public Unit findByUnitNo(String unitNo) {
        return unitDao.findByUnitNo(unitNo);
    }
}
