package tn.esprit.autoloc.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Slf4j
@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* tn.esprit.autoloc.service.*.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        log.info("Appel de la méthode : {} | Paramètres : {}",
                joinPoint.getSignature().getName(),
                Arrays.toString(joinPoint.getArgs()));
    }

    @After("execution(* tn.esprit.autoloc.service.*.*(..))")
    public void logAfter(JoinPoint joinPoint) {
        log.info("Fin de l'exécution de la méthode : {}",
                joinPoint.getSignature().getName());
    }
}