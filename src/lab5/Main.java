package lab5;

import lab5.Objects.*;


public class Main {

    public static void main(String[] args) {
        ApplicationContext context = ApplicationContext.getInstance();
        try {
            Car car = (Car) context.getBean("Objects.Car");
            Engine engine = car.getEngine();
            engine.setModel("sas");

            Plain plain = (Plain) context.getBean("Objects.Plain");
            PlainEngine plainEngine = plain.getPlainEngine();
            plainEngine.setModel("asd");
            PlainEngineProperties prop = plainEngine.getPlainEngineProperties();
            prop.setFuelCapacity(123);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
