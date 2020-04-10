package com.juanricardorc.mvp.login;

import androidx.annotation.NonNull;

import com.juanricardorc.mvp.base.BaseView;
import com.juanricardorc.mvp.data.model.UserModel;

public interface LoginView extends BaseView {
    void showError(String message);

    void showSuccess(String message);

    void showUser(@NonNull UserModel user);

    void goHome();
}
