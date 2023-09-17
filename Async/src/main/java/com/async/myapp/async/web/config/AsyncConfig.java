package com.async.myapp.async.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurerSupport;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@EnableAsync    //비동기 활성화
@Configuration  //클래스를 Bean으로 등록
public class AsyncConfig extends AsyncConfigurerSupport {

    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor(); //executor : 실행자
        executor.setCorePoolSize(5);    //기본 실행대기하는 thread 수
        executor.setMaxPoolSize(10);    //동시 동작하는 최대 thread 수
        executor.setQueueCapacity(30);  //thread 생성 요청 시 corePoolSize 또는 MaxPoolSize가 초과되었을 때, 해당 요청을 Queue에 저장. Queue가 수용할 수 있는 최대 Thread 수
        executor.setThreadNamePrefix("EVENT-");    //thread 생성 시 접두사
        executor.initialize();
        return executor;
    }
}
