package com.hrskrs.gettyimagemvp.core;

/**
 * Created by hrskrs on 4/10/2017.
 */

public interface BaseView {
  void onUnknownError(String error);
  void onTimeout();
  void onNetworkError();
}
