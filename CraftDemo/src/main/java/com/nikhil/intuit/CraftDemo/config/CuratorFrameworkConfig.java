package com.nikhil.intuit.CraftDemo.config;

import org.apache.curator.framework.CuratorFramework;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;

@Configuration
public class CuratorFrameworkConfig {
    @Bean
    public CuratorFramework curatorFramework() {
        // Configure CuratorFramework with necessary settings
        CuratorFramework curatorFramework = CuratorFrameworkFactory.newClient(
                "localhost:2181", // Replace with your ZooKeeper server address
                new ExponentialBackoffRetry(1000, 3)
        );
        curatorFramework.start();
        return curatorFramework;
    }
}
