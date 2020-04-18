package com.juanricardorc.mvp.data.source;

import android.content.Context;

import com.juanricardorc.mvp.domain.entity.UserEntity;
import com.juanricardorc.mvp.domain.model.UserModel;
import com.juanricardorc.mvp.domain.response.UserResponse;

import java.util.List;

public interface LoginDataSource {
    boolean validateUserNameAndPassword(String userName, String password);

    UserEntity getUserEntity(String id);

    UserResponse getUserResponse(String id);

    List<UserModel> getUsers();

    boolean isOnline(Context context);
}
