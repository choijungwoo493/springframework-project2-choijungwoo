package com.nhnacademy.springframework.aspect;

import com.nhnacademy.springframework.Main;
import com.nhnacademy.springframework.repository.CsvWaterBill;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class LoggerAspect {
    private static final Log log = LogFactory.getLog(Main.class);

    @Around("execution(* com.nhnacademy.springframework.*.*.*(..))")
    public Object timeCheck(ProceedingJoinPoint pjp) throws Throwable {
        StopWatch stopWatch = new StopWatch(pjp.getSignature().getName());
        try {
            stopWatch.start(pjp.getSignature().getName());
            return pjp.proceed();
        } finally {
            stopWatch.stop();
            log.info("\n" + stopWatch.prettyPrint());
        }
    }

    @Before("execution(* com.nhnacademy.springframework.repository.CsvWaterBill.findAll())")
    public void loadError() {
        try {
            CsvWaterBill.isFileLoaded();
        } catch (IllegalStateException e) {
            log.info("파일 로드가 안되어있습니다");
            throw new IllegalStateException("파일로드가 안되어있습니다");
        }
    }
}
