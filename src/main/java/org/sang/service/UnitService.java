package org.sang.service;

import org.sang.bean.Unit;

import java.util.List;

public interface UnitService {

    List<Unit> saveAll(Iterable<Unit> list);

    List<Unit> findAllUnit();

    Unit findByUnitNo(String unitNo);

}
