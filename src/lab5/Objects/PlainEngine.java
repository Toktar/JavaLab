package lab5.Objects;

import lab5.Annotation.Autowired;

/**
 * Created by Alenor on 14.03.2017.
 */
public class PlainEngine {

    private String model;

    @Autowired
    private PlainEngineProperties plainEngineProperties;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public PlainEngineProperties getPlainEngineProperties() {
        return plainEngineProperties;
    }

    public void setPlainEngineProperties(PlainEngineProperties plainEngineProperties) {
        this.plainEngineProperties = plainEngineProperties;
    }
}
