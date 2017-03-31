package lab5;

import lab5.Annotation.Autowired;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;


public final class BeanFactory {

    private static Map<String, Object> beanMap = new HashMap<>();

    public static Object createBean(String beanName)
            throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Object bean = beanMap.get(beanName);
        if (bean == null) {
            bean = getBean(beanName);
        }
        return bean;
    }

    private static Object getBean(String beanName) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class<?> clazz = Class.forName(beanName);
        Object classInstance = clazz.newInstance();
        inject(clazz, classInstance);
        beanMap.put(beanName, classInstance);
        return classInstance;
    }

    private static void inject(Class<?> clazz, Object classInstance) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(Autowired.class)) {
                field.setAccessible(true);

                String fieldClassName = field.getType().getName();
                Object bean = getBean(fieldClassName);
                field.set(classInstance, bean);
            }
        }
    }
}
