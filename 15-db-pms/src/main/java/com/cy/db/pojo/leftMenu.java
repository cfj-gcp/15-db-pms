package com.cy.db.pojo;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

//根据角色动态显示左侧菜单
@Data
@ToString
public class leftMenu  implements Serializable {

    private static final long serialVersionUID = -2217319351995890590L;
    private Integer id;
    private String name;
    private String url;
    private List<leftMenu> childs;

}
