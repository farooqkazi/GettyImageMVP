package com.hrskrs.gettyimagemvp.ui.main.core;

import com.hrskrs.gettyimagemvp.core.BaseView;
import com.hrskrs.gettyimagemvp.models.GettyImage;

import java.util.ArrayList;

/**
 * Created by hrskrs on 4/14/2017.
 */

public interface MainFragmentView extends BaseView{

  int getPageNo();

  int getPageCount();

  String getPhrase();

  void onImagesLoad(ArrayList<GettyImage> gettyImages);

  void onNextPage(ArrayList<GettyImage> gettyImages);
}
