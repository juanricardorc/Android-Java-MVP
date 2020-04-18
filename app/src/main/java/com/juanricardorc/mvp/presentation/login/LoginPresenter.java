package com.juanricardorc.mvp.presentation.login;

import com.juanricardorc.mvp.presentation.base.BasePresenter;
import com.juanricardorc.mvp.domain.model.UserModel;
import com.juanricardorc.mvp.data.repository.LoginRepository;

import java.util.List;


/*
 *
 * Hola Dev, si estas leyendo esto, es porque quieres entender el patrón de diseño
 * MVP (Modelo, Vista, Presentador).
 *
 * Te recomiendo que leas sobre clases abstractas e interfaces. Si ya tienes conceptos de
 * esos temas, puedes omitir esto y revisar las clases que he implementado.
 *
 * Si tienes alguna duda escribeme a mi email: ricardo.ramos@unas.edu.pe
 *
 * */


public class LoginPresenter extends BasePresenter<LoginView> {
    private LoginRepository loginRepository;

    public LoginPresenter(LoginView view, LoginRepository loginRepository) {
        super(view);
        this.loginRepository = loginRepository;
    }

    public LoginPresenter(LoginView view) {
        super(view);
    }

    public void validateCredentials(String userName, String password) {
        boolean state = this.loginRepository.validateUserNameAndPassword(userName, password);
        if (state) view.showSuccess("Usuario correcto");
        else view.showError("Usuario incorrecto");
    }

    public void getUser(String id) {
        UserModel user = this.loginRepository.getUser(id);
        view.showUser(user);
    }

    public void getUsers() {
        List<UserModel> users = this.loginRepository.getUsers();
        view.showUsers(users);
    }

}
