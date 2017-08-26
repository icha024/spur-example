package com.example;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.jboss.logging.Logger;

@Aspect
public class AspectWeaving {

    private static final Logger log = Logger.getLogger(AspectWeaving.class.getName());

    @Around("execution(* com.example.App.*(..))")
    public void around(ProceedingJoinPoint pjp) throws Throwable {
        long startTime = System.currentTimeMillis();
        try {
            pjp.proceed();
        } finally {
            log.info(pjp.toShortString() + " in " + (System.currentTimeMillis() - startTime) + " ms");
        }
    }
}
