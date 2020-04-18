package com.juanricardorc.mvp.presentation.login;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.juanricardorc.mvp.R;
import com.juanricardorc.mvp.presentation.base.BaseActivity;
import com.juanricardorc.mvp.domain.model.UserModel;
import com.juanricardorc.mvp.data.repository.LoginDataRepository;
import com.juanricardorc.mvp.data.repository.LoginRepository;
import com.juanricardorc.mvp.data.source.LoginDatabaseDataSource;
import com.juanricardorc.mvp.data.source.LoginNetworkDataSource;
import com.juanricardorc.mvp.presentation.home.HomeActivity;

import java.util.List;

public class LoginActivity extends BaseActivity<LoginPresenter> implements LoginView {

    private EditText userNameEditText;
    private EditText passwordEditText;
    private Button loginButton;

    @Override
    protected int getLayout() {
        return R.layout.activity_login;
    }

    @Override
    protected void finds() {
        userNameEditText = findViewById(R.id.userNameEditText);
        userNameEditText.setText("John");
        passwordEditText = findViewById(R.id.passwordEditText);
        passwordEditText.setText("123456");
        loginButton = findViewById(R.id.loginButton);
    }

    @Override
    protected void events() {
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateLogin();
            }
        });
    }

    @NonNull
    @Override
    protected LoginPresenter createPresenter() {
        LoginDatabaseDataSource loginDatabaseDataSource = new LoginDatabaseDataSource();
        LoginNetworkDataSource loginNetworkDataSource = new LoginNetworkDataSource();

        LoginRepository loginRepository = new LoginDataRepository(loginDatabaseDataSource,
                loginNetworkDataSource,
                getBaseContext());

        return new LoginPresenter(this, loginRepository);
    }

    private void validateLogin() {
        presenter.validateCredentials(userNameEditText.getText().toString(),
                passwordEditText.getText().toString());
    }

    @Override
    public void showError(String message) {
        Toast.makeText(getBaseContext(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showSuccess(String message) {
        Toast.makeText(getBaseContext(), message, Toast.LENGTH_SHORT).show();
        presenter.getUser("78264321");

    }

    @Override
    public void showUser(@NonNull UserModel user) {
        if (user.getName() != null && user.getJob() != null) {
            Toast.makeText(getBaseContext(), user.getSource()+" | "+user.getName() + " | " + user.getJob(), Toast.LENGTH_SHORT).show();
            goHome();
        }

    }

    @Override
    public void goHome() {
        Intent intent = new Intent(getBaseContext(), HomeActivity.class);
        startActivity(intent);
    }

    @Override
    public void showUsers(List<UserModel> users) {

    }
}
