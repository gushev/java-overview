package aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DemoAspect {

    @Before("execution(* services.DemoService.*(..))")
    public void before() {
        System.out.println("This is called BEFORE method execution");
    }

    @After("execution(* services.DemoService.*(..))")
    public void after() {
        System.out.println("This is called AFTER method execution");
    }

    @AfterReturning("execution(* services.DemoService.*(..))")
    public void afterReturning() {
        System.out.println("This method will be executed when NO exception is throws");
    }

    @AfterThrowing("execution(* services.DemoService.*(..))")
    public void afterThrowing() {
        System.out.println("This method will be executed when an exception IS throws");
    }

    @Around("execution(* services.DemoService.getStringAround(..))")
    public Object around(ProceedingJoinPoint joinPoint) {
        System.out.println("This comes from the around method");
        try {
            joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return "Response got spoofed";
    }
}
