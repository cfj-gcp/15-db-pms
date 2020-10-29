package com.cy.cbgactivity01.activity.controller;

import com.cy.cbgactivity01.activity.pojo.Activity;
import com.cy.cbgactivity01.activity.sevice.ActivityServic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ActivityController {
    @Autowired
    private ActivityServic  activityServic;
    @RequestMapping("activityUI")
    public String doActivityUI(){
          return  "activity";
    }
    @RequestMapping("doFindActivity")
    @ResponseBody
    public List<Activity>  doFindActivity(){
        List<Activity> activity = activityServic.findActivity();
        return  activity;
    }
    @RequestMapping("doSaveActivity")
    @ResponseBody
    public String doSaveActivity(Activity activity){
        activityServic.saveActivity(activity);
        return "save ok";
    }
}
