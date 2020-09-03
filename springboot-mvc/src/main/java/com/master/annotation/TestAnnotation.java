package com.master.annotation;

import java.lang.annotation.*;

/**
 * @author ColorXJH
 * @version 1.0
 * @date 2020/8/12 19:12
 */
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface TestAnnotation {
    String name() default "DearBear";
}
