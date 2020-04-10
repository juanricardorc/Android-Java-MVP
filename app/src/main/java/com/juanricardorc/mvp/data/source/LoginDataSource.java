package com.juanricardorc.mvp.data.source;

import com.juanricardorc.mvp.data.model.UserModel;

public interface LoginDataSource {
    boolean validateUserNameAndPassword(String userName, String password);

    UserModel getUser(String id);
}
