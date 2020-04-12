package com.juanricardorc.mvp.data.source;

import com.juanricardorc.mvp.domain.entity.UserEntity;
import com.juanricardorc.mvp.domain.response.UserResponse;

public class LoginNetworkDataSource implements LoginDataSource {

    public LoginNetworkDataSource() {

    }

    @Override
    public boolean validateUserNameAndPassword(String userName, String password) {
        return userName.equalsIgnoreCase("John") &&
                password.equalsIgnoreCase("123456");
    }

    @Override
    public UserEntity getUserEntity(String id) {
        return null;
    }

    @Override
    public UserResponse getUserResponse(String id) {
        if (id.equalsIgnoreCase("78264321")) {
            UserResponse userResponse = new UserResponse();
            userResponse.setId("78264321");
            userResponse.setName("John Maxweell");
            userResponse.setLastName("Richard Sim");
            userResponse.setJob("Senior Software Engineer");
            userResponse.setSource("API Rest");
            userResponse.setState(true);
            return userResponse;
        } else {
            return new UserResponse();
        }
    }
}
