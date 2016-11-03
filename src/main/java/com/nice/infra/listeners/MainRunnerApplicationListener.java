package com.nice.infra.listeners;

import com.nice.infra.annotations.Main;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Role;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * Created by Evegeny on 04/11/2016.
 */
@Component
@Role(BeanDefinition.ROLE_INFRASTRUCTURE)
public class MainRunnerApplicationListener implements ApplicationListener<ContextRefreshedEvent> {
    @Autowired
    private ConfigurableListableBeanFactory factory;


    @Override
    @SneakyThrows
    public void onApplicationEvent(ContextRefreshedEvent event) {
        ApplicationContext context = event.getApplicationContext();
        String[] names = context.getBeanDefinitionNames();
        for (String beanName : names) {
            BeanDefinition beanDefinition = factory.getBeanDefinition(beanName);
            String beanClassName = beanDefinition.getBeanClassName();
            if (beanClassName == null) {
                continue;
            }
            Class<?> beanClass = Class.forName(beanClassName);
            Method[] methods = beanClass.getDeclaredMethods();
            for (Method method : methods) {
                if (method.isAnnotationPresent(Main.class)) {
                    Object bean = context.getBean(beanName);
                    Method currentMethod = bean.getClass().getMethod(method.getName());
                    currentMethod.setAccessible(true);
                    currentMethod.invoke(bean);
                }
            }
        }
    }
}
