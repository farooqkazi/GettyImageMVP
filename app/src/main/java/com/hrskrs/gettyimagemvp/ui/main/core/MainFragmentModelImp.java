package com.hrskrs.gettyimagemvp.ui.main.core;

import com.hrskrs.gettyimagemvp.network.api.GettyImagesService;
import com.hrskrs.gettyimagemvp.network.responses.GetImagesResponse;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by hrskrs on 4/14/2017.
 */

public class MainFragmentModelImp implements MainFragmentModel {

  GettyImagesService service;

  @Inject
  public MainFragmentModelImp(GettyImagesService service){
    this.service = service;
  }

  @Override
  public Observable<GetImagesResponse> getImages(final int pageNo, final int pageCount, final String phrase) {
    return service.getImages(pageNo, pageCount, phrase);
  }
}
