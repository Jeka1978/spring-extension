package com.nice.infra.listeners;

import com.nice.infra.listeners.dummy.DummyConf;
import com.nice.infra.listeners.dummy.ValueHolder;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by Evegeny on 04/11/2016.
 */
public class MainAnnotationTest {

    @Test
    public void testThatMainAnnotationWorks() {
        new AnnotationConfigApplicationContext(DummyConf.class);
        Assert.assertEquals(12, ValueHolder.getInstance().getValue());
        Assert.assertEquals(12, ValueHolder.getInstance().getAnotherValue());
        Assert.assertEquals(12, ValueHolder.getInstance().getOneMoreValue());
    }

}