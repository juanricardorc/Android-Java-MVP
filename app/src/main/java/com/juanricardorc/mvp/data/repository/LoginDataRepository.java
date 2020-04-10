package com.juanricardorc.mvp.data.repository;

import android.content.Context;

import com.juanricardorc.mvp.data.model.UserModel;
import com.juanricardorc.mvp.data.source.LoginDatabaseDataSource;
import com.juanricardorc.mvp.data.source.LoginNetworkDataSource;
import com.juanricardorc.mvp.data.utils.DataUtils;

public class LoginDataRepository implements LoginRepository {
    private LoginDatabaseDataSource loginDatabaseDatasource;
    private LoginNetworkDataSource loginNetworkDataSource;
    private Context context;

    public LoginDataRepository(LoginDatabaseDataSource loginDatabaseDatasource,
                               LoginNetworkDataSource loginNetworkDataSource,
                               Context context) {
        this.loginDatabaseDatasource = loginDatabaseDatasource;
        this.loginNetworkDataSource = loginNetworkDataSource;
        this.context = context;
    }

    @Override
    public boolean validateUserNameAndPassword(String userName, String password) {
        if (DataUtils.isOnline(context)) {
            return this.loginNetworkDataSource.validateUserNameAndPassword(userName, password);
        } else {
            return this.loginDatabaseDatasource.validateUserNameAndPassword(userName, password);
        }
    }

    @Override
    public UserModel getUser(String id) {
        if (DataUtils.isOnline(context)) {
            return this.loginNetworkDataSource.getUser(id);
        } else {
            return this.loginDatabaseDatasource.getUser(id);
        }
    }
}
