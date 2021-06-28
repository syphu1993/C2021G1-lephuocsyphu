package book.manager.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class BookAspect {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @AfterReturning("execution(* book.manager.controller.BookController.*(..))")
    public void logger(JoinPoint joinPoint){
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.error("Name method:"+method);
        logger.error("Para:"+args);
    }
}
