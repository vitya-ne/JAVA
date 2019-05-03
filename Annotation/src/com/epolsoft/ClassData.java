package com.epolsoft;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Documented
@Inherited
@Retention( value= RetentionPolicy.RUNTIME )
@interface ClassData {
    String author();
    String company() default "epolsoft.com";
    String lastModified();
    int currentRevision() default 1;
}
