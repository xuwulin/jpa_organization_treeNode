package org.sang.bean;

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
@Table(name = "t_role")
public class Role {

    @Id
    @GenericGenerator(name = "user-uuid", strategy = "uuid")
    @GeneratedValue(generator = "user-uuid")
    private String id;

    // 角色编码
    private String roleNo;

    // 角色名称
    @Column(nullable = false)
    private String roleName;

    // 单位编码
    @Column(nullable = false)
    private String unitNo;

    // 部门编码
    @Column(nullable = false)
    private String deptNo;



}
