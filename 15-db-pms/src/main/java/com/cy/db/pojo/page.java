package com.cy.db.pojo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
@Data//get\set注解
@AllArgsConstructor
@NoArgsConstructor
public class page<T> implements Serializable {
    private static final long serialVersionUID = 6780580291247550747L;//类泛型
    /**
     * 当前页的页码值
     */
    private Integer pageCurrent = 1;
    /**
     * 页面大小
     */
    private Integer pageSize = 3;
    /**
     * 总行数(通过查询获得)
     */
    private Integer rowCount = 0;
    /**
     * 总页数(通过计算获得)
     */
    private Integer pageCount = 0;
    /**
     * 当前页记录
     */
    private List<T> records;

    public page(Integer rowCount, List<T> records, Integer pageCurrent, Integer pageSize) {
        this.rowCount = rowCount;
        this.records = records;
        this.pageCurrent = pageCurrent;
        this.pageSize = pageSize;
        this.pageCount = rowCount / pageSize;
        if (this.rowCount % this.pageSize != 0) this.pageCount++;

    }
}