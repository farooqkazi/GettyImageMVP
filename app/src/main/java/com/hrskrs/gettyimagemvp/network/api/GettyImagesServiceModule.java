package com.hrskrs.gettyimagemvp.network.api;

import com.hrskrs.gettyimagemvp.AppScope;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by hrskrs on 4/10/2017.
 */

@Module
public class GettyImagesServiceModule {

  private String baseUrl;

  public GettyImagesServiceModule(String baseUrl) {
    this.baseUrl = baseUrl;
  }

  @AppScope
  @Provides
  GettyImagesService provideGettyImagesService(GsonConverterFactory gsonConverterFactory, RxJava2CallAdapterFactory rxJava2CallAdapterFactory, OkHttpClient okHttpClient) {
    return new Retrofit.Builder()
        .addConverterFactory(gsonConverterFactory)
        .addCallAdapterFactory(rxJava2CallAdapterFactory)
        .baseUrl(baseUrl)
        .client(okHttpClient)
        .build()
        .create(GettyImagesService.class);
  }

}
