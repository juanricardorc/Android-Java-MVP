package com.juanricardorc.mvp.base;

public abstract class BasePresenter<V extends BaseView> {
    protected V view;

    protected BasePresenter(V view) {
        this.view = view;
    }

    void onDetach() {
        view = null;
    }
}
