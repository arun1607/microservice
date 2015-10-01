package com.learning.aop;

import com.learning.annotation.CircuitBreaker;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandKey;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by amits on 30/09/15.
 */
@Aspect
@Component
public class CircuitBreakerAspect {
    private Logger logger = Logger.getLogger(CircuitBreaker.class.getName());
    @Around("@annotation(com.learning.annotation.CircuitBreaker)")
    public Object circuitBreakerAround(final ProceedingJoinPoint aJoinPoint) throws Throwable {
        String theShortName = aJoinPoint.getSignature().toShortString();
        HystrixCommand.Setter theSetter =
                HystrixCommand.Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey(theShortName));
        theSetter = theSetter.andCommandKey(HystrixCommandKey.Factory.asKey(theShortName));
        HystrixCommand theCommand = new HystrixCommand(theSetter) {
            @Override
            protected Object run() throws Exception {
                Object retVal = null;
                try {
                    retVal = aJoinPoint.proceed();
                } catch (Throwable throwable) {
                   logger.log(Level.SEVERE,"Remote system unreachable",throwable);
                }
                return retVal;
            }

            @Override
            protected Object getFallback() {

                return null;
            }
        };
        return theCommand.execute();
    }
}
