package com.cy.db.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class node  implements Serializable {
    private static final long serialVersionUID = -7791392992359380461L;
    private  Integer id;
    private  String  name;
    private  Integer  parentId;
}
