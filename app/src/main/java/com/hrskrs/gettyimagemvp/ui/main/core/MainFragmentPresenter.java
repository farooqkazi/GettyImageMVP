package com.hrskrs.gettyimagemvp.ui.main.core;

import com.hrskrs.gettyimagemvp.core.BasePresenter;

/**
 * Created by hrskrs on 4/14/2017.
 */

public interface MainFragmentPresenter extends BasePresenter{

  void requestImages(final boolean loadMore);
}
