package com.nice.infra.annotations;/**
 * Created by Evegeny on 04/11/2016.
 */

import com.nice.infra.conf.InfraConfig;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Target(ElementType.TYPE)
@Import(InfraConfig.class)
public @interface EnableMain {
}
