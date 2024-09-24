package com.fjy.fxtools.utils.thread;

import cn.hutool.core.thread.NamedThreadFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 线程池
 * @author fangjy
 */
@Slf4j
@Component
public class ThreadPoolUtil<T> {
    private ExecutorService service;
    private final ThreadLocal<List<FutureTask<T>>> futureList	= new ThreadLocal<>();

    /**
     * 执行线程需要有返回值
     * @param call  Callable
     */
    public void async(Callable<T> call) {
        async(call, true);
    }

    public void async(Callable<T> call, boolean needBack) {
        FutureTask<T> task = new FutureTask<>(call);
        if (needBack) {
            List<FutureTask<T>> list = futureList.get();
            if (list == null) {
                list = new ArrayList<>();
                futureList.set(list);
            }
            list.add(task);
        }
        service.submit(task);
    }


    /**
     * 执行线程不需要返回值
     * @param run  Runnable
     */
    public void async(Runnable run) {
        if (run != null) {
            service.execute(run);
        }
    }

    /**
     * 获取线程返回值
     * @return List<T>
     */
    public List<T> get() {
        List<FutureTask<T>> list = futureList.get();
        List<T> result = new ArrayList<>();
        try {
            for (FutureTask<T> task : list) {
                result.add(task.get());
            }
        } catch (Exception e) {
            log.error("获取线程返回结果失败: ", e);
            Thread.currentThread().interrupt();
        } finally {
            futureList.remove();
        }
        return result;
    }


    @PostConstruct
    public void initialize() {
        service = new ThreadPoolExecutor(20, 20,
                60L, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(), new NamedThreadFactory("MessagePool-",false),new ThreadPoolExecutor.AbortPolicy());

    }
    @PreDestroy
    public void destroy() {
        service.shutdown();
    }


}
