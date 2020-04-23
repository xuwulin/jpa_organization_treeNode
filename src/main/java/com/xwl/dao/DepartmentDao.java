package com.xwl.dao;

import com.xwl.bean.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartmentDao extends JpaRepository<Department, String> {

    /**
     * 根据单位编码查找该单位下的所有部门
     * @param unitNo
     * @return
     */
    List<Department> findAllByUnitNo(String unitNo);


    /**
     * 根据单位编码和部门编码找该部门的子部门(该部门的部门编码是子部门的父部门编码)
     * @param unitNo 该部门的单位编码
     * @param deptNo 该部门的部门编码
     * @return
     */
    List<Department> findAllByUnitNoAndPDeptNo(String unitNo, String deptNo);


}
