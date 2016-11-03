package com.nice.infra.listeners.dummy;

import com.nice.infra.annotations.EnableMain;
import com.nice.infra.annotations.Main;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Evegeny on 04/11/2016.
 */
@Configuration
@EnableMain
@ComponentScan(basePackages = "com.nice.infra.listeners.dummy")
public class DummyConf {

    @Bean
    public ServiceWithoutIfc serviceWithoutIfc(){
        return new ServiceWithoutIfc();
    }

    @Bean
    public Ifc ifc(){
        return new Ifc() {
            @Override
            @Main
            public void doWork() {
                ValueHolder.getInstance().setOneMoreValue(12);
            }
        };
    }
}
