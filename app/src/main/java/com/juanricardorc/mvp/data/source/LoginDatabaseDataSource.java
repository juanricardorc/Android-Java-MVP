package com.juanricardorc.mvp.data.source;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.juanricardorc.mvp.domain.entity.UserEntity;
import com.juanricardorc.mvp.domain.model.UserModel;
import com.juanricardorc.mvp.domain.response.UserResponse;

import java.util.LinkedList;
import java.util.List;

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

    @Override
    public List<UserModel> getUsers() {
        List<UserModel> userModels = new LinkedList<>();

        UserModel userModel1 = new UserModel();
        userModel1.setId("100001");
        userModel1.setName("Pepe");

        UserModel userModel2 = new UserModel();
        userModel2.setId("100002");
        userModel2.setName("Carlos");

        UserModel userModel3 = new UserModel();
        userModel3.setId("100003");
        userModel3.setName("Ana");


        userModels.add(userModel1);
        userModels.add(userModel2);
        userModels.add(userModel3);
        return userModels;
    }

    @Override
    public boolean isOnline(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isAvailable() && networkInfo.isConnectedOrConnecting();
    }
}
