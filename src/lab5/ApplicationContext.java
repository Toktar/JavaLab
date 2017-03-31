package lab5;

import lab5.Annotation.Autowired;

import java.lang.reflect.Field;


public class ApplicationContext {

    private static ApplicationContext instance;

    public static ApplicationContext getInstance() {
        return instance;
    }

    static {
        instance = new ApplicationContext();
    }

    public Object getBean(String beanName) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        return BeanFactory.createBean(beanName);
    }
}
