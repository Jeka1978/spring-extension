package com.nice.infra.listeners.dummy;

import com.nice.infra.annotations.Main;
import org.springframework.stereotype.Service;

/**
 * Created by Evegeny on 04/11/2016.
 */
@Service
public class DummyService {

    @Main
    public void doWork(){
        ValueHolder.getInstance().setValue(12);
    }

}
