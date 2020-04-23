package com.xwl.dao;

import com.xwl.bean.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleDao extends JpaRepository<Role, String> {

    /**
     * 根据单位编码和部门编码查找角色信息
     * @param unitNo 单位编码
     * @param deptNo 部门编码
     * @return
     */
    List<Role> findAllByUnitNoAndDeptNo(String unitNo, String deptNo);
}
