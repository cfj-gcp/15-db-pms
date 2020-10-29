package com.cy.db.pojo;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;
@Data
@ToString
public class userMenu implements Serializable {
    private static final long serialVersionUID = 5373065045806145677L;
    private Integer id;
    private String name;
    private String url;
    private List<userMenu> childs;
}
