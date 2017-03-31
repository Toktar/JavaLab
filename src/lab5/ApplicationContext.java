package lab5;

import lab5.Annotation.Autowired;

import java.lang.reflect.Field;

/**
 * Created by Alenor on 14.03.2017.
 */
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
