package com.nikhil.intuit.CraftDemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
@EnableAsync
public class AsyncConfig {

    @Bean
    public Executor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(10); // Set the number of core threads
        executor.setMaxPoolSize(100); // Set the maximum number of threads
        executor.setQueueCapacity(10); // Set the queue capacity
        executor.setThreadNamePrefix("AsyncThread-"); // Set the thread name prefix
        executor.initialize();
        return executor;
    }
}

