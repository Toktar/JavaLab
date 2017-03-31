package lab5.Objects;

import lab5.Annotation.Autowired;


public class Plain {

    @Autowired
    private PlainEngine plainEngine;

    public PlainEngine getPlainEngine() {
        return plainEngine;
    }
}
