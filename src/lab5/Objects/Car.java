package lab5.Objects;

import lab5.Annotation.Autowired;

/**
 * Created by Alenor on 10.03.2017.
 */
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
