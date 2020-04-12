package com.juanricardorc.mvp.data.source;

import com.juanricardorc.mvp.domain.entity.UserEntity;
import com.juanricardorc.mvp.domain.response.UserResponse;

public interface LoginDataSource {
    boolean validateUserNameAndPassword(String userName, String password);

    UserEntity getUserEntity(String id);

    UserResponse getUserResponse(String id);
}
