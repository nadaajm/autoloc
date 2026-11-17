package tn.esprit.autoloc.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class PerformanceAspect {

    @Around("execution(* tn.esprit.autoloc.service.*.*(..))")
    public Object mesurerTemps(ProceedingJoinPoint joinPoint) throws Throwable {
        long debut = System.currentTimeMillis();

        Object resultat = joinPoint.proceed();

        long duree = System.currentTimeMillis() - debut;
        String methode = joinPoint.getSignature().getName();


        log.info("Méthode {} exécutée en {} ms", methode, duree);

        if (duree > 1000) {
            log.warn("ATTENTION : la méthode {} est lente ({} ms > 1000 ms)", methode, duree);
        }

        return resultat;
    }
}