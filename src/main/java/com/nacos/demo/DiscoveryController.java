package com.nacos.demo;

import com.alibaba.nacos.api.annotation.NacosInjected;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.pojo.Instance;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by zhoun on 2019-07-11
 */
@Controller
@RequestMapping("discovery")
public class DiscoveryController {

    //使用NacosInjected注入实例
    @NacosInjected
    private NamingService namingService;

    @GetMapping("get")
    @ResponseBody
    public List<Instance> get(@RequestParam String serviceName) throws NacosException {
        //返回服务实例
        return namingService.getAllInstances(serviceName);
    }



}
