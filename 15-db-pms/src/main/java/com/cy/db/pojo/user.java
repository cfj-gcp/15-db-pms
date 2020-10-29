package com.cy.db.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class user implements Serializable {
    private static final long serialVersionUID = 437377592788305775L;
    private Integer id;
    private String username;
    private String password;
    private String salt;//盐值
    private String email;
    private String mobile;
    private Integer valid=1;
    private Integer deptId;
    private Date createdTime;
    private Date modifiedTime;
    private String createdUser;
    private String modifiedUser;
}
