package sample.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AOPTest {
    @Pointcut("execution(* sample.aop.Dog.eat(..))")
    public void pointCut() {
    }

    @Before("pointCut()")
    public void before() {
        System.out.println("Before eat");
    }
}
