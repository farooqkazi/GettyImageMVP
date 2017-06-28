package com.hrskrs.gettyimagemvp.utils;

import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.hrskrs.gettyimagemvp.R;

/**
 * Created by hrskrs on 7/14/2016.
 */
public class FragmentTransactionUtil {

  private FragmentTransactionUtil() {
    throw new AssertionError();
  }

  public static void addFragment(FragmentManager fragmentManager,
                                 @NonNull Fragment fragment,
                                 @IdRes int fragmentContainerId,
                                 boolean addToBackStack) {
    FragmentTransaction transaction = fragmentManager.beginTransaction();
    transaction.setCustomAnimations(
        R.anim.slide_in_left, R.anim.slide_out_right,
        R.anim.slide_in_right, R.anim.slide_out_left);
    transaction.add(fragmentContainerId, fragment);
    if (addToBackStack) {
      transaction.addToBackStack(fragment.getClass().getSimpleName());
    }
    transaction.commit();
  }

  public static void replaceFragment(FragmentManager fragmentManager,
                                     @NonNull Fragment fragment,
                                     @IdRes int fragmentContainerId,
                                     boolean addToBackStack) {
    FragmentTransaction transaction = fragmentManager.beginTransaction();
    transaction.setCustomAnimations(
        R.anim.slide_in_left, R.anim.slide_out_right,
        R.anim.slide_in_right, R.anim.slide_out_left);
    transaction.replace(fragmentContainerId, fragment);
    if (addToBackStack) {
      transaction.addToBackStack(fragment.getClass().getSimpleName());
    }
    transaction.commit();
  }
}
