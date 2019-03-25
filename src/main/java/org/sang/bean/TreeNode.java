package org.sang.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain=true)
public class TreeNode {
    // 用于存放节点值，相当于value值
    private String id;

    // 节点文本内容
    private String name;

    // 父节点id
    private String pId;

    // 字节点
    private List<TreeNode> children = new ArrayList<>();

    // 是否展开节点
    private boolean open = true;

    // 是否选中节点
    private boolean checked = false;
}
