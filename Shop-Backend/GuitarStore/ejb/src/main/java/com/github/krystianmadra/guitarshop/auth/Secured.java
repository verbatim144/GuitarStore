package com.github.krystianmadra.guitarshop.auth;

import com.github.krystianmadra.guitarshop.entities.Role;

import javax.ws.rs.NameBinding;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@NameBinding
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.METHOD})
public @interface Secured {
    Role[] value() default {};
}
