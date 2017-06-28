package com.hrskrs.gettyimagemvp.network;

import android.content.Context;

import com.hrskrs.gettyimagemvp.BuildConfig;
import com.hrskrs.gettyimagemvp.AppScope;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.io.File;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by hrskrs on 4/10/2017.
 */

@Module
public class NetworkModule {

  @AppScope
  @Provides
  GsonConverterFactory provideGsonConverterFactory() {
    return GsonConverterFactory.create();
  }

  @AppScope
  @Provides
  RxJava2CallAdapterFactory provideRxJava2CallAdapterFactory() {
    return RxJava2CallAdapterFactory.create();
  }

  @AppScope
  @Provides
  HttpLoggingInterceptor provideHttpLoggingInterceptor() {
    HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
    httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
    return httpLoggingInterceptor;
  }

  @AppScope
  @Provides
  Interceptor provideHeaderInterceptor() {
    return chain -> {
      Request original = chain.request();
      Request request = original.newBuilder()
          .addHeader("Api-Key", BuildConfig.API_KEY)
          .build();
      return chain.proceed(request);
    };
  }

  @AppScope
  @Provides
  Cache provideCache(File file) {
    int cacheSize = 10 * 1024 * 1024;
    return new Cache(file, cacheSize);
  }

  @AppScope
  @Provides
  File provideCacheFile(Context context) {
    return context.getCacheDir();
  }

  @AppScope
  @Provides
  OkHttpClient provideOkHttpClient(HttpLoggingInterceptor loggingInterceptor, Interceptor headerInterceptor, Cache cache) {
    return new OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .addInterceptor(headerInterceptor)
        .cache(cache)
        .build();
  }

}
