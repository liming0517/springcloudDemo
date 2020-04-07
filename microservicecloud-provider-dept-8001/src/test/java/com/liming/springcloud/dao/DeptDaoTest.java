package com.liming.springcloud.dao;

import com.liming.springcloud.entity.Dept;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class DeptDaoTest {
    @Autowired
    public DeptDao deptDao;

    @Test
    public void findByid(){
        Dept dept=deptDao.findById(2L);
        System.out.printf("dept=="+dept.getDname());
    }
}
