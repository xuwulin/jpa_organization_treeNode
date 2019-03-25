package org.sang.controller;

import org.sang.bean.Department;
import org.sang.bean.Role;
import org.sang.bean.TreeNode;
import org.sang.bean.Unit;
import org.sang.service.DepartmentService;
import org.sang.service.RoleService;
import org.sang.service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UnitDeptRoleTreeController {

    @Autowired
    UnitService unitService;

    @Autowired
    DepartmentService departmentService;

    @Autowired
    RoleService roleService;

    /**
     * 获取所有的单位树，该案例只查找单位树
     * 表结构：
     *       id    unit_no    unit_name    unit_short_name    p_unit_no
     *
     * 返回形式：
     *          父单位
     *             --单位
     *               --单位
     * @return
     */
    @GetMapping("/getUnitTree")
    public List<TreeNode> getUnitTree() {

        // 定义要返回的结果
        List<TreeNode> resUnitDeptRoleTreeNodeList = new ArrayList<>();

        // 单位树，临时存放
        List<TreeNode> nodeListEmp = new ArrayList<>();

        // 查询所有的单位
        List<Unit> unitList = unitService.findAllUnit();

        // 使用HashMap的目的是使用HashMap的索引
        Map<String, TreeNode> unitTreeNodeMap = new HashMap<>();

        // 遍历所有的单位，将单位信息中的单位编码、单位名称、父单位编码赋值到树形节点TreeNode的id、text、pid
        for (Unit u : unitList) {
            TreeNode node = new TreeNode();
            node.setId(u.getUnitNo());
            node.setName(u.getUnitName());
            node.setPId(u.getPUnitNo());

            // 将树形节点放入ArrayList，用于下面的遍历
            nodeListEmp.add(node);

            // 将树形节点放入HashMap
            unitTreeNodeMap.put(node.getId(), node);
        }

        // 遍历树形节点，判断父节点和字节点
        for (TreeNode treeNode : nodeListEmp) {
            // 1、先将所有的树形节点当成子节点
            TreeNode child = treeNode;

            // 2、如果该节点中的pid为null，则表明它是根节点
            if (child.getPId() == null) {
                resUnitDeptRoleTreeNodeList.add(treeNode);
            } else {
                // 如果该节点的pid不为null，表示他一定是字节点
                // child.getPId() 获取该子节点的父id
                // unitTreeNodeMap.get(child.getPId()) 即为父节点
                TreeNode parent = unitTreeNodeMap.get(child.getPId()); // 通过子节点的pid找父节点

                // 将子节点放到父节点下
                parent.getChildren().add(child);
            }
        }

        return resUnitDeptRoleTreeNodeList;
    }

    /**
     * 获取所有单位及单位下的部门/子部门，角色/子部门角色
     *
     * 返回形式：
     *          单位
     *            --部门
     *              --子部门
     *              --角色
     *            --下级单位
     *          单位
     *            --部门
     *              --子部门
     *              --角色
     *            --下级单位
     *
     * 思路：
     *      1、先根据单位编码和部门编码查询角色信息，返回一个List<TreeNode>
     *      2、根据单位编码获取部门信息，部门中将角色信息装载好，返回一个List<TreeNode>
     *
     * @return
     */
    @GetMapping("getAllUnitDeptRoleTree")
    public List<TreeNode> getAllUnitDeptRoleTree() {

        // 当前时间
        Instant ins1 = Instant.now();

        // 定义要返回的结果
        List<TreeNode> resUnitDeptRoleTreeNodeList = new ArrayList<>();

        // 单位树，临时存放
        List<TreeNode> nodeListEmp = new ArrayList<>();

        // 查询所有的单位
        List<Unit> unitList = unitService.findAllUnit();
//        List<Unit> unitList = unitService.findByUnitNo("460000");

        // 使用HashMap的目的是使用HashMap的索引
        Map<String, TreeNode> unitTreeNodeMap = new HashMap<>();

        // 遍历所有的单位，将单位信息中的单位编码、单位名称、父单位编码赋值到树形节点TreeNode的id、text、pid
        for (Unit u : unitList) {
            TreeNode node = new TreeNode();
            node.setId(u.getUnitNo())
                    .setName(u.getUnitName())
                    .setPId(u.getPUnitNo());

            // 将树形节点放入ArrayList，用于下面的遍历
            nodeListEmp.add(node);

            // 将树形节点放入HashMap
            unitTreeNodeMap.put(node.getId(), node);
        }

        // 遍历树形节点，判断父节点和字节点
        for (TreeNode treeNode : nodeListEmp) {
            // 1、先将所有的树形节点当成子节点
            TreeNode child = treeNode;

            // 2、如果该节点中的pid为null，则表明它是根节点
            if (child.getPId() == null) {

                // 获取该单位下的部门和角色
                List<TreeNode> deptRoleTreeNodeList = this.getOneUnitDeptRoleTree(child.getId());
                if (deptRoleTreeNodeList.size() > 0) {
                    child.setChildren(deptRoleTreeNodeList);
                }

                resUnitDeptRoleTreeNodeList.add(treeNode);
            } else {
                // 如果该节点的pid不为null，表示他一定是字节点
                // child.getPId() 获取该子节点的父id
                // unitTreeNodeMap.get(child.getPId()) 即为父节点
                TreeNode parent = unitTreeNodeMap.get(child.getPId()); // 通过子节点的pid找父节点

                // 获取该单位下的部门和角色
                List<TreeNode> deptRoleTreeNodeList2 = this.getOneUnitDeptRoleTree(child.getId());
                if (deptRoleTreeNodeList2.size() > 0) {
                    child.setChildren(deptRoleTreeNodeList2);
                }

                // 将子节点放到父节点下
                parent.getChildren().add(child);
            }
        }

        // 当前时间
        Instant ins2 = Instant.now();

        System.out.println(Duration.between(ins1, ins2)); // 0.078S 0.04S 0.032S 0.027S 0.036S
        return resUnitDeptRoleTreeNodeList;
    }

    /**
     * 获取某一个单位下的部门角色信息
     * 返回形式：
     *         单位
     *            --部门
     *              --角色
     *              --子部门
     *                --子部门角色
     * @return
     */
    @GetMapping("getOneUnitDeptRoleTree/{unitNo}")
    public List<TreeNode> getOneUnitDeptRoleTree(@PathVariable("unitNo") String unitNo) {
        // 定义要返回的结果
        List<TreeNode> resUnitDeptRoleTreeNodeList = new ArrayList<>();

        // 查询所有的单位
        Unit unit = unitService.findByUnitNo(unitNo);

        // 获取该单位下的部门/（子部门）和角色/（子部门角色）
        List<TreeNode> deptRoleTreeNodeList = this.getDeptRoleTree(unitNo);

        TreeNode unitNode = new TreeNode();

        unitNode.setId(unit.getUnitNo())
                .setName(unit.getUnitName())
                .setPId(unit.getPUnitNo())
                .setChildren(deptRoleTreeNodeList);

        resUnitDeptRoleTreeNodeList.add(unitNode);

        return resUnitDeptRoleTreeNodeList;
    }

    /**
     * 根据单位编码获取部门信息，返回一个List<TreeNode>，部门中包含角色
     * 返回形式：
     *          部门
     *            --角色
     *            --子部门
     *              --子部门角色
     *
     * @param unitNo 单位编码
     * @return
     */
    public List<TreeNode> getDeptRoleTree(String unitNo) {

        // 定义要返回的TreeNode集合
        List<TreeNode> resDeptRoleTreeNodeList = new ArrayList<>();

        // 定义TreeNode集合，用于遍历出子部门
        List<TreeNode> deptTreeNodeList = new ArrayList<>();

        // 根据单位编码查询部门信息，注意有子部门的情况
        List<Department> departmentList = departmentService.findAllByUnitNo(unitNo);

        // 遍历所有的部门，将部门信息中的部门编码、部门名称、父部门编码赋值到树形节点TreeNode的id、text、pid
        for (Department dept : departmentList) {
            TreeNode deptNode = new TreeNode();

            // 链式调用（TreeNode类中的@Accessors(chain=true)注解）
            deptNode.setId(dept.getDeptNo())
                    .setName(dept.getDeptName())
                    .setPId(dept.getPDeptNo());

            // 将树形节点放入ArrayList， 用于下面的遍历找出子部门
            deptTreeNodeList.add(deptNode);
        }

        // 遍历deptTreeNodeList，找出子部门
        for (TreeNode deptNode : deptTreeNodeList) {
            // 1、先将所有的树形节点当成子节点
            TreeNode child = deptNode;

            // 如果这个部门的PId为null，则表明该部门一定是父部门
            if (child.getPId() == null) {
                // 获取该部门下的角色
                List<TreeNode> roleTreeNodeList = this.getRoleTree(unitNo, deptNode.getId());

                if (roleTreeNodeList.size() > 0) {
                    child.setChildren(roleTreeNodeList);
                }
                resDeptRoleTreeNodeList.add(child);
            } else {
                // 如果这个部门的PId不为null，则表明该部门一定是子部门
                for (TreeNode parentDeptNode : deptTreeNodeList) {
                    if (child.getPId().equals(parentDeptNode.getId())) {
                        // 父节点
                        TreeNode parent = parentDeptNode;

                        // 获取该部门下的角色
                        List<TreeNode> roleTreeNodeList2 = this.getRoleTree(unitNo, child.getId());
                        if (roleTreeNodeList2.size() > 0) {
                            child.setChildren(roleTreeNodeList2);
                        }

                        // 组合父子节点的关系
                        parent.getChildren().add(child);
                        // 跳出循环
                        break;
                    }
                }
            }
        }

        return resDeptRoleTreeNodeList;
    }

    /**
     * 根据单位编码和部门编码查询角色信息，返回一个List<TreeNode>
     *
     * @param unitNo 单位编码
     * @param deptNo 部门编码
     * @return
     */
    public List<TreeNode> getRoleTree(String unitNo, String deptNo) {

        // 定义要返回的TreeNode集合
        List<TreeNode> resRoleTreeNodeList = new ArrayList<>();

        // 根据单位编码和部门编码查询所有的角色
        List<Role> roleList = roleService.findAllByUnitNoAndDeptNo(unitNo, deptNo);

        // 遍历所有的角色，将角色信息中的角色编码、角色名称、部门编码赋值到树形节点TreeNode的id、text、pid
        for (Role role : roleList) {
            TreeNode node = new TreeNode();
            // 链式调用（TreeNode类中的@Accessors(chain=true)注解）
            node.setId(role.getRoleNo())
                    .setName(role.getRoleName())
                    .setPId(role.getDeptNo());

            // 将树形节点放入ArrayList
            resRoleTreeNodeList.add(node);
        }
        return resRoleTreeNodeList;
    }


















}
