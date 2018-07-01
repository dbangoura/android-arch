package fr.soat.androidarchi;

import android.app.Application;

import fr.soat.androidarchi.di.components.AppComponent;
import fr.soat.androidarchi.di.components.DaggerAppComponent;
import fr.soat.androidarchi.di.modules.AppModule;


public class PeopleApplication extends Application{

    private AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule())
                .build();
        mAppComponent.inject(this);
    }

    public AppComponent getmAppComponent() {
        return mAppComponent;
    }
}
