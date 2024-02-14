package com.esprit.examen23.aop;

import io.swagger.v3.oas.annotations.media.ArraySchema;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@org.aspectj.lang.annotation.Aspect
@Slf4j
public class Aspect {
    @Around("execution(* com.esprit.examen23.services..*.ajoute*(..))")
//    @Around("execution(* com.esprit.examen23.services..*.*(..))")
    public Object tempsExecutionAspect(ProceedingJoinPoint proceedingJoinPoint)throws Throwable{
        long start = System.currentTimeMillis();
        Object obj = proceedingJoinPoint.proceed();
        long end = System.currentTimeMillis();
        long duration = end - start;
        log.info("Date: " + java.time.LocalTime.now() + " - Method execution time: " + duration + "ms");
        return obj;
    }
}
