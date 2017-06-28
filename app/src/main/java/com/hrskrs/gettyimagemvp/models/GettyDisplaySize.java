package com.hrskrs.gettyimagemvp.models;

import android.support.annotation.VisibleForTesting;

import com.google.gson.annotations.SerializedName;

/**
 * Created by hrskrs on 4/11/2017.
 */

public class GettyDisplaySize {

  @SerializedName("uri")
  String uri;

  @VisibleForTesting
  public static GettyDisplaySize create(String uri) {
    GettyDisplaySize instance = new GettyDisplaySize();
    instance.uri = uri;
    return instance;
  }

  public String getUri() {
    return uri;
  }
}
