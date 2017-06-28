package com.hrskrs.gettyimagemvp.ui.main.core;

import com.hrskrs.gettyimagemvp.network.responses.GetImagesResponse;

import io.reactivex.Observable;

/**
 * Created by hrskrs on 4/14/2017.
 */

public interface MainFragmentModel {

  Observable<GetImagesResponse> getImages(final int pageNo, final int pageCount, final String phrase);
}
