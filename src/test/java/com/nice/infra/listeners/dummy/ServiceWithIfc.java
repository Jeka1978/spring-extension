package com.nice.infra.listeners.dummy;

import com.nice.infra.annotations.Main;

/**
 * Created by Evegeny on 04/11/2016.
 */
public class ServiceWithIfc implements Ifc {
    @Override
    @Main
    public void doWork() {
        ValueHolder.getInstance().setOneMoreValue(12);
    }
}
