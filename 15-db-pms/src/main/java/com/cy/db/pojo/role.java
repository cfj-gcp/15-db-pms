package com.cy.db.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class role implements Serializable {
    private static final long serialVersionUID = -5474736386243892599L;
    private Integer id;
    private String name;
    private String note;
    private Date createdTime;
    private Date modifiedTime;
    private String createdUser;
    private String modifiedUser;
}
