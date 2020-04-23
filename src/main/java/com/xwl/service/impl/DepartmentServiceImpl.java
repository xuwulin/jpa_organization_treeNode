package com.xwl.service.impl;

import com.xwl.dao.DepartmentDao;
import com.xwl.bean.Department;
import com.xwl.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    DepartmentDao departmentDao;

    @Override
    public List<Department> saveAll(Iterable<Department> list) {
        return departmentDao.saveAll(list);
    }

    @Override
    public List<Department> findAllDept() {
        return departmentDao.findAll();
    }

    @Override
    public List<Department> findAllByUnitNo(String unitNo) {
        return departmentDao.findAllByUnitNo(unitNo);
    }

    @Override
    public List<Department> findAllByUnitNoAndPDeptNo(String unitNo, String pDeptNo) {
        return departmentDao.findAllByUnitNoAndPDeptNo(unitNo, pDeptNo);
    }
}
