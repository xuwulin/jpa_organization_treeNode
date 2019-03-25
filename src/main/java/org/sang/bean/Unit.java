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
@Table(name = "t_unit")
@GenericGenerator(name = "unit-uuid", strategy = "uuid")
public class Unit {

    @Id
    @GeneratedValue(generator = "unit-uuid")
    private String id;

    // 单位名称
    @Column(nullable = false)
    private String unitName;

    // 单位简称
    private String unitShortName;

    // 单位编码
    @Column(nullable = false)
    private String unitNo;

    // 父单位编码
    private String pUnitNo;

}
