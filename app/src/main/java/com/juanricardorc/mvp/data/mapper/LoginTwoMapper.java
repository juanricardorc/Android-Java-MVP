package com.juanricardorc.mvp.data.mapper;

import com.juanricardorc.mvp.domain.entity.UserEntity;
import com.juanricardorc.mvp.domain.model.UserModel;
import com.juanricardorc.mvp.domain.response.UserResponse;

import org.modelmapper.ModelMapper;

public class LoginTwoMapper implements TwoMapper<UserEntity, UserResponse, UserModel> {

    @Override
    public UserModel transformEntity(UserEntity userEntity) {

        //Puedes usar la clase TwoMapper.
        UserModel userModel = new UserModel();
        /*userModel.setId(userEntity.getId());
        userModel.setName(userEntity.getName());
        userModel.setLastName(userEntity.getLastName());
        userModel.setJob(userEntity.getJob());
        userModel.setState(true);*/


        // Tambien puedes usar la clase ModelMapper. es un JAR (modelmapper-2.3.0.jar)
        ModelMapper modelMapper = new ModelMapper();
        userModel = modelMapper.map(userEntity, UserModel.class);

        return userModel;
    }

    @Override
    public UserModel transformResponse(UserResponse userResponse) {

        UserModel userModel = new UserModel();
        ModelMapper modelMapper = new ModelMapper();
        userModel = modelMapper.map(userResponse, UserModel.class);

        return userModel;
    }
}
