package com.hrskrs.gettyimagemvp.models;

import android.support.annotation.VisibleForTesting;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by hrskrs on 4/10/2017.
 */

public class GettyImage {

  @SerializedName("id")
  String id;
  @SerializedName("title")
  String title;
  @SerializedName("caption")
  String caption;
  @SerializedName("display_sizes")
  ArrayList<GettyDisplaySize> displaySizes;

  @VisibleForTesting
  public static GettyImage create(String id, String title, String caption, ArrayList<GettyDisplaySize> displaySizes) {
    GettyImage gettyImage = new GettyImage();
    gettyImage.id = id;
    gettyImage.title = title;
    gettyImage.caption = caption;
    gettyImage.displaySizes = displaySizes;
    return gettyImage;
  }

  public String getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public String getCaption() {
    return caption;
  }

  public ArrayList<GettyDisplaySize> getDisplaySizes() {
    return displaySizes;
  }
}
