package com.juanricardorc.mvp.data.repository;

import android.content.Context;

import com.juanricardorc.mvp.data.mapper.LoginTwoMapper;
import com.juanricardorc.mvp.domain.entity.UserEntity;
import com.juanricardorc.mvp.domain.model.UserModel;
import com.juanricardorc.mvp.data.source.LoginDatabaseDataSource;
import com.juanricardorc.mvp.data.source.LoginNetworkDataSource;
import com.juanricardorc.mvp.data.utils.DataUtils;
import com.juanricardorc.mvp.domain.response.UserResponse;

public class LoginDataRepository implements LoginRepository {
    private LoginDatabaseDataSource loginDatabaseDatasource;
    private LoginNetworkDataSource loginNetworkDataSource;
    private Context context;
    private LoginTwoMapper loginMapper;

    public LoginDataRepository(LoginDatabaseDataSource loginDatabaseDatasource,
                               LoginNetworkDataSource loginNetworkDataSource,
                               Context context) {
        this.loginDatabaseDatasource = loginDatabaseDatasource;
        this.loginNetworkDataSource = loginNetworkDataSource;
        this.context = context;
        this.loginMapper = new LoginTwoMapper();
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
            UserResponse userResponse = this.loginNetworkDataSource.getUserResponse(id);
            return this.loginMapper.transformResponse(userResponse);
        } else {
            UserEntity userEntity = this.loginDatabaseDatasource.getUserEntity(id);
            return this.loginMapper.transformEntity(userEntity);
        }
    }
}
