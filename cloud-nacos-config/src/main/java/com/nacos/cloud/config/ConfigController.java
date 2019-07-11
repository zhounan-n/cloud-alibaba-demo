package com.nacos.cloud.config;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by zhoun on 2019-07-11
 */
@Controller
@RequestMapping("config")
public class ConfigController {


    //通过@NacosValue设置属性值,并且动态刷新[nacos控制台修改后会刷新]
    //nacos open api调用进行修改 curl -X POST "http://127.0.0.1:8848/nacos/v1/cs/configs?dataId=example&group=DEFAULT_GROUP&content=useLocalCache=true"
    @NacosValue(value = "${useLocalCache:false}",autoRefreshed = true)
    private boolean useLocalCache;

    @GetMapping(value = "get")
    @ResponseBody
    public boolean get(){
        return useLocalCache;
    }

}
