package com.cy.db.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class userRole  implements Serializable {
    private static final long serialVersionUID = -9085561154625727396L;
    private  Integer id;
    private  String name;
}
