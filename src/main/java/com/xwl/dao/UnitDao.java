package com.xwl.dao;

import com.xwl.bean.Unit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnitDao extends JpaRepository<Unit,String> {

    Unit findByUnitNo(String unitNo);
}
