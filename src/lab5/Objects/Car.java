package lab5.Objects;

import lab5.Annotation.Autowired;


public class Car {

    @Autowired
    private Engine engine;

    public String getEngineModel() {
        return engine.getModel();
    }

    public Engine getEngine() {
        return engine;
    }
}
