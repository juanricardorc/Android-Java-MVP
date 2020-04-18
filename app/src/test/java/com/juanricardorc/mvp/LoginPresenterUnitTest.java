package com.juanricardorc.mvp;

import com.juanricardorc.mvp.data.repository.LoginRepository;
import com.juanricardorc.mvp.presentation.login.LoginPresenter;
import com.juanricardorc.mvp.presentation.login.LoginView;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


public class LoginPresenterUnitTest extends BaseUnitTest {

    private LoginPresenter loginPresenter;

    @Mock
    private LoginView loginView;

    @Mock
    private LoginRepository loginRepository;

    @Override
    protected void onSetUp() {
        loginPresenter = new LoginPresenter(loginView, loginRepository);
    }

    @Test
    public void shouldShowSuccessTest() {
        String userName = "John";
        String password = "123456";

        when(loginRepository.validateUserNameAndPassword(userName, password)).thenReturn(true);

        loginPresenter.validateCredentials(userName, password);

        verify(loginView).showSuccess(Mockito.anyString());
    }

    @Test
    public void shouldShowErrorTest() {
        String userName = "Johnn";
        String password = "1234566";

        when(loginRepository.validateUserNameAndPassword(userName, password)).thenReturn(false);

        loginPresenter.validateCredentials(userName, password);

        verify(loginView).showError(Mockito.anyString());
    }
}
