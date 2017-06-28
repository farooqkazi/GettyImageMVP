package com.hrskrs.gettyimagemvp;

import android.app.Application;
import android.support.annotation.VisibleForTesting;

import com.hrskrs.gettyimagemvp.network.NetworkModule;
import com.hrskrs.gettyimagemvp.network.api.GettyImagesServiceModule;
import com.squareup.leakcanary.LeakCanary;

/**
 * Created by hrskrs on 4/10/2017.
 */

public class App extends Application {

  private static AppComponent appComponent;
  private static App instance;

  @Override
  public void onCreate() {
    super.onCreate();
    LeakCanary.install(this);
    initAppComponent();
  }

  private void initAppComponent() {
    appComponent = DaggerAppComponent.builder()
        .appModule(new AppModule(this))
        .networkModule(new NetworkModule())
        .gettyImagesServiceModule(new GettyImagesServiceModule(BuildConfig.ENDPOINT_URL))
        .build();
  }

  public static AppComponent getAppComponent() {
    return appComponent;
  }

  @VisibleForTesting
  public static void setAppComponent(AppComponent appComponent) {
    App.appComponent = appComponent;
  }
}
