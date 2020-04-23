package com.xwl.service;

import com.xwl.bean.Unit;

import java.util.List;

public interface UnitService {

    List<Unit> saveAll(Iterable<Unit> list);

    List<Unit> findAllUnit();

    Unit findByUnitNo(String unitNo);

}
