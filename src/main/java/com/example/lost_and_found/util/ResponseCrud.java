package com.example.lost_and_found.util;

import org.springframework.stereotype.Repository;
import java.util.List;
/**
 * 用于前后端交互，一次返回多个相同种类数据的响应类。
 */
@Repository
public class ResponseCrud<T> {
    public List<T> rows;
    public int count;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}