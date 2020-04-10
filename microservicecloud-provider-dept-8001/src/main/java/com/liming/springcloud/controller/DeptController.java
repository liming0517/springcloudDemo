package com.liming.springcloud.controller;

import com.liming.springcloud.entity.Dept;
import com.liming.springcloud.service.impl.DeptServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeptController {

    @Autowired
    public DeptServiceImpl deptService;

    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value="/dept/add",method = RequestMethod.POST)
    public boolean addDept(Dept dept){
        return deptService.addDept(dept);
    }

    @RequestMapping(value= "/dept/get/{id}",method=RequestMethod.GET)
    public Dept get(@PathVariable Long id){
        return deptService.get(id);
    }

    @RequestMapping(value = "/dept/list")
    public List<Dept> getAllDept()
    {
        return deptService.list();
    }

    /*eureka服务发现*/
    @RequestMapping(value = "/dept/discovery", method = RequestMethod.GET)
    public Object discovery()
    {
        List<String> list = client.getServices();
        System.out.println("**********" + list);

        List<ServiceInstance> srvList = client.getInstances("MICROSERVICECLOUD-DEPT");
        for (ServiceInstance element : srvList) {
            System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t" + element.getPort() + "\t"
                    + element.getUri());
        }
        return this.client;
    }

}
