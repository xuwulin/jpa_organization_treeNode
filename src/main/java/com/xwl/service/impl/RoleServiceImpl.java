package com.xwl.service.impl;

import com.xwl.service.RoleService;
import com.xwl.dao.RoleDao;
import com.xwl.bean.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleDao roleDao;

    @Override
    public List<Role> saveAll(Iterable<Role> list) {
        return roleDao.saveAll(list);
    }

    @Override
    public List<Role> findAllRole() {
        return roleDao.findAll();
    }

    @Override
    public List<Role> findAllByUnitNoAndDeptNo(String unitNo, String deptNo) {
        return roleDao.findAllByUnitNoAndDeptNo(unitNo, deptNo);
    }
}
