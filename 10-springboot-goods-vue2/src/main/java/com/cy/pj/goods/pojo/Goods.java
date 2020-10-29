package com.cy.pj.goods.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Goods {
    private Long id;//id bigint primary key auto_increment
    private String name;//name varchar(100) not null
    private String remark;//remark text
//    告诉springmvc web模块将对象转换为json串时，这个日期按照指定格式转换
    @JsonFormat(pattern = "yyy/MM/dd HH:mm:ss")
    private Date createdTime;//createdTime datetime

//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getRemark() {
//        return remark;
//    }
//
//    public void setRemark(String remark) {
//        this.remark = remark;
//    }
//
//    public Date getCreatedTime() {
//        return createdTime;
//    }
//
//    public void setCreatedTime(Date createdTime) {
//        this.createdTime = createdTime;
//    }
//
//    @Override
//    public String toString() {
//        return "Goods{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", remark='" + remark + '\'' +
//                ", createdTime=" + createdTime +
//                '}';
//    }
}
