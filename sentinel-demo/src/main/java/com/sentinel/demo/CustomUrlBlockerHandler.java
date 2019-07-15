package com.sentinel.demo;

import com.alibaba.csp.sentinel.adapter.servlet.callback.UrlBlockHandler;
import com.alibaba.csp.sentinel.slots.block.BlockException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * 限流触发后的处理逻辑
 * Created by zhoun on 2019-07-15
 */
public class CustomUrlBlockerHandler implements UrlBlockHandler {


    @Override
    public void blocked(HttpServletRequest request, HttpServletResponse response, BlockException ex) throws IOException {
        //to do your logic
        System.out.println("先溜了");
    }
}
