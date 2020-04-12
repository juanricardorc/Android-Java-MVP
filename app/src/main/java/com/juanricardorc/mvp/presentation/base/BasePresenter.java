package com.juanricardorc.mvp.presentation.base;

public abstract class BasePresenter<V extends BaseView> {
    protected V view;

    protected BasePresenter(V view) {
        this.view = view;
    }

    void onDetach() {
        view = null;
    }
}
