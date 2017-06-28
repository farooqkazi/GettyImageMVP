package com.hrskrs.gettyimagemvp;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Created by hrskrs on 4/10/2017.
 */

@Module
public class AppModule {

  App app;

  public AppModule(App app) {
    this.app = app;
  }

  @AppScope
  @Provides
  Context provideApp(){
    return app;
  }

}
