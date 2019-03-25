package org.sang.dao;

import org.sang.bean.Unit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UnitDao extends JpaRepository<Unit,String> {

    Unit findByUnitNo(String unitNo);
}
