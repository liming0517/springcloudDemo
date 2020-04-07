package com.liming.springcloud.service;

import com.liming.springcloud.entity.Dept;

import java.util.List;

public interface DeptService {
    public boolean addDept(Dept dept);
    public Dept get(Long  id);
    public List<Dept> list();
}
