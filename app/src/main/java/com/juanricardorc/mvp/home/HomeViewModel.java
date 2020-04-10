package com.juanricardorc.mvp.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("LoginActivity usa el patron de diseño MVP, Los fragmentos (DashboardFragment, HomeFragment y NotificationsFragment) usa MVVM");
    }

    public LiveData<String> getText() {
        return mText;
    }
}