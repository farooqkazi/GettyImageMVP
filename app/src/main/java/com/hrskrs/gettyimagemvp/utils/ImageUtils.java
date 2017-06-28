package com.hrskrs.gettyimagemvp.utils;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.hrskrs.gettyimagemvp.R;

/**
 * Created by hrskrs on 4/11/2017.
 */

public class ImageUtils {

  private ImageUtils() {
    throw new AssertionError();
  }

  public static void loadImage(ImageView imageView, String url) {
    Glide.with(imageView.getContext())
        .load(url)
        .placeholder(R.drawable.ic_unhappy)
        .into(imageView);
  }
}
