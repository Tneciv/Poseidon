package com.tneciv.poseidon.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

@Configuration
@EnableAsync
public class ExecutorConfig {

    /**
     * Set the ThreadPoolExecutor's core pool size.
     */
    private static final int CORE_POOL_SIZE = 10;
    /**
     * Set the ThreadPoolExecutor's maximum pool size.
     */
    private static final int MAX_POOL_SIZE = 100;
    /**
     * Set the capacity for the ThreadPoolExecutor's BlockingQueue.
     */
    private static final int QUEUE_CAPACITY = 10;

    @Bean
    public Executor proAsync() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(CORE_POOL_SIZE);
        executor.setMaxPoolSize(MAX_POOL_SIZE);
        executor.setQueueCapacity(QUEUE_CAPACITY);
        executor.setThreadNamePrefix("ProExecutor-");
        // rejection-policy：当pool已经达到max size的时候，如何处理新任务  
        // CALLER_RUNS：不在新线程中执行任务，而是有调用者所在的线程来执行  
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.initialize();
        return executor;
    }
    
}