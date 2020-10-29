package com.cy.cbgactivity01.activity.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
@Data
public class Activity {
    private Integer id;
    private String title;
    private String category;
    @JsonFormat(pattern = "yyy/MM/dd HH:mm")
    private Date startTime;
    @JsonFormat(pattern = "yyy/MM/dd HH:mm")
    private Date endTime;
    private String remark;
    private Integer state=1;
    private Date createdTime;
    private String createdUser;
}
