package com.lexach.netcracker.frameworks.spring.ripper.quoters;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Random;

public class InjectRandomIntAnnotationBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Field[] declaredFields = bean.getClass().getDeclaredFields();

        for (Field field : declaredFields) {
            //Берем из филда аннотацию InjectRandomInt
            InjectRandomInt annotation = field.getAnnotation(InjectRandomInt.class);

            // Если она существует, то делаем наши дела с филдом
            if(annotation != null) {
                // Вытягиваем из аннотации границы диапозона рандомного числа
                int min = annotation.min();
                int max = annotation.max();

                Random random = new Random();

                int i = min + random.nextInt(max - min);

                //По-умолчанию поле приватное, меняем параметры доступа.
                field.setAccessible(true);
                // Запихиваем наше значение в нужный бин.
                ReflectionUtils.setField(field, bean, i);
            }
        }

        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
