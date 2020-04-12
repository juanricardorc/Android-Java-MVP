package com.juanricardorc.mvp.presentation.login;

import androidx.annotation.NonNull;

import com.juanricardorc.mvp.presentation.base.BaseView;
import com.juanricardorc.mvp.domain.model.UserModel;

public interface LoginView extends BaseView {
    void showError(String message);

    void showSuccess(String message);

    void showUser(@NonNull UserModel user);

    void goHome();
}
