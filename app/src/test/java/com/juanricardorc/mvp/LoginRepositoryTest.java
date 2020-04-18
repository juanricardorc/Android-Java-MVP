package com.juanricardorc.mvp;

import android.content.Context;

import com.juanricardorc.mvp.data.repository.LoginDataRepository;
import com.juanricardorc.mvp.data.repository.LoginRepository;
import com.juanricardorc.mvp.data.source.LoginDatabaseDataSource;
import com.juanricardorc.mvp.data.source.LoginNetworkDataSource;
import com.juanricardorc.mvp.presentation.login.LoginPresenter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LoginRepositoryTest {

    @Mock
    private Context context;

    @Mock
    private LoginDatabaseDataSource loginDatabaseDataSource;

    @Mock
    private LoginNetworkDataSource loginNetworkDataSource;

    private LoginRepository loginRepository;

    @Mock
    private LoginPresenter loginPresenter;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        loginRepository = new LoginDataRepository(loginDatabaseDataSource,
                loginNetworkDataSource, context);
    }

    @Test
    public void shouldValidateUserNameAndPasswordInDatabaseTest() throws Exception {
        String userName = "John";
        String password = "123456";

        when(loginNetworkDataSource.isOnline(context)).thenReturn(false);
        loginRepository.validateUserNameAndPassword(userName, password);
        verify(loginDatabaseDataSource).validateUserNameAndPassword(userName, password);
    }

    @Test
    public void shouldValidateUserNameAndPasswordInNetworkTest() throws Exception {
        String userName = "John";
        String password = "123456";

        when(loginNetworkDataSource.isOnline(context)).thenReturn(true);
        loginRepository.validateUserNameAndPassword(userName, password);
        verify(loginNetworkDataSource).validateUserNameAndPassword(userName, password);
    }
}
