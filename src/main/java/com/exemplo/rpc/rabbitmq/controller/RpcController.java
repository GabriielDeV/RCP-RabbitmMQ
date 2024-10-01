package com.exemplo.rpc.rabbitmq.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exemplo.rpc.rabbitmq.client.FibonacciRpcClient;

@RestController
@RequestMapping("/rpc")
public class RpcController {

    private final FibonacciRpcClient fibonacciRpcClient;

    public RpcController(FibonacciRpcClient fibonacciRpcClient) {
        this.fibonacciRpcClient = fibonacciRpcClient;
    }

    @GetMapping("/fib/{n}")
    public String getFibonacci(@PathVariable int n) {
        return fibonacciRpcClient.call(String.valueOf(n));
    }
}