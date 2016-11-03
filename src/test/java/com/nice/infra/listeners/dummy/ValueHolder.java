package com.nice.infra.listeners.dummy;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by Evegeny on 04/11/2016.
 */
@Setter
@Getter
public class ValueHolder {
    private static ValueHolder ourInstance = new ValueHolder();

    public static ValueHolder getInstance() {
        return ourInstance;
    }

    private ValueHolder() {
    }

    private int value;
    private int anotherValue;
    private int oneMoreValue;
}
