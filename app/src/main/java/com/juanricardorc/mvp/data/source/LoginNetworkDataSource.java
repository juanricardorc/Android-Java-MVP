package com.juanricardorc.mvp.data.source;

import com.juanricardorc.mvp.data.model.UserModel;

public class LoginNetworkDataSource implements LoginDataSource {

    public LoginNetworkDataSource() {

    }

    @Override
    public boolean validateUserNameAndPassword(String userName, String password) {
        return userName.equalsIgnoreCase("John") &&
                password.equalsIgnoreCase("123456");
    }

    @Override
    public UserModel getUser(String id) {
        if (id.equalsIgnoreCase("78264321")) {
            UserModel userModel = new UserModel();
            userModel.setId("78264321");
            userModel.setName("John Maxweell");
            userModel.setLastName("Richard Sim");
            userModel.setJob("Senior Software Engineer");
            userModel.setState(true);
            return userModel;
        } else {
            return new UserModel();
        }
    }
}
