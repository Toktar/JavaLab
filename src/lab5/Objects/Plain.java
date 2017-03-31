package lab5.Objects;

import lab5.Annotation.Autowired;

/**
 * Created by Alenor on 14.03.2017.
 */
public class Plain {

    @Autowired
    private PlainEngine plainEngine;

    public PlainEngine getPlainEngine() {
        return plainEngine;
    }
}
