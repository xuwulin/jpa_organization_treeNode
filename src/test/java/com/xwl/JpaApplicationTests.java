package com.xwl;

import com.xwl.bean.*;
import com.xwl.service.RoleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import com.xwl.dao.BookDao;
import com.xwl.service.DepartmentService;
import com.xwl.service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JpaApplicationTests {

	@Autowired
	BookDao bookDao;

	@Autowired
	UnitService unitService;

	@Autowired
	DepartmentService departmentService;

	@Autowired
    RoleService roleService;

	@Test
	public void contextLoads() {
		List<Book> all = bookDao.findAll();
		System.out.println(all);
		List<Book> booksByIdAndName = bookDao.getBooksByIdAndName("三", 10);
		System.out.println(booksByIdAndName);
	}

	@Test
	public void testUnitSave() {
		Unit unit1 = new Unit();
		unit1.setUnitName("海南省人民检察院").setUnitShortName("琼检").setUnitNo("460000");
		Unit unit2 = new Unit();
		unit2.setUnitName("海南省人民检察院第一分院").setUnitShortName("琼检一分").setUnitNo("460300").setPUnitNo("460000");
		Unit unit3 = new Unit();
		unit3.setUnitName("海南省人民检察院第二分院").setUnitShortName("琼检二分").setUnitNo("460500").setPUnitNo("460000");
		Unit unit4 = new Unit();
		unit4.setUnitName("琼海市人民检察院").setUnitShortName("琼海检").setUnitNo("460023").setPUnitNo("460300");
		Unit unit5 = new Unit();
		unit5.setUnitName("临高县人民检察院").setUnitShortName("临检").setUnitNo("460028").setPUnitNo("460500");

		List<Unit> list = new ArrayList<>();
		list.add(unit1);
		list.add(unit2);
		list.add(unit3);
		list.add(unit4);
		list.add(unit5);

		List<Unit> res = unitService.saveAll(list);
		System.out.println(res);
	}

	@Test
	public void testDeptSave() {
		Department dept1 = new Department();
		dept1.setDeptName("信息化工作办公室").setDeptShortName("信息办").setDeptNo("0001").setUnitNo("460028");
		Department dept2 = new Department();
		dept2.setDeptName("案件管理处").setDeptShortName("案管处").setDeptNo("0002").setUnitNo("460028");
		Department dept3 = new Department();
		dept3.setDeptName("统计部门").setDeptShortName("统计").setDeptNo("0003").setUnitNo("460028").setPDeptNo("0002");
		Department dept4 = new Department();
		dept4.setDeptName("侦查处").setDeptShortName("侦查").setDeptNo("0004").setUnitNo("460028");
		Department dept5 = new Department();
		dept5.setDeptName("侦查一处").setDeptShortName("侦一处").setDeptNo("0005").setUnitNo("460028").setPDeptNo("0004");
		Department dept6 = new Department();
		dept6.setDeptName("侦查二处").setDeptShortName("侦二处").setDeptNo("0006").setUnitNo("460028").setPDeptNo("0004");

		List<Department> list = new ArrayList<>();
		list.add(dept1);
		list.add(dept2);
		list.add(dept3);
		list.add(dept4);
		list.add(dept5);
		list.add(dept6);

		List<Department> res = departmentService.saveAll(list);
		System.out.println(res);


	}


	@Test
	public void testRoleSave() {
		Role role1 = new Role();
		role1.setRoleName("科长").setUnitNo("460028").setDeptNo("0001").setRoleNo("001");
		Role role2 = new Role();
		role2.setRoleName("处长").setUnitNo("460028").setDeptNo("0002").setRoleNo("001");
		Role role3 = new Role();
		role3.setRoleName("副处长").setUnitNo("460028").setDeptNo("0002").setRoleNo("002");
		Role role4 = new Role();
		role4.setRoleName("统计员").setUnitNo("460028").setDeptNo("0003").setRoleNo("001");
		Role role5 = new Role();
		role5.setRoleName("处长").setUnitNo("460028").setDeptNo("0004").setRoleNo("001");
		Role role6 = new Role();
		role6.setRoleName("副处长").setUnitNo("460028").setDeptNo("0004").setRoleNo("002");
		Role role7 = new Role();
		role7.setRoleName("处长").setUnitNo("460000").setDeptNo("0006").setRoleNo("001");
		Role role8 = new Role();
		role8.setRoleName("副处长").setUnitNo("460000").setDeptNo("0006").setRoleNo("002");
		Role role9 = new Role();
		role9.setRoleName("检察官").setUnitNo("460000").setDeptNo("0006").setRoleNo("003");

		List<Role> list = new ArrayList<>();
		list.add(role1);
		list.add(role2);
		list.add(role3);
		list.add(role4);
		list.add(role5);
		list.add(role6);
		list.add(role7);
		list.add(role8);
		list.add(role9);

		List<Role> res = roleService.saveAll(list);
		System.out.println(res);

	}


	@Test
	public void testTree() {

		// 单位树
		List<TreeNode> nodes = new ArrayList<>();
		List<TreeNode> resUnitTreeNode = new ArrayList<>();

		// 查询所有的单位
		List<Unit> unitList = unitService.findAllUnit();
		List<Department> departmentList = departmentService.findAllDept();
		List<Role> roleList = roleService.findAllRole();

		Map<String, TreeNode> unitTreeNodeMap = new HashMap<>();

		for (Unit u : unitList) {
			TreeNode node = new TreeNode();
			node.setId(u.getUnitNo());
			node.setName(u.getUnitName());
			node.setPId(u.getPUnitNo());

			nodes.add(node);

			unitTreeNodeMap.put(node.getId(), node);
		}

		for (TreeNode treeNode : nodes) {
			TreeNode child = treeNode;
			if ( child.getPId() == null ) { // pid为0，则为根节点
				resUnitTreeNode.add(treeNode);
			} else { // pid不为0，表示他一定是字节点
				TreeNode parent = unitTreeNodeMap.get(child.getPId()); // 通过子节点的pid找父节点
				parent.getChildren().add(child);
			}
		}

		System.out.println(resUnitTreeNode);



	}


	/**
	 * 查找子部门
	 */
	@Test
	public void test2() {
		List<Department> departments = departmentService.findAllByUnitNoAndPDeptNo("460000", "0004");
		System.out.println(departments);
	}
}
