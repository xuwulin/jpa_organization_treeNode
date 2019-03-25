package org.sang.service;

import org.sang.bean.Role;

import java.util.List;

public interface RoleService {

    /**
     * 批量保存角色
     * @param list
     * @return
     */
    List<Role> saveAll(Iterable<Role> list);

    /**
     * 查找所有角色
     * @return
     */
    List<Role> findAllRole();


    List<Role> findAllByUnitNoAndDeptNo(String unitNo, String deptNo);
}
