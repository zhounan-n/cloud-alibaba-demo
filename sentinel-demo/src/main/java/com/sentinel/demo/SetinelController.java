package com.sentinel.demo;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhoun on 2019-07-12
 */
@RestController
@RequestMapping("test")
public class SetinelController {

    public static void main(String[] args){
        //配置规则
        initFlowRules();
        while(true){
            try{
                //SphU方式埋点
                Entry entry = SphU.entry("HelloWorld");
                //被保护的逻辑
                System.out.println("hello world");
            }catch (BlockException e){
                //处理流控的逻辑
                System.out.println("blocked");
            }
        }


    }

    //定义规则[此种方式代码配置  可以通过控制台配置]
    private static void initFlowRules(){
        List<FlowRule> rules = new ArrayList<>();
        FlowRule flowRule = new FlowRule();
        //资源
        flowRule.setRefResource("HelloWorld");
        flowRule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        //SET QPS LIMIT TO 20
        flowRule.setCount(20);
        rules.add(flowRule);
        FlowRuleManager.loadRules(rules);
    }


    //用注解方式
    @SentinelResource("HelloWorld")
    public void helloworld(){
        System.out.println("hello world");
    }


    //注解方式埋点
    @SentinelResource("resource")
    @RequestMapping("hello")
    public String hello() {
        return "Hello";
    }
}
