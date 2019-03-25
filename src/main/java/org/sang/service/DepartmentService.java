package org.sang.service;

import org.sang.bean.Department;

import java.util.List;

public interface DepartmentService {

    /**
     * 批量保存部门
     * @param list
     * @return
     */
    List<Department> saveAll(Iterable<Department> list);

    /**
     * 查找所有的部门
     * @return
     */
    List<Department> findAllDept();

    /**
     * 根据单位编码查找部门
     * @param unitNo
     * @return
     */
    List<Department> findAllByUnitNo(String unitNo);

    /**
     * 根据单位编码和部门编码查找该部门下的子部门（用父部门的单位编码和部门编码）
     * @param unitNo 该部门的单位编码
     * @param deptNo 该部门的部门编码
     * @return
     */
    List<Department> findAllByUnitNoAndPDeptNo(String unitNo, String deptNo);
}
