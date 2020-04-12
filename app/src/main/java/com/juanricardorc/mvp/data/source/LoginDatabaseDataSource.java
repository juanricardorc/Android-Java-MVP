package com.juanricardorc.mvp.data.source;

import com.juanricardorc.mvp.domain.entity.UserEntity;
import com.juanricardorc.mvp.domain.response.UserResponse;

public class LoginDatabaseDataSource implements LoginDataSource {

    public LoginDatabaseDataSource() {

    }

    @Override
    public boolean validateUserNameAndPassword(String userName, String password) {
        return userName.equalsIgnoreCase("John") &&
                password.equalsIgnoreCase("123456");
    }

    @Override
    public UserEntity getUserEntity(String id) {
        if (id.equalsIgnoreCase("78264321")) {
            UserEntity userEntity = new UserEntity();
            userEntity.setId("78264321");
            userEntity.setName("John");
            userEntity.setLastName("Richard");
            userEntity.setJob("Software Engineer");
            userEntity.setSource("Database");
            userEntity.setState(true);
            return userEntity;
        } else {
            return new UserEntity();
        }
    }

    @Override
    public UserResponse getUserResponse(String id) {
        return null;
    }
}
