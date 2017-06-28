package com.hrskrs.gettyimagemvp.utils;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.Toast;

/**
 * Created by hrskrs on 4/11/2017.
 */

public class DisplayUtils {

  private DisplayUtils(){
    throw new AssertionError();
  }

  public static void showSnackbar(View view, String message, int length) {
    Snackbar.make(view, message, length).show();
  }

  public static void showToast(Context context, String message, int length) {
    Toast.makeText(context, message, length).show();
  }
}
