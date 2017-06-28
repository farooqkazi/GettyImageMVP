package com.hrskrs.gettyimagemvp.network;

import com.hrskrs.gettyimagemvp.core.BaseView;
import com.hrskrs.gettyimagemvp.network.responses.BaseResponse;
import com.jakewharton.retrofit2.adapter.rxjava2.HttpException;

import org.json.JSONObject;

import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.SocketTimeoutException;

import io.reactivex.observers.DisposableObserver;
import okhttp3.ResponseBody;

/**
 * Created by hrskrs on 4/10/2017.
 */

public abstract class CallbackWrapper <T extends BaseResponse> extends DisposableObserver<T>{

  private WeakReference<BaseView> weakReference;

  public CallbackWrapper(BaseView view) {
    this.weakReference = new WeakReference<>(view);
  }

  protected abstract void onSuccess(T t);

  @Override
  public void onNext(T t) {
    //TODO: add StatusCode on BaseResponse and handle it
    onSuccess(t);
  }

  @Override
  public void onError(Throwable e) {
    BaseView view = weakReference.get();
    if (e instanceof HttpException) {
      ResponseBody responseBody = ((HttpException) e).response().errorBody();
      view.onUnknownError(getErrorMessage(responseBody));
    } else if (e instanceof SocketTimeoutException) {
      view.onTimeout();
    } else if (e instanceof IOException) {
      view.onNetworkError();
    } else {
      view.onUnknownError(e.getMessage());
    }
  }

  @Override
  public void onComplete() {

  }

  private String getErrorMessage(ResponseBody responseBody) {
    try {
      JSONObject jsonObject = new JSONObject(responseBody.string());
      return jsonObject.getString("message");
    } catch (Exception e) {
      return e.getMessage();
    }
  }
}
