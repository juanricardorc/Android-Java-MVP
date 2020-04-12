package com.juanricardorc.mvp.data.repository;

import com.juanricardorc.mvp.domain.model.UserModel;

public interface LoginRepository {
    boolean validateUserNameAndPassword(String userName, String password);

    UserModel getUser(String id);
}
