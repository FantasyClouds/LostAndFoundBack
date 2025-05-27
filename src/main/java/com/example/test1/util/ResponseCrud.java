package com.example.test1.util;

import org.springframework.stereotype.Repository;
import java.util.List;

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
}package com.example.test1.util;

import org.springframework.stereotype.Repository;
import java.util.List;

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