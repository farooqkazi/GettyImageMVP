package com.hrskrs.gettyimagemvp.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import io.reactivex.Observable;

/**
 * Created by hrskrs on 4/10/2017.
 */

public class NetworkUtils {

  private NetworkUtils() {
    throw new AssertionError();
  }

  public static boolean isNetworkAvailable(Context context) {
    ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
    NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
    return activeNetworkInfo != null && activeNetworkInfo.isConnected();
  }

  public static Observable<Boolean> isNetworkAvailableObservable(Context context) {
    return Observable.just(isNetworkAvailable(context));
  }
}
