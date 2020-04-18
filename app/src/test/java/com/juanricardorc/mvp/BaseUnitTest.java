package com.juanricardorc.mvp;


import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

public abstract class BaseUnitTest {
    @Before
    public final void setUp() {
        initializeMocks();
        onSetUp();
    }

    private void initializeMocks() {
        MockitoAnnotations.initMocks(this);
    }

    protected abstract void onSetUp();
}
