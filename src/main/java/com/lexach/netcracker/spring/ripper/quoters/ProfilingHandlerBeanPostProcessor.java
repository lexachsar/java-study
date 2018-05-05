package com.lexach.netcracker.spring.ripper.quoters;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;
import java.lang.management.PlatformLoggingMXBean;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

public class ProfilingHandlerBeanPostProcessor implements BeanPostProcessor {

    // Мапа со всеми классами вместе с их именем.
    private Map<String, Class> map = new HashMap<>();

    // Контроллер с флажком для управления профилированием через JMX Consoleю
    private ProfilingController controller = new ProfilingController();

    public ProfilingHandlerBeanPostProcessor() throws Exception {
        // Получаем обхъект MBean Server, и теперьможем регестрировать в нем бины.
        MBeanServer platformMBeanServer = ManagementFactory.getPlatformMBeanServer();

        // Регаем mbean
        platformMBeanServer.registerMBean(controller, new ObjectName("profiling", "name", "controller"));
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        Class<?> beanClass = bean.getClass();

        // Проходимся по бинам, ищем бин с нашей аннотацией, добавляем его в мапу.
        if (beanClass.isAnnotationPresent(Profiling.class)) {
            map.put(beanName, beanClass);
        }

        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        Class beanClass = map.get(beanName);

        if (beanClass != null) {
            return Proxy.newProxyInstance(beanClass.getClassLoader(), beanClass.getInterfaces(), new InvocationHandler() {
                @Override
                public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
                    if ( controller.isEnabled() ) {
                        System.out.println("Профилирую...");

                        long before = System.nanoTime();

                        Object retVal = method.invoke(bean);

                        long after = System.nanoTime();

                        System.out.println(after - before);
                        System.out.println("Всё");

                        return retVal;
                    } else {
                        return method.invoke(bean);
                    }
                }
            });
        }

        return bean;
    }
}
