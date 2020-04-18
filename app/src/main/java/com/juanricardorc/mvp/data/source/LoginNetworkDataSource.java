package com.juanricardorc.mvp.data.source;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.juanricardorc.mvp.domain.entity.UserEntity;
import com.juanricardorc.mvp.domain.model.UserModel;
import com.juanricardorc.mvp.domain.response.UserResponse;

import java.util.List;

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

    @Override
    public List<UserModel> getUsers() {
        return null;
    }

    @Override
    public boolean isOnline(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isAvailable() && networkInfo.isConnectedOrConnecting();
    }
}
