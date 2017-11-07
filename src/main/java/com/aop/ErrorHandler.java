package com.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 切面处理异常
 */
@Aspect
@Component
public class ErrorHandler extends AbstractAspectj {


    /**
     * 在方法出现异常时会执行的代码
     * 可以访问到异常对象，可以指定在出现特定异常时在执行通知代码
     */
    @AfterThrowing(value = "execution(* com.unittest..*(..))", throwing = "ex")
    public void afterThrowing(JoinPoint joinPoint, Exception ex) {

        if (verifyExceptionType(ex)) {
            StringBuilder content = new StringBuilder();

            content.append("类名：")
                    .append(joinPoint.getSignature().getDeclaringTypeName()).append(br)
                    .append("方法名称：").append(joinPoint.getSignature().getName()).append(br)
                    .append("请求参数：").append(conventTOStr(joinPoint.getArgs())).append(br)
                    .append("异常堆栈：").append(getStackTrace(ex));
            System.out.println(content.toString());
        }
    }

    @Before("execution(* com.unittest..*.*(..))")
    public void before() {
        System.out.println("方法执行前执行.....");
    }

    // 5、后置返回通知：
    @AfterReturning("execution(* com.unittest..*.*(..))")
    public void afterReturning() {
        System.out.println("方法执行完执行.....");
    }

    //6、后置异常通知：
    @AfterThrowing("execution(* com.unittest..*.*(..))")
    public void throwss() {
        System.out.println("方法异常时执行.....");
    }

    //7、后置最终通知：
    @After("execution(* com.unittest..*.*(..))")
    public void after() {
        System.out.println("方法最后执行.....");
    }

    //8、环绕通知：
    @Around("execution(* com.unittest..*.*(..))")
    public Object around(ProceedingJoinPoint pjp) {
        System.out.println("方法环绕start.....");
        try {
            return pjp.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        System.out.println("方法环绕end.....");
        return null;
    }

}  



        
