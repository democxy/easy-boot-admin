package com.democxy.common.annotation;

import java.lang.annotation.*;

/**
 * @author shiling_deng
 */
@Target({ ElementType.PARAMETER, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Permission {

    String value() default  "";

    String func() default "";

}
