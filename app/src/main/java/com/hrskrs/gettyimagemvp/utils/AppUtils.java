package com.hrskrs.gettyimagemvp.utils;

import java.util.List;

/**
 * Created by hrskrs on 4/10/2017.
 */

public class AppUtils {

  private AppUtils(){
    throw new AssertionError();
  }

  public static <T> T checkNotNull(T obj) {
    if (obj == null) {
      throw new NullPointerException();
    }
    return obj;
  }

  public static <T> boolean isListEmpty(List<T> list) {
    return list == null || list.size() <= 0;
  }
}
