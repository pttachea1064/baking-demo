package cn.tedu.baking.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Target(ElementType.METHOD) //描述注解的使用范围
@Retention(RetentionPolicy.RUNTIME) //表示该注解是在运行时存活
public @interface RequiredLog {

    String value();
}
