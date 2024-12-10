package tn.esprit.examen.oueslatighaith4twin5.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServiceLoggerAspect {

    private static final Logger logger = LoggerFactory.getLogger(ServiceLoggerAspect.class);

    @Before("execution(* tn.esprit.examen.oueslatighaith4twin5.services.*.*(..))")
    public void logServiceAccess(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        logger.info("Bienvenue a l'un des service de l'application Boycott: " + methodName);
    }
}