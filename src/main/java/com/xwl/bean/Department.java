package com.xwl.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain=true)
@Entity
@Table(name = "t_department")
public class Department {
    @Id
    @GenericGenerator(name = "dept-uuid", strategy = "uuid")
    @GeneratedValue(generator = "dept-uuid")
    private String id;

    // 部门名称
    @Column(nullable = false)
    private String deptName;

    // 部门简称
    private String deptShortName;

    // 部门编码
    @Column(nullable = false)
    private String deptNo;

    // 单位编码
    @Column(nullable = false)
    private String unitNo;

    // 父部门编码
    private String pDeptNo;
}
