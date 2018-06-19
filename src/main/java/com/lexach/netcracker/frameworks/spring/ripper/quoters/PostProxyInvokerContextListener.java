package com.lexach.netcracker.frameworks.spring.ripper.quoters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.support.AbstractApplicationContext;

import java.lang.reflect.Method;

public class PostProxyInvokerContextListener implements ApplicationListener<ContextRefreshedEvent> {

    // На 3 этапе трехфазового конструктора мы не можем обращаться к бинам по имени, т.к.
    // на их месте может оказаться прокси. Поэтому мы используем ConfigurableListableBeanFactory.
    @Autowired
    private ConfigurableListableBeanFactory factory;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        ApplicationContext context = contextRefreshedEvent.getApplicationContext();

        String[] names = context.getBeanDefinitionNames();

        for (String name : names) {
            BeanDefinition beanDefinition = factory.getBeanDefinition(name);

            String originalClassName = beanDefinition.getBeanClassName();

            try {
                Class<?> originalClass = Class.forName(originalClassName);

                Method[] methods = originalClass.getMethods();
                for (Method method : methods) {
                    if(method.isAnnotationPresent(PostProxy.class)) {
                        // Мы должны запустить метод не оригинального класса, а класса
                        // с прокси, поэтому мы ищем этот класс среди наших бинов.
                        Object bean = context.getBean(name);
                        Method currentMethod = bean.getClass().getMethod(method.getName(), method.getParameterTypes());

                        currentMethod.invoke(bean);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
