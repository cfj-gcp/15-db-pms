package com.cy.cbgactivity01.activity.sevice;

import com.cy.cbgactivity01.activity.pojo.Activity;

import java.util.List;

public interface ActivityServic {
    List<Activity>  findActivity();
    int saveActivity(Activity entity);
}
