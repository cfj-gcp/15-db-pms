package com.cy.db.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;
@Data
//封装角色以及对应的权限菜单信息
public class roleMenu  implements Serializable {
    private static final long serialVersionUID = -993302961136058195L;
    private Integer id;
    private String name;
    private String note;
    /**角色对应的菜单id*/
    private List<Integer> menuIds;
}
