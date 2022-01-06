package thangok.icommerce.productmanager.aop.io;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class IOAspect {
    @Around("@annotation(LogIO)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("Enter method [%s] with parameters:(", joinPoint.getSignature()));
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            sb.append(arg).append(",");
        }
        if (args.length > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        sb.append(")");

        log.info(sb.toString());

        return joinPoint.proceed();
    }
}
