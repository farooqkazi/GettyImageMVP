package com.hrskrs.gettyimagemvp.network.responses;

import android.support.annotation.VisibleForTesting;

import com.google.gson.annotations.SerializedName;
import com.hrskrs.gettyimagemvp.models.GettyImage;

import java.util.ArrayList;

/**
 * Created by hrskrs on 4/10/2017.
 */

public class GetImagesResponse extends BaseResponse {

  @SerializedName("result_count")
  private int count;
  @SerializedName("images")
  ArrayList<GettyImage> images;

  @VisibleForTesting
  public static GetImagesResponse create(int count, ArrayList<GettyImage> images) {
    GetImagesResponse instance = new GetImagesResponse();
    instance.count = count;
    instance.images = images;
    return instance;
  }

  public int getCount() {
    return count;
  }

  public void setCount(int count) {
    this.count = count;
  }

  public ArrayList<GettyImage> getImages() {
    return images;
  }

  public void setImages(ArrayList<GettyImage> images) {
    this.images = images;
  }

}
