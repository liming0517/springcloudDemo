package com.liming.springcloud.service;

import com.liming.springcloud.entity.Dept;
import com.liming.springcloud.service.impl.DeptServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class DeptServiceImplTest {
    @Autowired
    public DeptServiceImpl deptService;

    @Test
    public void findByid(){
        String d=deptService.get(1L).getDname();
        System.out.println(d);
    }

}
