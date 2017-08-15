package com.vabram.hearthum.helper;


import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * Helper class which is able to autowire a specified class. It holds a static reference to the {@link org
 * .springframework.context.ApplicationContext}.
 */
@Component
public final class AutowireHelper implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    private AutowireHelper() {
    }

    public static void autowire(Object classToAutowire) {
        AutowireHelper.applicationContext.getAutowireCapableBeanFactory().autowireBean(classToAutowire);
    }

    @Override
    public void setApplicationContext(final ApplicationContext applicationContext) {
        AutowireHelper.applicationContext = applicationContext;
    }

}
