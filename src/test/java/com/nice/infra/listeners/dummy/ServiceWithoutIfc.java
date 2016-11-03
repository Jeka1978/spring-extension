package com.nice.infra.listeners.dummy;

import com.nice.infra.annotations.Main;

/**
 * Created by Evegeny on 04/11/2016.
 */
public class ServiceWithoutIfc {
    @Main
    public void doWork(){
        ValueHolder.getInstance().setAnotherValue(12);
    }
}
