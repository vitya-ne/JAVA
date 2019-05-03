package com.epolsoft;

import java.lang.annotation.*;

@Target( value=ElementType.FIELD )
@Retention( value= RetentionPolicy.RUNTIME )
@Inherited
public @interface FieldName {
    String type() default "entity";
}


