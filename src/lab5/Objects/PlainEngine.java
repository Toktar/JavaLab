package lab5.Objects;

import lab5.Annotation.Autowired;



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
